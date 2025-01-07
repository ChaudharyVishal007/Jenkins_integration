package Webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverUtility {

    public static WebDriver getDriver() {
        String chromeDriverPath;

        // Check if running in Jenkins environment
        if (System.getenv("JENKINS_HOME") != null) {
            // Running on Jenkins, use the Linux path for Jenkins
            chromeDriverPath = "/usr/bin/chromedriver";  // Path in Jenkins environment
        }
        // Check if running inside a Docker container
        else if (System.getenv("DOCKER") != null) {
            // Running in Docker on Ubuntu, use the Linux path
            chromeDriverPath = "/usr/bin/chromedriver";  // Path inside Docker container
        } else {
            // Running locally (on your system), use the local path
            chromeDriverPath = "C:\\Users\\vishalchaudhary\\Downloads\\chromedriver-win64 (3)\\chromedriver-win64\\chromedriver.exe";  // Local Windows path
        }

        // Set the WebDriver system property
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // Run in headless mode
        options.addArguments("--disable-gpu"); // Optional: Disable GPU rendering
        options.addArguments("--no-sandbox"); // Required for Linux environments like Docker and Jenkins
        options.addArguments("--disable-dev-shm-usage"); // Prevent resource issues in containers

        // Return the WebDriver instance
        return new ChromeDriver(options);
    }
}
