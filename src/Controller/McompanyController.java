/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import TAD.TVEmpresa;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.ScaleTransition;
import static javafx.application.ConditionalFeature.FXML;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Ricardo
 */
public class McompanyController implements Initializable {
    @FXML
    ImageView logo;
    @FXML
    Label name;
    static TVEmpresa temp;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        updateInfo();
    }    
    
    public void updateInfo(){
        logo.setImage(temp.getLogo().getImage());
        name.setText(temp.getNombre());
    }
    
    @FXML
    public void focusInAction(MouseEvent evt){
        stall((Node)evt.getSource(),50,0.1);
    }
    
    @FXML
    public void focusOutAction(MouseEvent evt){
        stall((Node)evt.getSource(),50,-0.10);
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
