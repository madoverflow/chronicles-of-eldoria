package view.scroll;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;

public class ConcreteScrollBuilder implements ScrollBuilder{
    private JScrollPane scrollPane;
    private JTextArea textArea;
    public ConcreteScrollBuilder(){this.reset();}
    @Override
    public void reset(){
        this.scrollPane = new JScrollPane();
        this.textArea = new JTextArea();
        this.textArea.setFocusable(false);
        this.textArea.setLineWrap(true);
        this.textArea.setWrapStyleWord(true);
        this.textArea.setEditable(false);
        this.textArea.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        this.textArea.setOpaque(false);
        this.textArea.setForeground(new Color(0.58f,0.29f,0f));
        this.scrollPane.setViewportView(this.textArea);
        this.scrollPane.setOpaque(false);
        this.scrollPane.setBorder(BorderFactory.createLineBorder(new Color(0.58f,0.29f,0f), 3));
        this.scrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI(){
            @Override
            protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(new Color(0.58f,0.29f,0f)); //Colore barretta
                g2.fillRect(thumbBounds.x, thumbBounds.y, thumbBounds.width, thumbBounds.height);
            }
            @Override
            protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(new Color(0.76f,0.59f,0.30f)); //Colore barra di scorrimento
                g2.fillRect(trackBounds.x, trackBounds.y, trackBounds.width, trackBounds.height);
            }
            @Override
            protected JButton createDecreaseButton(int orientation) {
                return createZeroButton();
            }
            @Override
            protected JButton createIncreaseButton(int orientation) {
                return createZeroButton();
            }
            private JButton createZeroButton() {
                JButton button = new JButton();
                button.setPreferredSize(new Dimension(0, 0));
                button.setMinimumSize(new Dimension(0, 0));
                button.setMaximumSize(new Dimension(0, 0));
                return button;
            }
        });
    }
    @Override
    public void buildDimension(int x, int y, int width, int height){
        this.scrollPane.setBounds(x, y, width, height);
    }
    @Override
    public void buildText(String text){
        this.textArea.setText(text);
    }
    @Override
    public JScrollPane build(){
        return this.scrollPane;
    }
}
