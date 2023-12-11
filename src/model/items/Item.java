package model.items;

import javax.swing.*;

public class Item {
    private final String name;
    private final ImageIcon icon;

    public Item(String name, ImageIcon icon){
        this.name = name;
        this.icon = icon;
    }
    
    public String getName() {
        return this.name;
    }

    public ImageIcon getImageIcon(){
        return this.icon;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Item)) return false;
        Item item = (Item) obj;
        return this.getName().equals(item.getName());
    }

    @Override
    public String toString() {
        return "Name: " + this.getName();
    }

}
