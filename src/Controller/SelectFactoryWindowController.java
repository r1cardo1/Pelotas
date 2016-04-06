/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import TAD.Empresa;
import TAD.TVEmpresa;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;


public class SelectFactoryWindowController implements Initializable {

    @FXML
    Button btnselect;
    @FXML
    Button btnback;
    @FXML
    TableView tbemp;
    @FXML
    TableColumn logemp;
    @FXML
    TableColumn nomemp;
    @FXML
    Pane pnswapp;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            loadTable();
        } catch (IOException ex) {
            Logger.getLogger(SelectFactoryWindowController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SelectFactoryWindowController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    
    public void loadTable() throws IOException, FileNotFoundException, ClassNotFoundException{
        ArrayList<Empresa> list = loadList();
        ObservableList<TVEmpresa> data = FXCollections.observableArrayList();
        for(int i=0;i<list.size();i++){
            data.add(new TVEmpresa(list.get(i).getNombre(),list.get(i).getRif(),list.get(i).getDireccion(),list.get(i).getLogo()));
        }
        logemp.setCellValueFactory(new PropertyValueFactory<TVEmpresa,ImageView>("logo"));
        nomemp.setCellValueFactory(new PropertyValueFactory<TVEmpresa,String>("nombre"));
        tbemp.setItems(data);
    }
    
    public ArrayList<Empresa> loadList() throws FileNotFoundException, IOException, ClassNotFoundException{
        ArrayList<Empresa> list = new ArrayList<>();
        if(!new File("C:\\AppPelotas").isDirectory())
            new File("C:\\AppPelotas").mkdirs();
        File f = new File("C:\\AppPelotas\\dbCompany");
        if(new File("C:\\AppPelotas\\dbCompany").isFile()){
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            list = (ArrayList<Empresa>)ois.readObject();
            ois.close();
        }
        return list;
    }
    
    @FXML
    public void selectAction(ActionEvent evt) throws IOException{
        if(!tbemp.getSelectionModel().isEmpty()){
            McompanyController.temp = (TVEmpresa) tbemp.getSelectionModel().getSelectedItem();
            pnswapp.getChildren().add(1, (Node)FXMLLoader.load(getClass().getResource("/FXML/mcompany.fxml")));
            ftall(pnswapp.getChildren().get(0),100,1,0);
            ftall(pnswapp.getChildren().get(1),100,0,1);
        }
    }
    
    public void ftall(Node n,int t,double from, double to){
        FadeTransition ft = new FadeTransition();
        ft.setNode(n);
        ft.setDuration(Duration.millis(t));
        ft.setFromValue(from);
        ft.setToValue(to);
        ft.play();    
    }
}
