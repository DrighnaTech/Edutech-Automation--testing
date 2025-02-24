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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class hostel extends BaseClass {
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
    	    WebElement link = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@href='#'])[31]")));
    	    link.click(); 
    	    
    	    WebElement link1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("  (//a[normalize-space()='Hostel Rooms'])[2]")));
    	    link1.click();
    	    
    	    
    	    WebElement amountField12 = driver.findElement(By.xpath("(//input[@id='amount'])[1]"));
            amountField12.clear();
            amountField12.sendKeys(prop.getProperty("amount02"));
    	    
    	    Select hostelDropdown = new Select(driver.findElement(By.xpath("(//select[@id='hostel_id'])[1]")));
            hostelDropdown.selectByIndex(1);

            Select roomTypeDropdown = new Select(driver.findElement(By.xpath("(//select[@id='room_type_id'])[1]")));
            roomTypeDropdown.selectByIndex(1);

            WebElement amountField2 = driver.findElement(By.xpath("(//input[@id='amount'])[2]"));
            amountField2.clear();
            amountField2.sendKeys(prop.getProperty("amount2"));

            WebElement amountField3 = driver.findElement(By.xpath("(//input[@id='amount'])[3]"));
            amountField3.clear();
            amountField3.sendKeys(prop.getProperty("amount3"));

            WebElement descriptionField = driver.findElement(By.xpath("(//textarea[@id='description'])[1]"));
            descriptionField.clear();
            descriptionField.sendKeys(prop.getProperty("description100"));

            driver.findElement(By.xpath("(//button[@class='btn btn-info pull-right'])[1]")).click();
        }
    
    @Test
    public void clickAngleLeftButton1() throws InterruptedException {
       
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
    	    
  	    WebElement link1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(" (//a[normalize-space()='Room Type'])[2]")));
  	    link1.click();
  	    
        String expectedAmount = prop.getProperty("amount23");

  	  WebElement amountField2 = driver.findElement(By.xpath("(//input[@id='amount'])[1]"));
      amountField2.clear();
      amountField2.sendKeys("amount23");
      
      WebElement amountField21 = driver.findElement(By.xpath(" (//textarea[@id='description'])[1]"));
      amountField21.clear();
      amountField21.sendKeys(prop.getProperty("description234"));
      
      WebElement amountField211 = driver.findElement(By.xpath(" (//button[@class='btn btn-info pull-right'])[1]"));
      amountField211.click();
      try {
          WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='alert alert-success text-left'])[1]")));
          String messageText = successMessage.getText();

          if (messageText.contains("Record Saved Successfully")) {
              System.out.println("Success Message Displayed: " + messageText);
          } else {
              System.out.println("Unexpected Message: " + messageText);
          }
      } catch (Exception e) {
          System.out.println("❌ Record Save Failed or Success Message Not Displayed!");
      }

           try {
          WebElement savedDataSection = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='box-body'])[2]")));
          String savedDataText = savedDataSection.getText();

          if (savedDataText.contains(expectedAmount)) {
              System.out.println("Data Saved Successfully! Found: " + expectedAmount);
          } else {
              System.out.println("Data Not Found! Expected: " + expectedAmount);
          }
      } catch (Exception e) {
          System.out.println("Save Section Not Displayed!");
      }
    	  
    }
    
    @Test
    public void clickAngleLeftButton11() throws InterruptedException {
       
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
    	    
  	    WebElement link1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[normalize-space()='Hostel'])[4]")));
  	    link1.click();
  	  WebElement amountField2 = driver.findElement(By.xpath("(//input[@id='amount'])[1]"));
  	  amountField2.sendKeys(prop.getProperty("amount02"));
      
      Select hostelDropdown = new Select(driver.findElement(By.xpath("(//select[@id='type'])[1]")));
      hostelDropdown.selectByIndex(1);
  	    
      WebElement amountField21 = driver.findElement(By.xpath("(//input[@id='amount'])[2]"));
  	  amountField21.sendKeys(prop.getProperty("amount03"));

    
      
  WebElement amountField211 = driver.findElement(By.xpath("(//input[@id='amount'])[3]"));
	  amountField211.sendKeys(prop.getProperty("amount04"));

	  WebElement amountField2111 = driver.findElement(By.xpath(" (//textarea[@id='description'])[1]"));
  	  amountField2111.sendKeys(prop.getProperty("desc05"));
      
  	  
  	 WebElement amountField21111 = driver.findElement(By.xpath(" (//button[@class='btn btn-info pull-right'])[1]"));
     amountField21111.click();
  	
  	 
}
}
