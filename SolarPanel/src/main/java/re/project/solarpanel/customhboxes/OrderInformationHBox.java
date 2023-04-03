package re.project.solarpanel.customhboxes;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import re.project.solarpanel.actualthings.Quotation;

public class OrderInformationHBox extends HBox {
    public Label nameLabel = new Label();

    public OrderInformationHBox(Quotation quotation) {
        nameLabel.setText(quotation.getNameCustomer());

        this.getChildren().add(nameLabel);
    }
}
