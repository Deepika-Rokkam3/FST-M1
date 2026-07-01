package Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class GettheHeaderImageUrl {

    @Test
    public void printHeaderImageURL() {

        WebDriver driver = new FirefoxDriver();

        // Open browser
        driver.get("https://hrm.alchemy.hguy.co/");

        // Locate header image
        WebElement image =
                driver.findElement(By.xpath("//img"));

        // Get image URL
        String imageURL = image.getAttribute("src");

        // Print URL
        System.out.println("Header Image URL: " + imageURL);

        // Close browser
        driver.quit();
    }
}