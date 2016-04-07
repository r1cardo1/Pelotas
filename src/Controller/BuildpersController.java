/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TabPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Box;
import javafx.scene.shape.Sphere;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Ricardo
 */
public class BuildpersController implements Initializable {


    @FXML
    Box cball;
    @FXML
    Sphere sball;
    @FXML
    GridPane panMetal;
    @FXML
    GridPane panWood;
    @FXML
    GridPane panGoma;
    @FXML
    GridPane panPlastic;
    @FXML
    GridPane panLeather;
    @FXML
    GridPane panOther;
    ToggleGroup mat = new ToggleGroup();
    @FXML
    GridPane panColor;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cball.setOpacity(0);
        loadMetalGrid();
        loadWoodGrid();
        loadRubberGrid();
        loadOtherGrid();
        loadLeatherGrid();
        loadPlasticGrid();
        loadColorGrid();
        
    }    
    
    
        @FXML
    public void focusInAction(MouseEvent evt){
        stall((Node)evt.getSource(),50,0.1);
    }
    
    @FXML
    public void focusOutAction(MouseEvent evt){
        stall((Node)evt.getSource(),50,-0.10);
    }
    
    public void ftall(Node n,int t,double from, double to){
        FadeTransition ft = new FadeTransition();
        ft.setNode(n);
        ft.setDuration(Duration.millis(t));
        ft.setFromValue(from);
        ft.setToValue(to);
        ft.play();    
    }
    
    public void stall(Node n,int t,double a){
        ScaleTransition stall = new ScaleTransition();
        stall.setNode(n);
        stall.setByX(a);
        stall.setByY(a);
        stall.setDuration(Duration.millis(t));
        stall.play();
    }
    
    public void loadMetalGrid(){
        File dir = new File("src\\images\\textures\\metal");
            if(dir.isDirectory()){
                ImageView pic;
                RadioButton bt;
                panMetal.setHgap(5);
                panMetal.setVgap(5);
                panMetal.setPadding(new Insets(10));
                File f[] = dir.listFiles();
                int imageCol=0;
                int imageRow=2;
                for(int i=0;i<f.length;i++){
                    System.out.println(f[i].getName());
                    pic = new ImageView(new Image("/images/textures/metal/"+f[i].getName()));
                    pic.setFitHeight(110);
                    pic.setFitWidth(110);
                    bt= new RadioButton("");
                    bt.setGraphic(pic);
                    bt.setToggleGroup(mat);
                    panMetal.add(bt, imageCol, imageRow);
                    imageCol++;
                    if(imageCol > 1){
                      // Reset Column
                      imageCol=0;
                      // Next Row
                      imageRow++;
                    }
                }
            }
            
    }
    
    public void loadWoodGrid(){
        File dir = new File("src\\images\\textures\\wood");
            if(dir.isDirectory()){
                ImageView pic;
                RadioButton bt;
                panWood.setHgap(5);
                panWood.setVgap(5);
                panWood.setPadding(new Insets(10));
                File f[] = dir.listFiles();
                int imageCol=0;
                int imageRow=2;
                for(int i=0;i<f.length;i++){
                    System.out.println(f[i].getName());
                    pic = new ImageView(new Image("/images/textures/wood/"+f[i].getName()));
                    pic.setFitHeight(110);
                    pic.setFitWidth(110);
                    bt= new RadioButton("");
                    bt.setGraphic(pic);
                    bt.setToggleGroup(mat);
                    panWood.add(bt, imageCol, imageRow);
                    imageCol++;
                    if(imageCol > 1){
                      // Reset Column
                      imageCol=0;
                      // Next Row
                      imageRow++;
                    }
                }
            }
    }
    
    public void loadRubberGrid(){
        File dir = new File("src\\images\\textures\\rubber");
            if(dir.isDirectory()){
                ImageView pic;
                RadioButton bt;
                panGoma.setHgap(5);
                panGoma.setVgap(5);
                panGoma.setPadding(new Insets(10));
                File f[] = dir.listFiles();
                int imageCol=0;
                int imageRow=2;
                for(int i=0;i<f.length;i++){
                    System.out.println(f[i].getName());
                    pic = new ImageView(new Image("/images/textures/rubber/"+f[i].getName()));
                    pic.setFitHeight(110);
                    pic.setFitWidth(110);
                    bt= new RadioButton("");
                    bt.setGraphic(pic);
                    bt.setToggleGroup(mat);
                    panGoma.add(bt, imageCol, imageRow);
                    imageCol++;
                    if(imageCol > 1){
                      // Reset Column
                      imageCol=0;
                      // Next Row
                      imageRow++;
                    }
                }
            }
    }
    
    public void loadPlasticGrid(){
        File dir = new File("src\\images\\textures\\plastic");
            if(dir.isDirectory()){
                ImageView pic;
                RadioButton bt;
                panPlastic.setHgap(5);
                panPlastic.setVgap(5);
                panPlastic.setPadding(new Insets(10));
                File f[] = dir.listFiles();
                int imageCol=0;
                int imageRow=2;
                for(int i=0;i<f.length;i++){
                    //System.out.println(f[i].getName());
                    pic = new ImageView(new Image("/images/textures/plastic/"+f[i].getName()));
                    pic.setFitHeight(110);
                    pic.setFitWidth(110);
                    bt= new RadioButton("");
                    bt.setGraphic(pic);
                    bt.setToggleGroup(mat);
                    panPlastic.add(bt, imageCol, imageRow);
                    imageCol++;
                    if(imageCol > 1){
                      // Reset Column
                      imageCol=0;
                      // Next Row
                      imageRow++;
                    }
                }
            }
    }
    
    public void loadLeatherGrid(){
        File dir = new File("src\\images\\textures\\leather");
        
            if(dir.isDirectory()){
                RadioButton bt;
                ImageView pic;
                panLeather.setHgap(5);
                panLeather.setVgap(5);
                panLeather.setPadding(new Insets(10));
                File f[] = dir.listFiles();
                int imageCol=0;
                int imageRow=2;
                for(int i=0;i<f.length;i++){
                    System.out.println(f[i].getName());
                    pic = new ImageView(new Image("/images/textures/leather/"+f[i].getName()));
                    pic.setFitHeight(110);
                    pic.setFitWidth(110);
                    bt = new RadioButton("");
                    bt.setGraphic(pic);
                    bt.setToggleGroup(mat);
                    panLeather.add(bt, imageCol, imageRow);
                    imageCol++;
                    if(imageCol > 1){
                      // Reset Column
                      imageCol=0;
                      // Next Row
                      imageRow++;
                    }
                }
            }
    }
    
    public void loadOtherGrid(){
        File dir = new File("src\\images\\textures\\other");
            if(dir.isDirectory()){
                ImageView pic;
                RadioButton bt;
                panOther.setHgap(5);
                panOther.setVgap(5);
                panOther.setPadding(new Insets(10));
                File f[] = dir.listFiles();
                int imageCol=0;
                int imageRow=2;
                for(int i=0;i<f.length;i++){
                    System.out.println(f[i].getName());
                    pic = new ImageView(new Image("/images/textures/other/"+f[i].getName()));
                    pic.setFitHeight(110);
                    pic.setFitWidth(110);
                    bt= new RadioButton("");
                    bt.setGraphic(pic);
                    bt.setToggleGroup(mat);
                    panOther.add(bt, imageCol, imageRow);
                    imageCol++;
                    if(imageCol > 1){
                      // Reset Column
                      imageCol=0;
                      // Next Row
                      imageRow++;
                    }
                }
            }
    }
    
    public void loadColorGrid(){
        File dir = new File("src\\images\\textures\\color");
            if(dir.isDirectory()){
                ImageView pic;
                RadioButton bt;
                panColor.setHgap(5);
                panColor.setVgap(5);
                panColor.setPadding(new Insets(10));
                File f[] = dir.listFiles();
                int imageCol=0;
                int imageRow=2;
                for(int i=0;i<f.length;i++){
                    System.out.println(f[i].getName());
                    pic = new ImageView(new Image("/images/textures/color/"+f[i].getName()));
                    pic.setFitHeight(110);
                    pic.setFitWidth(110);
                    bt= new RadioButton("");
                    bt.setGraphic(pic);
                    bt.setToggleGroup(mat);
                    panColor.add(bt, imageCol, imageRow);
                    imageCol++;
                    if(imageCol > 1){
                      // Reset Column
                      imageCol=0;
                      // Next Row
                      imageRow++;
                    }
                }
            }
    }
    
    @FXML
    public void onClickAction(MouseEvent evt){
        GridPane pan = (GridPane) evt.getSource();
        int col=0;
        
        
    }
    
    
}
