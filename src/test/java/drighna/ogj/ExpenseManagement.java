package drighna.ogj;

import java.io.FileInputStream;

import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.Actions;



public class ExpenseManagement extends BaseClass {

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

        // ✅ Open the 'Angle Left' button link before any test case runs
        WebElement angleLeftButton = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[contains(@href,'#')])[16]")));
        angleLeftButton.click();
        System.out.println("Clicked on 'Angle Left' button.");
    }

    @Test(priority = 1)  // ✅ Ensures test runs first
    public void behave() {
        // Extract values from properties file
        String expenseName = prop.getProperty("expenseName");
        String invoiceNo = prop.getProperty("invoiceNo");
        String amount = prop.getProperty("amount");
        String description = prop.getProperty("description");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait for the "Add Expense" link to be visible and clickable, then click
        WebElement expenseLink = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[normalize-space()='Add Expense'])[2]")));
        expenseLink.click();
        System.out.println("Clicked on 'Add Expense' link.");

        // Select an option from the expense dropdown
        WebElement dropdown = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='exp_head_id']")));
        Select select = new Select(dropdown);
        select.selectByIndex(1);  // Select the first option

        // Fill in the form fields with values from config.properties
        WebElement expenseNameField = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='name']")));
        expenseNameField.sendKeys(expenseName);

        WebElement invoiceNoField = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='invoice_no']")));
        invoiceNoField.sendKeys(invoiceNo);

        WebElement amountField = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='amount']")));
        amountField.sendKeys(amount);

        WebElement descriptionField = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='description']")));
        descriptionField.sendKeys(description);

        // Wait for the submit button to be clickable, then click it to submit the form
        WebElement submitButton = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='submitbtn']")));
        submitButton.click();
        System.out.println("Form submitted.");

        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));  // Increased wait time to 20 seconds

        // Wait for the success message element to be visible
        WebElement successMessage = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-success text-left']")));

        // Get the actual text of the success message
        String actualMessage = successMessage.getText();

        // Verify that the success message matches "Record Saved Successfully"
        Assert.assertTrue(actualMessage.contains("Record Saved Successfully"), "❌ Test failed: Success message is not as expected.");
        System.out.println("✅ 'Record Saved Successfully' message verified.");
    }

    @Test
    public void verifyExpenseDetails1() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));  // Increased wait time to 20 seconds

        WebElement expenseHeadLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[normalize-space()='Expense Head'])[2]")));
        expenseHeadLink.click();
        System.out.println("Expense Head' link clicked.");

        WebElement expenseHeadInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='expensehead'])[1]")));
        expenseHeadInput.clear();  // Clear any pre-filled text
        expenseHeadInput.sendKeys("Office Supplies1");
        System.out.println("Entered text in 'Expense Head' input field.");

        WebElement descriptionTextarea = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//textarea[@id='description'])[1]")));
        descriptionTextarea.clear();  // Clear any pre-filled text
        descriptionTextarea.sendKeys("Office Supplies for the month of February.");
        System.out.println("Entered text in 'Description' textarea.");

        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@class='btn btn-info pull-right'])[1]")));
        submitButton.click();
        System.out.println("'Submit' button clicked.");

        // Verify the second 'box-body' div is displayed
        WebElement boxBodyDiv = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='box-body'])[2]")));
        Assert.assertTrue(boxBodyDiv.isDisplayed(), "❌ Test failed: The second 'box-body' div is not visible.");
        System.out.println("✅The second 'box-body' div is displayed.");
    }
}
 

