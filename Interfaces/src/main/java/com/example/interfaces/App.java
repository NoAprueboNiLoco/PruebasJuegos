package com.example.interfaces;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(App.class.getResource("/View/login-view.fxml"));
        Pane rootPane = (Pane) loader.load();
        Scene scene = new Scene(rootPane);
        stage.setResizable(true);
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
    }
}
