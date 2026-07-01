package Activities;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class AddNewEmployee {

    @Test
    public void addEmployeeTest() throws InterruptedException {

        WebDriver driver = new FirefoxDriver();

        // Open application
        driver.get("https://hrm.alchemy.hguy.co/");
        driver.manage().window().maximize();

        // Login
        driver.findElement(By.name("txtUsername"))
                .sendKeys("orange");

        driver.findElement(By.name("txtPassword"))
                .sendKeys("5Nx#I6BK%r3$8vz0ch");

        driver.findElement(By.xpath("//*[@id=\"btnLogin\"]"))
                .click();

        Thread.sleep(3000);

        // Open PIM
        driver.findElement(By.xpath("//*[@id=\"menu_pim_viewPimModule\"]/b"))
                .click();

        Thread.sleep(2000);

        // Click Add
        driver.findElement(By.xpath("//*[@id=\"btnAdd\"]"))
                .click();

        Thread.sleep(2000);

        // Employee Details
        String firstName = "Deepika";
        String lastName = "R";

        driver.findElement(By.name("firstName"))
                .sendKeys(firstName);

        driver.findElement(By.name("lastName"))
                .sendKeys(lastName);

        // Save
//        driver.findElement(By.xpath("//button[@type='submit']"))
//                .click();

        Thread.sleep(3000);

        // Navigate Employee List
        driver.findElement(By.xpath("//*[@id=\"btnSave\"]"))
                .click();

        Thread.sleep(5000);

        // Navigate back to the pim page
        driver.findElement(By.xpath("//*[@id='menu_pim_viewPimModule']/b"))
        .click();
        
        //And navigate to employee list 
        
     // Navigate to Employee List
        driver.findElement(By.xpath("//*[@id='menu_pim_viewEmployeeList']"))
        .click();

        String employeeName = "Deepika R";
        
        //serach for the employee
     // Search employee
        driver.findElement(By.name("empsearch[employee_name][empName]"))
        .sendKeys(employeeName);

        // Click Search
        driver.findElement(By.xpath("//*[@id='searchBtn']"))
        .click();


        Thread.sleep(3000);

        // Verify employee created
        WebElement employee =
                driver.findElement(By.xpath("//*[contains(text(),'Deepika')]"));

        assertTrue(employee.isDisplayed());

        System.out.println("Employee created successfully");

        driver.quit();
    }
}