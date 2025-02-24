package drighna.ogj;

import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class transport1 extends BaseClass {
    private Properties prop;
    private WebDriverWait wait;

    @BeforeClass  // ✅ Runs only ONCE before all test cases
    public void setupOnce() throws InterruptedException {
        prop = new Properties();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Load config.properties file
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (inputStream == null) {
                System.out.println("config.properties not found!");
                return;
            }
            prop.load(inputStream);
        } catch (IOException e) {
            System.out.println("Error loading config.properties: " + e.getMessage());
        }

        // ✅ Perform login only once before all test cases
        Login login = new Login();
        login.driver = this.driver;
        login.prop = this.prop;
        login.Login();
        
    }
    @Test
    public void clickAngleLeftButton() throws InterruptedException {
       
    
    try {
	    // Locate and scroll to the 17th <a> tag
	  WebElement communicateElement = driver.findElement(By.xpath("(//a[@href='#'])[20]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", communicateElement);
	    System.out.println("Scrolled completely to the bottom of the page.");
	} catch (Exception e) {
	    System.err.println("An error occurred while scrolling: " + e.getMessage());
	}

    WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement link = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@href='#'])[30]")));
    link.click(); 
    
   
    
    WebElement link11 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[normalize-space()='Assign Vehicle'])[2]")));
    link11.click(); 
    
    Select routeDropdown = new Select(driver.findElement(By.xpath("(//select[@id='route_id'])[1]")));
    routeDropdown.selectByIndex(1);

    WebElement checkbox49 = driver.findElement(By.xpath("(//input[@value='49'])[1]"));
    checkbox49.click();

    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

    Thread.sleep(1000);

    // Click the submit button
    WebElement submitButton = driver.findElement(By.xpath("(//button[@class='btn btn-info pull-right'])[1]"));
    submitButton.click();
}




}
   