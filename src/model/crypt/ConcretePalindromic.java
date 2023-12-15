package model.crypt;

import java.util.Arrays;

public class ConcretePalindromic extends Strategy{

    private static ConcretePalindromic concretePalindromic;

    private ConcretePalindromic() {
        super("Otto usa dei particolari radar per calcolare gli ingegni delle persone.");
    }

    @Override
    public boolean execute(String response) {
        long responseNumber,palindromicWordsNumber;
        try{
            responseNumber = Integer.parseInt(response);
        }
        catch (NumberFormatException ex){
            responseNumber = 0;
        }
        if(this.getEnigma().isEmpty())
            palindromicWordsNumber = 0;
        else
            palindromicWordsNumber =
                    Arrays.stream(ConcretePalindromic.concretePalindromic.getEnigma().split(" "))
                            .map(word -> new StringBuilder(word.toLowerCase()))
                            .filter(word -> word.toString().contentEquals(word.reverse()))
                            .count();
        return responseNumber==palindromicWordsNumber;
    }

    public static ConcretePalindromic getInstance(){
        if(ConcretePalindromic.concretePalindromic == null)
            ConcretePalindromic.concretePalindromic = new ConcretePalindromic();
        return ConcretePalindromic.concretePalindromic;
    }
}
