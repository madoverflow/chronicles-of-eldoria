package model.inventory;
import model.items.Item;
import java.util.List;
import java.util.ArrayList;

public class Inventory {
    private static Inventory inventory = null;
    private final List<Item> items = new ArrayList<Item>();
    private Inventory() { }

    public static Inventory getInventory() {
        if (inventory == null) {
            inventory = new Inventory();
        }
        return inventory;
    }

    public void putItem(Item item) {
        this.items.add(item);
    }

    public List<Item> getItems() {
        return this.items;
    }

    public boolean useItem(Item item) {
        if (this.items.contains(item)) {
            this.items.remove(item);
            return true;
        }
        return false;
    }
}
