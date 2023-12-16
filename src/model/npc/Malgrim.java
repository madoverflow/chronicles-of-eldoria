package model.npc;

public class Malgrim extends Npc{
    private static Malgrim malgrim = null;

    private Malgrim(String name, String imagePath){
        super(name, imagePath);
    }

    public static Malgrim getInstance(){
        if(malgrim==null)
            malgrim = new Malgrim("Malgrim", "src/model/assets/malgrim.png");
        return malgrim;
    }
}
