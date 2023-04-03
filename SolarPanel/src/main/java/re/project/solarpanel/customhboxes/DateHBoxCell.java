package re.project.solarpanel.customhboxes;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import re.project.solarpanel.controllers.PlanningController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateHBoxCell extends HBox {
    public Label dateLabel = new Label();
    public CheckBox checkBox = new CheckBox();
    public LocalDate localDate;

    public DateHBoxCell(LocalDate localDate) {
        this.localDate = localDate;
        dateLabel.setText(localDate.format(DateTimeFormatter.ofPattern("dd-MM")));
        dateLabel.setMaxWidth(Double.MAX_VALUE);


        HBox.setHgrow(dateLabel, Priority.ALWAYS);

        checkBox.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent actionEvent) {
                if (checkBox.isSelected()) {
                    //check if any checkbox is selected
                    if (PlanningController.PLANNING_CONTROLLER.isASpecificDateSelected(localDate)) {
                    //deselect these boxes
                        PlanningController.PLANNING_CONTROLLER.deselectBoxes(localDate);
                    //reset the team list
                        PlanningController.PLANNING_CONTROLLER.dateUnselected();
                    }
                    PlanningController.PLANNING_CONTROLLER.dateSelected(LocalDate.now());
                }else {
                    PlanningController.PLANNING_CONTROLLER.dateUnselected();
                }
            }

        });

        this.getChildren().addAll(dateLabel, checkBox);
    }
}
