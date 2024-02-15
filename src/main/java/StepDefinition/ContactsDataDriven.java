package StepDefinition;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContactsDataDriven {
		
	
	WebDriver driver;
	

	@Given("^User on the HomePage by using the (.*) and (.*) as creds$")
	public void user_on_the_home_page_by_using_the_as_creds(String username, String password) {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://freecrm.com/");

		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("#1 Free CRM Power Up your Entire Business Free Forever", title);
		driver.findElement(By.xpath("//span[text()='Log In']")).click();

		driver.findElement(By.name("email")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);

		driver.findElement(By.xpath("//div[text() = 'Login']")).click();

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		boolean b = driver.findElement(By.xpath("//span[@class='user-display' and text() = 'Raju K']")).isDisplayed();
		Assert.assertTrue(b);
	}
	
	@When("^User clicks on the Contacts button$")
	public void user_clicks_on_the_contacts_and_title_is_contacts() {
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//i[@class = 'home icon']")));
		driver.findElement(By.xpath("//span[text() = 'Contacts']")).click();
		boolean b = driver.findElement(By.xpath("//span[text() = 'Contacts']"))
				.isDisplayed();
		Assert.assertTrue(b);
	}
	
	@Then("^User clicks on Create button and proceeds$")
	public void user_clicks_on_create_button() {
		driver.findElement(By.xpath("//button[text() = 'Create']")).click();
	}
	
	@Then("^user enters all the fields like (.*), (.*), (.*), (.*) and clicks save$")
	public void user_enters_all_the_fields_and_clicks_save(String firstname, String lastname, String company, String email) {
		driver.findElement(By.xpath("//input[@name = 'first_name']")).sendKeys(firstname);
		driver.findElement(By.xpath("//input[@name = 'last_name']")).sendKeys(lastname);
		driver.findElement(By.xpath("//div[@name = 'company']/child::input")).sendKeys(company);
		driver.findElement(By.xpath("//input[@placeholder='Email address']")).sendKeys(email);
		
		driver.findElement(By.xpath("//button[text() = 'Save']")).click();
	}
	
	@Then("^Verifies the contact name (.*) and (.*) which added$")
	public void verifies_the_contact_name_raaj_and_kk_which_added(String firstname, String lastname) {
		Boolean b = driver.findElement(By.xpath("//span[text() = '"+firstname+" "+lastname+"']")).isDisplayed();
		if (b == true) {
			driver.quit();
		}
	}


}
	
	
	
	
	
	
	
	
	
	
	
	
	

//	@Given("User on the HomePage by using the (.*) and (.*) as creds")
//	public void User_on_theHomePage(String username, String password) {
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.get("https://freecrm.com/");
//
//		String title = driver.getTitle();
//		System.out.println(title);
//		Assert.assertEquals("#1 Free CRM Power Up your Entire Business Free Forever", title);
//		driver.findElement(By.xpath("//span[text()='Log In']")).click();
//
//		driver.findElement(By.name("email")).sendKeys(username);
//		driver.findElement(By.name("password")).sendKeys(password);
//
//		driver.findElement(By.xpath("//div[text() = 'Login']")).click();
//
//		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		boolean b = driver.findElement(By.xpath("//span[@class='user-display']")).isDisplayed();
//		Assert.assertTrue(b);
//
//	}
//
//	@When("User clicks on the Contacts and Title is Contacts")
//	public void User_Clicks_Contacts_and_verify_Contact() {
//		Actions actions = new Actions(driver);
//		actions.moveToElement(driver.findElement(By.xpath("//i[@class = 'home icon']")));
//		driver.findElement(By.xpath("//span[text() = 'Contacts']")).click();
//		boolean b = driver.findElement(By.xpath("//span[@class = 'selectable ' and text() = 'Contacts']"))
//				.isDisplayed();
//		Assert.assertTrue(b);
//	}
//
//	@Then("User clicks on Create button")
//	public void User_clicks_on_Create_Button() {
//		driver.findElement(By.xpath("//button[text() = 'Create']")).click();
//	}
//
//	@Then("^user enters all the fields like (.*), (.*), , (.*), (.*) and clicks save$")
//	public void User_enters_name_and_saves_it(String firstname, String lastname, String company, String email) {
//		driver.findElement(By.xpath("//input[@name = 'first_name']")).sendKeys(firstname);
//		driver.findElement(By.xpath("//input[@name = 'last_name']")).sendKeys(lastname);
//		driver.findElement(By.xpath("//div[@name = 'company']")).sendKeys(company);
//		driver.findElement(By.xpath("//input[@placeholder='Email address']")).sendKeys(email);
//		
//		driver.findElement(By.xpath("//button[text() = 'Save']")).click();
//	}
//
//	@Then("^Verifies the contact name (.*) and (.*) which added$")
//	public void Verifies_firstname_lastname(String firstname, String lastname) {
//		Boolean b = driver.findElement(By.xpath("//span[text() = '"+firstname+" "+lastname+"']")).isDisplayed();
//		if (b == true) {
//			driver.quit();
//		}
//	}


