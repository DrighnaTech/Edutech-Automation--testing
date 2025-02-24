package drighna.ogj;




import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class report extends BaseClass {
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
    		    // Locate and scroll to the 17th <a> tag
    		  WebElement communicateElement = driver.findElement(By.xpath("(//a[@href='#'])[20]"));
    			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", communicateElement);
    		    System.out.println("Scrolled completely to the bottom of the page.");
    		} catch (Exception e) {
    		    System.err.println("An error occurred while scrolling: " + e.getMessage());
    		}
    	 
    	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[contains(@href,'#')])[35]"))).click();
    	 
    	 
		    
		    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[normalize-space()='Student Information'])[3]"))).click(); 
		    
         wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[normalize-space()='Student Report'])[1]"))).click();

         // Step 3: Select Class (Index 1)
         Select classDropdown = new Select(wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//select[@id='class_id'])[1]"))));
         classDropdown.selectByIndex(1); // Selecting the second option (index starts from 0)

         // Step 4: Select Section (Index 1)
         Select sectionDropdown = new Select(driver.findElement(By.xpath("(//select[@id='section_id'])[1]")));
         sectionDropdown.selectByIndex(1);

         // Step 5: Select Category (Index 1)
         Select categoryDropdown = new Select(driver.findElement(By.xpath("(//select[@id='category_id'])[1]")));
         categoryDropdown.selectByIndex(1);

         // Step 6: Select Gender (Index 1)
         Select genderDropdown = new Select(driver.findElement(By.xpath("(//select[@name='gender'])[1]")));
         genderDropdown.selectByIndex(1);

         // Step 7: Select RTE (Index 1)
         Select rteDropdown = new Select(driver.findElement(By.xpath("(//select[@id='rte'])[1]")));
         rteDropdown.selectByIndex(1);

         // Step 8: Click on "Search" Button
         wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='Search'])[1]"))).click();

         // Step 9: Verify if the Table is Displayed
         boolean isTableDisplayed = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='box-body table-responsive'])[1]"))).isDisplayed();

         if (isTableDisplayed) {
             System.out.println("Student Report Table is displayed!");
         } else {
             System.out.println("Student Report Table is NOT displayed!");
        
         } 
    
    
    	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[normalize-space()='Class & Section Report'])[1]"))).click();

         // Step 2: Click on "Guardian Report"
         wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[normalize-space()='Guardian Report'])[1]"))).click();

         // Step 3: Select Class (Index 1)
         Select classDropdown1 = new Select(wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//select[@id='class_id'])[1]"))));
         classDropdown1.selectByIndex(1);

         // Step 4: Select Section (Index 1)
         Select sectionDropdown1 = new Select(driver.findElement(By.xpath("(//select[@id='section_id'])[1]")));
         sectionDropdown1.selectByIndex(1);

         // Step 5: Click on "Search" Button
         wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='Search'])[1]"))).click();

         // Step 6: Check if Table is Displayed
         WebElement table = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='box-body table-responsive'])[1]")));

         if (table.isDisplayed()) {
             System.out.println("Table is displayed!");

             // Step 7: Extract Table Data
             List<WebElement> rows = table.findElements(By.tagName("tr"));
             for (WebElement row : rows) {
                 List<WebElement> columns = row.findElements(By.tagName("td"));
                 for (WebElement column : columns) {
                     System.out.print(column.getText() + " | "); // Print each cell value
                 }
                 System.out.println(); // New line for each row
             }
         } else {
             System.out.println("Table is NOT displayed!");
         }
    
         	 
        	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[normalize-space()='Student History'])[1]"))).click();
        	 
        	 Select classDropdowne1 = new Select(wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//select[@id='class_id'])[1]"))));
             classDropdowne1.selectByIndex(1);

             // Step 4: Select Section (Index 1)
             Select sectionDropdowen1 = new Select(driver.findElement(By.xpath("(//select[@id='year'])[1]")));
             sectionDropdowen1.selectByIndex(1);

             // Step 5: Click on "Search" Button
             wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='Search'])[1]"))).click();

         
     
	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[normalize-space()='Student Login Credential'])[1]"))).click();

	
	 Select classDropdown3 = new Select(wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//select[@id='class_id'])[1]"))));
     classDropdown3.selectByIndex(1);

     // Step 4: Select Section (Index 1)
     Select sectionDropdown3 = new Select(driver.findElement(By.xpath("(//select[@id='section_id'])[1]")));
     sectionDropdown3.selectByIndex(1);

     // Step 5: Click on "Search" Button
     wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='Search'])[1]"))).click();

     

	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[normalize-space()='Parent Login Credential'])[1]"))).click();


Select classDropdown4 = new Select(wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//select[@id='class_id'])[1]"))));
classDropdown4.selectByIndex(1);

// Step 4: Select Section (Index 1)
Select sectionDropdown4 = new Select(driver.findElement(By.xpath("(//select[@id='section_id'])[1]")));
sectionDropdown4.selectByIndex(1);

// Step 5: Click on "Search" Button
wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='Search'])[1]"))).click();





	 
	 
	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[normalize-space()='Class Subject Report'])"))).click();
	 Select classDropdown5 = new Select(wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//select[@id='class_id'])[1]"))));
     classDropdown5.selectByIndex(1);

     // Step 4: Select Section (Index 1)
     Select sectionDropdown5 = new Select(driver.findElement(By.xpath("(//select[@id='section_id'])[1]")));
     sectionDropdown5.selectByIndex(1);

     // Step 5: Click on "Search" Button
     wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='Search'])[1]"))).click();


	 
	 
	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[normalize-space()='Admission Report'])[1]"))).click();
	  Select sectionDropdown6 = new Select(driver.findElement(By.xpath("(//select[@name='search_type'])[1]")));
	     sectionDropdown6.selectByIndex(1);


	 
	 
	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[normalize-space()='Sibling Report'])[1]"))).click();
	 Select classDropdown7 = new Select(wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//select[@id='class_id'])[1]"))));
     classDropdown7.selectByIndex(1);

     // Step 4: Select Section (Index 1)
     Select sectionDropdown8 = new Select(driver.findElement(By.xpath("(//select[@id='section_id'])[1]")));
     sectionDropdown8.selectByIndex(1);

     // Step 5: Click on "Search" Button
     wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='Search'])[1]"))).click();


	 
	 
	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[normalize-space()='Student Profile'])[1]"))).click();
	 
	 
	 Select y = new Select(wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//select[@name='search_type'])[1]"))));
     y.selectByIndex(1);

	 
	 
	 Select classDropdown11u = new Select(wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//select[@id='class_id'])[1]"))));
     classDropdown11u.selectByIndex(1);

     // Step 4: Select Section (Index 1)
     Select sectionDropdown1y = new Select(driver.findElement(By.xpath("(//select[@id='section_id'])[1]")));
     sectionDropdown1y.selectByIndex(1);

     // Step 5: Click on "Search" Button
     wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='Search'])[1]"))).click();

     // Step 6: Check if Table is Displayed

	 
	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[normalize-space()='Student Gender Ratio Report'])[1]"))).click();
	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath(" (//a[normalize-space()='Student Teacher Ratio Report'])[1]"))).click();
	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("	 (//a[normalize-space()='Online Admission Report'])[1]"))).click();
	 Select classDropdowno = new Select(wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//select[@id='class_id'])[1]"))));
     classDropdowno.selectByIndex(1);

     // Step 4: Select Section (Index 1)
     Select sectionDropdown81 = new Select(driver.findElement(By.xpath("(//select[@id='section_id'])[1]")));
     sectionDropdown81.selectByIndex(1);
	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("     (//select[@id='status'])[1]"))).click();
	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='Search'])[1]"))).click();

     // Step 6: Check if Table is Displayed

}

    @Test(priority = 2)
    public void clickAngleLeftButton1() throws InterruptedException {
    	 try {
    		    // Locate and scroll to the 17th <a> tag
    		  WebElement communicateElement = driver.findElement(By.xpath("(//a[@href='#'])[20]"));
    			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", communicateElement);
    		    System.out.println("Scrolled completely to the bottom of the page.");
    		} catch (Exception e) {
    		    System.err.println("An error occurred while scrolling: " + e.getMessage());
    		}

    		
    			String dcrdf = prop.getProperty("dcrdf");
    			String dcrdt = prop.getProperty("dcrdt");

    		

    			driver.findElement(By.xpath("(//a[normalize-space()='Finance'])[2]")).click();
    			Thread.sleep(1000);
    			driver.findElement(By.xpath("(//*[text()=' Balance Fees Statement'])[1]")).click();
    			driver.findElement(By.xpath("//button[normalize-space()='Search']")).click();

    			Thread.sleep(1000);
    			WebElement cmf = driver.findElement(By.xpath("(//*[@class='box-body'])[2]"));
    			Assert.assertTrue(cmf.isDisplayed(), "Test failed: Unable to fetch Balance Fees Statement.");

    			// Daily Collection Report

    			driver.findElement(By.xpath("//a[normalize-space()='Daily Collection Report']")).click();
    			driver.findElement(By.xpath("//input[@id='date_from']")).sendKeys(dcrdf);
    			driver.findElement(By.xpath("//input[@id='date_to']")).sendKeys(dcrdt);
    			driver.findElement(By.xpath("//button[normalize-space()='Search']")).click();

    			Thread.sleep(1000);

    			WebElement cmf1 = driver.findElement(By.xpath("(//*[@class='odd'])[1]"));
    			Assert.assertTrue(cmf1.isDisplayed(), "Test failed: Unable to fetch Daily Collection Report.");

    			// fees statement
    			driver.findElement(By.xpath("//a[normalize-space()='Fees Statement']")).click();
    			driver.findElement(By.xpath("//button[normalize-space()='Search']")).click();
    			Thread.sleep(1000);

    			WebElement cmf2 = driver.findElement(By.xpath(
    					"//table[@id='DataTables_Table_0']//th[@class='sorting_disabled'][normalize-space()='Fees Group']"));
    			Assert.assertTrue(cmf2.isDisplayed(), "Test failed: Unable to fetch Fees Statement.");
    			Thread.sleep(1000);

    			// balance
    			driver.findElement(By.xpath("//a[normalize-space()='Balance Fees Report']")).click();
    			driver.findElement(By.xpath("//button[normalize-space()='Search']")).click();
    			Thread.sleep(1000);

    			WebElement cmf3 = driver.findElement(By.xpath("(//*[text()=' Balance Fees Report'])[2]"));
    			Assert.assertTrue(cmf3.isDisplayed(), "Test failed: Unable to fetch Balance Fees Report.");
    			Thread.sleep(1000);

    			// fee collection report
    			driver.findElement(By.xpath("//a[normalize-space()='Fees Collection Report']")).click();
    			WebElement secdur = driver.findElement(By.xpath("//select[@name='search_type']"));
    			Select secdursc = new Select(secdur);
    			secdursc.selectByIndex(1);
    			Thread.sleep(1000);
    			// online fee collection report
    			driver.findElement(By.xpath("//a[normalize-space()='Online Fees Collection Report']")).click();
    			WebElement sctt = driver.findElement(By.xpath("//select[@name='search_type']"));
    			Select scttsc = new Select(sctt);
    			scttsc.selectByIndex(1);
    			Thread.sleep(1000);

    			driver.findElement(By.xpath("//button[normalize-space()='Search']//i[@class='fa fa-search']")).click();
    			Thread.sleep(1000);

    			// Balance Fees Report With Remark
    			driver.findElement(By.xpath("//*[text()=' Balance Fees Report With Remark']")).click();
    			WebElement frcls = driver.findElement(By.xpath("//select[@id='class_id']"));
    			Select frclssc = new Select(frcls);
    			frclssc.selectByIndex(1);
    			Thread.sleep(1000);

    			WebElement frsec = driver.findElement(By.xpath("//select[@id='section_id']"));
    			Select frsecsc = new Select(frsec);
    			frsecsc.selectByIndex(1);
    			Thread.sleep(1000);

    			driver.findElement(By.xpath("//button[normalize-space()='Search']")).click();

    			Thread.sleep(1000);

    			WebElement cmf4 = driver.findElement(By.xpath("//*[text()=' Balance Fees Report With Remark ']"));
    			Assert.assertTrue(cmf4.isDisplayed(), "Test failed: Unable to fetch Balance Fees Report With Remark.");
    			Thread.sleep(1000);

    			// income report
    			driver.findElement(By.xpath("//a[normalize-space()='Income Report']")).click();
    			Thread.sleep(1000);
    			WebElement cmf5 = driver.findElement(By.xpath("(//*[@class='odd'])[1]"));
    			Assert.assertTrue(cmf5.isDisplayed(), "Test failed: Unable to fetch income report.");
    			Thread.sleep(1000);
    			

    			// Expense Report
    			driver.findElement(By.xpath("//a[normalize-space()='Expense Report']")).click();
    			Thread.sleep(1000);
    			WebElement cmf6 = driver.findElement(By.xpath("(//*[@class='odd'])[1]"));
    			Assert.assertTrue(cmf6.isDisplayed(), "Test failed: Unable to fetch Expense Report.");
    			Thread.sleep(1000);

    			// Payroll Report
    			driver.findElement(By.xpath("//a[normalize-space()='Payroll Report']")).click();
    			Thread.sleep(1000);
    			WebElement cmf7 = driver.findElement(By.xpath("(//*[@class='odd'])[1]"));
    			Assert.assertTrue(cmf7.isDisplayed(), "Test failed: Unable to fetch Payroll Reportk.");
    			Thread.sleep(1000);

    			// income group report
    			driver.findElement(By.xpath("//a[normalize-space()='Income Group Report']")).click();
    			Thread.sleep(1000);
    			WebElement cmf8 = driver.findElement(By.xpath("(//*[@class='odd'])[1]"));
    			Assert.assertTrue(cmf8.isDisplayed(), "Test failed: Unable to fetch Income Group Report.");
    			Thread.sleep(1000);

    			// Expense Group Report
    			driver.findElement(By.xpath("//a[normalize-space()='Expense Group Report']")).click();
    			Thread.sleep(1000);
    			WebElement cmf9 = driver.findElement(By.xpath("(//*[@class='odd'])[1]"));
    			Assert.assertTrue(cmf9.isDisplayed(), "Test failed: Unable to fetch Expense Group Report.");
    			Thread.sleep(1000);

    		}
    
    @Test(priority = 3)

	public void daily_attendance_report() throws InterruptedException {
    	 try {
 		  WebElement communicateElement = driver.findElement(By.xpath("(//a[@href='#'])[25]"));
 			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", communicateElement);
 		    System.out.println("Scrolled completely to the bottom of the page.");
 		} catch (Exception e) {
 		    System.err.println("An error occurred while scrolling: " + e.getMessage());
 		}
	
	driver.findElement(By.xpath("(//a[normalize-space()='Attendance'])[5]")).click();
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	WebElement attendanceReport = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[normalize-space()='Attendance Report'])[1]")));
	attendanceReport.click();

	// Wait for the dropdowns to be visible and select index 1
	Select classDropdown = new Select(wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//select[@id='class_id'])[1]"))));
	classDropdown.selectByIndex(1);

	Select sectionDropdown = new Select(wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//select[@id='section_id'])[1]"))));
	sectionDropdown.selectByIndex(1);

	Select monthDropdown = new Select(wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//select[@id='month'])[1]"))));
	monthDropdown.selectByIndex(1);

	// Click the "Search" button
	WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='Search'])[1]")));
	searchButton.click();
	
	// Wait for the element to be present

	try {
	    WebElement tableDiv = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='box-body table-responsive'])[1]")));
	    
	    if (tableDiv.isDisplayed()) {
	        System.out.println("✅ The table is displayed.");
	    } else {
	        System.out.println("❌ The table is NOT displayed.");
	    }
	} catch (TimeoutException e) {
	    System.out.println("⏳ The table did not appear within the timeout period.");
	}
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[normalize-space()='Student Attendance Type Report'])[1]"))).click();

    // Click on "Daily Attendance Report"
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[normalize-space()='Daily Attendance Report'])[1]"))).click();

    // Select date input field and enter date
    WebElement dateField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@name='date'])[1]")));
    dateField.click();

    // Select specific day (21st) from the calendar
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//td[normalize-space()='21'])[1]"))).click();

    // Click on "Search" button
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='Search'])[1]"))).click();

    // Verify if the table is displayed
    WebElement tableDiv1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='box-body table-responsive'])[1]")));
    if (tableDiv1.isDisplayed()) {
        System.out.println("✅ Attendance Report Table is displayed.");
    } else {
        System.out.println("❌ Attendance Report Table is NOT displayed.");
    }
    
    // Click on "Student Day Wise Attendance Report"
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[normalize-space()='Student Day Wise Attendance Report'])[1]"))).click();

    // Select class dropdown (select index 1)
    WebElement classDropdown1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//select[@id='class_id'])[1]")));
    Select selectClass = new Select(classDropdown1);
    selectClass.selectByIndex(1);

    // Select section dropdown (select index 1)
    WebElement sectionDropdown1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//select[@id='section_id'])[1]")));
    Select selectSection = new Select(sectionDropdown1);
    selectSection.selectByIndex(1);

    // Select date input field again
    WebElement dateField2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@name='date'])[1]")));
    dateField2.click();

    // Select specific day (21st) again
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//td[normalize-space()='21'])[1]"))).click();

    // Click on "Search" button again
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='Search'])[1]"))).click();
    
    WebElement dayWiseReport = driver.findElement(By.xpath("(//a[normalize-space()='Staff Day Wise Attendance Report'])[1]"));
    dayWiseReport.click();
    Thread.sleep(2000); // Wait for page to load (Better to use WebDriverWait)

   

    // Locate and click on "Staff Attendance Report"
    WebElement staffAttendanceReport = driver.findElement(By.xpath("(//a[normalize-space()='Staff Attendance Report'])[1]"));
    staffAttendanceReport.click();
    Thread.sleep(2000);

    // Locate and click on "Biometric Attendance Log"
    WebElement biometricLog = driver.findElement(By.xpath("(//a[normalize-space()='Biometric Attendance Log'])[1]"));
    biometricLog.click();
    Thread.sleep(2000);

}
    @Test(priority = 4)

   	public void daily_attendance_report1() throws InterruptedException {
       	 try {
    		  WebElement communicateElement = driver.findElement(By.xpath("(//a[@href='#'])[25]"));
    			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", communicateElement);
    		    System.out.println("Scrolled completely to the bottom of the page.");
    		} catch (Exception e) {
    		    System.err.println("An error occurred while scrolling: " + e.getMessage());
    		}
       
        // Click on the "Examinations" menu (3rd occurrence)
        driver.findElement(By.xpath("(//a[normalize-space()='Examinations'])[3]")).click();
        
        // Click on the "Rank Report" menu (1st occurrence)
        driver.findElement(By.xpath("(//a[normalize-space()='Rank Report'])[1]")).click();
        
      
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@id='select2-exam_group_id-container'])[1]")));
        dropdown.click();

        // Search in the dropdown textbox (if required)
        WebElement searchBox = driver.findElement(By.xpath("//input[@role='textbox']"));
        searchBox.sendKeys("John Doe");

        // Select the "John Doe" option
        driver.findElement(By.xpath("//li[contains(text(), 'John Doe')]")).click();

        // Print success message
        System.out.println("Successfully selected 'John Doe'!");
      
        
        WebElement classDropdown = driver.findElement(By.xpath("(//select[@id='class_id'])[1]"));
        Select selectClass = new Select(classDropdown);
        selectClass.selectByIndex(1);
        
        WebElement sectionDropdown = driver.findElement(By.xpath("(//select[@id='section_id'])[1]"));
        Select selectSection = new Select(sectionDropdown);
        selectSection.selectByIndex(1);
        
        // Click on the "Search" button
        driver.findElement(By.xpath("(//button[normalize-space()='Search'])[1]")).click();
        
        // Wait for results (Optional: Can use Explicit Wait if needed)
        Thread.sleep(3000);
        
        System.out.println("Test executed successfully!");
        
    
    

}
    @Test(priority = 5)

   	public void daily_attendance_report11() throws InterruptedException {
       	 try {
    		  WebElement communicateElement = driver.findElement(By.xpath("(//a[@href='#'])[25]"));
    			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", communicateElement);
    		    System.out.println("Scrolled completely to the bottom of the page.");
    		} catch (Exception e) {
    		    System.err.println("An error occurred while scrolling: " + e.getMessage());
    		}
       	 

    driver.findElement(By.xpath("(//a[normalize-space()='Online Examinations'])[3]")).click();

    // Click on 'Result Report'
    driver.findElement(By.xpath("(//a[normalize-space()='Result Report'])[1]")).click();

    // Click on the Exam dropdown
    driver.findElement(By.xpath("(//span[@id='select2-exam_id-container'])[1]")).click();

    // Wait for search box and enter the value
    WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@role='textbox']")));
    searchBox.sendKeys("444");

    // Wait and select the correct option
    WebElement option = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(text(), '444')]")));
    option.click();
    
    System.out.println("Successfully selected 'John Doe'!");

    // Select class and section
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//select[@id='class_id'])[1]"))).click();
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//select[@id='section_id'])[1]"))).click();

    // Click on search icon
    driver.findElement(By.xpath("(//i[@class='fa fa-search'])[5]")).click();

    // Wait for DataTables to load
    Thread.sleep(5000);

    // Check for error message
    if (driver.getPageSource().contains("DataTables warning")) {
        System.out.println("AJAX Error: DataTables failed to load.");
    } else {
        System.out.println("DataTables loaded successfully.");
    }
    WebElement examsReport = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[normalize-space()='Exams Report'])[1]")));
    examsReport.click();

    // Select a value from "search_type" dropdown
    Select searchTypeDropdown = new Select(wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//select[@name='search_type'])[1]"))));
    searchTypeDropdown.selectByIndex(1); // Selects the second option (Index starts from 0)

    // Select a value from "date_type" dropdown
    Select dateTypeDropdown = new Select(wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//select[@name='date_type'])[1]"))));
    dateTypeDropdown.selectByIndex(1); // Selects the second option

    // Click on the 5th search icon
    WebElement searchIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//i[@class='fa fa-search'])[5]")));
    searchIcon.click();

    // Wait for the table to appear
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='box-body table-responsive'])[1]")));

    // Click on "Student Exams Attempt Report"
    WebElement studentExamsReport = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[normalize-space()='Student Exams Attempt Report'])[1]")));
    studentExamsReport.click();

    // Select a value from "search_type" dropdown (again)
    Select searchTypeDropdown2 = new Select(wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//select[@name='search_type'])[1]"))));
    searchTypeDropdown2.selectByIndex(1);

    // Select a value from "date_type" dropdown (again)
    Select dateTypeDropdown2 = new Select(wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//select[@name='date_type'])[1]"))));
    dateTypeDropdown2.selectByIndex(1);

    // Click on "Search" button
    WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='Search'])[1]")));
    searchButton.click();

    // Click on "Exams Rank Report"
    WebElement examsRankReport = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[normalize-space()='Exams Rank Report'])[1]")));
    examsRankReport.click();

    // Click on the exam selection dropdown
    WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@id='select2-exam_id-container'])[1]")));
    dropdown.click();

    // Wait for the search box to appear and enter "444"
    WebElement searchBox1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@role='textbox']")));
    searchBox1.sendKeys("444");

    // Wait for the correct option to be clickable and select it
    WebElement option1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(text(), '444')]")));
    option1.click();

    System.out.println("Successfully selected '444'!");


}
    @Test(priority = 6)

   	public void daily_attendance_report111() throws InterruptedException {
       	 try {
    		  WebElement communicateElement = driver.findElement(By.xpath("(//a[@href='#'])[25]"));
    			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", communicateElement);
    		    System.out.println("Scrolled completely to the bottom of the page.");
    		} catch (Exception e) {
    		    System.err.println("An error occurred while scrolling: " + e.getMessage());
    		}
    WebElement lessonPlan = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[normalize-space()='Lesson Plan'])[3]")));
    lessonPlan.click();

    Select classDropdown = new Select(wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//select[@id='searchclassid'])[1]"))));
    classDropdown.selectByIndex(1); // Change index based on required option

    Select sectionDropdown = new Select(wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//select[@id='secid'])[1]"))));
    sectionDropdown.selectByIndex(1);

    Select subjectGroupDropdown = new Select(wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//select[@id='subject_group_id'])[1]"))));
    subjectGroupDropdown.selectByIndex(1);

    WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='Search'])[1]")));
    searchButton.click();

    WebElement resultBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='box-body'])[2]")));
    String resultText = resultBox.getText();

    System.out.println("Lesson Plan Search Results:");
    System.out.println(resultText);
    WebElement lessonPlanReport = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[normalize-space()='Subject Lesson Plan Report'])[1]")));
    lessonPlanReport.click();

    // Select a value from "Class" dropdown
    Select classDropdown1 = new Select(wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//select[@id='searchclassid'])[1]"))));
    classDropdown1.selectByIndex(1); // Change index based on required option

    // Select a value from "Section" dropdown
    Select sectionDropdown1 = new Select(wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//select[@id='secid'])[1]"))));
    sectionDropdown1.selectByIndex(1);

    // Select a value from "Subject Group" dropdown
    Select subjectGroupDropdown1 = new Select(wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//select[@id='subject_group_id'])[1]"))));
    subjectGroupDropdown1.selectByIndex(1);

    // Select a value from "Subject" dropdown
    Select subjectDropdown = new Select(wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//select[@id='subid'])[1]"))));
    subjectDropdown.selectByIndex(1);

    System.out.println("Successfully selected values from all dropdowns!");

    WebElement searchButton1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='Search'])[1]")));
    searchButton1.click();
}
    @Test(priority = 7)

   	public void daily_attendance_report1111() throws InterruptedException {
       	 try {
    		  WebElement communicateElement = driver.findElement(By.xpath("(//a[@href='#'])[25]"));
    			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", communicateElement);
    		    System.out.println("Scrolled completely to the bottom of the page.");
    		} catch (Exception e) {
    		    System.err.println("An error occurred while scrolling: " + e.getMessage());
    		}
       	 
       	WebElement humanResource = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[normalize-space()='Human Resource'])[3]")));
        humanResource.click();

        // Click on "Staff Report"
        WebElement staffReport = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[normalize-space()='Staff Report'])[1]")));
        staffReport.click();

        // Select a value from "Search Type" dropdown
        Select searchTypeDropdown = new Select(wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//select[@name='search_type'])[1]"))));
        searchTypeDropdown.selectByIndex(1); // Change index based on required option

        // Select a value from "Staff Status" dropdown
        Select staffStatusDropdown = new Select(wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//select[@name='staff_status'])[1]"))));
        staffStatusDropdown.selectByIndex(1);

        // Select a value from "Role" dropdown
        Select roleDropdown = new Select(wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//select[@name='role'])[1]"))));
        roleDropdown.selectByIndex(1);

        // Select a value from "Designation" dropdown
        Select designationDropdown = new Select(wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//select[@name='designation'])[1]"))));
        designationDropdown.selectByIndex(1);

        // Click on the "Search" button
        WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='Search'])[1]")));
        searchButton.click();

        // Wait for the result box to load and extract text
        WebElement resultBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='box-body table-responsive'])[1]")));
        String resultText = resultBox.getText();

        // Print the extracted text
        System.out.println("Staff Report Search Results:");
        System.out.println(resultText);
        
        WebElement payrollReport = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[normalize-space()='Payroll Report'])[1]")));
        payrollReport.click();

        // Select a value from "Year" dropdown
        Select yearDropdown = new Select(wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//select[@name='year'])[1]"))));
        yearDropdown.selectByIndex(1); // Change index based on required year

        // Click on the "Search" button
        WebElement searchButton1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='Search'])[1]")));
        searchButton1.click();

        // Wait for the result box to load and extract text
        WebElement resultBox1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='box-body table-responsive'])[1]")));
        String resultText1 = resultBox1.getText();

        // Print the extracted text
        System.out.println("Payroll Report Search Results:");
        System.out.println(resultText1);

  


    

}	
    
    
    @Test(priority = 8)

   	public void daily_attendance_report11111() throws InterruptedException {
       	 try {
    		  WebElement communicateElement = driver.findElement(By.xpath("(//a[@href='#'])[25]"));
    			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", communicateElement);
    		    System.out.println("Scrolled completely to the bottom of the page.");
    		} catch (Exception e) {
    		    System.err.println("An error occurred while scrolling: " + e.getMessage());
    		}
       	 driver.findElement(By.xpath("(//a[normalize-space()='Homework'])[3]")).click();
         driver.findElement(By.xpath("(//a[normalize-space()='Homework Report'])[1]")).click();

         // Select Class
         WebElement classDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//select[@id='searchclassid'])[1]")));
         new Select(classDropdown).selectByIndex(1);  // Selects second option (adjust if needed)

         // Click Search
         wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='Search'])[1]"))).click();

         // Wait for DataTables to Load
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='box-body table-responsive overflow-visible'])[1]")));

         System.out.println("Homework Report Loaded Successfully!");

         // Navigate to "Homework Evaluation Report"
         driver.findElement(By.xpath("(//a[normalize-space()='Homework Evaluation Report'])[1]")).click();

         // Select filters in Homework Evaluation Report
         new Select(wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//select[@id='searchclassid'])[1]")))).selectByIndex(1);
         new Select(wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//select[@id='secid'])[1]")))).selectByIndex(1);
         new Select(wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//select[@id='subject_group_id'])[1]")))).selectByIndex(1);
         new Select(wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//select[@id='subid'])[1]")))).selectByIndex(1);

         // Click Search
         wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='Search'])[1]"))).click();

         // Wait for DataTables to Load
         WebElement dataTable = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(@id, 'DataTables_Table_')])[1]")));
         
         // Print Table HTML
         System.out.println("Table Data: " + dataTable.getText());

       	 driver.findElement(By.xpath("         (//a[normalize-space()='Daily Assignment Report'])[1]")).click();
       	 
       	 



 }
    
    @Test(priority = 9)

   	public void daily_attendance_report111111() throws InterruptedException {
       	 try {
    		  WebElement communicateElement = driver.findElement(By.xpath("(//a[@href='#'])[25]"));
    			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", communicateElement);
    		    System.out.println("Scrolled completely to the bottom of the page.");
    		} catch (Exception e) {
    		    System.err.println("An error occurred while scrolling: " + e.getMessage());
    		}
       	 driver.findElement(By.xpath("    (//a[normalize-space()='Library'])[3]")).click();

       	driver.findElement(By.xpath("(//a[normalize-space()='Book Issue Report'])[1]")).click();

        // Select "search_type"
        WebElement searchTypeDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//select[@name='search_type'])[1]")));
        new Select(searchTypeDropdown).selectByIndex(1);

        // Click Search
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='Search'])[1]"))).click();

        // Wait for and print report data
        WebElement bookIssueReport = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='box-body table-responsive'])[1]")));
        System.out.println("Book Issue Report Data:\n" + bookIssueReport.getText());

        // Navigate to "Book Due Report"
        driver.findElement(By.xpath("(//a[normalize-space()='Book Due Report'])[1]")).click();

        // Select "search_type" for Book Due Report
        WebElement dueSearchTypeDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//select[@name='search_type'])[1]")));
        new Select(dueSearchTypeDropdown).selectByIndex(1);

        // Click Search
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='Search'])[1]"))).click();

      

        // Navigate to "Book Inventory Report"
        driver.findElement(By.xpath("(//a[normalize-space()='Book Inventory Report'])[1]")).click();

        // Select "search_type"
        WebElement inventorySearchTypeDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//select[@name='search_type'])[1]")));
        new Select(inventorySearchTypeDropdown).selectByIndex(1);

        // Click Search
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='Search'])[1]"))).click();

        // Wait for and print report data
      
        // Navigate to "Book Issue Return Report"
        driver.findElement(By.xpath("(//a[normalize-space()='Book Issue Return Report'])[1]")).click();

        // Select "search_type"
        WebElement returnSearchTypeDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//select[@name='search_type'])[1]")));
        new Select(returnSearchTypeDropdown).selectByIndex(1);

        // Click Search
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='Search'])[1]"))).click();

     
       

    }
    
    @Test(priority = 10)

   	public void daily_attendance_report1111111() throws InterruptedException {
       	 try {
    		  WebElement communicateElement = driver.findElement(By.xpath("(//a[@href='#'])[25]"));
    			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", communicateElement);
    		    System.out.println("Scrolled completely to the bottom of the page.");
    		} catch (Exception e) {
    		    System.err.println("An error occurred while scrolling: " + e.getMessage());
    		}
    
    driver.findElement(By.xpath("(//a[normalize-space()='Inventory'])[3]")).click();

    // Navigate to "Stock Report"
    driver.findElement(By.xpath("(//a[normalize-space()='Stock Report'])[1]")).click();

    // Select "search_type"
    WebElement stockSearchTypeDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//select[@name='search_type'])[1]")));
    new Select(stockSearchTypeDropdown).selectByIndex(1);

    // Click Search
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='Search'])[1]"))).click();

    // Wait for and print report data
    WebElement stockReport = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='box-body'])[1]")));
    System.out.println("Stock Report Data:\n" + stockReport.getText());

    // Navigate to "Add Item Report"
    driver.findElement(By.xpath("(//a[normalize-space()='Add Item Report'])[1]")).click();

    // Select "search_type"
    WebElement addItemSearchTypeDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//select[@name='search_type'])[1]")));
    new Select(addItemSearchTypeDropdown).selectByIndex(1);

    // Click Search
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='Search'])[1]"))).click();

    // Wait for and print report data
    WebElement addItemReport = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='box-body'])[1]")));
    System.out.println("Add Item Report Data:\n" + addItemReport.getText());

    // Navigate to "Issue Item Report"
    driver.findElement(By.xpath("(//a[normalize-space()='Issue Item Report'])[1]")).click();

    // Select "search_type"
    WebElement issueItemSearchTypeDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//select[@name='search_type'])[1]")));
    new Select(issueItemSearchTypeDropdown).selectByIndex(1);

    // Click Search
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='Search'])[1]"))).click();

    // Wait for and print report data
    WebElement issueItemReport = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='box-body'])[1]")));
    System.out.println("Issue Item Report Data:\n" + issueItemReport.getText());

}
    @Test(priority = 11)

   	public void daily_attendance_report11111111() throws InterruptedException {
       	 try {
    		  WebElement communicateElement = driver.findElement(By.xpath("(//a[@href='#'])[25]"));
    			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", communicateElement);
    		    System.out.println("Scrolled completely to the bottom of the page.");
    		} catch (Exception e) {
    		    System.err.println("An error occurred while scrolling: " + e.getMessage());
    		}
         driver.findElement(By.xpath("    (//a[normalize-space()='Transport'])[3]")).click();
         WebElement classDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//select[@id='class_id'])[1]")));
         new Select(classDropdown).selectByIndex(1); // Adjust index if needed

         // Select "Section"
         WebElement sectionDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//select[@id='section_id'])[1]")));
         new Select(sectionDropdown).selectByIndex(1); // Adjust index if needed

         // Wait for the DataTable to Load
         WebElement dataTable = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@id='DataTables_Table_0_wrapper'])[1]")));

         // Print Table Data
         System.out.println("Table Data:\n" + dataTable.getText());

    
    }
    

    @Test(priority = 12)

   	public void daily_attendance_report111111111() throws InterruptedException {
    
    	try {
  		  WebElement communicateElement = driver.findElement(By.xpath("(//a[@href='#'])[30]"));
  			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", communicateElement);
  		    System.out.println("Scrolled completely to the bottom of the page.");
  		} catch (Exception e) {
  		    System.err.println("An error occurred while scrolling: " + e.getMessage());
  		}
        driver.findElement(By.xpath("(//a[normalize-space()='Hostel'])[5]")).click();


    // Select "Class"
    WebElement classDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//select[@id='class_id'])[1]")));
    new Select(classDropdown).selectByIndex(1); // Adjust index if needed

    // Select "Section"
    WebElement sectionDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//select[@id='section_id'])[1]")));
    new Select(sectionDropdown).selectByIndex(1); // Adjust index if needed

    // Wait for the Data Table to Load
    WebElement dataTable = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='box-body table-responsive'])[1]")));

    // Print Table Data
    System.out.println("Table Data:\n" + dataTable.getText());
    
}
    
    @Test(priority = 13)

   	public void daily_attendance_report1111111111() throws InterruptedException {
    
    	try {
  		  WebElement communicateElement = driver.findElement(By.xpath("(//a[@href='#'])[30]"));
  			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", communicateElement);
  		    System.out.println("Scrolled completely to the bottom of the page.");
  		} catch (Exception e) {
  		    System.err.println("An error occurred while scrolling: " + e.getMessage());
  		}
        driver.findElement(By.xpath("(//a[normalize-space()='Alumni'])[3]")).click();

    // Select "Session"
    WebElement sessionDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//select[@id='session_id'])[1]")));
    new Select(sessionDropdown).selectByIndex(1); // Adjust index if needed

    // Select "Class"
    WebElement classDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//select[@id='class_id'])[1]")));
    new Select(classDropdown).selectByIndex(1); // Adjust index if needed

    // Click Search Button
    WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='Search'])[1]")));
    searchButton.click();

    // Wait for the Data Table to Load
    WebElement dataTable = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@id='DataTables_Table_0_wrapper'])[1]")));

    // Print Table Data
    System.out.println("Alumni Report Data:\n" + dataTable.getText());
    }
    @Test(priority = 14)

   	public void daily_attendance_report11111111111() throws InterruptedException {
    
    	try {
  		  WebElement communicateElement = driver.findElement(By.xpath("(//a[@href='#'])[30]"));
  			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", communicateElement);
  		    System.out.println("Scrolled completely to the bottom of the page.");
  		} catch (Exception e) {
  		    System.err.println("An error occurred while scrolling: " + e.getMessage());
  		}
        driver.findElement(By.xpath("    	(//a[normalize-space()='User Log'])[2]")).click();

    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[normalize-space()='All Users'])[1]"))).click();
    System.out.println("Navigated to 'All Users'");

    // Wait for tab content to load
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='tab-content'])[1]")));

    // Navigate to "Staff"
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[normalize-space()='Staff'])[1]"))).click();
    System.out.println("Navigated to 'Staff'");

    // Wait for content to load
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='tab-content'])[1]")));

    // Navigate to "Students"
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[normalize-space()='Students'])[1]"))).click();
    System.out.println("Navigated to 'Students'");

    // Wait for content to load
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='tab-content'])[1]")));

    // Navigate to "Parents"
    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[normalize-space()='Parent'])[1]"))).click();
    System.out.println("Navigated to 'Parents'");

    // Wait for content to load
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='tab-content'])[1]")));

   
}

    @Test(priority = 15)

   	public void daily_attendance_report111111111111() throws InterruptedException {
    
    	try {
  		  WebElement communicateElement = driver.findElement(By.xpath("(//a[@href='#'])[30]"));
  			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", communicateElement);
  		    System.out.println("Scrolled completely to the bottom of the page.");
  		} catch (Exception e) {
  		    System.err.println("An error occurred while scrolling: " + e.getMessage());
  		}  
    
     // Click on "Audit Trail Report"
    WebElement auditTrailLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[normalize-space()='Audit Trail Report'])[2]")));
    auditTrailLink.click();

    // Wait for the 83rd <div> to be visible
    WebElement auditTrailData = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div)[83]")));

    // Print Audit Trail Data
    System.out.println("Audit Trail Report Data:\n" + auditTrailData.getText());
    
}
}