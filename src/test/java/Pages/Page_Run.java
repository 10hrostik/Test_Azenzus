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

        searchPage.OpenList();
        list.add(searchPage.aspectCheck());

        searchPage.OpenList();
        list.add(searchPage.commentCheck());

        System.out.println(list);
    }

    @Test
    public void Tools(){
        List<String> list = new ArrayList<>();
        Tools tools = new Tools();

        tools.OpenList();
        list.add(tools.TrashedItemsCheck());

        tools.OpenList();
        list.add(tools.QueueManagerCheck());

        tools.OpenList();
        list.add(tools.ImportMetaCheck());

        tools.OpenList();
        list.add(tools.ImportCheck());

        System.out.println(list);
    }
}
