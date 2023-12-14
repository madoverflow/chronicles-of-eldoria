package model.items;

import javax.swing.*;

public class Item {
    private String name;
    private ImageIcon icon;

    public void setName(String name) {
        this.name = name;
    }
    public void setImageIcon(String path){
        this.icon = new ImageIcon(path);
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
