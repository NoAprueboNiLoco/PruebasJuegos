module com.example.practica74 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.practica74 to javafx.fxml;
    exports com.example.practica74;
}