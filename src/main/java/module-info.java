module tv2.metamorphose {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires net.synedra.validatorfx;

    opens tv2.metamorphose to javafx.fxml;
    exports tv2.metamorphose;
}