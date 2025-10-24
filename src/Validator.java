import java.util.Scanner;

/**
 * Класс для валидации пользовательского ввода.
 */
public class Validator {
    /**
     * Запрашивает у пользователя цифру от 0 до 6 с валидацией.
     *
     * @param sc      сканер
     * @param message сообщение для пользователя
     * @return цифра от 0 до 6
     */
    public static int getMenuChoice(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            String input = sc.nextLine().trim();

            if (input.matches("\\d+")) {
                int choice = Integer.parseInt(input);
                if (choice >= 0 && choice <= 6) {
                    return choice;
                }
            }

            System.out.println("Ошибка! Пожалуйста, введите цифру от 0 до 6.");
        }
    }

    /**
     * Запрашивает у пользователя площадь озера (положительное число).
     *
     * @param sc      сканер
     * @param message сообщение для пользователя
     * @return положительное число
     */
    public static int getPositiveInt(Scanner sc, String message) {
        while (true) {
            int value = getInt(sc, message);
            if (value > 0) {
                return value;
            }
            System.out.println("Ошибка! Значение должно быть положительным.");
        }
    }

    /**
     * Запрашивает у пользователя соленость воды в процентах [0; 100].
     *
     * @param sc      сканер
     * @param message сообщение для пользователя
     * @return соленость в процентах
     */
    public static double getSalinity(Scanner sc, String message) {
        while (true) {
            double value = getDouble(sc, message);
            if (value >= 0 && value <= 100) {
                return value;
            }
            System.out.println("Ошибка! Соленость должна быть в диапазоне от 0 до 100%.");
        }
    }

    /**
     * Запрашивает у пользователя неотрицательное вещественное число.
     *
     * @param sc      сканер
     * @param message сообщение для пользователя
     * @return неотрицательное число
     */
    public static double getNonNegativeDouble(Scanner sc, String message) {
        while (true) {
            double value = getDouble(sc, message);
            if (value >= 0) {
                return value;
            }
            System.out.println("Ошибка! Значение не может быть отрицательным.");
        }
    }

    /**
     * Запрашивает у пользователя строку с валидацией.
     *
     * @param sc      сканер
     * @param message сообщение для пользователя
     * @return строка
     */
    public static String getString(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            String input = sc.nextLine().trim();
            if (!input.isEmpty() && !isNumeric(input)) {
                return input;
            }
            System.out.println("Неправильный формат ввода. Введите строку.");
        }
    }

    /**
     * Запрашивает у пользователя целое число.
     *
     * @param sc      сканер
     * @param message сообщение для пользователя
     * @return целое число
     */
    public static int getInt(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            String input = sc.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Неправильный формат ввода. Введите целое число.");
            }
        }
    }

    /**
     * Запрашивает у пользователя вещественное число.
     *
     * @param sc      сканер
     * @param message сообщение для пользователя
     * @return вещественное число
     */
    public static double getDouble(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            String input = sc.nextLine().trim();
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Неправильный формат ввода. Введите число с точкой.");
            }
        }
    }

    /**
     * Запрашивает у пользователя булево значение (true/false).
     *
     * @param sc      сканер
     * @param message сообщение для пользователя
     * @return булево значение
     */
    public static boolean getBoolean(Scanner sc, String message) {
        while (true) {
            System.out.print(message + " (да/нет): ");
            String input = sc.nextLine().trim().toLowerCase();
            if (input.equals("да") || input.equals("д") || input.equals("yes") || input.equals("y")) {
                return true;
            }
            else if (input.equals("нет") || input.equals("н") || input.equals("no") || input.equals("n")) {
                return false;
            }
            System.out.println("Неправильный формат ввода. Введите 'да' или 'нет'.");
        }
    }

    /**
     * Проверяет, является ли строка числом.
     *
     * @param str строка
     * @return true, если строка - число
     */
    private static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }
}