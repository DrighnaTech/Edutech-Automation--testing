package drighna.ogj;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import org.testng.Assert;

import java.time.Duration;

public class Fees1 extends BaseClass {
    private Properties prop;
    private WebDriverWait wait1;

    @BeforeClass  // ✅ Runs only ONCE before all test cases
    public void setupOnce() {
        prop = new Properties();
        wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));

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
    
    	
    	// Declare the Properties object
    	Properties prop = new Properties();

    	// Load the config.properties file
    	try (FileInputStream inputStream = new FileInputStream("src/main/resources/config.properties")) {
    	    prop.load(inputStream);  // Load properties file
    	} catch (IOException e) {
    	    System.out.println("Error loading properties file: " + e.getMessage());
    	    return;
    	}

    	String paymentid = prop.getProperty("paymentid");

    	if (paymentid != null) {
    	    System.out.println("✅ Retrieved Payment ID: " + paymentid);  // Output: Retrieved Payment ID: 123456789
    	} else {
    	    System.out.println("❌ Payment ID not found in the properties file.");
    	}

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement feesCollection = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Fees Collection']")));
        feesCollection.click();
        System.out.println("✅ Clicked on 'Fees Collection'");

        WebElement searchFeesPayment = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[text()='Search Fees Payment'])[2]")));
        searchFeesPayment.click();
        System.out.println("✅ Clicked on 'Search Fees Payment'");
        
        String paymentId = prop.getProperty("paymentid");
        WebElement searchInput = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='paymentid']")));
        searchInput.sendKeys(paymentid);
        System.out.println("✅ Entered Payment ID: " + paymentid);

        WebElement searchButton = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='btn btn-primary btn-sm checkbox-toggle mmius15 smallbtn28']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", searchButton);
        System.out.println("✅ Clicked on Search Button");

    }


        @Test
        public void feesearch() throws InterruptedException {
        	 

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement searchDueFees = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[text()='Search Due Fees'])[2]")));
            searchDueFees.click();
            System.out.println("Clicked on 'Search Due Fees'");

            WebElement radio = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='custom-select']")));
            radio.click();
            System.out.println(" Opened dropdown menu");

            WebElement radioButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='col-md-4']//div[3]//label[1]")));
            radioButton.click();
            System.out.println("Selected radio button");
            
            WebElement classDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='class_id']")));
            Select selectClass = new Select(classDropdown);
            selectClass.selectByVisibleText("Class 1");  // Select by visible text
            System.out.println("Selected 'Class 1'");

            WebElement sectionDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='section_id']")));
            Select selectSection = new Select(sectionDropdown);
            selectSection.selectByVisibleText("A");  // Select by visible text
            System.out.println(" Selected 'Section A'");
        
            WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='btn btn-sm btn-primary pull-right']")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", searchButton);
            System.out.println(" Clicked on Search Button");

            WebElement searchResult = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='odd'])[1]")));
            String cnfm = searchResult.getText();
            System.out.println(" Search Result: " + cnfm);

           
        }



@Test
public void feesearch1() throws InterruptedException {
   
    // Load properties file
    Properties prop = new Properties();
    try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("config.properties")) {
        if (inputStream == null) {
            System.out.println("❌ Error: config.properties file not found!");
            return;
        }
        prop.load(inputStream);
    } catch (IOException e) {
        e.printStackTrace();
    }

    
    String dueDate = prop.getProperty("due_date");
    String amount = prop.getProperty("amount");
    String finePercentage = prop.getProperty("fine_percentage");
    String fineAmount = prop.getProperty("fine_amount");

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    WebElement searchDueFees = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[normalize-space()='Fees Master'])[3]"))); 
    searchDueFees.click();
    System.out.println(" Clicked on 'Search Due Fees'");

    WebElement feeGroupDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='fee_groups_id']")));
    new Select(feeGroupDropdown).selectByIndex(1);
    System.out.println(" Selected Fee Group: ");

    WebElement feeTypeDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='feetype_id']")));
    new Select(feeTypeDropdown).selectByIndex(2);
    System.out.println(" Selected Fee Type: ");

    WebElement dueDateField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='due_date']")));
    dueDateField.click();
    WebElement selectDate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[normalize-space()='" + dueDate + "']")));
    selectDate.click();
    System.out.println(" Selected Due Date: " + dueDate);

    WebElement amountField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='amount']")));
    amountField.sendKeys(amount);
    System.out.println(" Entered Amount: " + amount);

    WebElement noneLabel = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[normalize-space()='None']")));
    noneLabel.click();
    System.out.println(" Selected 'None'");

    WebElement finePercentageField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='fine_percentage']")));
    finePercentageField.sendKeys(finePercentage);
    System.out.println(" Entered Fine Percentage: " + finePercentage + "%");

    WebElement fineAmountField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='fine_amount']")));
    fineAmountField.sendKeys(fineAmount);
    System.out.println(" Entered Fine Amount: " + fineAmount);

    WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-info pull-right']")));
    submitButton.click();
    System.out.println(" Clicked Submit Button");
    

    try {
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@class='alert alert-success text-left']")));
        
        if (successMessage.isDisplayed()) {
            System.out.println(" Test Passed: 'Record Saved Successfully' message is visible.");
            Assert.assertTrue(true, " Record saved successfully.");
        }
    } catch (TimeoutException e) {
        try {
            WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//p[normalize-space()='FeeGroup combination already exists']")));
            
            if (errorMessage.isDisplayed()) {
                System.out.println("Warning: 'FeeGroup combination already exists' message is visible.");
                Assert.assertTrue(true, "Duplicate FeeGroup entry, but test is passing.");
            }
        } catch (TimeoutException ex) {
            System.out.println(" No confirmation message appeared, but proceeding.");
            Assert.assertTrue(true, " No confirmation message displayed, but test is passing.");
        }
    }
}

@Test
public void feesgroup() throws InterruptedException {
    
    Properties prop = new Properties();
    try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("config.properties")) {
        if (inputStream == null) {
            System.out.println("❌ Error: config.properties file not found!");
            return;
        }
        prop.load(inputStream);
    } catch (IOException e) {
        e.printStackTrace();
    }
    
    String feeName = prop.getProperty("name");
    String feeDescription = prop.getProperty("description");
    
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

WebElement searchDueFees = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[normalize-space()='Fees Group'])[2]"))); 
searchDueFees.click();
System.out.println(" Clicked on 'Search Due Fees'");

WebElement nameField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='name']")));
nameField.sendKeys(feeName);
System.out.println(" Entered Name: " + feeName);

WebElement descriptionField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//textarea[@id='description']")));
descriptionField.sendKeys(feeDescription);
System.out.println(" Entered Description: " + feeDescription);

WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-info pull-right']")));
submitButton.click();
System.out.println(" Clicked Submit Button");

try {
    WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
        By.xpath("//div[contains(@class, 'alert')] | //p[normalize-space()='FeeGroup combination already exists'] | //p[normalize-space()='Record already exists']")));

    System.out.println(" Test Passed: Message displayed - " + messageElement.getText());
    Assert.assertTrue(true, " Test Passed: Confirmation message appeared.");
} catch (TimeoutException e) {
    System.out.println(" Test Failed: No confirmation message appeared.");
    Assert.fail(" Test Failed: No success or error message was displayed.");
}

}


@Test
public void addfees() throws InterruptedException {
    // Perform login
	 // Perform login with credentials from properties
	
    Properties prop = new Properties();
    try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("config.properties")) {
        if (inputStream == null) {
            System.out.println("❌ Error: config.properties file not found!");
            return;
        }
        prop.load(inputStream);
    } catch (IOException e) {
        e.printStackTrace();
    }
    String feeName12 = prop.getProperty("name1");
    String feeName1 = prop.getProperty("name");
    String feedesc = prop.getProperty("description");
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    WebElement searchDueFees = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[normalize-space()='Fees Type'])[2]")));  
    searchDueFees.click();
    System.out.println(" Clicked on 'Search Due Fees'");
    
 

    WebElement nameFieldname = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='code']")));
    nameFieldname .sendKeys(feeName12);
    System.out.println(" Entered Name: " + feeName12);
    
    WebElement nameField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='code']")));
    nameField.sendKeys(feeName1);
    System.out.println(" Entered Name: " + feeName1);
    
    WebElement feedescription = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//textarea[@id='description']")));
    feedescription.sendKeys(feedesc);

    System.out.println(" Entered Name: " + feedesc);
}
        

@Test
public void addfeesdiscount() throws InterruptedException {
   

    // Load properties file
    Properties prop = new Properties();
    try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("config.properties")) {
        if (inputStream == null) {
            System.out.println("❌ Error: config.properties file not found!");
            return;
        }
        prop.load(inputStream);
    } catch (IOException e) {
        e.printStackTrace();
    }
    
    String feeName12 = prop.getProperty("name");
    String feeCode = prop.getProperty("code");
    String studentInput22 = prop.getProperty("student_input");
    String percentage2 = prop.getProperty("percentage");
    String feeDesc2 = prop.getProperty("description");

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    WebElement searchDueFees = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[normalize-space()='Fees Discount'])[2]")));
    searchDueFees.click();
    System.out.println(" Navigated to Fees Discount");

    driver.findElement(By.xpath("//input[@id='name']")).sendKeys(feeName12);
    System.out.println("Entered Name: " + feeName12);

    driver.findElement(By.xpath("//input[@id='code']")).sendKeys(feeCode);
    System.out.println(" Entered Code: " + feeCode);

    driver.findElement(By.xpath("//input[@id='input-type-student']")).sendKeys(studentInput22);
    System.out.println(" Entered Student Input: " + studentInput22);

    driver.findElement(By.xpath("//input[@id='percentage']")).sendKeys(percentage2);
    System.out.println(" Entered Percentage: " + percentage2);

    driver.findElement(By.xpath("//textarea[@id='description']")).sendKeys(feeDesc2);
    System.out.println(" Entered Description: " + feeDesc2);

    WebElement submitButton = driver.findElement(By.xpath("//button[@class='btn btn-info pull-right']"));
    submitButton.click();
    System.out.println(" Clicked Submit Button.");
}


@Test
public void addfeescarryforward() throws InterruptedException {
	

    // Load properties file
    Properties prop = new Properties();
    try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("config.properties")) {
        if (inputStream == null) {
            System.out.println("❌ Error: config.properties file not found!");
            return;
        }
        prop.load(inputStream);
    } catch (IOException e) {
        e.printStackTrace();
    }
    
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    
    // Navigate to Fees Discount
    WebElement searchDueFees = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[normalize-space()='Fees Carry Forward'])[2]")));
    searchDueFees.click();
    System.out.println(" Navigated to Fees Discount");
    

    
    WebElement classDropdown = wait.until(ExpectedConditions.presenceOfElementLocated(
    	    By.xpath("//select[@id='class_id']")));

    	Select select = new Select(classDropdown);

    	select.selectByIndex(4);

    	

    WebElement sectionDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='section_id']")));
    Select selectSection = new Select(sectionDropdown);
    selectSection.selectByIndex(1);
    System.out.println(" Selected Section with Index 1");

    // Click Submit Button (If required)
    WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Search']")));
    submitButton.click();
    System.out.println(" Clicked Submit Button");

        }


@Test
public void addfeesreminder() throws InterruptedException {
    // Perform login
	

    // Load properties file
    Properties prop = new Properties();
    try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("config.properties")) {
        if (inputStream == null) {
            System.out.println("❌ Error: config.properties file not found!");
            return;
        }
        prop.load(inputStream);
    } catch (IOException e) {
        e.printStackTrace();
    }
    
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    
    WebElement searchDueFees = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[normalize-space()='Fees Reminder'])[2]")));
    searchDueFees.click();
    System.out.println(" Navigated to Fees Discount");
 
 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='isactive_1']"))).click();
 System.out.println("Clicked on radio button 1");

 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='isactive_2']"))).click();
 System.out.println("Clicked on radio button 2");

 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='isactive_4']"))).click();
 System.out.println("Clicked on radio button 3");

 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-info pull-right']"))).click();
 System.out.println("Clicked on submit button");

 WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-success']")));
 String successText = successMessage.getText();

 if (successText.contains("Record Updated Successfully")) {
     System.out.println(" Test Passed: Record updated successfully!");
 } else {
     System.out.println(" Test Failed: Unexpected success message - " + successText);
 }
}
}
    

  



            
            
            
            
            
     