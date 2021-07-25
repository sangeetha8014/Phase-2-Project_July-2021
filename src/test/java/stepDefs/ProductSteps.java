package stepDefs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductSteps {

	WebDriver driver = BaseClass.driver;

	@Given("^PF User has opened the SawagLabs applications$")
	public void pf_user_has_opened_the_sawaglabs_applications() throws Throwable {

		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(8000, TimeUnit.MILLISECONDS);

	}

	@When("^PF User enters username \"([^\"]*)\"$")
	public void pf_user_enters_username_something(String username) throws Throwable {

		WebElement UserName = driver.findElement(By.xpath("//*[@name='user-name']"));
		UserName.sendKeys(username);

	}

	@And("^PF User enters correct password \"([^\"]*)\"$")
	public void pf_user_enters_correct_password_something(String password) throws Throwable {

		WebElement Password = driver.findElement(By.xpath("//*[@id='password']"));
		Password.sendKeys(password);

	}

	@And("^PF User clicks on Login button$")
	public void pf_user_clicks_on_login_button() throws Throwable {

		WebElement Loginbutton = driver.findElement(By.xpath("//*[@id='login-button']"));

		Loginbutton.click();

	}

	@Given("^PF User should be landed on the Products Page$")
	public void pf_user_should_be_landed_on_the_products_page() throws Throwable {

		WebElement ProductPageTitle = driver.findElement(By.xpath("//*[@class='title']"));
		ProductPageTitle.isDisplayed();
		System.out.println("Inside Product Page");

	}

	@And("^PF User selects a single product and Click Add to Cart button \"([^\"]*)\"$")
	public void pf_user_selects_a_single_product_and_click_add_to_cart_button_something(String product)
			throws Throwable {

		System.out.println("Click Add to Cart button");

		WebElement ShoppingCart = driver.findElement(By.xpath("//*[text() = '" + product + "']//following::button[1]"));
		ShoppingCart.click();
		System.out.println("Selected the Product");
		Thread.sleep(3000);
	}

	@And("^PF User selects Product and clicks on Add to Cart button$")
	public void pf_user_selects_product_and_clicks_on_add_to_cart_button(DataTable table) throws Throwable {

		String Product1 = table.cell(0, 0);
		String Product2 = table.cell(1, 0);
		String Product3 = table.cell(2, 0);
		String Product4 = table.cell(3, 0);

		WebElement adProduct1 = driver.findElement(By.xpath("//*[text() = '" + Product1 + "']//following::button[1]"));
		adProduct1.click();
		WebElement adProduct2 = driver.findElement(By.xpath("//*[text() = '" + Product2 + "']//following::button[1]"));
		adProduct2.click();
		WebElement adProduct3 = driver.findElement(By.xpath("//*[text() = '" + Product3 + "']//following::button[1]"));
		adProduct3.click();
		WebElement adProduct4 = driver.findElement(By.xpath("//*[text() = '" + Product4 + "']//following::button[1]"));
		adProduct4.click();

		System.out.println("Product been selected in my cart");

	}

	@Then("^PF User should be able to view the product in Mycart$")
	public void pf_user_should_be_able_to_view_the_product_in_mycart() throws Throwable {

		WebElement ShoppingCart = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
		ShoppingCart.click();
		System.out.println("Go to My cart page");
		Thread.sleep(3000);

	}

	@Then("^PF User should able to see the products in My Cart$")
	public void pf_user_should_be_able_to_see_the_products_in_mycart() throws Throwable {

		WebElement ShoppingCart = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
		ShoppingCart.click();
		System.out.println("Go to My cart page");
		Thread.sleep(3000);

	}
}