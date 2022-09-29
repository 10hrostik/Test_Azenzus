package Pages;

import DriverInitialization.DriverConstructor;
import Icons.Director;
import Icons.SearchBuilder;
import ReadConfigs.Configs;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchTool extends DriverConstructor {

    @FindBy(xpath = "//td[text() = 'Search']")
    private WebElement searchBox;

    public SearchTool() {
        driver.get(Configs.URL);
        PageFactory.initElements(driver, this);
    }

    public void openList() {
        try {
            Thread.sleep(1500);
            searchBox.click();
            Thread.sleep(200);
            Assert.assertEquals(true, isDisplayed());

        } catch (Exception e) {
            System.out.print(e.getMessage());
        }

    }
    public String windowCheck(String str[]) {
        try {
            driver.findElement(By.xpath(str[0])).click();
            Director director=new Director();
            SearchBuilder builder= new SearchBuilder();
            String[] buttonCheck = {str[1],str[2],str[3],str[4],str[5],str[6],str[7],str[8],str[9]};
            director.buildSearch(builder,buttonCheck);
            Assert.assertEquals(true,builder.getResult().check());

            driver.findElement(By.xpath(str[10])).click();
            Thread.sleep(800);
            String findElements = driver.findElement(By.xpath(str[11])).getText();
            driver.findElement(By.xpath(str[4])).click();
            return findElements;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Not found";
        }
    }

    private boolean isDisplayed() {
        if (!driver.findElement(By.xpath("//div[text() = 'Equipment']")).isDisplayed()) return false;
        if (!driver.findElement(By.xpath("//div[text() = 'Contact']")).isDisplayed()) return false;
        if (!driver.findElement(By.xpath("//div[text() = 'Document']")).isDisplayed()) return false;
        if (!driver.findElement(By.xpath("//div[text() = 'Aspect']")).isDisplayed()) return false;
        if (!driver.findElement(By.xpath("//div[text() = 'Comment']")).isDisplayed()) return false;

        return true;
    }

}