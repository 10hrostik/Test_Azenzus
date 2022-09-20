package General;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ContextMenuTreeStructure {
	
	WebDriver Az;
	
	public ContextMenuTreeStructure(WebDriver Az) {
		this.Az = Az;
	}

	public void optionExpandAll(WebElement item) throws InterruptedException {
		Actions action = new Actions(Az); 
		action.contextClick(item).perform();
		Az.findElement(By.xpath("//div[text()='Expand All']")).click();
		Thread.sleep(2000);
	}
}