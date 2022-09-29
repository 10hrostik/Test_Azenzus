package Icons;

import DriverInitialization.DriverConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class WindowIcons extends DriverConstructor {
    String label;
    String minimize;
    String maximize;
    String close;
    String searchText;
    String bottomIcon1;
    String bottomIcon2;
    String bottomIcon3;
    String bottomIcon4;

   public boolean check(){
       try {
           if (label != null) if (!driver.findElement(By.xpath(label)).isDisplayed()) return false;
           if (maximize != null) if (!driver.findElement(By.xpath(maximize)).isDisplayed()) return false;
           if (minimize != null) if (!driver.findElement(By.xpath(minimize)).isDisplayed()) return false;
           if (close != null) if (!driver.findElement(By.xpath(close)).isDisplayed()) return false;
           if (searchText != null) if (!driver.findElement(By.xpath(searchText)).isDisplayed()) return false;
           if (bottomIcon1 != null) if (!driver.findElement(By.xpath(bottomIcon1)).isDisplayed()) return false;
           if (bottomIcon2 != null) if (!driver.findElement(By.xpath(bottomIcon2)).isDisplayed()) return false;
           if (bottomIcon3 != null) if (!driver.findElement(By.xpath(bottomIcon3)).isDisplayed()) return false;
           if (bottomIcon4 != null) if (!driver.findElement(By.xpath(bottomIcon4)).isDisplayed()) return false;

           return true;
       }catch(NoSuchElementException e){
           System.out.print(e.getMessage());
           return false;
       }
   }
}
