package controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import view.InventoryFrame;

public class InventoryKeyListener extends KeyAdapter {
    private InventoryFrame inventoryFrame;
    private static boolean isClosed = false;
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_I) {
            if (!isClosed) {
                inventoryFrame = InventoryFrame.getInventoryFrame();
                inventoryFrame.setVisible(true);
                isClosed = true;
            } else {
                inventoryFrame.dispose();
                isClosed = false;
            }
        }
    }
}
