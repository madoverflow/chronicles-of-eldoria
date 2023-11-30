package view.buttons;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;

public interface ButtonBuilder {
    JButton build();
    void buildDimension(int x, int y, int width, int height);
    void buildName(String name);
    void buildColor(Color color);
    void buildBorder(Border border);
    void buildListener(MouseAdapter mouseAdapter);

}
