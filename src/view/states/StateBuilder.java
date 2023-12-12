package view.states;

import javax.swing.*;

public interface StateBuilder {
    JFrame build();
    void reset();
    void buildBackground(String path);
    void buildPanel(JPanel panel);
}
