package view.states;

import javax.swing.*;
import java.awt.*;
import java.nio.file.FileSystems;

public class ConcreteFinalStateBuilder implements StateBuilder {
    private JFrame state;
    private JPanel panel;
    private JLabel labelBackgroundImage;

    public ConcreteFinalStateBuilder(){
        this.reset();
    }

    @Override
    public JFrame build() {
        Container contentPane = this.state.getContentPane();
        contentPane.add(this.panel);
        contentPane.add(this.labelBackgroundImage);
        return this.state;
    }

    @Override
    public void reset() {
        this.state = new JFrame();
        this.panel = new JPanel();
        this.labelBackgroundImage = new JLabel();
        state.setSize(new Dimension(800, 650));
        state.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        state.setLocationRelativeTo(null);
        state.setResizable(false);
        state.setVisible(false);
    }

    @Override
    public void buildBackground(String path) {
        ImageIcon backgroundImage = new ImageIcon(
                FileSystems
                        .getDefault()
                        .getPath(path)
                        .toString()
        );
        this.labelBackgroundImage = new JLabel(backgroundImage);
    }

    @Override
    public void buildPanel(JPanel panel) {
        this.panel = panel;
    }
}
