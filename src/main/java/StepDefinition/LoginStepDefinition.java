package StepDefinition;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LoginStepDefinition {
	
	WebDriver driver;
	
	@Given("User is on the Pre-Login Page to login$")
	public void user_already_on_PreLoginPage() {	
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://freecrm.com/");	
	}
	
	@When("title of login page is FreeCRM$")
	public void title_of_PreloginPage() {
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("#1 Free CRM Power Up your Entire Business Free Forever", title);
		driver.findElement(By.xpath("//span[text()='Log In']")).click();
	}

	@Then("User enters (.*) and User enters (.*)$")
	public void user_enters_username_and_user_enters_password(String username, String Password) {
	   driver.findElement(By.name("email")).sendKeys(username);
	   driver.findElement(By.name("password")).sendKeys(Password);
	}
	
	@And("User Clicks on Login")
	public void user_clicks_on_login() {
	   driver.findElement(By.xpath("//div[text() = 'Login']")).click();
	}
	
	@And("User is on HomePage")
	public void user_is_on_home_page() {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	  boolean b = driver.findElement(By.xpath("//span[@class='user-display' and text() = 'Raju K']")).isDisplayed();
	  Assert.assertTrue(b);
	  driver.quit();
	}



}
