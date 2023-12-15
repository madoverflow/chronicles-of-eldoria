package model.crypt;

public class ConcreteHistory extends Strategy{
    private static ConcreteHistory concreteHistory;

    private ConcreteHistory() {
        super("Come si chiama tuo padre?");
    }

    @Override
    public boolean execute(String response) {
        return response.equals("Grisha") || response.equals("grisha");
    }

    public static ConcreteHistory getInstance(){
        if(ConcreteHistory.concreteHistory == null)
            ConcreteHistory.concreteHistory = new ConcreteHistory();
        return ConcreteHistory.concreteHistory;
    }
}
