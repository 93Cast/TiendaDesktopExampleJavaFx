module sv.arrupe.tienda {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens sv.arrupe.tienda to javafx.fxml;
    exports sv.arrupe.tienda;
}