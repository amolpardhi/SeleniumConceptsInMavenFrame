package automate_Ajaxcalls_iFrames_ChildWindows;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseInteractions {

	static WebDriver driver;

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.chrome.driver", ".\\browsers\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get("https://www.amazon.in/ref=nav_logo");

		// mouse hover
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.id("nav-link-accountList"))).build().perform();
		driver.findElement(By.xpath("//div[@id='nav-al-container'] //span[contains(text(),'Your Orders')]")).click();

		driver.navigate().back();

		action.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT)
				.sendKeys("amolpardhi").doubleClick().build().perform();
		
		Thread.sleep(3000);
		
		action.moveToElement(driver.findElement(By.id("nav-link-accountList"))).build().perform();
		
		Thread.sleep(2000);
		
		action.moveToElement(driver.findElement(By.id("glow-ingress-line2"))).contextClick().build().perform();

		Thread.sleep(4000);
		driver.quit();
	}
}
