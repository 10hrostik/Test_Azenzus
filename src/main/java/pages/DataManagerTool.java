package pages;

import icons.Director;
import icons.SearchBuilder;
import resources.Configs;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DataManagerTool extends LoginPage {
    @FindBy(xpath = "//td[text() = 'Data Manager']")
    private WebElement dataBox;

    public DataManagerTool(){
        super();
        driver.get(Configs.URL);
        PageFactory.initElements(driver,this);
    }

    public void openList(){
        try{
            Thread.sleep(1500);
            dataBox.click();
            boolean expected=true;
            Thread.sleep(200);
            Assert.assertEquals(expected,isDisplayed());

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
                builder.getResult().setDriver(driver);
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
                        System.out.println(driver.findElement(By.xpath(links[11])).getText());
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

    private boolean isDisplayed(){
       try {
           if (!driver.findElement(By.xpath("//div[text() = 'Synchronize']")).isDisplayed()) return false;
           if (!driver.findElement(By.xpath("//div[text() = 'Masterdata']")).isDisplayed()) return false;
           if (!driver.findElement(By.xpath("//div[text() = 'N&M Manager']")).isDisplayed()) return false;
           if (!driver.findElement(By.xpath("//div[text() = 'Link Types Manager']")).isDisplayed()) return false;
           if (!driver.findElement(By.xpath("//div[text() = 'Role Manager']")).isDisplayed()) return false;
           if (!driver.findElement(By.xpath("//div[text() = 'Unit Manager']")).isDisplayed()) return false;
           if (!driver.findElement(By.xpath("//div[text() = 'Reports Manager']")).isDisplayed()) return false;

           return true;
       }catch(NoSuchElementException e){
           System.out.println(e.getMessage());
           return false;
       }
    }

}
