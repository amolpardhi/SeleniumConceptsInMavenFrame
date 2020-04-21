package uiWebelements;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertConcept {
	
	static WebDriver driver;
	
	public static void main(String[] args) throws Exception {
		
		System.setProperty("webdriver.chrome.driver", ".\\browsers\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.name("enter-name")).sendKeys("Aarav Pardhi");
		driver.findElement(By.id("alertbtn")).click();
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		Thread.sleep(3000);
		alert.accept();
		
		driver.findElement(By.name("enter-name")).sendKeys("Aarav Pardhi");
		driver.findElement(By.id("confirmbtn")).click();
		System.out.println(alert.getText());
		Thread.sleep(3000);
		alert.dismiss();
		
		Thread.sleep(3000);
		driver.quit();
	}
}
