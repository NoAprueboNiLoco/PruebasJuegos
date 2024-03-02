package Controllers;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Factory.Hibernate_config;
import HibernateImplementation.*;

import Models.*;
import Relations.*;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class LoginController implements Initializable{

    @FXML
    private MediaView mediaView;
    private Media media;
    private MediaPlayer mediaPlayer;
    @FXML
    private TextField tf_mail;
    @FXML
    private TextField tf_pass;

    private UserDAOImplementation userDao = new UserDAOImplementation();
    private Hibernate_config hc = new Hibernate_config();

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        media = new Media(new File("./src/main/resources/Videos/Login.mp4").toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);
        mediaPlayer.setVolume(0f);
        mediaPlayer.play();
        mediaPlayer.setOnEndOfMedia(() -> mediaPlayer.seek(Duration.ZERO));
    }

    @FXML
    public void abrirVentanaRegistro(Event event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/register-view.fxml"));
        Pane root = (Pane) loader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Registro");
        stage.centerOnScreen();
        stage.setResizable(false);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void ingresar(ActionEvent actionEvent) {
        ArrayList<User> users = userDao.readUser(hc.getManager());
        for(User u :users)
        {
            if(u.getMail().equals(tf_mail.getText()) && u.getPass().equals(tf_pass.getText()))
            {
                System.out.printf("Su usuario es: " + u.getMail() + " Contraseña: " + u.getPass());
            }
        }
    }
}
