package model.npc;

public class Lythien extends Npc{
    private static Lythien lythien = null;

    private Lythien(String name, String imagePath){
        super(name, imagePath);
    }

    public static Lythien getInstance(){
        if(lythien==null)
            lythien = new Lythien("Lythien", "src/model/assets/lythien.png");
        return lythien;
    }
}
