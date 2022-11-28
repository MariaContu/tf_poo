module com.example.maria_contu_mauro_sachs {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.almasb.fxgl.all;
    requires java.desktop;

    opens poo to javafx.fxml;
    exports poo;
}