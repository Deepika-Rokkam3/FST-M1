import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Activity2 {

    String baseURI = "https://petstore.swagger.io/v2/user";
    String username = "deepika456789";   // Use a unique username

    @Test(priority = 1)
    public void addNewUserFromFile() {

        File inputJSON = new File("src/test/resources/user.json");

        Response response = given()
                .baseUri(baseURI)
                .contentType("application/json")
                .body(inputJSON)
                .when()
                .post();

        response.prettyPrint();

        response.then()
                .statusCode(200)
                .body("code", equalTo(200));

        // Wait for the user to be available
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 2)
    public void getUserInfo() throws IOException {

        Response response = given()
                .baseUri(baseURI)
                .pathParam("username", username)
                .when()
                .get("/{username}");

        response.prettyPrint();

        if (response.getStatusCode() == 200) {

            File outputJSON = new File("src/test/resources/userGETResponse.json");

            FileWriter writer = new FileWriter(outputJSON);
            writer.write(response.asPrettyString());
            writer.close();

            response.then()
                    .statusCode(200)
                    .body("id", equalTo(9901))
                    .body("username", equalTo(username))
                    .body("firstName", equalTo("Deepika"))
                    .body("lastName", equalTo("Rokkam"))
                    .body("email", equalTo("deepika@mail.com"))
                    .body("password", equalTo("password123"))
                    .body("phone", equalTo("9812763450"));

        } else {
            System.out.println("User not found.");
        }
    }

    @Test(priority = 3)
    public void deleteUser() {

        Response response = given()
                .baseUri(baseURI)
                .pathParam("username", username)
                .when()
                .delete("/{username}");

        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response: " + response.asString());

        response.then().statusCode(200);
    }
}