package model.npc;

public abstract class Npc {
    private final String name;
    private final String imagePath;

    public Npc(String name, String imagePath){
        this.name = name;
        this.imagePath = imagePath;
    }

    public final String getName() {
        return this.name;
    }

    public final String getImagePath() {
        return this.imagePath;
    }
}
