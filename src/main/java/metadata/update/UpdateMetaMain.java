package metadata.update;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import general.OpenManager;
import general.StartAndLogin;

class UpdateMetaMain {
	
	private static WebDriver Az;
	
	@Test
	public void updateMetaMain() throws InterruptedException {
		
		//Start and login(URL, Login, password)
		StartAndLogin azenzus = new StartAndLogin("https://test.covizmo.com/azenzus/");
		azenzus.loginAz("qa", "QAtest1-");
		Az = azenzus.getWebDriver();
		
		//Metadata manager(Equipment/Aspect/Other, ""||Function/Location/Document/External||Comment/Document/Document Task)
        OpenManager.metadataManager(Az, "Aspect","Function");
        openRootMeta("Covizmo - Function Root"); //e.g. "Covizmo - Function Root"
        resizeWindow();
        dragAndDrop();
        openMetaStructure();
        
        //Az.close();   
    }
	
	public void openRootMeta(String rootName) throws InterruptedException {
		Thread.sleep(500);
		WebElement fieldSearch = Az.findElement(By.xpath("//input[@name='searchTextBox']"));
		fieldSearch.clear();
		fieldSearch.sendKeys(rootName);
		buttonSearch();
		Thread.sleep(1000);
		Actions openMeta = new Actions(Az);
		WebElement metaRoot;
		try {
			metaRoot = Az.findElement(By.xpath("//div[text()='"+rootName+"']"));
		}
		catch (NoSuchElementException b) {
			metaRoot = Az.findElement(By.xpath("//font[text()='"+rootName+"']"));
		}
		openMeta.doubleClick(metaRoot).perform();
		Thread.sleep(2000);
	}
	
	public void openMetaStructure() throws InterruptedException {
		int level = 1, i = 1;
		do {
			try {
				WebElement ref = Az.findElement(By.xpath("//body/div[last()-1]//tr[@aria-expanded='false'][@aria-level='"+level+"'][@aria-posinset='"+i+"']//span[1]"));
				ref.click();
				Thread.sleep(500);
				i++;
				if (ifLevelExist(level, i) == true) {
					level++;
				}
			}
			catch (NoSuchElementException e) {
				//check+update
				checkIfRed(level);
				Thread.sleep(1000);
				WebElement ref1 = Az.findElement(By.xpath("//body/div[last()-1]//tr[@aria-expanded='true'][last()]/following-sibling::tr[1][@aria-expanded='false']"));
				level = getAriaLevel(ref1);
				System.out.print("try to close: "+level);
				WebElement ref2 = Az.findElement(By.xpath("//body/div[last()-1]//tr[@aria-expanded='true'][@aria-level='"+level+"']//span[1]"));
				WebElement refToClose = Az.findElement(By.xpath("//body/div[last()-1]//tr[@aria-expanded='true'][@aria-level='"+level+"']"));
				i = getAriaPosinSet(refToClose);
				Thread.sleep(500);
				ref2.click();   
				System.out.println(" - done");
			}
		}
		while(level<18);
	}
	
	public void checkIfRed(int level) throws InterruptedException {
		WebElement redRef;
		//WebElement ref1 = Az.findElement(By.xpath("//body/div[last()-1]//tr[@aria-expanded='true'][last()]"));
		do {
			try {
				redRef = Az.findElement(By.xpath("//body/div[last()-1]//tr[@aria-expanded='true'][@aria-level='"+level+"']//font[@color='red']/ancestor::tr[2]"));
				updateStructure(level);
				break;
			}
			catch(NoSuchElementException a) {
                try {
                	redRef = Az.findElement(By.xpath("//body/div[last()-1]//tr[@aria-expanded='false'][@aria-level='"+level+"']//font[@color='red']"));
                	break;
                }
				catch (NoSuchElementException b) {
					try {
						redRef = Az.findElement(By.xpath("//body/div[last()-1]//font[@color='red']"));
						level--;
					}
					catch(NoSuchElementException c) {
						break;
					}
				}
			}
		}
		while(true);
	}
	
	public void updateStructure(int level) throws InterruptedException {
		int l = level;
		do {
			WebElement redRef2 = Az.findElement(By.xpath("//body/div[last()-1]//tr[@aria-expanded='true'][@aria-level='"+l+"']//font[@color='red']/ancestor::tr[2]"));
			try {
				updateRef(redRef2);
			}
			catch (NoSuchElementException b) {
				try {
					saveAndCheck(redRef2);
				}
				catch(NoSuchElementException c) {
					l=level-1;
				}
			}
			Thread.sleep(3000);
			l--;
		}
		while(l>1);
	}
	
	public void updateRef(WebElement metaRef) throws InterruptedException {
		Actions contextMenu = new Actions(Az);
    	contextMenu.contextClick(metaRef).perform();
    	Thread.sleep(1000);
    	WebElement optionUpdateRef = Az.findElement(By.xpath("//td[@class='menu']/div[text()='Update Reference']"));
    	optionUpdateRef.click();
    	Thread.sleep(500);
	}
	
    public void saveAndCheck(WebElement metaRef) throws InterruptedException {
    	Actions contextMenu = new Actions(Az);
    	contextMenu.contextClick(metaRef).perform();
    	Thread.sleep(1000);
    	WebElement optionSaveAndCheck = Az.findElement(By.xpath("//td[@class='menu']/div[text()='Save & Check']"));
    	optionSaveAndCheck.click();
    	Thread.sleep(500);
	}
    
    public int getAriaPosinSet(WebElement ref1) {
		String ariaPosinSet = ref1.getAttribute("aria-posinset");
		int p = Integer.parseInt(ariaPosinSet);
		return p;
	}
	
	public int getAriaLevel(WebElement ref2) {
		String ariaLevel = ref2.getAttribute("aria-level");
		int l = Integer.parseInt(ariaLevel);
		return l;
	}
	
	public boolean ifLevelExist(int level, int i) {
		try {
			Az.findElement(By.xpath("//body/div[last()-1]//tr[@aria-expanded='false'][@aria-level='"+(level+1)+"'][@aria-posinset='"+i+"']"));
		}
		catch(NoSuchElementException e) {
			return false;
		}
		return true;
	}
	
	public void buttonSearch() {
		WebElement buttonSearch = Az.findElement(By.xpath("//div[text()='Search...']"));
	    buttonSearch.click();
	}
	
	public void dragAndDrop() throws InterruptedException {
		WebElement iconOfRectangle = Az.findElement(By.xpath("//body/div[last()-1]//div[contains(@eventproxy,'resizeBar')]//img[contains(@name, 'icon')]"));
        WebElement moveTo = Az.findElement(By.xpath("//div[text()='...']"));
		Actions act = new Actions(Az);
        act.dragAndDrop(iconOfRectangle, moveTo).build().perform();
        Thread.sleep(1000);
	}
	
	public void resizeWindow() throws InterruptedException {
		WebElement size = Az.findElement(By.xpath("//div[contains(@eventproxy,'MetadataInstanceWindow')]/div[contains(@eventproxy,'maximizeButton')]"));
		size.click();
		Thread.sleep(2000);
	}
}