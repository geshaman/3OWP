class SaltLake extends Lake {
    private double saltProduction;
    private boolean hasSaltIndustry;
    public SaltLake(String name, int area, double salinity, double saltProduction, boolean hasSaltIndustry) {
        super(name, area, salinity);
    }

    @Override
    public String getInfo() {
        return super.getInfo() + ", годовая добыча соли: " + saltProduction +
                ", имеет соледобывающую индустрию: " + (hasSaltIndustry ? "да" : "нет");
    }
}
