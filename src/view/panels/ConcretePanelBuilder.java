package view.panels;

import javax.swing.*;
import java.util.Arrays;

public class ConcretePanelBuilder implements PanelBuilder{
    private final JPanel panel;

    public ConcretePanelBuilder(){
        this.panel = new JPanel();
        this.panel.setLayout(null);
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
