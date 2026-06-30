//Create a TestNG Class with the annotations
//@Test
//@BeforeClass
//@AfterClass
//Once the Class file is created, import
//By
//WebDriver
//FirefoxDriver
//WebElement
//DataProviders
//In the @BeforeClass method, create the a driver instance for FirefoxDriver
//Also use the get() method to open the browser with https://training-support.net/webelements/login-form
//In the @AfterClass method, use close() to close the browser once the test is done.
//Add a @DataProviders method credentials() with the name parameter set to "Authentication".
//Set the return type of the method as Object[][].
//It should return two Objects with a username and a password each.
//Write a @Test method, with the parameter dataProvider set to name of the @DataProvider method.
//Add them as formal parameters for the test method.
//
//Activity 7
//In the @Test method:
//
//Use findElement() to find the username and password text boxes and the login button.
//Use sendKeys() with the variable names as input.
//Click the login button.
//Run the test script as a TestNG Test.
package activities;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Activity7 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        // Initialize driver
        driver = new FirefoxDriver();
        // Initialize wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Open the page
        driver.get("https://training-support.net/webelements/login-form");
    }

    @DataProvider(name = "Credentials")
    public static Object[][] creds() {
        return new Object[][] { 
            { "admin1", "password1", "Invalid Credentials" },
            { "wrongAdmin", "wrongPassword", "Invalid Credentials" }
        };
    }

    @Test(dataProvider = "Credentials")
    public void loginTest(String username, String password, String expectedMessage) {
        // Find the input fields and the login button
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.xpath("//button[text()='Submit']"));

        // Clear the input fields
        usernameField.clear();
        passwordField.clear();
        // Enter the credentials and click Log in
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();

        // Assert login message
        String loginMessage = driver.findElement(By.id("subheading")).getText();
        Assert.assertEquals(loginMessage, expectedMessage);
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}