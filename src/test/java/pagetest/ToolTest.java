package pagetest;

import azenzus.page.Authorization;
import azenzus.resources.Links;
import azenzus.tool.DataManager;
import azenzus.tool.Search;
import azenzus.tool.Tools;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ToolTest {
    private static WebDriver driver;
    private static Logger logger;

    @BeforeAll
    static void initialization(){
        logger = LogManager.getLogger(ToolTest.class);
        Authorization authorization = new Authorization();
        driver = authorization.getDriver();
    }
    @Test
    void checkSearch(){
        Search searchWindow = new Search(driver);
        for(String[] links : Links.searchLinks) {
            searchWindow.openList();
            assertTrue(searchWindow.isDisplayed());
            assertTrue(searchWindow.windowCheck(links));
        }
    }
    @Test
    void checkTools(){
        Tools tools = new Tools(driver);
        for(String[] links : Links.toolLinks){
            tools.openList();
            assertTrue(tools.isDisplayed());
            assertTrue(tools.windowCheck(links));
        }
    }
    @Test
    void checkDataManager(){
        DataManager data = new DataManager(driver);
        for(String[] links : Links.dataManagerLinks){
            data.openList();
            assertTrue(data.isDisplayed());
            assertTrue(data.windowCheck(links));
        }
    }
}
