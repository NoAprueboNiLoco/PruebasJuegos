package Controllers;

import Factory.*;
import HibernateImplementation.*;
import Models.*;
import Relations.*;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {

    private Hibernate_config hc = new Hibernate_config();
    private UserDAOImplementation userDao = new UserDAOImplementation();

    @javafx.fxml.FXML
    private TextField tf_passConf;
    @javafx.fxml.FXML
    private TextField tf_mail;
    @javafx.fxml.FXML
    private TextField tf_pass;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    private boolean validarContrasena(){
        if (tf_pass.getText().equals(tf_passConf.getText()))
        {
            return true;
        }
        return false;
    }

    private boolean validarCorreo(){
        if(tf_mail.getText().matches("^[a-zA-Z0-9]{1,20}@[a-zA-Z]{1,20}\\.com$"))
        {
            return true;
        }
        return false;
    }


    @javafx.fxml.FXML
    public void register(ActionEvent actionEvent) {
        if (validarCorreo() && validarContrasena())
        {
            User r1 = new User(0, tf_mail.getText(), tf_passConf.getText());
            userDao.addUser(r1, hc.getManager());
        }
    }

    @javafx.fxml.FXML
    public void close(Event event) {
        final Node source = (Node) event.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
}
