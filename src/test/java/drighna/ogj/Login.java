package drighna.ogj;

import java.io.IOException;

import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Login extends BaseClass {
	@Test
	
	public void Login() {
	    // ✅ Ensure driver is initialized
	    if (driver == null) {
	        System.out.println("❌ Error: WebDriver is not initialized!");
	        return;
	    }

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    // ✅ Retrieve credentials from config.properties
	    String username = prop.getProperty("username");
	    String password = prop.getProperty("password");

	    if (username == null || password == null) {
	        System.out.println("❌ Error: Username or password not found in config.properties!");
	        return;
	    }

	    // ✅ Wait for username input field & enter username
	    WebElement usernameField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='form-username'])[1]")));
	    usernameField.sendKeys(username);

	    // ✅ Wait for password input field & enter password
	    WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='form-password'])[1]")));
	    passwordField.sendKeys(password);

	    // ✅ Wait for submit button & click it
	    WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='submit1']")));
	    submitButton.click();

	    // ✅ Ensure login was successful by waiting for dashboard URL
	    wait.until(ExpectedConditions.urlContains("dashboard"));  // Change "dashboard" to the expected URL fragment
	    System.out.println("✅ Login successful!");
	}
}