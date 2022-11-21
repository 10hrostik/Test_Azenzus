package azenzus.tree;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public interface PlantPreparation {
    static void openPlant(WebDriver driver){
        try {
            driver.findElement(By.xpath("//table[contains(@style , '143px')]//img[contains(@src, 'selectPicker')]")).click();
            List<WebElement> elements = driver.findElement(By.xpath("//table[@width = 139]//tbody")).findElements(By.tagName("tr"));
            elements.get(1).click();
        } catch(NoSuchElementException e) {
            System.out.println((e.getMessage()));
        }
    }

}
