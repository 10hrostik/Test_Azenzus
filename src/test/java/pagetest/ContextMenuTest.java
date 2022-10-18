package pagetest;

import me.resources.Links;
import me.tree.Document;
import me.tree.Function;
import me.tree.Location;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ContextMenuTest {

    @Test
    public void function(){
        Function fun = new Function();
        fun.openPlant();
        Boolean checked = fun.windowCheck(Links.contextMenu,Links.subContextMenu);
        System.out.println("All function context menu buttons are correct? "+checked);
    }
    @Test
    public void location(){
        Location location = new Location();
        location.openPlant();
        Boolean checked = location.windowCheck(Links.contextMenu,Links.subContextMenu);
        System.out.println("All location context menu buttons are correct? "+checked);
    }

    @Test
    public void document(){
        Document doc = new Document();
        doc.openPlant();
        Boolean checked = doc.windowCheck(Links.contextMenu,Links.subContextMenu);
        System.out.println("All document context menu buttons are correct? "+checked);
    }

    @After
    public void shutDown(){
        //driver.close();
    }
}
