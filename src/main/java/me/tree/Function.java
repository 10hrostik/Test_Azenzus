package me.tree;

import me.check.context.ContextBuilder;
import me.check.context.Director;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import me.page.LoginPage;
import me.resources.Configs;

import java.util.List;

public class Function extends LoginPage {

    public Function() {
        super();
        driver.get(Configs.URL);
        PageFactory.initElements(driver, this);
    }

    public void openPlant(){
        try{
            driver.findElement(By.xpath("//table[contains(@style , '143px')]//img[contains(@src, 'selectPicker')]")).click();
            List<WebElement> elements = driver.findElement(By.xpath("//table[@width = 139]//tbody")).findElements(By.tagName("tr"));
            elements.get(1).click();
            driver.findElement(By.xpath("//table[contains(@style , '101px')]//img[contains(@src, 'selectPicker')]")).click();
            driver.findElement(By.xpath("//td[@height]//div[text() = 'Function']")).click();
            List<WebElement> list = driver.findElement(By.xpath("//table[@width = 232]//tbody")).findElements(By.tagName("tr"));
            Actions act = new Actions(driver);
            act.contextClick(list.get(0)).perform();
            Thread.sleep(500);
        }catch(NoSuchElementException e){
            System.out.println(e.getMessage());
        }catch(InterruptedException e){
            System.out.println(e.getMessage());
        }
    }

    public boolean windowCheck(String links[]) {

        try {
            driver.findElement(By.xpath(links[0])).click();
            Director director=new Director();
            ContextBuilder builder= new ContextBuilder();
            String[] buttonCheck = {
                    links[0] , links[1] , links[2] , links[3] , links[4]
                    , links[5] , links[6] , links[7] , links[8] , links[9]
                    , links[10] , links[11] , links[12] , links[13] , links[14]
                    , links[15] , links[16] , links[17] , links[18] , links[19]
                    , links[20] , links[21] , links[22] , links[23] , links[24]
                    , links[25] , links[26] , links[27] , links[28] , links[29]
                    , links[30] , links[31] , links[32] , links[33] , links[34]
            };
            director.buildSearch(builder,buttonCheck);
            builder.getResult().setDriver(driver);
            Assert.assertEquals(true,builder.getResult().check());

            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
