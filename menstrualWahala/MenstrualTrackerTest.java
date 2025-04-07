import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MenstrualTrackerTest {

        @Test
        public void testToCalculateNextStartDate() {
            MenstrualTracker period = new MenstrualTracker();
            LocalDate startDate = LocalDate.parse("2020-01-01");
            int cycleLength = 28;
            LocalDate nextStartDate = period.getStartDate();
            assertEquals(startDate, nextStartDate);
        }

        @Test
        public void testToCalculateEndDate() {
            MenstrualTracker period = new MenstrualTracker();
            LocalDate startDate = LocalDate.parse("2020-01-01");
            int cycleLength = 28;
            LocalDate endDate = period.getEndDate();
            assertEquals(endDate, startDate);
//            LocalDate nextEndDate = endDate.plusDays(cycleLength);
//            LocalDate startOvulationPeriod = nextEndDate.minusDays(14);
//            LocalDate endOvulationPeriod = startOvulationPeriod.plusDays(1);
//            LocalDate safePeriodStart = endDate.plusDays(1);
//            LocalDate safePeriodEnd = endOvulationPeriod.plusDays(1);
//            LocalDate menstrualStart = period.getStartDate();



        }
    }



