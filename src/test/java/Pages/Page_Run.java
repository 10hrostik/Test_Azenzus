package Pages;

import Driver_Init.ChromeDriverInit;
import ReadConfigs.Configs;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Page_Run extends ChromeDriverInit {

    @Before
    public void Login(){
        String login= Configs.LOGIN;
        String password = Configs.PASSWORD;

        Login_Page test= new Login_Page();
        test.Auth(login,password);
    }
    @Test
    public void Search(){
        List<String> list = new ArrayList<>();
        SearchTool searchPage = new SearchTool();
        searchPage.OpenList();
        list.add(searchPage.EquipmentCheck());

        searchPage.OpenList();
        list.add(searchPage.contactCheck());

        searchPage.OpenList();
        list.add(searchPage.docCheck());
        System.out.println(list);
    }
}
