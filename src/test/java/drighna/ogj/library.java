package drighna.ogj;

import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.List;
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

public class library extends BaseClass {
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
        WebElement linkElement7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@href='#'])[17]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", linkElement7);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 200);");

        System.out.println("Located the 17th <a> element and scrolled down slightly.");
    } catch (Exception e) {
        System.err.println("An error occurred in clickAngleLeftButton (7th <a>): " + e.getMessage());
    }
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement link = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@href='#'])[28]")));
    link.click();
    
    WebElement link1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(" (//a[normalize-space()='Book List'])[2]")));
    link1.click();
    
    WebElement link11 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("   (//button[normalize-space()='Add Book'])[1]")));
    link11.click();
  
    driver.findElement(By.id(prop.getProperty("bookTitlea"))).sendKeys("bookTitlea");
    driver.findElement(By.id(prop.getProperty("bookNoa"))).sendKeys("bookNoa");
    driver.findElement(By.id(prop.getProperty("isbnNoa"))).sendKeys("isbnNoa");
    driver.findElement(By.id(prop.getProperty("publishera"))).sendKeys("publishera");
    driver.findElement(By.id(prop.getProperty("authora"))).sendKeys("authora");
    driver.findElement(By.id(prop.getProperty("subjecta"))).sendKeys("subjecta");
    driver.findElement(By.id(prop.getProperty("rackNoa"))).sendKeys("rackNoa");
    driver.findElement(By.id(prop.getProperty("quantitya"))).sendKeys("quantitya");
    driver.findElement(By.id(prop.getProperty("unitCosta"))).sendKeys("unitCosta");
    driver.findElement(By.id(prop.getProperty("postDatea"))).sendKeys("postDatea");
    driver.findElement(By.id(prop.getProperty("descriptiona"))).sendKeys("descriptiona");

  

   
}
@Test(priority = 2)
public void clickAngleLeftButton1() {
    try {
        // Locate and scroll to the 7th <a> tag
        WebElement linkElement7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@href='#'])[17]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", linkElement7);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 200);");

        System.out.println("Located the 17th <a> element and scrolled down slightly.");
    } catch (Exception e) {
        System.err.println("An error occurred in clickAngleLeftButton (7th <a>): " + e.getMessage());
    }

    WebElement link1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[normalize-space()='Issue - Return'])[2]")));
    link1.click();
}

@Test(priority = 3)
public void clickAngleLeftButton11() {
    try {
        // Locate and scroll to the 7th <a> tag
        WebElement linkElement7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@href='#'])[17]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", linkElement7);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 200);");

        System.out.println("Located the 17th <a> element and scrolled down slightly.");
    } catch (Exception e) {
        System.err.println("An error occurred in clickAngleLeftButton (7th <a>): " + e.getMessage());
    }

    WebElement link1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[normalize-space()='Add Student'])[2]")));
    link1.click();
    
    WebElement classDropdown = driver.findElement(By.id("class_id"));
    Select selectClass = new Select(classDropdown);
    selectClass.selectByIndex(1);

    WebElement sectionDropdown = driver.findElement(By.id("section_id"));
    Select selectSection = new Select(sectionDropdown);
    selectSection.selectByIndex(1);

    driver.findElement(By.xpath("//button[normalize-space()='Search']")).click();
    
    WebElement boxBody = driver.findElement(By.xpath("(//div[@class='box-body'])[2]"));

    if (boxBody.isDisplayed()) {
        System.out.println("The second box-body div is displayed.");
    } else {
        System.out.println("The second box-body div is NOT displayed.");
    }
    
}
    @Test(priority = 4)
    public void clickAngleLeftButton111() {
        try {
            // Locate and scroll to the 7th <a> tag
            WebElement linkElement7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@href='#'])[17]")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", linkElement7);
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 200);");

            System.out.println("Located the 17th <a> element and scrolled down slightly.");
        } catch (Exception e) {
            System.err.println("An error occurred in clickAngleLeftButton (7th <a>): " + e.getMessage());

            try {
                WebElement addStaffMember = driver.findElement(By.xpath("(//a[normalize-space()='Add Staff Member'])[2]"));

                addStaffMember.click();
                Thread.sleep(3000); 

                WebElement boxBody = driver.findElement(By.xpath("(//div[@class='box-body'])[1]"));

                if (boxBody.isDisplayed()) {
                    System.out.println("'box-body' section is displayed after clicking 'Add Staff Member'.");
                } else {
                    System.out.println("'box-body' section is NOT displayed.");
                }
            } catch (Exception e2) {
                System.out.println("Element not found or not visible: " + e.getMessage());
            }
    
    
        }
    }
}
