package view;


import controller.ButtonWindowAdapter;

import view.buttons.ConcreteButtonBuilder;
import javax.swing.*;
import java.awt.*;
import java.util.Objects;


public class MenuFrame extends JFrame {
    Container c;
    JPanel titleNamePanel, startButtonPanel;
    JLabel titleNameLabel;
    ButtonWindowAdapter adapter;
    private static MenuFrame menuFrame;



    Font titleFont = new Font("Times New Roman", Font.PLAIN, 48);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 30);

    private MenuFrame() {
        super("Game Menu");
        c = this.getContentPane();
        c.setBackground(Color.BLACK);
        this.setLayout(null);


        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100, 100, 600, 150);
        titleNamePanel.setBackground(Color.BLACK);
        titleNameLabel = new JLabel("CHRONICLES OF ELDORIA");
        titleNameLabel.setForeground(Color.BLACK);
       // titleNameLabel.setBorder(BorderFactory.createLineBorder(Color.MAGENTA));
        titleNameLabel.setFont(titleFont);
        titleNamePanel.add(titleNameLabel);
        titleNamePanel.setOpaque(false);

        startButtonPanel=new JPanel();
        startButtonPanel.setBounds(300,450,200,100);
        startButtonPanel.setBackground(Color.black);
        ConcreteButtonBuilder buttonBuilder = new ConcreteButtonBuilder();
        buttonBuilder.buildText("START");
        buttonBuilder.buildForegroundColor(Color.BLACK);
        buttonBuilder.builFont(normalFont);
        //buttonBuilder.buildBackgroundColor(Color.BLACK);
        buttonBuilder.buildOpaque(false);
        //adapter = new ButtonWindowAdapter(); // Inizializza ButtonWindowAdapter con il frame corrente
        // buttonBuilder.buildListener(adapter); // Aggiungi il listener al pulsante

        //buttonBuilder.buildListener(e -> {
        //    GameFrame gameFrame= GameFrame.getGameFrame();
        //    MenuFrame.this.dispose();
        //});

        startButtonPanel.add(buttonBuilder.build());
        startButtonPanel.setOpaque(false);

        c.add(titleNamePanel);
        c.add(startButtonPanel);

        //imposta un immagine di sfondo
        ImageIcon backgroundImage = new ImageIcon("images/eldoria.jpg");
        JLabel labelBackgroundImage = new JLabel(backgroundImage);
        labelBackgroundImage.setBounds(0,0,800,614);
        c.add(labelBackgroundImage);

        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }
    //utilizzo il singleton
    public static MenuFrame getMenuFrame(){
        if (menuFrame==null) {
            menuFrame=new MenuFrame();
        }
        return menuFrame;
    }


}


