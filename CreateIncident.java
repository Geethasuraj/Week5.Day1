package week5.day1assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import org.testng.annotations.Test;

@Test
public class CreateIncident extends BaseClass {

	public void create() throws InterruptedException {
		// TODO Auto-generated method stub
		driver.findElement(By.xpath("//div[text()='Create New']")).click();
		// Select a value for Caller and Enter value for short_description
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("(//span[@class='icon icon-search'])[1]")).click();
		Thread.sleep(2000);
		Set<String> windowHandleset = driver.getWindowHandles();
		List<String> windowHandlelist = new ArrayList<String>(windowHandleset);
		driver.switchTo().window(windowHandlelist.get(1));
		driver.findElement(By.xpath("(//a[@class='glide_ref_item_link'])[1]")).click();
		driver.switchTo().window(windowHandlelist.get(0));
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		System.out.println(driver.getTitle());
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//input[@id='incident.short_description']")).sendKeys("Test");

		// Read the incident number and save it a variable
		incidentnumber = driver.findElement(By.xpath("//input[@name='incident.number']")).getAttribute("value");
		System.out.println("incidentnumber" + incidentnumber);
		driver.findElement(By.xpath("(//button[text()='Submit'])[2]")).click();
		Thread.sleep(2000);
		// check the incident is created
		driver.switchTo().window(windowHandlelist.get(0));
		driver.switchTo().frame("gsft_main");
		WebElement searchBox = driver.findElement(
				By.xpath("//span[contains(text(),'Press Enter from within the input to')]/following-sibling::input"));
		searchBox.sendKeys(incidentnumber);
		searchBox.sendKeys(Keys.ENTER);

		String createdId = driver.findElement(By.xpath("//a[@class='linked formlink']")).getText();
		if (createdId.equals(incidentnumber)) {
			System.out.println("Incident number is created successfully " + createdId);
		}

	}
}
