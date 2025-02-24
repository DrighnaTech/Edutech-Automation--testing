package drighna.ogj;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

public class Examination extends BaseClass {
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

        try {
            // Locate and click the 18th <a> tag
            WebElement linkElement18 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@href='#'])[18]")));
            wait.until(ExpectedConditions.elementToBeClickable(linkElement18)).click();

            System.out.println("Successfully clicked the 18th <a> element.");

            // Retrieve values from properties file
            String nameValue = prop.getProperty("nameValue2");
            String descriptionValue = prop.getProperty("descriptionValue");

            // Click "Exam Group"
            WebElement examGroup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[normalize-space()='Exam Group'])[2]")));
            examGroup.click();

            // Fill the form fields
            WebElement nameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='name'])[1]")));
            nameInput.sendKeys(nameValue);

            WebElement nameDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//select[@id='name'])[1]")));
            Select select = new Select(nameDropdown);
            select.selectByIndex(1); // Adjust index as needed

            WebElement descriptionInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//textarea[@id='description'])[1]")));
            descriptionInput.sendKeys(descriptionValue);
            
            WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@class='btn btn-info pull-right'])[1]")));

            button.click();


            System.out.println("Form filled successfully.");
        } catch (Exception e) {
            System.err.println("An error occurred while filling the form: " + e.getMessage());
        }
    }

    @Test(priority = 2)
    public void verifyExamScheduleLink() {
        try {
            // Locate and click the "Exam Schedule" link
            WebElement examScheduleLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[normalize-space()='Exam Schedule'])[4]")));
            wait.until(ExpectedConditions.elementToBeClickable(examScheduleLink)).click();

            System.out.println("Successfully clicked the 'Exam Schedule' link.");
        } catch (Exception e) {
            System.err.println("An error occurred in verifyExamScheduleLink: " + e.getMessage());
        }
        
      
            WebElement examGroupDropdown = driver.findElement(By.xpath("(//select[@id='exam_group_id'])[1]"));
            Select examGroupSelect = new Select(examGroupDropdown);
            examGroupSelect.selectByIndex(1);

            WebElement examDropdown = driver.findElement(By.xpath("(//select[@id='exam_id'])[1]"));
            examDropdown.click();

            WebElement searchIcon = driver.findElement(By.xpath("(//i[@class='fa fa-search'])[4]"));
            Assert.assertTrue(searchIcon.isDisplayed(), "Search icon is not displayed.");

            WebElement boxBody = driver.findElement(By.xpath("(//div[@class='box-body'])[2]"));
            Assert.assertTrue(boxBody.isDisplayed(), "Box-body is not displayed.");
        }
        @Test(priority = 3)

    public void verifyExamResultAndDropdowns() throws InterruptedException {
       
    	 try {
             // Locate and click the "Exam Schedule" link
             WebElement examScheduleLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[normalize-space()='Exam Result'])[2]")));
             wait.until(ExpectedConditions.elementToBeClickable(examScheduleLink)).click();
             System.out.println("Successfully clicked the 'Exam Schedule' link.");
         } catch (Exception e) {
             System.err.println("An error occurred in verifyExamScheduleLink: " + e.getMessage());
         }
        WebElement examGroupDropdown = driver.findElement(By.xpath("(//span[@id='select2-exam_group_id-container'])[1]"));
        examGroupDropdown.click();
      

        WebElement examDropdown = driver.findElement(By.xpath("(//span[@id='select2-exam_id-container'])[1]"));
        examDropdown.click();
       

        WebElement sessionDropdown = driver.findElement(By.xpath("(//select[@id='session_id'])[1]"));
        sessionDropdown.click();

        WebElement classDropdown = driver.findElement(By.xpath("(//select[@id='class_id'])[1]"));
        Select classSelect = new Select(classDropdown);
        classSelect.selectByIndex(1);
        Thread.sleep(1000);
        WebElement searchIcon = driver.findElement(By.xpath("(//button[normalize-space()='Search'])[1]"));
        searchIcon.click();
        
   
    }
        
        @Test(priority = 4)

        public void verifyExamResultAndDropdowns1() throws InterruptedException {
           
        	 try {
                 // Locate and click the "Exam Schedule" link
                 WebElement examScheduleLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" (//a[normalize-space()='Design Admit Card'])[2]")));
                 wait.until(ExpectedConditions.elementToBeClickable(examScheduleLink)).click();
                 System.out.println("Successfully clicked the 'Exam Schedule' link.");
             } catch (Exception e) {
                 System.err.println("An error occurred in verifyExamScheduleLink: " + e.getMessage());
             }
        	 
        	        driver.findElement(By.xpath("(//input[@id='template'])[1]")) .sendKeys(prop.getProperty("template"));
        	        driver.findElement(By.xpath("(//input[@id='heading'])[1]"))
        	              .sendKeys(prop.getProperty("heading"));
        	        driver.findElement(By.xpath("(//input[@id='title'])[1]"))
        	              .sendKeys(prop.getProperty("title"));
        	        driver.findElement(By.xpath("(//input[@id='exam_name'])[1]"))
        	              .sendKeys(prop.getProperty("exam_name"));
        	        driver.findElement(By.xpath("(//input[@id='school_name'])[1]"))
        	              .sendKeys(prop.getProperty("school_name"));
        	        driver.findElement(By.xpath("(//input[@id='exam_center'])[1]"))
        	              .sendKeys(prop.getProperty("exam_center"));
        	        driver.findElement(By.xpath("(//textarea[@name='content_footer'])[1]"))
        	              .sendKeys(prop.getProperty("content_footer"));
        	    }
        
        
        
        @Test(priority = 5)

        public void verifyExamResultAndDropdowns11() throws InterruptedException {
        	try {
                // Locate and click the "Exam Schedule" link
                WebElement examScheduleLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" (//a[normalize-space()='Print Admit Card'])[2]")));
                wait.until(ExpectedConditions.elementToBeClickable(examScheduleLink)).click();
                System.out.println("Successfully clicked the 'Exam Schedule' link.");
            } catch (Exception e) {
                System.err.println("An error occurred in verifyExamScheduleLink: " + e.getMessage());
            }
        	                WebElement examGroupDropdown = driver.findElement(By.xpath("(//select[@id='exam_group_id'])[1]"));
                Select examGroupSelect = new Select(examGroupDropdown);
                examGroupSelect.selectByIndex(1);
                Thread.sleep(1000);

                driver.findElement(By.xpath("(//select[@id='exam_id'])[1]")).click();
                Thread.sleep(1000);

                WebElement sessionDropdown = driver.findElement(By.xpath("(//select[@id='session_id'])[1]"));
                Select sessionSelect = new Select(sessionDropdown);
                sessionSelect.selectByIndex(1);
                Thread.sleep(1000);

                driver.findElement(By.xpath("(//select[@id='class_id'])[1]")).click();
                Select sessionSelect1 = new Select(sessionDropdown);
                sessionSelect1.selectByIndex(2);
                Thread.sleep(1000);

                WebElement sectionDropdown = driver.findElement(By.xpath("(//select[@id='section_id'])[1]"));
               sectionDropdown .click();

                WebElement admitCardDropdown = driver.findElement(By.xpath("(//select[@id='admitcard'])[1]"));
                Select admitCardSelect = new Select(admitCardDropdown);
                admitCardSelect.selectByIndex(1);
                Thread.sleep(1000);

                driver.findElement(By.xpath("(//button[normalize-space()='Search'])[1]")).click();
            }
        
        @Test(priority = 6)

        public void verifyExamResultAndDropdowns111() throws InterruptedException {
        	try {
                // Locate and click the "Exam Schedule" link
                WebElement examScheduleLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[normalize-space()='Design Marksheet'])[2]")));
                wait.until(ExpectedConditions.elementToBeClickable(examScheduleLink)).click();
                System.out.println("Successfully clicked the 'Exam Schedule' link.");
            } catch (Exception e) {
                System.err.println("An error occurred in verifyExamScheduleLink: " + e.getMessage());
            }
        	       	    	      	
        	  driver.findElement(By.xpath("(//input[@id='template'])[1]")).sendKeys(prop.getProperty("template1"));
        	        driver.findElement(By.xpath("(//input[@id='exam_name'])[1]")).sendKeys(prop.getProperty("exam_name1"));
        	        driver.findElement(By.xpath("(//input[@id='school_name'])[1]")).sendKeys(prop.getProperty("school_name1"));
        	        driver.findElement(By.xpath("(//input[@id='exam_center'])[1]")).sendKeys(prop.getProperty("exam_center1"));
        	        driver.findElement(By.xpath("(//textarea[@name='content'])[1]")).sendKeys(prop.getProperty("content1"));
        	        driver.findElement(By.xpath("(//textarea[@name='content_footer'])[1]")).sendKeys(prop.getProperty("content_footer1"));
        	        driver.findElement(By.xpath("(//input[@id='date'])[1]")) .sendKeys(prop.getProperty("date"));
        	        driver.findElement(By.xpath("(//button[@id='submitbtn'])[1]")).click();
        	        
        	        Thread.sleep(2000); // Replace with explicit wait if needed

        	        WebElement successMessage = driver.findElement(By.xpath("(//div[@class='alert alert-success text-left'])[1]"));
        	        Assert.assertTrue(successMessage.isDisplayed(), "Success message is NOT displayed.");
        	        Assert.assertEquals(successMessage.getText().trim(), "Record Saved Successfully", 
        	                            "Success message text does not match.");

        	        WebElement savedRecord = driver.findElement(By.xpath("(//div[@class='box-body'])[2]"));
        	        Assert.assertTrue(savedRecord.isDisplayed(), "Saved record is NOT displayed.");
        	    }
        
        
        
        @Test(priority = 7)

        public void verifyExamResultAndDropdowns1111() throws InterruptedException {
        	
        	
        	        WebElement designMarksheet = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//a[normalize-space()='Design Marksheet'])[2]")));

        	        // Scroll to the element slightly (not fully to the center)
        	        JavascriptExecutor js = (JavascriptExecutor) driver;
        	        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", designMarksheet);
        	
        	try {
                // Locate and click the "Exam Schedule" link
                WebElement examScheduleLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" (//a[normalize-space()='Print Marksheet'])[4]")));
                wait.until(ExpectedConditions.elementToBeClickable(examScheduleLink)).click();
                System.out.println("Successfully clicked the 'Exam Schedule' link.");
            } catch (Exception e) {
                System.err.println("An error occurred in verifyExamScheduleLink: " + e.getMessage());
            }
        	
        	
        	        driver.findElement(By.xpath("(//span[@id='select2-exam_group_id-container'])[1]")).click();
        	        Thread.sleep(1000); // Wait for options to appear

        	   
        	            

        	            WebElement sessionDropdown = driver.findElement(By.xpath("(//select[@id='session_id'])[1]"));
        	            new Select(sessionDropdown).selectByIndex(1);
        	            Thread.sleep(1000);

        	            WebElement classDropdown = driver.findElement(By.xpath("(//select[@id='class_id'])[1]"));
        	            new Select(classDropdown).selectByIndex(1);
        	            Thread.sleep(1000);

        	            WebElement sectionDropdown = driver.findElement(By.xpath("(//select[@id='section_id'])[1]"));
        	            new Select(sectionDropdown).selectByIndex(1);
        	            Thread.sleep(1000);

        	            WebElement marksheetDropdown = driver.findElement(By.xpath("(//select[@id='marksheet'])[1]"));
        	            new Select(marksheetDropdown).selectByIndex(1);
        	            Thread.sleep(1000);

        	            driver.findElement(By.xpath("(//button[normalize-space()='Search'])[1]")).click();
        	        }
        
        
        @Test(priority = 8)

        public void verifyExamResultAndDropdowns11111() throws InterruptedException {
        	  WebElement designMarksheet = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//a[normalize-space()='Design Marksheet'])[2]")));

  	        // Scroll to the element slightly (not fully to the center)
  	        JavascriptExecutor js = (JavascriptExecutor) driver;
  	        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", designMarksheet);
  	
   
        		try {
                    // Locate and click the "Exam Schedule" link
                    WebElement examScheduleLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[normalize-space()='Marks Grade'])[2]")));
                    wait.until(ExpectedConditions.elementToBeClickable(examScheduleLink)).click();
                    System.out.println("Successfully clicked the 'Exam Schedule' link.");
                } catch (Exception e) {
                    System.err.println("An error occurred in verifyExamScheduleLink: " + e.getMessage());
                }
        
        WebElement sessionDropdown = driver.findElement(By.xpath("(//select[@id='name'])[1]"));
        new Select(sessionDropdown).selectByIndex(1);
        Thread.sleep(1000);
        
        WebElement sessionDropdown1 = driver.findElement(By.xpath(" (//input[@id='name'])[1]"));
       sessionDropdown1.sendKeys(prop.getProperty("namw1"));
       
       WebElement sessionDropdown11 = driver.findElement(By.xpath("(//input[@id='mark_from'])[1]"));
       sessionDropdown11.sendKeys(prop.getProperty("markfrom"));
       
       WebElement sessionDropdown111 = driver.findElement(By.xpath("(//input[@id='mark_upto'])[1]"));
       sessionDropdown111.sendKeys(prop.getProperty("markupto"));
       
       
       WebElement sessionDropdown1111 = driver.findElement(By.xpath("  (//input[@id='grade_point'])[1]"));
       sessionDropdown1111.sendKeys(prop.getProperty("gradepoint"));
       
       WebElement sessionDropdown11111 = driver.findElement(By.xpath("(//textarea[@id='description'])[1]"));
       sessionDropdown11111.sendKeys(prop.getProperty("description123"));
      
       WebElement sessionDropdowns = driver.findElement(By.xpath("(//button[@class='btn btn-info pull-right'])[1]"));
       sessionDropdowns.click();
       
       Thread.sleep(2000); 
       WebElement successMessage = driver.findElement(By.xpath("(//div[@class='alert alert-success text-left'])[1]"));
       Assert.assertTrue(successMessage.isDisplayed(), "Success message is NOT displayed.");
       Assert.assertEquals(successMessage.getText().trim(), "Record Saved Successfully", 
                           "Success message text does not match.");

       WebElement savedRecord = driver.findElement(By.xpath("(//div[@class='box-body'])[2]"));
       Assert.assertTrue(savedRecord.isDisplayed(), "Saved record is NOT displayed.");
   }
        
        
        @Test(priority = 9)

        public void verifyExamResultAndDropdowns111111() throws InterruptedException {
        	  WebElement designMarksheet = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//a[normalize-space()='Design Marksheet'])[2]")));

  	        // Scroll to the element slightly (not fully to the center)
  	        JavascriptExecutor js = (JavascriptExecutor) driver;
  	        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", designMarksheet);
  	
   
        		try {
                    // Locate and click the "Exam Schedule" link
                    WebElement examScheduleLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" (//a[normalize-space()='Marks Division'])[2]")));
                    wait.until(ExpectedConditions.elementToBeClickable(examScheduleLink)).click();
                    System.out.println("Successfully clicked the 'Exam Schedule' link.");
                } catch (Exception e) {
                    System.err.println("An error occurred in verifyExamScheduleLink: " + e.getMessage());
                }
        		
        		
        		   WebElement sessionDropdown1 = driver.findElement(By.xpath("	//input[@id='name']"));
        	       sessionDropdown1.sendKeys(prop.getProperty("namw12"));
        	       
        	       WebElement sessionDropdown11 = driver.findElement(By.xpath("(//input[@id='percentage_from'])[1]"));
        	       sessionDropdown11.sendKeys(prop.getProperty("percent"));
        	       
        	       WebElement sessionDropdown111 = driver.findElement(By.xpath(" (//input[@id='percentage_to'])[1]"));
        	       sessionDropdown111.sendKeys(prop.getProperty("percentto")); 
        	       WebElement sessionDropdowns = driver.findElement(By.xpath("(//button[@class='btn btn-info pull-right'])[1]"));
        	       sessionDropdowns.click();
        	      
        	       Thread.sleep(2000); 
        	       WebElement successMessage = driver.findElement(By.xpath("(//div[@class='alert alert-success text-left'])[1]"));
        	       Assert.assertTrue(successMessage.isDisplayed(), "Success message is NOT displayed.");
        	       Assert.assertEquals(successMessage.getText().trim(), "Record Saved Successfully", 
        	                           "Success message text does not match.");

        	       WebElement savedRecord = driver.findElement(By.xpath("(//div[@class='box-body'])[2]"));
        	       Assert.assertTrue(savedRecord.isDisplayed(), "Saved record is NOT displayed.");
        }
}
 




        
        


    
