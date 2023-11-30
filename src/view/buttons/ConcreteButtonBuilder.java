package view.buttons;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;

public class ConcreteButtonBuilder implements ButtonBuilder{
    private final JButton button;

    public ConcreteButtonBuilder(){
        this.button = new JButton();
    }

    @Override
    public JButton build() {
        return this.button;
    }

    @Override
    public void buildDimension(int x, int y, int width, int height) {
        this.button.setBounds(x, y, width, height);
    }

    @Override
    public void buildName(String name) {
        this.button.setName(name);
    }

    @Override
    public void buildColor(Color color) {
        this.button.setBackground(color);
    }

    @Override
    public void buildBorder(Border border) {
        this.button.setBorder(border);
    }

    @Override
    public void buildListener(MouseAdapter mouseAdapter) {
        this.button.addMouseListener(mouseAdapter);
    }
}
