package re.project.solarpanel.customhboxes;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import re.project.solarpanel.helperclasses.DataSaver;
import re.project.solarpanel.controllers.OpenQuotationOverview;
import re.project.solarpanel.actualthings.Quotation;

import java.time.format.DateTimeFormatter;

public class CustomHBoxCell extends HBox{

    Label nameLabel = new Label();
    Label dateLabel = new Label();
    Label idLabel = new Label();
    Button approveButton = new Button();
    Button deleteButton = new Button();
    Button editButton = new Button();

    private final Quotation quotation;

    public CustomHBoxCell(Quotation quotation) {
        super();

        this.quotation = quotation;
        idLabel.setText(String.valueOf(DataSaver.getListOfQuotations().size()));
        idLabel.setMaxWidth(Double.MAX_VALUE);
        dateLabel.setText(quotation.getDateCreated().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        dateLabel.setMaxWidth(Double.MAX_VALUE);
        nameLabel.setText(quotation.getNameCustomer());
        nameLabel.setMaxWidth(Double.MAX_VALUE);

        HBox.setHgrow(nameLabel, Priority.ALWAYS);
        this.setSpacing(25);


        approveButton.setText("Approve");
        deleteButton.setText("Delete");
        editButton.setText("Edit");
        approveButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                OpenQuotationOverview.QUOTATION_OVERVIEW.approveButtonClick(Integer.parseInt(idLabel.getText()));
            }
        });

        this.getChildren().addAll(idLabel, dateLabel,nameLabel, approveButton, editButton, deleteButton);
    }

    public Quotation getQuotation() {
        return quotation;
    }
}
