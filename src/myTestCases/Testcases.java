package myTestCases;

import static org.testng.Assert.assertEquals;

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
		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

	}

	@Test(priority = 1, enabled = true)
	public void myTest() throws InterruptedException {

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

		Thread.sleep(3000);

		WebElement signUpMsg = driver.findElement(By.cssSelector(".message-success.success.message"));

		assertEquals(signUpMsg.isDisplayed(), true);
	}

	@Test(priority = 2, enabled = true)
	public void loginTest() throws InterruptedException {

		driver.findElement(By.cssSelector("div[class='panel header'] button[type='button']")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("div[aria-hidden='false'] li[data-label='or'] a")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("div[class='panel header'] li[data-label='or'] a")).click();
		Thread.sleep(3000);

		WebElement loginEmailInput = driver.findElement(By.id("email"));
		WebElement loginpassInput = driver.findElement(By.id("pass"));
		WebElement loginSubmmitBtn = driver.findElement(By.id("send2"));

		loginEmailInput
				.sendKeys(randoomFirstName[randFName] + randoomLastName[randLName] + randomNumber + "@gmail.com");
		loginpassInput.sendKeys(randoomFirstName[randFName] + randoomLastName[randLName] + randomNumber + "@");
		loginSubmmitBtn.click();

	}
}
