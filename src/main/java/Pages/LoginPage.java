package Pages;
import DriverInitialization.DriverConstructor;
import ReadConfigs.Configs;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends DriverConstructor {

    @FindBy(xpath = "//input[@name ='loginField']")
    private WebElement LoginBox;

    @FindBy(xpath = "//input[@name='passwordField']")
    private WebElement PassWordBox;

    @FindBy(xpath = "//div[text() = 'Login']")
    private WebElement EnterBox;

    public LoginPage(){
        driver.get(Configs.URL);
        PageFactory.initElements(driver,this);
    }

    public LoginPage Auth(String login , String password){
        
        try{
            Thread.sleep(500);
            LoginBox.sendKeys(login);
            PassWordBox.sendKeys(password);
            EnterBox.click();
            Thread.sleep(1000);
            if(!driver.findElement((By.xpath("//td[text() = 'Search']"))).isDisplayed()){
                driver.findElement(By.xpath("//input[@name = 'username']")).sendKeys(login);
                driver.findElement(By.xpath("//input[@name = 'password']")).sendKeys(password);
                driver.findElement(By.xpath("//div[contains(@eventproxy,'LoginWindow')]//div[text()='Log in']")).click();
            }
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

}
