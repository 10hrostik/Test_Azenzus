package metadata.datamanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MetadataManager {

    WebDriver Az;

    public enum objectType{
        Location,
        Function,
        External
    }

    public enum options{
        SELECT
    }

    public MetadataManager(WebDriver Az){
        this.Az = Az;
    }

    public void selectObjectType(MetadataManager.objectType type) {
        Az.findElement(By.xpath("//body/div[contains(@eventproxy, 'Meta')]//label[text()='Type Of Object']//ancestor::tr/td[2]//div")).click();
        Az.findElement(By.xpath("//body/div[@class='pickListMenu']//div[text()='"+type+"']")).click();
    }

    public void searchField(String value){
        WebElement textField = Az.findElement(By.xpath("//body/div[contains(@eventproxy, 'Meta')]//input[@name='searchTextBox']"));
        textField.clear();
        textField.sendKeys(value);
    }

    public void buttonSearch(){
        Az.findElement(By.xpath("//body/div[contains(@eventproxy, 'Meta')]//div[text()='Search...']")).click();
        WebDriverWait wait = new WebDriverWait(Az, 5, 100);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//body/div[contains(@eventproxy, 'Meta')]//img[contains(@src, 'loadingSmall.gif')]")));
    }

    public void contextMenu(String id, options option) throws InterruptedException {
        WebElement listGrid = Az.findElement(By.xpath("//body/div[contains(@eventproxy, 'Meta')]//div[text()='"+id+"']"));
        Actions contextMenu = new Actions(Az);
        contextMenu.contextClick(listGrid).perform();
        if (option == options.SELECT) {
            Az.findElement(By.xpath("//td[@class='menu']/div[text()='Select']")).click();
        }
        Thread.sleep(1000);
    }

    public void buttonClose(){
        Az.findElement(By.xpath("//body/div[contains(@eventproxy, 'Meta')]//img[contains(@src, 'close.png')]")).click();
    }


}
