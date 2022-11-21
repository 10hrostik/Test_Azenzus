package azenzus.tree;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class TreeMenu {

    private Logger logger = LogManager.getLogger(TreeMenu.class);
    private WebDriver driver;
    public TreeMenu(WebDriver driver){
        this.driver = driver;
    }

    public void openFunction() {
        try{
            driver.findElement(By.xpath("//table[contains(@style , '101px')]//img[contains(@src, 'selectPicker')]")).click();
            driver.findElement(By.xpath("//td[@height]//div[text() = 'Function']")).click();
        }catch(NoSuchElementException e){
            System.out.println(e.getMessage());
        }
    }

    public boolean isDisplayed() {
        try {
            boolean add = driver.findElement(By.xpath("//div[@aria-label='Add Node']")).isDisplayed();
            boolean edit = driver.findElement(By.xpath("//div[@aria-label='Edit Node']")).isDisplayed();
            boolean delete = driver.findElement(By.xpath("//div[@aria-label='Delete Node']")).isDisplayed();
            boolean refresh = driver.findElement(By.xpath("//div[@aria-label='Refresh Node']")).isDisplayed();
            boolean print = driver.findElement(By.xpath("//div[@aria-label='Print']")).isDisplayed();
            boolean trash = driver.findElement(By.xpath("//div[@aria-label='Trash']")).isDisplayed();

            return add && edit && delete && refresh && print && trash;
        } catch (NoSuchElementException e) {
            logger.error(e.getMessage());
            return false;
        }
    }
}