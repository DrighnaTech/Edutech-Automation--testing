package drighna.ogj;

import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class inventory extends BaseClass {
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

    @Test(priority = 1)
    public void clickAngleLeftButton() {
        try {
            // Locate and scroll to the 7th <a> tag
            WebElement linkElement7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@href='#'])[20]")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", linkElement7);
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 200);");

            System.out.println("Located the 7th <a> element and scrolled down slightly.");
        } catch (Exception e) {
            System.err.println("An error occurred in clickAngleLeftButton (7th <a>): " + e.getMessage());
        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@href='#'])[29]")));
        link.click();
        
        WebElement link1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(" (//a[normalize-space()='Issue Item'])[2]")));
        link1.click();
        
        WebElement link11 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@type='button'])[1]")));
        link11.click();
    
  
        driver.findElement(By.xpath("//select[@id='input-type-student']")).sendKeys(prop.getProperty("studentTypeValuew"));
        driver.findElement(By.xpath("//select[@id='issue_to']")).sendKeys(prop.getProperty("issueToValuew"));
        driver.findElement(By.xpath("//select[@name='issue_by']")).sendKeys(prop.getProperty("issueByValuew"));
        driver.findElement(By.xpath("//input[@id='issue_date']")).sendKeys(prop.getProperty("issueDateValuew"));
        driver.findElement(By.xpath("//input[@id='return_date']")).sendKeys(prop.getProperty("returnDateValuew"));
        driver.findElement(By.xpath("//textarea[@id='note']")).sendKeys(prop.getProperty("noteValuew"));
        driver.findElement(By.xpath("//select[@id='item_category_id']")).sendKeys(prop.getProperty("itemCategoryValuew"));
        driver.findElement(By.xpath("//select[@id='item_id']")).sendKeys(prop.getProperty("itemIdValuew"));
        driver.findElement(By.xpath("//input[@name='quantity']")).sendKeys(prop.getProperty("quantityValuew"));

        driver.findElement(By.xpath("//button[normalize-space()='Submit']")).click();

        System.out.println("Student Type: " + prop.getProperty("studentTypeValuew"));
        System.out.println("Issue To: " + prop.getProperty("issueToValuew"));
        System.out.println("Issue By: " + prop.getProperty("issueByValuew"));
        System.out.println("Issue Date: " + prop.getProperty("issueDateValuew"));
        System.out.println("Return Date: " + prop.getProperty("returnDateValuew"));
        System.out.println("Note: " + prop.getProperty("noteValuew"));
        System.out.println("Item Category: " + prop.getProperty("itemCategoryValuew"));
        System.out.println("Item ID: " + prop.getProperty("itemIdValuew"));
        System.out.println("Quantity: " + prop.getProperty("quantityValuew"));

        System.out.println("Form submitted successfully!");
    } 
    
    @Test(priority = 2)
    public void clickAngleLeftButton1() {
        try {
            // Locate and scroll to the 7th <a> tag
            WebElement linkElement7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@href='#'])[20]")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", linkElement7);
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 200);");

            System.out.println("Located the 7th <a> element and scrolled down slightly.");
        } catch (Exception e) {
            System.err.println("An error occurred in clickAngleLeftButton (7th <a>): " + e.getMessage());
        }
        
        WebElement link1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[normalize-space()='Add Item Stock'])[2]")));
        link1.click();
        
        try {
            driver.findElement(By.xpath("//select[@id='item_category_id']")).sendKeys(prop.getProperty("itemCategoryValue3"));
            driver.findElement(By.xpath("//select[@id='item_id']")).sendKeys(prop.getProperty("itemIdValue3"));
            driver.findElement(By.xpath("//select[@id='supplier_id']")).sendKeys(prop.getProperty("supplierIdValue3"));
            driver.findElement(By.xpath("//select[@id='store_id']")).sendKeys(prop.getProperty("storeIdValue3"));
            driver.findElement(By.xpath("//select[@name='symbol']")).sendKeys(prop.getProperty("symbolValue3"));
            driver.findElement(By.xpath("//input[@id='quantity']")).sendKeys(prop.getProperty("quantityValue3"));
            driver.findElement(By.xpath("(//input[@id='date'])[1]")).sendKeys(prop.getProperty("startDateValue3"));
            driver.findElement(By.xpath("(//input[@id='date'])[2]")).sendKeys(prop.getProperty("endDateValue3"));
            driver.findElement(By.xpath("//textarea[@id='description']")).sendKeys(prop.getProperty("descriptionValue3"));

            // Click Submit Button
            driver.findElement(By.xpath("//button[@id='submitbtn']")).click();

            System.out.println("Inventory form submitted successfully!");
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
}
    
    
    @Test(priority = 3)
    public void clickAngleLeftButton11() {
        try {
            // Locate and scroll to the 7th <a> tag
            WebElement linkElement7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@href='#'])[20]")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", linkElement7);
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 200);");

            System.out.println("Located the 7th <a> element and scrolled down slightly.");
        } catch (Exception e) {
            System.err.println("An error occurred in clickAngleLeftButton (7th <a>): " + e.getMessage());
        }
        
        WebElement link1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[normalize-space()='Add Item'])[2]")));
        link1.click();
        
        try {
            driver.findElement(By.xpath("//input[@id='name']")).sendKeys(prop.getProperty("itemName23"));
            driver.findElement(By.xpath("//select[@id='item_category_id']")).sendKeys(prop.getProperty("itemCategory23"));
            driver.findElement(By.xpath("//input[@id='unit']")).sendKeys(prop.getProperty("unitValue23"));
            driver.findElement(By.xpath("//textarea[@id='description']")).sendKeys(prop.getProperty("descriptionValue23"));

            driver.findElement(By.xpath("//button[@class='btn btn-info pull-right']")).click();

            // Check if Box-Body is Displayed
            WebElement boxBody = driver.findElement(By.xpath("(//div[@class='box-body'])[2]"));
            if (boxBody.isDisplayed()) {
                System.out.println(" Form submitted successfully, and the box-body is displayed!");
            } else {
                System.out.println(" Form submission failed, box-body not visible.");
            }
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }

}
    
    
    @Test(priority = 4)
    public void clickAngleLeftButton111() {
        try {
            // Locate and scroll to the 7th <a> tag
            WebElement linkElement7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@href='#'])[20]")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", linkElement7);
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 200);");

            System.out.println("Located the 7th <a> element and scrolled down slightly.");
        } catch (Exception e) {
            System.err.println("An error occurred in clickAngleLeftButton (7th <a>): " + e.getMessage());
        }
        
        WebElement link1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[normalize-space()='Item Category'])[2]")));
        link1.click();
        try {
            driver.findElement(By.xpath("//input[@id='itemcategory']")).sendKeys(prop.getProperty("itemCategoryName23"));

            driver.findElement(By.xpath("//textarea[@id='description']")).sendKeys(prop.getProperty("descriptionValue23"));

            driver.findElement(By.xpath("//button[@class='btn btn-info pull-right']")).click();
            
            WebElement dataTable = driver.findElement(By.xpath("//div[@id='DataTables_Table_0_wrapper']"));
            if (dataTable.isDisplayed()) {
                System.out.println("Submission successful! Data table is displayed.");
            } else {
                System.out.println("Submission failed! Data table is NOT displayed.");
            }
        } catch (Exception e) {
            System.out.println(" Error occurred: " + e.getMessage());
        }
        
        
}
    
    @Test(priority = 5)
    public void clickAngleLeftButton1111() {
        try {
            // Locate and scroll to the 7th <a> tag
            WebElement linkElement7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@href='#'])[20]")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", linkElement7);
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 200);");

            System.out.println("Located the 7th <a> element and scrolled down slightly.");
        } catch (Exception e) {
            System.err.println("An error occurred in clickAngleLeftButton (7th <a>): " + e.getMessage());
        } 
        
        WebElement link1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(" (//a[normalize-space()='Item Store'])[2]")));
        link1.click();
        try {
            driver.findElement(By.xpath("(//input[@id='name'])[1]")).sendKeys(prop.getProperty("nameValue4"));

            driver.findElement(By.xpath("(//input[@id='code'])[1]")).sendKeys(prop.getProperty("codeValue4"));

            driver.findElement(By.xpath("(//textarea[@id='description'])[1]")).sendKeys(prop.getProperty("descriptionValue"));

            driver.findElement(By.xpath("(//button[@class='btn btn-info pull-right'])[1]")).click();
            
            WebElement dataTable = driver.findElement(By.xpath("(//div[contains(@class,'')])[76]"));
            if (dataTable.isDisplayed()) {
                System.out.println("Submission successful! Data table is displayed.");
            } else {
                System.out.println("Submission failed! Data table is NOT displayed.");
            }
        } catch (Exception e) {
            System.out.println(" Error occurred: " + e.getMessage());
        }
    
    }
        @Test(priority = 5)
        public void clickAngleLeftButton11111() {
            try {
                // Locate and scroll to the 7th <a> tag
                WebElement linkElement7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@href='#'])[20]")));
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", linkElement7);
                ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 200);");

                System.out.println("Located the 7th <a> element and scrolled down slightly.");
            } catch (Exception e) {
                System.err.println("An error occurred in clickAngleLeftButton (7th <a>): " + e.getMessage());
            } 
            
            WebElement link1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[normalize-space()='Item Supplier'])[2]")));
            link1.click();
    
            driver.findElement(By.xpath("(//input[@id='name'])[1]")).sendKeys(prop.getProperty("nameValue117"));
            
            driver.findElement(By.xpath("(//input[@id='phone'])[1]")).sendKeys(prop.getProperty("phoneValue117"));
            
            driver.findElement(By.xpath("(//input[@id='text'])[1]")).sendKeys(prop.getProperty("textValue117"));
            
            String address = prop.getProperty("address117");
            String contactName = prop.getProperty("contact_name117");
            String contactPhone = prop.getProperty("contact_phone117");
            String contactEmail = prop.getProperty("contact_email117");
            String description = prop.getProperty("description117");


            driver.findElement(By.xpath("(//textarea[@id='address'])[1]")).sendKeys(address);
            driver.findElement(By.xpath("(//input[@id='contact_person_name'])[1]")).sendKeys(contactName);
            driver.findElement(By.xpath("(//input[@id='contact_person_phone'])[1]")).sendKeys(contactPhone);
            driver.findElement(By.xpath("(//input[@id='contact_person_email'])[1]")).sendKeys(contactEmail);
            driver.findElement(By.xpath("(//textarea[@id='description'])[1]")).sendKeys(description);

            driver.findElement(By.xpath("(//button[@class='btn btn-info pull-right'])[1]")).click();

            WebElement confirmationMessage = driver.findElement(By.xpath("(//div[contains(@class,'')])[81]"));
            if (confirmationMessage.isDisplayed()) {
                System.out.println("Form submitted successfully!");
            } else {
                System.out.println("Form submission failed!");
            }

           
    
    }
}