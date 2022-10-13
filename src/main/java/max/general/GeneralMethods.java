package max.general;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class GeneralMethods {
	
	public static String getObjectID(WebDriver Az, WebElement item) throws InterruptedException {
		var action = new Actions(Az); 
		action.moveToElement(item).perform();
		Thread.sleep(200);
		var labelID = Az.findElement(By.xpath("//b[contains(text(),'ID:')]"));
		String objectID = labelID.getText();
		objectID = objectID.replaceAll("ID:","");
		objectID = objectID.replaceAll(",","");
		Thread.sleep(2000);
		return objectID;
	}
	
	public static void closeProgressBar(WebDriver Az) throws InterruptedException {
		boolean st = false;
		do {
			try {
				Az.findElement(By.xpath("//body/div[contains(@eventproxy,'isc_ProgressBarQueueWindow')][last()-1]//b[text()='COMPLETED']"));
				st = true;
			}
			catch(NoSuchElementException e) {
				st = false;
			}
			Thread.sleep(500);
		}
		while(!st);
		Thread.sleep(500);
		var buttonClosePrBar = Az.findElement(By.xpath("//body/div[contains(@eventproxy,'isc_ProgressBarQueueWindow')][last()-1]//img[contains(@src,'close.png')]"));
		buttonClosePrBar.click();
	}
}