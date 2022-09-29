package Icons;

public class Director {
    public void buildSearch(Builder builder , String[] links){
        builder.setLabel(links[0]);
        builder.setMaximize(links[1]);
        builder.setMinimize(links[2]);
        builder.setClose(links[3]);
        builder.setSearchText(links[4]);
        builder.setButtomIcon1(links[5]);
        builder.setButtomIcon2(links[6]);
        builder.setButtomIcon3(links[7]);
        builder.setButtomIcon4(links[8]);
    }
    public void buildTool(Builder builder , String[] links){
        builder.setLabel(links[0]);
        builder.setMaximize(links[1]);
        builder.setMinimize(links[2]);
        builder.setClose(links[3]);
        builder.setSearchText(links[4]);
        builder.setButtomIcon1(links[5]);
        builder.setButtomIcon2(links[6]);
        builder.setButtomIcon3(links[7]);
    }
}
