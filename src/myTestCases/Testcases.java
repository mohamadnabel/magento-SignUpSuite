package myTestCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import parameter.Parameters;

public class Testcases extends Parameters {

	WebDriver driver = new ChromeDriver();

	@BeforeTest
	public void mySetupTest() {
		driver.get(URL);
	}

	@Test(priority = 1, enabled = true)
	public void myTest() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();

		WebElement signUp = driver
				.findElement(By.cssSelector("header[class='page-header'] li:nth-child(3) a:nth-child(1)"));

		signUp.click();

		WebElement firstNameInput = driver.findElement(By.cssSelector("#firstname"));

		firstNameInput.sendKeys(randoomFirstName[randFName]);

		WebElement lastNameInput = driver.findElement(By.cssSelector("#lastname"));

		lastNameInput.sendKeys(randoomLastName[randLName]);

		WebElement emailInput = driver.findElement(By.cssSelector("#email_address"));

		emailInput.sendKeys(randoomFirstName[randFName] + randoomLastName[randLName] + randomNumber + "@gmail.com");

		WebElement passInput = driver.findElement(By.cssSelector("#password"));

		passInput.sendKeys(randoomFirstName[randFName] + randoomLastName[randLName] + randomNumber + "@");

		WebElement passConfirmeInput = driver.findElement(By.cssSelector("#password-confirmation"));

		passConfirmeInput.sendKeys(randoomFirstName[randFName] + randoomLastName[randLName] + randomNumber + "@");

		WebElement submitBtn = driver.findElement(By.cssSelector("button[title='Create an Account']"));

		submitBtn.click();
	}
}
