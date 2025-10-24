import java.util.Scanner;

/**
 * Главный класс приложения для работы со списком озер.
 */
public class App {
    private static Scanner _in;
    private LakesList lakes;

    /**
     * Конструктор инициализирует список озер и сканер ввода.
     */
    public App(){
        _in = new Scanner(System.in);
        lakes = new LakesList();
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
        String name = Validator.getString(_in, "Введите название озера: ");
        int area = Validator.getPositiveInt(_in, "Введите площадь (км²): ");
        String location = Validator.getString(_in, "Введите местоположение: ");
        int maxDepth = Validator.getPositiveInt(_in, "Введите максимальную глубину: ");
        int discoveryYear = Validator.getPositiveInt(_in, "Введите год открытия: ");

        double salinity = Validator.getSalinity(_in, "Введите соленость воды (‰): ");
        boolean isNavigable = Validator.getBoolean(_in, "Судоходное");
        boolean hasIslands = Validator.getBoolean(_in, "Наличие островов");
        double coastlineLength = Validator.getNonNegativeDouble(_in, "Введите длину береговой линии (км): ");
        double waterTemperature = Validator.getDouble(_in, "Введите температуру воды (°C): ");

        Lake lake = new Lake(name, area, location, maxDepth, discoveryYear, salinity, isNavigable, hasIslands, coastlineLength, waterTemperature);
        lakes.addLake(lake);
        System.out.println("Озеро успешно добавлено!");
    }

    /**
     * Выводит информацию обо всех озерах в списке.
     */
    private void printAllLakes() {
        for (Lake lake : lakes.getAll()) {
            lake.printInfo();
        }
    }

    /**
     * Осуществляет поиск озера по названию и позволяет редактировать его поля.
     */
    private void editLake() {
        String name = Validator.getString(_in, "Введите название озера для поиска: ");

        Lake lake = lakes.findByName(name);
        if (lake == null) {
            System.out.println("Озеро с таким названием не найдено.");
            return;
        }

        System.out.println("Найдено озеро:");
        lake.printInfo();

        int choice;
        do {
            System.out.println("\nЧто хотите изменить?");
            System.out.println("1 - Название");
            System.out.println("2 - Площадь");
            System.out.println("3 - Местоположение");
            System.out.println("4 - Максимальную глубину");
            System.out.println("5 - Год открытия");
            System.out.println("6 - Соленость воды");
            System.out.println("7 - Судоходность");
            System.out.println("8 - Наличие островов");
            System.out.println("9 - Длину береговой линии");
            System.out.println("10 - Температуру воды");
            System.out.println("0 - Завершить редактирование");

            choice = Validator.getInt(_in, "Ваш выбор: ");

            switch (choice) {
                case 1 -> lake.setName(Validator.getString(_in, "Введите новое название: "));
                case 2 -> lake.setArea(Validator.getPositiveInt(_in, "Введите новую площадь (км²): "));
                case 3 -> lake.setLocation(Validator.getString(_in, "Введите новое местоположение: "));
                case 4 -> lake.setMaxDepth(Validator.getPositiveInt(_in, "Введите новую максимальную глубину: "));
                case 5 -> lake.setDiscoveryYear(Validator.getPositiveInt(_in, "Введите новый год открытия: "));
                case 6 -> lake.editSalinity(Validator.getSalinity(_in, "Введите новую соленость воды (‰): "));
                case 7 -> lake.setNavigable(Validator.getBoolean(_in, "Судоходное"));
                case 8 -> lake.setHasIslands(Validator.getBoolean(_in, "Наличие островов"));
                case 9 -> lake.editCoastlineLength(Validator.getNonNegativeDouble(_in, "Введите новую длину береговой линии (км): "));
                case 10 -> lake.editWaterTemperature(Validator.getDouble(_in, "Введите новую температуру воды (°C): "));
                case 0 -> System.out.println("Редактирование завершено.");
                default -> System.out.println("Неверный выбор.");
            }

            if (choice != 0) {
                System.out.println("\nТекущие данные об озере:");
                lake.printInfo();
            }

        } while (choice != 0);
    }

    /**
     * Запускает основной цикл программы.
     */
    public void run(){
        lakes.addLake(new Lake("Каспийское море", 371000, "Казахстан/Россия/Туркменистан/Иран/Азербайджан",
                1025, 932, 13.0, true, true, 7000, 15.5));
        lakes.addLake(new Lake("Байкал", 31722, "Россия", 1642, 1643,
                0.1, true, true, 2100, 4.0));
        lakes.addLake(new Lake("Верхнее", 82100, "США/Канада", 406, 1658,
                0.1, true, true, 4387, 4.0));

        printLabInfo();

        int choice;
        do {
            showCommands();
            choice = Validator.getMenuChoice(_in, "Введите номер команды: ");
            switch (choice) {
                case 1 -> createLake();
                case 2 -> printAllLakes();
                case 3 -> System.out.println("Самое большое озеро: " + lakes.findMaxArea().getName());
                case 4 -> System.out.println("Количество озер с площадью меньше средней: " + lakes.countLakesWithAreaLessThanAverage());
                case 5 -> lakes.printSortedLakes();
                case 6 -> editLake();
                case 0 -> System.out.println("Выход из программы...");
            }
        } while (choice != 0);
    }
}