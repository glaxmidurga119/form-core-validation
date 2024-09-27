import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FormValidationTest {
    public static void main(String[] args) {
        // Set the path for the ChromeDriver
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Initialize the Chrome driver
        WebDriver driver = new ChromeDriver();

        try {
            // Maximize the browser window
            driver.manage().window().maximize();

            // Set implicit wait
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            // Navigate to the webpage
            driver.get("http://example.com/form"); // Change to your form URL

            // Locate the form fields
            WebElement nameField = driver.findElement(By.id("name"));
            WebElement emailField = driver.findElement(By.id("email"));
            WebElement submitButton = driver.findElement(By.id("submit"));

            // Input data into the form
            nameField.sendKeys("John Doe");
            emailField.sendKeys("john.doe@example.com");

            // Submit the form
            submitButton.click();

            // Add assertions or validations as needed
            // Example: Check for a success message
            WebElement successMessage = driver.findElement(By.id("success-message"));
            if (successMessage.isDisplayed()) {
                System.out.println("Form submitted successfully!");
            } else {
                System.out.println("Form submission failed!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the driver
            driver.quit();
        }
    }
}
