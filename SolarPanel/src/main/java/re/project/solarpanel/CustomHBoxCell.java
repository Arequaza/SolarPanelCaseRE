package re.project.solarpanel;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class CustomHBoxCell extends HBox{
    Label nameLabel = new Label();
    Label dateLabel = new Label();
    Label idLabel = new Label();
    Button approveButton = new Button();

    private final Quotation quotation;

    public CustomHBoxCell(Quotation quotation) {
        super();

        this.quotation = quotation;
        idLabel.setText(String.valueOf(DataSaver.getListOfQuotations().size() + 1));
        idLabel.setMaxWidth(Double.MAX_VALUE);
        nameLabel.setText(quotation.getNameCustomer());
        nameLabel.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(nameLabel, Priority.ALWAYS);

        approveButton.setText("Approve");
        approveButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                approveButtonClick(quotation);
            }
        });

        this.getChildren().addAll(nameLabel, approveButton);
    }

    public void approveButtonClick(Quotation quotation) {
        DataSaver.addApprovedQuotation(quotation);

    }
}
