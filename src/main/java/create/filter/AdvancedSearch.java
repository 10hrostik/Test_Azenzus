package create.filter;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AdvancedSearch {
	
	private WebDriver Az;
	
	public AdvancedSearch(WebDriver Az) {
		this.Az = Az;
	}
	
	public void advancedSearch() throws InterruptedException {
        Az.findElement(By.xpath("//div[contains (text(), 'Advanced Search')]")).click();
        Thread.sleep(2000);
    }
	
	public void buttonMetadata() throws InterruptedException {
		Az.findElement(By.xpath("//label[text()='Metadata']/ancestor::tr//img[contains (@src, 'add')]")).click();
		Thread.sleep(2000);
    }
	
	public void buttonMaster() throws InterruptedException {
		Az.findElement(By.xpath("//label[text()='Masters']/ancestor::tr//img[contains (@src, 'add')]")).click();
		Thread.sleep(2000);
    }
	
	public void buttonNounsAndModifiers() throws InterruptedException {
		Az.findElement(By.xpath("//label[text()='N&M']/ancestor::tr//img[contains (@src, 'add')]")).click();
		Thread.sleep(2000);
    }
	
	public void buttonProperties() throws InterruptedException {
		Az.findElement(By.xpath("//label[text()='Properties']/ancestor::tr//img[contains (@src, 'add')]")).click();
		Thread.sleep(2000);
        //new WebDriverWait(driver, 4).until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text() = 'Properties']/ancestor::tr//img[contains (@src, 'add')]"))).click();
    }
	
	public void buttonPlant() throws InterruptedException {
		Az.findElement(By.xpath("//label[text()='Plant']/ancestor::tr//img[contains(@src, 'add')]")).click();
		Thread.sleep(2000);
	}
	
	public void buttonContact() throws InterruptedException {
		Az.findElement(By.xpath("//label[text()='Contacts']/ancestor::tr//img[contains(@src, 'add')]")).click();
		Thread.sleep(2000);
	}
}

class SelectPlant {
	
	private WebDriver Az;
	
	public SelectPlant(WebDriver Az) {
		this.Az = Az;
	}
	
	public void buttonSearch() throws InterruptedException {
		Az.findElement(By.xpath("//div[contains(@eventproxy,'PlantManager')][last()-1]//div[text()='Search']")).click();
		Thread.sleep(2000);
	}
	
	public void selectPlant(String[] plants) throws InterruptedException {
        Thread.sleep(2000);
        Actions act = new Actions(Az);
        for (int i = 0; i <= plants.length - 1; i++) {
            act.keyDown(Keys.CONTROL).build().perform();
            Az.findElement(By.xpath(".//div[text()='"+plants[i]+"']")).click();
            act.keyUp(Keys.CONTROL).build().perform();
        }
    }

    public void buttonSelect() throws InterruptedException {
    	WebElement plant = Az.findElement(By.xpath("//div[contains(@eventproxy,'PlantManager')]//tr[@aria-selected='true'][1]"));
    	Actions act = new Actions(Az);
    	act.contextClick(plant).perform();
        Az.findElement(By.xpath("//td[not(@height)]/div[text()='Select'][@cellclipdiv]")).click();
        Thread.sleep(2000);
    }
}

class SelectContact {
	
	private WebDriver Az;
	
	public SelectContact(WebDriver Az) {
		this.Az = Az;
	}
	
	public void selectContactData(String type, String contact) throws InterruptedException {
		selectType(type);
		searchContact(contact);
        Az.findElement(By.xpath("//div[text()='"+contact+"']")).click();
    }
	
	public void clickSelect() throws InterruptedException{
        Az.findElement(By.xpath("//td[@class='buttonTitle']/div[text()='Select']")).click();
        Thread.sleep(500);
    }
	
	private void selectType(String type) throws InterruptedException {
		Az.findElement(By.xpath("//label[text()='Type']/parent::td/following-sibling::td//td[@class='selectItemPickerIcon']")).click();
        Az.findElement(By.xpath("//div[text()='"+type+"'][not(@id)]")).click();
        Thread.sleep(200);
	}
	
	private void searchContact(String contact) throws InterruptedException {
		Thread.sleep(500);
		Az.findElement(By.xpath("//div[contains(@eventproxy,'ContactRole')]//input[@name='searchText']")).sendKeys(contact);
        Az.findElement(By.xpath("//div[contains(@eventproxy,'ContactRole')]//div[text()='Search']")).click();
        Thread.sleep(2000);
	}
}

class SelectMaster {
	
	private WebDriver Az;
	
	public SelectMaster(WebDriver Az) {
		this.Az = Az;
	}
	
	public void searchMaster(String masterdata) {
        WebElement input = Az.findElement(By.xpath("(//td[text()='Products catalogue'])[1]/ancestor::div[contains(@eventproxy,'KBWindow')]//input"));
        input.clear();
        input.sendKeys(masterdata);
        Az.findElement(By.xpath("(//td[text()='Products catalogue'])[1]/ancestor::div[contains(@eventproxy,'KBWindow')]//div[text()='Search']")).click();
    }

    public void pickMaster(String masterdata) {
        WebElement row = null;
        try {
            row = Az.findElement(By.xpath("//div[text() = '"+masterdata+"']"));
        } 
        catch (Exception e) {
            row = Az.findElement(By.xpath("//font[text() = '"+masterdata+"']"));
        }
        finally {
            JavascriptExecutor js = (JavascriptExecutor) Az;
            js.executeScript("arguments[0].scrollIntoView();", row);
            Actions actions = new Actions(Az);
            actions.doubleClick(row).perform();
        }
    }
}