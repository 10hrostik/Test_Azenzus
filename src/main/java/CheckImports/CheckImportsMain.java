package CheckImports;

import java.io.IOException;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import General.ContextMenuTreeStructure;
import General.GeneralMethods;
import General.ImportManager;
import General.OpenManager;
import General.StartAndLogin;
import General.TreeStructure;

public class CheckImportsMain {
	
	private static WebDriver Az;
	private String rootID, rootName = "Root123";
	
	@Test
	public void main() throws InterruptedException, IOException {
		
		StartAndLogin azenzus = new StartAndLogin("https://test.covizmo.com/azenzus/");
		azenzus.loginAz("qa", "QAtest1-");
		Az = azenzus.getWebDriver();
		
		root(this.rootName, "Test Function");
		
		//Import function(filePath)
		String pathToAspectsImportFile = "A:\\Aaa\\CheckImports\\CreateFunctionSt.xlsx";
		XlsxPathChanger changer = new XlsxPathChanger();
		changer.updateXlsx(rootID, pathToAspectsImportFile);
		importFunction(pathToAspectsImportFile, "Test Function");
		
		checkIfStructureCreated();
	}
	
	private void root(String rootName, String meta) throws InterruptedException {
		TreeStructure tree = new TreeStructure(Az);
		tree.selectPlant("QA import");
		
		CreateRoot newRoot = new CreateRoot(Az);
		newRoot.create(meta, rootName);
		
		WebElement openRoot = Az.findElement(By.xpath("//div[@eventproxy='isc_PlantStructureTree_1']//td[text()='"+rootName+"']"));
		rootID = GeneralMethods.getObjectID(Az, openRoot);
	}
	
	private void importFunction(String path, String meta) throws InterruptedException {
		ImportManager manager = new ImportManager(Az);
		
		OpenManager.dymanicImportManager(Az);
		manager.dataType("STRUCTURE_RECORD");
		manager.objectType("ASPECT_FUNCTION");
		manager.selctMetadata(meta);
		manager.chooseFile(path);
		manager.buttonPrepare();
		manager.primaryKey();
		mapFunctionColumns(manager);
		manager.buttonImport();
		manager.closeWhenCompleted();
		System.out.println("Function sub-nodes imported successfully");
	}
	
	private void mapFunctionColumns(ImportManager manager) throws InterruptedException {
		manager.mapColumn("ID", 1);
		manager.mapColumn("RDC_TAG", 2);
		manager.mapColumn("NAME", 3);
		manager.mapColumn("PATH", 4);
		manager.mapColumn("PLANT_ID", 5);
	}
	
	private void checkIfStructureCreated() throws InterruptedException {
		TreeStructure manager = new TreeStructure(Az);
		manager.buttonRefresh();
		
		ContextMenuTreeStructure menu = new ContextMenuTreeStructure(Az);
		WebElement root = Az.findElement(By.xpath("//td[text()='"+this.rootName+"']"));
		menu.optionExpandAll(root);
	}
}