package drighna.ogj;

import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class transport extends BaseClass {
    private Properties prop;
    private WebDriverWait wait;

    @BeforeClass  
    public void setupOnce() {
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

     
        Login login = new Login();
        login.driver = this.driver;
        login.prop = this.prop;
        login.Login();
        
    }
    public void closePopupIfPresent() {
        WebElement closeButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='close']")));
        if (closeButton.isDisplayed()) {
            closeButton.click();
            System.out.println("Popup closed successfully.");
        }
    }
    
    

    @Test
    public void clickAngleLeftButton() throws InterruptedException {
       
    	  try {
              closePopupIfPresent(); 
          } catch (Exception e) {
              System.out.println("No popup found or an error occurred.");
          }
    	
    	  try {
    		    // Locate and scroll to the 17th <a> tag
    		  WebElement communicateElement = driver.findElement(By.xpath("(//a[@href='#'])[20]"));
    			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", communicateElement);
    		    System.out.println("Scrolled completely to the bottom of the page.");
    		} catch (Exception e) {
    		    System.err.println("An error occurred while scrolling: " + e.getMessage());
    		}

    	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	    WebElement link = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@href='#'])[30]")));
    	    link.click();  
       
                    
               WebElement dobSelect1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[normalize-space()='Pickup Point'])[2]")));
            dobSelect1.click();
         
            WebElement dobSelect11 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='Add'])[1]")));
            dobSelect11.click();
         
            WebElement dobSelect111 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='name'])[1]")));
            dobSelect111.click();
            
            String name = prop.getProperty("name");
            String latitude = prop.getProperty("latitude");
            String longitude = prop.getProperty("longitude");


            WebElement nameField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='name'])[1]")));
            nameField.click();
            nameField.sendKeys(name);

            WebElement latitudeField = driver.findElement(By.xpath("(//input[@id='latitude'])[1]"));
            latitudeField.sendKeys(latitude);

            WebElement longitudeField = driver.findElement(By.xpath("(//input[@id='longitude'])[1]"));
            longitudeField.sendKeys(longitude);
            
            WebElement submit= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@id='submit'])[1]")));
            submit.click();
            
            try {
                WebElement boxBody = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='box-body'])[1]")));
                if (boxBody.isDisplayed()) {
                    System.out.println("Box body is displayed after submission.");
                }
            } catch (Exception e) {
                System.out.println("Box body is NOT displayed after submission.");
            }
        }
    
    
    
    @Test
    public void clickAngleLeftButton11() throws InterruptedException {
        try {
            closePopupIfPresent(); // Close popups if present
        } catch (Exception e) {
            System.out.println("No popup found or an error occurred.");
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        try {
		    // Locate and scroll to the 17th <a> tag
        	WebElement communicateElement = driver.findElement(By.xpath("(//a[@href='#'])[20]"));
    		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", communicateElement);

		    System.out.println("Scrolled completely to the bottom of the page.");
		} catch (Exception e) {
		    System.err.println("An error occurred while scrolling: " + e.getMessage());
		}
	  
        WebElement nameField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[normalize-space()='Routes'])[2]")));
        nameField.click();

        // Enter route title (Manually set the value since 'prop' is not defined)
        String routess = "My Route Title"; // Replace with actual value
        WebElement routes = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='route_title'])[1]")));
        routes.sendKeys(routess);

        // Click the Save/Submit button
        WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@class='btn btn-info pull-right'])[1]")));
        saveButton.click();

    }
   
   

    @Test
    public void clickAngleLeftButton11111() throws InterruptedException {
       


        try {
        	WebElement communicateElement = driver.findElement(By.xpath("(//a[@href='#'])[30]"));
    		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", communicateElement);
		    System.out.println("Scrolled completely to the bottom of the page.");
		} catch (Exception e) {
		    System.err.println("An error occurred while scrolling: " + e.getMessage());
		}
        
	    
        WebElement nameField = driver.findElement(By.xpath("(//a[normalize-space()='Route Pickup Point'])[2]"));
        nameField.click();
        
        WebElement nameField1 = driver.findElement(By.xpath(" (//button[@class='btn btn-primary btn-sm checkbox-toggle pull-right'])[1]"));
        nameField1.click();
        
        
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id("route_id")));

     Select select = new Select(dropdown);
     select.selectByVisibleText("My Route Title");
     
        Select pickupDropdown = new Select(driver.findElement(By.xpath("(//select[@name='pickup_point[]'])[1]")));
        pickupDropdown.selectByVisibleText("Example Name1");
        
        WebElement destinationDistance = driver.findElement(By.xpath("(//input[@name='destination_distance[]'])[1]"));
        destinationDistance.click();
        
        WebElement timeField = driver.findElement(By.xpath("(//input[@name='time[]'])[1]"));
        timeField.click();
        
       
        
        WebElement submit = driver.findElement(By.xpath(" (//button[@id='submit'])[1]"));
        submit.click();
    }
    

}
