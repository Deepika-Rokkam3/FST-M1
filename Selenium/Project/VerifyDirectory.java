package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyDirectory {
	
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
        
        //verify the directory and do click
        
        driver.findElement(By.xpath("//*[@id=\"menu_directory_viewDirectory\"]/b")).click();
        
        WebElement heading =
                driver.findElement(
                        By.xpath("//*[@id=\"content\"]/div[1]/div[1]"));

        String actualText = heading.getText();

        // Verify heading
        Assert.assertEquals(actualText,
                "Search Directory");

        System.out.println("Heading verified successfully");

        // Close browser
        driver.quit();
        
        
       

}
}
