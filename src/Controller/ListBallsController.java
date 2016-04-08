/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import TAD.Empresa;
import TAD.Pelota;
import TAD.TVEmpresa;
import TAD.TVListBall;
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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;


public class ListBallsController implements Initializable {
    @FXML
    TableView tvball;
    @FXML
    TableColumn name;
    @FXML
    TableColumn preview;
    static TVEmpresa temp;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            initTable();
        } catch (IOException ex) {
            Logger.getLogger(ListBallsController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ListBallsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    public void initTable() throws IOException, FileNotFoundException, ClassNotFoundException{
        ArrayList<Empresa> listemp = loadList();
        ArrayList<Pelota> listpel = new ArrayList<>();
        for(int i=0;i<listemp.size();i++)
            if(listemp.get(i).getRif().equals(temp.getRif()))
                listpel = listemp.get(i).listaPelotas;
        ObservableList<TVListBall> data = FXCollections.observableArrayList();
        for(int i=0;i<listpel.size();i++){
            data.add(new TVListBall(listpel.get(i).nombre,temp.getRif(),listpel.get(i).getMaterial().getFile()));
        }
        preview.setCellValueFactory(new PropertyValueFactory<TVListBall,ImageView>("preview"));
        name.setCellValueFactory((new PropertyValueFactory<TVListBall,String>("name")));
        tvball.setItems(data);
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
    
    
}
