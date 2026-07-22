package project;


import static org.testng.Assert.assertTrue;

import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

import java.util.Arrays;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

public class Activity2 {
	AndroidDriver driver;
    WebDriverWait wait;
	@Test
	public void addCategoryAndAssignTask() {

	    // 1. Open the dropdown
	    driver.findElement(AppiumBy.id("YOUR_DROPDOWN_ID")).click();

	    // 2. Select "Edit categories"
	    driver.findElement(
	        AppiumBy.xpath("//*[@text='Edit categories']")
	    ).click();

	    // 3. Click New button
	    driver.findElement(
	        AppiumBy.accessibilityId("New")
	    ).click();

	    // 4. Enter category name
	    driver.findElement(
	        AppiumBy.id("YOUR_CATEGORY_FIELD_ID")
	    ).sendKeys("Work");

	    // 5. Click OK to save category
	    driver.findElement(
	        AppiumBy.accessibilityId("OK")
	    ).click();


	    // 6. Long press the second task
	    WebElement secondTask = driver.findElement(
	        AppiumBy.xpath("(//*[contains(@text,'Complete Activity')])[2]")
	    );

	    // Long press using W3C Actions
	    PointerInput finger = new PointerInput(
	        PointerInput.Kind.TOUCH,
	        "finger"
	    );

	    Sequence longPress = new Sequence(finger, 1);

	    longPress.addAction(
	        finger.createPointerMove(
	            Duration.ZERO,
	            PointerInput.Origin.fromElement(secondTask),
	            0,
	            0
	        )
	    );

	    longPress.addAction(
	        finger.createPointerDown(
	            PointerInput.MouseButton.LEFT.asArg()
	        )
	    );

	    longPress.addAction(
	        new Pause(finger, Duration.ofSeconds(2))
	    );

	    longPress.addAction(
	        finger.createPointerUp(
	            PointerInput.MouseButton.LEFT.asArg()
	        )
	    );

	    driver.perform(Arrays.asList(longPress));


	    // 7. Select the category for the task
	    driver.findElement(
	        AppiumBy.id("YOUR_CATEGORY_FIELD_ID")
	    ).click();

	    driver.findElement(
	        AppiumBy.xpath("//*[@text='Work']")
	    ).click();


	    // 8. Click OK / Save
	    driver.findElement(
	        AppiumBy.accessibilityId("OK")
	    ).click();


	    // 9. Open the filter dropdown
	    driver.findElement(
	        AppiumBy.id("YOUR_FILTER_DROPDOWN_ID")
	    ).click();

	    // 10. Select the "Work" category from filter
	    driver.findElement(
	        AppiumBy.xpath("//*[@text='Work']")
	    ).click();


	    // 11. Verify that the second task is displayed
	    WebElement task = driver.findElement(
	        AppiumBy.xpath("//*[contains(@text,'Complete Activity 2')]")
	    );

	    assertTrue(
	        task.isDisplayed(),
	        "Activity 2 should be displayed under the Work category"
	    );
	}

}
