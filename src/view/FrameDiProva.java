package view;

import controller.InventoryKeyListener;

import javax.swing.*;
import java.awt.*;

public class FrameDiProva extends JFrame {

    private FrameDiProva(){
        Container c = this.getContentPane();
        this.addKeyListener(new InventoryKeyListener());
    };
    public static void initGUI(){
        FrameDiProva frame = new FrameDiProva();
        frame.requestFocus();
        frame.setTitle("");
        frame.setSize(new Dimension(300,350));
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
