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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ZoomLiveTest extends BaseClass {
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
    

        WebElement zoomLiveClasses = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Zoom Live Classes']")));
        zoomLiveClasses.click();
        System.out.println("Clicked on 'Zoom Live Classes'.");

        WebElement liveMeeting = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[normalize-space()='Live Meeting'])[4]")));
        liveMeeting.click();
        System.out.println("Clicked on 'Live Meeting' (4th occurrence).");

        WebElement addButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Add']")));
        addButton.click();
        System.out.println("Clicked on 'Add' button.");

        WebElement titleInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='title']")));
        titleInput.sendKeys(prop.getProperty("title"));
        System.out.println("Entered Title: " + prop.getProperty("title"));

        WebElement datePickerIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='glyphicon glyphicon-calendar']")));
        datePickerIcon.click();
        System.out.println("Clicked on Date Picker icon.");

        WebElement durationInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='duration']")));
        durationInput.sendKeys(prop.getProperty("duration"));
        System.out.println("Entered Duration: " + prop.getProperty("duration"));

        WebElement descriptionInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='description']")));
        descriptionInput.sendKeys(prop.getProperty("description"));
        System.out.println("Entered Description: " + prop.getProperty("description"));

        WebElement staffCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='staff_2'])[1]")));
        if (!staffCheckbox.isSelected()) {
            staffCheckbox.click();
            System.out.println("Selected 'Staff 2' checkbox.");
        } else {
            System.out.println("'Staff 2' checkbox was already selected.");
        }

        WebElement loadButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='load']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", loadButton);
        loadButton.click();
        System.out.println("Clicked 'Load' button.");

        WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@type='button'][normalize-space()='×'])[2]")));
        closeButton.click();
        System.out.println("Clicked on the close (×) button.");
    }

        @Test
        public void testZoomLiveClass1() {
        	
        	  try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("config.properties")) {
                  if (inputStream == null) {
                      System.out.println("config.properties not found!");
                      return;
                  }
                  prop.load(inputStream);
              } catch (IOException e) {
                  System.out.println("Error loading config.properties: " + e.getMessage());
              }

        WebElement liveClasses = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[normalize-space()='Live Classes'])[4]")));
        liveClasses.click();
        System.out.println("Clicked on 'Live Classes' (4th occurrence).");

        WebElement addButton1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='Add'])[1]")));
        addButton1.click();
        System.out.println("Clicked on 'Add' button.");

        WebElement titleInput1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='title']")));
        titleInput1.sendKeys(prop.getProperty("title34"));
        System.out.println("Entered Title: " + prop.getProperty("title34"));

        WebElement durationInput1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='duration']")));
        durationInput1.sendKeys(prop.getProperty("duration34"));
        System.out.println("Entered Duration: " + prop.getProperty("duration34"));

        WebElement roleDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='role_id']")));
        Select roleSelect = new Select(roleDropdown);
        roleSelect.selectByIndex(1);
        System.out.println("Selected Role (Index 1).");

        WebElement staffDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='staff_id']")));
        Select staffSelect = new Select(staffDropdown);
        staffSelect.selectByIndex(1);
        System.out.println("Selected Staff (Index 1).");

        WebElement classDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='class_id']")));
        Select classSelect = new Select(classDropdown);
        classSelect.selectByIndex(1);
        System.out.println("Selected Class (Index 1).");

        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//ul[@class='select2-selection__rendered'])[1]")));
        dropdown.click();
        System.out.println("Opened the dropdown.");

        WebElement firstOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//ul[@class='select2-results__options']/li)[1]")));
        firstOption.click();
        System.out.println("Selected the first option from dropdown.");

        WebElement descriptionInput1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//textarea[@id='description'])[1]")));
        descriptionInput1.sendKeys(prop.getProperty("description34"));
        System.out.println("Entered Description: " + prop.getProperty("description34"));
    }
}

    
    
    
    
    
    
    
    
    
    
    

