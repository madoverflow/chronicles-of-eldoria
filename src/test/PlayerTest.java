package test;

import model.crypt.ConcretePalindromic;
import model.inventory.Inventory;
import model.items.ConcreteItemBuilder;
import model.items.Item;
import model.items.ItemBuilder;
import model.items.ItemDirector;
import model.player.Eren;
import model.player.Player;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    Inventory inventory;
    ItemDirector itemDirector;
    Item item;
    Player eren;
    @BeforeEach
    void setUp() {
        inventory = Inventory.getInventory();
        itemDirector = new ItemDirector(new ConcreteItemBuilder());
        item = itemDirector.constructStone();
        eren = Eren.getInstance();
        eren.getItem(item); //Put the item in to the Inventory
        assertNotNull(inventory, "Non è stato possibile istanziare un oggetto di tipo Inventory");
        assertNotNull(itemDirector, "Non è stato possibile istanziare un oggetto di tipo ItemDirector");
        assertNotNull(item, "Non è stato possibile istanziare un oggetto di tipo Item");
        assertNotNull(eren, "Non è stato possibile istanziare un oggetto di tipo Player");
    }

    @AfterEach
    void tearDown() {
        inventory = null;
        itemDirector = null;
        item = null;
        eren = null;
    }

    @Test
    void useItem() {
        assertTrue(eren.useItem(item));
    }
}