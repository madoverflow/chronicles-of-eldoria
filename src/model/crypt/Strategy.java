package model.crypt;

public abstract class Strategy {
    private final String enigma;

    public Strategy(String enigma){
        this.enigma = enigma;
    }

    public final String getEnigma() {
        return enigma;
    }

    public abstract boolean execute(String response);
}
