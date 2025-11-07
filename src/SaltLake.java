/**
 * Класс SaltLake представляет собой солёное озеро с возможностью добычи соли.
 */
public class SaltLake extends Lake {
    private double saltProduction;      // Годовая добыча соли (тонн)
    private boolean hasSaltIndustry;    // Наличие соледобывающей индустрии

    /**
     * Конструктор по умолчанию.
     */
    public SaltLake() {
        super();
        this.saltProduction = 0.0;
        this.hasSaltIndustry = false;
    }

    /**
     * Конструктор с параметрами для инициализации солёного озера.
     *
     * @param name Название озера.
     * @param area Площадь озера (в кв. км).
     * @param salinity Солёность воды (в промилле).
     * @param saltProduction Годовая добыча соли (в тоннах).
     * @param hasSaltIndustry Наличие соледобывающей индустрии.
     */
    public SaltLake(String name, int area, double salinity, double saltProduction, boolean hasSaltIndustry) {
        super(name, area, salinity);
        this.saltProduction = saltProduction;
        this.hasSaltIndustry = hasSaltIndustry;
    }

    /**
     * Возвращает годовую добычу соли из озера.
     *
     * @return Годовая добыча соли (в тоннах).
     */
    public double getSaltProduction() {
        return saltProduction;
    }

    /**
     * Возвращает информацию о наличии соледобывающей индустрии.
     *
     * @return true, если индустрия имеется, иначе false.
     */
    public boolean getHasSaltIndustry() {
        return hasSaltIndustry;
    }

    /**
     * Устанавливает годовую добычу соли.
     *
     * @param count Новое значение годовой добычи соли (в тоннах).
     */
    public void setSaltProduction(double count) {
        this.saltProduction = count;
    }

    /**
     * Устанавливает наличие соледобывающей индустрии.
     *
     * @param has Новое значение флага наличия индустрии.
     */
    public void setHasSaltIndustry(boolean has) {
        this.hasSaltIndustry = has;
    }

    /**
     * Возвращает строковое представление информации об озере.
     *
     * @return Строка с полной информацией об озере.
     */
    @Override
    public String getInfo() {
        return super.getInfo() + ", годовая добыча соли: " + saltProduction +
                ", имеет соледобывающую индустрию: " + (hasSaltIndustry ? "да" : "нет");
    }

    /**
     * Создает солёное озеро и добавляет его в коллекцию
     *
     * @param name название озера
     * @param area площадь озера
     * @param salinity процент солёности озера
     * @param saltProduction годовое производство соли
     * @param hasSaltIndustry наличие соледобывающей индустрии
     * @return true - если солёное озеро успешно создано и добавлено в коллекцию
     */
    public static boolean createSaltLake(String name, int area, double salinity, double saltProduction, boolean hasSaltIndustry) {
        SaltLake newLake = new SaltLake(name, area, salinity, saltProduction, hasSaltIndustry);
        Lake.addLake(newLake);
        return true;
    }
}