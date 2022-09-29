package Pages;

import DriverInitialization.DriverConstructor;
import Icons.Director;
import Icons.SearchBuilder;
import ReadConfigs.Configs;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ToolsTool extends DriverConstructor {

    @FindBy(xpath = "//td[text() = 'Tools']")
    private WebElement toolsBox;

    public ToolsTool(){
        driver.get(Configs.URL);
        PageFactory.initElements(driver,this);
    }

    public void openList(){
        try{
            Thread.sleep(1500);
            toolsBox.click();
            boolean expected = true;
            Thread.sleep(200);
            Assert.assertEquals(expected,isDisplayed());

        }catch(Exception e){
            System.out.print(e.getMessage());
        }

    }

    public String windowCheck(String links[]){
        try{
            driver.findElement(By.xpath(links[0])).click();

            if(links[1]!= null)driver.findElement(By.xpath(links[1])).click();

            String[] buttonCheck = {links[2],links[3],links[4],links[5],links[6],links[7],links[8],links[8]};
            Director director=new Director();
            SearchBuilder builder=new SearchBuilder();
            director.buildTool(builder,buttonCheck);
            Assert.assertEquals(true,builder.getResult().check());

            if(!links[9].equals("not needed")&&!links[10].equals("not needed")){
                if(links[10].contains("Found")){
                    driver.findElement(By.xpath(links[9])).click();
                    Thread.sleep(1500);
                    String findElements = driver.findElement(By.xpath(links[10])).getText();
                    driver.findElement(By.xpath(links[5])).click();
                    return findElements;
                }else{
                     if(links[9].contains("table")){
                         driver.findElement(By.xpath(links[9])).click();
                         driver.findElement(By.xpath(links[10])).click();
                         List<WebElement> list = driver.findElement(By.xpath(links[11])).findElements(By.tagName(links[12]));

                         driver.findElement(By.xpath(links[5])).click();
                         return "Found "+list.size()+"+ elements";
                     }else{
                         driver.findElement(By.xpath(links[9])).click();
                         List<WebElement> list = driver.findElement(By.xpath(links[10])).findElements(By.tagName(links[11]));
                         driver.findElement(By.xpath(links[5])).click();
                         return "Found "+list.size()+"+ elements";
                     }
                }

            }else{
                System.out.println();
                driver.findElement(By.xpath(links[5])).click();
                return "Not Needed";
            }


        }catch(Exception e){
            System.out.println(e.getMessage());
            return "Not found";
        }
    }
    private boolean isDisplayed(){
        try{
            if(!driver.findElement(By.xpath("//div[text() = 'Administration']")).isDisplayed()) return false;
            if(!driver.findElement(By.xpath("//div[text() = 'Import (dynamic)']")).isDisplayed()) return false;
            if(!driver.findElement(By.xpath("//div[text() = 'Import Meta']")).isDisplayed()) return false;
            if(!driver.findElement(By.xpath("//div[text() = 'Queue Manager']")).isDisplayed()) return false;
            if(!driver.findElement(By.xpath("//div[text() = 'Trashed Items Manager']")).isDisplayed()) return false;

            return true;
        }catch(NoSuchElementException e){
            System.out.print(e.getMessage());
            return false;
        }
    }
}
