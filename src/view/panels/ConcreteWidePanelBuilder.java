package view.panels;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class ConcreteWidePanelBuilder implements PanelBuilder{
    private JPanel panel;

    public ConcreteWidePanelBuilder(){
        this.reset();
    }

    @Override
    public void reset() {
        this.panel = new JPanel();
        this.panel.setLayout(null);
        this.panel.setBounds(0,0,786,613); //Dimensioni Pannello 786 x 613
        this.panel.setOpaque(false);
    }

    @Override
    public void buildComponents(JComponent... components) {
        Arrays.stream(components).forEach(this.panel::add);
    }

    @Override
    public JPanel build() {
        JPanel tmpPanel = this.panel;
        this.reset();
        return tmpPanel;
    }
}