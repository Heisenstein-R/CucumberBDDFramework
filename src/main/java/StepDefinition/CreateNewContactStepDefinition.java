package StepDefinition;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateNewContactStepDefinition {

	WebDriver driver;

	@Given("^User is on the HomePage$")
	public void User_on_theHomePage() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://freecrm.com/");

		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("#1 Free CRM Power Up your Entire Business Free Forever", title);
		driver.findElement(By.xpath("//span[text()='Log In']")).click();

		driver.findElement(By.name("email")).sendKeys("dharmaraj.k3011@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Iamrajuk@1234");

		driver.findElement(By.xpath("//div[text() = 'Login']")).click();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		boolean b = driver.findElement(By.xpath("//span[@class='user-display' and text() = 'Raju K']")).isDisplayed();
		Assert.assertTrue(b);

	}

	@When("^User clicks on the Contacts and Title is Contacts$")
	public void User_Clicks_Contacts_and_verify_Contact() {
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//i[@class = 'home icon']")));
		driver.findElement(By.xpath("//span[text() = 'Contacts']")).click();
		boolean b = driver.findElement(By.xpath("//span[text() = 'Contacts']"))
				.isDisplayed();
		Assert.assertTrue(b);
	}

	@Then("^User clicks on Create button$")
	public void User_clicks_on_Create_Button() {
		driver.findElement(By.xpath("//button[text() = 'Create']")).click();
	}

	@And("^user enters all the fields and clicks save$")
	public void User_enters_name_and_saves_it() {
		driver.findElement(By.xpath("//input[@name = 'first_name']")).sendKeys("Raajaa");
		driver.findElement(By.xpath("//input[@name = 'last_name']")).sendKeys("K");
		driver.findElement(By.xpath("//button[text() = 'Save']")).click();
	}

	@And("^Verifies the contact name which added$")
	public void Verifies_firstname_lastname() {
		Boolean b = driver.findElement(By.xpath("//span[text() = 'Raajaa K']")).isDisplayed();
		if (b == true) {
			driver.quit();
		}
	}
}
