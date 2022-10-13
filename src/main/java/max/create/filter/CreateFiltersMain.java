package max.create.filter;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

import max.general.OpenManager;
import max.general.StartAndLogin;

public class CreateFiltersMain {
	
	private WebDriver Az;
	
	@Test
	public void main() throws InterruptedException {
		StartAndLogin azenzus = new StartAndLogin("https://test.covizmo.com/azenzus/");
		azenzus.loginAz("qa", "QAtest1-");
		Az = azenzus.getWebDriver();
		
		OpenManager.equipmentManager(Az);
		AdvancedSearch search = new AdvancedSearch(Az);
		search.advancedSearch();

		//to test
		String[] plants = {"QA import", "Maksymilian test 2"};
		search.buttonPlant();
		selectPlants(plants);
		
		search.buttonContact();
		selectContact("Person", "Max QA");

		search.buttonMaster();
		selectMaster("Mastername");
	}
	
	private void selectPlants(String[] plants) throws InterruptedException {
		SelectPlant plant = new SelectPlant(Az);
		plant.buttonSearch();
		plant.selectPlant(plants);
		plant.buttonSelect();
	}
	
	private void selectContact(String type, String cont) throws InterruptedException {
		SelectContact contact = new SelectContact(Az);
		contact.selectContactData(type, cont);
		contact.clickSelect();
	}

	private void selectMaster(String masterName) {
		SelectMaster master = new SelectMaster(Az);
		master.searchMaster(masterName);
		master.pickMaster(masterName);
	}
}