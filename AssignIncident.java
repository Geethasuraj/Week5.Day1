package week5.day1assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

@Test
public class AssignIncident extends BaseClass {

	public void assign() throws InterruptedException {
		driver.findElement(By.xpath("//div[text()='Open']")).click();
		driver.switchTo().frame("gsft_main");
		WebElement searchBox = driver.findElement(
				By.xpath("//span[contains(text(),'Press Enter from within the input to')]/following-sibling::input"));
		searchBox.sendKeys(incidentnumber, Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(),'INC')]")).click();
		driver.findElement(By.xpath("//button[@id='lookup.incident.assignment_group']")).click();
		Set<String> windowHandlesSet = driver.getWindowHandles();
		List<String> windowHandlesList = new ArrayList<String>(windowHandlesSet);
		driver.switchTo().window(windowHandlesList.get(1));
		// SELECTING SOFTWARE GROUP
		WebElement SGP = driver.findElementByXPath("(//input[@class='form-control'])[1]");
		SGP.sendKeys("Software");
		SGP.sendKeys(Keys.ENTER);
		// CLICKING ON SOFTWARE
		driver.findElementByXPath("//a[text()='Software']").click();
		// SWITCHING BACK TO PARENT WINDOW
		driver.switchTo().window(windowHandlesList.get(0));
		// SWITCHING OUT OF FRAME
		driver.switchTo().defaultContent();
		// SWITCHING IN TO FRAME
		driver.switchTo().frame(0);
		Thread.sleep(2000);
		JavascriptExecutor scroll = (JavascriptExecutor) driver;
		scroll.executeScript("window.scrollBy(0,400)");
		// Update the incident with Work Notes
		driver.findElementById("activity-stream-textarea").sendKeys("Test");
		// ClickKing on UPDATE
		driver.findElementByXPath("(//button[text()='Update'])[1]").click();

		WebElement Fortext1 = driver.findElementByXPath("//select[@class='form-control default-focus-outline']");
		Select drpdown = new Select(Fortext1);
		drpdown.selectByVisibleText("for text");
		Thread.sleep(2000);
		// Verify the Assignment group and Assigned for the incident
		driver.findElement(By.xpath("//a[contains(text(),'INC')]")).click();
		String assignedgrp = driver.findElement(By.xpath("//input[@id='sys_display.incident.assignment_group']"))
				.getAttribute("value");
		System.out.println(assignedgrp);
		if (assignedgrp.contains("Software")) {
			System.out.println("incident is assigned to software Group");
		}

	}

}
