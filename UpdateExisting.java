package week5.day1assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class UpdateExisting extends BaseClass {
	@Test
	public void update() throws InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("incidentnumber" + incidentnumber);
		driver.findElement(By.xpath("//div[text()='Open']")).click();
		driver.getTitle();
		driver.switchTo().frame("gsft_main");
		WebElement searchBox = driver.findElement(
				By.xpath("//span[contains(text(),'Press Enter from within the input to')]/following-sibling::input"));

		searchBox.sendKeys(incidentnumber, Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(),'INC')]")).click();
        //Update the incidents with Urgency as High and State as In Progress
		WebElement urgency = driver.findElement(By.xpath("//select[@id='incident.urgency']"));
		Select indexdrop = new Select(urgency);
		indexdrop.selectByVisibleText("1 - High");
		WebElement state = driver.findElement(By.xpath("//select[@id='incident.state']"));
		Select inc = new Select(state);
		inc.selectByValue("2");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("javascript:window.scrollBy(250,350)");
		driver.findElement(By.xpath("(//button[text()='Update'])[2]")).click();
        //verify the priority and state 
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(),'INC')]")).click();
		String statevalue = driver
				.findElement(By.xpath("(//span[text()='Incident state'])[1]/following-sibling::span/span")).getText();
		String priority = driver.findElement(By.xpath("(//span[text()='Priority'])[2]/following-sibling::span/span"))
				.getText();
		if (statevalue.contains(statevalue) && priority.contains(priority)) {
			System.out.println("Urgency as High and State as In Progress");

		} else {
			System.out.println("Urgency not High and State nots In Progress");
		}
	}
}
