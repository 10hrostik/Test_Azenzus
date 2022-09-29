package documentmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DocumentManagerGeneral {

    private final WebDriver Az;
    private final WebDriverWait wait;
    public enum objectType {
        DOCUMENT,
        TASK_DOCUMENT
    }

    public DocumentManagerGeneral(WebDriver Az){
        this.Az = Az;
        this.wait = new WebDriverWait(Az, 5, 100);
    }

    public void openAdvancedSearch() throws InterruptedException {
        Az.findElement(By.xpath("//body/div[contains(@eventproxy, 'DocumentManagerSearchWindowNew')]//div[contains(text(),'Advanced Search')]")).click();
        Thread.sleep(500);
    }

    public void selectObjectType(objectType type) {
        Az.findElement(By.xpath("//body/div[contains(@eventproxy, 'DocumentManagerSearchWindowNew')]//label[text()='Type Of Object']//ancestor::tr/td[2]//div")).click();
        switch (type){
            case DOCUMENT:
                Az.findElement(By.xpath("//body/div[contains(@eventproxy, 'PickListMenu')]//div[text()='Document']")).click();
                break;
            case TASK_DOCUMENT:
                Az.findElement(By.xpath("//body/div[contains(@eventproxy, 'PickListMenu')]//div[text()='Document task']")).click();
                break;
        }
    }

    public void buttonSearch() {
        Az.findElement(By.xpath("//body/div[contains(@eventproxy, 'DocumentManagerSearchWindowNew')]//div[text()='Search']")).click();
        //wait until loading gif disappear
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//body/div[contains(@eventproxy, 'DocumentManagerSearchWindowNew')]//img[contains(@src, 'loadingSmall.gif')]")));
    }

    public void buttonReferences() throws InterruptedException {
        try{
            Az.findElement(By.xpath("//body/div[contains(@eventproxy, 'DocumentManagerSearchWindowNew')]//div[text()='References']")).click();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//body/div[contains(@eventproxy, 'DocumentManagerReferenceWindow')]")));
        }
        catch(NoSuchElementException | IllegalArgumentException ignored){}
        Thread.sleep(500);
    }

    public void buttonConditionReset() throws InterruptedException {
        Az.findElement(By.xpath("//body/div[contains(@eventproxy, 'DocumentManagerSearchWindowNew')]//div[text()='Conditions reset']")).click();
        Thread.sleep(1000);
    }

    public void findDocById(String id) {
        Az.findElement(By.xpath("//body/div[contains(@eventproxy, 'DocumentManagerSearchWindowNew')]//b[text()='"+id+"']")).click();
    }

    public void openDocument(String id){
        findDocById(id);
        WebElement doc = Az.findElement(By.xpath("//body/div[contains(@eventproxy, 'DocumentManagerSearchWindowNew')]//b[text()='"+id+"']"));
        Actions doubleClick = new Actions(Az);
        doubleClick.doubleClick(doc).perform();
    }
}