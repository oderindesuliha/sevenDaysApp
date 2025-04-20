package CreditCard;

import java.util.Scanner;

public class CreditCardMain {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Hello!, Kindly Enter Your Card Number To Verify: ");
        String creditCardNumber = input.nextLine();
        while(!creditCardNumber.matches("^[0-9]+$")) {
            System.out.println("Invalid Card Number");
            creditCardNumber = input.nextLine();
        }


        while(creditCardNumber.length() < 13 || creditCardNumber.length() > 16) {
            System.out.println("Enter valid credit card number between 13 and 16 digits");
            creditCardNumber = input.nextLine();
        }


        int[] number = CreditCardValidator.validateCreditCard(creditCardNumber);
        System.out.println("Credit Card Type: " + CreditCardValidator.creditCardType(number));
        System.out.println("Credit Card Number: " + creditCardNumber);
        System.out.println("Credit Card Digit Length: " + CreditCardValidator.cardDigitLength(number));
        System.out.println("Credit Card Validity Status: " + CreditCardValidator.cardValidation(number));
    }
}
