package view.buttons;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

public interface ButtonBuilder {
    JButton build();
    void reset();
    void buildDimension(int x, int y, int width, int height);
    void buildText(String name);
    void buildBackgroundColor(Color color);
    void buildForegroundColor(Color color);
    void builFont(Font font);
    void buildOpaque(boolean flag);
    void buildBorder(Border border);
    void buildListener(ActionListener actionListener);
    void buildTip(String tip);
}
