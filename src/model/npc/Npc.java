package model.npc;

import model.items.Item;

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
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Npc)) return false;
        Npc npc = (Npc) obj;
        return this.getName().equals(npc.getName());
    }
}
