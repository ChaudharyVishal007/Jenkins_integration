package Webpages;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;


public class LoginTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        driver = WebDriverUtility.getDriver();
    }

    @Test
    public void LaunchUrl() {
        // Launch the URL
        String url = "https://www.google.com/";
        driver.get(url);

        // Verify the title of the page
        String expectedTitle = "Google";
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
