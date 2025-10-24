class FreshLake extends Lake {
    public FreshLake(String name, int area, String location, int maxDepth, int discoveryYear, double salinity, boolean isNavigable, boolean hasIslands, double coastlineLength, double waterTemperature) {
        super(name, area, location, maxDepth, discoveryYear, salinity, isNavigable, hasIslands, coastlineLength, waterTemperature);
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println(name + " - пресноводное озеро, концентрация соли: " + salinity + "%");
    }
}
