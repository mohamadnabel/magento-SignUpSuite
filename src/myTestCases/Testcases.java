package myTestCases;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

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

	@Test(priority = 2, enabled = false)
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

	@Test(priority = 1, enabled = true)
	public void navToBags() {
		WebElement aTag = driver.findElement(By.cssSelector("#ui-id-6"));
		action.moveToElement(aTag).perform();

		WebElement aTag1 = driver.findElement(By.cssSelector("#ui-id-25"));
		aTag1.click();
	}

	@Test(priority = 2, enabled = true)
	public void addOddNumberOfItem2() throws InterruptedException {
		WebElement containerItem = driver.findElement(By.cssSelector(".products.list.items.product-items"));
		List<WebElement> item = containerItem.findElements(By.tagName("li"));
		System.out.println("Total items: " + item.size());

		for (int i = 0; i < item.size(); i++) {
			Thread.sleep(1000);

			// Check if the index is odd
			if ((i % 2) == 0) {
				System.out.println(i + " is an even number.");

				 // Move to the item
				action.moveToElement(item.get(i)).perform();
				Thread.sleep(3000);

				// Get the count of index (1-based)
				int countOfIndex = i + 1;

				// Click the "Add to Cart" button
				WebElement btnAdd = driver
						.findElement(By.xpath("(//button[@title='Add to Cart'])[" + countOfIndex + "]"));
				btnAdd.click();
				Thread.sleep(2000);
			}
		}
	}

	@Test(priority = 3, enabled = false)
	public void addFirstThreeItems() throws InterruptedException {

		WebElement conteninerItem = driver.findElement(By.cssSelector(".products.list.items"));
		List<WebElement> itemBox = conteninerItem.findElements(By.tagName("li"));
		System.out.println(itemBox.size());

		for (int i = 0; i < 3; i++) {
			System.out.println(i);

			Thread.sleep(1000);

			action.moveToElement((WebElement) itemBox.get(i)).perform();

			Thread.sleep(1000);

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
			Thread.sleep(2000);

			driver.findElement(By.xpath("(//button[@title='Add to Cart'])[" + countOfIndex + "]")).click();
			Thread.sleep(2000);

		}

	}

	@Test(priority = 5, enabled = false)
	public void assertionForTotalItem() throws InterruptedException {

		Thread.sleep(2000);

		WebElement countOfItemInCard = driver.findElement(By.cssSelector(".counter-number"));

		String countOfItem = countOfItemInCard.getText();

		int countOfItemInteger = Integer.parseInt(countOfItem);

		assertEquals(countOfItemInteger, 0);
		Thread.sleep(2000);

	}

	@Test(priority = 6, enabled = false)
	public void checkTotalPrice() throws InterruptedException {
		driver.findElement(By.xpath("//a[@class='action showcart']")).click();
//		driver.findElement(By.cssSelector("#top-cart-btn-checkout")).click();
		Thread.sleep(2000);

	}

	@Test(priority = 5, enabled = false, description = "")
	public void checkSumPriceItemInCard() throws InterruptedException {
		Thread.sleep(2000);

		WebElement numOfItemPrice = driver.findElement(By.xpath("//span[contains(text(),'$190.00')]"));
		String itemNum = numOfItemPrice.getText();
		int countOfNum = Integer.parseInt(itemNum);
		System.out.println(countOfNum);
	}

	@Test(enabled = false)
	public void testtt() throws InterruptedException {
		driver.get("https://www.saucedemo.com/inventory.html");

		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();

		WebElement container = driver.findElement(By.className("inventory_list"));
		List<WebElement> product = container.findElements(By.tagName("button"));

		for (int i = 0; i < 3; i++) {

			int randomNum = rand.nextInt(product.size());

			product.get(randomNum).click();

			driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

			Thread.sleep(2000);

		}
	}
}
