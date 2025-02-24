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

public class homework extends BaseClass {
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
        WebElement linkElement7 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@href='#'])[20]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", linkElement7);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 200);");

        System.out.println("Located the 7th <a> element and scrolled down slightly.");
    } catch (Exception e) {
        System.err.println("An error occurred in clickAngleLeftButton (7th <a>): " + e.getMessage());
    }
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement link = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@href='#'])[27]")));
    link.click();
   
    WebElement addHomeworkLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[normalize-space()='Add Homework'])[2]")));
    addHomeworkLink.click();

    WebElement classDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//select[@id='searchclassid'])[1]")));
    Select selectClass = new Select(classDropdown);
    selectClass.selectByIndex(1); 

    WebElement sectionDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//select[@id='secid'])[1]")));
    Select selectSection = new Select(sectionDropdown);
    selectSection.selectByIndex(1);

    WebElement subjectGroupDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//select[@id='subject_group_id'])[1]")));
    Select selectSubjectGroup = new Select(subjectGroupDropdown);
    selectSubjectGroup.selectByIndex(1);

    WebElement subjectDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//select[@id='subid'])[1]")));
    Select selectSubject = new Select(subjectDropdown);
    selectSubject.selectByIndex(1);

    WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='Search'])[1]")));
    searchButton.click();

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
   
    WebElement addHomeworkLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[normalize-space()='Daily Assignment'])[2]")));
    addHomeworkLink.click();


WebElement classDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//select[@id='searchclassid'])[1]")));
Select selectClass = new Select(classDropdown);
selectClass.selectByIndex(1); 

WebElement sectionDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//select[@id='secid'])[1]")));
Select selectSection = new Select(sectionDropdown);
selectSection.selectByIndex(1);

WebElement subjectGroupDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//select[@id='subject_group_id'])[1]")));
Select selectSubjectGroup = new Select(subjectGroupDropdown);
selectSubjectGroup.selectByIndex(1);

WebElement subjectGroupDropdown1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//select[@id='subid'])[1]")));
Select selectSubjectGroup1 = new Select(subjectGroupDropdown1);
selectSubjectGroup1.selectByIndex(1);

WebElement addHomeworkLink11 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@name='date'])[1]")));
addHomeworkLink11.click();

WebElement addHomeworkLink111 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//td[normalize-space()='12'])[1]")));
addHomeworkLink111.click();


WebElement addHomeworkLink1111 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[normalize-space()='Search'])[1]")));
addHomeworkLink1111.click();
}
}

