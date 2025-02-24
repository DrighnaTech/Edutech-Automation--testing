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


		
		

public class HR extends BaseClass {
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
            WebElement linkElement7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@href='#'])[24]")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", linkElement7);
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 200);");

            System.out.println("Located the 7th <a> element and scrolled down slightly.");
        } catch (Exception e) {
            System.err.println("An error occurred in clickAngleLeftButton (7th <a>): " + e.getMessage());
        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@href='#'])[24]")));
        link.click();
      
        		
        		   
                WebElement link1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(" (//a[normalize-space()='Staff Directory'])[2]")));
                link1.click();
                
                WebElement classDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("  (//select[@name='role'])[1]")));
    	        new Select(classDropdown).selectByIndex(1); // Change index as needed
    	        
    	 	   
                WebElement link11 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("  (//button[@value='search_filter'])[1]")));
                link11.click();
    	        
                WebElement firstTabContainer = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='nav-tabs-custom border0'])[1]")));

                if (firstTabContainer.isDisplayed()) {
                    System.out.println("Element is visible.");
                } else {
                    System.out.println("Element is present but not visible.");
                }

                WebElement link111 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class='btn btn-primary btn-sm'][normalize-space()='Add Staff'])[2]")));
                link111.click();
    	       
                        // Read values from properties
                        String employeeID = prop.getProperty("employee_id.value");
                        String name = prop.getProperty("name.value");
                        String surname = prop.getProperty("surname.value");
                        String fatherName = prop.getProperty("father_name.value");
                        String motherName = prop.getProperty("mother_name.value");
                        String email = prop.getProperty("email.value");
                        String dob = prop.getProperty("dob.value");
                        String joiningDate = prop.getProperty("date_of_joining.value");
                        String mobile1 = prop.getProperty("mobile1.value");
                        String mobile2 = prop.getProperty("mobile2.value");
                        String address = prop.getProperty("address.value");
                        String permanentAddress = prop.getProperty("permanent_address.value");
                        String qualification = prop.getProperty("qualification.value");
                        String workExp = prop.getProperty("work_exp.value");
                        String note = prop.getProperty("note.value");

                        // Enter data into fields using sendKeys()
                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("employee_id"))).sendKeys(employeeID);
                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name"))).sendKeys(name);
                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("surname"))).sendKeys(surname);
                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("father_name"))).sendKeys(fatherName);
                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mother_name"))).sendKeys(motherName);
                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email"))).sendKeys(email);
                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dob"))).sendKeys(dob);
                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("date_of_joining"))).sendKeys(joiningDate);
                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mobileno"))).sendKeys(mobile1);
                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='mobileno'])[2]"))).sendKeys(mobile2);
                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("address"))).sendKeys(address);
                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("permanent_address"))).sendKeys(permanentAddress);
                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("qualification"))).sendKeys(qualification);
                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("work_exp"))).sendKeys(workExp);
                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("note"))).sendKeys(note);
                      
                        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 200);");

                        WebElement link1111 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("   (//button[@id='submitbtn'])[1]")));
                        link1111.click();
                       
                        System.out.println(" Successfully entered all employee details.");
                      
                        
                        
                    }
    @Test(priority = 2)
    public void clickAngleLeftButton1() {
        try {
            // Locate and scroll to the 7th <a> tag
            WebElement linkElement7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@href='#'])[24]")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", linkElement7);
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 200);");

            System.out.println("Located the 7th <a> element and scrolled down slightly.");
        } catch (Exception e) {
            System.err.println("An error occurred in clickAngleLeftButton (7th <a>): " + e.getMessage());
        }
        
        WebElement link1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("  (//a[normalize-space()='Staff Attendance'])[2]")));
        link1.click();
        
        
        
        WebElement classDropdown11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" (//select[@id='class_id'])[1]")));
        new Select(classDropdown11).selectByIndex(1); // Change index as needed
        
        WebElement dateInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@name='date'])[1]")));
        dateInput.click();

        // Click on the 21st day in the calendar
        WebElement day21 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//td[normalize-space()='21'])[1]")));
        day21.click();
    
        WebElement day211 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='Search'])")));
        day211.click();
                }
    
    @Test(priority = 3)
    public void clickAngleLeftButton11() {
        try {
            // Locate and scroll to the 7th <a> tag
            WebElement linkElement7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@href='#'])[24]")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", linkElement7);
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 200);");

            System.out.println("Located the 7th <a> element and scrolled down slightly.");
        } catch (Exception e) {
            System.err.println("An error occurred in clickAngleLeftButton (7th <a>): " + e.getMessage());
        }
        WebElement link1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("   (//a[normalize-space()='Payroll'])[2]")));
        link1.click();
        
        WebElement classDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("  (//select[@name='role'])[1]")));
        new Select(classDropdown).selectByIndex(1); 
       
        WebElement classDropdown1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//select[@name='month'])[1]")));
        new Select(classDropdown1).selectByIndex(1); 
       
        WebElement classDropdown11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("   (//select[@name='year'])[1]")));
        new Select(classDropdown11).selectByIndex(1); 

        WebElement day211 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("  (//button[normalize-space()='Search'])[1]")));
        day211.click();
    }
}
    
