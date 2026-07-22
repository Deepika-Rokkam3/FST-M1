package project;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity3 {

    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException, URISyntaxException {

        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();

        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setDeviceName("Android Emulator");

        // Use your application's package and activity
        options.setAppPackage("YOUR_APP_PACKAGE");
        options.setAppActivity("YOUR_APP_ACTIVITY");

        options.noReset();

        // Appium Server URL
        URL serverURL = new URI(
                "http://localhost:4723"
        ).toURL();

        // Driver initialization
        driver = new AndroidDriver(serverURL, options);

        // Explicit wait
        wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(20)
        );
    }

    @Test
    public void markTasksAsComplete() {

        // Mark the first task as completed
        driver.findElement(
                AppiumBy.xpath(
                        "//*[contains(@text,'Complete Activity 1')]"
                )
        ).click();

        // Mark the second task as completed
        driver.findElement(
                AppiumBy.xpath(
                        "//*[contains(@text,'Complete Activity 2')]"
                )
        ).click();

        // Click the icon to toggle completed tasks
        driver.findElement(
                AppiumBy.accessibilityId("Toggle completed tasks")
        ).click();

        // Verify Activity 3 is displayed
        assertTrue(
                driver.findElement(
                        AppiumBy.xpath(
                                "//*[contains(@text,'Complete Activity 3')]"
                        )
                ).isDisplayed(),
                "Activity 3 should be displayed"
        );

        // Verify Activity 1 is NOT displayed
        assertFalse(
                driver.findElements(
                        AppiumBy.xpath(
                                "//*[contains(@text,'Complete Activity 1')]"
                        )
                ).size() > 0,
                "Activity 1 should not be displayed"
        );

        // Verify Activity 2 is NOT displayed
        assertFalse(
                driver.findElements(
                        AppiumBy.xpath(
                                "//*[contains(@text,'Complete Activity 2')]"
                        )
                ).size() > 0,
                "Activity 2 should not be displayed"
        );
    }

    @AfterClass
    public void tearDown() {

        // Close the app
        if (driver != null) {
            driver.quit();
        }
    }
}