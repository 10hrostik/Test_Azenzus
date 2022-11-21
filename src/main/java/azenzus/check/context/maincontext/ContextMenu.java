package azenzus.check.context.maincontext;

import azenzus.check.context.contextmenu.Builder;
import azenzus.check.context.contextmenu.Director;
import azenzus.check.context.contextmenu.Window;
import azenzus.check.context.contextmenu.WindowBuilder;
import azenzus.resources.Links;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ContextMenu {
    private static ContextMenu contextMenu;
    private WebDriver driver;
    private Director director = new Director();;
    private Builder builder = new WindowBuilder();
    String synchronize;
    String edit;
    String editMaster;
    String addContact;
    String mappingLinks;
    String modelTree;
    String detach;
    String moveItem;
    String replaceMeta;
    String visibility;
    String history;
    String details;
    String locator;
    String orderItem;
    String changeItem;
    String print;
    String refresh;
    String expand;
    String collapse;
    String nm;
    public void setDriver(WebDriver driver){
        this.driver=driver;
    }
    public static ContextMenu getContextMenu(){
        if(contextMenu == null){
            contextMenu = new ContextMenu();
        }
        return contextMenu;
    }
    public boolean check(String menuLinks[][]){
        try {
            boolean checkSynchronize = synchronize != null && !driver.findElement(By.xpath(synchronize)).isDisplayed();
            boolean checkEdit = edit != null && !windowCheck(edit, menuLinks[0]);
            boolean checkEditMaster = editMaster != null && !driver.findElement(By.xpath(editMaster)).isDisplayed();
            boolean checkAddContact = addContact != null && !driver.findElement(By.xpath(addContact)).isDisplayed();
            boolean checkMappingLinks = mappingLinks != null && !driver.findElement(By.xpath(mappingLinks)).isDisplayed();
            boolean checkHistory = history != null && menuLinks[1][0].contains("PlantWindow") ? !windowCheck(history, menuLinks[1]) : !driver.findElement(By.xpath(history)).isDisplayed();;
            boolean checkModelTree = modelTree != null && menuLinks[1][0].contains("KBWindow") ? !windowCheck(modelTree, menuLinks[1]) : !driver.findElement(By.xpath(modelTree)).isDisplayed();
            boolean checkReplaceMeta = replaceMeta != null && !driver.findElement(By.xpath(replaceMeta)).isDisplayed();
            boolean checkVisibility = visibility != null && !driver.findElement(By.xpath(visibility)).isDisplayed();
            boolean checkDetach = detach != null && !driver.findElement(By.xpath(detach)).isDisplayed();
            boolean checkDetails = details != null && !windowCheck(details, menuLinks[2]);
            boolean checkMoveItem = moveItem != null && !driver.findElement(By.xpath(moveItem)).isDisplayed();
            boolean checkLocator = locator != null && !windowCheck(locator, menuLinks[3]);
            boolean checkOrderItem = orderItem != null && !windowCheck(orderItem, menuLinks[4]);
            boolean checkChangeItem = changeItem != null && !driver.findElement(By.xpath(changeItem)).isDisplayed();
            boolean checkPrint = print != null && !driver.findElement(By.xpath(print)).isDisplayed();
            boolean checkRefresh = refresh != null && !windowCheck(refresh, menuLinks[5]);
            boolean checkExpand = expand != null && !driver.findElement(By.xpath(expand)).isDisplayed();
            boolean checkCollapse = collapse != null && !driver.findElement(By.xpath(collapse)).isDisplayed();
            boolean checkNm = nm != null && !driver.findElement(By.xpath(nm)).isDisplayed();

            return (!checkCollapse || !checkNm || !checkExpand || !checkRefresh || !checkPrint || !checkChangeItem
                    || !checkOrderItem || !checkLocator || !checkMoveItem || !checkDetach || !checkVisibility
                    || !checkReplaceMeta || !checkHistory || !checkModelTree || !checkMappingLinks
                    || !checkAddContact || !checkEditMaster || !checkEdit || !checkSynchronize || !checkDetails
            );
        }catch(Exception e){
            System.out.print(e.getMessage());
            return false;
        }
    }
    private boolean windowCheck(String link, String windowLinks[]){
        try {
            WebElement webElement = driver.findElement(By.xpath(link));
            if (webElement.isDisplayed()) {
                if (webElement.isEnabled()) {
                    webElement.click();
                    Window window = createWindow(windowLinks);
                    window.setDriver(driver);
                    Thread.sleep(100);
                    boolean checked = window.isChecked();
                    Thread.sleep(200);
                    driver.findElement(By.xpath(windowLinks[3])).click();
                    return checked;
                } else {
                    return true;
                }
            } else {
                WebElement item = driver.findElement(By.xpath("//i[contains(text(),'test')]"));
                Actions actions = new Actions(driver);
                actions.contextClick(item).perform();
                Thread.sleep(600);
                if (webElement.isDisplayed()) {
                    windowCheck(link, windowLinks);
                }
                return false;
            }
        } catch (Exception e) {
             System.out.println(e.getMessage());
             return false;
        }
    }
    private Window createWindow(String links[]) {
        director.buildWindow(builder, links);
        return builder.getResult();
    }
}
