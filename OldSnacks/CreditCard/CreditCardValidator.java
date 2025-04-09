package CreditCard;

public class CreditCardValidator {

    public static int[] validateCreditCard(String creditCardNumber) {
        int[] numbers = new int[creditCardNumber.length()];
        for (int count = 0; count < creditCardNumber.length(); count++) {
            numbers[count] = Integer.parseInt(creditCardNumber.charAt(count) + "");
        }

        return numbers;
    }

    public static int doubleEvenIndexes(int[] numbers) {
        int sum = 0;
        for(int count = numbers.length - 2; count >= 0; count-=2) {
                int doubleEvenIndex = numbers[count] * 2;
                if(doubleEvenIndex > 9){
                   int doubleEven = (doubleEvenIndex / 10) + (doubleEvenIndex % 10);
                    sum += doubleEven;
                }
                else{
                    sum += doubleEvenIndex;
                }
            }

        return sum;
    }

    public static int oddIndexes(int[] numbers) {
        int sum = 0;
        for(int count = numbers.length - 1; count >= 0; count-=2) {
            sum += numbers[count] ;
        }
        return sum;
    }

    public static int sumIndexes(int[] numbers) {
        return doubleEvenIndexes(numbers) + oddIndexes(numbers);
    }

    public static String cardValidation(int[] numbers) {
        if(sumIndexes(numbers) / 10 == 0) {
            return "Valid";
        }
        else { return "Invalid";}
    }

    public static String creditCardType(int[] numbers) {
        if(numbers[0] == 4)return "Visa Cards";
        else if(numbers[0] == 5)return "MasterCard";
        else if(numbers[0] == 6)return "Discover Cards";
        else if(numbers[0] == 3 && numbers[1] == 7)return "American Express Cards";
        else return "Invalid credit card type";
    }


    public static int cardDigitLength(int[] creditCardNumber) {
        return creditCardNumber.length;
    }
}
