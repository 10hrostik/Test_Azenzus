package azenzus.tree;

import azenzus.check.context.maincontext.ContextBuilder;
import azenzus.check.context.maincontext.Director;
import azenzus.check.context.subcontext.SubContextDirector;
import azenzus.check.context.subcontext.SubContextMenuBuilder;
import azenzus.resources.Links;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Function {
    private WebDriver driver;
    public Function(WebDriver driver){
        this.driver = driver;
    }
    public void openFunction(){
        try{
            driver.findElement(By.xpath("//table[contains(@style , '101px')]//img[contains(@src, 'selectPicker')]")).click();
            driver.findElement(By.xpath("//td[@height]//div[text() = 'Function']")).click();
            driver.findElement(By.xpath("//table[@width = 232]//span[contains(@style , 'opener')]")).click();

        }catch(NoSuchElementException e){
            System.out.println(e.getMessage());
        }
    }
    public boolean windowCheck(String mainLinks[],String subLinks[]) {
        try {
            WebElement item = driver.findElement(By.xpath("//td[contains(@id,'Tree_1_valueCell1')]"));
            Actions actions = new Actions(driver);
            Director director = new Director();
            ContextBuilder builder = new ContextBuilder();
            director.buildMain(builder,mainLinks);
            builder.getResult().setDriver(driver);
            String openContext[] = {"//i[contains(text(),'test')]", mainLinks[3]};

            SubContextDirector subContextDirector = new SubContextDirector();
            SubContextMenuBuilder subContextBuilder = new SubContextMenuBuilder();
            subContextDirector.buildSub(subContextBuilder,subLinks);
            subContextBuilder.getResult().setDriver(driver);
            Thread.sleep(1000);

            actions.contextClick(item).perform();
            Thread.sleep(700);
            actions.contextClick(item).perform();
            if(!builder.getResult().check(Links.contextMenu)) return false;

            actions.contextClick(item).perform();
            driver.findElement(By.xpath(mainLinks[3])).click();
            if(!subContextBuilder.getResult().checkNM(openContext, Links.subFunContextMenu[0])) return false;
            Thread.sleep(700);

            actions.contextClick(item).perform();
            driver.findElement(By.xpath(mainLinks[6])).click();
            if(!subContextBuilder.getResult().checkModelTree(Links.subFunContextMenu[1])) return false;
            Thread.sleep(700);

            actions.contextClick(item).perform();
            driver.findElement(By.xpath(mainLinks[7])).click();
            if(!subContextBuilder.getResult().checkDetach()) return false;
            Thread.sleep(700);

            openContext[1] = mainLinks[14];
            actions.contextClick(item).perform();
            driver.findElement(By.xpath(mainLinks[14])).click();
            if(!subContextBuilder.getResult().checkOrderEquipment(openContext,Links.subFunContextMenu[2], Links.subFunContextMenu[3], Links.subFunContextMenu[4])) return false;
            Thread.sleep(700);

            openContext[1] = mainLinks[15];
            actions.contextClick(item).perform();
            driver.findElement(By.xpath(mainLinks[15])).click();
            if(!subContextBuilder.getResult().checkChangeEquipment(openContext,Links.subFunContextMenu[5], Links.subFunContextMenu[6])) return false;
            driver.findElement(By.xpath("//td//span[contains(@id,'icon_1')]")).click();
            Thread.sleep(300);

            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
