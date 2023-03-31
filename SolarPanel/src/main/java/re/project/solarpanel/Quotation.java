package re.project.solarpanel;

import java.time.LocalDateTime;

public class Quotation {
    private String nameCustomer;
    private int amountSolarPanels;
    private String inverter;
    private boolean meterAdjustment;
    private int totalPriceWithVAT;
    private boolean confirmed;
    private LocalDateTime dateCreated;

    public Quotation(String nameCustomer, int amountSolarPanels, String inverter, boolean meterAdjustment, int totalPriceWithVAT, LocalDateTime dateCreated) {
        this.nameCustomer = nameCustomer;
        this.amountSolarPanels = amountSolarPanels;
        this.inverter = inverter;
        this.meterAdjustment = meterAdjustment;
        this.totalPriceWithVAT = totalPriceWithVAT;
        this.dateCreated = dateCreated;

        confirmed = false;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public int getAmountSolarPanels() {
        return amountSolarPanels;
    }

    public String getInverter() {
        return inverter;
    }

    public boolean isMeterAdjustment() {
        return meterAdjustment;
    }

    public int getTotalPriceWithVAT() {
        return totalPriceWithVAT;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }
}
