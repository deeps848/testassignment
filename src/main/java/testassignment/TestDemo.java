package testassignment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TestDemo {
	public static void main(String args[]) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.saucedemo.com");
		//driver.get("https://www.selenium.dev/documentation/");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		//driver.findElement(By.name("password")).sendKeys("secret_sauce");
		//driver.findElement(By.name("q")).submit();
		//driver.findElement(By.tagName("input")).sendKeys("error_user");
		//driver.findElement(By.className("form_input")).sendKeys("problem_user");
		//driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
		//driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
		

		//driver.findElement(By.linkText("Overview")).click();
		//driver.findElement(By.partialLinkText("Manager")).click();
		
		//relative locators
//		WebElement pass = driver.findElement(By.id("password"));
//		By un = RelativeLocator.with(By.tagName("input")).above(pass);
//		driver.findElement(un).sendKeys("error_user");
		
		
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(1000);
		Actions actions = new Actions(driver);
		WebElement firstItem = driver.findElement
				(By.xpath("//*[@id=\"inventory_container\"]/div/div[1]"));
		actions.moveToElement(firstItem).perform();
	firstItem.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();
	Thread.sleep(2000);
	
	WebElement sortDropDown = driver.findElement(By.className("product_sort_container"));
	Select select = new Select(sortDropDown);
	select.selectByVisibleText("Price (low to high)");
	
	WebElement item2 = driver.findElement
			(By.xpath("//*[@id=\"inventory_container\"]/div/div[4]"));
			actions.moveToElement(item2).perform();
	firstItem.findElement
	(By.xpath("//*[@id=\"add-to-cart-test.allthethings()-t-shirt-(red)\"]")).click();

	Thread.sleep(6000);
	
	WebElement cartButton = driver.findElement(By.className("shopping_cart_link"));
	cartButton.click();
	Thread.sleep(6000);
	
	WebElement checkoutButton = driver.findElement
			(By.id("checkout"));
	checkoutButton.click();
	Thread.sleep(5000);
	
	WebElement firstName = driver.findElement(By.id("first-name"));
	WebElement lastName = driver.findElement(By.id("last-name"));
	WebElement postalCode = driver.findElement(By.id("postal-code"));
	
	firstName.sendKeys("Deepika");
	lastName.sendKeys("muralidharan");
	postalCode.sendKeys("620101");
	Thread.sleep(5000);
	
	WebElement continueButton = driver.findElement(By.id("continue"));
	continueButton.click();
	Thread.sleep(5000);
	
	WebElement finishButton = driver.findElement(By.id("finish"));
	finishButton.click();
	Thread.sleep(5000);
	
	WebElement orderConfirmation = driver.findElement(By.className("complete-header"));
	if(orderConfirmation.getText().equals("Thank you for your order!")) {
	System.out.println("Order placed Successfully");
	}
	else
	{
		System.out.println("order placement failed. plz try again..");
	}
	
	List<WebElement> items = driver.findElements(By.className("inventory_item"));
	System.out.println("Number of items:" +items.size());
	
	Thread.sleep(5000);
	driver.findElement(By.id("react-burger-menu-btn")).click();
	Thread.sleep(5000);
	driver.findElement(By.id("logout_sidebar_link")).click();
	Thread.sleep(1000);
	}

}
