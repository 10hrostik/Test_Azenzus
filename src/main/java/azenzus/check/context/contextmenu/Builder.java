package azenzus.check.context.contextmenu;

public interface Builder {
    Builder setLabel(String label);
    Builder setMinimize(String min);
    Builder setMaximize(String max);
    Builder setClose(String close);
    Builder setButton1(String button);
    Builder setButton2(String button);
    Builder setButton3(String button);
    Builder setButton4(String button);
    Builder setButton5(String button);
    Builder setButton6(String button);
    Window getResult();
}
