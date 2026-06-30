package activities;

//Create a TestNG Class with the annotations
//@Test
//@BeforeClass
//@AfterClass
//Once the Class file is created, import
//By
//WebDriver
//FirefoxDriver
//WebElement
//Parameters
//In the @BeforeClass method, create the a driver instance for FirefoxDriver
//Also use the get() method to open the browser with https://training-support.net/webelements/login-form
//In the @AfterClass method, use close() to close the browser once the test is done.
//Write a @Test method, with the annotation @Parameters below @Test.
//Pass "username" and "password" as the parameters. Also add them as formal parameters for the test method.
//Use findElements() to find the username and password text boxes and the login button.
//Use sendKeys() with the variable names as input. Then click() the login button.

//In testng.xml,
//
//Add the <parameter> tags before the <classes> tag.
//Add name parameters for username and password.
//Set their value to "admin" and "password", respectively.
//Save all the files and RUN testng.xml, NOT the test script.

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
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Activity6 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void beforeClass() {
        // Initialize the Firefox driver
        driver = new FirefoxDriver();
        // Initialize the wait object
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Open browser
        driver.get("https://training-support.net/webelements/login-form");
    }

    @Test
    @Parameters({ "username", "password", "message" })
    public void loginTestCase(String username, String password, @Optional("Login Success!") String message) {
        // Find username and password fields
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));

        // Enter credentials
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);

        // Click the submit button
        driver.findElement(By.xpath("//button[text()='Submit']")).click();

        // Wait for the success page to load
        wait.until(ExpectedConditions.titleContains("Success"));

        // Assert login message
        String loginMessage = driver.findElement(By.cssSelector("h2.text-center")).getText();
        Assert.assertEquals("Welcome Back, Admin!", loginMessage);
    }

    @AfterClass
    public void afterClass() {
        // Close browser
        driver.close();
    }
}