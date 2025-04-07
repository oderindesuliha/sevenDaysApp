import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.ArrayList;


public class CheckOutApp {

    public static void main(String[] args) {

	Scanner input = new Scanner(System.in);
	LocalDateTime dateTime = LocalDateTime.now();
	DateTimeFormatter date = DateTimeFormatter.ofPattern("dd-mm-yyyy hh:mm:ss");
	String dateTimer = dateTime.format(date);

	ArrayList<String> items = new ArrayList<>();
	ArrayList<Integer> piecesList = new ArrayList<>();

	ArrayList<Double> unitPriceList = new ArrayList<>();

	double total = 0;
	double discountAmount;
	double bill = 0;
	double vat = 0;
	String choice;
	String name = "";
	int pieces = 0;
	double unitPrice = 0;
	String item = "";

	
	 	
		
        	System.out.print("Enter Customer's Name: ");
        	name = input.nextLine();
		
	do {
		System.out.print("What did the Customer buy? ");
        		items.add(input.nextLine());
	
		System.out.println("How many pieces? ");
           		 piecesList.add(input.nextInt());

	   	 System.out.println("How much per unit? ");
        	 unitPriceList.add(input.nextDouble());
       
	       
			input.nextLine();
		
        System.out.println("Add more item ?(yes or no): ");
        	choice = input.nextLine();	

	if(choice.equalsIgnoreCase("no") || choice.equalsIgnoreCase("yes")){
	  continue;
	
	}else{
		 System.out.println("invalid.....Input yes or no");
	}
	 
	}while(!choice.equalsIgnoreCase("no"));
	
	
	
        System.out.println(" ");
	System.out.println("Cashier's name: ");
	String cashier = input.nextLine(); 


        System.out.println("How much discount percentage will he get(%)? ");
        double discount = input.nextDouble();

	for(int count = 0;count <= unitPriceList.size() - 1;count++){
		total += piecesList.get(count) * unitPriceList.get(count);
}

		
	System.out.println("===============================================================");
        System.out.printf("""
	SEMICOLON STORES\s
	MAIN BRANCH
	LOCATION: 312 HERBERT MACAULAY WAY, SABO YABA, LAGOS.
	TEL: 08139338208
	DATE: %s
	CASHIER'S NAME: %s
	CUSTOMER'S NAME: %s
	===============================================================%n""", dateTimer, cashier, name);
        System.out.println("	ITEM		QTY		PRICE		TOTAL(NGN)");
        System.out.println("----------------------------------------------------------------");
	
       
        discountAmount = (discount / 100) * total;
        vat = (17.50 / 100) * (total - discountAmount);
        bill = total - discountAmount + vat;
	
	System.out.println("---------------------------------------------------------------");
	for(String newItem : items){
        System.out.printf("""
                          \t				Total:		%.2f
                          \t				Discount:	%.2f
                          \t				VAT@17.50:	%.2f
                   =====================================================================
                                             		Bill Total:	%.2f
                   =====================================================================
                     THIS IS NOT A RECEIPT..............KINDLY PAY		%.2f                                                  
                   =====================================================================""",total, discountAmount, vat, bill, bill);
		break;
	

	}
	
	System.out.println(" ");
        System.out.println("\nHow much did the customer give you? ");
	double amountPaid = input.nextDouble(); 

	while (amountPaid < bill){
 	System.out.println("amount paid cannot be lesser than total bill");
	System.out.println("How much did customer give you?");
	amountPaid = input.nextDouble();
} 

	
	System.out.println(" ");
        
	System.out.println("===============================================================");
	System.out.printf("""
	SEMICOLON STORES\s
	MAIN BRANCH
	LOCATION: 312 HERBERT MACAULAY WAY, SABO YABA, LAGOS.
	TEL: 08139338208
	DATE: %s
	CASHIER'S NAME: %s
	CUSTOMER'S NAME: %s
	==============================================================================%n""", dateTimer, cashier, name);
	System.out.println("	ITEM		QTY		PRICE		TOTAL(NGN)");
        System.out.println("----------------------------------------------------------------------");
       

 
        double balance = amountPaid - bill;
                                                                            
        System.out.println("----------------------------------------------------------------------");
        System.out.printf("""
                          \t			Total:			%.2f
                          \t                   Discount:		%.2f
                          \t                   VAT@17.50:		%.2f
         =============================================================================
                                              Bill Total:		%.2f
                                             Amount Paid:		%.2f
                                                 Balance:		%.2f
         =============================================================================
                                    THANK YOU FOR YOUR PATRONAGE!!!
         =============================================================================""", total, discountAmount, vat, bill, amountPaid, balance);
        

   
	
}
}
