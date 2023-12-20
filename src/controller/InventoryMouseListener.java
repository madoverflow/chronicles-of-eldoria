package controller;

import java.awt.event.MouseEvent;

import view.InventoryFrame;

public class InventoryMouseListener extends ButtonAdapter {
    private static InventoryFrame inventoryFrame;
    public static boolean isClosed = true;

    @Override
    public void mouseClicked(MouseEvent e){
       if(isClosed == true){
           inventoryFrame = InventoryFrame.getInventoryFrame();
           isClosed = false;
       }
       else{
           inventoryFrame.dispose();
           isClosed = true;
       }
    }
}
