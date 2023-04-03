package re.project.solarpanel.actualthings;

public class Stock {
    private int solarPanels;
    private int inverterSB2000;
    private int inverterSB5000;
    private int inverterSB6000;
    private int inverterSB8000;
    private int inverterSB12000;
    private int phaseConnector;

    public Stock(int solarPanels, int inverterSB2000, int inverterSB5000, int inverterSB6000, int inverterSB8000, int inverterSB12000, int phaseConnector) {
        this.solarPanels = solarPanels;
        this.inverterSB2000 = inverterSB2000;
        this.inverterSB5000 = inverterSB5000;
        this.inverterSB6000 = inverterSB6000;
        this.inverterSB8000 = inverterSB8000;
        this.inverterSB12000 = inverterSB12000;
        this.phaseConnector = phaseConnector;
    }

    public int getSolarPanels() {
        return solarPanels;
    }

    public int getInverterSB2000() {
        return inverterSB2000;
    }

    public int getInverterSB5000() {
        return inverterSB5000;
    }

    public int getInverterSB6000() {
        return inverterSB6000;
    }

    public int getInverterSB8000() {
        return inverterSB8000;
    }

    public int getInverterSB12000() {
        return inverterSB12000;
    }

    public int getPhaseConnector() {
        return phaseConnector;
    }

    public void addSolarPanels(int amount) {
        this.solarPanels += amount;
    }

    public void addInverterSB2000(int amount) {
        this.inverterSB2000 += amount;
    }

    public void addInverterSB5000(int amount) {
        this.inverterSB5000 += amount;
    }

    public void addInverterSB6000(int amount) {
        this.inverterSB6000 += amount;
    }

    public void addInverterSB8000(int amount) {
        this.inverterSB8000 += amount;
    }

    public void addInverterSB12000(int amount) {
        this.inverterSB12000 += amount;
    }

    public void addPhaseConnector(int amount) {
        this.phaseConnector += amount;
    }
}
