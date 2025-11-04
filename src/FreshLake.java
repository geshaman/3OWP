/**
 * Класс пресных озёр, наследует от класса Lake.
 */
class FreshLake extends Lake {
    private int fishSpeciesCount;
    private boolean hasFishingIndustry;

    /**
     * Конструктор класса по умолчанию.
     */
    public FreshLake() {
        super();
        this.fishSpeciesCount = 0;
        this.hasFishingIndustry = false;
    }

    /**
     * Параметризированный Конструктор класса.
     *
     * @param name               Название объекта
     * @param area               Площадь (км^2)
     * @param salinity           Соленость (%)
     * @param fishSpeciesCount   Количество видов рыб
     * @param hasFishingIndustry Наличие рыболовной промышленности
     */
    public FreshLake(String name, int area, double salinity, int fishSpeciesCount, boolean hasFishingIndustry) {
        super(name, area, salinity);
        this.fishSpeciesCount = fishSpeciesCount;
        this.hasFishingIndustry = hasFishingIndustry;
    }

    /**
     * Возвращает Количество видов рыб.
     *
     * @return fishSpeciesCount
     */
    public  int getFishSpeciesCount() {return fishSpeciesCount;}

    /**
     * Возвращает true если в озере ведется добыча рыбы и false в ином случае.
     *
     * @return hasFishingIndustry
     */
    public boolean HasFishingIndustry() {return hasFishingIndustry; }

    /**
     * Устанавливает новое Количество видов рыб.
     *
     * @param count количество
     */
    public void setFishSpeciesCount(int count) { this.fishSpeciesCount = count; }

    /**
     * Устанавливает новое значение hasFishingIndustry.
     *
     * @param has boolean
     */
    public void setHasFishingIndustry(boolean has) {this.hasFishingIndustry = has; }

    /**
     * Возвращает информацию о пресном озере в виде строки.
     * @return строка с информацией
     */
    @Override
    public String getInfo() {
        return super.getInfo() + ", видов рыб: " + fishSpeciesCount +
                ", имеет рыболовную индустрию: " + (hasFishingIndustry ? "да" : "нет");
    }

    public static boolean createFreshLake(String name, int area, double salinity, int fishSpeciesCount, boolean hasFishingIndustry) {
        FreshLake newLake = new FreshLake(name, area, salinity, fishSpeciesCount, hasFishingIndustry);
        Lake.addLake(newLake);
        return true;
    }
}
