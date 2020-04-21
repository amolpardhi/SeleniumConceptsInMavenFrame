package synchronization;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {

	static WebDriver driver;

	public static void main(String[] args) throws Exception {

		String itemsNeeded[] = { "Cucumber", "Beetroot" };

		System.setProperty("webdriver.chrome.driver", ".\\browsers\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");

		Thread.sleep(3000);
		
		addItems(driver, itemsNeeded);
		
		Thread.sleep(3000);
		driver.quit();

	}

	public static void addItems(WebDriver driver, String[] itemsNeeded){

		int j = 0;

		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

		for (int i = 0; i < products.size(); i++)

		{ String[] name = products.get(i).getText().split("-");

			String formattedName = name[0].trim();

			List itemsNeededList = Arrays.asList(itemsNeeded);

			if (itemsNeededList.contains(formattedName))

			{ j++;

				// click on Add to cart

				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

				if (j == itemsNeeded.length)

				{	break; }

			}
		}
	}
}
