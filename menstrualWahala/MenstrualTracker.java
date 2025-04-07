import java.time.LocalDate;

    public class MenstrualTracker {

        private LocalDate endDate;
        private int cycleLength;
        private int periodLength;

        public  MenstrualTracker(String startDate, String endDate, int cycleLength) {
            this.startDate = startDate;
            this.endDate = endDate;
            this.cycleLength = cycleLength;

        }

        public LocalDate getStartDate() {
            return startDate;
        }

        public LocalDate getEndDate() {
            LocalDate endDate = startDate.plusDays(periodLength - 1);
            return endDate;
        }
    }

