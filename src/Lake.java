import java.util.ArrayList;
import java.util.Comparator;

/**
 * Базовый класс озёр.
 */
class Lake {
    private static final ArrayList<Lake> lakes = new ArrayList<>();
    protected String name;
    protected int area;
    protected double salinity;

    /**
     * Конструктор класса по умолчанию.
     */
    public Lake() {
        this.name = "Undefind";
        this.area = 0;
        this.salinity = 0;
    }

    /**
     * Параметризированный Конструктор класса.
     *
     * @param name              Название объекта
     * @param area              Площадь (км^2)
     * @param salinity          Соленость (%)
     */
    public Lake(String name, int area, double salinity) {
        this.name = name;
        this.area = area;
        this.salinity = salinity;
    }

    /**
     * Возвращает название географического объекта.
     *
     * @return название
     */
    public String getName() { return name; }

    /**
     * Возвращает площадь объекта.
     *
     * @return площиадь в квадратных километрах
     */
    public int getArea() { return area; }

    /**
     * Устанавливает новое имя объекта.
     *
     * @param name имя
     */
    public void setName(String name) { this.name = name; }

    /**
     * Возвращает информацию об озере в виде строки.
     * @return строка с информацией
     */
    public String getInfo() {
        return "Название: " + name + ", площадь: " + area + " км^2, солёность: " + salinity + " %";
    }

    /**
     * Устанавливает новую площадь объекта.
     *
     * @param area новая площадь (должна быть положительной)
     */
    public void setArea(int area) {
        if (area > 0) {
            this.area = area;
        }
    }

    /**
     * Устанавливает новую максимальную глубину объекта.
     *
     * @param salinity новое значение солёности
     */
    public void setSalinity(double salinity) { this.salinity = salinity; }

    /**
     * Добавляет озеро в список.
     *
     * @param lake озеро
     */
    public static void addLake(Lake lake) {
        lakes.add(lake);
    }

    /**
     * Находит самое большое озеро по площади.
     *
     * @return самое большое озеро
     */
    public static Lake findMaxArea() {
        Lake maxLake = lakes.get(0);
        for (Lake lake : lakes) {
            if (lake.getArea() > maxLake.getArea()) {
                maxLake = lake;
            }
        }
        return maxLake;
    }

    /**
     * Вычисляет среднюю площадь озер.
     *
     * @return средняя площадь
     */
    public static int findAverageArea() {
        int totalArea = 0;
        for (Lake lake : lakes) {
            totalArea += lake.getArea();
        }
        return totalArea / lakes.size();
    }

    /**
     * Подсчитывает количество озер с площадью меньше средней.
     *
     * @return количество озер
     */
    public static int countLakesWithAreaLessThanAverage() {
        int avgArea = findAverageArea();
        int count = 0;
        for (Lake lake : lakes) {
            if (lake.getArea() < avgArea) {
                count++;
            }
        }
        return count;
    }

    /**
     * Возвращает строку, содержащую информацию о всех озерах, отсортированных в алфавитном порядке.
     *
     * @return строка отсортированного списка озер
     */
    public static String getSortedLakes() {
        if (lakes.isEmpty()) {
            return "Список озер пуст.";
        }

        ArrayList<Lake> sorted = new ArrayList<>(lakes);
        sorted.sort(Comparator.comparing(Lake::getName));

        String AllLakesInfo = "";
        for (Lake lake : sorted) {
            AllLakesInfo += (lake.getInfo() + "\n");
        }

        return AllLakesInfo;
    }

    /**
     * Возвращает строку, содержащую информацию о всех озерах.
     *
     * @return список озер
     */
    public static String getAll() {
        if (lakes.isEmpty()) {
            return "Список озер пуст.";
        }

        String AllLakesInfo = "";
        for (Lake lake : lakes) {
            AllLakesInfo += (lake.getInfo() + "\n");
        }

        return AllLakesInfo;
    }

    /**
     * Ищет озеро по названию.
     *
     * @param name название озера
     * @return найденное озеро или null
     */
    public static Lake findByName(String name) {
        for (Lake lake : lakes) {
            if (lake.getName().equalsIgnoreCase(name)) {
                return lake;
            }
        }
        return null;
    }

    public static boolean createLake(String name, int area, double salinity) {
        Lake newLake = new Lake(name, area, salinity);
        Lake.addLake(newLake);
        return true;
    }
}