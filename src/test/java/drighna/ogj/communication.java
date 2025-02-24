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
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class communication extends BaseClass {
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
        Login login = new Login();
        login.driver = this.driver;
        login.prop = this.prop;
        login.Login();
    }

    @Test(priority = 1)
    public void clickAngleLeftButton() {
        try {
            // Locate and scroll to the 7th <a> tag
            WebElement linkElement7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@href='#'])[10]")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", linkElement7);
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 200);");

            System.out.println("Located the 7th <a> element and scrolled down slightly.");
        } catch (Exception e) {
            System.err.println("An error occurred in clickAngleLeftButton (7th <a>): " + e.getMessage());
        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@href='#'])[25]")));
        link.click();
        
        WebElement link1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("  (//a[normalize-space()='Notice Board'])[2]")));
        link1.click();
        
        WebElement link11 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("  (//a[normalize-space()='Post New Message'])[1]")));
        link11.click();
        
    

        String title = prop.getProperty("title");  
        String date = prop.getProperty("date");  
        String publishDate = prop.getProperty("publish_date");  

        // Locate and enter 'title'
        WebElement titleInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='title'])[1]")));
        titleInput.sendKeys(title);

        // Locate and enter 'date'
        WebElement dateInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='date'])[1]")));
        dateInput.sendKeys(date);

        // Locate and enter 'publish_date'
        WebElement publishDateInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='publish_date'])[1]")));
        publishDateInput.sendKeys(publishDate);


        String addressValue1 = prop.getProperty("address.value1");

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.className("wysihtml5-sandbox")));

        WebElement addressInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body[@class='form-control wysihtml5-editor']")));
        addressInput.sendKeys(addressValue1);

        driver.switchTo().defaultContent();
        
        WebElement sendButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='Send'])[1]")));

        // Scroll to the "Send" button using JavaScriptExecutor
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sendButton);

        // Click the "Send" button
        sendButton.click();

        System.out.println("Successfully scrolled and clicked the 'Send' button.");
        
    }
}
    


     