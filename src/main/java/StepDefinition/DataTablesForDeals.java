package StepDefinition;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DataTablesForDeals {

	WebDriver driver;

	@Given("^user is on the Pre-login Page of FreeCRM$")
	public void user_is_on_the_pre_login_page_of_free_crm() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://freecrm.com/");
		

	}

	@When("^User user uses creds to login into the web app$")
	public void user_user_uses_creds_to_login_into_the_web_app(DataTable credsTable) {
		
		List<List<String>> credsList = credsTable.asLists();
		
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("#1 Free CRM Power Up your Entire Business Free Forever", title);
		driver.findElement(By.xpath("//span[text()='Log In']")).click();
		driver.findElement(By.name("email")).sendKeys(credsList.get(0).get(0));
		driver.findElement(By.name("password")).sendKeys(credsList.get(0).get(1));
		driver.findElement(By.xpath("//div[text() = 'Login']")).click();

	}

	@And("^User will be on the HomePage of FreeCRM$")
	public void user_will_be_on_the_home_page_of_free_crm() {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		boolean b = driver.findElement(By.xpath("//span[@class='user-display' and text() = 'Raju K']")).isDisplayed();
		Assert.assertTrue(b);
	}

	@And("^User clicks on the Deals nad create button$")
	public void user_clicks_on_the_deals_button() {
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//i[@class = 'home icon']")));
		driver.findElement(By.xpath("//span[text() = 'Deals']")).click();
		boolean b = driver
				.findElement(By.xpath("//div[@class='ui header item mb5 light-black']//span[text() = 'Deals']"))
				.isDisplayed();
		Assert.assertTrue(b);

		driver.findElement(By.xpath("//button[text() = 'Create']")).click();
	}

	@Then("^User adds the details in the fields and saves it$")
	public void user_adds_the_details_in_the_fields_and_saves_it(DataTable inputFields) {
		
		List<List<String>> FieldsList =  inputFields.asLists();
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.findElement(By.name("title")).sendKeys(FieldsList.get(0).get(0));
		driver.findElement(By.xpath("//div[@name = 'company']//input")).sendKeys(FieldsList.get(0).get(1));
		driver.findElement(By.xpath("//div[@name = 'products']//input")).sendKeys(FieldsList.get(0).get(2));
		driver.findElement(By.xpath("//div[@name = 'contacts']//input")).sendKeys(FieldsList.get(0).get(3));
		driver.findElement(By.xpath("//input[@name = 'amount']")).sendKeys(FieldsList.get(0).get(4));
		driver.findElement(By.xpath("//input[@name = 'commission']")).sendKeys(FieldsList.get(0).get(5));
		
	}

	@And("^User verifies it and closes the browser$")
	public void user_verifies_it_and_closes_the_browser() {
		
		driver.findElement(By.xpath("//button[text() = 'Save']")).click();
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		Boolean b = driver.findElement(By.xpath("//div[text() = 'Created By']")).isDisplayed();
		if (b == true) {
			driver.close();
		}
		
	}

}
