package azenzus.page;

import azenzus.resources.Configs;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class Authorization {
    private WebDriver driver;
    @FindBy(xpath = "//input[@name ='loginField']")
    private WebElement loginBox;
    @FindBy(xpath = "//input[@name='passwordField']")
    private WebElement passWordBox;
    @FindBy(xpath = "//div[text() = 'Login']")
    private WebElement enterBox;
    public Authorization(){
        String login = Configs.LOGIN;
        String password = Configs.PASSWORD;
        auth(login,password);
    }
    public Authorization auth(String login , String password){
        initDriver();
        try{
            Thread.sleep(500);
            loginBox.sendKeys(login);
            passWordBox.sendKeys(password);
            enterBox.click();
            Thread.sleep(1000);
            if (!driver.findElement((By.xpath("//td[text() = 'Search']"))).isDisplayed())
            Thread.sleep(500);
        }catch(InterruptedException e){
            System.out.println(e.getMessage());
        }
        catch(NoSuchElementException e){
            driver.findElement(By.xpath("//input[@name = 'username']")).sendKeys(login);
            driver.findElement(By.xpath("//input[@name = 'password']")).sendKeys(password);
            driver.findElement(By.xpath("//div[contains(@eventproxy,'LoginWindow')]//div[text()='Log in']")).click();
        }catch(StaleElementReferenceException e){
            System.out.println(e.getMessage());
        }
        return this;
    }
    private void initDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(65, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(65,TimeUnit.SECONDS);
        driver.get(Configs.URL);
        PageFactory.initElements(driver,this);
    }
    public WebDriver getDriver(){
        return driver;
    }
}
