package re.project.solarpanel.actualthings;

import re.project.solarpanel.helperclasses.DataSaver;

public class Stock {
    private static int solarPanels = 0;
    private static int solarPanelsNeeded = 0;
    private static int inverterSB2000 = 0;
    private static int inverterSB2000Needed = 0;
    private static int inverterSB5000 = 0;
    private static int inverterSB5000Needed = 0;
    private static int inverterSB6000 = 0;
    private static int inverterSB6000Needed = 0;
    private static int inverterSB8000 = 0;
    private static int inverterSB8000Needed = 0;
    private static int inverterSB12000 = 0;
    private static int inverterSB12000Needed = 0;
    private static int phaseConnector = 0;
    private static int phaseConnectorNeeded = 0;

    public static int getSolarPanels() {
        return solarPanels;
    }

    public static int getInverterSB2000() {
        return inverterSB2000;
    }

    public static int getInverterSB5000() {
        return inverterSB5000;
    }

    public static int getInverterSB6000() {
        return inverterSB6000;
    }

    public static int getInverterSB8000() {
        return inverterSB8000;
    }

    public static int getInverterSB12000() {
        return inverterSB12000;
    }

    public static int getPhaseConnector() {
        return phaseConnector;
    }

    public static void addSolarPanels(int amount) {
        solarPanels += amount;
    }

    public static void addInverterSB2000(int amount) {
        inverterSB2000 += amount;
    }

    public static void addInverterSB5000(int amount) {
        inverterSB5000 += amount;
    }

    public static void addInverterSB6000(int amount) {
        inverterSB6000 += amount;
    }

    public static void addInverterSB8000(int amount) {
        inverterSB8000 += amount;
    }

    public static void addInverterSB12000(int amount) {
        inverterSB12000 += amount;
    }

    public static void addPhaseConnector(int amount) {
        phaseConnector += amount;
    }

    public static void updateSolarPanelsNeeded() {
        int solarPanelCount = 0;
        for (Quotation quotation: DataSaver.getApprovedQuotations()) {
            solarPanelCount += quotation.getAmountSolarPanels();
        }
        for (InstallationTeam installationTeam: DataSaver.getInstallationTeams()) {
            for (Quotation quotation: installationTeam.getQuotationsToDo()) {
                solarPanelCount += quotation.getAmountSolarPanels();
            }
        }
        solarPanelsNeeded = solarPanelCount;
    }

    public static void updateInvertersNeeded() {
        inverterSB2000Needed = 0;
        inverterSB5000Needed = 0;
        inverterSB6000Needed = 0;
        inverterSB8000Needed = 0;
        inverterSB12000Needed = 0;
        for (Quotation quotation: DataSaver.getApprovedQuotations()) {
            inverterCounter(quotation);
        }
        for (InstallationTeam installationTeam: DataSaver.getInstallationTeams()) {
            for (Quotation quotation: installationTeam.getQuotationsToDo()) {
                inverterCounter(quotation);
            }
        }
    }

    private static void inverterCounter(Quotation quotation) {
        switch (quotation.getInverter()) {
            case "SB2000" -> inverterSB2000Needed++;
            case "SB5000" -> inverterSB5000Needed++;
            case "SB6000" -> inverterSB6000Needed++;
            case "SB8000" -> inverterSB8000Needed++;
            case "SB12000" -> inverterSB12000Needed++;
            default -> {}
        }
    }

    public static void updatePhaseConnectorsNeeded() {
        int phaseConnectorCount = 0;
        for (Quotation quotation : DataSaver.getApprovedQuotations()) {
            if (quotation.isMeterAdjustment()) {
                phaseConnectorCount++;
            }
        }
        for (InstallationTeam installationTeam : DataSaver.getInstallationTeams()) {
            for (Quotation quotation: installationTeam.getQuotationsToDo()) {
                if (quotation.isMeterAdjustment()) {
                    phaseConnectorCount++;
                }
            }
        }
        phaseConnectorNeeded = phaseConnectorCount;
    }

    public static int getSolarPanelsNeeded() {
        return solarPanelsNeeded;
    }

    public static int getInverterSB2000Needed() {
        return inverterSB2000Needed;
    }

    public static int getInverterSB5000Needed() {
        return inverterSB5000Needed;
    }

    public static int getInverterSB6000Needed() {
        return inverterSB6000Needed;
    }

    public static int getInverterSB8000Needed() {
        return inverterSB8000Needed;
    }

    public static int getInverterSB12000Needed() {
        return inverterSB12000Needed;
    }

    public static int getPhaseConnectorNeeded() {
        return phaseConnectorNeeded;
    }
}
