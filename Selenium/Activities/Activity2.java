//Using Selenium:
//
//Open a new browser to https://training-support.net/webelements/login-form/
//Get the title of the page and print it to the console.
//Find the username field using any locator and enter "admin" into it.
//Find the password field using any locator and enter "password" into it.
//Find the "Log in" button using any locator and click it.
//Close the browser.

package fst.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2 {

	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://training-support.net/webelements/login-form");
		
		driver.findElement(By.id("username")).sendKeys("admin");
		
		driver.findElement(By.id("password")).sendKeys("password");
		
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		
		String message = driver.findElement(By.tagName("h1")).getText();
        System.out.println(message);

        // Close the browser
        driver.quit();
		// TODO Auto-generated method stub

	}

}
