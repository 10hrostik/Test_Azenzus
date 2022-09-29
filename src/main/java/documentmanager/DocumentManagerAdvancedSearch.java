package documentmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DocumentManagerAdvancedSearch {

    WebDriver Az;

    public DocumentManagerAdvancedSearch(WebDriver Az){
        this.Az = Az;
    }

    public void searchById(String ids){
        WebElement fieldId = Az.findElement(By.xpath("//body/div[contains(@eventproxy, 'DocumentManagerSearchWindowNew')]//input[contains(@name,'kbEquipmentsRangesTextBox')]"));
        fieldId.clear();
        fieldId.sendKeys(ids);
    }

}
