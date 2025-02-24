package drighna.ogj;


import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BehaviourRecords extends BaseClass {
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

        @Test(priority = 1)  // ✅ Ensures test runs first
   
        public void behave() {
            WebElement behaviourRecords = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[normalize-space()='Behaviour Records'])[1]")));

            // ✅ Use Actions class to perform a double-click
            Actions actions = new Actions(driver);
            actions.doubleClick(behaviourRecords).perform();

            System.out.println("Successfully double-clicked on 'Behaviour Records'");
              		
		
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement assignIncident = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[normalize-space()='Assign Incident'])[2]")));
		assignIncident.click();
		
		WebElement classDropdown = driver.findElement(By.xpath("//select[@id='class_id']"));
		Select selectClass = new Select(classDropdown);
		selectClass.selectByIndex(1); // Select by index (0-based index)
		
		WebElement sectionDropdown = driver.findElement(By.xpath("//select[@id='section_id']"));
		Select selectSection = new Select(sectionDropdown);
		selectSection.selectByIndex(1); // Select by index
		
		WebDriverWait wait12 = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement searchButton = wait12.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Search']")));
		searchButton.click();
	}
    
    @Test
	public void studentincidentreport() throws InterruptedException {
	       
	     		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement behaviourRecords = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space()='Behaviour Records']")));
		behaviourRecords.click();

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement incidentsTab = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//a[normalize-space()='Incidents'])[2]")));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", incidentsTab);

		String searchKeyword = prop.getProperty("searchKeyword");

		WebDriverWait wait11 = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement searchBox = wait11.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Search...']")));
		searchBox.sendKeys(searchKeyword);
		
	

}
    @Test
	public void studentreport() throws InterruptedException {
    	 

		
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement reportsTab = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[normalize-space()='Reports'])[3]")));
        js.executeScript("arguments[0].click();", reportsTab);

        WebElement studentIncidentReport = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[normalize-space()='Student Incident Report'])[1]")));
        js.executeScript("arguments[0].click();", studentIncidentReport);

        WebElement classDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='class_id']")));
        Select selectClass = new Select(classDropdown);
        selectClass.selectByIndex(1);

        WebElement sectionDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='section_id']")));
        Select selectSection = new Select(sectionDropdown);
        selectSection.selectByIndex(1);

        WebElement sessionDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@name='session_id']")));
        Select selectSession = new Select(sessionDropdown);
        selectSession.selectByIndex(1);
        String admissionNo = prop.getProperty("admissionNo"); // Get Admission No from properties

        WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Search']")));
        searchButton.click();
        
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Search...']")));
        searchBox.clear();
        searchBox.sendKeys(admissionNo);
        searchBox.sendKeys(Keys.ENTER);  

        List<WebElement> studentRow = driver.findElements(By.xpath("//td[normalize-space()='" + admissionNo + "']"));

        if (!studentRow.isEmpty()) {
            System.out.println("Student with Admission No " + admissionNo + " is displayed successfully.");
        } else {
            System.out.println("Student with Admission No " + admissionNo + " is NOT found in the table.");
        
        
     }
    }

   

        @Test
        public void studentreport1() throws InterruptedException {
        	
                   
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            WebElement behaviourRankReport = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Student Behaviour Rank Report']")));
            behaviourRankReport.click();

            WebElement classDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='class_id']")));
            Select selectClass = new Select(classDropdown);
            selectClass.selectByIndex(1);

            WebElement sectionDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='section_id']")));
            Select selectSection = new Select(sectionDropdown);
            selectSection.selectByIndex(1);

            WebElement sessionDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@name='session_id']")));
            Select selectSession = new Select(sessionDropdown);
            selectSession.selectByIndex(1);

            WebElement typeDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='type']")));
            Select selectType = new Select(typeDropdown);
            selectType.selectByIndex(2);
            
            String pointValue = prop.getProperty("pointValue");

            WebElement pointInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='point']")));
            pointInput.clear();
            pointInput.sendKeys(pointValue);

            System.out.println("Successfully entered point value: " + pointValue);

            WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Search']")));
            searchButton.click();

            try {
                WebElement resultContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body//div[@class='wrapper']//div[@class='box removeboxmius']//div//div[@class='box-body']//div[3]")));
                System.out.println("Result is displayed after clicking search.");
            } catch (Exception e) {
                System.out.println("No results found after clicking search.");
            }
        }

        @Test
        public void studentreport11() throws InterruptedException {
        	
        	

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            WebElement behaviourRankReport = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Class Wise Rank Report']")));
            behaviourRankReport.click();

            try {
                WebElement rankTable = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='DataTables_Table_0_wrapper']")));
                System.out.println("Class Wise Rank Report table is displayed.");
            } catch (Exception e) {
                System.out.println("Class Wise Rank Report table is NOT displayed.");
            }
        }

        @Test
        public void studentreport111() throws InterruptedException {
        	


            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            WebElement behaviourRankReport = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Class Section Wise Rank Report']")));
            behaviourRankReport.click();

            try {
                WebElement rankTable1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='DataTables_Table_0_wrapper']")));
                System.out.println("✅ Class Section Wise Rank Report table is displayed.");
            } catch (Exception e) {
                System.out.println("❌ Class Section Wise Rank Report table is NOT displayed.");
            }
        }

        @Test
        public void studentreport1111() throws InterruptedException {
        	

    	
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            WebElement behaviourRankReport = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='House Wise Rank Report']")));
            behaviourRankReport.click();

            try {
                WebElement rankTable11 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='DataTables_Table_0_wrapper']")));
                System.out.println("House Wise Rank Report table is displayed.");
            } catch (Exception e) {
                System.out.println("House Wise Rank Report table is NOT displayed.");
            }
        }

        @Test
        public void studentreport11111() throws InterruptedException {

    		
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            JavascriptExecutor js = (JavascriptExecutor) driver;

            WebElement behaviourRankReport = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Incident Wise Report']")));
            behaviourRankReport.click();

            WebElement sessionTypeDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='session_type']")));
            js.executeScript("arguments[0].scrollIntoView(true);", sessionTypeDropdown);
            System.out.println("Scrolled to 'Session Type' dropdown.");

            Select selectSessionType = new Select(sessionTypeDropdown);
            selectSessionType.selectByIndex(1);
            System.out.println("Selected 'Session Type' with index 1.");

            WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Search']")));
            searchButton.click();
            System.out.println("Clicked on 'Search' button.");

            try {
                WebElement rankTable111 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='DataTables_Table_0_wrapper']")));
                System.out.println("Incident Wise Report table is displayed.");
            } catch (Exception e) {
                System.out.println("Incident Wise Report table is NOT displayed.");
            }
        }
		@Test
		public void studentreport111111() throws InterruptedException {
			
		
		
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		    WebElement behaviourRankReport = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='House Wise Rank Report']")));
		    behaviourRankReport.click();
		
		    try {
		        WebElement rankTable4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='DataTables_Table_0_wrapper']")));
		        System.out.println("House Wise Rank Report table is displayed.");
		    } catch (Exception e) {
		        System.out.println("House Wise Rank Report table is NOT displayed.");
		    }
		}

}
