import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

public class SSHKeystest {
	RequestSpecification requestSpec;

	String sshKey="ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIL4QurQyZhp0cO2rQh0DoBuSi4Q6gMSVcAoOu15IaOT1 azuread\\rokkamdeepika@IBM-PF3XPMX1";

	int keyId;
	
	@BeforeClass
    public void setUp() {

        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://api.github.com")
                .setContentType(ContentType.JSON)
                .addHeader("Authorization", " Bearer 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")
                .build();
    }
	//post method
	
	@Test(priority = 1)
    public void addSSHKey() {

        String requestBody = "{\n" +
                "\"title\":\"TestAPIKey\",\n" +
                "\"key\":\"" + sshKey + "\"\n" +
                "}";

        Response response = given()
                .spec(requestSpec)
                .body(requestBody)
                .when()
                .post("/user/keys");

        response.prettyPrint();

        // Extract generated key id
        keyId = response.jsonPath().getInt("id");

        Reporter.log("Generated Key ID: " + keyId);

        Assert.assertEquals(response.getStatusCode(), 201);

        keyId = response.jsonPath().getInt("id");
        Assert.assertTrue(keyId > 0);
    }
	
	//get method
	
	@Test(priority = 2, dependsOnMethods = "addSSHKey")
    public void getSSHKey() {

        Response response = given()
                .spec(requestSpec)
                .pathParam("keyId", keyId)
                .when()
                .get("/user/keys/{keyId}");

        Reporter.log(response.asPrettyString());

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("title"), "TestAPIKey");
        Assert.assertEquals(response.jsonPath().getInt("id"), keyId);
    }
	
	//delete method
	
	@Test(priority = 3, dependsOnMethods = "getSSHKey")
    public void deleteSSHKey() {

        Response response = given()
                .spec(requestSpec)
                .pathParam("keyId", keyId)
                .when()
                .delete("/user/keys/{keyId}");

        Reporter.log("Delete Response Status Code: " + response.getStatusCode());

        Assert.assertEquals(response.getStatusCode(), 204);
    }


	

	

}
