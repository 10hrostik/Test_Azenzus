package max.addingreferences;

import max.document.manager.DocumentManagerAdvancedSearch;
import max.document.manager.DocumentManagerGeneral;
import max.document.manager.DocumentReferenceWindow;
import max.general.OpenManager;
import max.general.StartAndLogin;
import max.general.Parameters;
import max.metadata.datamanager.MetadataManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;


public class AddReferencesToMetaMain {

    public static WebDriver Az;
    public static int position = 1;

    @Test
    public void addReferences() throws InterruptedException, IOException {
        StartAndLogin azenzus = new StartAndLogin(Parameters.url);
        azenzus.loginAz(Parameters.user, Parameters.password);
        Az = azenzus.getWebDriver();

        OpenManager.documentManager(Az);
        XslxReaderForReferences reader = new XslxReaderForReferences("A:\\Aaa\\addReferences.xlsx");
        DocumentManagerGeneral docManager = new DocumentManagerGeneral(Az);
        DocumentManagerAdvancedSearch advancedSearch = new DocumentManagerAdvancedSearch(Az);
        DocumentReferenceWindow refWindow = new DocumentReferenceWindow(Az);
        MetadataManager metaManager = new MetadataManager(Az);

        docManager.buttonConditionReset();
        docManager.selectObjectType(DocumentManagerGeneral.objectType.DOCUMENT);

        for (int i=0; i<reader.getCount()-1; i++){
            boolean check = true;
            String id = reader.getDocumentId();
            String[] metaIds = reader.getMetadataIds();
            docManager.openAdvancedSearch();
            advancedSearch.searchById(id);
            docManager.buttonSearch();
            try{
                docManager.findDocById(id);
            }
            catch(NoSuchElementException e){
                reader.setException("Document with such id is not found");
                check = false;
            }
            if (check){
                docManager.buttonReferences();
                for (String metaId : metaIds) {
                    refWindow.contextMenu(DocumentReferenceWindow.options.ADD_META_ASPECT_REFERENCE);

                    metaManager.selectObjectType(MetadataManager.objectType.Function);
                    metaManager.searchField(metaId);
                    metaManager.buttonSearch();
                    try{
                        metaManager.contextMenu(metaId, MetadataManager.options.SELECT);
                        WebDriverWait wait = new WebDriverWait(Az, 301, 1000);
                        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//body/div[contains(@eventproxy, 'globalPrompt')]//td[text()='Contacting server...']")));
                    }
                    catch(NoSuchElementException e){
                        metaManager.buttonClose();
                        reader.setException("Metadata with id: "+metaId+" is not found");
                        check = false;
                    }
                }
                refWindow.buttonClose();
                String result = check? "Added all": "Half Added";
                reader.setResult(result);
            }
            else {
                reader.setResult("-");
            }
            position++;
        }
        reader.saveResult();
    }
}