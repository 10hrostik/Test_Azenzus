package ImportTest;

import java.awt.AWTException;
import java.io.IOException;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import General.StartAndLogin;
import General.OpenManager;

class ImportAllTest {
	
	public static WebDriver Az;
	
	@Test
	public void main() throws InterruptedException, AWTException, IOException {
		
		//Start and login(URL, login, password)
		StartAndLogin azenzus = new StartAndLogin("https://test.covizmo.com/azenzus/");
		azenzus.loginAz("qa", "QAtest1-");
		Az = azenzus.getWebDriver();

		//import meta for function (filePath, metaName), using the same file for import meta aspect and equipment
		String pathToMetaImportFile = "A:\\Aaa\\ImportAllTest\\ImportMeta.xlsx";
		String metaF = "mrAaa6";
/*		importMeta(pathToMetaImportFile, metaF, "ASPECT_FUNCTION");

		//import meta for equipment (metaName)
		String metaE = "mrAaa7";
		importMeta(pathToMetaImportFile, metaE, "EQUIPMENT");
		
		//Create root(rootName, plant, meta)
		String rootName1 = "Function1";
     	CreateRoot.root("Maksymilian test 2", metaF, rootName1);
     	var openRoot = Az.findElement(By.xpath("//div[@eventproxy='isc_PlantStructureTree_1']//td[text()='"+rootName1+"']"));
		String id = GeneralMethods.getObjectID(Az, openRoot);

		//Import function(filePath)
		String pathToAspectsImportFile = "A:\\Aaa\\ImportAllTest\\ImportFunctions.xlsx";
		XlsxPathChanger.updateXlsx(id, pathToAspectsImportFile);
		importFunction(pathToAspectsImportFile, metaF);

		//Import equipment(filePath)
		String pathToEquipmentImportFile = "A:\\Aaa\\ImportAllTest\\ImportEquipment.xlsx";
		XlsxPathChanger.updateXlsx(id, pathToEquipmentImportFile);
		importEquipment(pathToEquipmentImportFile, metaE);
*/
		//Create new Structure(rootName2)
		String rootName2 = "Function2";
     	CreateRoot.root("Maksymilian test 2", metaF, rootName2);
     	
     	//newSt(rootName1, rootName2);
     	//checkContextMenu(rootName);
		newSt("Function1", "Function2");
		checkContextMenu("Function1");
		
	}
	
	public static void importFunction(String path, String meta) throws InterruptedException {
		OpenManager.dymanicImportManager(Az);
		DynamicImport.dataType("STRUCTURE_RECORD");
		DynamicImport.objectType("ASPECT_FUNCTION");
		DynamicImport.selctMetadata(meta);
		DynamicImport.chooseFile(path);
		DynamicImport.buttonPrepare();
		DynamicImport.primaryKey();
		DynamicImport.dragAndDropID();
		DynamicImport.dragAndDropTag();
		DynamicImport.dragAndDropName();
		DynamicImport.dragAndDropPath();
		DynamicImport.dragAndDropPlant();
		DynamicImport.buttonImport();
		DynamicImport.closeWhenCompleted();
		System.out.println("Function subnodes imported successfully");
	}
	
	public static void importEquipment(String path, String meta) throws InterruptedException {
		OpenManager.dymanicImportManager(Az);
		DynamicImport.dataType("PRODUCT_INSTANCE");
		DynamicImport.objectType("EQUIPMENT");
		DynamicImport.selctMetadata(meta);
		DynamicImport.chooseFile(path);
		DynamicImport.buttonPrepare();
		DynamicImport.primaryKey();
		DynamicImport.dragAndDropID();
		DynamicImport.dragAndDropTag();
		DynamicImport.dragAndDropDesc();
		DynamicImport.dragAndDropPath();
		DynamicImport.dragAndDropPlant();
		DynamicImport.buttonImport();
		DynamicImport.closeWhenCompleted();
		System.out.println("Equipment imported successfully");
	}
	
	public static void importMeta (String path, String meta, String kbObjectType) throws InterruptedException, AWTException, IOException {
		UdateMetaImportFile.updateFile(path, meta, kbObjectType);
		OpenManager.metaImportManager(Az);
		MetaImport.buttonAdd();
		MetaImport.metaRobot(path);
		MetaImport.buttonImport();
		if (MetaImport.importStatus()==false) {
			System.out.println("File for Meta import is incorrect");
			Thread.sleep(2000);
			//Az.close();
		}
		else { 
			System.out.println("Metadata imported successfully");
		}
		MetaImport.buttonClose();
		Thread.sleep(1000);
    }
	
	public static void newSt(String rootName1, String rootName2) throws InterruptedException {
		var root1 = Az.findElement(By.xpath("//div[@eventproxy='isc_PlantStructureTree_1']//td[text()='"+rootName1+"']"));
		ContextMenuTreeSt.optionExpandAll(root1);
		var root2 = Az.findElement(By.xpath("//div[@eventproxy='isc_PlantStructureTree_1']//td[text()='"+rootName2+"']"));
		var subNode2 = Az.findElement(By.xpath("//tr[@role='treeitem'][@aria-level='2'][@aria-expanded='true'][last()]"));
		subNode2.click();
		var moveSubNode = new Actions(Az);
		moveSubNode.dragAndDrop(subNode2, root2).build().perform();
		Thread.sleep(1000);
		var buttonMove = Az.findElement(By.xpath("//body/div[contains(@eventproxy,'CloneMoveDialog')][not(@aria-hidden='true')]//div[text()='Move']"));
		buttonMove.click();
		Thread.sleep(1000);
		root2 = Az.findElement(By.xpath("//div[@eventproxy='isc_PlantStructureTree_1']//td[text()='"+rootName2+"']"));
		ContextMenuTreeSt.optionExpandAll(root2);
		Thread.sleep(2000);
	}
	
	public static void checkContextMenu(String rootName1) throws InterruptedException {
		
		ContextMenuTreeSt.optionCollapseAll(Az.findElement(By.xpath("//div[@eventproxy='isc_PlantStructureTree_1']//td[text()='"+rootName1+"']")));
		ContextMenuTreeSt.optionExpandAll(Az.findElement(By.xpath("//div[@eventproxy='isc_PlantStructureTree_1']//td[text()='"+rootName1+"']")));
		
		var equipment1 = Az.findElement(By.xpath("//span[contains(@style,'constrain-product.png')]/ancestor::tr[@role='treeitem'][@aria-posinset='4']"));
		var equipment2 = Az.findElement(By.xpath("//span[contains(@style,'constrain-product.png')]/ancestor::tr[@role='treeitem'][@aria-posinset='5']"));
		var equipment3 = Az.findElement(By.xpath("//span[contains(@style,'constrain-product.png')]/ancestor::tr[@role='treeitem'][@aria-posinset='6']"));
		
		ContextMenuTreeSt.optionEdit(equipment1);
		ContextMenuTreeSt.optionNounAndModifier(equipment1, "Other");//Can't check for now
		ContextMenuTreeSt.optionLinks(equipment2, equipment3); //in progress
		
		//...
		
		ContextMenuTreeSt.optionRefresh(Az.findElement(By.xpath("//div[@eventproxy='isc_PlantStructureTree_1']//td[text()='"+rootName1+"']")));
	}
}