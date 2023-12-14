package model.player;

public class Eren extends Player{
    private static Eren eren = null;
    private Eren(String name, String imagePath){
        super(name, imagePath);
    }
    public static Eren getInstance(){
        if (eren == null){
            eren = new Eren("Eren","src/model/assets/eren.png");
        }
        return eren;
    }
}

