package view.panels;

import javax.swing.*;
import java.util.Arrays;

public class ConcreteInventoryPanelBuilder implements PanelBuilder{
    private JPanel panel;

    public ConcreteInventoryPanelBuilder(){
        this.reset();
    }

    @Override
    public void reset() {
        this.panel = new JPanel();
        //Il layout in base all'implementazione va cambiato
        this.panel.setLayout(null);
        this.panel.setOpaque(true);
    }

    @Override
    //Va cambiato il corpo del metodo se il layout dovesse essere cambiato
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
