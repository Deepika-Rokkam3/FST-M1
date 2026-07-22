package project;

import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity6 {

    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException, URISyntaxException {

        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();

        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setDeviceName("Android Emulator");

        // Open Chrome
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

    @Test
    public void popupLoginTest() {

        // Open the web page
        driver.get(
            "https://training-support.net/webelements"
        );

        // Click the Popups card
        driver.findElement(
                AppiumBy.xpath(
                    "//*[contains(@text,'Popups')]"
                )
        ).click();

        // Click the button to open the login popup
        driver.findElement(
                By.xpath(
                    "//button[contains(text(),'Open')]"
                )
        ).click();

        // Enter username
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                    By.id("username")
                )
        ).sendKeys("admin");

        // Enter password
        driver.findElement(
                By.id("password")
        ).sendKeys("password");

        // Click Submit
        driver.findElement(
                By.xpath(
                    "//button[contains(text(),'Submit')]"
                )
        ).click();

        // Verify successful login message
        String message = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                    By.id("message")
                )
        ).getText();

        // Assertion
        assertTrue(
                message.contains("S"),
                "Expected successful login message was not displayed"
        );
    }

    @AfterClass
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}