package me.check.context.subcontext;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class SubContextMenu {
    private WebDriver driver;

    String product;

    String function;

    String location;

    String document;

    String characteristic;

    String other;

    String addRoot;

    String addSub;

    String editRDC;

    String renameRDC;

    String deleteNode;

    String deleteAspect;

    String simpleDetach;

    String detachInThis;

    String detachInALl;

    String catalogue;

    String constraint;

    String abstractEquipment;

    String changeCatalogue;

    String catalogueToConstraint;

    String abstractToConstraint;

    String constraintToAbstract;

    String constraintToConstraint;

    String createDocument;

    String documentWizard;

    public void setDriver(WebDriver driver){
        this.driver=driver;
    }

    public boolean checkNM(){
        try {
            if (product != null) if (!driver.findElement(By.xpath(product)).isDisplayed()) return false;
            if (location != null) if (!driver.findElement(By.xpath(location)).isDisplayed()) return false;
            if (function != null) if (!driver.findElement(By.xpath(function)).isDisplayed()) return false;
            if (document != null) if (!driver.findElement(By.xpath(document)).isDisplayed()) return false;
            if (characteristic != null) if (!driver.findElement(By.xpath(characteristic)).isDisplayed()) return false;
            if (other != null) if (!driver.findElement(By.xpath(other)).isDisplayed()) return false;

            return true;
        }catch(NoSuchElementException e){
            System.out.print(e.getMessage());
            return false;
        }
    }
    public boolean checkModelTree(){
        try {
            if (addRoot != null) if (!driver.findElement(By.xpath(addRoot)).isDisplayed()) return false;
            if (addSub != null) if (!driver.findElement(By.xpath(addSub)).isDisplayed()) return false;
            if (editRDC != null) if (!driver.findElement(By.xpath(editRDC)).isDisplayed()) return false;
            if (renameRDC != null) if (!driver.findElement(By.xpath(renameRDC)).isDisplayed()) return false;
            if (deleteNode != null) if (!driver.findElement(By.xpath(deleteNode)).isDisplayed()) return false;
            if (deleteAspect != null) if (!driver.findElement(By.xpath(deleteAspect)).isDisplayed()) return false;

            return true;
        }catch(NoSuchElementException e){
            System.out.print(e.getMessage());
            return false;
        }
    }

    public boolean checkDetach(){
        try {
            if (simpleDetach != null) if (!driver.findElement(By.xpath(simpleDetach)).isDisplayed()) return false;
            if (detachInThis != null) if (!driver.findElement(By.xpath(detachInThis)).isDisplayed()) return false;
            if (detachInALl != null) if (!driver.findElement(By.xpath(detachInALl)).isDisplayed()) return false;

            return true;
        }catch(NoSuchElementException e){
            System.out.print(e.getMessage());
            return false;
        }
    }

    public boolean checkOrderEquipment(){
        try {
            if (catalogue != null) if (!driver.findElement(By.xpath(catalogue)).isDisplayed()) return false;
            if (constraint != null) if (!driver.findElement(By.xpath(constraint)).isDisplayed()) return false;
            if (abstractEquipment != null) if (!driver.findElement(By.xpath(abstractEquipment)).isDisplayed()) return false;
            if (createDocument != null && documentWizard !=null){
                driver.findElement(By.xpath("//table[@width = 146]//img[contains(@src , 'submenu')]")).click();
                if (!driver.findElement(By.xpath(createDocument)).isDisplayed()) return false;
                if (!driver.findElement(By.xpath(documentWizard)).isDisplayed()) return false;
            }

            return true;
        }catch(NoSuchElementException e){
            System.out.print(e.getMessage());
            return false;
        }
    }

    public boolean checkChangeEquipment(){
        try {
            if (changeCatalogue != null) if (!driver.findElement(By.xpath(changeCatalogue)).isDisplayed()) return false;
            if (catalogueToConstraint != null) if (!driver.findElement(By.xpath(constraintToAbstract)).isDisplayed()) return false;
            if (constraintToAbstract != null) if (!driver.findElement(By.xpath(constraintToAbstract)).isDisplayed()) return false;
            if (abstractToConstraint != null) if (!driver.findElement(By.xpath(abstractToConstraint)).isDisplayed()) return false;
            if (constraintToConstraint != null) if (!driver.findElement(By.xpath(constraintToConstraint)).isDisplayed()) return false;

            return true;
        }catch(NoSuchElementException e){
            System.out.print(e.getMessage());
            return false;
        }
    }
}
