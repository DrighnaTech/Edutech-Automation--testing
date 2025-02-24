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



public class acad extends BaseClass {
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
            // Locate and scroll to the 7th <a> tag
            WebElement linkElement7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@href='#'])[7]")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", linkElement7);
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 200);");

            System.out.println("Located the 7th <a> element and scrolled down slightly.");
        } catch (Exception e) {
            System.err.println("An error occurred in clickAngleLeftButton (7th <a>): " + e.getMessage());
        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@href='#'])[22]")));
        link.click();
        
        WebElement link1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(" (//a[normalize-space()='Class Timetable'])[2]")));
        link1.click();
        WebElement classDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//select[@id='class_id'])[1]")));
        new Select(classDropdown).selectByIndex(1); // Change index as needed

        // Select section from dropdown
        WebElement sectionDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//select[@id='section_id'])[1]")));
        new Select(sectionDropdown).selectByIndex(1); // Change index as needed

        // Click the Search button
        WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='Search'])[1]")));
        searchButton.click();
        
        System.out.println("Search button clicked successfully!");
    } 
    @Test(priority = 2)
    public void clickAngleLeftButton1() {
    	
    	
    	  WebElement link1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[normalize-space()='Teachers Timetable'])[2]")));
          link1.click();
          
          WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

       WebElement teacherDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//select[@id='teacher'])[1]")));

       // Select the second option (index starts from 0, so index 1 is the second option)
       Select selectTeacher = new Select(teacherDropdown);
       selectTeacher.selectByIndex(1);

    }
    
    @Test(priority = 2)
    public void clickAngleLeftButton11() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement link = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//a[@href='#'])[22]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", link);
        System.out.println("Scrolled to the 22nd <a> element successfully.");
        WebElement assignClassTeacherLink = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//a[normalize-space()='Assign Class Teacher'])[2]")));

        assignClassTeacherLink.click(); // Directly click

        System.out.println("Successfully clicked on the second 'Assign Class Teacher' link.");
    
        
    	WebElement classDropdown = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("class_id")));
        Select selectClass = new Select(classDropdown);
        selectClass.selectByIndex(1); // Selecting the second option (Index starts from 0)

        WebElement sectionDropdown = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("(//select[@id='section_id'])[1]")));
        Select selectSection = new Select(sectionDropdown);
        selectSection.selectByIndex(1); // Selecting the second option

        WebElement teacherCheckbox = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//input[@name='teachers[]'])[1]")));
        if (!teacherCheckbox.isSelected()) {
            teacherCheckbox.click();
        }

        // Click the submit button
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//button[@class='btn btn-info pull-right'])[1]")));
        submitButton.click();

        System.out.println("Form submitted successfully!");


}
    
    
    @Test(priority = 3)
    public void clickAngleLeftButton111() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement link = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//a[@href='#'])[22]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", link);
        System.out.println("Scrolled to the 22nd <a> element successfully.");
        
        WebElement assignClassTeacherLink = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("    (//a[normalize-space()='Promote Students'])[2]")));

        assignClassTeacherLink.click(); // Directly click

        System.out.println("Successfully clicked on the second 'Assign Class Teacher' link.");
    	
        WebElement classDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//select[@id='class_id'])[1]")));
        new Select(classDropdown).selectByIndex(1); // Change index as needed

        // Select Section
        WebElement sectionDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//select[@id='section_id'])[1]")));
        new Select(sectionDropdown).selectByIndex(1); // Change index as needed

        // Select Session
        WebElement sessionDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//select[@id='session_id'])[1]")));
        new Select(sessionDropdown).selectByIndex(1); // Change index as needed

        // Select Promote Class
        WebElement classPromoteDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//select[@id='class_promote_id'])[1]")));
        new Select(classPromoteDropdown).selectByIndex(1); // Change index as needed

        // Select Promote Section
        WebElement sectionPromoteDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//select[@id='section_promote_id'])[1]")));
        new Select(sectionPromoteDropdown).selectByIndex(1); // Change index as needed

        System.out.println("Successfully selected all dropdown values.");
        
        
        WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//button[normalize-space()='Search'])[1]")));

        // Click on the button
        searchButton.click();
    }
    
    @Test(priority = 3)
    public void clickAngleLeftButton1111() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement link = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//a[@href='#'])[22]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", link);
        System.out.println("Scrolled to the 22nd <a> element successfully.");
        
        WebElement assignClassTeacherLink = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//a[normalize-space()='Subject Group'])[2]")));

        assignClassTeacherLink.click(); // Directly click

        System.out.println("Successfully clicked on the second 'Assign Class Teacher' link.");
    	
        String nameValue = prop.getProperty("name.value");
        String descriptionValue = prop.getProperty("description.value");

        WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='name'])[1]")));
        nameField.sendKeys(nameValue);

        WebElement classDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//select[@id='class_id'])[1]")));
        new Select(classDropdown).selectByIndex(1); // Change index as needed

        WebElement radioButton2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@value='2'])[1]")));
        radioButton2.click();

        WebElement radioButton17 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@value='17'])[1]")));
        radioButton17.click();

        WebElement descriptionField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//textarea[@id='description'])[1]")));
        descriptionField.sendKeys(descriptionValue);

        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@class='btn btn-info pull-right'])[1]")));
        submitButton.click();

        System.out.println("Text successfully entered and form submitted.");
    }

    @Test(priority = 4)
    public void clickAngleLeftButton11111() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement link = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//a[@href='#'])[22]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", link);
        System.out.println("Scrolled to the 22nd <a> element successfully.");
        
        WebElement assignClassTeacherLink = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("   (//a[normalize-space()='Subjects'])[2]")));
        assignClassTeacherLink.click(); // Directly click

        // Read input values from properties
        String category1Value = prop.getProperty("category1.value");
        String category2Value = prop.getProperty("category2.value");

        // Enter text into first Category Field
        WebElement category1Field = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='category'])[1]")));
        category1Field.sendKeys(category1Value);

        // Click on Radio Button with value 'theory'
        WebElement theoryRadioButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@value='theory'])[1]")));
        theoryRadioButton.click();

        // Enter text into second Category Field
        WebElement category2Field = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='category'])[2]")));
        category2Field.sendKeys(category2Value);

        // Click on Submit Button
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@class='btn btn-info pull-right'])[1]")));
        submitButton.click();

        // Verify that the displayed element is present
        WebElement displayedElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='box-body'])[2]")));
        Assert.assertTrue(displayedElement.isDisplayed(), "The expected element is NOT displayed.");

        System.out.println("Text successfully entered, form submitted, and element is displayed.");
    }
    @Test(priority = 5)
    public void clickAngleLeftButton111111() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement link = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//a[@href='#'])[22]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", link);
        System.out.println("Scrolled to the 22nd <a> element successfully.");
        
        WebElement assignClassTeacherLink = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("  (//a[normalize-space()='Class'])[2]")));
        assignClassTeacherLink.click(); // Directly click
        
        String classValue = prop.getProperty("class.value1");

        // Wait for the "Class" input field and enter text
        WebElement classField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='class'])[1]")));
        classField.sendKeys(classValue);

        // Wait and Click on the Radio Button with value '2'
        WebElement radioButton2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@value='2'])[1]")));
        radioButton2.click();

        System.out.println("Successfully entered text, clicked on 'Sections', and selected radio button.");
        
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@class='btn btn-info pull-right'])[1]")));
        submitButton.click();
    }
    
    
    @Test(priority = 5)
    public void clickAngleLeftButton1111111() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement link = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//a[@href='#'])[22]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", link);
        System.out.println("Scrolled to the 22nd <a> element successfully.");
        
        WebElement assignClassTeacherLink = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath(" (//a[normalize-space()='Sections'])[2]")));
        assignClassTeacherLink.click(); // Directly click
        String classValue = prop.getProperty("classValue23");

        WebElement classField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='section'])[1]")));
        classField.sendKeys(classValue);
        
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@class='btn btn-info pull-right'])[1]")));
        submitButton.click();
        WebElement boxBody = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("(//div[contains(@class,'box-body')])[2]")));

        boolean isDisplayed = boxBody.isDisplayed();
        Assert.assertTrue(isDisplayed, "The 'box-body' element is NOT displayed.");

        System.out.println("✅ The 'box-body' element is displayed successfully.");
    }



}