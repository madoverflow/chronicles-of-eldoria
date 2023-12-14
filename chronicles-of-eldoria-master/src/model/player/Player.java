package model.player;

import model.inventory.Inventory;
import model.items.Item;
import model.npc.Npc;

import java.util.ArrayList;
import java.util.List;

public abstract class Player {
    private final String name;
    private final String imagePath;
    private final Inventory inventory = Inventory.getInventory();
    private final List<Npc> npcList = new ArrayList<Npc>();

    public Player(String name, String imagePath){
        this.name = name;
        this.imagePath = imagePath;
    }

    public final void getItem(Item item){
        inventory.putItem(item);
    }

    public final boolean useItem(Item item){
        return inventory.useItem(item);
    }

    public final void npcFollow(Npc npc){
        npcList.add(npc);
    }

    public final String getName(){
        return this.name;
    }
    public final String getImagePath(){
        return this.imagePath;
    }
    public final Inventory getInventory(){
        return this.inventory;
    }
    public final List<Npc> getNpcList(){ return this.npcList; }

}
