package model.items;
import javax.swing.*;

public class ConcreteItemBuilder implements ItemBuilder {
    private Item item;
    public ConcreteItemBuilder(){this.reset();}
    public void reset(){
        this.item = new Item();
    }

    @Override
    public void buildName(String name) {
        item.setName(name);
    }

    @Override
    public void buildImageIcon(String path){
        item.setImageIcon(path);
    }
    @Override
    public Item build() {
        Item tmpItem = this.item;
        this.reset();
        return tmpItem;
    }
}
