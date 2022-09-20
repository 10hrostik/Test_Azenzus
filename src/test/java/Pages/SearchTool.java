package Pages;

import Driver_Init.ChromeDriverInit;
import Driver_Init.DriverConstructor;
import ReadConfigs.Configs;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchTool extends DriverConstructor {

    @FindBy (xpath = "//td[text() = 'Search']")
    private WebElement SearchBox;

    public SearchTool(){
        driver.get(Configs.URL);
        PageFactory.initElements(driver,this);
    }
    public void OpenList(){
        try{
            Thread.sleep(1500);
            SearchBox.click();
            boolean expected[] = {true,true,true,true,true};
            Thread.sleep(200);
            Assert.assertArrayEquals(expected,isDisplayed());

        }catch(Exception e){
            System.out.print(e.getMessage());
        }

    }
    public String EquipmentCheck(){
        try{
            driver.findElement(By.xpath("//div[text() = 'Equipment']")).click();
            boolean expected[] = {true,true,true,true,true,true,true,true,true};
            Assert.assertArrayEquals(expected,checkIcons("//table[@height = '18px']//td[text() = 'Equipment Manager']",
                    "//div[contains(@eventproxy,'QueryManagerWindowNew_0_max')]",
                    "//div[contains(@eventproxy,'QueryManagerWindowNew_0_min')]",
                    "//div[contains(@eventproxy,'QueryManagerWindowNew_0_cl')]",
                    "//div[contains(@eventproxy,'QueryManagerWindowNew_0')]//input[@name = 'searchTextBox']",
                    "//div[contains(@eventproxy,'QueryManagerWindowNew_0')]//div[text() = 'Start Editing']",
                    "//div[contains(@eventproxy,'QueryManagerWindowNew_0')]//div[text() = 'Conditions reset']",
                    "//div[contains(@eventproxy,'QueryManagerWindowNew_0')]//div[text() = 'Layout reset']",
                    "//div[contains(@eventproxy,'QueryManagerWindowNew_0')]//div[text() = 'Report...']"
            ));
            driver.findElement(By.xpath("//div[contains(@eventproxy,'QueryManagerWindowNew_0')]//div[text() = 'Search']")).click();
            Thread.sleep(800);
            String findElements = driver.findElement(By.xpath("//div[contains(@eventproxy,'QueryManagerWindowNew_0')]//td[contains(text(),'Found')]")).getText();
            driver.findElement(By.xpath("//div[contains(@eventproxy,'QueryManagerWindowNew_0_cl')]")).click();
            return findElements;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return "Not found";
        }
    }
    public String contactCheck(){
        try{
            driver.findElement(By.xpath("//div[text() = 'Contact']")).click();
            boolean expected[] = {true,true,true,true,true,false,false,false,false};
            Assert.assertArrayEquals(expected,checkIcons("//table[@height='18px']//td[text()='Contact Manager']",
                    "//div[contains(@eventproxy,'ContactManagerWindowNew_0_max')]",
                    "//div[contains(@eventproxy,'ContactManagerWindowNew_0_min')]",
                    "//div[contains(@eventproxy,'ContactManagerWindowNew_0_cl')]",
                    "//div[contains(@eventproxy,'QueryManagerWindowNew_0')]//input[@name = 'CMSearchText']",
                    null,null,null,null
            ));
            driver.findElement(By.xpath("//div[contains(@eventproxy,'ButtonItem_14_button')]//div[text() = 'Search']")).click();
            Thread.sleep(800);
            String findElements = driver.findElement(By.xpath("//td[contains(text(),'record')]")).getText();
            driver.findElement(By.xpath("//div[contains(@eventproxy,'QueryManagerWindowNew_0_cl')]")).click();
            return findElements;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return "Not found";
        }
    }

    public String docCheck(){
        try{
            driver.findElement(By.xpath("//div[text() = 'Document']")).click();
            boolean expected[] = {true,true,true,true,true,true,true,true,true};
            Assert.assertArrayEquals(expected,checkIcons("//table[@height = '18px']//td[text() = 'Document Manager']",
                    "//div[contains(@eventproxy,'DocumentManagerSearchWindowNew_0_max')]",
                    "//div[contains(@eventproxy,'DocumentManagerSearchWindowNew_0_min')]",
                    "//div[contains(@eventproxy,'DocumentManagerSearchWindowNew_0_cl')]",
                    "//div[contains(@eventproxy,'DocumentManagerSearchWindowNew_0')]//input[@name = 'searchTextBox']",
                    "//div[contains(@eventproxy,'DocumentManagerSearchWindowNew_0')]//div[text() = 'Start Editing']",
                    "//div[contains(@eventproxy,'DocumentManagerSearchWindowNew_0')]//div[text() = 'Conditions reset']",
                    "//div[contains(@eventproxy,'DocumentManagerSearchWindowNew_0')]//div[text() = 'Layout reset']",
                    "//div[contains(@eventproxy,'DocumentManagerSearchWindowNew_0')]//div[text() = 'Report...']"
            ));
            driver.findElement(By.xpath("//div[contains(@eventproxy,'DocumentManagerWindowNew_0')]//div[text() = 'Search']")).click();
            Thread.sleep(800);
            String findElements = driver.findElement(By.xpath("//div[contains(@eventproxy,'DocumentManagerSearchWindowNew_0')]//td[contains(text(),'Found')]")).getText();
            driver.findElement(By.xpath("//div[contains(@eventproxy,'DocumentManagerSearchWindowNew_0_cl')]")).click();
            return findElements;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return "Not found";
        }
    }
    public String aspectCheck(){
        try{
            driver.findElement(By.xpath("//div[text() = 'Equipment']")).click();
            boolean expected[] = {true,true,true,true,true,true,true,true,true};
            Assert.assertArrayEquals(expected,checkIcons("//table[@height = '18px']//td[text() = 'Equipment Manager']",
                    "//div[contains(@eventproxy,'QueryManagerWindowNew_0_max')]",
                    "//div[contains(@eventproxy,'QueryManagerWindowNew_0_min')]",
                    "//div[contains(@eventproxy,'QueryManagerWindowNew_0_cl')]",
                    "//div[contains(@eventproxy,'QueryManagerWindowNew_0')]//input[@name = 'searchTextBox']",
                    "//div[contains(@eventproxy,'QueryManagerWindowNew_0')]//div[text() = 'Start Editing']",
                    "//div[contains(@eventproxy,'QueryManagerWindowNew_0')]//div[text() = 'Conditions reset']",
                    "//div[contains(@eventproxy,'QueryManagerWindowNew_0')]//div[text() = 'Layout reset']",
                    "//div[contains(@eventproxy,'QueryManagerWindowNew_0')]//div[text() = 'Report...']"
            ));
            driver.findElement(By.xpath("//div[contains(@eventproxy,'QueryManagerWindowNew_0')]//div[text() = 'Search']")).click();
            Thread.sleep(800);
            String findElements = driver.findElement(By.xpath("//div[contains(@eventproxy,'QueryManagerWindowNew_0')]//td[contains(text(),'Found')]")).getText();
            driver.findElement(By.xpath("//div[contains(@eventproxy,'QueryManagerWindowNew_0_cl')]")).click();
            return findElements;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return "Not found";
        }
    }
    public String commentCheck(){
        try{
            driver.findElement(By.xpath("//div[text() = 'Equipment']")).click();
            boolean expected[] = {true,true,true,true,true,true,true,true,true};
            Assert.assertArrayEquals(expected,checkIcons("//table[@height = '18px']//td[text() = 'Equipment Manager']",
                    "//div[contains(@eventproxy,'QueryManagerWindowNew_0_max')]",
                    "//div[contains(@eventproxy,'QueryManagerWindowNew_0_min')]",
                    "//div[contains(@eventproxy,'QueryManagerWindowNew_0_cl')]",
                    "//div[contains(@eventproxy,'QueryManagerWindowNew_0')]//input[@name = 'searchTextBox']",
                    "//div[contains(@eventproxy,'QueryManagerWindowNew_0')]//div[text() = 'Start Editing']",
                    "//div[contains(@eventproxy,'QueryManagerWindowNew_0')]//div[text() = 'Conditions reset']",
                    "//div[contains(@eventproxy,'QueryManagerWindowNew_0')]//div[text() = 'Layout reset']",
                    "//div[contains(@eventproxy,'QueryManagerWindowNew_0')]//div[text() = 'Report...']"
            ));
            driver.findElement(By.xpath("//div[contains(@eventproxy,'QueryManagerWindowNew_0')]//div[text() = 'Search']")).click();
            Thread.sleep(800);
            String findElements = driver.findElement(By.xpath("//div[contains(@eventproxy,'QueryManagerWindowNew_0')]//td[contains(text(),'Found')]")).getText();
            driver.findElement(By.xpath("//div[contains(@eventproxy,'QueryManagerWindowNew_0_cl')]")).click();
            return findElements;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return "Not found";
        }
    }

    private boolean[] isDisplayed(){
        boolean mass[] = new boolean[5];

        if(driver.findElement(By.xpath("//div[text() = 'Equipment']")).isDisplayed()) mass[0] =true;
        if(driver.findElement(By.xpath("//div[text() = 'Contact']")).isDisplayed()) mass[1] =true;
        if(driver.findElement(By.xpath("//div[text() = 'Document']")).isDisplayed()) mass[2] =true;
        if(driver.findElement(By.xpath("//div[text() = 'Aspect']")).isDisplayed()) mass[3] =true;
        if(driver.findElement(By.xpath("//div[text() = 'Comment']")).isDisplayed()) mass[4] =true;

        return mass;
    }
    private boolean[] checkIcons(String lable,String maximize,String minimize,String close,String searchBox ,String startEditing,String CondtionRest,String layOutReset,String report){
        boolean isChecked[]= new boolean[9];
        try{
            Thread.sleep(200);
            if(report!=null&&layOutReset!=null&&CondtionRest!=null&&startEditing!=null){
                if(driver.findElement(By.xpath(startEditing)).isDisplayed()) isChecked[5] =true;
                if(driver.findElement(By.xpath(CondtionRest)).isDisplayed()) isChecked[6] =true;
                if(driver.findElement(By.xpath(layOutReset)).isDisplayed()) isChecked[7] =true;
                if(driver.findElement(By.xpath(report)).isDisplayed()) isChecked[8] =true;
            }
            if(driver.findElement(By.xpath(lable)).isDisplayed()) isChecked[0] =true;
            if(driver.findElement(By.xpath(maximize)).isDisplayed()) isChecked[1] =true;
            if(driver.findElement(By.xpath(minimize)).isDisplayed()) isChecked[2] =true;
            if(driver.findElement(By.xpath(close)).isDisplayed()) isChecked[3] =true;
            if(driver.findElement(By.xpath(searchBox)).isDisplayed()) isChecked[4] =true;


            return isChecked;
        }catch(Exception e) {
            return isChecked;
        }
    }
}
