package drighna.ogj;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
    protected WebDriver driver;
    protected Properties prop;

    @BeforeClass  // Initialize WebDriver before tests
    public void setup() {
        prop = new Properties();

        // Load config.properties file
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                System.out.println("config.properties file not found!");
            }
        } catch (IOException e) {
            System.out.println("Error loading config.properties: " + e.getMessage());
        }

        // Select browser from properties file
        String browser = prop.getProperty("browser", "chrome").toLowerCase();
        System.out.println("Selected browser: " + browser);

        // Initialize WebDriver based on the browser type
        switch (browser) {
            case "chrome":
                // Explicitly specifying the ChromeDriver version
                WebDriverManager.chromedriver().driverVersion("133.0.6943.99").setup(); // Specify the ChromeDriver version here
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            default:
                System.out.println("Invalid browser. Defaulting to Chrome.");
                WebDriverManager.chromedriver().driverVersion("133.0.6943.99").setup(); // Specify the ChromeDriver version here
                driver = new ChromeDriver();
        }

        // Browser setup
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        // Navigate to the login page
        driver.get("https://edutech.drighna.com/gauthenticate/login");
    }

    
}
