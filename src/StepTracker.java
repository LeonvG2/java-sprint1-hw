import java.util.Scanner;

public class StepTracker {
    Scanner scanner;
    MonthData[] monthToData = new MonthData[12];
    Converter converter = new Converter();
    int goalByStepsPerDay = 10000;

    public StepTracker(Scanner scanner) {
        this.scanner = scanner;

        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    public void addNewNumberStepsPerDay() {
        System.out.println("Введите номер месяца");
        // ввод и проверка номера месяца
        int month;
        while (true) {
            System.out.println("Номер месяца (1 - 12):");
            month = scanner.nextInt();
            if (month >= 1 && month <= 12) {
                break;
            } else {
                System.out.println("Ошибка: номер месяца должен быть от 1 до 12");
            }
        }

        System.out.println("Введите день от 1 до 30 (включительно)");
        // ввод и проверка дня
        int day;
        while (true) {
            day = scanner.nextInt();
            if (day >= 1 && day <= 30) {
                break;
            } else {
                System.out.println("Ошибка: день должен быть от 1 до 30.");
            }
        }

        System.out.println("Введите количество шагов");
        // ввод и проверка количества шагов
        int step;
        while (true) {
            step =  scanner.nextInt();
            if (step >= 0 ) {
                break;
            } else {
                System.out.println("Ошибка: количество шагов должно быть положительным.");
            }
        }

        // Получение соответствующего объекта MonthData из массива
        MonthData monthData = monthToData[month - 1];
        // Сохранение полученных данных
        monthData.days[day - 1] = step;
    }

    public void changeStepGoal() {
        System.out.println("Введите новую цель:");
        int newGoalStep;

        while(true) {
            newGoalStep = scanner.nextInt();
            if (newGoalStep >= goalByStepsPerDay) {
                goalByStepsPerDay = newGoalStep;
                break;
            } else if (newGoalStep >= 0 && newGoalStep <= goalByStepsPerDay) {
                System.out.println("Не удалось установить новый рекорд.");
                break;
            } else {
                System.out.println("Вы ввели не правильно число");
            }
        }
    }

    public void printStatistic() {
        System.out.println("Введите число месяца");
        int month;

        while (true) {
            month = scanner.nextInt();
            if (month >= 1 && month <= 12) {
                break;
            } else {
                System.out.println("Введите номер месяца еще раз");
            }
        }

        MonthData monthData = monthToData[month - 1];
        int sumSteps = monthData.sumStepsFromMonth();

        monthData.printDaysAndStepsFromMonth();
        System.out.println("Сумма шагов за месяц: " + sumSteps);
        System.out.println("Максимальное количество шагов за день: " + monthData.maxSteps());

        if (sumSteps > 0) {
            System.out.println("Среднее количество шагов за день: " + (sumSteps / 30));
        }

        System.out.println("Пройденная дистанция (в км): " + converter.convertToKM(sumSteps));
        System.out.println("Сожжённые килокалории: " + converter.convertStepsToKilocalories(sumSteps));
        System.out.println("Лучшая серия: " + monthData.bestSeries(goalByStepsPerDay));
        System.out.println();
    }
}
