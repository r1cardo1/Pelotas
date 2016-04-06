/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;


public class SelectFactoryWindowController implements Initializable {

    @FXML
    Button btnselect;
    @FXML
    Button btnback;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    public void stall(Node n,int t,double a){
        ScaleTransition stall = new ScaleTransition();
        stall.setNode(n);
        stall.setByX(a);
        stall.setByY(a);
        stall.setDuration(Duration.millis(t));
        stall.play();
    }
    
    @FXML
    public void focusInAction(MouseEvent evt){
        stall((Node)evt.getSource(),50,0.1);
    }
    
    @FXML
    public void focusOutAction(MouseEvent evt){
        stall((Node)evt.getSource(),50,-0.10);
    }
    
    public void loadTable(){
        
    }
}
