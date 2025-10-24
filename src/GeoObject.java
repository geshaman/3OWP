/**
 * Базовый класс для географических объектов (озёр).
 */
class GeoObject {
    protected String name;
    protected int area;
    protected String location;
    protected int maxDepth;
    protected int discoveryYear;

    /**
     * Конструктор класса.
     *
     * @param name              Название объекта
     * @param area              Площадь (км^2)
     * @param location          Местоположение
     * @param maxDepth          Максимальная глубина
     * @param discoveryYear     Год открытия
     */
    public GeoObject(String name, int area, String location, int maxDepth, int discoveryYear) {
        this.name = name;
        this.area = area;
        this.location = location;
        this.maxDepth = maxDepth;
        this.discoveryYear = discoveryYear;
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
    public int getLength() { return area; }

    /**
     * Возвращает местоположение объекта.
     *
     * @return местоположение
     */
    public String getLocation() { return location; }

    /**
     * Возвращает максимальную глубину объекта.
     *
     * @return максимальная глубина
     */
    public int getMaxDepth() { return maxDepth; }

    /**
     * Возвращает год открытия объекта.
     *
     * @return год открытия
     */
    public int getDiscoveryYear() {return discoveryYear; }

    /**
     * Печатает информацию об объекте.
     */
    public void printInfo() {
        System.out.println("Название: " + name + ", площадь: " + area + " км^2, местоположение: " + location +
                ", максимальная глубина: " + maxDepth + ", год открытия: " + discoveryYear);
    }

    /**
     * Устанавливает новое имя объекта.
     *
     * @param name имя
     */
    public void setName(String name) { this.name = name; }

    /**
     * Устанавливает новую площадь объекта.
     *
     * @param area новая площадь (должна быть положительной)
     */
    public void setArea(int area) {
        if (area > 0) {
            this.area = area;
        } else {
            System.out.println("Длина должна быть положительной!");
        }
    }

    /**
     * Устанавливает новое местоположение объекта.
     *
     * @param location новое местоположение
     */
    public void setLocation(String location) { this.location = location; }

    /**
     * Устанавливает новую максимальную глубину объекта.
     *
     * @param maxDepth максимальная глубина
     */
    public void setMaxDepth(int maxDepth) { this.maxDepth = maxDepth; }

    /**
     * Устанавливает новый год открытия объекта.
     *
     * @param discoveryYear год окрытия
     */
    public void setDiscoveryYear(int discoveryYear) { this.discoveryYear = discoveryYear; }

}