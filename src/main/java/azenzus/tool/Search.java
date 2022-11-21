package azenzus.tool;

import azenzus.check.icon.Director;
import azenzus.check.icon.WindowBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Search {
    private WebDriver driver;
    public Search(WebDriver driver){
        this.driver = driver;
    }
    public void openList() {
        try {
            Thread.sleep(1500);
            driver.findElement(By.xpath("//td[text() = 'Search']")).click();;
            Thread.sleep(200);
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
    public boolean windowCheck(String links[]) {
        try {
            driver.findElement(By.xpath(links[0])).click();
            Director director=new Director();
            WindowBuilder builder= new WindowBuilder();
            String[] buttonCheck = {links[1] , links[2] , links[3] , links[4] , links[5] , links[6] , links[7] , links[8] , links[9]};
            director.buildSearch(builder,buttonCheck);
            builder.getResult().setDriver(driver);
            Thread.sleep(800);
            boolean checked = builder.getResult().check();
            driver.findElement(By.xpath(links[4])).click();

            return checked;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    public boolean isDisplayed() {
        if (!driver.findElement(By.xpath("//div[contains(@eventproxy,'searchMenu')]//div[text() = 'Equipment']")).isDisplayed()) return false;
        if (!driver.findElement(By.xpath("//div[contains(@eventproxy,'searchMenu')]//div[text() = 'Contact']")).isDisplayed()) return false;
        if (!driver.findElement(By.xpath("//div[contains(@eventproxy,'searchMenu')]//div[text() = 'Document']")).isDisplayed()) return false;
        if (!driver.findElement(By.xpath("//div[contains(@eventproxy,'searchMenu')]//div[text() = 'Aspect']")).isDisplayed()) return false;
        if (!driver.findElement(By.xpath("//div[contains(@eventproxy,'searchMenu')]//div[text() = 'Comment']")).isDisplayed()) return false;

        return true;
    }
}