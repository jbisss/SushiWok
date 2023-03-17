module com.example.sushiwok {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens com.example.sushiwok to javafx.fxml;
    exports com.example.sushiwok;
}