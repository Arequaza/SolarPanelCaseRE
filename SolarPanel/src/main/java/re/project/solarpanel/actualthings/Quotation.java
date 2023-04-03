package re.project.solarpanel.actualthings;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Quotation {
    private String nameCustomer;
    private int amountSolarPanels;
    private String inverter;
    private boolean meterAdjustment;
    private int totalPriceWithVAT;
    private boolean confirmed;
    private LocalDateTime dateCreated;
    private LocalDate datePlanned;

    public Quotation(String nameCustomer, int amountSolarPanels, String inverter, boolean meterAdjustment, int totalPriceWithVAT, LocalDateTime dateCreated) {
        this.nameCustomer = nameCustomer;
        this.amountSolarPanels = amountSolarPanels;
        this.inverter = inverter;
        this.meterAdjustment = meterAdjustment;
        this.totalPriceWithVAT = totalPriceWithVAT;
        this.dateCreated = dateCreated;

        confirmed = false;
    }

    public Quotation(String nameCustomer, int amountSolarPanels, String inverter, boolean meterAdjustment, int totalPriceWithVAT, boolean confirmed, LocalDateTime dateCreated, LocalDate datePlanned) {
        this.nameCustomer = nameCustomer;
        this.amountSolarPanels = amountSolarPanels;
        this.inverter = inverter;
        this.meterAdjustment = meterAdjustment;
        this.totalPriceWithVAT = totalPriceWithVAT;
        this.confirmed = confirmed;
        this.dateCreated = dateCreated;
        this.datePlanned = datePlanned;
    }

    public Quotation() {
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

    public void confirmQuotation() {
        confirmed = true;
    }

    public void setDatePlanned(LocalDate datePlanned) {
        this.datePlanned = datePlanned;
    }

    public LocalDate getDatePlanned() {
        return datePlanned;
    }

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }
}
