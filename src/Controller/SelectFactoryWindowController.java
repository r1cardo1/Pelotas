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
import javafx.scene.layout.Pane;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author este_
 */
public class SelectFactoryWindowController implements Initializable {

    @FXML
    Button btnselect;
    @FXML
    Button btnback;
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    @FXML
    public void focusInAction(ActionEvent evt){
        ScaleTransition st = new ScaleTransition();
        st.setNode((Node)evt.getSource());
        st.setDuration(Duration.millis(100));
        st.setByX(0.1);
        st.setByY(0.1);
        st.play();
    }
}
