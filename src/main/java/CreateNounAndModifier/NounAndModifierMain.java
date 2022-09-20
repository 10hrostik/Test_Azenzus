package CreateNounAndModifier;

import java.io.IOException;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import General.OpenManager;
import General.StartAndLogin;

public class NounAndModifierMain extends XlsxReaderForNounAndModifier {
	
	public static int position=1;
	private WebDriver Az;
	
	@Test
	public void nounAndModifier() throws InterruptedException, IOException {
		
		//Start and login(URL, Login, password)
		StartAndLogin azenzus = new StartAndLogin("https://test.covizmo.com/azenzus/");
		azenzus.loginAz("qa", "QAtest1-");
		Az = azenzus.getWebDriver();   
		
        OpenManager.nounAndModifierManager(Az, "Product");
        XlsxReaderForNounAndModifier reader = new XlsxReaderForNounAndModifier();
		reader.readXlsx("A:\\Aaa\\Test N&M.xlsx");

        int count = reader.getCount();
        do {
        	String noun = reader.getNoun(position);
        	String modifier = reader.getModifier(position);
            if (noun != getPreviousNoun(position)) {
            	createNoun(noun);
        	}
            if (!reader.checkPreviousModifiers(position)) {
            	createModifier(modifier);
            }
            String pathToM = "//div[text()='"+modifier+"']";
            String pathToN = "//td[text()='"+noun+"']";
            scrollModifierTop();
            searchModifier(pathToM);
            scrollNounTop();
            searchNoun(pathToN);
            DragAndDrop(pathToM, pathToN);
            count--;
            position++;
        }
        while (count!=1);
        Az.close();
    }

	private void createNoun(String noun) throws InterruptedException {
		WebElement inputNoun = Az.findElement(By.xpath("//input[@name='noun']"));
		inputNoun.clear();
		inputNoun.sendKeys(noun);
	    Az.findElement(By.xpath("//div[contains(text(), 'Add')]")).click();
	    Thread.sleep(1000);
	}
	
	private void createModifier(String modifier) throws InterruptedException {
		WebElement inputModifier = Az.findElement(By.xpath("//input[@name='modifier']"));
        inputModifier.clear();
        inputModifier.sendKeys(modifier);
        Az.findElement(By.xpath("//input[@name='modifier']/ancestor::form/following-sibling::div[1]")).click();
        Thread.sleep(1000);
	}
	
	private void scrollNounTop() {
		Actions scrollN = new Actions(Az);
        WebElement scrollBarNoun = Az.findElement(By.xpath("//div[text()='Noun']/ancestor::div[5]//img[contains(@src, 'vthumb_stretch')]"));
        WebElement scrollTopNoun = Az.findElement(By.xpath("//div[text()='Noun']/ancestor::div[5]//img[contains(@src, 'vscroll_track_s')]"));
        scrollN.clickAndHold(scrollBarNoun).moveToElement(scrollTopNoun).release().perform();
	}
	
	private void scrollModifierTop() {
		Actions scrollM = new Actions(Az);
        WebElement scrollBarModifier = Az.findElement(By.xpath("//div[text()='Modifier']/ancestor::div[5]//img[contains(@src, 'vthumb_stretch')]"));
        WebElement scrollTopModifier = Az.findElement(By.xpath("//div[text()='Modifier']/ancestor::div[5]//img[contains(@src, 'vscroll_track_s')]"));
        scrollM.clickAndHold(scrollBarModifier).moveToElement(scrollTopModifier).release().perform();
	}
	
	private void searchNoun(String pathToNoun) {
		while(!checkIfNounPresent(pathToNoun)) {
            WebElement clickDownN = Az.findElement(By.xpath("//div[text()='Noun']/ancestor::div[5]//img[contains(@src, 'scroll_end')]"));
            clickDownN.click();        	
        }
	}
	
	private void searchModifier(String pathToModifier) {
		while(Az.findElement(By.xpath(pathToModifier)).isDisplayed() == false) {
            WebElement clickDownM = Az.findElement(By.xpath("//div[text()='Modifier']/ancestor::div[5]//img[contains(@src, 'scroll_end')]"));
            clickDownM.click();
        }
	}
	
	private boolean checkIfNounPresent(String path) {
		try {
			Az.findElement(By.xpath(path));
			return true;
		}
		catch (NoSuchElementException  e) {
			return false;
		}
	}
	
	private void DragAndDrop(String pathToModifier, String pathToNoun) throws InterruptedException {
		WebElement modifier1 = Az.findElement(By.xpath(pathToModifier));
        WebElement noun1 = Az.findElement(By.xpath(pathToNoun));
		Actions addModifierToNoun = new Actions(Az);
		addModifierToNoun.dragAndDrop(modifier1, noun1).build().perform();
        Thread.sleep(1000);
	}
}