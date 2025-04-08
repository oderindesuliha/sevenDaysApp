import java.time.LocalDate;

    public class MenstrualTracker {
        private LocalDate startDate;
        private int cycleLength;
        int periodLength;
        private LocalDate startOvulationPeriod;

        public MenstrualTracker(LocalDate startDate, int cycleLength, int periodLength) {
            this.startDate = startDate;
            this.cycleLength = cycleLength;
            this.periodLength = periodLength;
        }

        public LocalDate getStartDate() {
            return startDate;
        }

        public LocalDate getEndDate() {
            return startDate.plusDays(periodLength - 1);
        }

        public int getPeriodLength(int i) {
            if (periodLength >= 3 && periodLength <= 9) return periodLength;
            else throw new IllegalArgumentException("PeriodLength should be between 3-9days");
        }

        public LocalDate nextStartDate() {
            return startDate.plusDays(cycleLength);
        }

        public LocalDate startOvulation() {
            return startOvulationPeriod = nextStartDate().minusDays(14);
        }

        public LocalDate endOvulation() {
            return startOvulation().plusDays(1);
        }

        public LocalDate startSafePeriod() {
            return getEndDate().plusDays(1);
        }

        public LocalDate endSafePeriod() {
            return getEndDate().plusDays(6);
        }

        public LocalDate fertilityWindowStarts() {
            return startOvulation().minusDays(3);
        }

    }

