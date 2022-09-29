package general;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StartAndLoginKeycloak {
	
	public static WebDriver Az;
	
	public static void startAz(String url) {
        System.setProperty("webdriver.chrome.driver", "A:\\chromedriver.exe");
        Az = new ChromeDriver();
        Az.manage().window().setPosition(new Point(1500,10));
        Az.manage().window().maximize(); 
        Az.get(url);
	}
	
	public static void login(String loginValue, String passwordValue) throws InterruptedException {
	    WebElement login = Az.findElement(By.xpath("//input[@id='username']"));
	    WebElement password = Az.findElement(By.xpath("//input[@id='password']"));
	    WebElement buttonLogin = Az.findElement(By.xpath("//input[@id='kc-login']"));
	    
	    login.sendKeys(loginValue);
	    password.sendKeys(passwordValue);
	    buttonLogin.click();
	    Thread.sleep(6000);
	    System.out.println("User \""+loginValue+"\" logined successfully");
	}
}
