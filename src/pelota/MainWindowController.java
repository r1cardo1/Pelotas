/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pelota;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.stage.Stage;
import javafx.util.Duration;

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
    
    @FXML
    public void addAction(ActionEvent evt){
        stall(btnadd,500,-0.7);
        ttally(btnadd,500,250);
        
    }
    
    public void ttally(Node n,int t,int y){
        TranslateTransition ttadd = new TranslateTransition();
        ttadd.setByY(y);
        ttadd.setDuration(Duration.millis(t));
        ttadd.setNode(n);
        ttadd.play();
    }
    
    public void ttallx(Node n,int t,double x){
        TranslateTransition ttadd = new TranslateTransition();
        ttadd.setByX(x);
        ttadd.setDuration(Duration.millis(t));
        ttadd.setNode(n);
        ttadd.play();
    }
    
    public void stall(Node n,int t,double a){
        ScaleTransition stall = new ScaleTransition();
        stall.setNode(n);
        stall.setByX(a);
        stall.setByY(a);
        stall.setDuration(Duration.millis(t));
        stall.play();
    }
}
