public class Converter {
    final int STEP_LENGTH_CM = 75;
    final int CALORIES_PER_STEP = 50;
    final int KCAL_DIVISOR = 1000;        // калорий в килокалории

    public int convertToKM(int steps) {
        return (steps * STEP_LENGTH_CM) / 100000;
    }

    int convertStepsToKilocalories(int steps) {
        return (steps * CALORIES_PER_STEP) / KCAL_DIVISOR;
    }
}
