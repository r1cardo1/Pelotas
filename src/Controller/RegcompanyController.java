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
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

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
    Label result;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initCombo();
        result.setOpacity(0);
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
    public void regCompanyAction(ActionEvent evt) throws IOException, ClassNotFoundException{
        
        if(addCompany(name.getText(),rif.getText(),dir.getText(),cblogo.getSelectionModel().getSelectedIndex()))
            success();
        else
            error();
    }
    
    public boolean addCompany(String n,String r,String d,int l) throws IOException, ClassNotFoundException{
        Empresa cp;
        ArrayList<Empresa> list = new ArrayList<Empresa>();
        new File("C:\\AppPelotas").mkdirs();
        File f = new File("C:\\AppPelotas\\dbCompany");
        if(new File("C:\\AppPelotas\\dbCompany").isFile()){
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            list = (ArrayList<Empresa>)ois.readObject();
            ois.close();
        }
        FileOutputStream fos = new FileOutputStream(f);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        cp = new Empresa(n,r,d,l);
        for(int i=0;i<list.size();i++){
            if(list.get(i).getRif().equals(r))
                return false;
        }
        list.add(cp);
        oos.writeObject(list);
        oos.close();
        return true;        
    }
    
    public void success(){
        result.setText("Registro exitoso");
        result.setGraphic(new ImageView(new Image("/images/check-icon.png")));
        result.setLayoutX((620-result.getHeight())/2);
        FadeTransition ft = new FadeTransition();
        ft.setNode(result);
        ft.setFromValue(0);
        ft.setToValue(1);
        ft.setAutoReverse(true);
        ft.setDuration(Duration.seconds(2));
        ft.play();
    }
    
    public void error(){
        result.setText("No se pudo completar el registro, Los datos ya existen.");
        result.setGraphic(new ImageView(new Image("/images/error-icon.png")));
        result.setLayoutX((620-result.getHeight())/2);
        FadeTransition ft = new FadeTransition();
        ft.setNode(result);
        ft.setFromValue(0);
        ft.setToValue(1);
        ft.setAutoReverse(true);
        ft.setDuration(Duration.seconds(2));
        ft.play();
    }
    

}
