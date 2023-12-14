import model.inventory.Inventory;
import model.items.ConcreteItemBuilder;
import model.items.Item;
import model.items.ItemBuilder;
import model.items.ItemDirector;
import view.FrameDiProva;
import view.InventoryFrame;
import view.MenuFrame;
import view.states.States;

public class Main {
    public static void main(String[] args) {
        //MenuFrame.getMenuFrame();
        /*
        //Prova Inventario
        ItemBuilder itemBuilder = new ConcreteItemBuilder();
        ItemDirector itemDirector = new ItemDirector(itemBuilder);

        Inventory i = Inventory.getInventory();
        Item stone = itemDirector.constructStone();
        i.putItem(stone);
        */
        //InventoryFrame.getInventoryFrame();
        FrameDiProva.initGUI();

        States.S4.setVisible(true);
        //States.S6.setVisible(true);

    }
}