package uiWebelements;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendarUI {
	
	static WebDriver driver;

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", ".\\browsers\\chromedriver.exe");
		System.setProperty("webdriver.chrome.silentOutput", "true");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://www.path2usa.com/travel-companions");
		driver.findElement(By.id("travel_date")).click();
		
		List<WebElement> dates = driver.findElements(By.className("day"));
		int count = driver.findElements(By.className("day")).size();
		
		for (int i=0; i<count;i++) {
			String text = driver.findElements(By.className("day")).get(i).getText();
			if(text.equalsIgnoreCase("23")) 
			{
				driver.findElements(By.className("day")).get(i).click();
				break;
			}
		}
		
		
		
		//sumome-react-svg-image-container
		
		
	}
}
