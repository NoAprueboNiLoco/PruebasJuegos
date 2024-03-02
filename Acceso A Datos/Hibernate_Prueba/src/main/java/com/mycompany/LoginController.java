package com.mycompany;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

public class LoginController implements Initializable{

    @FXML
    private MediaView mediaView;
    private Media media;
    private MediaPlayer mediaPlayer;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        media = new Media(new File("./src/main/resources/Videos/Login.mp4").toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);
        mediaPlayer.setVolume(0f);
        mediaPlayer.play();

        mediaPlayer.setOnEndOfMedia(() -> mediaPlayer.seek(Duration.ZERO));
    }
}

