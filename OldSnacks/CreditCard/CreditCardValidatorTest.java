import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class CreditCardValidatorTest {

    @Test
    public void testThatCreditCardNumberIsString() {
        String creditCardNumber = "1234567171856782";
        int[] result = new int[]{1,2,3,4,5,6,7,1,7,1,8,5,6,7,8,2};
        assertArrayEquals(result, CreditCardValidator.validateCreditCard(creditCardNumber));
    }

    @Test
    public void testThatCreditCardNumberAddsDoublesOfEvenIndexesFromRightToLeft() {
        int[] creditCardNumber = {3,1,3,6,3,1,3,1,3,8,3,1,3};
        int result = 18;
        assertEquals(result, CreditCardValidator.doubleEvenIndexes(creditCardNumber));
    }

    @Test
    public void testThatCreditCardNumberAddsDigitsInOddIndexes() {
        int[] creditCardNumber = {3,1,3,6,3,1,3,1,3,8,3,1,3};
        int result = 21;
        assertEquals(result, CreditCardValidator.oddIndexes(creditCardNumber));
    }

    @Test
    public void testThatCreditCardNumberSumsTheDoubleOfEvenIndexesAndOddIndexes() {
        int[] creditCardNumber = {3,1,3,6,3,1,3,1,3,8,3,1,3};
        int total = 39;
        assertEquals(total, CreditCardValidator.sumIndexes(creditCardNumber));
    }

    @Test
    public void testThatCreditCardNumberSumsValidatesIt() {
        int[] creditCardNumber = {3,1,3,6,3,1,3,1,3,8,3,1};
        String result = "Invalid";
        assertEquals(result, CreditCardValidator.cardValidation(creditCardNumber));
    }

    @Test
    public void testThatTheStartNumberValidatesCreditCardType() {
        int[] creditCardNumber = {3,1,3,6,3,1,3,1,3,8,3,1};
        String result = "Invalid credit card type";
        assertEquals(result, CreditCardValidator.creditCardType(creditCardNumber));
    }

    @Test
    public void testForCreditCardDigitLength() {
        int[] creditCardNumber = {3,1,3,6,3,1,3,1,3,8,3,1,2};
        int result = 13;
        assertEquals(result, CreditCardValidator.cardDigitLength(creditCardNumber));
    }

}

