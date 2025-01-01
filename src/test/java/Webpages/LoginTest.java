package Webpages;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        // Manually set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\vishalchaudhary\\Downloads\\chromedriver-win64 (3)\\chromedriver-win64\\chromedriver.exe"); // Replace with your actual path
        // Initialize ChromeDriver
        driver = new ChromeDriver();
    }

    @Test
    public void LaunchUrl() {
        // Launch the URL
        String url = "https://mcqa-shop.larsonjuhl.com/en-US/customer/account/login";
        driver.get(url);

        // Verify the title of the page
        String expectedTitle = "Customer Login";
        String actualTitle = driver.getTitle();
        assertEquals("The page title should match", expectedTitle, actualTitle);
    }

    @After
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
