import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class MenstrualTrackerTest {

    @Test
    public void testToCalculateNextStartDate() {
        MenstrualTracker period = new MenstrualTracker(LocalDate.of(2020, 1, 1), 28, 5);
        assertEquals(LocalDate.of(2020, 1, 29), period.nextStartDate());
    }

    @Test
    public void testToCalculateEndDate() {
        MenstrualTracker period = new MenstrualTracker(LocalDate.of(2025, 2, 1), 29, 6);
        assertEquals(LocalDate.of(2025, 2, 6), period.getEndDate());
    }

    @Test
    public void testToCalculateStartOfOvulation() {
        MenstrualTracker period = new MenstrualTracker(LocalDate.of(2025, 2, 1), 29, 6);
        assertEquals(LocalDate.of(2025, 2, 16), period.startOvulation());

    }

    @Test
    public void testToCalculateEndOfOvulation() {
        MenstrualTracker period = new MenstrualTracker(LocalDate.of(2025, 2, 1), 29, 6);
        assertEquals(LocalDate.of(2025, 2, 17), period.endOvulation());
    }

    @Test
    public void testToCalculateWhenSafePeriodStart() {
        MenstrualTracker period = new MenstrualTracker(LocalDate.of(2025, 2, 1), 29, 6);
        assertEquals(LocalDate.of(2025, 2, 7), period.startSafePeriod());
    }

    @Test
    public void testToCalculateWhenSafePeriodEnds() {
        MenstrualTracker period = new MenstrualTracker(LocalDate.of(2025, 2, 1), 29, 6);
        assertEquals(LocalDate.of(2025, 2, 12), period.endSafePeriod());
    }

    @Test
    public void testToCalculateFertileWindow() {
        MenstrualTracker period = new MenstrualTracker(LocalDate.of(2025, 2, 1), 29, 6);
        assertEquals(LocalDate.of(2025,2,11), period.fertilityWindowStarts());
    }



}



