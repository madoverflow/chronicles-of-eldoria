package model.items;
import javax.swing.*;

public class ItemBuilder implements Builder {
    private String name;
    private ImageIcon icon;

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setImageIcon(String path){
        this.icon = new ImageIcon(path);
    }

    public Item getResults() {
        return new Item(name, icon);
    }
}
