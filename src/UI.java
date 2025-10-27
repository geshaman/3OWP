import java.util.Scanner;
import java.util.ArrayList;

/**
 * Главный класс приложения для работы со списком озер.
 */
public class UI {
    private Scanner _in;

    /**
     * Конструктор сканер ввода.
     */
    public UI(){
        _in = new Scanner(System.in);
    }


    /**
     * Печатает информацию о лабораторной работе и задании.
     */
    public void printLabInfo(){
        System.out.println("Лабораторная работа №3");
        System.out.println("Выполнили студенты группы 24ВП1 Глебов Ярослав и Пчелинцев Даниил");
        System.out.println("Задание: " + "\n– определить самое большое озеро;" +
                "\n– подсчитать количество озер с площадью меньше средней;\n" +
                "– упорядочить список по названиям;\n" +
                "– организовать поиск по названию озера, исправление одного из полей и вывод полной информации об озере после редактирования.");
    }

    /**
     * Отображает меню команд программы.
     */
    public void showCommands(){
        System.out.println("Меню программы:");
        System.out.println("1 - Создать озеро");
        System.out.println("2 - Вывести все озера");
        System.out.println("3 - Найти самое большое озеро");
        System.out.println("4 - Подсчитать озера с площадью меньше средней");
        System.out.println("5 - Упорядочить список по алфавиту");
        System.out.println("6 - Поиск по названию и редактирование");
        System.out.println("0 - Выход");
    }

    /**
     * Создаёт новое озеро на основе пользовательского ввода.
     */
    private void createLake() {
        String name = getValidatedString("Введите название озера: ");
        int area = getValidatedPositiveInt("Введите площадь (км²): ");
        double salinity = getValidatedSalinity("Введите соленость воды (%): ");

        Lake lake;
        if (salinity > 1.0) {
            double saltProduction = getValidatedNonNegativeDouble("Введите годовую добычу соли: ");
            boolean hasSaltIndustry = getValidatedBoolean("Имеет соледобывающую индустрию (да/нет): ");
            lake = new SaltLake(name, area, salinity, saltProduction, hasSaltIndustry);
            System.out.println("Создано солёное озеро");
        } else {
            int fishSpeciesCount = getValidatedPositiveInt("Введите количество видов рыб: ");
            boolean hasFishIndustry = getValidatedBoolean("Имеет рыболовную индустрию (да/нет): ");
            lake = new FreshLake(name, area, salinity, fishSpeciesCount, hasFishIndustry);
            System.out.println("Создано пресное озеро");
        }
        Lake.addLake(lake);
        System.out.println("Озеро успешно добавлено!");
    }

    /**
     * Выводит информацию обо всех озерах в списке.
     */
    private void printAllLakes() {
        ArrayList<Lake> allLakes = Lake.getAll();
        if (allLakes.isEmpty()) {
            System.out.println("Список озер пуст.");
            return;
        }
        for (Lake lake : allLakes) {
            System.out.println(lake.getInfo());
        }
    }

    /**
     * Осуществляет поиск озера по названию и позволяет редактировать его поля.
     */
    private void editLake() {
        String name = getValidatedString("Введите название озера для поиска: ");

        Lake lake = Lake.findByName(name);
        if (lake == null) {
            System.out.println("Озеро с таким названием не найдено.");
            return;
        }

        System.out.println("Найдено озеро:");
        System.out.println(lake.getInfo());

        int choice;
        do {
            System.out.println("\nЧто хотите изменить?");
            System.out.println("1 - Название");
            System.out.println("2 - Площадь");
            System.out.println("3 - Процент солёности");
            if (lake instanceof FreshLake){
                System.out.println("4 - Количество видов рыб");
                System.out.println("5 - Наличие рыболовной индустрии");
            } else if (lake instanceof SaltLake) {
                System.out.println("4 - Годовую добычу соли");
                System.out.println("5 - Наличие соледобывающей индустрии");
            }
            System.out.println("0 - Завершить редактирование");

            choice = getValidatedInt("Ваш выбор: ");

            switch (choice) {
                case 1 -> {
                    String newName = getValidatedString("Введите новое название: ");
                    lake.setName(newName);
                }
                case 2 -> {
                    int newArea = getValidatedPositiveInt("Введите новое значение площади (км²): ");
                    lake.setArea(newArea);
                }
                case 3 -> {
                    double newSalinity = getValidatedSalinity("Введите новое значение солёности воды (%): ");
                    lake.setSalinity(newSalinity);
                }
                case 4 -> {
                    if (lake instanceof FreshLake) {
                        int newFishCount = getValidatedPositiveInt("Введите новое количество рыб: ");
                        ((FreshLake) lake).setFishSpeciesCount(newFishCount);
                    } else if (lake instanceof SaltLake) {
                        double newSaltProduction = getValidatedDouble("Введите новую годовую добычу соли (%): ");
                        ((SaltLake) lake).setSaltProduction(newSaltProduction);
                    }
                }
                case 5 -> {
                    if (lake instanceof FreshLake) {
                        boolean newHasFishing = getValidatedBoolean("Имеет рыболовную индустрию (да/нет): ");
                        ((FreshLake) lake).setHasFishingIndustry(newHasFishing);
                    } else if (lake instanceof SaltLake) {
                        boolean newHasSaltIndustry = getValidatedBoolean("Имеет соледобывающую индустрию (да/нет): ");
                        ((SaltLake) lake).setHasSaltIndustry(newHasSaltIndustry);
                    }
                }

                case 0 -> System.out.println("Редактирование завершено.");
                default -> System.out.println("Неверный выбор.");
            }

            if (choice != 0) {
                System.out.println("\nТекущие данные об озере:");
                System.out.println(lake.getInfo());
            }

        } while (choice != 0);
    }

    public void run(){
        Lake.addLake(new Lake("Байкал", 31722, 0.1));
        Lake.addLake(new FreshLake("Онежское", 9720, 0.1, 45, true));
        Lake.addLake(new SaltLake("Мертвое море", 810, 34.2, 1200000, true));

        printLabInfo();

        int choice;
        do {
            showCommands();
            choice = getMenuChoice("Введите номер команды: ");
            switch (choice) {
                case 1 -> createLake();
                case 2 -> printAllLakes();
                case 3 -> {
                    Lake maxLake = Lake.findMaxArea();
                    if (maxLake != null) {
                        System.out.println("Самое большое озеро: " + maxLake.getInfo());
                    }
                }
                case 4 -> System.out.println("Количество озер с площадью меньше средней: " + Lake.countLakesWithAreaLessThanAverage());
                case 5 -> {
                    ArrayList<Lake> sortedLakes = Lake.getSortedLakes();
                    for (Lake lake : sortedLakes){
                        System.out.println(lake.getInfo());
                    }
                }
                case 6 -> editLake();
                case 0 -> System.out.println("Выход из программы...");
            }
        } while (choice != 0);
        _in.close();
    }

    private String getValidatedString(String message) {
        while (true) {
            System.out.print(message);
            String input = _in.nextLine().trim();

            if (Validator.isValidString(input)) {
                return input;
            }
            System.out.print("Некорректный ввод. Строка не должна быть пустой и не должна состоять только из цифр. ");
        }
    }

    private int getValidatedInt(String message) {
        while (true) {
            System.out.print(message);
            String input = _in.nextLine().trim();

            if (Validator.isValidInt(input)) {
                return Integer.parseInt(input);
            }
            System.out.print("Некорректный ввод. Введите целое число. ");
        }
    }

    private int getValidatedPositiveInt(String message) {
        while (true) {
            System.out.print(message);
            String input = _in.nextLine().trim();

            if (Validator.isValidPositiveInt(input)) {
                return Integer.parseInt(input);
            }
            System.out.print("Некорректный ввод. Введите положительное целое число. ");
        }
    }

    private double getValidatedDouble(String message) {
        while (true) {
            System.out.print(message);
            String input = _in.nextLine().trim();

            if (Validator.isValidDouble(input)) {
                return Double.parseDouble(input);
            }
            System.out.print("Некорректный ввод. Введите число. ");
        }
    }

    private double getValidatedSalinity(String message) {
        while (true) {
            System.out.print(message);
            String input = _in.nextLine().trim();

            if (Validator.isValidSalinity(input)) {
                return Double.parseDouble(input);
            }
            System.out.print("Некорректный ввод. Введите число от 0 до 100 включительно. ");
        }
    }

    private double getValidatedNonNegativeDouble(String message) {
        while (true) {
            System.out.print(message);
            String input = _in.nextLine().trim();

            if (Validator.isValidNonNegativeDouble(input)) {
                return Double.parseDouble(input);
            }
            System.out.print("Некорректный ввод. Введите неотрицательное число. ");
        }
    }

    private boolean getValidatedBoolean(String message) {
        while (true) {
            System.out.print(message);
            String input = _in.nextLine().trim();

            if (Validator.isValidBoolean(input)) {
                return Validator.parseBoolean(input);
            }
            System.out.print("Некорректный ввод. Используйте да/нет. ");
        }
    }

    private int getMenuChoice(String message) {
        while (true) {
            System.out.print(message);
            String input = _in.nextLine().trim();
            if (Validator.isValidMenuChoice(input)) {
                return Integer.parseInt(input);
            }
            System.out.print("Некорректный ввод. Введите число от 0 до 6. ");
        }
    }

}