package project;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity5 {

    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException, URISyntaxException {

        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();

        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setDeviceName("Android Emulator");

        // Open Google Chrome
        options.setAppPackage("com.android.chrome");
        options.setAppActivity(
                "com.google.android.apps.chrome.Main"
        );

        options.noReset();

        // Appium Server URL
        URL serverURL = new URI(
                "http://localhost:4723"
        ).toURL();

        // Initialize Android Driver
        driver = new AndroidDriver(
                serverURL,
                options
        );

        wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(20)
        );
    }

    // Test Case 1: Valid Login
    @Test
    public void validLoginTest() {

        // Open the web page
        driver.get(
            "https://training-support.net/webelements"
        );

        // Click Login Form card
        driver.findElement(
                AppiumBy.xpath(
                    "//*[contains(@text,'Login Form')]"
                )
        ).click();

        // Enter valid username
        WebElement username = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                    By.id("username")
                )
        );

        username.sendKeys("admin");

        // Enter valid password
        driver.findElement(
                By.id("password")
        ).sendKeys("password");

        // Click Submit
        driver.findElement(
                By.xpath("//button[contains(text(),'Submit')]")
        ).click();

        // Verify successful login message
        String actualMessage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                    By.id("message")
                )
        ).getText();

        assertEquals(
                actualMessage,
                "Login successful",
                "Valid login should display success message"
        );
    }


    // Test Case 2: Invalid Login
    @Test
    public void invalidLoginTest() {

        // Open the web page
        driver.get(
            "https://training-support.net/webelements"
        );

        // Click Login Form card
        driver.findElement(
                AppiumBy.xpath(
                    "//*[contains(@text,'Login Form')]"
                )
        ).click();

        // Enter invalid username
        WebElement username = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                    By.id("username")
                )
        );

        username.sendKeys("wronguser");

        // Enter invalid password
        driver.findElement(
                By.id("password")
        ).sendKeys("wrongpassword");

        // Click Submit
        driver.findElement(
                By.xpath("//button[contains(text(),'Submit')]")
        ).click();

        // Verify error message
        String actualMessage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                    By.id("message")
                )
        ).getText();

        assertEquals(
                actualMessage,
                "Invalid credentials",
                "Invalid login should display error message"
        );
    }


    @AfterClass
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}
