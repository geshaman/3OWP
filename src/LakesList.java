import java.util.ArrayList;
import java.util.Comparator;

/**
 * Класс для управления списком озер.
 */
public class LakesList {
    private ArrayList<Lake> lakes;

    /**
     * Конструктор инициализирует пустой список озер.
     */
    public LakesList() {
        lakes = new ArrayList<>();
    }

    /**
     * Добавляет озеро в список.
     *
     * @param lake озеро
     */
    public void addLake(Lake lake) {
        lakes.add(lake);
    }

    /**
     * Находит самое большое озеро по площади.
     *
     * @return самое большое озеро
     */
    public Lake findMaxArea() {
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
    public int findAverageArea() {
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
    public int countLakesWithAreaLessThanAverage() {
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
     * Сортирует озера по алфавиту и выводит их.
     */
    public void printSortedLakes() {
        lakes.stream().sorted(Comparator.comparing(Lake::getName)).forEach(Lake::printInfo);
    }

    /**
     * Возвращает все озера.
     *
     * @return список озер
     */
    public ArrayList<Lake> getAll() {
        return lakes;
    }

    /**
     * Ищет озеро по названию.
     *
     * @param name название озера
     * @return найденное озеро или null
     */
    public Lake findByName(String name) {
        for (Lake lake : lakes) {
            if (lake.getName().equalsIgnoreCase(name)) {
                return lake;
            }
        }
        return null;
    }
}