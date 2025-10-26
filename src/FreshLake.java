class FreshLake extends Lake {
    private int fishSpeciesCount;
    private boolean hasFishingIndustry;
    public FreshLake(String name, int area, double salinity, int fishSpeciesCount, boolean hasFishingIndustry) {
        super(name, area, salinity);
        this.fishSpeciesCount = fishSpeciesCount;
        this.hasFishingIndustry = hasFishingIndustry;
    }

    public  int getFishSpeciesCount() {return fishSpeciesCount;}
    public boolean HasFishingIndustry() {return hasFishingIndustry; }

    public void setFishSpeciesCount(int count) { this.fishSpeciesCount = count; }
    public void setHasFishingIndustry(boolean has) {this.hasFishingIndustry = has; }

    @Override
    public String getInfo() {
        return super.getInfo() + ", видов рыб: " + fishSpeciesCount +
                ", имеет рыболовную индустрию: " + (hasFishingIndustry ? "да" : "нет");
    }
}
