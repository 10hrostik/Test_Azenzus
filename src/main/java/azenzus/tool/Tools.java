package azenzus.tool;

import azenzus.check.icon.Director;
import azenzus.check.icon.WindowBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class Tools {
    private WebDriver driver;
    public Tools(WebDriver driver){
        this.driver = driver;
    }
    public void openList(){
        try{
            Thread.sleep(1500);
            driver.findElement(By.xpath("//td[text() = 'Tools']")).click();
            Thread.sleep(200);
        }catch(Exception e){
            System.out.print(e.getMessage());
        }
    }
    public boolean windowCheck(String links[]){
        try{
            driver.findElement(By.xpath(links[0])).click();
            if (links[1]!= null)driver.findElement(By.xpath(links[1])).click();
            String[] buttonCheck = {links[2] , links[3] , links[4] , links[5] , links[6] , links[7] , links[8] , links[8]};

            Director director=new Director();
            WindowBuilder builder=new WindowBuilder();
            director.buildTool(builder,buttonCheck);
            builder.getResult().setDriver(driver);
            boolean checked = builder.getResult().check();
            driver.findElement(By.xpath(links[5])).click();

            return checked;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    public boolean isDisplayed(){
        try{
            if (!driver.findElement(By.xpath("//div[text() = 'Administration']")).isDisplayed()) return false;
            if (!driver.findElement(By.xpath("//div[text() = 'Import (dynamic)']")).isDisplayed()) return false;
            if (!driver.findElement(By.xpath("//div[text() = 'Import Meta']")).isDisplayed()) return false;
            if (!driver.findElement(By.xpath("//div[text() = 'Queue Manager']")).isDisplayed()) return false;
            if (!driver.findElement(By.xpath("//div[text() = 'Trashed Items Manager']")).isDisplayed()) return false;

            return true;
        }catch(NoSuchElementException e){
            System.out.print(e.getMessage());
            return false;
        }
    }
}
