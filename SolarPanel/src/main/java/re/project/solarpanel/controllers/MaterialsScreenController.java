package re.project.solarpanel.controllers;

import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import re.project.solarpanel.actualthings.Quotation;

import java.time.format.DateTimeFormatter;

public class MaterialsScreenController {
    public BorderPane borderPane;
    public Text nameCustomerText;
    public Text addressCustomerText;
    public Text telephoneCustomerText;
    public Text datePlannedText;
    public Label solarPanelLabel;
    public Text inverterTypeText;
    public Text inverterAmountText;
    public Text phaseConnectionText;
    public static Quotation QUOTATION = new Quotation();

    public MaterialsScreenController() {
    }

    public void initialize() {
        borderPane.addEventFilter(MouseEvent.MOUSE_ENTERED, eventHandler);
    }

    EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent mouseEvent) {
            setText(QUOTATION);
        }
    };

    private void setText(Quotation quotation) {
        if (quotation.getAmountSolarPanels() != 0) {
            nameCustomerText.setText(quotation.getNameCustomer());
            datePlannedText.setText(quotation.getDatePlanned().format(DateTimeFormatter.ofPattern("dd-MM")));
            solarPanelLabel.setText(Integer.toString(quotation.getAmountSolarPanels()));
            inverterTypeText.setText("Inverter " + quotation.getInverter());
            inverterAmountText.setText("1");
            if (quotation.isMeterAdjustment()) {
                phaseConnectionText.setText("1");
            } else {
                phaseConnectionText.setText("No meter adjustment");
            }
        }
    }


}


