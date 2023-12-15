package test;

import model.crypt.ConcretePalindromic;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class ConcretePalindromicTest {

    @BeforeEach
    void setUp() {
        ConcretePalindromic concretePalindromic = ConcretePalindromic.getInstance();
        assertNotNull(concretePalindromic, "Non è stato possibile istanziare un oggetto di tipo " +
                "ConcretePalindromic");
    }

    @org.junit.jupiter.api.Test
    void execute() {
        String palindromicWordsNumber = "3";
        assertTrue(ConcretePalindromic.getInstance().execute(palindromicWordsNumber));
    }
}