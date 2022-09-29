package testcomment;

import document.editwindow.DocEditWindowGeneral;
import document.manager.DocumentManagerAdvancedSearch;
import document.manager.DocumentManagerGeneral;
import general.OpenManager;
import general.Parameters;
import general.StartAndLogin;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class testCommentsDocument {

    static WebDriver Az;
    static DocumentManagerGeneral docManager;
    static DocumentManagerAdvancedSearch advancedSearch;
    static DocEditWindowGeneral editWindow;

    @BeforeClass
    public static void login() throws InterruptedException {
        StartAndLogin azenzus = new StartAndLogin(Parameters.url);
        azenzus.loginAz(Parameters.user, Parameters.password);
        Az = azenzus.getWebDriver();

        docManager = new DocumentManagerGeneral(Az);
        advancedSearch = new DocumentManagerAdvancedSearch(Az);
        editWindow = new DocEditWindowGeneral(Az);
    }

    @BeforeClass
    public static void openManager() throws InterruptedException {
        OpenManager.documentManager(Az);
        docManager.buttonConditionReset();
        docManager.selectObjectType(DocumentManagerGeneral.objectType.DOCUMENT);
    }

    @Test
    public void testAddComment() throws InterruptedException {
        String id = "";
        docManager.openAdvancedSearch();
        advancedSearch.searchById(id);
        docManager.findDocById(id);
        docManager.openDocument(id);
        editWindow.openTab(DocEditWindowGeneral.tabs.Comments);
    }


}