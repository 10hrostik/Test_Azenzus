package masterreference;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import general.OpenManager;
import general.StartAndLogin;

public class MasterReferenceMain  {
	
	public static int position=2;
	private static WebDriver Az;
	public static boolean status = true;
	
	@Test
	public void masterReferenceMain() throws InterruptedException, IOException, AWTException {
		//Start and login(URL, Login, password)
		StartAndLogin azenzus = new StartAndLogin("https://test.covizmo.com/azenzus/");
		azenzus.loginAz("qa", "QAtest1-");
		Az = azenzus.getWebDriver();
				
        //create reader
        XslxReaderForMasterRef reader = new XslxReaderForMasterRef();
		String pathToFile = "A:\\Aaa\\1D420640.xlsx";
		reader.readXlsx(pathToFile);
		
		//Master manager (Equipment/Spare Parts/Document/Other...)
        OpenManager.masterdataManager(Az, "Equipment");
		while(position < XslxReaderForMasterRef.getCount()) {
			status = true;
			search();
			data();
	        if (status) {
	        	XslxReaderForMasterRef.setResult("Added");
	        }
	        else {
	        	XslxReaderForMasterRef.setResult("Error");
	        }
	        close();
			position++;
		}
		XslxReaderForMasterRef.inputStream.close();
		XslxReaderForMasterRef.saveResult(pathToFile.replace(".xlsx", "-Result.xlsx"));
	}
	
	public void data() throws InterruptedException, IOException, AWTException {
        if (checkIfExist()) {
        	openMaster();
        	if (checkIfPossible()) {
        		selectMeta();
        		putCode();
        		buttonCreate();
        		contextMenu();
        		if (status != false) {
        			if (checkIfRefExist()) {
	        			selectExistedMaster();
	        		}
	        		else {
	        			createNewMaster();
	        		}
        		}
        	}
        	else {
        		XslxReaderForMasterRef.setException("Can't add reference");
        	}
        }
        else {
        	XslxReaderForMasterRef.setException("Master with id "+XslxReaderForMasterRef.getMasterID()+" is not found");
        }
	}
	
	public void search() throws InterruptedException {
		WebElement input = Az.findElement(By.xpath("//input[@name='searchText']"));
		input.clear();
		Thread.sleep(100);
		input.sendKeys(XslxReaderForMasterRef.getMasterID());
		Thread.sleep(100);
		
		WebElement buttonSearch = Az.findElement(By.xpath("//div[contains(@eventproxy, 'MasterdataManagerWindowNew')]//div[text()='Search']"));
		buttonSearch.click();
		Thread.sleep(2000);
	}
	
	public boolean checkIfExist() throws InterruptedException {
		try {
			String id = XslxReaderForMasterRef.getMasterID();
			Az.findElement(By.xpath("//tr[@role='listitem']//div[text()='"+id+"']"));
			return true;
		}
		catch (NoSuchElementException e) {
			status = false;
			return false;
		}	
	}
	
	public void openMaster() throws InterruptedException {
		String id = XslxReaderForMasterRef.getMasterID();
		WebElement masterRecord = Az.findElement(By.xpath("//tr[@role='listitem']//div[text()='"+id+"']"));	
		Actions doubleClick = new Actions(Az);
		doubleClick.doubleClick(masterRecord).perform();
		Thread.sleep(3000);
	}
	
	public boolean checkIfPossible() {
		try {
			Az.findElement(By.xpath("//div[contains(@eventproxy, 'MasterdataInstanceWindow')]//img[contains(@src, 'add.png')]"));
			return true;
		}
		catch (NoSuchElementException e) {
			status = false;
			return false;
		}	
	}
	
	public void selectMeta() throws InterruptedException {
		WebElement buttonAdd = Az.findElement(By.xpath("//body/div[contains(@eventproxy, 'MasterdataInstanceWindow')][last()-1]//img[contains(@src, 'add.png')]"));
		buttonAdd.click();
		Thread.sleep(2000);
		
		WebElement comboboxRefType = Az.findElement(By.xpath("//body/div[contains(@eventproxy, 'RDCCodesEditorWindow')][last()-1]//label[text()='Reference Type']/ancestor::tr//div[@class='selectItemText']"));
		comboboxRefType.click();
		Thread.sleep(100);
		
		String meta = XslxReaderForMasterRef.getMetaName();
		WebElement optionSpecMeta = Az.findElement(By.xpath("//div[contains(@eventproxy, 'PickListMenu')]//div[contains(text(), '"+meta+"')]"));
		optionSpecMeta.click();
		Thread.sleep(100);
	}
	
	public static void putCode() {
		WebElement inputCode = Az.findElement(By.xpath("//body/div[contains(@eventproxy, 'RDCCodesEditorWindow')][last()-1]//input[@name='prefix']"));
		inputCode.clear();
		inputCode.sendKeys(XslxReaderForMasterRef.getCode());
	}
	
	public static void buttonCreate() throws InterruptedException {
		WebElement buttonCreate = Az.findElement(By.xpath("//body/div[contains(@eventproxy, 'RDCCodesEditorWindow')][last()-1]//div[contains(text(), 'Create')]"));
		buttonCreate.click();
		Thread.sleep(700);
	}
	
	public void contextMenu() throws InterruptedException, IOException {
		Thread.sleep(200);
		String tag = XslxReaderForMasterRef.getCode();
		WebElement code = Az.findElement(By.xpath("//body/div[contains(@eventproxy, 'RDCCodesEditorWindow')][last()-1]//div[contains(text(), '"+tag+"')]/ancestor::td/following-sibling::td[1]//i[text()='<empty>']"));	
		Actions contextClick = new Actions(Az);
		contextClick.contextClick(code).perform();
		Thread.sleep(200);
		selectContextOption();
	}
	
	public boolean checkIfRefExist() throws IOException {
		//true - exist; false - new
		String value = XslxReaderForMasterRef.getValueNewOrExisted();
        value = value.toLowerCase();
		if (value.equals("existed") || value.equals("existed ")) {
			String id = XslxReaderForMasterRef.getIdOfExistedMaster();
			if (id  == "" || id.isBlank() || id.isEmpty()) {
				status = false ;
				XslxReaderForMasterRef.setException("Id is missed in E"+(position+1));
			}
			return true;	
		}
		else {
			if(value.equals("new") || value.equals("new ")) {
				String name = XslxReaderForMasterRef.getNewMasterName();
				status = (name  == "" || name.isBlank() || name.isEmpty()) ? false : true;
				return false;
			}
			else {
				XslxReaderForMasterRef.setException("Incorrect value in cell D"+(position+1));
				status = false;
				return false;
			}
		}
	}
	
	public void selectContextOption() throws IOException {
		String value = XslxReaderForMasterRef.getValueNewOrExisted();
        value = value.toLowerCase();
		if (checkIfRefExist()) {
			Az.findElement(By.xpath("//body/div[contains(@eventproxy,'Menu')][last()-1]//div[text()='Attach Existed Reference']")).click();	
		}
		else {
			Az.findElement(By.xpath("//body/div[contains(@eventproxy,'Menu')][last()-1]//div[text()='Attach New Reference']")).click();
		}
	}
	
	//for EXISTED 
	public void selectExistedMaster() throws InterruptedException, IOException, AWTException {
		searchForE();
		selectMasterForE();
	}
	
	public void searchForE() throws InterruptedException, AWTException {
		Thread.sleep(2000);
		String value = String.valueOf(XslxReaderForMasterRef.getIdOfExistedMaster());
		StringSelection selectMetaFile = new StringSelection(value);
		Robot robot = new Robot();
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selectMetaFile, null);
		
		robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_A);
	    Thread.sleep(100);
	    
	    robot.keyRelease(KeyEvent.VK_CONTROL);
	    robot.keyRelease(KeyEvent.VK_A);
	    Thread.sleep(100);
		
	    robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
	    Thread.sleep(100);
	    
	    robot.keyRelease(KeyEvent.VK_CONTROL);
	    robot.keyRelease(KeyEvent.VK_V);
	    Thread.sleep(100);

	    robot.keyPress(KeyEvent.VK_ENTER);
	    robot.keyRelease(KeyEvent.VK_ENTER);
	    Thread.sleep(1200);
	}
	
	public void selectMasterForE() throws InterruptedException, IOException {
		try {
			String id = XslxReaderForMasterRef.getIdOfExistedMaster();
			WebElement master = Az.findElement(By.xpath("//tr[@role='listitem']//div[text()='"+id+"']"));	
			Actions doubleClick = new Actions(Az);
			doubleClick.doubleClick(master).perform();
			Thread.sleep(1500);
		}
		catch (Exception e) {
			XslxReaderForMasterRef.setException("Can't find master with id "+XslxReaderForMasterRef.getIdOfExistedMaster());
			status = false;
		}
		
	}
	
	//for NEW
	public void createNewMaster() throws InterruptedException, IOException {
		Thread.sleep(500);
		putMasterName();
		putMasterDesc();
		putCheckmarkReleased();
		buttonCreateNewMaster();
		if (checkIfCreated()) {
			XslxReaderForMasterRef.setResult("New master"+XslxReaderForMasterRef.getNewMasterName()+" is created");
		}
		String contact = XslxReaderForMasterRef.getNewManufacturer();
		if (contact  != "" && !contact.isBlank() && !contact.isEmpty()) {
			addContact();
		}
		putCheckmarkCatalogue();
		buttonSaveNewMaster();
		
	}
	
	public void putMasterName() throws InterruptedException {
		//WebElement inputName = Az.findElement(By.xpath("//body/div[contains(@eventproxy, 'KBWindow')][last()-1]//input[@name='txtName']"));
		String value = XslxReaderForMasterRef.getNewMasterName();
		Az.findElement(By.xpath("//body/div[contains(@eventproxy,'KBWindow')][last()-1]//input[@name='txtName']")).sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), value);
	}
	
	public void putMasterDesc() {
		WebElement inputDesc = Az.findElement(By.xpath("//div[contains(@eventproxy,'KBWindow')][last()-1]//textarea[@name='txtDescription']"));
		inputDesc.clear();
		inputDesc.sendKeys(XslxReaderForMasterRef.getNewMasterDesc());
	}
	
	public void putCheckmarkReleased() throws InterruptedException {
		if(XslxReaderForMasterRef.getNewReleased()) {
			Az.findElement(By.xpath("//div[contains(@eventproxy,'KBWindow')][last()-1]//label[text()='Released']/preceding-sibling::span")).click();
			Thread.sleep(200);
		}
	}
	
	public void buttonCreateNewMaster() throws InterruptedException {
		Az.findElement(By.xpath("//div[contains(@eventproxy,'KBWindow')][last()-1]//div[text()='Create']")).click();
		Thread.sleep(2000);
	}
	
	public void addContact() throws InterruptedException {
		Thread.sleep(1200);
		Az.findElement(By.xpath("//body/div[contains(@eventproxy,'MasterdataInstanceWindow')][last()-1]//td[text()='Contacts ']")).click();
		Thread.sleep(500);
		Az.findElement(By.xpath("//body/div[contains(@eventproxy,'MasterdataInstanceWindow')][last()-1]//div[text()='Add...'][@id]")).click();
		Thread.sleep(500);
		Az.findElement(By.xpath("//body/div[contains(@eventproxy,'ContactRoleEditDialog')][last()-1]//label[text()='Role']/ancestor::tr//div[@class='selectItemText']")).click();
		Thread.sleep(200);
		Az.findElement(By.xpath("//body/div[contains(@eventproxy,'PickListMenu')]//div[text()='Manufacturer'][not(@id)]")).click();
		Thread.sleep(200);
		Az.findElement(By.xpath("//body/div[contains(@eventproxy,'ContactRoleEditDialog')][last()-1]//img[contains(@src, 'add.png')]")).click();
		Thread.sleep(500);
		selectContactDialog();
		Az.findElement(By.xpath("//body/div[contains(@eventproxy,'ContactRoleEditDialog')][last()-1]//div[text()='OK'][@id]")).click();
		Thread.sleep(500);
		try {
			Az.findElement(By.xpath("//div[contains(@eventproxy,'ContactsTabItemList')]//div[text()='Manufacturer']"));
		}
		catch (Exception e) {
			System.out.println("Contact is not created");
			//setException
		}
		Thread.sleep(200);
	}
	
	public void selectContactDialog() throws InterruptedException {
		WebElement input = Az.findElement(By.xpath("//body/div[contains(@eventproxy,'SearchDialog')][last()-1]//input[@name='searchText']"));
		input.clear();
		String manufacturer = XslxReaderForMasterRef.getNewManufacturer();
		input.sendKeys(manufacturer);
		Az.findElement(By.xpath("//body/div[contains(@eventproxy,'SearchDialog')][last()-1]//div[text()='Search']")).click();
		Thread.sleep(500);
		WebElement contact = Az.findElement(By.xpath("//body/div[contains(@eventproxy,'SearchDialog')][last()-1]//div[text()='"+manufacturer+"']"));
		Actions doubleClick = new Actions(Az);
		doubleClick.doubleClick(contact).perform();
		Thread.sleep(200);
	}
	
	public void putCheckmarkCatalogue() throws InterruptedException {
		Az.findElement(By.xpath("//body/div[contains(@eventproxy, 'MasterdataInstanceWindow')][last()-1]//td[text()='Master Product']")).click();
		Thread.sleep(500);
		if(XslxReaderForMasterRef.getNewCatalogue()) {
			Az.findElement(By.xpath("//body/div[contains(@eventproxy, 'MasterdataInstanceWindow')][last()-1]//label[text()='Catalogue']")).click();
		}
	}
	
	public void buttonSaveNewMaster() throws InterruptedException {
		Az.findElement(By.xpath("//body/div[contains(@eventproxy, 'MasterdataInstanceWindow')][last()-1]//div[text()='Save']")).click();
		Thread.sleep(1500);
	}
	
	public boolean checkIfCreated() throws InterruptedException, IOException {
		try {
			Az.findElement(By.xpath("//div[@id='notifications']//p[text()='Done']"));
			return true;
		}
		catch (Exception e) {
			XslxReaderForMasterRef.setException("New master is not created");
			return false;
		}
	}
	
	public void close() throws InterruptedException {
		try {
			Az.findElement(By.xpath("//body/div[contains(@eventproxy, 'KBWindow')][last()-1]//img[contains(@src, 'close.png')]")).click();
			Thread.sleep(200);
		}
		catch (Exception ee) {}
		try {
			Az.findElement(By.xpath("//body/div[contains(@eventproxy, 'RDCCodesEditorWindow')][last()-1]//img[contains(@src, 'close.png')]")).click();
			Thread.sleep(200);
			tryToSync();
			try {
				Az.findElement(By.xpath("//body/div[contains(@eventproxy, 'MasterdataInstanceWindow')][last()-1]//img[contains(@src, 'close.png')]")).click();
				Thread.sleep(200);
			}
			catch (Exception ee) {}
		}
		catch (Exception e) {
			try {
				Az.findElement(By.xpath("//body/div[contains(@eventproxy, 'MasterdataInstanceWindow')][last()-1]//img[contains(@src, 'close.png')]")).click();
				Thread.sleep(200);
			}
			catch (Exception ee) {}
			try {
				Az.findElement(By.xpath("//body/div[contains(@eventproxy, 'RDCCodesEditorWindow')][last()-1]//img[contains(@src, 'close.png')]")).click();
				Thread.sleep(200);
				tryToSync();
			}
			catch (Exception ee) {}
			try {
				Az.findElement(By.xpath("//body/div[contains(@eventproxy, 'MasterdataInstanceWindow')][last()-3]//img[contains(@src, 'close.png')]")).click();
				Thread.sleep(200);
			}
			catch (Exception ee) {}
		}
	}
	
	private void tryToSync() {
		try {
			Az.findElement(By.xpath("//body/div[contains(@eventproxy, 'MasterdataInstanceWindow')][last()-3]//div[text()='Synchronize properties']")).click();
			Thread.sleep(200);
		}
		catch (Exception a) {
			try {
				Az.findElement(By.xpath("//body/div[contains(@eventproxy, 'MasterdataInstanceWindow')][last()-1]//div[text()='Synchronize properties']")).click();
				Thread.sleep(200);
			}
			catch (Exception b) {
				//do nothing
			}
		}
	}
}