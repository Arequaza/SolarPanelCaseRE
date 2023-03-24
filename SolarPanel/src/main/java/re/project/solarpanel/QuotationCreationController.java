package re.project.solarpanel;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;

public class QuotationCreationController {
    public Button calcButton;
    public TextField amountSolarPanelsInput;
    public TextField roofAreaInput;
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
    public FlowPane quotationCreationScreen;

    public void calcButtonPress(MouseEvent mouseEvent) {
        if (amountSolarPanelsInput.getText().isEmpty()) {

        } else {
            int amountOfSolarPanels = Integer.parseInt(amountSolarPanelsInput.getText());
            int productionEnergy = QuotationCalculation.productionOfAllSolarPanels(amountOfSolarPanels);
            textSolarPanels.setText(amountOfSolarPanels + " Solar Panels");
            solarPanelPrice.setText("€ " + QuotationCalculation.getPriceOfSolarPanels(amountOfSolarPanels));

        }
    }
}
