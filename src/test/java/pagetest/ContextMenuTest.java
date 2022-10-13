package pagetest;

import me.tree.Document;
import me.tree.Function;
import me.tree.Location;
import org.junit.Test;

public class ContextMenuTest {

    @Test
    public void Function(){
        Function fun = new Function();
        fun.openPlant();

    }
    @Test
    public void Location(){
        Location location = new Location();
        location.openPlant();

    }

    @Test
    public void document(){
        Document doc = new Document();
        doc.openPlant();

    }

}
