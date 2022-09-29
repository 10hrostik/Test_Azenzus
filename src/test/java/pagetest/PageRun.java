package pagetest;

import resources.Links;
import org.junit.After;
import org.junit.Test;
import pages.DataManagerTool;
import pages.SearchTool;
import pages.ToolsTool;

import java.util.ArrayList;
import java.util.List;

public class PageRun {

    @Test
    public void search(){

        List<String> list = new ArrayList<>();
        SearchTool searchWindow = new SearchTool();
        for(String[] links : Links.searchLinks){
            searchWindow.openList();
            list.add(searchWindow.windowCheck(links));
        }
        System.out.println(list);
    }

    @Test
    public void tools(){
        List<String> list = new ArrayList<>();
        ToolsTool tools = new ToolsTool();
        for(String[] links : Links.toolLinks){
            tools.openList();
            list.add(tools.windowCheck(links));
        }
        System.out.println(list);
    }

    @Test
    public void data(){
        List<String> list = new ArrayList<>();
        DataManagerTool data = new DataManagerTool();

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
