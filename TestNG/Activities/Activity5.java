//Create a TestNG Class with the annotations
//@Test
//@BeforeClass
//@AfterClass
//In the @BeforeClass method, create the a driver instance for FirefoxDriver
//Also use the get() method to open the browser with https://training-support.net/webelements/target-practice
//In the @AfterClass method, use close() to close the browser once the test is done.
//Activity 5
//Write tests for:
//
//Checking the page title
//Header Tests:
//Find the third header and assert the text in the h3 tag.
//Find and assert the colour of the fifth header tag element.
//Button Tests:
//Find the button with the class emerald and assert it text.
//Find and assert the colour of the first button in the third row.
//Group the Header tests under a group, HeaderTests.
//Group the Button tests under a group, ButtonTests.
package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity5 {
    WebDriver driver;

    // Include alwaysRun property on the @BeforeClass to make sure the page always
    // opens
    @BeforeClass(alwaysRun = true)
    public void setUp() {
        // Create a new instance of the Firefox driver
        driver = new FirefoxDriver();

        // Open the browser
        driver.get("https://training-support.net/webelements/target-practice");
    }

    @Test(groups = { "HeaderTests", "ButtonTests" })
    public void pageTitleTest() {
        String title = driver.getTitle();
        System.out.println("Title is: " + title);
        Assert.assertEquals(title, "Selenium: Target Practice");
    }

    @Test(dependsOnMethods = { "pageTitleTest" }, groups = { "HeaderTests" })
    public void HeaderTest1() {
        WebElement header3 = driver.findElement(By.xpath("//h3[contains(@class, 'orange')]"));
        Assert.assertEquals(header3.getText(), "Heading #3");
    }

    @Test(dependsOnMethods = { "pageTitleTest" }, groups = { "HeaderTests" })
    public void HeaderTest2() {
        Color header5Color = Color.fromString(driver.findElement(By.cssSelector("h5.text-purple-600")).getCssValue("color"));
        Assert.assertEquals(header5Color.asHex(), "#9333ea");
    }

    @Test(dependsOnMethods = { "pageTitleTest" }, groups = { "ButtonTests" })
    public void ButtonTest1() {
        WebElement button1 = driver.findElement(By.xpath("//button[contains(@class, 'emerald')]"));
        Assert.assertEquals(button1.getText(), "Emerald");
    }

    @Test(dependsOnMethods = { "pageTitleTest" }, groups = { "ButtonTests" })
    public void ButtonTest2() {
        Color button2Color = Color.fromString(driver.findElement(By.xpath("//button[contains(@class, 'purple')]")).getCssValue("color"));
        Assert.assertEquals(button2Color.asHex(), "#581c87");
    }

    // Include alwaysRun property on the @AfterClass to make sure the page always
    // closes
    @AfterClass(alwaysRun = true)
    public void tearDown() {
        // Close the browser
        driver.close();
    }
}