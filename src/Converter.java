public class Converter {
    int step = 75;               // длина шага в сантиметрах
    int caloriesPerStep = 50;    // калорий на шаг (не килокалорий!)
    int kiloCal = 1000;          // калорий в килокалории

    public int convertToKM(int steps) {
        return (steps * step) / 100000;
    }

    int convertStepsToKilocalories(int steps) {
        return (steps * caloriesPerStep) / kiloCal;
    }
}
