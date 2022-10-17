package me.check.context;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class ContextMenu {

    private WebDriver driver;

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

    String product;

    String function;

    String location;

    String document;

    String characteristic;

    String other;

    String rootNode;

    String subNode;

    String editRdc;

    String renameRdc;

    String deleteNode;

    String deleteAspect;

    String orderCatalogue;

    String orderConstraint;

    String orderAbstract;
    public void setDriver(WebDriver driver){
        this.driver=driver;
    }

    public boolean check(){
        try {
            if (synchronize != null) if (!driver.findElement(By.xpath(synchronize)).isDisplayed()) return false;
            if (edit != null) if (!driver.findElement(By.xpath(edit)).isDisplayed()) return false;
            if (editMaster != null) if (!driver.findElement(By.xpath(editMaster)).isDisplayed()) return false;
            if (addContact != null) if (!driver.findElement(By.xpath(addContact)).isDisplayed()) return false;
            if (mappingLinks != null) if (!driver.findElement(By.xpath(mappingLinks)).isDisplayed()) return false;
            if (modelTree != null) if (!driver.findElement(By.xpath(modelTree)).isDisplayed()) return false;
            if (detach != null) if (!driver.findElement(By.xpath(detach)).isDisplayed()) return false;
            if (moveItem != null) if (!driver.findElement(By.xpath(moveItem)).isDisplayed()) return false;
            if (replaceMeta != null) if (!driver.findElement(By.xpath(replaceMeta)).isDisplayed()) return false;
            if (visibility != null) if (!driver.findElement(By.xpath(visibility)).isDisplayed()) return false;
            if (history != null) if (!driver.findElement(By.xpath(history)).isDisplayed()) return false;
            if (details != null) if (!driver.findElement(By.xpath(details)).isDisplayed()) return false;
            if (locator != null) if (!driver.findElement(By.xpath(locator)).isDisplayed()) return false;
            if (orderItem != null) if (!driver.findElement(By.xpath(orderItem)).isDisplayed()) return false;
            if (changeItem != null) if (!driver.findElement(By.xpath(changeItem)).isDisplayed()) return false;
            if (print != null) if (!driver.findElement(By.xpath(print)).isDisplayed()) return false;
            if (refresh != null) if (!driver.findElement(By.xpath(refresh)).isDisplayed()) return false;
            if (expand != null) if (!driver.findElement(By.xpath(expand)).isDisplayed()) return false;
            if (collapse != null) if (!driver.findElement(By.xpath(collapse)).isDisplayed()) return false;
            if (nm != null) if (!driver.findElement(By.xpath(nm)).isDisplayed()) return false;

            // Subcontext button

            if (product != null) if(!driver.findElement(By.xpath(product)).isDisplayed()) return false;
            if (function != null) if(!driver.findElement(By.xpath(function)).isDisplayed()) return false;
            if (location != null) if(!driver.findElement(By.xpath(location)).isDisplayed()) return false;
            if (document != null) if(!driver.findElement(By.xpath(document)).isDisplayed()) return false;
            if (characteristic != null) if(!driver.findElement(By.xpath(characteristic)).isDisplayed()) return false;
            if (other != null) if(!driver.findElement(By.xpath(other)).isDisplayed()) return false;
            if (rootNode != null) if(!driver.findElement(By.xpath(rootNode)).isDisplayed()) return false;
            if (subNode != null) if(!driver.findElement(By.xpath(subNode)).isDisplayed()) return false;
            if (editRdc != null) if(!driver.findElement(By.xpath(editRdc)).isDisplayed()) return false;
            if (renameRdc != null) if(!driver.findElement(By.xpath(renameRdc)).isDisplayed()) return false;
            if (deleteNode != null) if(!driver.findElement(By.xpath(deleteNode)).isDisplayed()) return false;
            if (deleteAspect != null) if(!driver.findElement(By.xpath(deleteAspect)).isDisplayed()) return false;
            if (orderCatalogue != null) if(!driver.findElement(By.xpath(orderCatalogue)).isDisplayed()) return false;
            if (orderConstraint != null) if(!driver.findElement(By.xpath(orderConstraint)).isDisplayed()) return false;
            if (orderAbstract != null) if(!driver.findElement(By.xpath(orderAbstract)).isDisplayed()) return false;

            return true;
        }catch(NoSuchElementException e){
            System.out.print(e.getMessage());
            return false;
        }
    }
}
