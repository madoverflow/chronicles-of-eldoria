package model.npc;

public class Cedric extends Npc{
    private static Cedric cedric = null;
    
    private Cedric(String name, String imagePath){
        super(name, imagePath);
    }
    
    public static Cedric getInstance(){
        if(cedric==null)
            cedric = new Cedric("Cedric", "src/model/assets/cedric.png");
        return cedric;
    }
}
