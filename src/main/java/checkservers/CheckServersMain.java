package checkservers;

import javax.mail.internet.AddressException;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import general.OpenManager;
import general.SendEmail;
import general.StartAndLogin;

public class CheckServersMain {
	
	private WebDriver driver;
	private StartAndLogin server;
	private String[] emailList = {"maksymilianrrr@gmail.com", "mr@covizmo.com"};

	@Test
	public void checkdrivers() throws AddressException {
		
		server = new StartAndLogin("https://covizmo.com");
		driver = server.getWebDriver();
		
		//Website
		check("Covizmo website", "https://covizmo.com");
		
		//Azenzus
		check("Azenzus test driver", "https://test.covizmo.com/azenzus/", "qa", "QAtest1-");
		//https://pacificdrilling.covizmo.com/azenzus/
		//https://kb-md.covizmo.com/azenzus/
		//https://awilco.covizmo.com/azenzus/
		//https://sbm.covizmo.com/azenzus/
		//https://seadrill.covizmo.com/azenzus/
		
		//Asset navigator
		check("Asset Navigator", "https://test.covizmo.com/AssetNavigator/", "qa", "QAtest1-");
		
		//Kibana
		check("Kibana for test driver", "https://hudson.covizmo.com/app/home#/", "elastic", "ZGX4abIJnWJSgsM2b7W5");
		//https://awilco.covizmo.com/s/covizmo/login
		//https://sbm.covizmo.com/s/covizmo/login	
		
		//Hermes
		check("Hermes test driver", "https://test-identitydriver.namc-hermes.com/Account/Login", "mr@covizmo.com", "Qwerty1");
		//https://identitydriver.namc-hermes.com/Account/Login
		
		//DMM for Hermes
		check("DMM test for Hermes", "https://dmm-test.covizmo.com/driver/", "mr@covizmo.com", "Qwerty1");
		//https://dmm.covizmo.com/driver/
		
		//DMM for MODU
		check("DMM test for MODU", "https://testdmm.covizmo.com/driver/", "mr", "mr123");

		//DMM inspector
		check("Inspector test for MODU", "https://testdmm.covizmo.com/inspector/", "mr", "mr123");
	}
	
	private void check(String name, String url) throws AddressException {
		try {
			checkSite();
			System.out.println(name+ " is working properly\n");
		}
		catch (Exception e) {
			sendEmail(name, name+" may doesn't work. <br>Please, check the following url: <br>"+url+" <br><br><br><br><b>Exception:</b><br>"+e);
		}
	}
	
	private void check(String name, String url, String user, String password) throws AddressException {
		try {
			if (url.contains("azenzus")) {
				checkAz(url, user, password);
			}
			else if (url.contains("AssetNavigator")) {
				checkAssetNavigator(url, user, password);
			}
			else if (url.contains("/driver/")) {
				checkDmm(url, user, password);
			}
			else if (url.contains("inspector")) {
				checkInspector(url, user, password);
			}
			else if (url.contains("/s/covizmo/") || url.contains("hudson")) {
				checkKibana(url, user, password);
			}
			else if (url.contains("hermes")) {
				checkHermes(url, user, password);
			}
			else {
				System.out.println("PLEASE CHECK THE URL : "+url+"\n if the url is correct, notify mr about the problem");
			}
			System.out.println(name+" is working properly\n");
		}
		catch (Exception e) {
			sendEmail(name, name+" may doesn't work. <br>Please, check the following url: <br>"+url+" <br><br><br><br><b>Exception:</b><br>"+e);
		}
	}
	
	private void checkSite() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//img[contains(@src, 'covizmo-logo.png')]"));
		driver.findElement(By.xpath("//a[text()='Services']")).click();
		Thread.sleep(800);
		driver.findElement(By.xpath("//a[@data-popup='computer_vision']")).click();
		Thread.sleep(800);
		driver.findElement(By.xpath("//div[contains(@style, 'service-image1.jpg')]"));
		driver.findElement(By.xpath("//div[@id='computer_vision']//span[text()='+']")).click();
	}
	
	private void checkAz(String url, String user, String pasword) throws InterruptedException {
		server.reloadPage("https://test.covizmo.com/azenzus/");	
		server.loginAz("qa", "QAtest1-");		
		OpenManager.equipmentManager(driver);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[text()='Conditions reset']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//div[text()='Search']")).click();
		Thread.sleep(6000);
		driver.findElement(By.xpath("//td[contains(text(),'Found')][text()!='Found 0 object(s)']"));
		driver.findElement(By.xpath("//img[contains(@src,'close.png')]")).click();
		//to finish...
		driver.findElement(By.xpath("//div[text()='Log Out']")).click();
	}
	
	private void checkAssetNavigator(String url, String user, String pasword) throws InterruptedException {
		
		server.reloadPage(url);
		server.loginAz("qa", "QAtest1-");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//img[contains(@src, 'apps_icon')]")).click();
		Thread.sleep(100);
		driver.findElement(By.xpath("//div[text()='Search Manager']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//img[contains(@src, 'search.png')]")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//td[contains(text(),'Found')][text()!='Found 0 object(s)']"));
		driver.findElement(By.xpath("//div[text()='Logout']")).click();
	}
	
	private void checkDmm(String url, String user, String password) throws InterruptedException {
		server.reloadPage(url);	
		server.loginDmm(user, password);
		//to finish...
	}
	
	private void checkInspector(String url, String user, String password) throws InterruptedException {
		server.reloadPage(url);
		server.loginDmmInspector(user, password);
		//to finish...
	}
	
	private void checkKibana(String url, String user, String password) throws InterruptedException {
		server.reloadPage(url);
		Thread.sleep(2000);
		server.loginKibana(user, password);
		//to finish...
	}
	
	private void checkHermes(String url, String user, String password) throws InterruptedException {
		server.reloadPage(url);
		server.loginHermes(user, password);
		//to finish...
	}
	
	private void sendEmail(String server, String text) {
		SendEmail.sendEmails(server+" is not working", text, emailList);
	}
}