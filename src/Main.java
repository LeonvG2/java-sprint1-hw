import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(scanner);

        while (true) {
            printMenu();
            int i = scanner.nextInt();

            if (i == 1) {
                stepTracker.addNewNumberStepsPerDay();
            } else if (i == 2) {
                stepTracker.changeStepGoal();
            } else if (i == 3) {
                stepTracker.printStatistic();
            } else if (i == 4) {
                System.out.println("Пока!");
                scanner.close();
                return;
            } else {
                System.out.println("Неверное значение, попробуйте еще раз.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("Добро пожаловать в приложение Calorie Counter X.\n" +
                "Выберите один из следующих вариантов работы с приложением: \n" +
                "1. ввести количество шагов за определённый день; \n" +
                "2. изменить цель по количеству шагов в день; \n" +
                "3. напечатать статистику за определённый месяц; \n" +
                "4. выйти из приложения.");
    }
}
