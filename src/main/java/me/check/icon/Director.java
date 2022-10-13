package me.check.icon;

public class Director {
    public void buildSearch(Builder builder , String[] links){
        builder.setLabel(links[0]).setMaximize(links[1])
                .setMinimize(links[2])
                .setClose(links[3])
                .setSearchText(links[4])
                .setBottomIcon1(links[5])
                .setBottomIcon2(links[6])
                .setBottomIcon3(links[7])
                .setBottomIcon4(links[8]);
    }
    public void buildTool(Builder builder , String[] links){
        builder.setLabel(links[0]).setMaximize(links[1])
                .setMinimize(links[2])
                .setClose(links[3])
                .setSearchText(links[4])
                .setBottomIcon1(links[5])
                .setBottomIcon2(links[6])
                .setBottomIcon3(links[7]);
    }
}
