package re.project.solarpanel;

public class QuotationCalculation {
    public static final int productionPerPanel = 405;
    public static final int priceOfOnePanel = 200;
    public static final int sizeOfPanelLengthMM = 1754;
    public static final int sizeSizeOfPanelWidthMM = 1096;
    public static final int inverterSB2000Price = 400;
    public static final int inverterSB5000Price = 600;
    public static final int inverterSB6000Price = 800;
    public static final int inverterSB8000Price = 1000;
    public static final int inverterSB12000Price = 1500;
    public static final int meterAdjustmentPrice = 800;
    public static final int installationFixedPrice = 1000;
    public static final int installationPricePerPanel = 50;

    public static int getPriceOfSolarPanels(int amountOfPanels) {
        return amountOfPanels * priceOfOnePanel;
    }

    public static int productionOfAllSolarPanels(int amountOfPanels) {
        return amountOfPanels * productionPerPanel;
    }

    public static int getInstallationPrice(int amountOfPanels) {
        return installationFixedPrice + installationPricePerPanel * amountOfPanels;
    }

    public static boolean needMeterAdjustment(int amountOfEnergy) {
        return amountOfEnergy >= 6000;
    }

    public static String whichInverter(int amountOfEnergy) {
        if (amountOfEnergy < 2000) {
            return "SB2000";
        } else if (amountOfEnergy < 5000) {
            return "SB5000";
        } else if (amountOfEnergy < 6000) {
            return "SB6000";
        } else if (amountOfEnergy < 8000) {
            return "SB8000";
        } else {
            return "SB12000";
        }
    }

    public static int priceOfInverter(String nameInverter) {
        return switch (nameInverter) {
            case "SB2000" -> inverterSB2000Price;
            case "SB5000" -> inverterSB5000Price;
            case "SB6000" -> inverterSB6000Price;
            case "SB8000" -> inverterSB8000Price;
            case "SB12000" -> inverterSB12000Price;
            default -> 0;
        };
    }


}
