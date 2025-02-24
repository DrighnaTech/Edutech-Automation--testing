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
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class Attendance extends BaseClass {
    private Properties prop;
    private WebDriverWait wait;

    @BeforeClass  
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

  
    public void dashboard() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // ✅ Verify login success
        if (driver.findElements(By.xpath("//span[normalize-space()='Dashboard']")).size() > 0) {
            System.out.println("✅ Login successful!");
        } else {
            System.out.println("❌ Error: Login failed. Check credentials.");
            return;
        }

        try {
            WebElement studentInfo = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Student Information']")));
            studentInfo.click();
            System.out.println("Clicked 'Student Information'");

            WebElement studentDetails = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Student Details']")));
            studentDetails.click();
            System.out.println("Clicked 'Student Details'");
            if (driver.findElements(By.xpath("//select[@id='class_id']")).size() == 0) {
                System.out.println("Error: Failed to navigate to 'Student Details' page.");
                return;
            }

            WebElement classDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='class_id']")));
            Select classSelect = new Select(classDropdown);
            classSelect.selectByVisibleText("Class 1");
            System.out.println("Selected 'Class 1'");

            WebElement sectionDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='section_id']")));
            Select sectionSelect = new Select(sectionDropdown);
            sectionSelect.selectByVisibleText("A");
            System.out.println(" Selected 'Section A'");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    public void fill() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String religionValue = prop.getProperty("religion12100");
        String casteValue = prop.getProperty("caste12100");
        String mobileNoValue = prop.getProperty("mobileno12100");
        String emailValue = prop.getProperty("email12100");
        try {
            WebElement Studentad = driver.findElement(By.xpath("//a[normalize-space()='Student Admission']"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", Studentad);

            String admissionNumber = prop.getProperty("admission_no100");
            String rollNumber = prop.getProperty("roll_no100");

            WebElement admissionNo = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='admission_no']")));
            admissionNo.sendKeys(admissionNumber);

            WebElement rollNo = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='roll_no']")));
            rollNo.sendKeys(rollNumber);

            WebElement classDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='class_id']")));
            Select classSelect = new Select(classDropdown);
            classSelect.selectByVisibleText("Class 1");

            WebElement sectionDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='section_id']")));
            Select sectionSelect = new Select(sectionDropdown);
            sectionSelect.selectByVisibleText("A");

            String firstNameValue = prop.getProperty("firstname34100");
            String lastNameValue = prop.getProperty("lastname34100");

            WebElement firstName = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='firstname']")));
            firstName.sendKeys(firstNameValue);

            WebElement lastName = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='lastname']")));
            lastName.sendKeys(lastNameValue);


            WebElement genderDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@name='gender']")));
            Select genderSelect = new Select(genderDropdown);
            genderSelect.selectByVisibleText("Male");

            WebElement dobField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='dob']")));
            dobField.click();
            WebElement dobSelect = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[normalize-space()='13']")));
            dobSelect.click();

            WebElement categoryDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='category_id']")));
            Select categorySelect = new Select(categoryDropdown);
            categorySelect.selectByIndex(1);

            

            WebElement religion = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='religion'])[1]")));
            religion.sendKeys(religionValue);

            WebElement caste = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='cast'])[1]")));
            caste.sendKeys(casteValue);

            WebElement mobileNo = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='mobileno'])[1]")));
            mobileNo.sendKeys(mobileNoValue);

            WebElement email = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='email'])[1]")));
            email.sendKeys(emailValue);


            WebElement dobField1 = wait.until(ExpectedConditions.elementToBeClickable(By.id("dob")));
            dobField1.click();

            // Wait for the specific date (14th) to be clickable and select it
            WebElement dateSelect = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//td[normalize-space()='14'])[1]")));
            dateSelect.click();

            // Scroll down to the end of the page (optional)
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        

            WebElement bloodGroupDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//select[@name='blood_group'])[1]")));
            Select bloodGroupSelect = new Select(bloodGroupDropdown);
            bloodGroupSelect.selectByVisibleText("O+");

            WebElement houseDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//select[@name='house'])[1]")));
            Select houseSelect = new Select(houseDropdown);
            houseSelect.selectByVisibleText("The Red House");
            
            JavascriptExecutor js1 = (JavascriptExecutor) driver;
            js1.executeScript("window.scrollTo(0, document.body.scrollHeight);");
            WebElement addLoaderButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(" (//input[@value='father'])[1]")));
            addLoaderButton.click();
            
           
         // Fetch values from properties file
            String guardianNameValue = prop.getProperty("guardian_name100");
            String guardianPhoneValue = prop.getProperty("guardian_phone100");
            JavascriptExecutor js11 = (JavascriptExecutor) driver;
            
            js11.executeScript("window.scrollTo(0, document.body.scrollHeight);");
            WebElement guardianName = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='guardian_name'])[1]")));
            guardianName.sendKeys(guardianNameValue);
            JavascriptExecutor js111 = (JavascriptExecutor) driver;
            js111.executeScript("window.scrollTo(0, document.body.scrollHeight);");
            WebElement guardianPhone = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='guardian_phone'])[1]")));
            guardianPhone.sendKeys(guardianPhoneValue);


            System.out.println("Student Admission Form Filled Successfully!");

            WebElement addLoaderButton1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@id='addloader'])[1]")));
            addLoaderButton1.click();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

            
            
            @Test
            public void fill1() throws InterruptedException {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

                WebElement disabledStudentsLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[normalize-space()='Disabled Students'])[2]")));
                disabledStudentsLink.click();
                System.out.println("Navigated to 'Disabled Students' page");

                WebElement classDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='class_id']")));
                Select classSelect = new Select(classDropdown);
                classSelect.selectByIndex(1);  

                WebElement sectionDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='section_id']")));
                Select sectionSelect = new Select(sectionDropdown);
                sectionSelect.selectByIndex(1);  

                WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@value='search_filter']")));
                searchButton.click();

                System.out.println("Test Passed: Disabled students in class1 and section A are displayed.");
            }

            
            @Test
            public void fill12() throws InterruptedException {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            	WebElement MultiClassStudent  = driver.findElement(By.xpath("(//a[normalize-space()='Multi Class Student'])"));
            	((JavascriptExecutor) driver).executeScript("arguments[0].click();", MultiClassStudent );
            	
            	  WebElement classDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='class_id']")));
                  Select classSelect = new Select(classDropdown);
                  classSelect.selectByIndex(1);

                  WebElement sectionDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='section_id']")));
                  Select sectionSelect = new Select(sectionDropdown);
                  sectionSelect.selectByIndex(1);
                  
               
                  WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Search']")));
                  searchButton.click();
            }
            
            @Test
            public void fill123() throws InterruptedException {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            	WebElement BulkStudent   = driver.findElement(By.xpath("(//a[normalize-space()='Bulk Delete'])"));
            	((JavascriptExecutor) driver).executeScript("arguments[0].click();", BulkStudent );
            	
            	  WebElement classDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='class_id']")));
                  Select classSelect = new Select(classDropdown);
                  classSelect.selectByIndex(1);

                  WebElement sectionDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='section_id']")));
                  Select sectionSelect = new Select(sectionDropdown);
                  sectionSelect.selectByIndex(1);
                  
                

                  WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Search']")));
                  searchButton.click();
            }
            
            @Test
            public void fill1234() throws InterruptedException {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            	WebElement studentCategory = new WebDriverWait(driver, Duration.ofSeconds(10))
            	   .until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[normalize-space()='Student Categories'])[2]")));

            	((JavascriptExecutor) driver).executeScript("arguments[0].click();", studentCategory);
        	
            	String categoryValue = prop.getProperty("category134");

            	WebElement categoryInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='category']")));
            	categoryInput.sendKeys(categoryValue);


            // Locate the button and click it
            WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-info pull-right']")));
            searchButton.click();
            
        	
}
            
            @Test
            public void fill12345() throws InterruptedException {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        	WebElement Studenthouse   = driver.findElement(By.xpath("(//a[normalize-space()='Student House'])"));
        	((JavascriptExecutor) driver).executeScript("arguments[0].click();", Studenthouse );
        	
        	
        	
        	String houseNameValue = prop.getProperty("house_name117");
        	String descriptionValue = prop.getProperty("description117");

        	// Locate and enter 'house_name'
        	WebElement categoryInput1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='house_name']")));
        	categoryInput1.sendKeys(houseNameValue);

        	// Locate and enter 'description'
        	WebElement description1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='description']")));
        	description1.sendKeys(descriptionValue);

            
            WebElement searchButton1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-info pull-right']")));
            searchButton1.click();
            }
            
            

            @Test
            public void fill123456() throws InterruptedException {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        	WebElement Studenthouse1  = driver.findElement(By.xpath("(//a[normalize-space()='Disable Reason'])"));
        	((JavascriptExecutor) driver).executeScript("arguments[0].click();", Studenthouse1 );
        	

        	String nameValue = prop.getProperty("name");

        	WebElement nameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='name']")));
        	nameInput.sendKeys(nameValue);

        	WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-info pull-right']")));
        	submitButton.click();


            }
            @AfterClass
            public void tearDown() {
                // Close the browser
                if (driver != null) {
                    driver.quit();
                }
            }
}


        
                



