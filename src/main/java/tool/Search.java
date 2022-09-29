package tool;

import check.icon.Director;
import check.icon.SearchBuilder;
import page.LoginPage;
import resources.Configs;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Search extends LoginPage {

    @FindBy(xpath = "//td[text() = 'Search']")
    private WebElement searchBox;

    public Search() {
        super();
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
    public String windowCheck(String links[]) {
        try {
            driver.findElement(By.xpath(links[0])).click();
            Director director=new Director();
            SearchBuilder builder= new SearchBuilder();
            String[] buttonCheck = {links[1] , links[2] , links[3] , links[4] , links[5] , links[6] , links[7] , links[8] , links[9]};
            director.buildSearch(builder,buttonCheck);
            builder.getResult().setDriver(driver);
            Assert.assertEquals(true,builder.getResult().check());

            driver.findElement(By.xpath(links[10])).click();
            Thread.sleep(800);
            String findElements = driver.findElement(By.xpath(links[11])).getText();
            driver.findElement(By.xpath(links[4])).click();
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