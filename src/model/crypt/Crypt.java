package model.crypt;

public class Crypt {
    private Strategy strategy;
    private boolean flag;
    private String message;
    private static Crypt crypt;

    private Crypt() {
        this.flag = false;
        this.message = "";
    }

    private final boolean isOpen(){return this.flag;};

    public void setStrategy(Strategy strategy){
        this.strategy = strategy;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public boolean open(String text){
        if(this.isOpen())
            return true;
        if(this.strategy == null)
            throw new RuntimeException("Prima di aprire la cripta devi scegliere la strategia (setta strategy).");
        return this.strategy.execute(text);
    }

    public static Crypt getInstance(){
        if(Crypt.crypt == null)
            Crypt.crypt = new Crypt();
        return Crypt.crypt;
    }
}
