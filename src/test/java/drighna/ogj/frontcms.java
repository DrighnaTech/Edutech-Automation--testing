package drighna.ogj;


import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class frontcms extends BaseClass {
    private Properties prop;
    private WebDriverWait wait;

    @BeforeClass  // ✅ Runs only ONCE before all test cases
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

        // ✅ Perform login only once before all test cases
        Login login = new Login();
        login.driver = this.driver;
        login.prop = this.prop;
        login.Login();
    }

    @Test(priority = 1)
    public void clickAngleLeftButton() {
    	 try {
    		    // Locate and scroll to the 17th <a> tag
    		  WebElement communicateElement = driver.findElement(By.xpath("(//a[@href='#'])[20]"));
    			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", communicateElement);
    		    System.out.println("Scrolled completely to the bottom of the page.");
    		} catch (Exception e) {
    		    System.err.println("An error occurred while scrolling: " + e.getMessage());
    		}
    	    
        
        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@href='#'])[33]")));
        link.click();
        
        WebElement link1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(" (//a[normalize-space()='Event'])[2]")));
        link1.click();
        
        WebElement link11 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class='btn btn-sm btn-primary'])[1]")));
        link11.click();
        
        WebElement titleField = driver.findElement(By.xpath("(//input[@id='title'])[1]"));
        titleField.clear();
        titleField.sendKeys(prop.getProperty("title"));

        // Enter Venue
        WebElement venueField = driver.findElement(By.xpath("(//input[@id='venue'])[1]"));
        venueField.clear();
        venueField.sendKeys(prop.getProperty("venue"));

        WebElement iframe = driver.findElement(By.xpath("//iframe[@title='Rich Text Editor, editor1']"));
        driver.switchTo().frame(iframe);
        WebElement editorBody = driver.findElement(By.tagName("body"));
        editorBody.clear();
        editorBody.sendKeys(prop.getProperty("editor_text"));
        driver.switchTo().defaultContent(); // Switch back to the main page
        
        
        WebElement link111 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("  (//button[@class='btn cfees btn-block'])[1]")));
        link111.click();
        

       
    }
    
    @Test(priority = 2)
    public void clickAngleLeftButton1() {
    	 try {
    		    // Locate and scroll to the 17th <a> tag
    		  WebElement communicateElement = driver.findElement(By.xpath("(//a[@href='#'])[20]"));
    			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", communicateElement);
    		    System.out.println("Scrolled completely to the bottom of the page.");
    		} catch (Exception e) {
    		    System.err.println("An error occurred while scrolling: " + e.getMessage());
    		}
    	 WebElement link1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[normalize-space()='Gallery'])[2]")));
         link1.click();
    	 
         WebElement link11 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class='btn btn-sm btn-primary'])[1]")));
         link11.click();
         
         WebElement titleField = driver.findElement(By.xpath("(//input[@id='title'])[1]"));
         titleField.clear();
         titleField.sendKeys(prop.getProperty("title1"));

      

         WebElement iframe = driver.findElement(By.xpath("//iframe[@title='Rich Text Editor, editor1']"));
         driver.switchTo().frame(iframe);
         WebElement editorBody = driver.findElement(By.tagName("body"));
         editorBody.clear();
         editorBody.sendKeys(prop.getProperty("editor_text1"));
         driver.switchTo().defaultContent(); // Switch back to the main page
         
        		 
        WebElement link1111 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(" (//button[@data-placement='bottom'])[1]")));
                 link1111.click();
         
         WebElement link111 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("  (//button[@class='btn cfees btn-block'])[1]")));
         link111.click();
         
         try {
             WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='alert alert-success text-left'])[1]")));
             String messageText = successMessage.getText();

             if (messageText.contains("Record Saved Successfully")) {
                 System.out.println("✅ Success Message Displayed: " + messageText);
             } else {
                 System.out.println("❌ Unexpected Message: " + messageText);
             }
         } catch (Exception e) {
             System.out.println("❌ Record Save Failed or Success Message Not Displayed!");
         }
    }
         @Test(priority = 3)
         public void clickAngleLeftButton11() {
         	 try {
         		    // Locate and scroll to the 17th <a> tag
         		  WebElement communicateElement = driver.findElement(By.xpath("(//a[@href='#'])[20]"));
         			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", communicateElement);
         		    System.out.println("Scrolled completely to the bottom of the page.");
         		} catch (Exception e) {
         		    System.err.println("An error occurred while scrolling: " + e.getMessage());
         		}
         	String titleText = prop.getProperty("title123");
            String editorBodyText = prop.getProperty("editorBodyText123");

            // Locate and scroll to the 20th <a> tag
            WebElement communicateElement = driver.findElement(By.xpath("(//a[@href='#'])[20]"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", communicateElement);
            System.out.println("Scrolled completely to the bottom of the page.");

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[normalize-space()='News'])[2]"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class='btn btn-sm btn-primary'])[1]"))).click();

        WebElement titleField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='title'])[1]")));
        titleField.sendKeys(titleText);

        // Enter Date
        WebElement dateField = driver.findElement(By.xpath("(//input[@id='date'])[1]"));
        dateField.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//td[normalize-space()='24'])[1]"))).click();

        // Switch to iFrame and Enter Content (Using Properties)
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']")));
        WebElement editorBody = driver.findElement(By.tagName("body"));
        editorBody.clear();
        editorBody.sendKeys(editorBodyText);
        driver.switchTo().defaultContent(); // Exit iFrame

        // Click on Minimize Button
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//i[@class='fa fa-minus'])[1]"))).click();

        System.out.println("News entry created successfully!");

        WebElement link111 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("  (//button[@class='btn cfees btn-block'])[1]")));
        link111.click();
        // Close the browser
        System.out.println("News entry created successfully!");

    }
}
         


        
        
        
        
  
