import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class MenstrualApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //MenstrualTracker period = new MenstrualTracker();

        System.out.print("Enter your name: ");
        String name = input.nextLine();

        System.out.print("Enter number of period days: ");
        int lengthOfPeriod = input.nextInt();

        System.out.print("Enter cycle length days: ");
        int cycleLength = input.nextInt();

        System.out.print("Enter starting date: ");
        String startPeriod = input.next();

        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate startDate = LocalDate.parse(startPeriod, format);
        LocalDate endDate = startDate.plusDays(lengthOfPeriod - 1);

        LocalDate nextPeriod = startDate.plusDays(cycleLength);
        LocalDate startOvulationPeriod = nextPeriod.minusDays(14);
        LocalDate endOvulationPeriod = startOvulationPeriod.plusDays(1);
        LocalDate safePeriodStart = endDate.plusDays(1);
        LocalDate safePeriodEnd = endDate.plusDays(6);

        System.out.printf("%s %s %s%n ", "Hello" , name, "!" );
        System.out.printf("The start date for your period is: %s%n", startDate);
        System.out.printf("The end date of your period is: %s%n", endDate);
        System.out.printf("Your safe period is between %s to %s%n", safePeriodStart, safePeriodEnd);
        System.out.printf("Your ovulation period is from %s to %s%n", startOvulationPeriod, endOvulationPeriod);
        System.out.printf("You will be starting your next period on: %s%n", nextPeriod);
        System.out.printf("Your next cycle begins count on: %s%n", nextPeriod);
    }
}
