package model.items;

public interface ItemBuilder {
    void reset();
    void buildName(String name);
    void buildImageIcon(String path);
    Item build();
}
