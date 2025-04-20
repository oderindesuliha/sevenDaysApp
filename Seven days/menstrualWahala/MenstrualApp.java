import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class MenstrualApp {
    public static void main(String[] args) {
        LocalDate endDate = null;
        LocalDate startDate = null;
        boolean isTrue = true;
        String name = "";
        MenstrualTracker period = null;

        Scanner input = new Scanner(System.in);
        while(isTrue) {
            System.out.println("""
                    \nWelcome to the Menstrual Tracker App
                        1.Enter the details
                        2.Show the menstruation details
                        3.Exit
                    """);
            int choice = 0;
            while(isTrue) {
                try {
                    System.out.println("Enter Your Choice: ");
                    String option = input.nextLine();
                    if (option.isEmpty()) {
                        System.out.println("Enter a number between 1 and 3: ");
                        continue;
                    }
                    choice = Integer.parseInt(option);
                    break;
                } catch (InputMismatchException errorMessage) {
                    System.out.println("Please enter a valid number.");
                    input.nextLine();
                    continue;
                }
            }
                String startPeriod = "";
                switch (choice) {
                    case 1:
                        System.out.println("Enter your name: ");
                        name = input.nextLine();
                        if (name.equals("")) {
                            System.out.println("Name can't be empty.......Enter a valid name.");
                            name = input.nextLine();
                        } else if (!name.matches("[a-zA-Z]+")) {
                            System.out.println("Please enter a valid name.");
                            name = input.nextLine();
                        }
                        
                        LocalDate dayOne = null;
                        while (dayOne == null) {
                            System.out.println("Enter starting date (yyyy-MM-dd): ");
                            startPeriod = input.nextLine();
                            try {
                                dayOne = LocalDate.parse(startPeriod);
                            } catch (DateTimeException error) {
                                System.out.println("Enter start date in this format: (yyyy-MM-dd)");
                            }
                        }
                        int flowDays = 0;
                        while(isTrue) {
                            try {
                                System.out.println("Enter number of flow days");
                                String periodDays = input.nextLine();
                                if (periodDays.isEmpty()) {
                                    System.out.println("Flow days can't be empty.......Enter valid flow days");
                                    continue;
                                }
                                flowDays = Integer.parseInt(periodDays);
                                if(flowDays < 3 || flowDays > 9) {
                                    System.out.println("Please enter a number between 3 to 9: ");
                                    continue;
                                }
                                break;
                            }catch(InputMismatchException exception) {
                                    System.out.println("Please enter valid flow days");
                                    input.nextLine();
                            }
                        }
                        int cycleLength = 0;
                        while(isTrue){
                            try {
                                System.out.println("Enter your cycle length days: ");
                                String cycle = input.nextLine();
                                if (cycle.isEmpty()) {
                                    System.out.println("Cycle length can't be empty.......Enter valid cycle length");
                                    continue;
                                }
                                cycleLength = Integer.parseInt(cycle);
                                if (cycleLength < 21 || cycleLength > 35) {
                                    System.out.println("Please enter valid cycle length");
                                    continue;
                                }
                                break;
                            }catch(InputMismatchException exception) {
                            System.out.println("Please enter valid cycle length");
                            input.nextLine();
                            }
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
                        isTrue = false;
                        System.out.println("Exiting the app, Goodbye!");
                        break;
                    default:
                        System.out.println("Please enter a valid choice");


                }
            }
    }
}