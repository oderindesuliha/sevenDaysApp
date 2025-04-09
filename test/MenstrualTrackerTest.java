import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;


public class MenstrualTrackerTest {

    @Test
    public void testToCalculateNextStartDate() {
        MenstrualTracker period = new MenstrualTracker(LocalDate.of(2020, 1, 1), 28, 5);
        assertEquals(LocalDate.of(2020, 1, 29), period.nextPeriod());
    }

    @Test
    public void testToCalculateEndDate() {
        MenstrualTracker period = new MenstrualTracker(LocalDate.of(2025, 2, 1), 29, 6);
        assertEquals(LocalDate.of(2025, 2, 6), period.getEndDate());
    }

    @Test
    public void testToCalculateStartOfOvulation() {
        MenstrualTracker period = new MenstrualTracker(LocalDate.of(2025, 2, 1), 29, 6);
        assertEquals(LocalDate.of(2025, 2, 16), period.ovulation());

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
    public void testToCalculateStartOfFertility() {
        MenstrualTracker period = new MenstrualTracker(LocalDate.of(2025, 2, 1), 29, 6);
        assertEquals(LocalDate.of(2025, 2, 13), period.fertilityWindowStarts());
    }

    @Test
    public void testToCalculateEndOfFertility() {
        MenstrualTracker period = new MenstrualTracker(LocalDate.of(2025, 2, 1), 29, 6);
        assertEquals(LocalDate.of(2025, 2, 17), period.fertilityWindowEnds());
    }

    @Test
    public void testToValidateCycleLength() {
        MenstrualTracker period = new MenstrualTracker(LocalDate.of(2025, 2, 1), 20, 6);
        assertEquals("Irregular cycle length......Consult a doctor", period.validateCycleLength());

    }

    @Test
    public void testToValidateFlowDaysLength() {
        MenstrualTracker period = new MenstrualTracker(LocalDate.of(2025, 2, 1), 20, 11);
        assertEquals("Irregular flow days...... Consult a doctor", period.validateFlowDays());
    }

    @Test
    public void testForLatePeriod() {
        MenstrualTracker period = new MenstrualTracker(LocalDate.of(2025, 2, 1), 33, 6);
        assertEquals("Take a pregnancy test or see a doctor", period.latePeriod());
    }

    @Test
    public void testOvulationDate() {
        MenstrualTracker period = new MenstrualTracker(LocalDate.of(2025, 2, 1), 29, 6);
        assertEquals(LocalDate.of(2025, 2, 16), period.verifyingOvulationDay());
    }

    @Test
    public void testValidateFertilityWindow() {
        MenstrualTracker period = new MenstrualTracker(LocalDate.of(2025, 2, 1), 29, 6);
        assertEquals("Your fertility window is from: " + period.fertilityWindowStarts() + "to" + period.fertilityWindowEnds(), period.validateFertilityWindow());
    }

    @Test
    public void testForStartOfSafePeriodAfterOvulation() {
        MenstrualTracker period = new MenstrualTracker(LocalDate.of(2025, 2, 1), 29, 6);
        assertEquals(LocalDate.of(2025, 2, 18), period.startSafePeriodAfterOvulation());
    }

    @Test
    public void testForEndOfSafePeriodAfterOvulation() {
        MenstrualTracker period = new MenstrualTracker(LocalDate.of(2025, 2, 1), 29, 6);
        assertEquals(LocalDate.of(2025, 3, 1), period.endSafePeriodAfterOvulation());
    }
}






