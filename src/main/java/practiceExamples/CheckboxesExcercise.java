package practiceExamples;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

	// 1. Check the first  Checkbox and verify if it is successfully checked and Uncheck 
	//it again to verify if it is successfully Unchecked.

	//2. How to get the Count of number of check boxes present in the page.

public class CheckboxesExcercise {

	static WebDriver driver;
	
	public static void main(String[] args) throws Exception {
		
		System.setProperty("webdriver.chrome.driver", ".\\browsers\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//1. Check the first  Checkbox and verify if it is successfully checked and Uncheck it again to verify if it is successfully Unchecked.
		driver.findElement(By.id("checkBoxOption1")).click();
		System.out.println(driver.findElement(By.id("checkBoxOption1")).isSelected());
		driver.findElement(By.id("checkBoxOption1")).click();
		System.out.println(driver.findElement(By.id("checkBoxOption1")).isSelected());
		
		//2. How to get the Count of number of check boxes present in the page
		List<WebElement> element = driver.findElements(By.xpath("//input[@type='checkbox']"));
		System.out.println("Count of number of check boxes present in the page are " + element.size());
		
		Thread.sleep(2000);
		driver.quit();
	}
}
