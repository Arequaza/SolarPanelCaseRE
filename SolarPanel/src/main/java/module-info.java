module re.project.solarpanel {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens re.project.solarpanel to javafx.fxml;
    exports re.project.solarpanel;
    exports re.project.solarpanel.customhboxes;
    opens re.project.solarpanel.customhboxes to javafx.fxml;
    exports re.project.solarpanel.controllers;
    opens re.project.solarpanel.controllers to javafx.fxml;
    exports re.project.solarpanel.actualthings;
    opens re.project.solarpanel.actualthings to javafx.fxml;
    exports re.project.solarpanel.helperclasses;
    opens re.project.solarpanel.helperclasses to javafx.fxml;
}