package re.project.solarpanel.customhboxes;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import re.project.solarpanel.actualthings.Quotation;
import re.project.solarpanel.controllers.InstallerJobOverviewController;

import java.time.format.DateTimeFormatter;

public class InstallerJobOverviewHBox extends HBox {
    public Label nameLabel = new Label();
    public Label plannedDateLabel = new Label();
    public Button infoButton = new Button("Info");
    private Quotation quotation;

    public InstallerJobOverviewHBox(Quotation quotation) {
        this.quotation = quotation;
        nameLabel.setText(quotation.getNameCustomer());
        nameLabel.setMaxWidth(Double.MAX_VALUE);
        plannedDateLabel.setText(quotation.getDatePlanned().format(DateTimeFormatter.ofPattern("dd-MM")));
        plannedDateLabel.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(plannedDateLabel, Priority.ALWAYS);
        this.setSpacing(65);

        infoButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                InstallerJobOverviewController.infoButtonAction(quotation);
            }
        });

        this.getChildren().addAll(nameLabel, plannedDateLabel, infoButton);
    }
}
