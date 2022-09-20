package General;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TreeStructure {
	
	private WebDriver Az;
	
	public TreeStructure(WebDriver Az) {
		this.Az = Az;
	}

	public void selectPlant(String plant) throws InterruptedException {
		Az.findElement(By.xpath("//label[text()='Plant']/parent::span/following-sibling::table//div")).click();
		Thread.sleep(500);
		Az.findElement(By.xpath("//div[text()='"+plant+"'][@role='presentation']")).click();
		Thread.sleep(500);
	}	

	public void buttonRefresh() throws InterruptedException {
		Az.findElement(By.xpath("//div[@eventproxy='kbPageLayout']//img[contains(@src, 'refresh.png')]")).click();
		Thread.sleep(500);
	}
	
	public void buttonAdd() throws InterruptedException {
		Az.findElement(By.xpath("//div[@eventproxy='kbPageLayout']//img[contains(@src,'images/actions/add.png')]")).click();
		Thread.sleep(500);
	}
	
	public void buttonEdit() throws InterruptedException {
		Az.findElement(By.xpath("//div[@eventproxy='kbPageLayout']//img[contains(@src,'images/actions/edit.png')]")).click();
		Thread.sleep(500);
	}
	
	public void buttonTrash() throws InterruptedException {
		Az.findElement(By.xpath("//div[@eventproxy='kbPageLayout']//img[contains(@src,'images/actions/trash.png')]")).click();
		Thread.sleep(500);
	}
}