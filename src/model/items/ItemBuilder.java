package model.items;

public interface ItemBuilder {
    void buildName(String name);
    void buildImageIcon(String path);
    Item build();
}
