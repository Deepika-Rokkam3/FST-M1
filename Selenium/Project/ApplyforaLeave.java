package Activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ApplyforaLeave {

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
        
        //Navigate to Dashboard
        
        driver.findElement(By.xpath("//*[@id=\"menu_dashboard_index\"]/b")).click();
        
        //navigate to apply leave
        
        driver.findElement(By.xpath("//*[@id=\"dashboard-quick-launch-panel-menu_holder\"]/table/tbody/tr/td[4]/div/a/img")).click();
        
        //Apply Leave
        
        WebElement leavetype = driver.findElement(By.name("applyleave[txtLeaveType]"));
        Select select=new Select(leavetype);
        select.selectByVisibleText("Holiday");
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement fromdate = wait.until(ExpectedConditions.elementToBeClickable(By.id("applyleave_txtFromDate")));
        
        fromdate.clear();
        
        fromdate.sendKeys("2026-07-24");
        
        //to date
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement todate = wait1.until(ExpectedConditions.elementToBeClickable(By.id("applyleave_txtToDate")));
        
        todate.clear();
        todate.sendKeys("2026-07-24");
        
        //aplly
//        driver.findElement(By.xpath("//*[@id=\"applyBtn\"]")).click();
        
//        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement apply=wait1.until(ExpectedConditions.elementToBeClickable(By.id("applyBtn")));
//        
//        apply.click();
        driver.findElement(By.name("applyleave[txtComment]")).sendKeys("Apply leave");
        
        driver.findElement(By.id("applyBtn")).click();
        
        System.out.print("Leave applied successfully");
        
        //check the status of the leaves
        driver.findElement(By.id("menu_leave_viewMyLeaveList")).click();
        
        //select from and to date 
        
       
     
        
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement from1 = wait2.until(ExpectedConditions.elementToBeClickable(By.name("leaveList[calFromDate]")));
        
        from1.clear();
        from1.sendKeys("2026-07-24");
        
        
        WebDriverWait wait21 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement to1 = wait21.until(ExpectedConditions.elementToBeClickable(By.name("leaveList[calToDate]")));
        
        to1.clear();
        to1.sendKeys("2026-07-24");
        
        
        driver.findElement(By.name("btnSearch")).click();
        
        String status = driver.findElement(
                By.xpath("//*[@id=\"resultTable\"]/tbody/tr/td[6]/a"))
                .getText();

        System.out.println(status);
        

        

        // Validation
        
       
        
        driver.quit();
        
        
        
}
}