package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class AddEmployeeQualifications {
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
        
        //click on myinfo
        driver.findElement(By.xpath("//*[@id=\"menu_pim_viewMyDetails\"]/b")).click();
        
        //click on qualifications
        driver.findElement(By.xpath("//*[@id=\"sidenav\"]/li[9]/a")).click();
        
        //click on add
        driver.findElement(By.xpath("//*[@id=\"addWorkExperience\"]")).click();
        
        //Have to add the details
        String CompanyName ="IBM";
        String JobTitle="QA Tester";
        
        driver.findElement(By.name("experience[employer]")).sendKeys(CompanyName);
        driver.findElement(By.name("experience[jobtitle]")).sendKeys(JobTitle);
        
        //click on save
        
        driver.findElement(By.xpath("//*[@id=\"btnWorkExpSave\"]")).click();
        
        System.out.println("Qualification Details got added");
        
        driver.quit();
        
       
        
        		
        
       
        

}
}
