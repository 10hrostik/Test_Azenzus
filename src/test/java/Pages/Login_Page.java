package Pages;
import Driver_Init.DriverConstructor;
import ReadConfigs.Configs;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Login_Page extends DriverConstructor {

    @FindBy(xpath = "//input[@name ='loginField']")
    private WebElement LoginBox;

    @FindBy(xpath = "//input[@name='passwordField']")
    private WebElement PassWordBox;

    @FindBy(xpath = "//td[text(),'Login']")
    private WebElement EnterBox;

    public Login_Page(){
        driver.get(Configs.URL);
        PageFactory.initElements(driver,this);
    }

    public Login_Page Auth(String login , String password){
        try{
            Thread.sleep(500);
            LoginBox.sendKeys(login);
            PassWordBox.sendKeys(password);
            EnterBox.click();
            Thread.sleep(500);

            LoginBox.sendKeys(login);
            PassWordBox.sendKeys(password);
            EnterBox.click();
            if(!driver.findElement(By.xpath("//td[contains(text() , 'Search')]")).isDisplayed()){

                driver.findElement(By.xpath("//input[@name = 'username']")).sendKeys(login);
                driver.findElement(By.xpath("//div[@eventproxy = 'isc_LoginWindow_0']//input[@name = 'password']")).sendKeys(password);
                driver.findElement(By.xpath("//div[@eventproxy = 'isc_LoginWindow_0']//div[contains(text(),'Log in')]")).click();
           }
            Thread.sleep(500);
        }catch(InterruptedException e){
            System.out.println(e.getMessage());
        }
        catch(NoSuchElementException e){
            System.out.println(e.getMessage());
        }catch(StaleElementReferenceException e){
            System.out.println(e.getMessage());
        }
        return this;
    }

}