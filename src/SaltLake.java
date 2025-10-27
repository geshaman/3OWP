class SaltLake extends Lake {
    private double saltProduction;
    private boolean hasSaltIndustry;
    public SaltLake(String name, int area, double salinity, double saltProduction, boolean hasSaltIndustry) {
        super(name, area, salinity);
    }

    public double getSaltProduction() {return saltProduction;}
    public boolean getHasSaltIndustry() {return hasSaltIndustry; }

    public void setSaltProduction(double count) { this.saltProduction = count; }
    public void setHasSaltIndustry(boolean has) {this.hasSaltIndustry = has; }

    @Override
    public String getInfo() {
        return super.getInfo() + ", годовая добыча соли: " + saltProduction +
                ", имеет соледобывающую индустрию: " + (hasSaltIndustry ? "да" : "нет");
    }
}
