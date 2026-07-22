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

public class Activity4 {

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
        options.setAppActivity("com.google.android.apps.chrome.Main");

        options.noReset();

        // Appium Server URL
        URL serverURL = new URI(
                "http://localhost:4723"
        ).toURL();

        // Initialize driver
        driver = new AndroidDriver(serverURL, options);

        wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(20)
        );
    }

    @Test
    public void todoListTest() {

        // Open the web page
        driver.get(
            "https://training-support.net/webelements"
        );

        // Scroll and click the To-Do List card
        // The exact locator may need to be adjusted based on Appium Inspector
        WebElement todoCard = driver.findElement(
                AppiumBy.xpath(
                    "//*[contains(@text,'To-Do List')]"
                )
        );

        todoCard.click();

        // Wait for the To-Do input field
        WebElement inputField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                    By.id("taskInput")
                )
        );

        // Add Task 1
        inputField.sendKeys("Add tasks to list");
        inputField.sendKeys("\n");

        // Add Task 2
        inputField.sendKeys("Get number of tasks");
        inputField.sendKeys("\n");

        // Add Task 3
        inputField.sendKeys("Clear the list");
        inputField.sendKeys("\n");

        // Find all tasks
        int taskCount = driver.findElements(
                By.cssSelector("#todo-list li")
        ).size();

        // There were already 2 tasks
        // We added 3 new tasks
        // Expected total = 5
        assertEquals(
                taskCount,
                5,
                "Expected 5 tasks in the To-Do list"
        );

        // Click each newly added task to strike it out
        driver.findElement(
                By.xpath(
                    "//*[contains(text(),'Add tasks to list')]"
                )
        ).click();

        driver.findElement(
                By.xpath(
                    "//*[contains(text(),'Get number of tasks')]"
                )
        ).click();

        driver.findElement(
                By.xpath(
                    "//*[contains(text(),'Clear the list')]"
                )
        ).click();

        // Verify task count is still 5
        // Clicking tasks only strikes them out,
        // it does not remove them from the list
        int finalTaskCount = driver.findElements(
                By.cssSelector("#todo-list li")
        ).size();

        assertEquals(
                finalTaskCount,
                5,
                "Task count should remain 5 after striking tasks"
        );
    }

    @AfterClass
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}