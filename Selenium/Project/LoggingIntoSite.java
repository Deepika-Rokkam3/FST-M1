package Activities;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class LoggingIntoSite {

    @Test
    public void loginTest() {

        // Open browser
        WebDriver driver = new FirefoxDriver();

        // Navigate to site
        driver.get("https://hrm.alchemy.hguy.co/");

//        // Maximize window
//        driver.manage().window().maximize();

        // Enter username
        driver.findElement(By.name("txtUsername"))
              .sendKeys("orange");

        // Enter password
        driver.findElement(By.name("txtPassword"))
              .sendKeys("5Nx#I6BK%r3$8vz0ch");

        // Click Login
        driver.findElement(By.xpath("//*[@id=\"btnLogin\"]"))
              .click();

        // Verify homepage opened
        String pageTitle = driver.getTitle();

        assertTrue(pageTitle.contains("OrangeHRM"));

        System.out.println("Login Successful");

        // Close browser
        driver.quit();
    }
}