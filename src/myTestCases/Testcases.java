package myTestCases;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import parameter.Parameters;

public class Testcases extends Parameters {

	WebDriver driver = new ChromeDriver();
	Actions action = new Actions(driver);

	@BeforeTest
	public void mySetupTest() {
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(9));

	}

	@Test(priority = 1, enabled = false)
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

		assertEquals(signUpMsg.getText(), "Thank you for registering with Main Website Store.");
	}

	@Test(priority = 2, enabled = false)
	public void loginTest() throws InterruptedException {

		driver.findElement(By.cssSelector("div[class='panel header'] button[type='button']")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("div[aria-hidden='false'] li[data-label='or'] a")).click();
		Thread.sleep(5000);
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

	@Test(priority = 2, enabled = true)
	public void navToTees() throws InterruptedException {

		WebElement aTag = driver
				.findElement(By.cssSelector("a[id='ui-id-4'] span[class='ui-menu-icon ui-icon ui-icon-carat-1-e']"));
		action.moveToElement(aTag).perform();
		Thread.sleep(1000);
		WebElement aTag1 = driver.findElement(By.cssSelector("#ui-id-9"));
		action.moveToElement(aTag1).perform();

		Thread.sleep(1000);
		WebElement aTag2 = driver.findElement(By.cssSelector("#ui-id-13"));
//		action.moveToElement(aTag2).click();
		aTag2.click();

	}

	@Test(priority = 3)
	public void addFirstThreeItems() throws InterruptedException {

		WebElement conteninerItem = driver.findElement(By.cssSelector(".products.list.items"));
		List<WebElement> itemBox = conteninerItem.findElements(By.tagName("li"));
		System.out.println(itemBox.size());

		for (int i = 0; i < 3; i++) {
			System.out.println(i);

			Thread.sleep(2000);

			action.moveToElement((WebElement) itemBox.get(i)).perform();

			Thread.sleep(2000);

			int countOfIndex = i + 1;

			WebElement contenierSize = driver
					.findElement(By.xpath("(//div[@aria-label='Size'])[" + countOfIndex + "]"));
			WebElement contenierColor = driver
					.findElement(By.xpath("(//div[@aria-label='Color'])[" + countOfIndex + "]"));

			List<WebElement> sizeBox = contenierSize.findElements(By.tagName("div"));
			List<WebElement> colorBox = contenierColor.findElements(By.tagName("div"));

			int randomSize = rand.nextInt(sizeBox.size());
			int randomColor = rand.nextInt(colorBox.size());

			sizeBox.get(randomSize).click();
			colorBox.get(randomColor).click();
			Thread.sleep(1000);

			driver.findElement(By.xpath("(//button[@title='Add to Cart'])[" + countOfIndex + "]")).click();
			Thread.sleep(1000);

		}

	}
}
