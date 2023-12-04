package view.panels;

import javax.swing.*;
import java.util.Arrays;

public class ConcreteDimensionPanelBuilder implements PanelBuilder{
    private final JPanel panel;

    public ConcreteDimensionPanelBuilder(){
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
        return this.panel;
    }
}
