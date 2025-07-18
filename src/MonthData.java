public class MonthData {
    int[] days = new int[30];

    public void printDaysAndStepsFromMonth() {
        for (int i = 0; i < days.length; i++) {
            if (days[i] > 0) {
                System.out.println((i + 1) + " день: " + (days[i]));
            }
        }
    }

    public int sumStepsFromMonth() {
        int sumSteps = 0;
        for (int i = 0; i < days.length; i++) {
            sumSteps += days[i];
        }
        return sumSteps;
    }

    public int maxSteps() {
        int maxSteps = 0;
        for (int i = 0; i < days.length; i++) {
            if (days[i] > maxSteps) {
                maxSteps = days[i];
            }
        }
        return maxSteps;
    }

    public int bestSeries(int goalByStepsPerDay) {
        int currentSeries = 0;
        int finalSeries = 0;

        for (int i = 0; i < days.length; i++) {
            // поиск максимальной серии
            if (days[i] > goalByStepsPerDay) {
                currentSeries ++;
                if (currentSeries > finalSeries) {
                    finalSeries = currentSeries;
                }
            } else {
                currentSeries = 0;
            }
        }

        return finalSeries;
    }
}
