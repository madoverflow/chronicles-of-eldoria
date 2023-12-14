package view.scroll;

import javax.swing.*;

public interface ScrollBuilder {
    void reset();
    void buildDimension(int x, int y, int width, int height);
    void buildText(String text);
    JScrollPane build();

}
