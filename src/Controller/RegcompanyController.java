/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import TAD.Empresa;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author este_
 */
public class RegcompanyController implements Initializable {

    
    @FXML
    ComboBox cblogo;
    @FXML
    TextField name;
    @FXML
    TextField rif;
    @FXML
    TextField dir;
    @FXML
    TextField logo;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initCombo();
    }  
    
    public void initCombo(){
        cblogo.getItems().addAll(new ImageView(new Image("/images/Football-icon.png")));
        cblogo.getItems().addAll(new ImageView(new Image("/images/Soccer-icon.png")));
        cblogo.getItems().addAll(new ImageView(new Image("/images/Volleyball-icon.png")));
        cblogo.getItems().addAll(new ImageView(new Image("/images/beach-ball-icon.png")));
        cblogo.getItems().addAll(new ImageView(new Image("/images/Baseball-icon.png")));
        cblogo.getItems().addAll(new ImageView(new Image("/images/Basketball-icon.png")));
        cblogo.getSelectionModel().select(0);
    }
    
    @FXML
    public void regCompanyAction(ActionEvent evt){

    }
    
    public void addCompany(String n,String r,String d,String l) throws IOException{
        Empresa cp;
        ArrayList<Empresa> list = new ArrayList<>();
        File f = new File("C:\\AppPelotas\\dbCompany");
        FileOutputStream fos = new FileOutputStream(f);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        FileInputStream fis = new FileInputStream(f);
        ObjectInputStream ois = new ObjectInputStream(fis);
        
        
        
    }
}
