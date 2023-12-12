package view;


import controller.ButtonWindowAdapter;

import view.buttons.ConcreteButtonBuilder;
import javax.swing.*;
import java.awt.*;
import java.nio.file.FileSystems;


public class MenuFrame extends JFrame {
    private final JPanel titleNamePanel;
    private final JPanel startButtonPanel;
    private final JLabel titleNameLabel;
    private static MenuFrame menuFrame;
    private final ConcreteButtonBuilder buttonBuilder;
    private final Font titleFont = new Font("Times New Roman", Font.PLAIN, 48);
    private final Font normalFont = new Font("Times New Roman", Font.PLAIN, 30);

    private MenuFrame() {
        super("Game Menu");
        Container contentPanel = this.getContentPane();
        contentPanel.setBackground(Color.BLACK);
        this.setLayout(null);

        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100, 100, 600, 150);
        titleNamePanel.setBackground(Color.BLACK);
        titleNameLabel = new JLabel("CHRONICLES OF ELDORIA");
        titleNameLabel.setForeground(Color.BLACK);
        titleNameLabel.setFont(titleFont);
        titleNamePanel.add(titleNameLabel);
        titleNamePanel.setOpaque(false);

        startButtonPanel=new JPanel();
        startButtonPanel.setBounds(300,450,200,100);
        startButtonPanel.setBackground(Color.black);
        buttonBuilder = new ConcreteButtonBuilder();
        buttonBuilder.buildText("START");
        buttonBuilder.buildForegroundColor(Color.BLACK);
        buttonBuilder.builFont(normalFont);
        buttonBuilder.buildOpaque(false);
        startButtonPanel.add(buttonBuilder.build());
        startButtonPanel.setOpaque(false);

        contentPanel.add(titleNamePanel);
        contentPanel.add(startButtonPanel);

        ImageIcon backgroundImage = new ImageIcon(
                FileSystems
                        .getDefault()
                        .getPath("src/model/assets/eldoria.jpg")
                        .toString()
        );
        JLabel labelBackgroundImage = new JLabel(backgroundImage);
        labelBackgroundImage.setBounds(0,0,800,614);
        contentPanel.add(labelBackgroundImage);

        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }

    public static MenuFrame getMenuFrame(){
        if (menuFrame==null) {
            menuFrame=new MenuFrame();
        }
        return menuFrame;
    }

}


