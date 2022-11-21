package pagetest;

import azenzus.page.Authorization;
import azenzus.resources.Links;
import azenzus.tree.*;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;


class ContextMenuTest {
    private static WebDriver driver;
    private static Logger logger;
    @BeforeAll
    static void initialization(){
        logger = LogManager.getLogger(ContextMenuTest.class);
        Authorization authorization = new Authorization();
        driver = authorization.getDriver();
        PlantPreparation.openPlant(driver);
    }
    @Test
    void checkFunction(){
        Function fun = new Function(driver);
        fun.openFunction();
        Boolean checked = fun.windowCheck(Links.contextMenuFunction,Links.subContextMenuFun);
        assertTrue(checked);
        logger.log(Level.INFO,"All function context menu buttons are correct");
    }
    @Test
    void checkLocation(){
        Location location = new Location(driver);
        location.openLocation();
        Boolean checked = location.windowCheck(Links.contextMenuLocation,Links.subContextMenuLoc);
        assertTrue(checked);
        logger.log(Level.INFO,"All location context menu buttons are correct");
    }
    @Test
    void checkDocument(){
        Document doc = new Document(driver);
        doc.openDocument();
        Boolean checked = doc.windowCheck(Links.contextMenuDocument,Links.subContextDocMenuDoc);
        assertTrue(checked);
        logger.log(Level.INFO,"All document context menu buttons are correct");
    }
    @Test
    void checkTreeMenu() {
        TreeMenu treeMenu = new TreeMenu(driver);
        treeMenu.openFunction();
        assertTrue(treeMenu.isDisplayed());
    }
}
