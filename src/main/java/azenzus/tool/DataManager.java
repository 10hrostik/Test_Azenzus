package azenzus.tool;

import azenzus.check.icon.Director;
import azenzus.check.icon.WindowBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DataManager {
    private boolean flag = true;
    private WebDriver driver;
    public DataManager(WebDriver driver){
        this.driver = driver;
    }
    public void openList(){
        try{
            Thread.sleep(1000);
            driver.findElement(By.xpath("//td[text() = 'Data Manager']")).click();
            Thread.sleep(200);
        }catch(Exception e){
            System.out.print(e.getMessage());
        }
    }
    public boolean windowCheck(String[] links){
            try{
                driver.findElement(By.xpath(links[0])).click();
                if(links[1]!= null)driver.findElement(By.xpath(links[1])).click();
                if(links[2]!= null)driver.findElement(By.xpath(links[2])).click();
                String[] buttonCheck = {links[3] , links[4] , links[5] , links[6] , links[7] , links[8] , links[9] , links[10]};

                Director director=new Director();
                WindowBuilder builder=new WindowBuilder();
                director.buildTool(builder,buttonCheck);
                builder.getResult().setDriver(driver);
                boolean checked = builder.getResult().check();
                driver.findElement(By.xpath(links[6])).click();
                return checked;
            }catch(Exception e){
                System.out.println(e.getMessage());
                return false;
            }
    }
    public boolean isDisplayed(){
       try {
           if (!driver.findElement(By.xpath("//div[text() = 'Synchronize']")).isDisplayed()) return false;
           if (!driver.findElement(By.xpath("//div[text() = 'Masterdata']")).isDisplayed()) return false;
           if (!driver.findElement(By.xpath("//div[text() = 'N&M Manager']")).isDisplayed()) return false;
           if (!driver.findElement(By.xpath("//div[text() = 'Link Types Manager']")).isDisplayed()) return false;

           if (!driver.findElement(By.xpath("//div[text() = 'Role Manager']")).isDisplayed()) return false;
           if (!driver.findElement(By.xpath("//div[text() = 'Unit Manager']")).isDisplayed()) return false;
           if (!driver.findElement(By.xpath("//div[text() = 'Reports Manager']")).isDisplayed()) return false;

           return true;
       }catch(Exception e){
           System.out.println(e.getMessage());
           return false;
       }
    }
}
