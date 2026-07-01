package Activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class EditUserInformation {
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

        
        //Navigate to my menu
        driver.findElement(By.xpath("//*[@id=\"menu_pim_viewMyDetails\"]/b")).click();
        
        //click on edit
        driver.findElement(By.xpath("//*[@id=\"btnSave\"]")).click();
        
        //edit the details
        
        driver.findElement(By.name("personal[txtEmpFirstName]"))
        .clear();

        driver.findElement(By.name("personal[txtEmpFirstName]"))
        .sendKeys("Deepika");

        // Update Last Name
        driver.findElement(By.name("personal[txtEmpLastName]"))
        .clear();

        driver.findElement(By.name("personal[txtEmpLastName]"))
        .sendKeys("R");
        
       // Select Gender
        driver.findElement(
                By.xpath("//*[@id=\"personal_optGender_2\"]"))
                .click();
        
        //Select Nationality
        WebElement nationality= driver.findElement(By.xpath("//*[@id=\"personal_cmbNation\"]"));
        Select select = new Select(nationality);
        select.selectByVisibleText("Indian");
        
        // DOB
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement dob = wait.until(ExpectedConditions.elementToBeClickable(By.id("personal_DOB")));
        
        dob.clear();
        dob.sendKeys("2000-06-09");
        
        
     // Save
        driver.findElement(
                By.xpath("//*[@id=\"btnSave\"]"))
                .click();

       

        System.out.println("User information updated");

        driver.quit();


   }
}
