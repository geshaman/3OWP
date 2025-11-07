/**
 * Класс для валидации пользовательского ввода.
 * Содержит методы проверки корректности введённых данных.
 */
public class Validator {

    /**
     * Проверяет, является ли строка валидным выбором пункта меню (0-6).
     *
     * @param input введённая пользователем строка
     * @return true если строка является цифрой от 0 до 6, иначе false
     */
    public static boolean isValidMenuChoice(String input) {
        return input.matches("[0-6]");
    }

    /**
     * Проверяет, является ли строка положительным целым числом.
     *
     * @param input введённая пользователем строка
     * @return true если строка содержит только цифры (без знака), иначе false
     */
    public static boolean isValidPositiveInt(String input) {
        return input.matches("\\d+");
    }

    /**
     * Проверяет, является ли строка валидным значением солёности воды (0-100%).
     *
     * @param input введённая пользователем строка
     * @return true если строка представляет число от 0 до 100, иначе false
     */
    public static boolean isValidSalinity(String input) {
        if (!input.matches("\\d+(\\.\\d+)?")) return false;
        double value = Double.parseDouble(input);
        return value >= 0 && value <= 100;
    }

    /**
     * Проверяет, является ли строка неотрицательным вещественным числом.
     *
     * @param input введённая пользователем строка
     * @return true если строка содержит неотрицательное число, иначе false
     */
    public static boolean isValidNonNegativeDouble(String input) {
        return input.matches("\\d+(\\.\\d+)?");
    }

    /**
     * Проверяет, является ли строка валидным текстовым значением.
     * Текст должен быть непустым и не состоять только из цифр.
     *
     * @param input введённая пользователем строка
     * @return true если строка не пустая и не является числом, иначе false
     */
    public static boolean isValidString(String input) {
        return !input.isEmpty() && !input.matches("-?\\d+(\\.\\d+)?");
    }

    /**
     * Проверяет, является ли строка целым числом.
     *
     * @param input введённая пользователем строка
     * @return true если строка содержит только цифры, иначе false
     */
    public static boolean isValidInt(String input) {
        return input.matches("-?\\d+");
    }

    /**
     * Проверяет, является ли строка вещественным числом.
     *
     * @param input введённая пользователем строка
     * @return true если строка содержит число (целое или дробное), иначе false
     */
    public static boolean isValidDouble(String input) {
        return input.matches("-?\\d+(\\.\\d+)?");
    }

    /**
     * Преобразует строку в boolean
     * Поддерживаются варианты: да/д/yes/y/true/1 и нет/н/no/n/false/0.
     *
     * @param input введённая пользователем строка
     * @return true если строка распознана как "истина", false если как "ложь"
     * @throws IllegalArgumentException если строка не является валидным булевым значением
     */
    public static boolean parseBoolean(String input) {
        String lowerInput = input.trim().toLowerCase();

        if (lowerInput.equals("да") || lowerInput.equals("д") ||
                lowerInput.equals("yes") || lowerInput.equals("y") ||
                lowerInput.equals("true") || lowerInput.equals("1")) {
            return true;
        }
        else if (lowerInput.equals("нет") || lowerInput.equals("н") ||
                lowerInput.equals("no") || lowerInput.equals("n") ||
                lowerInput.equals("false") || lowerInput.equals("0")) {
            return false;
        }

        throw new IllegalArgumentException("Некорректное булево значение");
    }

    /**
     * Проверяет, является ли строка валидным булевым значением.
     * Поддерживаются варианты: да/д/yes/y/true/1 и нет/н/no/n/false/0.
     *
     * @param input введённая пользователем строка
     * @return true если строка может быть преобразована в boolean, иначе false
     */
    public static boolean isValidBoolean(String input) {
        if (input == null) return false;

        String lowerInput = input.trim().toLowerCase();

        return lowerInput.equals("да") || lowerInput.equals("д") ||
                lowerInput.equals("yes") || lowerInput.equals("y") ||
                lowerInput.equals("true") || lowerInput.equals("1") ||
                lowerInput.equals("нет") || lowerInput.equals("н") ||
                lowerInput.equals("no") || lowerInput.equals("n") ||
                lowerInput.equals("false") || lowerInput.equals("0");
    }
}