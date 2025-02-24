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



public class download extends BaseClass {
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
    	// Locate the 9th <a> element
    	WebElement linkElement9 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@href='#'])[18]")));

    	// Scroll to the element and bring it to the center of the viewport
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", linkElement9);

    

    	((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 200);");
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@href='#'])[26]")));
        link.click();
    
    WebElement contentShareLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[normalize-space()='Content Type'])[2]")));
    contentShareLink.click();
    System.out.println(" Clicked on 'Content Share List' successfully.");
    
    String nameText = prop.getProperty("name.value");

    WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='name'])[1]")));
    nameField.sendKeys(nameText);

    System.out.println("Successfully entered name: " + nameText);

    String descriptionText = prop.getProperty("description.value");

    WebElement descriptionField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//textarea[@id='description'])[1]")));
    descriptionField.sendKeys(descriptionText);
    System.out.println(" Successfully entered description: " + descriptionText);
    
    WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(" (//button[@id='submitbtn'])[1]")));
    searchButton.click();
    try {
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='alert alert-success text-left'])[1]")));

        Assert.assertTrue(successMessage.isDisplayed(), "Success message is NOT displayed!");
        
        String messageText = successMessage.getText().trim();
        Assert.assertEquals(messageText, "Record Saved Successfully", "Message text does not match!");
        
        System.out.println("Success Message Displayed: " + messageText);

    } catch (Exception e) {
        System.out.println("The success message did NOT appear.");
        Assert.fail("The 'Record Saved Successfully' message was not found.");
    }
    }
   

    @Test(priority = 2)
    public void clickAngleLeftButton11() {
        try {
            // Locate and scroll to the 7th <a> tag
            WebElement linkElement7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@href='#'])[18]")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", linkElement7);
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1000);");

            System.out.println("Located the 7th <a> element and scrolled down slightly.");
        } catch (Exception e) {
            System.err.println("An error occurred in clickAngleLeftButton (7th <a>): " + e.getMessage());
        }
        
        
        WebElement contentShareLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("  (//a[normalize-space()='Content Share List'])[2]")));
        contentShareLink.click();
        System.out.println(" Clicked on 'Content Share List' successfully.");
    String searchText = prop.getProperty("search.value34");

    WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@placeholder='Search...'])[1]")));
    searchBox.sendKeys(searchText);

    System.out.println("Successfully entered search text: " + searchText);

    }
    
    
    @Test(priority = 3)
    public void clickAngleLeftButton111() {
        try {
            // Locate and scroll to the 7th <a> tag
            WebElement linkElement7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@href='#'])[18]")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", linkElement7);
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1000);");

            System.out.println("Located the 7th <a> element and scrolled down slightly.");
        } catch (Exception e) {
            System.err.println("An error occurred in clickAngleLeftButton (7th <a>): " + e.getMessage());
        }
        
        try {
            WebElement link = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a)[351]")));
         
            link.click();

            System.out.println("Successfully clicked the 351st <a> link.");

        } catch (Exception e) {
            System.out.println("Error clicking the 351st <a> link: " + e.getMessage());
            
        }
        String urlValue = prop.getProperty("url_value12");

        WebElement uploadButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='Upload'])[1]")));
        uploadButton.click();
        System.out.println("Clicked 'Upload' button.");

        WebElement contentTypeDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//select[@id='content_type'])[2]")));
        new Select(contentTypeDropdown).selectByIndex(1);
        System.out.println("Selected Content Type: ");

        WebElement urlInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='url'])[1]")));
        urlInput.sendKeys(urlValue);
        System.out.println("Entered URL: " + urlValue);

        WebElement loadButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@id='load'])[1]")));
        loadButton.click();
        System.out.println("Clicked 'Load' button.");
    }

    
    @Test(priority = 4)
    public void clickAngleLeftButton1111() {
    	 try {
             // Locate and scroll to the 7th <a> tag
             WebElement linkElement7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@href='#'])[18]")));
             ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", linkElement7);
             ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1000);");

             System.out.println("Located the 7th <a> element and scrolled down slightly.");
         } catch (Exception e) {
             System.err.println("An error occurred in clickAngleLeftButton (7th <a>): " + e.getMessage());
         }
    	try {
    	    // Check if modal is present and close it
    	    try {
    	        WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='addModal']//button[contains(@class, 'close')]")));
    	        closeButton.click();
    	        System.out.println("Closed the modal successfully.");

    	        // Wait for modal to disappear completely
    	        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("addModal")));
    	        System.out.println("Modal is now hidden.");
    	    } catch (Exception e) {
    	        System.out.println("No modal found, proceeding with the test.");
    	    }

    	    // Click on the "Video Tutorial" link
    	    WebElement videoTutorialLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[normalize-space()='Video Tutorial'])[2]")));
    	    videoTutorialLink.click();
    	    System.out.println("Clicked on Video Tutorial link.");

    	    // Retrieve search text from properties file
    	    String searchTextValue = prop.getProperty("search_textabc");

    	    // Select Class Dropdown
    	    WebElement classDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//select[@id='search_class_id'])[1]")));
    	    new Select(classDropdown).selectByIndex(1);
    	    System.out.println("Selected Class Index: 1");

    	    // Select Section Dropdown
    	    WebElement sectionDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//select[@id='search_section_id'])[1]")));
    	    new Select(sectionDropdown).selectByIndex(1);
    	    System.out.println("Selected Section Index: 1");

    	    // Enter Search Text
    	    WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[normalize-space()='Search'])[1]")));
    	    searchInput.sendKeys(searchTextValue);
    	    System.out.println("Entered Search Text: " + searchTextValue);
    	} catch (Exception e) {
    	    System.out.println("An error occurred: " + e.getMessage());
    	}
    	  WebElement uploadButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='Search'])[1]")));
          uploadButton.click();
          System.out.println("Clicked 'Search' button.");

       
    }
}
    



    

    