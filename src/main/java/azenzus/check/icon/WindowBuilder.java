package azenzus.check.icon;

public class WindowBuilder implements Builder{
    WindowIcon window = WindowIcon.getWindow();
    public WindowBuilder setLabel(String label){
         window.label = label;
         return this;
    }
    public WindowBuilder setMinimize(String min){
         window.minimize = min;
         return this;
    }
    public WindowBuilder setMaximize(String max){
         window.maximize = max;
         return this;
    }
    public WindowBuilder setClose(String close){
         window.close = close;
         return this;
    }
    public WindowBuilder setSearchText(String searchText){
         window.searchText = searchText;
         return this;
    }
    public WindowBuilder setBottomIcon1(String buttomIcon1){
         window.bottomIcon1 = buttomIcon1;
         return this;
    }
    public WindowBuilder setBottomIcon2(String buttomIcon2){
         window.bottomIcon2 = buttomIcon2;
         return this;
    }
    public WindowBuilder setBottomIcon3(String buttomIcon3){
        window.bottomIcon3 = buttomIcon3;
        return this;
    }
    public WindowBuilder setBottomIcon4(String buttomIcon4){
        window.bottomIcon4 = buttomIcon4;
        return this;
    }
    public WindowIcon getResult(){
        return window;
    }
}
