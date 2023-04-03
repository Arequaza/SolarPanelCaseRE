package re.project.solarpanel.controllers;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import re.project.solarpanel.helperclasses.DataSaver;
import re.project.solarpanel.HelloController;
import re.project.solarpanel.actualthings.Quotation;
import re.project.solarpanel.helperclasses.QuotationCalculation;

import java.time.LocalDateTime;

public class QuotationCreationController {
    public Button calcButton;
    public TextField roofWidthInput;
    public TextField roofLengthInput;
    public TextField amountSolarPanelsInput;
    public TextField consumptionInput;
    public CheckBox meterAdjustmentCheckBox;
    public Text textSolarPanels;
    public Text solarPanelPrice;
    public Text inverterText;
    public Text inverterPrice;
    public Text meterAdjustmentText;
    public Text meterAdjustmentCost;
    public Text installationCost;
    public Text totalCost;
    public Text vatPrice;
    public Text totalIncludingVatPrice;
    public Text estimatedEnergyProduction;
    public TextField telephoneNumberInput;
    public TextField emailAddressInput;
    public TextField nameCustomerInput;
    public Text warningText;

    public HelloController helloController = new HelloController();

    public void calcButtonPress() {
        if (amountSolarPanelsInput.getText().isEmpty()) {
            int amountOfSolarPanels = getPanelsFittingOnRoof();
            generateText(amountOfSolarPanels);
        } else {
            int amountOfSolarPanels = Integer.parseInt(amountSolarPanelsInput.getText());
            if (amountOfSolarPanels <= getPanelsFittingOnRoof()) {
                generateText(amountOfSolarPanels);
            }
        }
    }

    public void onCreateButtonPress() {
        if (!amountSolarPanelsInput.getText().isEmpty()) {
            String nameCustomer = nameCustomerInput.getText();
            int amountSolarPanels = Integer.parseInt(amountSolarPanelsInput.getText());
            String inverter = QuotationCalculation.whichInverter(amountSolarPanels);
            boolean meterAdjustMent = meterAdjustmentCheckBox.isSelected();
            int totalPriceWithVat = QuotationCalculation.totalPriceWithVAT(amountSolarPanels, meterAdjustMent);
            Quotation quotation = new Quotation(nameCustomer,amountSolarPanels,inverter,meterAdjustMent,totalPriceWithVat, LocalDateTime.now());
            DataSaver.addQuotationToList(quotation);
            OpenQuotationOverview.QUOTATION_OVERVIEW.addNewItem(quotation);
        } else {
            warningText.setText("There is no specified amount of solar panels!");
        }
    }

    public void cancelButtonPress() {

    }

    private int getPanelsFittingOnRoof() {
        int roofLength = Integer.parseInt(roofLengthInput.getText());
        int roofWidth = Integer.parseInt(roofWidthInput.getText());

        return QuotationCalculation.placeForNumberOfPanels(roofLength, roofWidth);
    }

    private void generateText(int amountOfSolarPanels) {
        textSolarPanels.setText(amountOfSolarPanels + " Solar Panels");
        solarPanelPrice.setText("€ " + QuotationCalculation.getPriceOfSolarPanels(amountOfSolarPanels));
        inverterText.setText("1 " + QuotationCalculation.whichInverter(amountOfSolarPanels));
        inverterPrice.setText("€ " + QuotationCalculation.priceOfInverter(QuotationCalculation.whichInverter(amountOfSolarPanels)));
        installationCost.setText("€ " + QuotationCalculation.getInstallationPrice(amountOfSolarPanels));
        if (meterAdjustmentCheckBox.isSelected()) {
            meterAdjustmentText.setText("Meter adjustment");
            meterAdjustmentCost.setText("€ " + QuotationCalculation.meterAdjustmentPrice);
            warningText.setText("");
        } else {
            if (QuotationCalculation.needMeterAdjustment(amountOfSolarPanels)) {
                warningText.setText("! Might need meter adjustment");
            } else {
                warningText.setText("");
            }
        }
        totalCost.setText("€ " + QuotationCalculation.totalPriceNoVAT(amountOfSolarPanels, meterAdjustmentCheckBox.isSelected()));
        vatPrice.setText("€ " + QuotationCalculation.vatPrice(amountOfSolarPanels, meterAdjustmentCheckBox.isSelected()));
        totalIncludingVatPrice.setText("€ " + QuotationCalculation.totalPriceWithVAT(amountOfSolarPanels, meterAdjustmentCheckBox.isSelected()));
        estimatedEnergyProduction.setText(QuotationCalculation.productionOfAllSolarPanels(amountOfSolarPanels) + " WAT");

    }




}
