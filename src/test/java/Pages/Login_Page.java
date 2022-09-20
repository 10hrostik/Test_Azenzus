package Pages;
import Driver_Init.DriverConstructor;
import ReadConfigs.Configs;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Login_Page extends DriverConstructor {

    @FindBy(xpath = "//*[@id='isc_J']")
    private WebElement LoginBox;

    @FindBy(xpath = "//*[@id=\"isc_N\"]")
    private WebElement PassWordBox;

    @FindBy(xpath = "/html/body/div[2]/div/div[1]/div/div/div/div/div/div[2]/div/div[1]/table/tbody/tr/td")
    private WebElement EnterBox;

    public Login_Page(){
        driver.get(Configs.URL);
        PageFactory.initElements(driver,this);
    }

    public Login_Page Auth(String login , String password){
        LoginBox.sendKeys(login);
        PassWordBox.sendKeys(password);
        EnterBox.click();
        return this;
    }

}
