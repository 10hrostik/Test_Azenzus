package Pages;

import Driver_Init.DriverConstructor;
import ReadConfigs.Configs;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DataManagerTool extends DriverConstructor {
    @FindBy(xpath = "//td[text() = 'Data Manager']")
    private WebElement DataBox;

    public DataManagerTool(){
        driver.get(Configs.URL);
        PageFactory.initElements(driver,this);
    }

    public void OpenList(){
        try{
            Thread.sleep(1500);
            DataBox.click();
            boolean expected[] = {true,true,true,true,true,true,true};
            Thread.sleep(200);
            Assert.assertArrayEquals(expected,isDisplayed());

        }catch(Exception e){
            System.out.print(e.getMessage());
        }

    }

    public String LinkTypesCheck(){
        try{
            driver.findElement(By.xpath("//div[text() = 'Link Types Manager']")).click();
            boolean expected[] = {true,true,true,true,false,true,true,true};
            Assert.assertArrayEquals(expected,checkIcons("//table[@height = '18px']//td[text() = 'Link Types Manager']",
                    "//div[contains(@eventproxy,'LinkTypesManager_0_max')]",
                    "//div[contains(@eventproxy,'LinkTypesManager_0_min')]",
                    "//div[contains(@eventproxy,'LinkTypesManager_0_cl')]",
                    null,
                    "//div[contains(@eventproxy,'LinkTypesManager_0')]//div[text() = 'Add']",
                    "//div[contains(@eventproxy,'LinkTypesManager_0')]//div[text() = 'Edit']",
                    "//div[contains(@eventproxy,'LinkTypesManager_0')]//div[text() = 'Remove']"
            ));
            Thread.sleep(800);
            List<WebElement> list = driver.findElement(By.xpath("//table[@width = '356']//tbody")).findElements(By.tagName("tr"));
            driver.findElement(By.xpath("//div[contains(@eventproxy,'LinkTypesManager_0_cl')]")).click();
            return "Found "+list.size()+"+ plants";
        }catch(Exception e){
            System.out.println(e.getMessage());
            return "Not needed";
        }
    }
    public String ReportCheck(){
        try{
            driver.findElement(By.xpath("//div[text() = 'Reports Manager']")).click();
            boolean expected[] = {true,true,true,true,true,true,false,false};
            Assert.assertArrayEquals(expected,checkIcons("//table[@height = '18px']//td[text() = 'Report Manager']",
                    "//div[contains(@eventproxy,'ReportManagerWindow_0_max')]",
                    "//div[contains(@eventproxy,'ReportManagerWindow_0_min')]",
                    "//div[contains(@eventproxy,'ReportManagerWindow_0_cl')]",
                    "//div[contains(@eventproxy,'ReportManagerWindow_0')]//div[contains(@style , 'width:746')]",
                    "//div[contains(@eventproxy,'ReportManagerWindow_0')]//div[text() = 'Generate']",
                    null,
                    null
            ));
            Thread.sleep(800);

            driver.findElement(By.xpath("//div[contains(@eventproxy,'ReportManagerWindow_0_cl')]")).click();
            return "Not needed";
        }catch(Exception e){
            System.out.println(e.getMessage());
            return "Not needed";
        }
    }

    public String UnitCheck(){
        try{
            driver.findElement(By.xpath("//div[text() = 'Unit Manager']")).click();
            boolean expected[] = {true,true,true,true,true,true,false,false};
            Assert.assertArrayEquals(expected,checkIcons("//table[@height = '18px']//td[text() = 'Unit Manager']",
                    "//div[contains(@eventproxy,'UnitManagerWindow_0_max')]",
                    "//div[contains(@eventproxy,'UnitManagerWindow_0_min')]",
                    "//div[contains(@eventproxy,'UnitManagerWindow_0_cl')]",
                    "//div[contains(@eventproxy,'UnitManagerWindow_0')]//input[@name = 'searchText']",
                    "//div[contains(@eventproxy,'UnitManagerWindow_0')]//div[text() = 'Search']",
                    null,
                    null
            ));
            Thread.sleep(800);
            driver.findElement(By.xpath("//div[contains(@eventproxy,'UnitManagerWindow_0')]//div[text() = 'Search']")).click();
            Thread.sleep(1000);
            List<WebElement> list = driver.findElement(By.xpath("//table[@width = '580']//tbody")).findElements(By.tagName("tr"));
            driver.findElement(By.xpath("//div[contains(@eventproxy,'UnitManagerWindow_0_cl')]")).click();
            return "Found "+list.size()+"+ units";
        }catch(Exception e){
            System.out.println(e.getMessage());
            return "Something went wrong";
        }
    }

    public String RoleCheck(){
        try{
            driver.findElement(By.xpath("//div[text() = 'Role Manager']")).click();
            boolean expected[] = {true,true,true,true,false,true,true,true};
            Assert.assertArrayEquals(expected,checkIcons("//table[@height = '18px']//td[text() = 'Role Manager']",
                    "//div[contains(@eventproxy,'RoleManagerWindow_0_max')]",
                    "//div[contains(@eventproxy,'RoleManagerWindow_0_min')]",
                    "//div[contains(@eventproxy,'RoleManagerWindow_0_cl')]",
                    null,
                    "//div[contains(@eventproxy,'RoleManagerWindow_0')]//div[text() = 'Add Role']",
                    "//div[contains(@eventproxy,'RoleManagerWindow_0')]//div[text() = 'Start Editing']",
                    "//div[contains(@eventproxy,'RoleManagerWindow_0')]//div[text() = 'Remove Role']"
            ));
            Thread.sleep(800);
            driver.findElement(By.xpath("//div[contains(@eventproxy,'RoleManagerWindow_0_cl')]")).click();
            return "Not needed";
        }catch(Exception e){
            System.out.println(e.getMessage());
            return "Something went wrong";
        }
    }
    public String masterDataEquipmentCheck(){
        try{
            driver.findElement(By.xpath("//div[text() = 'Masterdata']")).click();
            Thread.sleep(500);
            driver.findElement(By.xpath("//div[contains(@eventproxy,'isc_Menu')]//div[text() ='Equipment']")).click();
            boolean expected[] = {true,true,true,true,true,true,true,false};
            Assert.assertArrayEquals(expected,checkIcons("//table[@height = '18px']//td[text() = 'Masterdata -> Equipment']",
                    "//div[contains(@eventproxy,'MasterdataManagerWindowNew_0_max')]",
                    "//div[contains(@eventproxy,'MasterdataManagerWindowNew_0_min')]",
                    "//div[contains(@eventproxy,'MasterdataManagerWindowNew_0_cl')]",
                    "//div[contains(@eventproxy,'MasterdataManagerWindowNew_0')]//input[@name = 'searchText']",
                    "//div[contains(@eventproxy,'MasterdataManagerWindowNew_0')]//div[text() = 'Reset']",
                    "//div[contains(@eventproxy,'MasterdataManagerWindowNew_0')]//div[text() = 'Report']",
                    null
            ));
            driver.findElement(By.xpath("//div[contains(@eventproxy,'MasterdataManagerWindowNew_0')]//div[text() = 'Search']")).click();
            Thread.sleep(1500);
            String findElements = driver.findElement(By.xpath("//div[contains(@eventproxy,'MasterdataManagerWindowNew_0')]//td[contains(text(),'Found')]")).getText();
            driver.findElement(By.xpath("//div[contains(@eventproxy,'MasterdataManagerWindowNew_0_cl')]")).click();
            return findElements;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return "Not found";
        }

    }

    public String masterDataSpareCheck(){
        try{
            driver.findElement(By.xpath("//div[text() = 'Masterdata']")).click();
            Thread.sleep(500);
            driver.findElement(By.xpath("//div[contains(@eventproxy,'isc_Menu')]//div[text() ='Spare Parts']")).click();
            boolean expected[] = {true,true,true,true,true,true,true,false};
            Assert.assertArrayEquals(expected,checkIcons("//table[@height = '18px']//td[text() = 'Masterdata -> Spare Parts']",
                    "//div[contains(@eventproxy,'MasterdataManagerWindowNew_1_max')]",
                    "//div[contains(@eventproxy,'MasterdataManagerWindowNew_1_min')]",
                    "//div[contains(@eventproxy,'MasterdataManagerWindowNew_1_cl')]",
                    "//div[contains(@eventproxy,'MasterdataManagerWindowNew_1')]//input[@name = 'searchText']",
                    "//div[contains(@eventproxy,'MasterdataManagerWindowNew_1')]//div[text() = 'Reset']",
                    "//div[contains(@eventproxy,'MasterdataManagerWindowNew_1')]//div[text() = 'Report']",
                    null
            ));
            driver.findElement(By.xpath("//div[contains(@eventproxy,'MasterdataManagerWindowNew_1')]//div[text() = 'Search']")).click();
            Thread.sleep(1500);
            String findElements = driver.findElement(By.xpath("//div[contains(@eventproxy,'MasterdataManagerWindowNew_1')]//td[contains(text(),'Found')]")).getText();
            driver.findElement(By.xpath("//div[contains(@eventproxy,'MasterdataManagerWindowNew_1_cl')]")).click();
            return findElements;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return "Not found";
        }

    }

    public String masterDataDocCheck(){
        try{
            driver.findElement(By.xpath("//div[text() = 'Masterdata']")).click();
            Thread.sleep(500);
            driver.findElement(By.xpath("//div[contains(@eventproxy,'isc_Menu')]//div[text() ='Document']")).click();
            Thread.sleep(500);
            boolean expected[] = {true,true,true,true,true,true,true,false};
            Assert.assertArrayEquals(expected,checkIcons("//table[@height = '18px']//td[text() = 'Masterdata -> Documents']",
                    "//div[contains(@eventproxy,'MasterdataManagerWindowNew_2_max')]",
                    "//div[contains(@eventproxy,'MasterdataManagerWindowNew_2_min')]",
                    "//div[contains(@eventproxy,'MasterdataManagerWindowNew_2_cl')]",
                    "//div[contains(@eventproxy,'MasterdataManagerWindowNew_2')]//input[@name = 'searchText']",
                    "//div[contains(@eventproxy,'MasterdataManagerWindowNew_2')]//div[text() = 'Reset']",
                    "//div[contains(@eventproxy,'MasterdataManagerWindowNew_2')]//div[text() = 'Report']",
                    null
            ));
            driver.findElement(By.xpath("//div[contains(@eventproxy,'MasterdataManagerWindowNew_2')]//div[text() = 'Search']")).click();
            Thread.sleep(1500);
            String findElements = driver.findElement(By.xpath("//div[contains(@eventproxy,'MasterdataManagerWindowNew_2')]//td[contains(text(),'Found')]")).getText();
            driver.findElement(By.xpath("//div[contains(@eventproxy,'MasterdataManagerWindowNew_2_cl')]")).click();
            return findElements;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return "Not found";
        }

    }

    public String masterDataOtherCheck(){
        try{
            driver.findElement(By.xpath("//div[text() = 'Masterdata']")).click();
            Thread.sleep(500);
            driver.findElement(By.xpath("//div[contains(@eventproxy,'isc_Menu')]//div[text() ='Other...']")).click();
            boolean expected[] = {true,true,true,true,true,true,true,false};
            Assert.assertArrayEquals(expected,checkIcons("//table[@height = '18px']//td[text() = 'Masterdata -> Other...']",
                    "//div[contains(@eventproxy,'MasterdataManagerWindow_0_max')]",
                    "//div[contains(@eventproxy,'MasterdataManagerWindow_0_min')]",
                    "//div[contains(@eventproxy,'MasterdataManagerWindow_0_cl')]",
                    "//div[contains(@eventproxy,'MasterdataManagerWindow_0')]//input[@name = 'searchText']",
                    "//div[contains(@eventproxy,'MasterdataManagerWindow_0')]//div[text() = 'Reset']",
                    "//div[contains(@eventproxy,'MasterdataManagerWindow_0')]//div[text() = 'Report']",
                    null
            ));
            driver.findElement(By.xpath("//div[contains(@eventproxy,'MasterdataManagerWindow_0')]//div[text() = 'Search']")).click();
            Thread.sleep(1500);
            String findElements = driver.findElement(By.xpath("//div[contains(@eventproxy,'MasterdataManagerWindow_0')]//td[contains(text(),'Found')]")).getText();
            driver.findElement(By.xpath("//div[contains(@eventproxy,'MasterdataManagerWindow_0_cl')]")).click();
            return findElements;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return "Not found";
        }

    }



    public String nmProductCheck(){
        try{
            driver.findElement(By.xpath("//div[text() = 'N&M Manager']")).click();
            driver.findElement(By.xpath("//div[text() = 'Product']")).click();
            Thread.sleep(500);

            boolean expected[] = {true,false,true,true,false,true,true,false};
            Assert.assertArrayEquals(expected,checkIcons("//table[@height = '18px']//td[contains(text(),'PRODUCT')]",
                    null,
                    "//div[contains(@eventproxy,'KBWindow_0_min')]",
                    "//div[contains(@eventproxy,'KBWindow_0_cl')]",
                    null,
                    "//div[contains(@eventproxy,'KBWindow_0')]//div[contains(@style , 'left: 220px')]",
                    "//div[contains(@eventproxy,'KBWindow_0')]//div[contains(@style , 'left: 225px')]", //add button
                    null
            ));

            driver.findElement(By.xpath("//div[contains(@eventproxy,'KBWindow_0_cl')]")).click();
            return "Not needed";
        }catch(Exception e){
            System.out.println(e.getMessage());
            return "Not found";
        }
    }

    public String nmCharCheck(){
        try{
            driver.findElement(By.xpath("//div[text() = 'N&M Manager']")).click();
            driver.findElement(By.xpath("//div[text() = 'Characteristic']")).click();
            Thread.sleep(500);

            boolean expected[] = {true,false,true,true,false,true,true,false};
            Assert.assertArrayEquals(expected,checkIcons("//table[@height = '18px']//td[contains(text(),'CHARACTERISTIC')]",
                    null,
                    "//div[contains(@eventproxy,'KBWindow_1_min')]",
                    "//div[contains(@eventproxy,'KBWindow_1_cl')]",
                    null,
                    "//div[contains(@eventproxy,'KBWindow_1')]//div[contains(@style , 'left: 220px')]",
                    "//div[contains(@eventproxy,'KBWindow_1')]//div[contains(@style , 'left: 225px')]", //add button
                    null
            ));

            driver.findElement(By.xpath("//div[contains(@eventproxy,'KBWindow_1_cl')]")).click();
            return "Not needed";
        }catch(Exception e){
            System.out.println(e.getMessage());
            return "Not found";
        }
    }
    public String masterSyncCheck(){
        try{
            driver.findElement(By.xpath("//div[text() = 'Synchronize']")).click();
            Thread.sleep(500);
            driver.findElement(By.xpath("//div[text()='Master']")).click();
            boolean expected[] = {true,true,true,true,true,true,true,true};
            Assert.assertArrayEquals(expected,checkIcons("//table[@height = '18px']//td[text() = 'Master Product Synchronization']",
                    "//div[contains(@eventproxy,'KBWindow_2_max')]",
                    "//div[contains(@eventproxy,'KBWindow_2_min')]",
                    "//div[contains(@eventproxy,'KBWindow_2_cl')]",
                    "//div[contains(@eventproxy,'KBWindow_2')]//input[@name = 'searchText']",
                    "//div[contains(@eventproxy,'KBWindow_2')]//div[text() = 'Reset']",
                    "//div[contains(@eventproxy,'KBWindow_2')]//div[text() = 'Report']",
                    "//div[contains(@eventproxy,'KBWindow_2')]//div[text() = 'Synchronize']"
            ));
            driver.findElement(By.xpath("//div[contains(@eventproxy,'KBWindow_2')]//div[text() = 'Search']")).click();
            Thread.sleep(1500);
            String findElements = driver.findElement(By.xpath("//div[contains(@eventproxy,'KBWindow_2')]//td[contains(text(),'Found')]")).getText();
            driver.findElement(By.xpath("//div[contains(@eventproxy,'KBWindow_2_cl')]")).click();
            return findElements;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return "Not found";
        }

    }

    public String spareSyncCheck(){
        try{
            driver.findElement(By.xpath("//div[text() = 'Synchronize']")).click();
            Thread.sleep(500);
            driver.findElement(By.xpath("//div[contains(@style , 'top: 42')]//div[text()='Spare Parts']")).click();
            boolean expected[] = {true,true,true,true,true,true,true,true};
            Assert.assertArrayEquals(expected,checkIcons("//table[@height = '18px']//td[text() = 'Spare Parts Synchronization']",
                    "//div[contains(@eventproxy,'KBWindow_3_max')]",
                    "//div[contains(@eventproxy,'KBWindow_3_min')]",
                    "//div[contains(@eventproxy,'KBWindow_3_cl')]",
                    "//div[contains(@eventproxy,'KBWindow_3')]//input[@name = 'searchText']",
                    "//div[contains(@eventproxy,'KBWindow_3')]//div[text() = 'Reset']",
                    "//div[contains(@eventproxy,'KBWindow_3')]//div[text() = 'Report']",
                    "//div[contains(@eventproxy,'KBWindow_3')]//div[text() = 'Synchronize']"
            ));
            driver.findElement(By.xpath("//div[contains(@eventproxy,'KBWindow_3')]//div[text() = 'Search']")).click();
            Thread.sleep(1500);
            String findElements = driver.findElement(By.xpath("//div[contains(@eventproxy,'KBWindow_3')]//td[contains(text(),'Found')]")).getText();
            driver.findElement(By.xpath("//div[contains(@eventproxy,'KBWindow_3_cl')]")).click();
            return findElements;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return "Not found";
        }

    }
    public String instanceEquipCheck(){
        try{
            driver.findElement(By.xpath("//div[text() = 'Synchronize']")).click();
            Thread.sleep(500);
            driver.findElement(By.xpath("//div[text()='Instance']")).click();
            driver.findElement(By.xpath("//div[contains(@style , 'top: 52')]//div[text()='Equipment']")).click();
            boolean expected[] = {true,true,true,true,true,true,true,true};
            Assert.assertArrayEquals(expected,checkIcons("//table[@height = '18px']//td[text() = 'Equipment Synchronization']",
                    "//div[contains(@eventproxy,'InstanceSynchronizationWindow_0_max')]",
                    "//div[contains(@eventproxy,'InstanceSynchronizationWindow_0_min')]",
                    "//div[contains(@eventproxy,'InstanceSynchronizationWindow_0_cl')]",
                    "//div[contains(@eventproxy,'InstanceSynchronizationWindow_0')]//input[@name = 'searchTextBox']",
                    "//div[contains(@eventproxy,'InstanceSynchronizationWindow_0')]//div[text() = 'Conditions reset']",
                    "//div[contains(@eventproxy,'InstanceSynchronizationWindow_0')]//div[text() = 'Report...']",
                    "//div[contains(@eventproxy,InstanceSynchronizationWindow_0')]//div[text() = 'Synchronize']"
            ));
            driver.findElement(By.xpath("//div[contains(@eventproxy,'InstanceSynchronizationWindow_0')]//div[text() = 'Search']")).click();
            Thread.sleep(1500);
            String findElements = driver.findElement(By.xpath("//div[contains(@eventproxy,'InstanceSynchronizationWindow_0')]//td[contains(text(),'Found')]")).getText();
            driver.findElement(By.xpath("//div[contains(@eventproxy,'InstanceSynchronizationWindow_0_cl')]")).click();
            return findElements;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return "Not found";
        }

    }

    public String instanceDocCheck(){
        try{
            driver.findElement(By.xpath("//div[text() = 'Synchronize']")).click();
            Thread.sleep(500);
            driver.findElement(By.xpath("//div[text()='Instance']")).click();
            driver.findElement(By.xpath("//div[contains(@style , 'top: 52')]//div[text()='Documents']")).click();
            boolean expected[] = {true,true,true,true,true,true,true,true};
            Assert.assertArrayEquals(expected,checkIcons("//table[@height = '18px']//td[text() = 'Document Instance Synchronization']",
                    "//div[contains(@eventproxy,'InstanceSynchronizationWindow_1_max')]",
                    "//div[contains(@eventproxy,'InstanceSynchronizationWindow_1_min')]",
                    "//div[contains(@eventproxy,'InstanceSynchronizationWindow_1_cl')]",
                    "//div[contains(@eventproxy,'InstanceSynchronizationWindow_1')]//input[@name = 'searchTextBox']",
                    "//div[contains(@eventproxy,'InstanceSynchronizationWindow_1')]//div[text() = 'Conditions reset']",
                    "//div[contains(@eventproxy,'InstanceSynchronizationWindow_1')]//div[text() = 'Report...']",
                    "//div[contains(@eventproxy,InstanceSynchronizationWindow_1')]//div[text() = 'Synchronize']"
            ));
            driver.findElement(By.xpath("//div[contains(@eventproxy,'InstanceSynchronizationWindow_1')]//div[text() = 'Search']")).click();
            Thread.sleep(1500);
            String findElements = driver.findElement(By.xpath("//div[contains(@eventproxy,'InstanceSynchronizationWindow_1')]//td[contains(text(),'Found')]")).getText();
            driver.findElement(By.xpath("//div[contains(@eventproxy,'InstanceSynchronizationWindow_1_cl')]")).click();
            return findElements;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return "Not found";
        }

    }

    public String instanceAspectCheck(){
        try{
            driver.findElement(By.xpath("//div[text() = 'Synchronize']")).click();
            Thread.sleep(500);
            driver.findElement(By.xpath("//div[text()='Instance']")).click();
            driver.findElement(By.xpath("//div[contains(@style , 'top: 52')]//div[text()='Aspect']")).click();
            boolean expected[] = {true,true,true,true,true,true,true,true};
            Assert.assertArrayEquals(expected,checkIcons("//table[@height = '18px']//td[text() = 'Aspect Synchronization']",
                    "//div[contains(@eventproxy,'InstanceSynchronizationWindow_2_max')]",
                    "//div[contains(@eventproxy,'InstanceSynchronizationWindow_2_min')]",
                    "//div[contains(@eventproxy,'InstanceSynchronizationWindow_2_cl')]",
                    "//div[contains(@eventproxy,'InstanceSynchronizationWindow_2')]//input[@name = 'searchTextBox']",
                    "//div[contains(@eventproxy,'InstanceSynchronizationWindow_2')]//div[text() = 'Conditions reset']",
                    "//div[contains(@eventproxy,'InstanceSynchronizationWindow_2')]//div[text() = 'Report...']",
                    "//div[contains(@eventproxy,InstanceSynchronizationWindow_2')]//div[text() = 'Synchronize']"
            ));
            driver.findElement(By.xpath("//div[contains(@eventproxy,'InstanceSynchronizationWindow_2')]//div[text() = 'Search']")).click();
            Thread.sleep(1500);
            String findElements = driver.findElement(By.xpath("//div[contains(@eventproxy,'InstanceSynchronizationWindow_2')]//td[contains(text(),'Found')]")).getText();
            driver.findElement(By.xpath("//div[contains(@eventproxy,'InstanceSynchronizationWindow_2_cl')]")).click();
            return findElements;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return "Not found";
        }

    }
    private boolean[] isDisplayed(){
        boolean mass[] = new boolean[7];

        if(driver.findElement(By.xpath("//div[text() = 'Synchronize']")).isDisplayed()) mass[0] =true;
        if(driver.findElement(By.xpath("//div[text() = 'Masterdata']")).isDisplayed()) mass[1] =true;
        if(driver.findElement(By.xpath("//div[text() = 'N&M Manager']")).isDisplayed()) mass[2] =true;
        if(driver.findElement(By.xpath("//div[text() = 'Link Types Manager']")).isDisplayed()) mass[3] =true;
        if(driver.findElement(By.xpath("//div[text() = 'Role Manager']")).isDisplayed()) mass[4] =true;
        if(driver.findElement(By.xpath("//div[text() = 'Unit Manager']")).isDisplayed()) mass[5] =true;
        if(driver.findElement(By.xpath("//div[text() = 'Reports Manager']")).isDisplayed()) mass[6] =true;

        return mass;
    }
    private boolean[] checkIcons(String lable,String maximize,String minimize,String close,String searchBox ,String lowButton1,String lowButton2,String lowButton3){
        boolean isChecked[]= new boolean[8];
        try{
            Thread.sleep(200);

            if(lable!=null)if(driver.findElement(By.xpath(lable)).isDisplayed()) isChecked[0] =true;
            if(maximize!=null)if(driver.findElement(By.xpath(maximize)).isDisplayed()) isChecked[1] =true;
            if(minimize!=null)if(driver.findElement(By.xpath(minimize)).isDisplayed()) isChecked[2] =true;
            if(close!=null)if(driver.findElement(By.xpath(close)).isDisplayed()) isChecked[3] = true;
            if(searchBox!=null)if(driver.findElement(By.xpath(searchBox)).isDisplayed()) isChecked[4] =true;
            if(lowButton1!=null)   if (driver.findElement(By.xpath(lowButton1)).isDisplayed()) isChecked[5] = true;
            if(lowButton2!=null)  if (driver.findElement(By.xpath(lowButton2)).isDisplayed()) isChecked[6] = true;
            if(lowButton3!=null)  if (driver.findElement(By.xpath(lowButton2)).isDisplayed()) isChecked[7] = true;
            return isChecked;
        }catch(Exception e) {
            System.out.print(e.getMessage());
            return isChecked;
        }
    }
}
