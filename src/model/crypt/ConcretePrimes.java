package model.crypt;

public class ConcretePrimes extends Strategy{

    private static ConcretePrimes concretePrimes;

    private ConcretePrimes() {
        super("Elenca i primi 10 numeri primi.");
    }

    @Override
    public boolean execute(String response) {
        return response.equals("2 3 5 7 11 13 17 19 23 29");
    }

    public static ConcretePrimes getInstance(){
        if(ConcretePrimes.concretePrimes == null)
            ConcretePrimes.concretePrimes = new ConcretePrimes();
        return ConcretePrimes.concretePrimes;
    }
}
