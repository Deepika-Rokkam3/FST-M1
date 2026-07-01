package Activities;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class VerifytheWebsiteTitle {

    @Test
    public void verifyWebsiteTitle() {

        WebDriver driver = new FirefoxDriver();

        // Open website
        driver.get("https://hrm.alchemy.hguy.co/");

        // Get title
        String actualTitle = driver.getTitle();

        // Verify title
        assertEquals(actualTitle, "OrangeHRM");

        System.out.println("Title Verified Successfully");

        // Close browser
        driver.quit();
    }
}
