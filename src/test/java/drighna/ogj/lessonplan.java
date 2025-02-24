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


		
		

public class lessonplan extends BaseClass {
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
            WebElement linkElement7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@href='#'])[23]")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", linkElement7);
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 200);");

            System.out.println("Located the 7th <a> element and scrolled down slightly.");
        } catch (Exception e) {
            System.err.println("An error occurred in clickAngleLeftButton (7th <a>): " + e.getMessage());
        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@href='#'])[23]")));
        link.click();
        		
        		  WebElement link1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[normalize-space()='Copy Old Lessons'])[2]")));
        	        link1.click();
        	        
        	        WebElement classDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//select[@id='old_session_id'])[1]")));
        	        new Select(classDropdown).selectByIndex(1); // Change index as needed
        	        
        	        WebElement classDropdown1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("  (//select[@id='old_class_id'])[1]")));
        	        new Select(classDropdown1).selectByIndex(1); // Change index as needed
        	        
        	        WebElement classDropdown11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("   (//select[@id='old_section_id'])[1]")));
        	        new Select(classDropdown11).selectByIndex(1); // Change index as needed

        	        
        	          	        
        	        WebElement classclick1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" (//button[normalize-space()='Search'])[1]")));
                    classclick1.click();
                    
                    WebElement subjectGroupError = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//p[normalize-space()='The Subject Group field is required.'])[1]")));
        	        Assert.assertTrue(subjectGroupError.isDisplayed(), "❌ Subject Group validation message NOT displayed!");
        	        System.out.println("✅ Subject Group validation message displayed: " + subjectGroupError.getText());
    	   
        	        
        	        WebElement subjectError1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//p[normalize-space()='The Subject field is required.'])[1]")));
        	        Assert.assertTrue(subjectError1.isDisplayed(), "❌ Subject validation message NOT displayed!");
        	        System.out.println("✅ Subject validation message displayed: " + subjectError1.getText());
        	    
        	     
    
   
}   
    
    @Test(priority = 2)
    public void clickAngleLeftButton11() {
        try {
            // Locate and scroll to the 7th <a> tag
            WebElement linkElement7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@href='#'])[23]")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", linkElement7);
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 200);");

            System.out.println("Located the 7th <a> element and scrolled down slightly.");
        } catch (Exception e) {
            System.err.println("An error occurred in clickAngleLeftButton (7th <a>): " + e.getMessage());
        }
        WebElement link1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(" (//a[normalize-space()='Manage Syllabus Status'])[2]")));
        link1.click();
        

        WebElement classDropdown11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" (//select[@id='searchclassid'])[1]")));
        new Select(classDropdown11).selectByIndex(1); 
        

        WebElement classDropdown111 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("   (//select[@id='secid'])[1]")));
        new Select(classDropdown111).selectByIndex(1); 
        

        WebElement classDropdown1111 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//select[@id='subject_group_id'])[1]")));
        new Select(classDropdown1111).selectByIndex(1);
        
        WebElement classDropdown11111 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("  (//select[@id='subid'])[1]")));
        new Select(classDropdown11111).selectByIndex(1);
        
        WebElement classclick1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" (//button[normalize-space()='Search'])[1]")));
        classclick1.click();
        
        WebElement mailboxMessagesDiv = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='table-responsive mailbox-messages overflow-visible-lg'])[1]")));

        // Verify if the message table is displayed
        Assert.assertTrue(mailboxMessagesDiv.isDisplayed(), "❌ The 'mailbox-messages' table is NOT displayed!");
        System.out.println("✅ The 'mailbox-messages' table is displayed successfully.");
}
    
    
    @Test(priority = 3)
    public void clickAngleLeftButton111() {
        try {
            // Locate and scroll to the 7th <a> tag
            WebElement linkElement7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@href='#'])[23]")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", linkElement7);
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 200);");

            System.out.println("Located the 7th <a> element and scrolled down slightly.");
        } catch (Exception e) {
            System.err.println("An error occurred in clickAngleLeftButton (7th <a>): " + e.getMessage());
        }
        WebElement link1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(" (//a[normalize-space()='Lesson'])[2]")));
        link1.click();
        
        WebElement classDropdown11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" (//select[@id='searchclassid'])[1]")));
        new Select(classDropdown11).selectByIndex(1); 
    
        WebElement classDropdown111 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("   (//select[@id='secid'])[1]")));
        new Select(classDropdown111).selectByIndex(1); 
        
        WebElement classDropdown1111 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//select[@id='subject_group_id'])[1]")));
        new Select(classDropdown1111).selectByIndex(1);
        
        WebElement classDropdown11111 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("  (//select[@id='subid'])[1]")));
        new Select(classDropdown11111).selectByIndex(1);
        
        String lessonValue = prop.getProperty("lesson.value");

        // Wait for the lesson input field and enter text
        WebElement lessonInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@name='lessons[]'])[1]")));
        lessonInput.sendKeys(lessonValue);

        System.out.println(" Successfully entered text into the lesson input field.");
        
        WebElement classclick1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@class='btn btn-info pull-right'])[1]")));
        classclick1.click();
   
    }
    
    @Test(priority = 4)
    public void clickAngleLeftButton1() {
    	WebElement link = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@href='#'])[23]")));

        // Perform double click using Actions class
        Actions actions = new Actions(driver);
        actions.doubleClick(link).perform();

        System.out.println(" Successfully performed a double-click on the link.");
   
        try {
            WebElement linkElement7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@href='#'])[23]")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", linkElement7);
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 200);");

            System.out.println("Located the 7th <a> element and scrolled down slightly.");
        } catch (Exception e) {
            System.err.println("An error occurred in clickAngleLeftButton (7th <a>): " + e.getMessage());
        }
        WebElement link1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(" (//a[normalize-space()='Manage Lesson Plan'])[2]")));
        link1.click();
    
        WebElement classDropdown11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" (//select[@id='teacher'])[1]")));
        new Select(classDropdown11).selectByIndex(1); // Change index as needed

        WebElement classclick1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" (//button[normalize-space()='Search'])[1]")));
        classclick1.click();
        WebElement tableDiv = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='table-responsive'])[1]")));

        // Verify if the table is displayed
        Assert.assertTrue(tableDiv.isDisplayed(), "❌ The 'table-responsive' div is NOT displayed!");
        System.out.println(" The 'table-responsive' div is displayed successfully.");
    }
    
    @Test(priority = 5)
    public void clickAngleLeftButton1111() {
    	WebElement link = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@href='#'])[23]")));

        // Perform double click using Actions class
        Actions actions = new Actions(driver);
        actions.doubleClick(link).perform();
    	try {
            // Locate and scroll to the 7th <a> tag
            WebElement linkElement17 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@href='#'])[23]")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", linkElement17);
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 400);");

            System.out.println("Located the 7th <a> element and scrolled down slightly.");
        } catch (Exception e) {
            System.err.println("An error occurred in clickAngleLeftButton (7th <a>): " + e.getMessage());
        }
        WebElement link1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[normalize-space()='Topic'])[2]")));
        link1.click();
        
        WebElement classDropdown11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" (//select[@id='searchclassid'])[1]")));
        new Select(classDropdown11).selectByIndex(1); 
        
        WebElement classDropdown111 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("   (//select[@id='secid'])[1]")));
        new Select(classDropdown111).selectByIndex(1); 
        
        WebElement classDropdown1111 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//select[@id='subject_group_id'])[1]")));
        new Select(classDropdown1111).selectByIndex(1);
        
        WebElement classDropdown11111 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("  (//select[@id='subid'])[1]")));
        new Select(classDropdown11111).selectByIndex(1);
        
        WebElement classDropdown111111 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='lessonid']")));
        new Select(classDropdown111111).selectByIndex(1);
     
        String lessonValue1 = prop.getProperty("topics");

        WebElement lessonInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@name='topic[]'])[1]")));
        lessonInput.sendKeys(lessonValue1);
        
        WebElement classclick1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@class='btn btn-info pull-right'])[1]")));
        classclick1.click();
    
    try {
        WebElement boxBody = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='box-body'])[2]")));

        Assert.assertTrue(boxBody.isDisplayed(), "❌ The 'box-body' div is NOT displayed!");
        System.out.println("The 'box-body' div is displayed successfully.");
    } catch (Exception e) {
        System.out.println(" The 'box-body' div did NOT appear.");
        Assert.fail("The 'box-body' div was not found.");
    }
    }
}

    
