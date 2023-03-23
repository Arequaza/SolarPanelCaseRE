module re.project.solarpanel {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens re.project.solarpanel to javafx.fxml;
    exports re.project.solarpanel;
}