/**
 * Класс, описывающий озеро.
 */
class Lake extends GeoObject {
    protected double salinity;           // соленость воды (‰)
    protected boolean isNavigable;       // судоходное ли озеро
    protected boolean hasIslands;        // наличие островов
    protected double coastlineLength;    // длина береговой линии (км)
    protected double waterTemperature;   // температура воды (°C)

    /**
     * Конструктор класса Lake.
     *
     * @param name              название
     * @param area              площадь (км²)
     * @param location          местоположение
     * @param maxDepth          максимальная глубина
     * @param discoveryYear     год открытия
     * @param salinity          соленость воды (‰)
     * @param isNavigable       судоходное ли озеро
     * @param hasIslands        наличие островов
     * @param coastlineLength   длина береговой линии (км)
     * @param waterTemperature  температура воды (°C)
     */
    public Lake(String name, int area, String location, int maxDepth, int discoveryYear,
                double salinity, boolean isNavigable, boolean hasIslands, double coastlineLength,
                double waterTemperature) {
        super(name, area, location, maxDepth, discoveryYear);
        this.salinity = salinity;
        this.isNavigable = isNavigable;
        this.hasIslands = hasIslands;
        this.coastlineLength = coastlineLength;
        this.waterTemperature = waterTemperature;
    }

    /**
     * Устанавливает соленость воды.
     *
     * @param salinity новая соленость воды (должна быть неотрицательной)
     */
    public void editSalinity(double salinity) {
        if (salinity >= 0) {
            this.salinity = salinity;
        } else {
            System.out.println("Соленость воды должна быть неотрицательной!");
        }
    }

    /**
     * Устанавливает температуру воды.
     *
     * @param waterTemperature новая температура воды
     */
    public void editWaterTemperature(double waterTemperature) {
        this.waterTemperature = waterTemperature;
    }

    /**
     * Устанавливает судоходность озера.
     *
     * @param isNavigable судоходное ли озеро
     */
    public void setNavigable(boolean isNavigable) {
        this.isNavigable = isNavigable;
    }

    /**
     * Устанавливает наличие островов.
     *
     * @param hasIslands наличие островов
     */
    public void setHasIslands(boolean hasIslands) {
        this.hasIslands = hasIslands;
    }

    /**
     * Устанавливает длину береговой линии.
     *
     * @param coastlineLength новая длина береговой линии (должна быть положительной)
     */
    public void editCoastlineLength(double coastlineLength) {
        if (coastlineLength > 0) {
            this.coastlineLength = coastlineLength;
        } else {
            System.out.println("Длина береговой линии должна быть положительной!");
        }
    }

    /**
     * Печатает информацию об озере.
     */
    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Соленость воды: " + salinity + "‰");
        System.out.println("Судоходное: " + (isNavigable ? "Да" : "Нет"));
        System.out.println("Наличие островов: " + (hasIslands ? "Да" : "Нет"));
        System.out.println("Длина береговой линии: " + coastlineLength + " км");
        System.out.println("Температура воды: " + waterTemperature + "°C");
    }
}