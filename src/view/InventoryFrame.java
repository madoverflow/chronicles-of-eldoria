package view;
import model.inventory.Inventory;
import model.items.Item;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.nio.file.FileSystems;

public class InventoryFrame extends JFrame {
    private Inventory i = Inventory.getInventory();
    private static InventoryFrame inventory;
    private final JPanel panStone = new JPanel();
    private final JPanel panBoard = new JPanel();
    private final JPanel panLight = new JPanel();
    private final JLabel labelStoneIcon = new JLabel();
    private final JLabel labelBoardIcon = new JLabel();
    private final JLabel labelLightIcon = new JLabel();
    private final ImageIcon frameIcon = new ImageIcon(FileSystems.getDefault().getPath("src/model/assets/chest.png").toString());

    private InventoryFrame() {
        this.setIconImage(frameIcon.getImage());
        Container c = this.getContentPane();
        c.setLayout(new BorderLayout());
        c.add(panStone, BorderLayout.NORTH);
        c.add(panBoard, BorderLayout.CENTER);
        c.add(panLight, BorderLayout.SOUTH);
        labelStoneIcon.setPreferredSize(new Dimension(70,70));
        labelBoardIcon.setPreferredSize(new Dimension(70,70));
        labelLightIcon.setPreferredSize(new Dimension(70,70));

        panStone.add(labelStoneIcon);
        panBoard.add(labelBoardIcon);
        panLight.add(labelLightIcon);

        Border border = BorderFactory.createLineBorder(Color.BLACK);
        panStone.setBorder(BorderFactory.createTitledBorder(border, "Empty"));
        panBoard.setBorder(BorderFactory.createTitledBorder(border, "Empty"));
        panLight.setBorder(BorderFactory.createTitledBorder(border, "Empty"));

        for(Item item : i.getItems()){
            switch (item.getName()) {
                case "Stone" -> {
                    panStone.setBorder(BorderFactory.createTitledBorder(border, "Stone"));
                    labelStoneIcon.setIcon(item.getImageIcon());
                }
                case "Board" -> {
                    panBoard.setBorder(BorderFactory.createTitledBorder(border, "Board"));
                    labelBoardIcon.setIcon(item.getImageIcon());
                }
                case "Torch" -> {
                    panLight.setBorder(BorderFactory.createTitledBorder(border, "Torch"));
                    labelLightIcon.setIcon(item.getImageIcon());
                }
            }
        }
    }

    public static InventoryFrame getInventoryFrame(){
        inventory = new InventoryFrame();
        inventory.setTitle("Inventory");
        inventory.setSize(new Dimension(300, 350));
        //inventory.setLocationRelativeTo(null);
        inventory.setLocation(0,0);
        inventory.setResizable(false);
        inventory.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        inventory.setVisible(true);
        return inventory;
    }
}
