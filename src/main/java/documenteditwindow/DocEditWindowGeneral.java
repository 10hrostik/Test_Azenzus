package documenteditwindow;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DocEditWindowGeneral {

    WebDriver Az;

    public enum tabs{
        Document,
        Details,
        Drawings,
        References,
        Attachments,
        Contacts,
        Comments
    }

    public DocEditWindowGeneral(WebDriver Az){
        this.Az = Az;
    }

    public void openTab(tabs tab) {
        WebElement listGrid = Az.findElement(By.xpath("//div[contains(@eventproxy, 'DocumentManagerInstance')]//img[contains(@src, 'picker_top.png')]"));
        Actions contextMenu = new Actions(Az);
        contextMenu.contextClick(listGrid).perform();
        Az.findElement(By.xpath("//div[@role='menu'][@aria-hidden='false']//div[contains(text(),'"+tab+"')]")).click();
    }
}
