package automate_Ajaxcalls_iFrames_ChildWindows;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleWindows {
	
	static WebDriver driver;
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", ".\\browsers\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://accounts.google.com/signup/v2/webcreateaccount?flowName=GlifWebSignIn&flowEntry=SignUp");
		
		driver.findElement(By.xpath("//a[text()='Privacy']")).click();		
		Set<String> ids = driver.getWindowHandles();
		Iterator<String> it = ids.iterator();
		String parentId = it.next();
		String childId = it.next();
		System.out.println(driver.switchTo().window(childId).getTitle());
		System.out.println(driver.switchTo().window(parentId).getTitle());
		
		driver.switchTo().window(childId).close();
		

		
	}
}
