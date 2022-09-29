package deletemetadata;

import createnounandmodifier.XlsxReaderForNounAndModifier;
import general.OpenManager;
import general.StartAndLogin;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;

public class DeleteMetaMain extends XlsxReaderForNounAndModifier {
	
	public static int position=1;
	private WebDriver Az;
	private XlsxReaderForMetadata reader;
	
	@Test
	public void deleteMetaMain() throws InterruptedException, IOException {
		
		//Start and login(URL, Login, password)
		StartAndLogin azenzus = new StartAndLogin("https://test.covizmo.com/azenzus/");
		azenzus.loginAz("qa", "QAtest1+");
		Az = azenzus.getWebDriver();
		
        OpenManager.metadataManager(Az, "Aspect","Function");
        Thread.sleep(5000);
		String pathToFile = "A:\\Aaa\\DeletionMeta.xlsx";
		reader = new XlsxReaderForMetadata();
		reader.readXlsx(pathToFile);
		try {
			int count = reader.getCount();
			do {
				String id = reader.getMetaId(position);
				findMetaById(id);
				deleteMetaById(id);
				count--;
				position++;
			}
			while(count!=1);
		}
		finally {
			Thread.sleep(5000);
			Az.close();
			XlsxReaderForMetadata.inputStream.close();
			XlsxReaderForMetadata.saveResult(pathToFile.replace(".xlsx", "-Result.xlsx"));
		}
    }

    private void findMetaById(String id) throws InterruptedException {
		WebElement searchField = Az.findElement(By.xpath("//div[contains(@eventproxy, 'MetadataManagerWindow')]//input[@name='searchTextBox']"));
		searchField.clear();
		searchField.sendKeys(id);
		Thread.sleep(400);
		Az.findElement(By.xpath("//div[contains(@eventproxy, 'MetadataManagerWindow')]//div[text()='Search...']")).click();
		Thread.sleep(3000);
	}

	private void deleteMetaById(String id) throws InterruptedException, IOException {
		try {
			String name = reader.getMetaName(position);
			WebElement metaToBeDeleted = Az.findElement(By.xpath("//div[contains(@eventproxy,'MetadataManagerWindowLayoutListGrid')]//tr/td[2]//font[text()='"+id+"']/ancestor::td/following-sibling::td//font[text()='"+name+"']"));
			Actions action = new Actions(Az);
			action.contextClick(metaToBeDeleted).perform();
			Thread.sleep(200);
			Az.findElement(By.xpath("//tbody/tr[3]//div[text()='Delete']")).click();
			Thread.sleep(500);
			Az.findElement(By.xpath("//td[text()='OK']")).click();
			System.out.println("Meta with id: "+id+" deleted");
			reader.setResult("Meta with id: "+id+" deleted");
		}
		catch(Exception e) {
			System.out.println("Meta with id: "+id+" is not found");
			reader.setResult("Meta with id: "+id+" is not found");
		}
	}
}