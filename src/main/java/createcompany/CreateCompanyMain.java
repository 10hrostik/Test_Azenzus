package createcompany;

import java.io.IOException;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.StaleElementReferenceException;
import general.OpenManager;
import general.StartAndLogin;

public class CreateCompanyMain {
	
	private static WebDriver Az;
	public static int position=2;
	
	@Test
	public void company() throws InterruptedException, IOException {
		
		//Start and login(URL, Login, password)
		StartAndLogin azenzus = new StartAndLogin("https://test.covizmo.com/azenzus/");
		azenzus.loginAz("qa", "QAtest1-");
		Az = azenzus.getWebDriver();

		OpenManager.contactManager(Az);

		XlsxReaderForCompany reader = new XlsxReaderForCompany();
		String pathToFile = "A:\\Aaa\\SBM\\Create Contact 4_5_2021.xlsx";
		reader.readXlsx(pathToFile);

		sortByID();
		try {
			inputAllData();
		}
		catch(StaleElementReferenceException e) {
			//e.printStackTrace();
		}

		XlsxReaderForCompany.inputStream.close();
		XlsxReaderForCompany.saveResult(pathToFile.replace(".xlsx", "-Result.xlsx"));
	}
	
	private void buttonSearch() {
		WebElement buttonSearch = Az.findElement(By.xpath("//div[text()='Search']"));
        buttonSearch.click();
	}
	
	private void sortByID() {
		Actions action = new Actions(Az);
		WebElement contextMenu = Az.findElement(By.xpath("//div[text()='ID']"));
		action.contextClick(contextMenu).perform();
		WebElement optionSortDesc = Az.findElement(By.xpath("//div[text()='Sort Descending']"));
		optionSortDesc.click();
	}

	private void contextMenu() throws InterruptedException {
		Actions action = new Actions(Az);
		WebElement contextMenu = Az.findElement(By.xpath("//div[@eventproxy='CMListGrid_body']//table"));//"//div[text()='Contact Name']/ancestor::table/ancestor::div[2]/following-sibling::div//tr[1]/td[1]/div"
		action.contextClick(contextMenu).perform();
		Thread.sleep(150);
		
		WebElement buttonAdd = Az.findElement(By.xpath("//div[text()='Add']"));
        buttonAdd.click();
        Thread.sleep(250);
        
        WebElement buttonCompany = Az.findElement(By.xpath("//tr[@role='menuitem']//div[text()='Company']"));//"//div[text()='Person']//ancestor::tr/preceding-sibling::tr/td[2]/*[text()='Company']"
        buttonCompany.click();
        Thread.sleep(100);
	}
	
	private void inputCompanyName(String name) {
		WebElement fieldCompanyName = Az.findElement(By.xpath("//input[@name='name']"));
		fieldCompanyName.sendKeys(name);
	}
	
	private void inputDescription(String desc) {
		WebElement fieldDesc = Az.findElement(By.xpath("//textarea[@name='description']"));
		fieldDesc.sendKeys(desc);
	}
	
	private void inputEmail(String email) {
		WebElement fieldEmail = Az.findElement(By.xpath("//label[text()='E-mail']/parent::span/following-sibling::input[@name='editbox']"));
		email = email.replaceAll("^[\\#]", "");
		fieldEmail.sendKeys(email);
		WebElement buttonAdd = Az.findElement(By.xpath("//label[text()='E-mail']/ancestor::div[4]/following-sibling::div//div[text()='Add']"));
		buttonAdd.click();
	}
	
	private void inputPhone(String phone) {
		WebElement fieldPhone = Az.findElement(By.xpath("//div[text()='Tel']/ancestor::td[@class]/following-sibling::td/input"));
		fieldPhone.sendKeys(phone);
		WebElement buttonAdd = Az.findElement(By.xpath("//td[text()='Phones :']/ancestor::div[4]/following-sibling::div//div[text()='Add']"));
		buttonAdd.click();
	}
	
	private void inputHomePage(String homePage) {
		WebElement fieldHomePage = Az.findElement(By.xpath("//label[text()='Home pages']/parent::span/following-sibling::input[@name='editbox']"));
		homePage = homePage.replaceAll("^[\\#]", "");
		fieldHomePage.sendKeys(homePage);
		WebElement buttonAdd = Az.findElement(By.xpath("//label[text()='Home pages']/ancestor::div[4]/following-sibling::div//div[text()='Add']"));
		buttonAdd.click();
	}
	
	private void inputAdress(String street, String city, String region, String postalCode, String country, String postalBox) {
		WebElement buttonAdd = Az.findElement(By.xpath("//td[text()='Addresses :']/ancestor::div[2]/following-sibling::div//div[text()='Add']"));
		buttonAdd.click();
		WebElement fieldStreet = Az.findElement(By.xpath("//input[@name='street']"));
		fieldStreet.sendKeys(street);
		WebElement fieldCity = Az.findElement(By.xpath("//input[@name='town']"));
		fieldCity.sendKeys(city);
		WebElement fieldRegion = Az.findElement(By.xpath("//input[@name='region']"));
		fieldRegion.sendKeys(region);
		WebElement fieldPostalCode = Az.findElement(By.xpath("//input[@name='postalcode']"));
		fieldPostalCode.sendKeys(postalCode);
		WebElement fieldCountry = Az.findElement(By.xpath("//input[@name='country']"));
		fieldCountry.sendKeys(country);
		WebElement fieldPostalBox = Az.findElement(By.xpath("//input[@name='postalbox']"));
		fieldPostalBox.sendKeys(postalBox);	
	}
	
	private void inputAllData() throws InterruptedException, IOException {
		buttonSearch();
		Thread.sleep(1000);
		int count = XlsxReaderForCompany.getCount();
        do {
        	buttonSearch();
        	Thread.sleep(800);
        	try {
        		contextMenu();
        	}
        	catch (Exception e) {
        		try {
        			Thread.sleep(2000);
        			contextMenu();
        		}
        		catch (Exception e2) {
        			try {
        				Thread.sleep(2000);
            			contextMenu();
        			}
        			catch (Exception e3) {
        				e2.printStackTrace();
            			break;
        			}
        		}
        	}
        	String name = XlsxReaderForCompany.getCompanyName();
			inputCompanyName(name);
			
        	String desc, email, phone, homePage;
        	String[] adress;
        	if (XlsxReaderForCompany.ifValueExist(1) == true) {
        		desc = XlsxReaderForCompany.getDescription();
        		inputDescription(desc);
        	}
        	if (XlsxReaderForCompany.ifValueExist(2) == true) {
        		email = XlsxReaderForCompany.getEmail();
        		inputEmail(email);
        	}
        	if (XlsxReaderForCompany.ifValueExist(3) == true) {
        		phone = XlsxReaderForCompany.getPhone();
        		inputPhone(phone);
        	}
        	if (XlsxReaderForCompany.ifValueExist(4) == true) {
        		homePage = XlsxReaderForCompany.getHomePage();
        		inputHomePage(homePage);
        	}
    		        	
        	if (XlsxReaderForCompany.ifValueExist(5) == true) {
        		adress = XlsxReaderForCompany.getAdress();
            	inputAdress(adress[0], adress[1], adress[2], adress[3], adress[4], adress[5]);
        	}
        	
        	position++;
    		count--;
    		
        	while(position < XlsxReaderForCompany.getCount()) {
        		if (name == XlsxReaderForCompany.getCompanyName()) {
        			email = XlsxReaderForCompany.getEmail();
            		inputEmail(email);
                    phone = XlsxReaderForCompany.getPhone();
                    inputPhone(phone);
                   	homePage = XlsxReaderForCompany.getHomePage();
                   	inputHomePage(homePage);
                   	if (XlsxReaderForCompany.ifValueExist(5) == true) {
                   		adress = XlsxReaderForCompany.getAdress();
                       	inputAdress(adress[0], adress[1], adress[2], adress[3], adress[4], adress[5]);
                   	}
                   	position++;
                   	count--;
        		}
        		else {
        			break;
        		}
    		}
        	
    		buttonSave();
    		
    		try {
    			Thread.sleep(500);
    			Az.findElement(By.xpath("//p[contains(text(), 'email')]"));
    			XlsxReaderForCompany.setException("Too long email");
    			XlsxReaderForCompany.setResult("Not created");
        		System.out.println("Contact \""+name+"\" isn't created");
        		Thread.sleep(12000);
    		}
    		catch (Exception e) {
    			XlsxReaderForCompany.setID(getId());
        		XlsxReaderForCompany.setResult("Created");
    		}
    		
        }
        while(count!=2);
	}
	
	public int getId() throws InterruptedException {
		Thread.sleep(200);
    	int id  = Integer.parseInt(Az.findElement(By.xpath("//tr[@role='listitem'][@aria-posinset='1']/td[2]/div")).getText());
    	return id;
    }
	
	private void buttonSave() {
		WebElement buttonSave = Az.findElement(By.xpath("//div[text()='Save Company']"));
		buttonSave.click();
	}
}