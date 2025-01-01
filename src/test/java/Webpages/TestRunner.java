package Webpages;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {

    public static void main(String[] args) {
        // Run the Login class tests
        Result result = JUnitCore.runClasses(Webpages.LoginTest.class);

        // Print out the result of the test run
        for (Failure failure : result.getFailures()) {
            System.out.println("Test failed: " + failure.toString());
        }

        // Print whether all tests passed
        System.out.println("All tests passed: " + result.wasSuccessful());
    }
}
