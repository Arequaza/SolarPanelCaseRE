package re.project.solarpanel.customhboxes;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import re.project.solarpanel.controllers.ToBePlannedController;
import re.project.solarpanel.helperclasses.DataSaver;
import re.project.solarpanel.actualthings.Quotation;

import java.time.format.DateTimeFormatter;

public class ToBePlannedOverviewHBox extends HBox {
    Label nameLabel = new Label();
    Label dateLabel = new Label();
    Label idLabel = new Label();
    Button planButton = new Button();
    private final Quotation quotation;

    public ToBePlannedOverviewHBox(Quotation quotation) {
        this.quotation = quotation;
        planButton.setText("Plan");

        idLabel.setText(String.valueOf(DataSaver.getApprovedQuotations().size()));
        nameLabel.setText(quotation.getNameCustomer());
        nameLabel.setMaxWidth(Double.MAX_VALUE);
        dateLabel.setText(quotation.getDateCreated().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));

        HBox.setHgrow(nameLabel, Priority.ALWAYS);

        this.setSpacing(25);

        planButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                ToBePlannedController.TO_BE_PLANNED_CONTROLLER.planButtonClick(Integer.parseInt(idLabel.getText()));
            }
        });


        this.getChildren().addAll(idLabel, dateLabel, nameLabel, planButton);
    }

    public Quotation getQuotation() {
        return quotation;
    }
}
