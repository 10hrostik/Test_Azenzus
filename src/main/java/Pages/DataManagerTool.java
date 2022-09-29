package Pages;

import DriverInitialization.DriverConstructor;
import Icons.Director;
import Icons.SearchBuilder;
import ReadConfigs.Configs;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DataManagerTool extends DriverConstructor {
    @FindBy(xpath = "//td[text() = 'Data Manager']")
    private WebElement DataBox;

    public DataManagerTool(){
        driver.get(Configs.URL);
        PageFactory.initElements(driver,this);
    }

    public void OpenList(){
        try{
            Thread.sleep(1500);
            DataBox.click();
            boolean expected[] = {true,true,true,true,true,true,true};
            Thread.sleep(200);
            Assert.assertArrayEquals(expected,isDisplayed());

        }catch(Exception e){
            System.out.print(e.getMessage());
        }

    }

    public String windowCheck(String[] links){
            try{
                driver.findElement(By.xpath(links[0])).click();
                if(links[1]!= null)driver.findElement(By.xpath(links[1])).click();
                if(links[2]!= null)driver.findElement(By.xpath(links[2])).click();

                String[] buttonCheck = {links[3],links[4],links[5],links[6],links[7],links[8],links[9],links[10]};
                Director director=new Director();
                SearchBuilder builder=new SearchBuilder();
                director.buildTool(builder,buttonCheck);
                Assert.assertEquals(true,builder.getResult().check());

                if(!links[11].equals("Not needed")){
                    if(links[12].contains("Found")){
                        driver.findElement(By.xpath(links[11])).click();
                        Thread.sleep(1500);
                        String findElements = driver.findElement(By.xpath(links[12])).getText();
                        driver.findElement(By.xpath(links[6])).click();
                        return findElements;
                    }if (links[11].contains("tbody")){
                        List<WebElement> list = driver.findElement(By.xpath(links[11])).findElements(By.tagName(links[12]));
                        driver.findElement(By.xpath(links[6])).click();
                        return "Found " + list.size() + "+ elements";
                    }
                    else{
                            driver.findElement(By.xpath(links[11])).click();
                            List<WebElement> list = driver.findElement(By.xpath(links[12])).findElements(By.tagName(links[13]));

                            driver.findElement(By.xpath(links[6])).click();
                            return "Found " + list.size() + "+ elements";
                    }

                }else{
                    System.out.println();
                    driver.findElement(By.xpath(links[6])).click();
                    return "Not Needed";
                }


            }catch(Exception e){
                System.out.println(e.getMessage());
                return "Not found";
            }
    }

    private boolean[] isDisplayed(){
        boolean mass[] = new boolean[7];
        if(driver.findElement(By.xpath("//div[text() = 'Synchronize']")).isDisplayed()) mass[0] =true;
        if(driver.findElement(By.xpath("//div[text() = 'Masterdata']")).isDisplayed()) mass[1] =true;
        if(driver.findElement(By.xpath("//div[text() = 'N&M Manager']")).isDisplayed()) mass[2] =true;
        if(driver.findElement(By.xpath("//div[text() = 'Link Types Manager']")).isDisplayed()) mass[3] =true;
        if(driver.findElement(By.xpath("//div[text() = 'Role Manager']")).isDisplayed()) mass[4] =true;
        if(driver.findElement(By.xpath("//div[text() = 'Unit Manager']")).isDisplayed()) mass[5] =true;
        if(driver.findElement(By.xpath("//div[text() = 'Reports Manager']")).isDisplayed()) mass[6] =true;

        return mass;
    }

}
