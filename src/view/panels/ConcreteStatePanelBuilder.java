package view.panels;

import javax.swing.*;
import java.util.Arrays;

public class ConcreteStatePanelBuilder implements PanelBuilder{
    private JPanel panel;

    public ConcreteStatePanelBuilder(){
        this.reset();
    }

    @Override
    public void reset() {
       this.panel = new JPanel();
       this.panel.setLayout(null);
       this.panel.setBounds(125,125,550,400);
       this.panel.setOpaque(true);
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
