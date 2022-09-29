 package Import.test;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import general.GeneralMethods;

public class ContextMenuTreeSt {
	
	private static WebDriver Az = ImportAllTest.Az;
	
	public static void optionEdit(WebElement item) throws InterruptedException {
		var action = new Actions(Az); 
		action.contextClick(item).perform();
		var optionEdit = Az.findElement(By.xpath("//div[text()='Edit...']"));
		optionEdit.click();
		Thread.sleep(4000);
		
		try {
			var inputTag = Az.findElement(By.xpath("//body/div[contains(@eventproxy,'InstanceWindow')][last()-1]//input[@name='tagData']"));
			inputTag.sendKeys(" new");
			Thread.sleep(200);
			
			var inputDesc = Az.findElement(By.xpath("//body/div[contains(@eventproxy,'InstanceWindow')][last()-1]//input[@name='servicedescription']"));
			inputDesc.sendKeys(" new");
			Thread.sleep(200);
			
			var buttonSave = Az.findElement(By.xpath("//body/div[contains(@eventproxy,'InstanceWindow')][last()-1]//div[text()='Save']"));
			buttonSave.click();
			Thread.sleep(1000);
			
			var buttonClose = Az.findElement(By.xpath("//body/div[contains(@eventproxy,'InstanceWindow')][last()-1]//img[contains(@src,'close.png')]"));
			buttonClose.click();
			Thread.sleep(5000);  
		}
		catch(NoSuchElementException | StaleElementReferenceException exc) {
			System.out.println("\nOption \"Edit\" works incorrect!!!");
			exc.printStackTrace();
		}
	}
	
	public static void optionNounAndModifier(WebElement item, String type) throws InterruptedException {
		var action = new Actions(Az); 
		action.contextClick(item).perform();
		var optionNM = Az.findElement(By.xpath("//div[text()='Noun & Modifiers...']"));
		optionNM.click();
		Thread.sleep(200);
		var optionTypeNM = Az.findElement(By.xpath("//div[text()='"+type+"'][@role='presentation']"));
		optionTypeNM.click();
		Thread.sleep(2000);
		
		try {
			//first noun
			var noun1 = Az.findElement(By.xpath("//body/div[contains(@eventproxy,'isc_NounModifierPickerWindow')][last()-1]//tr[@aria-posinset='1']/td[2]//span"));
			noun1.click();
			Thread.sleep(200);
			String nameNoun1 = Az.findElement(By.xpath("//body/div[contains(@eventproxy,'isc_NounModifierPickerWindow')][last()-1]//tr[@aria-posinset='1']//td[text()]")).getText();
			
			var noun2 = Az.findElement(By.xpath("//body/div[contains(@eventproxy,'isc_NounModifierPickerWindow')][last()-1]//tr[@aria-posinset='2']/td[2]//span"));
			noun2.click();
			Thread.sleep(200);
			String nameNoun2= Az.findElement(By.xpath("//body/div[contains(@eventproxy,'isc_NounModifierPickerWindow')][last()-1]//tr[@aria-posinset='2']//td[text()]")).getText();
			
			System.out.println(nameNoun1+" "+nameNoun2);
			
			var buttonSave = Az.findElement(By.xpath("//body/div[contains(@eventproxy,'isc_NounModifierPickerWindow')][last()-1]//div[text()='Save']"));
			buttonSave.click();
			Thread.sleep(200);
		
			GeneralMethods.closeProgressBar(Az);
		}
		catch(NoSuchElementException | StaleElementReferenceException exc) {
			System.out.println("\nOption \"Noun & Modifier\" works incorrect!!!");
			exc.printStackTrace();
		}
	}
	
	public static void optionRefresh(WebElement item) throws InterruptedException {
		var action = new Actions(Az); 
		action.contextClick(item).perform();
		var optionRefresh = Az.findElement(By.xpath("//div[text()='Refresh']"));
		optionRefresh.click();
		Thread.sleep(2000);
	}
	
	public static void optionLinks(WebElement eq1, WebElement eq2) throws InterruptedException {

		String equipmentID2 = GeneralMethods.getObjectID(Az, eq2);
		var action = new Actions(Az); 
		action.contextClick(eq1).perform();
		var optionRefresh = Az.findElement(By.xpath("//div[text()='Mapping links']"));
		optionRefresh.click();
		Thread.sleep(1000);
		
		try {	
			var buttonFind = Az.findElement(By.xpath("//div[text()='Find ...']"));
			buttonFind.click();
			Thread.sleep(1500);
			
			var buttoMaximize = Az.findElement(By.xpath("//body/div[contains(@eventproxy,'ProductInstanceSelectWindow')][last()-1]//img[contains(@src,'maximize.png')]"));
			buttoMaximize.click();
			Thread.sleep(1000);
			
			var buttonConditionReset = Az.findElement(By.xpath("//body/div[contains(@eventproxy,'ProductInstanceSelectWindow')][last()-1]//img[text()='Conditions reset']"));
			buttonConditionReset.click();
			Thread.sleep(1000);
			
			var openAdvancedSearch = Az.findElement(By.xpath("//body/div[contains(@eventproxy,'ProductInstanceSelectWindow')][last()-1]//div[contains(text(),'Advanced Search')]"));
			openAdvancedSearch.click();
			Thread.sleep(1000);
			
			var inputID = Az.findElement(By.xpath("//input[@name='kbEquipmentsRangesTextBox']"));
			inputID.clear();
			inputID.sendKeys(equipmentID2);
			Thread.sleep(500);
			
			var buttonSearch = Az.findElement(By.xpath("//body/div[contains(@eventproxy,'ProductInstanceSelectWindow')][last()-1]//div[text()='Search']"));
			buttonSearch.click();
			Thread.sleep(1000);
			
			var actionSelectEquipment = new Actions(Az);
			var equpmentToBeSelected = Az.findElement(By.xpath("//body/div[contains(@eventproxy,'ProductInstanceSelectWindow')][last()-1]//tr[@aria-posinset='1']"));
			actionSelectEquipment.doubleClick(equpmentToBeSelected).perform();
			Thread.sleep(1000);
			
			var comboboxLinkType = Az.findElement(By.xpath("//div[contains(@eventproxy,'KBWindow')]//label[text()='Link Type']//ancestor::td/following-sibling::td//div"));
			comboboxLinkType.click();
			Thread.sleep(200);
			var linkType = Az.findElement(By.xpath("//div[contains(@eventproxy,'PickListMenu')]//tr[@aria-posinset='1']"));
			linkType.click();
			Thread.sleep(200);
			
			var buttonSave = Az.findElement(By.xpath("//div[contains(@eventproxy,'KBWindow')]//div[text()='Save']"));
			buttonSave.click();
			
			GeneralMethods.closeProgressBar(Az);

			//FOR FUTURE: test2 - check if notification appears
		}
		catch(NoSuchElementException | StaleElementReferenceException exc) {
			System.out.println("\nOption \"Links\" works incorrect!!!");
			exc.printStackTrace();
		}
	}
	
	public static void optionExpandAll(WebElement item) throws InterruptedException {
		var action = new Actions(Az); 
		action.contextClick(item).perform();
		var optionExpandAll = Az.findElement(By.xpath("//div[text()='Expand All']"));
		optionExpandAll.click();
		Thread.sleep(2000);
	}
	
	public static void optionCollapseAll(WebElement item) throws InterruptedException {
		var action = new Actions(Az); 
		action.contextClick(item).perform();
		var optionCollapseAll = Az.findElement(By.xpath("//div[text()='Collapse All']"));
		optionCollapseAll.click();
		Thread.sleep(2000);
	}
}