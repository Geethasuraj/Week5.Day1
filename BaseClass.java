package week5.day1assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public ChromeDriver driver;
	public static String incidentnumber;

	@BeforeMethod
	public void preCondition() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(
				"https://dev89751.service-now.com/nav_to.do?uri=%2Fui_page.do%3Fsys_id%3D1f871d002fe230108e4cf7ecf699b604");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.switchTo().frame(0);
		driver.findElementById("user_name").sendKeys("admin");
		driver.findElementById("user_password").sendKeys("Akshara@01");
		driver.findElementById("sysverb_login").click();
		Thread.sleep(3000);
		driver.findElementByXPath("//input[@id='filter']").sendKeys("incident", Keys.ENTER);
		Thread.sleep(2000);

	}

	@AfterMethod
	public void logout() {
		driver.close();
	}

}
