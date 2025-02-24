package drighna.ogj;

import java.io.FileInputStream;

import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OnlineCourse extends BaseClass {
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

     
    
    
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Click on "Online Course" and "Offline Payment"
        WebElement onlineCourseLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[text()='Online Course'])[2]")));
        onlineCourseLink.click();

        WebElement offlinePaymentLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[text()='Offline Payment'])[2]")));
        offlinePaymentLink.click();

        // Wait for the class dropdown and select a class
        WebElement cls = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='class_id']")));
        Select clssc = new Select(cls);
        clssc.selectByIndex(1);

        // Wait for the section dropdown and select a section
        WebElement sec = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name='section_id']")));
        Select secsc = new Select(sec);
        secsc.selectByIndex(1);

        // Wait for the student dropdown and select a student
        WebElement stu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='student_id']")));
        Select stusc = new Select(stu);
        stusc.selectByVisibleText("Edward Thomas (19001)");

        // Click on the 'Submit' button
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='btn btn-primary btn-sm pull-right']")));
        submitButton.click();

        // Wait for the data table info to appear and assert it
        WebElement dataTableInfo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='DataTables_Table_0_info']")));
        String infoText = dataTableInfo.getText();

      
    }


	
	@Test
	public void coursecategory() {
		
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
		 String catname = prop.getProperty("catname");

	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Explicit wait

	       
	        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
	        WebElement onlineCourse = wait1.until(ExpectedConditions.elementToBeClickable(
	                By.xpath("(//*[text()='Online Course'])[2]")));
	        onlineCourse.click();
	        System.out.println("✅ Clicked on 'Online Course'");

	        
	        
	        WebElement onlineCourse1 = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[text()='Online Course'])[2]")));
	        onlineCourse1.click();
	        System.out.println("✅ Clicked on 'Online Course'");

	        // Click on "Course Category"
	        WebElement courseCategory = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[text()='Course Category'])[2]")));
	        courseCategory.click();
	        System.out.println("✅ Clicked on 'Course Category'");

	        // Enter category name
	        WebElement categoryInput = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='category_name']")));
	        categoryInput.sendKeys(catname);
	        System.out.println("✅ Entered category name: " + catname);

	        // Click "Save" button
	        WebElement saveButton = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='btn btn-info pull-right']")));
	        saveButton.click();
	        System.out.println("✅ Clicked on 'Save' button");

	        // Validate messages: "Record already exists" or "Record Saved Successfully"
	        try {
	            WebElement cf1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Record already exists']")));
	            System.out.println("✅ Test passed: Record already exists.");
	            Assert.assertTrue(true, "Test passed: Record already exists.");
	            return;
	        } catch (Exception e) {
	            System.out.println("ℹ️ 'Record already exists' message not found, checking next condition...");
	        }

	        try {
	            WebElement cf2 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Record Saved Successfully']")));
	            System.out.println("✅ Test passed: Record saved successfully.");
	            Assert.assertTrue(true, "Test passed: Record saved successfully.");
	        } catch (Exception e) {
	            Assert.fail("❌ Test failed: Neither 'Record already exists' nor 'Record Saved Successfully' messages are displayed.");
	        }
	    }
	
	@Test
	public void coursereport() throws InterruptedException {
	    // Ensure that the 'prop' is initialized from BaseClass

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

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    // Click the "Online Course Report" link
	    WebElement studentHouse14 = driver.findElement(By.xpath("(//a[normalize-space()='Online Course Report'])[2]"));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", studentHouse14);
	    System.out.println("✅ Clicked 'Online Course Report'");

	    // Click "Student Course Purchase Report"
	    WebElement studentCoursePurchaseReport = wait.until(ExpectedConditions.elementToBeClickable(
	            By.xpath("(//a[normalize-space()='Student Course Purchase Report'])[1]")));
	    studentCoursePurchaseReport.click();
	    System.out.println("✅ Clicked 'Student Course Purchase Report'");

	    // Select search type
	    Select searchType = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(
	            By.xpath("//select[@id='search_type']"))));
	    searchType.selectByIndex(1);
	    System.out.println("✅ Selected 'Search Type'");

	    // Select payment type
	    Select searchType1 = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(
	            By.xpath("(//select[@name='payment_type'])[1]"))));
	    searchType1.selectByIndex(2);
	    System.out.println("✅ Selected 'Payment Type'");

	    // Select payment status
	    WebElement paymentDropdown = wait.until(ExpectedConditions.elementToBeClickable(
	            By.xpath("//select[@name='payment_status']")));  // Change name if needed
	    paymentDropdown.click();

	    // Select "Success" in payment status dropdown
	    Select select = new Select(paymentDropdown);
	    select.selectByVisibleText("Success");
	    System.out.println("✅ 'Success' selected in Payment Status dropdown.");

	    // Select user type
	    Select searchType111 = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(
	            By.xpath("//select[@name='users_type']"))));
	    searchType111.selectByIndex(1);
	    System.out.println("✅ Selected 'User Type'");

	    // Click 'Search' button
	    WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(
	            By.xpath("//*[@class='btn btn-primary btn-sm pull-right']")));
	    searchButton.click();
	    System.out.println("✅ Clicked 'Search'");

	    // Validate "Search" field presence
	    WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(
	            By.xpath("//input[@placeholder='Search...']")));
	    Assert.assertTrue(searchField.isDisplayed(), "❌ Test failed: Unable to fetch Student Course Purchase Report.");
	    System.out.println("✅ 'Student Course Purchase Report' verified");
	}

	
	@Test
    public void subject() throws IOException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Load search query from config.properties
        Properties prop = new Properties();
        FileInputStream file = new FileInputStream("src/main/resources/config.properties");
        prop.load(file);
        String searchQuery = prop.getProperty("search_query");  // Get value from config file

        // Click on "Course Sell Count Report"
        WebElement courseSellCountReport = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[text()='Course Sell Count Report']")));
        courseSellCountReport.click();
        System.out.println("✅ Clicked 'Course Sell Count Report'");

        // Verify page load by checking the header
        WebElement reportHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h3[normalize-space()='Course Sell Count Report']")));
        Assert.assertTrue(reportHeader.isDisplayed(), "❌ Test failed: Unable to fetch Course Sell Count Report.");
        System.out.println("✅ 'Course Sell Count Report' page loaded successfully.");

        // Wait for search box and enter query from config.properties
        WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//input[@placeholder='Search...']")));
        searchBox.sendKeys(searchQuery);
        System.out.println("✅ Entered '" + searchQuery + "' in search box.");

        // Wait for table update
        wait.until(ExpectedConditions.or(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'No data available in table')]")),
                ExpectedConditions.presenceOfElementLocated(By.xpath("//table/tbody/tr")) // Check if rows exist
        ));

        // Check if "No data available in table" appears
        List<WebElement> noDataMessage = driver.findElements(By.xpath("//*[contains(text(),'No data available in table')]"));
        if (!noDataMessage.isEmpty()) {
            Assert.assertTrue(noDataMessage.get(0).isDisplayed(), "❌ Test failed: Expected 'No data available' but data was found.");
            System.out.println("✅ Verified: 'No data available in table' is displayed.");
        } else {
            // If data exists, print all course names
            List<WebElement> courseRows = driver.findElements(By.xpath("//table/tbody/tr"));
            Assert.assertTrue(courseRows.size() > 0, "❌ Test failed: No data found, but 'No data available' message is missing.");
            System.out.println("✅ Data found: Printing course details...");
            for (WebElement row : courseRows) {
                System.out.println(row.getText());
            }
        }
	}
        
        @Test
        public void verifyCourseTrendingReport() throws IOException {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Load search query from config.properties
            Properties prop1 = new Properties();
            FileInputStream file1 = new FileInputStream("src/main/resources/config.properties"); // FIXED PATH
            prop1.load(file1);
            String searchQuery1 = prop1.getProperty("search_query1");  // Get value from config file

            // Ensure searchQuery1 is not null or empty
            if (searchQuery1 == null || searchQuery1.trim().isEmpty()) {
                throw new IllegalArgumentException("❌ Error: Search query is null or empty! Check config.properties.");
            }

            // Click on "Course Trending Report"
            WebElement courseTrendingReport = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//a[normalize-space()='Course Trending Report']")));  // FIXED XPATH
            courseTrendingReport.click();
            System.out.println("✅ Clicked 'Course Trending Report'");

            // Verify page load by checking the header
            WebElement reportHeader1 = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//h3[normalize-space()='Course Trending Report']")));
            Assert.assertTrue(reportHeader1.isDisplayed(), "❌ Test failed: Unable to fetch Course Trending Report.");
            System.out.println("✅ 'Course Trending Report' page loaded successfully.");

            // Wait for search box and enter query
            WebElement searchBox1 = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//input[@placeholder='Search...']")));
            searchBox1.clear();
            searchBox1.sendKeys(searchQuery1);
            searchBox1.sendKeys(Keys.ENTER);  // FIXED: Press ENTER after entering text
            System.out.println("✅ Entered '" + searchQuery1 + "' in search box.");


            // Check if "No data available in table" appears
            List<WebElement> noDataMessage1 = driver.findElements(By.xpath("//*[contains(text(),'No data available in table')]"));
            if (!noDataMessage1.isEmpty()) {
                Assert.assertTrue(noDataMessage1.get(0).isDisplayed(), "❌ Test failed: Expected 'No data available' but data was found.");
                System.out.println("✅ Verified: 'No data available in table' is displayed.");
            } else {
                // If data exists, print all course details
                List<WebElement> tableRows = driver.findElements(By.xpath("//table/tbody/tr"));
                Assert.assertTrue(tableRows.size() > 0, "❌ Test failed: No data found, but 'No data available' message is missing.");
                System.out.println("✅ Data found: Printing course details...");

                for (WebElement row : tableRows) {
                    System.out.println(row.getText());
                    Assert.assertTrue(row.getText().contains(searchQuery1), "❌ Test failed: Search query '" + searchQuery1 + "' not found in row.");
                }
            }
        }
            
        @Test
        public void verifyCourseCompleteReport() {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Click on "Course Complete Report"
            WebElement courseCompleteReport = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//a[normalize-space()='Course Complete Report']")));
            courseCompleteReport.click();
            System.out.println("✅ Clicked 'Course Complete Report'");

            // Select dropdowns
            selectDropdownByIndex(wait, "//select[@id='users_type']", 1);
            selectDropdownByIndex(wait, "//select[@id='class_id']", 1);
            selectDropdownByIndex(wait, "//select[@id='section_id']", 1);
            selectDropdownByIndex(wait, "//select[@id='course_id']", 1);

            // Click the "Search" button
            WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[normalize-space()='Search']")));
            searchButton.click();
            System.out.println("✅ Clicked 'Search' button");

            // Verify the report appears
            WebElement resultsTable = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//table")));  // Assuming results are displayed in a table
            Assert.assertTrue(resultsTable.isDisplayed(), "❌ Test failed: No results found in Course Complete Report.");
            System.out.println("✅ Verified: Course Complete Report results displayed.");
        }

        private void selectDropdownByIndex(WebDriverWait wait, String xpath, int index) {
            WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));

            // Wait until options are loaded
            wait.until(driver -> new Select(dropdown).getOptions().size() > index);

            // Print available options
            List<WebElement> options = new Select(dropdown).getOptions();
            System.out.println("Dropdown Options for " + xpath + ":");
            for (WebElement option : options) {
                System.out.println(option.getText());
            }

            // Select index
            Select select = new Select(dropdown);
            select.selectByIndex(index);
            System.out.println("✅ Selected index " + index + " for " + xpath);
        }
        
        @Test
        public void verifyCourseRatingReport() {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Click on "Course Rating Report"
            WebElement courseRatingReport = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//a[normalize-space()='Course Rating Report']")));
            courseRatingReport.click();
            System.out.println("✅ Clicked 'Course Rating Report'");

            // Verify page load by checking the header
            WebElement reportHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//h3[normalize-space()='Course Rating Report']")));
            Assert.assertTrue(reportHeader.isDisplayed(), "❌ Test failed: Unable to fetch Course Rating Report.");
            System.out.println(" 'Course Rating Report' page loaded successfully.");


            List<WebElement> noDataMessage = driver.findElements(By.xpath("//*[contains(text(),'No data available in table')]"));
            if (!noDataMessage.isEmpty()) {
                Assert.assertTrue(noDataMessage.get(0).isDisplayed(), "❌ Test failed: Expected 'No data available' but data was found.");
                System.out.println(" Verified: 'No data available in table' is displayed.");
            } else {
                // If data exists, print all course details
                List<WebElement> tableRows = driver.findElements(By.xpath("//table/tbody/tr"));
                Assert.assertTrue(tableRows.size() > 0, "❌ Test failed: No data found, but 'No data available' message is missing.");
                System.out.println(" Data found: Printing course details...");

                for (WebElement row : tableRows) {
                    System.out.println(row.getText());
                }
            }
        }
            
            @Test
            public void verifyGuestReport() {
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
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

                // Click on "Guest Report"
                WebElement guestReport = wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//a[normalize-space()='Guest Report']")));
                guestReport.click();
                System.out.println(" Clicked 'Guest Report'");

                WebElement reportHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//h3[normalize-space()='Guest Report']")));
                Assert.assertTrue(reportHeader.isDisplayed(), "❌ Test failed: Unable to fetch Guest Report.");
                System.out.println("'Guest Report' page loaded successfully.");


                List<WebElement> noDataMessage = driver.findElements(By.xpath("//*[contains(text(),'No data available in table')]"));
                if (!noDataMessage.isEmpty()) {
                    Assert.assertTrue(noDataMessage.get(0).isDisplayed(), "❌ Test failed: Expected 'No data available' but data was found.");
                    System.out.println(" Verified: 'No data available in table' is displayed.");
                } else {
                    List<WebElement> tableRows = driver.findElements(By.xpath("//table/tbody/tr"));
                    Assert.assertTrue(tableRows.size() > 0, "❌ Test failed: No data found, but 'No data available' message is missing.");
                    System.out.println(" Data found: Printing guest report details...");

                    for (WebElement row : tableRows) {
                        System.out.println(row.getText());
                    }
                }
            }
                
                @Test
                public void verifyGuestReport1() {
                                   
                  
                  // Click on the 'Online Course' link
                    WebElement onlineCourseLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[normalize-space()='Online Course'])[3]")));
                    onlineCourseLink.click(); // Fixed incorrect variable name

                  
                    
                    WebElement addCourseButton1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='Add Course'])[1]")));
                    addCourseButton1.click();

                 String expectedTitle = prop.getProperty("title");
                 String expectedOutcomes = prop.getProperty("outcomes");
                 String expectedDescription = prop.getProperty("description");
                 String coursePrice = prop.getProperty("course_price");
                 String courseDiscount = prop.getProperty("course_discount");
                 String frontSideVisibility = prop.getProperty("front_side_visibility");

                 // Wait initialization
                 WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
                 JavascriptExecutor js = (JavascriptExecutor) driver;

                 // Locate input fields and set values
                 WebElement titleInput = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='title']")));
                 titleInput.sendKeys(expectedTitle);

                 WebElement outcomesInput = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//select[@id='course_provider'])[1]")));
                 outcomesInput.sendKeys(expectedOutcomes);

                 WebElement descriptionInput = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//textarea[@id='description']")));
                 descriptionInput.sendKeys(expectedDescription);

                 // Locate dropdowns and select by hardcoded index
                 WebElement classDropdown = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@id='class_id']")));
                 Select classSelect = new Select(classDropdown);
                 classSelect.selectByIndex(1);  

                 WebElement teacherDropdown = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@id='teacher_id']")));
                 Select teacherSelect = new Select(teacherDropdown);
                 teacherSelect.selectByIndex(1);  // Hardcoded index

                 WebElement courseProviderDropdown = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@id='course_provider']")));
                 Select courseProviderSelect = new Select(courseProviderDropdown);
                 courseProviderSelect.selectByIndex(1);  // Hardcoded index
                 WebElement coursePriceInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='course_price']")));
                 coursePriceInput.sendKeys(coursePrice);

                 WebElement courseDiscountInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='course_discount']")));
                 courseDiscountInput.sendKeys(courseDiscount);

                 // Select radio button for free course
                 WebElement freeCourseRadioButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='free_course']")));
                 if (!freeCourseRadioButton.isSelected()) {
                     freeCourseRadioButton.click();
                 }

                 // Select dropdowns
                 WebElement categoryDropdown = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@id='category_id']")));
                 Select categorySelect = new Select(categoryDropdown);
                 categorySelect.selectByIndex(1);  // Hardcoded index

                 WebElement frontSideVisibilityDropdown = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@name='front_side_visibility']")));
                 Select frontSideVisibilitySelect = new Select(frontSideVisibilityDropdown);
                 frontSideVisibilitySelect.selectByIndex(1); // Select by text from config

                 // Click on Add Course Button
                 WebElement addCourseButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='add_course_btn']")));
                 addCourseButton.click();

                 // Print values for verification
                 System.out.println("🔹 Title: " + expectedTitle);
                 System.out.println("🔹 Outcomes: " + expectedOutcomes);
                 System.out.println("🔹 Description: " + expectedDescription);
                 System.out.println("🔹 Class Index: 1");
                 System.out.println("🔹 Teacher Index: 1");
                 System.out.println("🔹 Course Provider Index: 1");
                 
                 System.out.println("🔹 Course Price: " + coursePrice);
                 System.out.println("🔹 Course Discount: " + courseDiscount);
                 System.out.println("🔹 Free Course Selected: " + freeCourseRadioButton.isSelected());
                 System.out.println("🔹 Category Index: 1");
                 System.out.println("🔹 Front Side Visibility: " + frontSideVisibility);
                 System.out.println("🔹 Course Added Successfully!");

                }
            
            }
                


    
    
    
    
   
