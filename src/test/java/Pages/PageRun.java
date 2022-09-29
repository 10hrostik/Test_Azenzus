package Pages;

import DriverInitialization.ChromeDriverInit;
import ReadConfigs.Configs;
import ReadConfigs.Links;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PageRun extends ChromeDriverInit {


    public void login(){
        String login= Configs.LOGIN;
        String password = Configs.PASSWORD;

        LoginPage test= new LoginPage();
        test.Auth(login,password);
    }
    @Test
    public void search(){
        login();
        List<String> list = new ArrayList<>();
        SearchTool searchWindow = new SearchTool();
        for(String[] links : Links.searchLinks){
            searchWindow.OpenList();
            list.add(searchWindow.windowCheck(links));
        }
        System.out.println(list);
    }

    @Test
    public void tools(){
        List<String> list = new ArrayList<>();
        Tools tools = new Tools();

        for(String[] links : Links.toolLinks){
            tools.OpenList();
            list.add(tools.windowCheck(links));
        }
        System.out.println(list);
    }

    @Test
    public void data(){
        List<String> list = new ArrayList<>();
        DataManagerTool data = new DataManagerTool();

        for(String[] links : Links.dataManagerLinks){
            data.OpenList();
            list.add(data.windowCheck(links));
        }
        System.out.print(list);
    }
}
