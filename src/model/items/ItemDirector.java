package model.items;

public class ItemDirector {
    public void constructStone(Builder builder) {
        builder.setName("Stone");
        builder.setImageIcon("images/stone.png");
    }

    public void constructBoard(Builder builder) {
        builder.setName("Board");
        builder.setImageIcon("images/wood.png");
    }

    public void constructLight(Builder builder) {
        builder.setName("Light");
        builder.setImageIcon("images/torch.png");
    }
}
