package Test_Step1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class cs1 {
	public static WebDriver driver; 
	@Given("^user navigates to testmeapp$")
	public void user_navigates_to_testmeapp() throws Throwable 
	{
		System.out.println("Navigate to the testmeapp");
		System.setProperty("Webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://lkmdemoaut.accenture.com/TestMeApp/fetchcat.htm");
		driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/div/div/div[2]/div/ul/li[1]/a")).click();
	}

	@When("^i enter username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
	public void i_enter_username_as_and_password_as(String username, String password) throws Throwable 
	{
		System.out.println("Enter username and password");
		driver.findElement(By.name("userName")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.xpath("/html/body/main/div/div/div/form/fieldset/div[4]/div/input[1]")).click();
	}

	@Then("^Login should be unsuccessful$")
	public void login_should_be_unsuccessful() throws Throwable 
	{
		String str = driver.findElement(By.xpath("//*[@id=\"errormsg\"]")).getText();
		if(str.contentEquals("Username or Password is wrong here!!!"))
		{
			System.out.println("Login failed");
		}
		else
		{
			System.out.println("login successful");
		}
		driver.close();
	}

	

}
