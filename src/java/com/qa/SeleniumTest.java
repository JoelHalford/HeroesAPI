
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import com.qa.selenium.Constants;
import com.qa.selenium.Homepage;

public class SeleniumTest {
	
	WebDriver driver;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", Constants.DRIVER);
		driver = new ChromeDriver();
	}
	
	@After
	public void teardown() {
		driver.quit();
	}
	
	@Test
	public void registerNeedsCapital() throws InterruptedException {
		driver.manage().window().maximize();
		driver.get(Constants.URL);
		Homepage homepage = PageFactory.initElements(driver, Homepage.class);
		
		homepage.goToRegister();
		Thread.sleep(500);
		homepage.usernameWithoutCapital();		
		
		WebElement result = driver.findElement(By.id("error-message"));
		
		assertEquals("Error: Username too long validation not working.", "For some reason, you need a capital letter.", result.getText());
		Thread.sleep(1000);
	}
	
	@Test
	public void registerTooShort() throws InterruptedException {
		driver.manage().window().maximize();
		driver.get(Constants.URL);
		Homepage homepage = PageFactory.initElements(driver, Homepage.class);
		
		homepage.goToRegister();
		Thread.sleep(500);
		homepage.usernameTooShort();
		
		WebElement result = driver.findElement(By.id("error-message"));
		
		assertEquals("Error: Username too short validation not working.", "Username too short, hero!", result.getText());
		Thread.sleep(1000);
	}
	
	@Test
	public void registerTooLong() throws InterruptedException {
		driver.manage().window().maximize();
		driver.get(Constants.URL);
		Homepage homepage = PageFactory.initElements(driver, Homepage.class);
		
		homepage.goToRegister();
		Thread.sleep(500);
		homepage.usernameTooLong();
		
		WebElement result = driver.findElement(By.id("error-message"));
		
		assertEquals("Error: Username too long validation not working.", "Hero, your username is too long!", result.getText());
		Thread.sleep(1000);
	}
}
