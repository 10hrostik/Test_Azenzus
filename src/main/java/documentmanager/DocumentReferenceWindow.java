package documentmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DocumentReferenceWindow {

    WebDriver Az;
    public enum options{
        ADD_META_ASPECT_REFERENCE
    }

    public DocumentReferenceWindow(WebDriver Az) {
        this.Az = Az;
    }

    public void contextMenu(options option) {
        WebElement listGrid = Az.findElement(By.xpath("//body//div[contains(@eventproxy,'DocumentManagerReferenceWindowListGrid')][@class='listGrid']/div[1]"));
        Actions contextMenu = new Actions(Az);
        contextMenu.contextClick(listGrid).perform();

        switch(option) {
            case ADD_META_ASPECT_REFERENCE:
                Az.findElement(By.xpath("//body/div[contains(@eventproxy, 'Menu')][@aria-hidden='false']//div[text()='Add Meta Aspect Reference']")).click();
                break;
        }
    }

    public void buttonClose(){
        Az.findElement(By.xpath("//body/div[contains(@eventproxy, 'DocumentManagerReferenceWindow')][last()-1]//img[contains(@src, 'close.png')]")).click();
    }
}