/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pelota;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author este_
 */
public class MainWindowController implements Initializable {

    @FXML
    Button btnclose;
    @FXML
    Button btnmin;
    @FXML
    Button btnadd;
    @FXML
    Button btnsearch;
    @FXML
    Button btnadmin;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        btnclose.setBackground(Background.EMPTY);
        btnmin.setBackground(Background.EMPTY);
        btnadd.setBackground(Background.EMPTY);
        btnsearch.setBackground(Background.EMPTY);
        btnadmin.setBackground(Background.EMPTY);
    }    
    
    @FXML
    public void closeAction(ActionEvent evt){
        Stage stage = (Stage)btnclose.getScene().getWindow();
        stage.close();
    }
    
}
