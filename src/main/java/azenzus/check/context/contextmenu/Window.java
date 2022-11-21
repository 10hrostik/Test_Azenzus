package azenzus.check.context.contextmenu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Window {
    private static Window window;
    private WebDriver driver;
    String label;
    String close;
    String maximize;
    String minimize;
    String button1;
    String button2;
    String button3;
    String button4;
    String button5;
    String button6;

    public void setDriver(WebDriver driver){
        this.driver = driver;
    }
    public static Window getWindow(){
        if(window == null){
           window = new Window();
        }
        return window;
    }
    public boolean isChecked(){
        try{
            boolean checkLabel = label != null && !driver.findElement(By.xpath(label)).isDisplayed();
            boolean checkMaximize = maximize != null && !driver.findElement(By.xpath(maximize)).isDisplayed();
            boolean checkMinimize = minimize != null && !driver.findElement(By.xpath(minimize)).isDisplayed();
            boolean checkClose = close != null && !driver.findElement(By.xpath(close)).isDisplayed();
            boolean checkButton1 = button1 != null && !driver.findElement(By.xpath(button1)).isDisplayed();
            boolean checkButton2 = button2 != null && !driver.findElement(By.xpath(button2)).isDisplayed();
            boolean checkButton3 = button3 != null && !driver.findElement(By.xpath(button3)).isDisplayed();
            boolean checkButton4 = button4 != null && !driver.findElement(By.xpath(button4)).isDisplayed();
            boolean checkButton5 = button5 != null && !driver.findElement(By.xpath(button5)).isDisplayed();
            boolean checkButton6 = button6 != null && !driver.findElement(By.xpath(button6)).isDisplayed();

            return (!checkLabel || !checkMaximize || !checkMinimize || !checkClose || !checkButton1
                    || !checkButton2 || !checkButton3 || !checkButton4 || !checkButton5 || !checkButton6
            );
        }catch (Exception e){
            return false;
        }
    }
}
