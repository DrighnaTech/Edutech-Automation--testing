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
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;





public class attendanceexam extends BaseClass {
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
    public void clickAngleLeftButton() throws InterruptedException {
    	
    	// Locate the element using XPath
        WebElement element = driver.findElement(By.xpath("(//a[@href='#'])[13]"));

        // Scroll to the element (touch effect)
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);

        // Scroll down a little more (200 pixels)
        js.executeScript("window.scrollBy(0,200);");

        // Wait for a second to simulate a human-like action
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    	
    	WebElement link = driver.findElement(By.xpath("(//a[@href='#'])[19]"));
    	link.click();
    	
    	
    	System.out.println("naviagted ");
    	
    	WebElement link1 = driver.findElement(By.xpath("(//a[normalize-space()='Student Attendance'])[2]"));
    	link1.click();
    	
    	
    	  WebElement sessionDropdown = driver.findElement(By.xpath("(//select[@id='class_id'])[1]"));
          new Select(sessionDropdown).selectByIndex(1);
          Thread.sleep(1000);
          
          WebElement sessionDropdown1 = driver.findElement(By.xpath("  (//select[@id='section_id'])[1]"));
          new Select(sessionDropdown1).selectByIndex(1);
          Thread.sleep(1000);
          
          
          WebElement sessionDropdown11 = driver.findElement(By.xpath("(//input[@id='date'])[1]"));
         sessionDropdown11.click();
         
         WebElement sessionDropdown111 = driver.findElement(By.xpath(" (//td[normalize-space()='20'])[1]"));
         sessionDropdown111.click();

      	WebElement link11 = driver.findElement(By.xpath("(//button[normalize-space()='Search'])[1]"));
      	link11.click();
      	
      	 WebElement savedRecord = driver.findElement(By.xpath("(//div[@class='box-body'])[2]"));
         Assert.assertTrue(savedRecord.isDisplayed(), "Saved record is NOT displayed.");
      	
      	
          
    }
    
    @Test(priority = 2)
    public void clickAngleLeftButton1() throws InterruptedException {
    	
    	// Locate the element using XPath
        
    	
    	WebElement link1 = driver.findElement(By.xpath("(//a[normalize-space()='Approve Leave'])[2]"));
    	link1.click();
    	
    	WebElement sessionDropdown1 = driver.findElement(By.xpath("	//select[@id='searchclassid']"));
        new Select(sessionDropdown1).selectByIndex(1);
        Thread.sleep(1000);
        
        WebElement sessionDropdown11 = driver.findElement(By.xpath("//select[@id='secid']"));
        new Select(sessionDropdown11).selectByIndex(1);
        Thread.sleep(1000);
        
        System.out.println("Successfully clicked and selected an option from the dropdown.");


        System.out.println("Successfully clicked and selected an option from the dropdown.");
          
      	WebElement link11 = driver.findElement(By.xpath("(//button[normalize-space()='Search'])[1]"));
      	link11.click();
    
      		 
    }
      	 @Test(priority = 3)
	         public void clickAngleLeftButton111() throws InterruptedException {
      		 
      
      		 
      		WebElement link111 = driver.findElement(By.xpath("(//a[normalize-space()='Attendance By Date'])[2]"));
          	link111.click();
          	
         	
            WebElement sessionDropdown = driver.findElement(By.xpath(" //select[@id='class_id']"));
            new Select(sessionDropdown).selectByIndex(1);
            Thread.sleep(1000);
            
            WebElement sessionDropdown1 = driver.findElement(By.xpath(" //select[@id='section_id']"));
            new Select(sessionDropdown1).selectByIndex(1);
            Thread.sleep(1000);
            
            WebElement sessionDropdown11211 = driver.findElement(By.xpath("//input[@name='date']"));
            sessionDropdown11211.click();
            
            WebElement sessionDropdown111211 = driver.findElement(By.xpath(" (//td[normalize-space()='20'])[1]"));
            sessionDropdown111211.click();
       
            WebElement link11 = driver.findElement(By.xpath("(//button[normalize-space()='Search'])[1]"));
          	link11.click();
          	
          	try {
          	    WebElement tableWrapper = new WebDriverWait(driver, Duration.ofSeconds(10))
          	            .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@id='DataTables_Table_0_wrapper'])[1]")));

          	    if (tableWrapper.isDisplayed()) {
          	        System.out.println("The DataTables wrapper is displayed.");
          	    } else {
          	        System.out.println("The DataTables wrapper is NOT displayed.");
          	    }
          	} catch (Exception e) {
          	    System.err.println("The DataTables wrapper did NOT appear within 10 seconds: " + e.getMessage());
          	}

      	 }
}
      	 
        	             	      
