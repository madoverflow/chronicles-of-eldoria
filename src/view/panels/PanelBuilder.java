package view.panels;

import javax.swing.*;

public interface PanelBuilder {
    void reset();
    void buildComponents(JComponent... components);
    JPanel build();
}
