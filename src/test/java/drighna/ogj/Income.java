package drighna.ogj;

import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.*;

import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

public class Income extends BaseClass {
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
    public void incomeTest() {
        // Retrieve values from properties file
        String name = prop.getProperty("name99");
        String invoiceNo = prop.getProperty("invoice_no99");
        String date = prop.getProperty("date99");
        String amount = prop.getProperty("amount99");
        String description = prop.getProperty("description99");

        // Double-click on the 15th anchor link
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@href='#'])[15]")));
        element.click();
        System.out.println("Double-clicked on the 15th anchor with href='#'.");

        WebElement addIncomeLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[normalize-space()='Add Income'])[2]")));
        addIncomeLink.click();
        System.out.println("Clicked on the second 'Add Income' link.");

        WebElement nameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='name'])[1]")));
        nameInput.sendKeys(name);

        WebElement invoiceInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='invoice_no'])[1]")));
        invoiceInput.sendKeys(invoiceNo);

        WebElement dateInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='date']")));
        dateInput.sendKeys(date);

        WebElement amountInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='amount']")));
        amountInput.sendKeys(amount);

        WebElement descriptionInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='description']")));
        descriptionInput.sendKeys(description);

        // Wait for the second 'box-body' to be visible and check if it's displayed
        WebElement secondBoxBody = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='box-body'])[2]")));

        if (secondBoxBody.isDisplayed()) {
            System.out.println("The second 'box-body' is visible.");
        } else {
            System.out.println(" The second 'box-body' is not visible.");
        }
    }


    @Test(priority = 2)
     public void searchincome() {
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
         
        
         // Click on "Search Income" link (the second occurrence)
         WebElement searchIncomeLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[normalize-space()='Search Income'])[2]")));
         searchIncomeLink.click();

        
         WebElement searchTypeOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='search_type']/option[2]"))); // Select second option (index 1)
         searchTypeOption.click();

         WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@value='search_full'])[1]")));  // Adjust this XPath if needed
         searchButton.click();

         // Step 2: Wait for the table or message to load and check for "No data available in table"
         List<WebElement> noDataMessage = driver.findElements(By.xpath("//*[contains(text(),'No data available in table')]"));
         
         if (!noDataMessage.isEmpty()) {
             Assert.assertTrue(noDataMessage.get(0).isDisplayed(), "❌ Test failed: Expected 'No data available' but data was found.");
             System.out.println("✅ Verified: 'No data available in table' message is displayed.");
         } else {
             // Step 3: If no message, check for table rows
             List<WebElement> tableRows = driver.findElements(By.xpath("//table/tbody/tr"));
             Assert.assertTrue(tableRows.size() > 0, "❌ Test failed: No data found, but 'No data available' message is missing.");
             System.out.println("✅ Data found: Printing guest report details...");

             // Step 4: Print the details of each row in the table
             for (WebElement row : tableRows) {
                 System.out.println(row.getText());
             }
         }
    }
    
    @Test(priority = 3)
      
    public void fillIncomeHeadForm() {
    	 // Extract login credentials from config.properties
    	 Properties prop = new Properties();

 		try (InputStream inputStream = OnlineCourse.class.getClassLoader().getResourceAsStream("config.properties")) {

 			if (inputStream == null) {
 				System.out.println("Sorry, unable to find config.properties");
 				return;
 			}

 			// Load properties from the file
 			prop.load(inputStream);

 		} catch (IOException e) {
 			e.printStackTrace();
 		}
    	 
    	    	        	
    	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));  // Increased wait time to 20 seconds

    	        WebElement incomeHeadLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[normalize-space()='Income Head'])[2]")));
    	        incomeHeadLink.click();
    	        System.out.println("Income Head' link clicked.");
    	        String incomeHeadValue = prop.getProperty("incomehead100");
    	        String descriptionValue = prop.getProperty("description100");

    	        
    	        WebElement incomeHeadInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='incomehead'])[1]")));
    	        incomeHeadInput.clear();  // Clear any pre-filled text
    	        incomeHeadInput.sendKeys(incomeHeadValue);  // Enter value from properties
    	        System.out.println(" Entered text in 'Income Head' input field: " + incomeHeadValue);

    	        // Fill the "Description" textarea
    	        WebElement descriptionTextarea = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//textarea[@id='description'])[1]")));
    	        descriptionTextarea.clear();  // Clear any pre-filled text
    	        descriptionTextarea.sendKeys(descriptionValue);  // Enter value from properties
    	        System.out.println(" Entered text in 'Description' textarea: " + descriptionValue);
    	  
    	        
    	        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@class='btn btn-info pull-right'])[1]")));
    	        button.click();

    	        System.out.println("btn btn-info pull-right' button clicked.");
    	        
    	        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));  // Increased wait time to 20 seconds

    	        // Wait for the success message to appear
    	        WebElement successMessage = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-success text-left']")));

    	        // Get the actual text of the success message
    	        String actualMessage = successMessage.getText();

    	        // Verify that the message matches "Record Saved Successfully"
    	        Assert.assertTrue(actualMessage.contains("Record Saved Successfully"), "❌ Test failed: Success message is not as expected.");
    	        System.out.println("✅ 'Record Saved Successfully' message verified.");
    	    }
    	    
    	

  
        
    
}

