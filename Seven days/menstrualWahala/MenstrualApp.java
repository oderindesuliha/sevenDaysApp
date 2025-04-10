import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class MenstrualApp {
    public static void main(String[] args) {
        LocalDate endDate = null;
        LocalDate startDate = null;
        boolean running = true;
        String name= "";
        MenstrualTracker period = null;

        Scanner input = new Scanner(System.in);
        while(running) {
            System.out.println("""
                    Welcome to the Menstrual Tracker App
                        1.Enter the details
                        2.Show the menstruation details
                        3.Exit
                    """);
            System.out.println("Enter Your Choice: ");
            int choice;
            try {
                choice = input.nextInt();
                input.nextLine();
            }catch(InputMismatchException errorMessage) {
                System.out.println("Please enter a valid number.");
                input.nextLine();
                continue;
            }
            String startPeriod = "";
            switch(choice) {
                case 1:

                    System.out.print("Enter your name: ");
                    name = input.nextLine();


                    LocalDate dayOne = null;

                    
                    while (dayOne == null) {
                        System.out.print("Enter starting date (yyyy-MM-dd): ");
                        startPeriod = input.next();
                        try {
                            dayOne = LocalDate.parse(startPeriod);
                        } catch (DateTimeException error) {
                            System.out.println("Irregular start date...... Consult a doctor");
                        }
                    }
                    System.out.print("Enter number of period days: ");
                    int flowDays = input.nextInt();

                    while (flowDays < 3 || flowDays > 9) {
                        System.out.println("Irregular flow days...... Consult a doctor");
                        flowDays = input.nextInt();
                    }
                    System.out.println("Enter your cycle length days: ");
                    int cycleLength = input.nextInt();
                    while (cycleLength < 21 || cycleLength > 35) {
                        System.out.println("Irregular cycle length......Consult a doctor");
                        cycleLength = input.nextInt();
                    }

                    startDate = LocalDate.parse(startPeriod);
                    period = new MenstrualTracker(startDate, cycleLength, flowDays);
                    break;

                case 2:
                    if (period != null) {
                        System.out.printf("%s %s %s%n ", "Hello", name, "!");
                        System.out.printf("The start date for your period is: %s%n", startPeriod);
                        System.out.printf("The end date of your period is: %s%n", period.getEndDate());
                        System.out.printf("Your safe period is between %s to %s%n", period.startSafePeriod(), period.endSafePeriod());
                        System.out.printf("Your Safe Period After Ovulation is between %s to %s%n", period.startSafePeriodAfterOvulation(), period.endSafePeriodAfterOvulation());
                        System.out.println("Your ovulation day is " + period.ovulation());
                        System.out.printf("Your safe period is between %s to %s%n", period.startSafePeriodAfterOvulation(), period.endSafePeriodAfterOvulation());
                        System.out.printf("Your fertility period is from %s to %s%n", period.fertilityWindowStarts(), period.fertilityWindowEnds());
                        System.out.printf("You will be starting your next period on: %s%n", period.latePeriod());
                        System.out.printf("You will be starting your next period on: %s%n", period.nextPeriod());
                        System.out.printf("Your next cycle begins count on: %s%n", period.nextPeriod());
                    } else {
                        System.out.println("Please enter the details first");
                    }
                    break;
                case 3:
                    running = false;
                    System.out.println("Exiting the app, Goodbye!");
                    break;
                default:
                    System.out.println("Please enter a valid choice");

            }






            






        }

    }
}