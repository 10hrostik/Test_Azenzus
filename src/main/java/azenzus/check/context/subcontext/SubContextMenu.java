package azenzus.check.context.subcontext;

import azenzus.check.context.contextmenu.Builder;
import azenzus.check.context.contextmenu.Director;
import azenzus.check.context.contextmenu.Window;
import azenzus.check.context.contextmenu.WindowBuilder;
import azenzus.check.context.maincontext.ContextMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Arrays;

public class SubContextMenu {
    private static SubContextMenu contextMenu;
    private WebDriver driver;
    private Director director = new Director();;
    private Builder builder = new WindowBuilder();
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
    public static SubContextMenu getContextMenu(){
        if(contextMenu == null){
            contextMenu = new SubContextMenu();
        }
        return contextMenu;
    }
    public boolean checkNM(String openContext[], String menuLinks[]){
        try {
            boolean checkProduct = product != null && !windowCheck(product, menuLinks);
            WebElement element = driver.findElement(By.xpath(openContext[0]));
            Actions actions = new Actions(driver);
            actions.contextClick(element).perform();
            driver.findElement(By.xpath(openContext[1])).click();
            boolean checkLocation = location != null && !windowCheck(location, menuLinks);
            actions.contextClick(element).perform();
            driver.findElement(By.xpath(openContext[1])).click();
            boolean checkFunction = function != null && !windowCheck(function, menuLinks);
            actions.contextClick(element).perform();
            driver.findElement(By.xpath(openContext[1])).click();
            boolean checkDocument = document != null && !windowCheck(document, menuLinks);
            actions.contextClick(element).perform();
            driver.findElement(By.xpath(openContext[1])).click();
            boolean checkCharacteristic = characteristic != null && !windowCheck(characteristic, menuLinks);
            actions.contextClick(element).perform();
            driver.findElement(By.xpath(openContext[1])).click();
            boolean checkOther = other != null && !windowCheck(other, menuLinks);

            return (!checkProduct || !checkLocation || !checkFunction
                    || !checkDocument || !checkCharacteristic || !checkOther
            );
        }catch(NoSuchElementException e){
            System.out.print(e.getMessage());
            return false;
        }
    }
    public boolean checkModelTree(String menuLinks[]){
        try {
            boolean checkAddRoot = addRoot != null && !windowCheck(addRoot, menuLinks);
            boolean checkAddSub = addSub != null && !driver.findElement(By.xpath(addSub)).isDisplayed();
            boolean checkEditRDC = editRDC != null && !driver.findElement(By.xpath(editRDC)).isDisplayed();
            boolean checkRenameRDC = renameRDC != null && !driver.findElement(By.xpath(renameRDC)).isDisplayed();
            boolean checkDeleteNode = deleteNode != null && !driver.findElement(By.xpath(deleteNode)).isDisplayed();
            boolean checkDeleteAspect = deleteAspect != null && !driver.findElement(By.xpath(deleteAspect)).isDisplayed();

            return (!checkAddRoot || !checkAddSub || !checkEditRDC
                    || !checkRenameRDC || !checkDeleteNode || !checkDeleteAspect
            );
        }catch(NoSuchElementException e){
            System.out.print(e.getMessage());
            return false;
        }
    }
    public boolean checkDetach(){
        try {
            boolean checkDetach = simpleDetach != null && !driver.findElement(By.xpath(simpleDetach)).isDisplayed();
            boolean checkDetachInThis = detachInThis != null && !driver.findElement(By.xpath(detachInThis)).isDisplayed();
            boolean checkDetachInAll = detachInALl != null && !driver.findElement(By.xpath(detachInALl)).isDisplayed();

            return (!checkDetachInAll || !checkDetachInThis || !checkDetach);
        }catch(NoSuchElementException e){
            System.out.print(e.getMessage());
            return false;
        }
    }
    public boolean checkOrderEquipment(String openContext[],String menuLinks1[], String menuLinks2[], String menuLinks3[]){
        try {
            boolean checkCatalogue = catalogue != null && !windowCheck(catalogue, menuLinks1);
            WebElement element = driver.findElement(By.xpath(openContext[0]));
            Actions actions = new Actions(driver);
            actions.contextClick(element).perform();
            driver.findElement(By.xpath(openContext[1])).click();
            boolean checkConstraint = constraint != null && !windowCheck(constraint, menuLinks2);
            actions.contextClick(element).perform();
            driver.findElement(By.xpath(openContext[1])).click();
            boolean checkAbstract = abstractEquipment != null && !windowCheck(abstractEquipment, menuLinks3);
            actions.contextClick(element).perform();
            Thread.sleep(100);
            driver.findElement(By.xpath(openContext[1])).click();
            boolean checkCreateDocument = true;
            boolean checkDocumentWizard = true;
            if (createDocument != null && documentWizard !=null){
                driver.findElement(By.xpath("//table[@width = 146]//img[contains(@src , 'submenu')]")).click();
                checkCreateDocument = createDocument != null && !driver.findElement(By.xpath(createDocument)).isDisplayed();
                checkDocumentWizard = documentWizard != null && !driver.findElement(By.xpath(documentWizard)).isDisplayed();
            }
            return (!checkCatalogue || !checkConstraint || !checkAbstract
                    || !checkCreateDocument || !checkDocumentWizard
            );
        }catch(Exception e){
            System.out.print(e.getMessage());
            return false;
        }
    }
    public boolean checkChangeEquipment(String openContext[],String menuLinks1[], String menuLinks2[]){
        try {
            boolean checkCatalogue = changeCatalogue != null && !windowCheck(changeCatalogue, menuLinks1);
            WebElement element = driver.findElement(By.xpath(openContext[0]));
            Actions actions = new Actions(driver);
            actions.contextClick(element).perform();
            driver.findElement(By.xpath(openContext[1])).click();
            boolean checkCatalogueToConstraint = catalogueToConstraint != null && !driver.findElement(By.xpath(catalogueToConstraint)).isDisplayed();
            boolean checkConstraintToAbstract = constraintToAbstract != null && !windowCheck(constraintToAbstract, menuLinks2);
            boolean checkAbstractToConstraint = abstractToConstraint != null && !driver.findElement(By.xpath(abstractToConstraint)).isDisplayed();
            actions.contextClick(element).perform();
            driver.findElement(By.xpath(openContext[1])).click();
            boolean checkConstraintToConstraint = constraintToConstraint != null && !driver.findElement(By.xpath(constraintToConstraint)).isDisplayed();

            return (!checkCatalogue || !checkCatalogueToConstraint || !checkConstraintToAbstract
                    || !checkConstraintToConstraint || !checkAbstractToConstraint
            );
        }catch(NoSuchElementException e){
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
