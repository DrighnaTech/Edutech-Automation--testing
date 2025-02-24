package drighna.ogj;

import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class onlineexam extends BaseClass {
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
        try {
            // Locate and scroll to the 7th <a> tag
            WebElement linkElement7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@href='#'])[7]")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", linkElement7);
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 200);");

            System.out.println("Located the 7th <a> element and scrolled down slightly.");
        } catch (Exception e) {
            System.err.println("An error occurred in clickAngleLeftButton (7th <a>): " + e.getMessage());
        }

        try {
            // Locate and click the 18th <a> tag
            WebElement linkElement18 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@href='#'])[21]")));
            wait.until(ExpectedConditions.elementToBeClickable(linkElement18)).click();

            System.out.println("Successfully clicked the 21th <a> element.");
        }
            catch (Exception e) {
                System.err.println("An error occurred while filling the form: " + e.getMessage());
            }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement onlineExamLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[normalize-space()='Online Exam'])[2]")));
        onlineExamLink.click();
                		
        	    WebElement onlineExamLink1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("   (//button[normalize-space()='Add Exam'])[1]")));
                onlineExamLink1.click();
                String examname = prop.getProperty("examname");
                WebElement nameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" (//input[@id='exam'])[1]")));
                nameInput.sendKeys(examname);
             
                WebElement nameInput1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='exam_from'])[1]")));
                nameInput1.click();
                WebElement nameInput11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='exam_to'])[1]")));
                nameInput11.click();
                WebElement nameInput111 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" (//input[@id='auto_publish_date'])[1]")));
                nameInput111.click();
                String timeduration = prop.getProperty("timeduration");

                WebElement nameInput1111 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" (//input[@id='duration'])[1]")));
                nameInput1111.sendKeys(timeduration);
                
             nameInput1111.sendKeys(timeduration, Keys.RETURN); 
             String attempt = prop.getProperty("attempt");

             WebElement nameInput11111 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("  (//input[@id='attempt'])[1]")));
             nameInput11111.sendKeys(attempt);
             String percentage = prop.getProperty("percentage");

             WebElement nameInput111111 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" (//input[@id='passing_percentage'])[1]")));
             nameInput111111.sendKeys(percentage);

        
             
             WebElement isActive = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='is_active']")));
             isActive.click();

             WebElement publishResult = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='publish_result']")));
             publishResult.click();

             WebElement isNegMarking = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@name='is_neg_marking'])[1]")));
             isNegMarking.click();
             try {
                 WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[contains(@class,'cke_wysiwyg_frame')]")));
                 driver.switchTo().frame(iframe);

                 WebElement editorBody = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//body[@contenteditable='true']")));
                 editorBody.clear(); // Clear existing text if needed
                 editorBody.sendKeys("This is a test message inside CKEditor!");

                 JavascriptExecutor js = (JavascriptExecutor) driver;
                 js.executeScript("arguments[0].scrollIntoView(true);", editorBody);

                 Actions actions = new Actions(driver);
                 actions.moveToElement(editorBody).sendKeys(Keys.PAGE_DOWN).perform();

                 driver.switchTo().defaultContent();

                 WebElement loadButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@id='load'])[2]")));
                 loadButton.click();

                 System.out.println("✅ Successfully entered text in CKEditor, exited the iframe, and clicked the 'Load' button.");

             } catch (Exception e) {
                 System.out.println("⚠ An error occurred: " + e.getMessage());
                 Assert.fail("❌ Failed to interact with CKEditor or click the 'Load' button.");
                 
             }
    }
    
    @Test(priority = 2)
    public void clickAngleLeftButton1() throws InterruptedException {
    	
    	try {
    	    WebElement modalCloseButton = driver.findElement(By.xpath("//div[@id='myModal']//button[@class='close']"));
    	    if (modalCloseButton.isDisplayed()) {
    	        modalCloseButton.click();
    	        Thread.sleep(2000);  // Wait for modal to close
    	    }
    	} catch (Exception e) {
    	    System.out.println("No modal found, proceeding...");
    	}

    	// Now click the "Question Bank" link
    	WebElement questionBankLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[normalize-space()='Question Bank'])[2]")));
    	questionBankLink.click();

    	WebElement classDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//select[@id='class_id'])[1]")));
        new Select(classDropdown).selectByIndex(1);

        // Select "Search Section" dropdown
        WebElement sectionDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//select[@id='search_section_id'])[1]")));
        new Select(sectionDropdown).selectByIndex(1); // Adjust index as needed

        // Select "Subject" dropdown
        WebElement subjectDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//select[@name='subject'])[1]")));
        new Select(subjectDropdown).selectByIndex(1); // Adjust index as needed

        // Select "Question Type" dropdown
        WebElement questionTypeDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//select[@name='question_type'])[1]")));
        new Select(questionTypeDropdown).selectByIndex(1); // Adjust index as needed

        // Select "Question Level" dropdown
        WebElement questionLevelDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//select[@id='question_level'])[1]")));
        new Select(questionLevelDropdown).selectByIndex(1); // Adjust index as needed

        // Select "Created By" dropdown
        WebElement createdByDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//select[@id='created_by'])[1]")));
        new Select(createdByDropdown).selectByIndex(1); // Adjust index as needed

        // Click the "Search" button
        WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='Search'])[1]")));
        searchButton.click();

      System.out.println("Successfully selected dropdown values and clicked 'Search'.");
    

	        

}
}

  

