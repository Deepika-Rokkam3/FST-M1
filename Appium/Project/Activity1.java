package project;

import static org.testng.Assert.assertEquals;

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

public class Activity1 {

    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() throws MalformedURLException, URISyntaxException {

        UiAutomator2Options options = new UiAutomator2Options();

        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setDeviceName("Android Emulator");

        // Add your app package and activity here
        options.setAppPackage("YOUR_APP_PACKAGE");
        options.setAppActivity("YOUR_APP_ACTIVITY");

        URL serverURL = new URI("http://127.0.0.1:4723").toURL();

        driver = new AndroidDriver(serverURL, options);

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void addTodoTasks() {

        // Click New button
        driver.findElement(AppiumBy.accessibilityId("New")).click();

        // Add Activity 1
        driver.findElement(AppiumBy.id("YOUR_TASK_FIELD_ID"))
              .sendKeys("Complete Activity 1");

        // Set Priority 1
        driver.findElement(AppiumBy.id("YOUR_PRIORITY_FIELD_ID"))
              .sendKeys("1");

        // Set Due Date Wednesday
        driver.findElement(AppiumBy.id("YOUR_DUE_DATE_FIELD_ID"))
              .sendKeys("Wednesday");

        // Click OK
        driver.findElement(AppiumBy.accessibilityId("OK")).click();


        // Click New button for Activity 2
        driver.findElement(AppiumBy.accessibilityId("New")).click();

        // Add Activity 2
        driver.findElement(AppiumBy.id("YOUR_TASK_FIELD_ID"))
              .sendKeys("Complete Activity 2");

        // Set Priority 2
        driver.findElement(AppiumBy.id("YOUR_PRIORITY_FIELD_ID"))
              .sendKeys("2");

        // Set Due Date Wednesday
        driver.findElement(AppiumBy.id("YOUR_DUE_DATE_FIELD_ID"))
              .sendKeys("Wednesday");

        // Click OK
        driver.findElement(AppiumBy.accessibilityId("OK")).click();


        // Click New button for Activity 3
        driver.findElement(AppiumBy.accessibilityId("New")).click();

        // Add Activity 3
        driver.findElement(AppiumBy.id("YOUR_TASK_FIELD_ID"))
              .sendKeys("Complete Activity 3");

        // Set Priority 3
        driver.findElement(AppiumBy.id("YOUR_PRIORITY_FIELD_ID"))
              .sendKeys("3");

        // Set Due Date Thursday
        driver.findElement(AppiumBy.id("YOUR_DUE_DATE_FIELD_ID"))
              .sendKeys("Thursday");

        // Click OK
        driver.findElement(AppiumBy.accessibilityId("OK")).click();


        // Verify all three tasks are added
        int taskCount = driver.findElements(
                AppiumBy.xpath(
                    "//*[contains(@text,'Complete Activity 1') or " +
                    "contains(@text,'Complete Activity 2') or " +
                    "contains(@text,'Complete Activity 3')]"
                )
        ).size();

        assertEquals(taskCount, 3,
                "All three tasks should be present in the To-Do list");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
