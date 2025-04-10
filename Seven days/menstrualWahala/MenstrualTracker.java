
import java.time.LocalDate;

public class MenstrualTracker {
        private  LocalDate startDate;
        private  int cycleLength;
        private  int flowDays;



        public MenstrualTracker(LocalDate startDate, int cycleLength, int flowDays) {
            this.startDate = startDate;
            this.cycleLength = cycleLength;
            this.flowDays = flowDays;

        }

        public  LocalDate getEndDate() {
            return this.startDate.plusDays(this.flowDays - 1);
        }

        public  LocalDate nextPeriod() {
            return this.startDate.plusDays(this.cycleLength);
        }

        public  LocalDate ovulation() {
            return this.startDate.plusDays(this.cycleLength - 14);
        }

        public LocalDate startSafePeriod() {
            return this.startDate.plusDays(this.flowDays - 1);
        }

        public  LocalDate endSafePeriod() {

            return getEndDate().plusDays(5);
        }

        public  LocalDate fertilityWindowStarts() {
            return ovulation().minusDays(5);
        }

        public  LocalDate fertilityWindowEnds() {
            LocalDate ovulationDay = this.startDate.plusDays(this.cycleLength - 14);

            return ovulationDay.plusDays(1);
        }

        public  String validateCycleLength() {
            if (this.cycleLength < 21 || this.cycleLength > 35){ return "Irregular cycle length......Consult a doctor"; }
            else{ return this.cycleLength + ""; }
        }

        public  String validateFlowDays(int flowDays) {
            if (flowDays < 3 || flowDays > 9) return "Irregular flow days...... Consult a doctor";
            else{ return "flowDays are normal"; }
        }

        public String latePeriod() {
            LocalDate expectedPeriod = this.startDate.plusDays(this.cycleLength);
            if (LocalDate.now().isAfter(expectedPeriod.plusDays(5))) {
                return "Take a pregnancy test or see a doctor";
            } else {
                return expectedPeriod.toString();
            }
        }

        public  LocalDate verifyingOvulationDay() {
            return this.startDate.plusDays(this.cycleLength - 14);
        }

        public  String validateFertilityWindow() {

            return "Your fertility window is from: " + fertilityWindowStarts() + "to" + fertilityWindowEnds();
        }

        public  LocalDate startSafePeriodAfterOvulation() {
            return ovulation().plusDays(2);
        }

        public  LocalDate endSafePeriodAfterOvulation() {
            return this.startDate.plusDays(this.cycleLength - 1);
        }


    }

