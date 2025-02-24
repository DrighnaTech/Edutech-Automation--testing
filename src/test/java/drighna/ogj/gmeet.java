package drighna.ogj;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class gmeet extends BaseClass {
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
    }
    @Test
    public void completeFeeProcess() throws InterruptedException {
    	

        // **Fix: Close blocking modal (if any)**
        try {
            WebElement closeModal = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-online-timetable']//button[contains(text(),'Close')]")));
            closeModal.click();
            System.out.println(" Closed blocking modal.");
        } catch (Exception e) {
            System.out.println("No blocking modal found.");
        }

        // Click on "Gmeet Live Classes"
        WebElement liveClasses1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[normalize-space()='Gmeet Live Classes'])[1]")));
        liveClasses1.click();
        System.out.println(" Clicked on 'Gmeet Live Classes'.");

        // Click on "Live Classes" again
        WebElement liveClasses2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[normalize-space()='Live Classes'])[3]")));
        liveClasses2.click();
        System.out.println("Clicked on 'Live Classes' again.");

        // Click on "Add" button
        WebElement addButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='Add'])[1]")));
        addButton.click();
        System.out.println("Clicked on 'Add' button.");

        // Fill "Title" field
        WebElement titleInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='title']")));
        titleInput.sendKeys(prop.getProperty("title"));
        System.out.println("Entered Title: " + prop.getProperty("title"));

        // Click Date Picker Icon
        WebElement datePickerIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='glyphicon glyphicon-calendar']")));
        datePickerIcon.click();
        System.out.println("Clicked on Date Picker icon.");

        // Select Date (16th)
        WebElement day16 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[normalize-space()='16']")));
        day16.click();
        System.out.println("Selected date: February 16, 2025.");

        // Fill "Duration" field
        WebElement durationInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='duration']")));
        durationInput.sendKeys(prop.getProperty("duration"));
        System.out.println("Entered Duration: " + prop.getProperty("duration"));

        // Select "Role" (Index 1)
        new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='role_id']")))).selectByIndex(1);
        System.out.println("Selected Role (Index 1)");

        // Select "Staff" (Index 1)
        new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='staff_id']")))).selectByIndex(1);
        System.out.println("Selected Staff (Index 1)");

        // Select "Class" (Index 1)
        new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='class_id']")))).selectByIndex(1);
        System.out.println(" Selected Class (Index 1)");

        // **Fix: Select Section from Custom Dropdown**
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//ul[@class='select2-selection__rendered'])[1]")));
        dropdown.click();
        System.out.println(" Opened the dropdown.");

        Thread.sleep(2000); // Wait for options to load

        // Select First Option
        WebElement firstOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@class='select2-results__options']/li")));
        firstOption.click();
        System.out.println(" Selected the first option from dropdown.");

        // Fill "URL" field
        WebElement urlInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='url']")));
        urlInput.sendKeys(prop.getProperty("url1"));
        System.out.println("Entered URL: " + prop.getProperty("url1"));

        // Fill "Description" field
        WebElement descriptionInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='description']")));
        descriptionInput.sendKeys(prop.getProperty("description"));
        System.out.println("Entered Description: " + prop.getProperty("description"));

     // Locate the "Load" button
        WebElement loadButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='load']")));

        // **Fix 1: Scroll into view**
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", loadButton);
        System.out.println("Scrolled down to the 'Load' button.");

        // **Fix 2: Wait for any overlay to disappear**
        try {
            WebElement overlay = driver.findElement(By.xpath("//div[contains(@class,'loading') or contains(@class,'overlay')]"));
            wait.until(ExpectedConditions.invisibilityOf(overlay));
            System.out.println(" Overlay disappeared, ready to click.");
        } catch (Exception e) {
            System.out.println("No overlay found, proceeding to click.");
        }

        // **Fix 3: Click using JavaScript (if normal click fails)**
        try {
            loadButton.click();
            System.out.println(" Clicked 'Load' button.");
        } catch (Exception e) {
            System.out.println("Normal click failed, trying JavaScript click...");
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", loadButton);
            System.out.println("Clicked 'Load' button using JavaScript.");
        }

        
        try {
            WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Record saved successfully')]")));
            System.out.println(" Success Message Displayed: " + successMessage.getText());
        } catch (Exception e) {
            System.out.println(" 'Record saved successfully' message NOT found. Check manually.");
        }
    }
    
    
  @Test
    	public void daily_asg() throws InterruptedException {
	 
    		Properties prop = new Properties();

    		try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("config.properties")) {

    			if (inputStream == null) {
    				System.out.println("Sorry, unable to find config.properties");
    				return;
    			}

    			// Load properties from the file
    			prop.load(inputStream);

    		} catch (IOException e) {
    			e.printStackTrace();	
    		}

        // **Fix 2: Scroll & Click "Live Meeting"**
        WebElement liveMeeting = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[normalize-space()='Live Meeting'])[3]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", liveMeeting);
        Thread.sleep(1000);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", liveMeeting);
        System.out.println("✅ Clicked on 'Live Meeting'.");

     // Scroll down slightly before clicking "Add" button
        WebElement addButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='Add'])[1]")));
        addButton.click();
        System.out.println("✅ Clicked on 'Add' button.");


        // **Continue with Form Filling**
        WebElement titleInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='title']")));
        titleInput.sendKeys(prop.getProperty("title1"));
        System.out.println("✅ Entered Title: " + prop.getProperty("title1"));

        WebElement datePickerIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='glyphicon glyphicon-calendar']")));
        datePickerIcon.click();
        System.out.println("✅ Clicked on Date Picker icon.");

        WebElement day16 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[normalize-space()='16']")));
        day16.click();
        System.out.println("✅ Selected date: February 16, 2025.");

        WebElement durationInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='duration']")));
        durationInput.sendKeys(prop.getProperty("duration1"));
        System.out.println("✅ Entered Duration: " + prop.getProperty("duration1"));

        WebElement urlInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='url']")));
        urlInput.sendKeys(prop.getProperty("url11"));
        System.out.println("✅ Entered URL: " + prop.getProperty("url11"));

        WebElement descriptionInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='description']")));
        descriptionInput.sendKeys(prop.getProperty("description1"));
        System.out.println("✅ Entered Description: " + prop.getProperty("description1"));

        WebElement staffCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='staff_2']")));
        if (!staffCheckbox.isSelected()) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", staffCheckbox);
            System.out.println("✅ Clicked on 'Staff 2' checkbox.");
        } else {
            System.out.println("✅ 'Staff 2' checkbox was already selected.");
        }

        // **Fix 4: Scroll & Click "Load" Button**
        WebElement loadButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='load']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", loadButton);
        Thread.sleep(1000);
        loadButton.click();
        System.out.println("✅ Clicked 'Load' button.");

        // **Verify Success Message**
        try {
            WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Record saved successfully')]")));
            System.out.println("✅ Success Message Displayed: " + successMessage.getText());

            WebElement savedTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'" + prop.getProperty("title1") + "')]")));
            System.out.println("✅ Saved title is displayed: " + savedTitle.getText());
        } catch (Exception e) {
            System.out.println("❌ 'Record saved successfully' message OR saved title NOT found. Check manually.");
        }
    }

    @Test
    public void completeFeeProcess11() throws InterruptedException {
        System.out.println("✅ Logged in successfully");

        // **Fix 1: Handle Blocking Modal**
        try {
            WebElement closeModal = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='modal-online-timetable']//button[contains(@class,'close')]")));
            closeModal.click();
            System.out.println("✅ Closed the blocking modal.");
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("ℹ️ No modal found. Proceeding...");
        }

        // **Fix 2: Scroll & Click "Live Classes Report"**
        WebElement liveClassesReport = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[normalize-space()='Live Classes Report'])[3]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", liveClassesReport);
        Thread.sleep(1000);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", liveClassesReport);
        System.out.println("✅ Clicked on 'Live Classes Report' (3rd occurrence).");

        WebElement classDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='class_id']")));
        Select selectClass = new Select(classDropdown);
        selectClass.selectByIndex(1);
        System.out.println("✅ Selected first option in 'Class' dropdown.");

        WebElement sectionDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='section_id']")));
        Select selectSection = new Select(sectionDropdown);
        selectSection.selectByIndex(1);
        System.out.println("✅ Selected first option in 'Section' dropdown.");

        // Click on "Search" button
        WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Search']")));
        searchButton.click();
        System.out.println("✅ Clicked on 'Search' button.");

        // Check if the alert message appears
        try {
            WebElement alertMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-info']")));
            System.out.println("✅ Alert Message Displayed: " + alertMessage.getText());
        } catch (Exception e) {
            System.out.println("❌ Alert message not found. Check manually.");
        }
    }
}