package me.tree;

import me.check.context.maincontext.ContextBuilder;
import me.check.context.maincontext.Director;
import me.check.context.subcontext.SubContextDirector;
import me.check.context.subcontext.SubContextMenuBuilder;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import me.page.LoginPage;
import me.resources.Configs;

import java.util.List;

public class Document extends LoginPage {

    public Document() {
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
            driver.findElement(By.xpath("//td[@height]//div[text() = 'Document']")).click();
            driver.findElement(By.xpath("//table[@width = 232]//span[contains(@style , 'opener')]")).click();

        }catch(NoSuchElementException e){
            System.out.println(e.getMessage());
        }
    }
    public boolean windowCheck(String mainLinks[],String subLinks[]) {
        try {

            WebElement item = driver.findElement(By.xpath("//i[contains(text(),'Covizmo')]"));
            Actions actions = new Actions(driver);

            Director director = new Director();
            ContextBuilder builder = new ContextBuilder();
            director.buildMain(builder,mainLinks);
            builder.getResult().setDriver(driver);

            SubContextDirector subContextDirector = new SubContextDirector();
            SubContextMenuBuilder subContextBuilder = new SubContextMenuBuilder();
            subContextDirector.buildSub(subContextBuilder,subLinks);
            subContextBuilder.getResult().setDriver(driver);
            Thread.sleep(1000);

            actions.contextClick(item).perform();
            Thread.sleep(700);
            actions.contextClick(item).perform();
            Assert.assertEquals(true,builder.getResult().check());



            actions.contextClick(item).perform();
            driver.findElement(By.xpath(mainLinks[3])).click();
            Assert.assertEquals(true,subContextBuilder.getResult().checkNM());
            Thread.sleep(700);

            actions.contextClick(item).perform();
            driver.findElement(By.xpath(mainLinks[6])).click();
            Assert.assertEquals(true,subContextBuilder.getResult().checkModelTree());
            Thread.sleep(700);

            actions.contextClick(item).perform();
            driver.findElement(By.xpath(mainLinks[7])).click();
            Assert.assertEquals(true,subContextBuilder.getResult().checkDetach());
            Thread.sleep(700);

            actions.contextClick(item).perform();
            driver.findElement(By.xpath(mainLinks[14])).click();
            Assert.assertEquals(true,subContextBuilder.getResult().checkOrderEquipment());
            Thread.sleep(700);

            actions.contextClick(item).perform();
            driver.findElement(By.xpath(mainLinks[15])).click();
            Assert.assertEquals(true,subContextBuilder.getResult().checkChangeEquipment());

            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
