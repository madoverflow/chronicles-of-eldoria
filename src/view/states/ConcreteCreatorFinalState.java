package view.states;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class ConcreteCreatorFinalState implements CreatorState{
    @Override
    public JFrame createState(JPanel panel) {
        JFrame state = new JFrame();
        Container container = state.getContentPane();
        ImageIcon backgroundImage = new ImageIcon(
                Objects.requireNonNull(this.getClass().getResource("model/assets/sfondo.png"))
        );
        JLabel labelBackgroundImage = new JLabel(backgroundImage);
        labelBackgroundImage.setBounds(0, 0, backgroundImage.getIconWidth(), backgroundImage.getIconHeight());
        state.setSize(new Dimension(800, 650));
        state.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        state.setLocationRelativeTo(null);
        state.setResizable(false);
        state.setVisible(false);
        container.add(labelBackgroundImage);
        container.add(panel);
        return state;
    }
}
