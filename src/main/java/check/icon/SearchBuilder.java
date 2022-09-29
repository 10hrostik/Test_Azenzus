package check.icon;

import java.awt.*;

public class SearchBuilder implements Builder{
    WindowIcon window = new WindowIcon();
    public SearchBuilder setLabel(String label){
         window.label=label;
         return this;
    }
    public SearchBuilder setMinimize(String min){
         window.minimize=min;
         return this;
    }
    public SearchBuilder setMaximize(String max){
         window.maximize=max;
         return this;
    }
    public SearchBuilder setClose(String close){
         window.close=close;
         return this;
    }
    public SearchBuilder setSearchText(String searchText){
         window.searchText=searchText;
         return this;
    }
    public SearchBuilder setBottomIcon1(String buttomIcon1){
         window.bottomIcon1=buttomIcon1;
         return this;
    }
    public SearchBuilder setBottomIcon2(String buttomIcon2){
         window.bottomIcon2=buttomIcon2;
         return this;
    }
    public SearchBuilder setBottomIcon3(String buttomIcon3){
        window.bottomIcon3=buttomIcon3;
        return this;
    }
    public SearchBuilder setBottomIcon4(String buttomIcon4){
        window.bottomIcon4=buttomIcon4;
        return this;
    }
    public WindowIcon getResult(){
        return window;
    }
}
