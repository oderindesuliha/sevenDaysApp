
import java.time.LocalDate;

    public class MenstrualTracker {
        private LocalDate startDate;
        private int cycleLength;
        private int periodLength;



        public MenstrualTracker(LocalDate startDate, int cycleLength, int periodLength) {
            this.startDate = startDate;
            this.cycleLength = cycleLength;
            this.periodLength = periodLength;

        }

        public LocalDate getEndDate() {

            return startDate.plusDays(
                    periodLength - 1);
        }

        public LocalDate nextPeriod() {

            return startDate.plusDays(cycleLength);
        }

        public LocalDate ovulation() {
            return startDate.plusDays(cycleLength - 14);
        }

        public LocalDate startSafePeriod() {
            return getEndDate().plusDays(1);
        }

        public LocalDate endSafePeriod() {
            return getEndDate().plusDays(6);
        }

        public LocalDate fertilityWindowStarts() {
            return ovulation().minusDays(3);
        }

        public LocalDate fertilityWindowEnds() {
            return ovulation().plusDays(1);
        }

        public String validateCycleLength() {
            if (cycleLength < 21 || cycleLength > 35){ return "Irregular cycle length......Consult a doctor"; }
            else{ return cycleLength + ""; }
        }

        public String validateFlowDays() {
            if (periodLength < 3 || periodLength > 9) return "Irregular flow days...... Consult a doctor";
            else{ return periodLength + ""; }
        }

        public String latePeriod() {
            LocalDate expectedPeriod = startDate.plusDays(cycleLength);
            if (LocalDate.now().isAfter(expectedPeriod.plusDays(5))) {
                return "Take a pregnancy test or see a doctor";
            } else {
                return expectedPeriod.toString();
            }
        }

        public LocalDate verifyingOvulationDay() {
            return startDate.plusDays(cycleLength - 14);
        }

        public String validateFertilityWindow() {

            return "Your fertility window is from: " + fertilityWindowStarts() + "to" + fertilityWindowEnds();
        }

        public LocalDate startSafePeriodAfterOvulation() {
            return ovulation().plusDays(2);
        }

        public LocalDate endSafePeriodAfterOvulation() {
            return startDate.plusDays(cycleLength-1);
        }
    }

