package drighna.ogj;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.time.Duration;

public class Academics extends BaseClass {
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

        Login login = new Login();
        login.driver = this.driver;
        login.prop = this.prop;
        login.Login();
    }

    @Test(priority = 1)  // ✅ Ensures test runs first
   
    public void testClickFrontOfficeAndSelectClass() {
        WebElement frontOffice = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Front Office']")));
        frontOffice.click();

        WebElement admissionEnquiry = driver.findElement(By.xpath("//a[normalize-space()='Admission Enquiry']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", admissionEnquiry);


        WebElement classDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id("class")));

        Select select = new Select(classDropdown);
        select.selectByVisibleText("Class 1");
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "Class 1", "Dropdown selection failed!");

        WebElement sourceDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id("source")));

        Select sel = new Select(sourceDropdown);

        sel.selectByVisibleText("Advertisement");

        WebElement enquiryFromDate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='from_date']")));
        enquiryFromDate.click();

        WebElement selectDate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[normalize-space()='15']")));
        selectDate.click();

        WebElement enquiryToDate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='to_date']")));
        enquiryToDate.click();

        WebElement selectDate1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[normalize-space()='16']")));
        selectDate1.click();

        WebElement statusDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id("status")));

        Select select1 = new Select(statusDropdown);

        select1.selectByVisibleText("All");

        WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Search']")));

        searchButton.click();
    }
        
    

    @Test(priority = 2, dependsOnMethods = "testClickFrontOfficeAndSelectClass")  // ✅ Runs after the first test
    public void testVisitor() {
        WebElement visitor = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[normalize-space()='Visitor Book'])[2]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", visitor);

        WebElement addButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'btn-primary') and contains(text(),'Add')]")));
        addButton.click();

        WebElement purposeDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@name='purpose']")));
        Select purposeSelect = new Select(purposeDropdown);
        purposeSelect.selectByVisibleText("ok");

        WebElement meetingWithDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='meeting_with']")));
        Select meetingWithSelect = new Select(meetingWithDropdown);
        meetingWithSelect.selectByVisibleText("Staff");

        String contact = prop.getProperty("contactrr");
        String idProof = prop.getProperty("id_proofrr");
        String pepples = prop.getProperty("pepplesrr");

        WebElement contactField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='contact']")));
        contactField.sendKeys(contact);

        WebElement idProofField = driver.findElement(By.xpath("//input[@name='id_proof']"));
        idProofField.sendKeys(idProof);

        WebElement pepplesField = driver.findElement(By.xpath("//input[@name='pepples']"));
        pepplesField.sendKeys(pepples);


        WebElement dateField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("date")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].value='02/14/2025';", dateField);

        String inTime = prop.getProperty("in_time1");
        String outTime = prop.getProperty("out_time1");
        String description = prop.getProperty("description1");

        // Locate and enter 'in_time'
        WebElement inTimeField = wait.until(ExpectedConditions.elementToBeClickable(By.name("time")));
        inTimeField.clear();
        inTimeField.sendKeys(inTime);

        // Locate and enter 'out_time'
        WebElement outTimeField = wait.until(ExpectedConditions.elementToBeClickable(By.name("out_time")));
        outTimeField.clear();
        outTimeField.sendKeys(outTime);

        // Locate and enter 'description'
        WebElement descriptionField = driver.findElement(By.xpath("//textarea[@id='description']"));
        descriptionField.sendKeys(description);


        System.out.println("Visitor form completed successfully!");
    }


    
    @Test
    public void testFormSubmission() {
    	
    	WebElement phonecall = driver.findElement(By.xpath("//a[normalize-space()='Phone Call Log']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();" ,phonecall );

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        String name = prop.getProperty("nameT");
        String contact = prop.getProperty("contactT");

        WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("name")));
        nameField.sendKeys(name);

        Assert.assertEquals(nameField.getDomProperty("value"), name, "Name not entered correctly!");

        WebElement contactField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='contact']")));
        contactField.sendKeys(contact);

        Assert.assertEquals(contactField.getDomProperty("value"), contact, "Contact number not entered correctly!");


        WebElement dateField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='date']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].value='02/14/2025';", dateField);
        
        WebElement followUpDateField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='follow_up_date']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].value='02/21/2025';", followUpDateField);

        String callDuration = prop.getProperty("call_durationA");
        String description = prop.getProperty("descriptionA");
        String note = prop.getProperty("noteA");

        WebElement callDurationField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='call_duration']")));
        callDurationField.sendKeys(callDuration);

        WebElement descriptionField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='description' and @name='description']")));
        descriptionField.sendKeys(description);

        WebElement noteField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='description' and @name='note']")));
        noteField.sendKeys(note);


        WebElement radioButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Incoming']")));
        if (!radioButton.isSelected()) {
            radioButton.click();
        }

        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-info pull-right']")));
        submitButton.click();

        // **Validate Form Submission (Optional)**
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'alert-success')]")));
        Assert.assertTrue(successMessage.isDisplayed(), "Form submission failed!");
    }
    
    @Test
    public void testFormSubmission1() {
    
    WebElement phonedis = driver.findElement(By.xpath("//a[normalize-space()='Postal Dispatch']"));
    ((JavascriptExecutor) driver).executeScript("arguments[0].click();" ,phonedis );

 // Initialize WebDriverWait
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    String toTitle = prop.getProperty("to_titleT");
    String refNo = prop.getProperty("ref_noT");
    String from = prop.getProperty("fromT");
    String followUpDateValue = prop.getProperty("follow_up_dateT");
    String description = prop.getProperty("descriptionT");
    String note = prop.getProperty("noteT");

    WebElement titleField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='to_title']")));
    titleField.sendKeys(toTitle);

    WebElement refNoField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='ref_no']")));
    refNoField.sendKeys(refNo);

    WebElement fromField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='from']")));
    fromField.sendKeys(from);

    WebElement followUpDate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='date']")));
    ((JavascriptExecutor) driver).executeScript("arguments[0].value=arguments[1];", followUpDate, followUpDateValue);

    WebElement descriptionField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@name='address']")));
    descriptionField.sendKeys(description);

    WebElement noteField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@name='note']")));
    noteField.sendKeys(note);

    WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='submitbtn']")));
    submitButton.click();

}
    @Test
    public void testFormSubmission11() {

        WebElement complain = driver.findElement(By.xpath("//a[normalize-space()='Complain']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", complain);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement complaintDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@name='complaint']")));
        Select complaintSelect = new Select(complaintDropdown);
        complaintSelect.selectByVisibleText("Fees");

        WebElement sourceDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@name='source']")));
        Select sourceSelect = new Select(sourceDropdown);
        sourceSelect.selectByVisibleText("Advertisement");

        String name = prop.getProperty("nameq");
        String contact = prop.getProperty("contactq");
        String followUpDateValue = prop.getProperty("follow_up_dateq");
        String description = prop.getProperty("descriptionq");
        String actionTaken = prop.getProperty("action_takenq");
        String assigned = prop.getProperty("assignedq");
        String note = prop.getProperty("noteq");

        WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='name']")));
        nameField.sendKeys(name);
        WebElement contactField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='contact']")));
        contactField.sendKeys(contact);

        WebElement followUpDate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='date']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].value=arguments[1];", followUpDate, followUpDateValue);

        WebElement descriptionField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@name='description']")));
        descriptionField.sendKeys(description);

        WebElement actionTakenField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='action_taken']")));
        actionTakenField.sendKeys(actionTaken);

        WebElement assignedField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='assigned']")));
        assignedField.sendKeys(assigned);

        WebElement noteField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@name='note']")));
        noteField.sendKeys(note);

        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='submitbtn']")));
        submitButton.click();

       

    }


    @Test
    public void testFormInteraction() {
    	
    	
    	WebElement Setup = driver.findElement(By.xpath("//a[normalize-space()='Setup Front Office']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", Setup);

    
        WebElement purposeLink = driver.findElement(By.xpath("//a[normalize-space()='Purpose']"));
        purposeLink.click(); 

        String descriptionInput = prop.getProperty("description_input");
        String descriptionTextArea = prop.getProperty("description_textarea");

        WebElement descriptionField = driver.findElement(By.xpath("//input[@id='description']"));
        descriptionField.sendKeys(descriptionInput);

        WebElement descriptionArea = driver.findElement(By.xpath("//textarea[@id='description']"));
        descriptionArea.sendKeys(descriptionTextArea);

    }

   
        
    }



