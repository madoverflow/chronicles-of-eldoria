package view.buttons;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;
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
    public void buildText(String name) {
        this.button.setText(name);
    }

    @Override
    public void buildBackgroundColor(Color color) {
        this.button.setBackground(color);
    }

    @Override
    public void buildForegroundColor(Color color) {
        this.button.setForeground(color);
    }

    @Override
    public void builFont(Font font) {
        this.button.setFont(font);
    }

    @Override
    public void buildOpaque(boolean flag) {
        this.button.setOpaque(flag);
    }

    @Override
    public void buildBorder(Border border) {
        this.button.setBorder(border);
    }

    @Override
    public void buildListener(MouseAdapter mouseAdapter) {
        this.button.addMouseListener(mouseAdapter);
    }
    public void buildListener(ActionListener actionListener) {
        this.button.addActionListener(actionListener);
    }

}
