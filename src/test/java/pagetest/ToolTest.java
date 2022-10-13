package pagetest;

import me.resources.Links;
import org.junit.After;
import org.junit.Test;
import me.tool.DataManager;
import me.tool.Search;
import me.tool.Tools;

import java.util.ArrayList;
import java.util.List;

public class ToolTest {

    @Test
    public void search(){

        List<String> list = new ArrayList<>();
        Search searchWindow = new Search();
        for(String[] links : Links.searchLinks){
            searchWindow.openList();
            list.add(searchWindow.windowCheck(links));
        }
        System.out.println(list);
    }

    @Test
    public void tools(){
        List<String> list = new ArrayList<>();
        Tools tools = new Tools();
        for(String[] links : Links.toolLinks){
            tools.openList();
            list.add(tools.windowCheck(links));
        }
        System.out.println(list);
    }

    @Test
    public void data(){
        List<String> list = new ArrayList<>();
        DataManager data = new DataManager();

        for(String[] links : Links.dataManagerLinks){
            data.openList();
            list.add(data.windowCheck(links));
        }
        System.out.print(list);
    }
    @After
    public void shutDown(){
        //driver.close();
    }
}
