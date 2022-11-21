package azenzus.check.icon;


import azenzus.check.context.contextmenu.Window;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class WindowIcon {
    private static WindowIcon window;
    WebDriver driver;
    String label;
    String minimize;
    String maximize;
    String close;
    String searchText;
    String bottomIcon1;
    String bottomIcon2;
    String bottomIcon3;
    String bottomIcon4;
    public void setDriver(WebDriver driver){
        this.driver = driver;
    }
    public static WindowIcon getWindow(){
        if(window == null){
            window = new WindowIcon();
        }
        return window;
    }
   public boolean check(){
       try {

           boolean checkTitle = label != null && !driver.findElement(By.xpath(label)).isDisplayed();
           boolean checkMaximize = maximize != null && !driver.findElement(By.xpath(maximize)).isDisplayed();
           boolean checkMinimize = minimize != null && !driver.findElement(By.xpath(minimize)).isDisplayed();
           boolean checkClose = close != null && !driver.findElement(By.xpath(close)).isDisplayed();
           boolean checkSearch = searchText != null && !driver.findElement(By.xpath(searchText)).isDisplayed();
           boolean checkBottomIcon1 = bottomIcon1 != null && !driver.findElement(By.xpath(bottomIcon1)).isDisplayed();
           boolean checkBottomIcon2 = bottomIcon2 != null && !driver.findElement(By.xpath(bottomIcon2)).isDisplayed();
           boolean checkBottomIcon3 = bottomIcon3 != null && !driver.findElement(By.xpath(bottomIcon3)).isDisplayed();
           boolean checkBottomIcon4 = bottomIcon4 != null && !driver.findElement(By.xpath(bottomIcon4)).isDisplayed();

           return (!checkTitle || !checkMaximize || !checkMinimize || !checkClose || !checkSearch
                   || !checkBottomIcon1 || !checkBottomIcon2 || !checkBottomIcon3 || !checkBottomIcon4
           );
       }catch(NoSuchElementException e){
           System.out.print(e.getMessage());
           return false;
       }
   }
}
