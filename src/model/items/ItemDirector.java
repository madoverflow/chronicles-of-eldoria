package model.items;

import java.nio.file.FileSystems;

public class ItemDirector {
    private ItemBuilder itemBuilder;
    public ItemDirector(ItemBuilder itemBuilder){this.itemBuilder = itemBuilder;}
    public void changeBuilder(ItemBuilder itemBuilder){this.itemBuilder = itemBuilder;}
    public Item constructStone() {
        itemBuilder.buildName("Stone");
        itemBuilder.buildImageIcon(FileSystems.getDefault().getPath("src/model/assets/stone.png").toString());
        return itemBuilder.build();
    }

    public Item constructBoard() {
        itemBuilder.buildName("Board");
        itemBuilder.buildImageIcon(FileSystems.getDefault().getPath("src/model/assets/wood.png").toString());
        return itemBuilder.build();
    }

    public Item constructTorch() {
        itemBuilder.buildName("Torch");
        itemBuilder.buildImageIcon(FileSystems.getDefault().getPath("src/model/assets/torch.png").toString());
        return itemBuilder.build();
    }
}
