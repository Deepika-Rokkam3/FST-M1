package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class AddEmergencyContacts {
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
        
        //navigate to emergency contacts 
        driver.findElement(By.xpath("//*[@id=\"sidenav\"]/li[3]/a")).click();
        
        //click on add
        driver.findElement(By.xpath("//*[@id=\"btnAddContact\"]")).click();
        
        //Add a name
        
//        String Name="Deepika";
//        String Relationship="Me";
//        String 
        
        driver.findElement(By.name("emgcontacts[name]")).sendKeys("Deepika");
        driver.findElement(By.name("emgcontacts[relationship]")).sendKeys("Sister");
        driver.findElement(By.name("emgcontacts[mobilePhone]")).sendKeys("532753288");
        
        //click on save 
        
        driver.findElement(By.name("btnSaveEContact")).click();
        
        System.out.println("Emergency contact got added");
        
        
        
       
        driver.quit();
        
        
}
}
