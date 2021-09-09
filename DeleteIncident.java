package week5.day1assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DeleteIncident extends BaseClass {
	
	@Test
	public void delete() throws InterruptedException {
		driver.findElement(By.xpath("//div[text()='Open']")).click();
		driver.getTitle();
		driver.switchTo().frame("gsft_main");
	WebElement searchBox = driver.findElement(By.xpath("//span[contains(text(),'Press Enter from within the input to')]/following-sibling::input"));

	searchBox.sendKeys(incidentnumber,Keys.ENTER);
	Thread.sleep(2000);
	driver.findElement(By.xpath("//a[contains(text(),'INC')]")).click();
	driver.findElement(By.xpath("//button[text()='Delete']")).click();
	driver.findElement(By.xpath("//button[@id='ok_button']")).click();
	//Search for the existing incident and navigate into the incident
	String norecord=driver.findElement(By.xpath("//td[text()='No records to display']")).getText();
	if(norecord.contains("No records")) {
		System.out.println("Record is deleted");
	}
	}
		
	}
	


