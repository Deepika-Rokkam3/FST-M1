//Using Selenium:
//
//Open the training support site. (https://training-support.net)
//
//Print the title of the page
//
//Click the about us button
//
//Print the title of the new page

package fst.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity1 {
	public void main(String[] args) {
		
		WebDriver driver= new FirefoxDriver();
		
		driver.get("https://training-support.net");
		
		System.out.println("Page title is:" + driver.getTitle());
		
		driver.findElement(By.linkText("About Us")).click();
		
		System.out.println("New Page title is:" + driver.getTitle());
		
		driver.quit();
	}

}
