package Pages;

import Driver_Init.DriverConstructor;
import ReadConfigs.Configs;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class Tools extends DriverConstructor {

    @FindBy(xpath = "//td[text() = 'Tools']")
    private WebElement ToolsBox;

    public Tools(){
        driver.get(Configs.URL);
        PageFactory.initElements(driver,this);
    }

    public void OpenList(){
        try{
            Thread.sleep(1500);
            ToolsBox.click();
            boolean expected[] = {true,true,true,true,true};
            Thread.sleep(200);
            Assert.assertArrayEquals(expected,isDisplayed());

        }catch(Exception e){
            System.out.print(e.getMessage());
        }

    }

    public String TrashedItemsCheck(){
        try{
            driver.findElement(By.xpath("//div[text() = 'Trashed Items Manager']")).click();
            boolean expected[] = {true,true,true,true,true,true,true};
            Assert.assertArrayEquals(expected,checkIcons("//table[@height = '18px']//td[text() = 'Trashed Items Manager']",
                    "//div[contains(@eventproxy,'TrashedItemsManagerWindow_0_max')]",
                    "//div[contains(@eventproxy,'TrashedItemsManagerWindow_0_min')]",
                    "//div[contains(@eventproxy,'TrashedItemsManagerWindow_0_cl')]",
                    "//div[contains(@eventproxy,'TrashedItemsManagerWindow_0')]//input[@name = 'searchTextBox']",
                    "//div[contains(@eventproxy,'TrashedItemsManagerWindow_0')]//div[text() = 'Conditions reset']",
                    "//div[contains(@eventproxy,'TrashedItemsManagerWindow_0')]//div[text() = 'Layout reset']"
            ));
            driver.findElement(By.xpath("//div[contains(@eventproxy,'TrashedItemsManagerWindow_0')]//div[text() = 'Search']")).click();
            Thread.sleep(1500);
            String findElements = driver.findElement(By.xpath("//div[contains(@eventproxy,'TrashedItemsManagerWindow_0')]//td[contains(text(),'Found')]")).getText();
            driver.findElement(By.xpath("//div[contains(@eventproxy,'TrashedItemsManagerWindow_0_cl')]")).click();
            return findElements+" Equipments";
        }catch(Exception e){
            System.out.println(e.getMessage());
            return "Not found";
        }
    }

    public String QueueManagerCheck(){
        try{
            driver.findElement(By.xpath("//div[text() = 'Queue Manager']")).click();
            boolean expected[] = {true,true,true,true,true,false,false};
            Assert.assertArrayEquals(expected,checkIcons("//table[@height = '18px']//td[text() = 'Queue manager']",
                    "//div[contains(@eventproxy,'QueueManagerWindow_0_max')]",
                    "//div[contains(@eventproxy,'QueueManagerWindow_0_min')]",
                    "//div[contains(@eventproxy,'QueueManagerWindow_0_cl')]",
                    "//div[contains(@eventproxy,'QueueManagerWindow_0')]//table[contains(@style,'772') ]",
                    null,
                    null
            ));
            driver.findElement(By.xpath("//div[contains(@eventproxy,'QueueManagerWindow_0')]//table[contains(@style,'772') ]")).click();
            Thread.sleep(800);
            driver.findElement(By.xpath("//div[contains(@eventproxy,'ListMenu')]//div[text() = 'EXPORT']")).click();
            List<WebElement> list = driver.findElement(By.xpath("//div[contains(@eventproxy,'QueueManagerWindowList')]//table[@width = 856]//tbody")).findElements(By.tagName("tr"));

            driver.findElement(By.xpath("//div[contains(@eventproxy,'QueueManagerWindow_0_cl')]")).click();
            return "Found "+list.size()+"+ export tools";
        }catch(Exception e){
            System.out.println(e.getMessage());
            return "Not found";
        }
    }

    public String ImportMetaCheck(){
        try{
            driver.findElement(By.xpath("//div[text() = 'Import Meta']")).click();
            boolean expected[] = {true,true,true,true,false,true,true};
            Assert.assertArrayEquals(expected,checkIcons("//table[@height = '18px']//td[text() = 'Import Meta Manager']",
                    "//div[contains(@eventproxy,'ImportMetaWindow_0_max')]",
                    "//div[contains(@eventproxy,'ImportMetaWindow_0_min')]",
                    "//div[contains(@eventproxy,'ImportMetaWindow_0_cl')]",
                    null,
                    "//div[contains(@eventproxy,'ImportMetaWindow_0')]//div[text() = 'Add file']",
                    "//div[contains(@eventproxy,'ImportMetaWindow_0')]//div[text() = 'Import']"
            ));
            Thread.sleep(800);

            driver.findElement(By.xpath("//div[contains(@eventproxy,'ImportMetaWindow_0_cl')]")).click();
            return "Import - not needed";
        }catch(Exception e){
            System.out.println(e.getMessage());
            return "Not found";
        }
    }
    public String ImportCheck(){
        try{
            driver.findElement(By.xpath("//div[text() = 'Import (dynamic)']")).click();
            boolean expected[] = {true,true,true,true,false,true,true};
            Assert.assertArrayEquals(expected,checkIcons("//table[@height = '18px']//td[text() = 'Import Manager']",
                    "//div[contains(@eventproxy,'SyncManagerWindow_0_max')]",
                    "//div[contains(@eventproxy,'SyncManagerWindow_0_min')]",
                    "//div[contains(@eventproxy,'SyncManagerWindow_0_cl')]",
                    null,
                    "//div[contains(@eventproxy,'SyncManagerWindow_0')]//div[text() = 'Prepare']",
                    "//div[contains(@eventproxy,'SyncManagerWindow_0')]//div[text() = 'Import']"
            ));
            Thread.sleep(800);

            driver.findElement(By.xpath("//div[contains(@eventproxy,'SyncManagerWindow_0_cl')]")).click();
            return "Import - not needed";
        }catch(Exception e){
            System.out.println(e.getMessage());
            return "Not found";
        }
    }
    private boolean[] isDisplayed(){
        boolean mass[] = new boolean[5];

        if(driver.findElement(By.xpath("//div[text() = 'Administration']")).isDisplayed()) mass[0] =true;
        if(driver.findElement(By.xpath("//div[text() = 'Import (dynamic)']")).isDisplayed()) mass[1] =true;
        if(driver.findElement(By.xpath("//div[text() = 'Import Meta']")).isDisplayed()) mass[2] =true;
        if(driver.findElement(By.xpath("//div[text() = 'Queue Manager']")).isDisplayed()) mass[3] =true;
        if(driver.findElement(By.xpath("//div[text() = 'Trashed Items Manager']")).isDisplayed()) mass[4] =true;

        return mass;
    }

    private boolean[] checkIcons(String lable,String maximize,String minimize,String close,String searchBox ,String lowButton1,String lowButton2){
        boolean isChecked[]= new boolean[7];
        try{
            Thread.sleep(200);
            if(lowButton1!=null&&lowButton2!=null) {
                if (driver.findElement(By.xpath(lowButton1)).isDisplayed()) isChecked[6] = true;
                if (driver.findElement(By.xpath(lowButton2)).isDisplayed()) isChecked[5] = true;
            }

            if(driver.findElement(By.xpath(lable)).isDisplayed()) isChecked[0] =true;
            if(driver.findElement(By.xpath(maximize)).isDisplayed()) isChecked[1] =true;
            if(driver.findElement(By.xpath(minimize)).isDisplayed()) isChecked[2] =true;
            if(driver.findElement(By.xpath(close)).isDisplayed()) isChecked[3] = true;
            if(searchBox!=null)if(driver.findElement(By.xpath(searchBox)).isDisplayed()) isChecked[4] =true;

            return isChecked;
        }catch(Exception e) {
            System.out.print(e.getMessage());
            return isChecked;
        }
    }
}
