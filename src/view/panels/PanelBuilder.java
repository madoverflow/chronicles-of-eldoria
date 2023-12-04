package view.panels;

import javax.swing.*;

public interface PanelBuilder {
    void buildComponents(JComponent... components);
    JPanel build();
}
