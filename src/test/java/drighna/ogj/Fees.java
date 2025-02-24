package drighna.ogj;

import java.io.IOException;


import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.testng.Assert;


public class Fees extends BaseClass {
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
    

  
        String username = prop.getProperty("username");
        String password = prop.getProperty("password");

     

        WebElement feesCollection = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Fees Collection']")));
        feesCollection.click();
     

        WebElement feesMaster = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(@class, 'active')]//a[normalize-space()='Fees Master']")));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", feesMaster);

        try {
            feesMaster.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", feesMaster);
        }

        System.out.println("✅ Clicked on Fees Master, waiting for navigation...");

        boolean urlLoaded = wait.until(ExpectedConditions.urlToBe("https://edutech.drighna.com/admin/feemaster"));
        Assert.assertTrue(urlLoaded, "❌ Navigation to Fees Master page failed!");

        System.out.println("✅ Successfully navigated to Fees Master page!");

       
      
        String amount = prop.getProperty("amount", "1000000"); // default value if not found

        WebElement feeGroupDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='fee_groups_id']")));
        new Select(feeGroupDropdown).selectByIndex(1);
        System.out.println("Selected 'Renu' in Fee Groups");

        WebElement feeTypeDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='feetype_id']")));
        new Select(feeTypeDropdown).selectByIndex(1);
        System.out.println("Selected 'NASA' in Fee Type");

        WebElement dueDateInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='due_date']")));
        dueDateInput.click();
        WebElement datePicker = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[normalize-space()='10']")));
        datePicker.click();
        System.out.println("Selected Due Date as 10th");

        // Enter Amount
        WebElement amountField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='amount']")));
        amountField.sendKeys(amount);
        System.out.println("Entered Amount: " + amount);

        // Click the first Radio Button
        WebElement firstRadioButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='input-type']//div[1]")));
        firstRadioButton.click();
        System.out.println("Selected First Radio Button");

        // Enter Fine Percentage
        WebElement finePercentage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='fine_percentage']")));
        finePercentage.sendKeys("5");
        System.out.println(" Entered Fine Percentage: 5%");

        // Enter Fine Amount
        WebElement fineAmount = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='fine_amount']")));
        fineAmount.sendKeys("500");
        System.out.println("Entered Fine Amount: 500");

        // Click Submit Button
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-info pull-right']")));
        submitButton.click();
        System.out.println("Clicked Submit Button");
    }

    
    @Test
    public void searchFeeCollection() throws InterruptedException {
        // Click on "Collect Fees"
       
        
        WebElement CollectFees = driver.findElement(By.xpath("//a[normalize-space()='Collect Fees']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", CollectFees);


        // Select Class 1
        WebElement classDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='class_id']")));
        new Select(classDropdown).selectByIndex(1);
        System.out.println(" Selected Class 1");

        // Select Section A
        WebElement sectionDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='section_id']")));
        new Select(sectionDropdown).selectByIndex(1);
        System.out.println(" Selected Section A");

        String searchValue = prop.getProperty("searchText1");  // Retrieves 'Student Name' from config file

        WebElement searchInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='search_text']")));
        searchInput.sendKeys(searchValue);  
        System.out.println("✅ Entered search text: " + searchValue);

        // Click Search Button
        WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@name='keyword_search']")));
        searchButton.click();
        System.out.println(" Clicked on Search Button");
    }
    
  

        
}

