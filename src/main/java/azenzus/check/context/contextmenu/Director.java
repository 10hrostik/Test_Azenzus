package azenzus.check.context.contextmenu;

public class Director {
    public void buildWindow(Builder builder , String[] links){
        builder.setLabel(links[0])
                .setMaximize(links[1])
                .setMinimize(links[2])
                .setClose(links[3])
                .setButton1(links[4])
                .setButton2(links[5])
                .setButton3(links[6])
                .setButton4(links[7])
                .setButton5(links[8])
                .setButton6(links[9]);
    }
}
