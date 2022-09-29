package icons;

public class SearchBuilder implements Builder{
    WindowIcons window = new WindowIcons();
    public void setLabel(String label){
         window.label=label;
    }
    public void setMinimize(String min){
         window.minimize=min;
    }
    public void setMaximize(String max){
         window.maximize=max;
    }
    public void setClose(String close){
         window.close=close;
    }
    public void setSearchText(String searchText){
         window.searchText=searchText;
    }
    public void setBottomIcon1(String buttomIcon1){
         window.bottomIcon1=buttomIcon1;
    }
    public void setBottomIcon2(String buttomIcon2){
         window.bottomIcon2=buttomIcon2;
    }
    public void setBottomIcon3(String buttomIcon3){
        window.bottomIcon3=buttomIcon3;
    }
    public void setBottomIcon4(String buttomIcon4){
        window.bottomIcon4=buttomIcon4;
    }
    public WindowIcons getResult(){
        return window;
    }
}
