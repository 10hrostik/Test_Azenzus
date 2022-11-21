package azenzus.check.context.contextmenu;

public class WindowBuilder implements Builder{
    Window window = Window.getWindow();
    public WindowBuilder setLabel(String label){
        window.label=label;
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
    public WindowBuilder setButton1(String button){
        window.button1 = button;
        return this;
    }
    public WindowBuilder setButton2(String button){
        window.button2 = button;
        return this;
    }
    public WindowBuilder setButton3(String button){
        window.button3 = button;
        return this;
    }
    public WindowBuilder setButton4(String button){
        window.button4 = button;
        return this;
    }
    public WindowBuilder setButton5(String button){
        window.button5 = button;
        return this;
    }
    public WindowBuilder setButton6(String button){
        window.button6 = button;
        return this;
    }
    public Window getResult(){
        return window;
    }
}
