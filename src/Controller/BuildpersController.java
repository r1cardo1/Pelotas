/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import static javafx.animation.Animation.INDEFINITE;
import javafx.animation.FadeTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.beans.property.DoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TabPane;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;
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
    ArrayList<String> file = new ArrayList<>();
    ArrayList<String> path = new ArrayList<>();
    boolean osball = true;
    
    
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
        mat.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
            public void changed(ObservableValue<? extends Toggle> ov,
                Toggle toggle, Toggle new_toggle) {
                    if (new_toggle!=null){
                        RadioButton bt = (RadioButton)new_toggle;
                        texturize(path.get(file.indexOf(bt.getText()))+bt.getText());
                    }
            }
        });
        cball.setRotationAxis(Rotate.X_AXIS);
        cball.rotateProperty().add(30);
        cball.setRotationAxis(Rotate.Y_AXIS);
        initSBall();
        initCBall();
        
        
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
                    file.add(f[i].getName());
                    path.add("/images/textures/metal/");
                    bt= new RadioButton(f[i].getName());
                    bt.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
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
                    file.add(f[i].getName());
                    path.add("/images/textures/wood/");
                    bt= new RadioButton(f[i].getName());
                    bt.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
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
                    file.add(f[i].getName());
                    path.add("/images/textures/rubber/");
                    bt= new RadioButton(f[i].getName());
                    bt.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
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
                    file.add(f[i].getName());
                    path.add("/images/textures/plastic/");
                    bt= new RadioButton(f[i].getName());
                    bt.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
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
                    file.add(f[i].getName());
                    path.add("/images/textures/leather/");
                    bt= new RadioButton(f[i].getName());
                    bt.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
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
                    file.add(f[i].getName());
                    path.add("/images/textures/other/");
                    bt= new RadioButton(f[i].getName());
                    bt.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
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
                    file.add(f[i].getName());
                    path.add("/images/textures/color/");
                    bt= new RadioButton(f[i].getName());
                    bt.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
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
    
    public void texturize(String path){
    PhongMaterial phongMaterial = new PhongMaterial();
    phongMaterial.setDiffuseMap(new Image(getClass().getResource(path).toExternalForm()));
    sball.setMaterial(phongMaterial);
    cball.setMaterial(phongMaterial);
    }
    
    @FXML
    public void sizeUpAction(ActionEvent evt){
        if(osball)
            sball.setRadius(sball.getRadius()+2);
        else{
            cball.setWidth(cball.getWidth()+2);
            cball.setHeight(cball.getHeight()+2);
            cball.setDepth(cball.getDepth()+2);
        }
    }
    
    @FXML
    public void sizeDownAction(ActionEvent evt){
        if(osball)
            sball.setRadius(sball.getRadius()-2);
        else{
            cball.setWidth(cball.getWidth()-2);
            cball.setHeight(cball.getHeight()-2);
            cball.setDepth(cball.getDepth()-2);
        }
    }
    
    public void initSBall(){
        RotateTransition rts = new RotateTransition();
        rts.setNode(sball);
        sball.setRotationAxis(Rotate.Y_AXIS);
        rts.setDuration(Duration.seconds(10));
        rts.setCycleCount(INDEFINITE);
        rts.setByAngle(360);
        rts.play();
    }

    
    public void initCBall(){
        RotateTransition rtc = new RotateTransition();
        rtc.setNode(cball);
        rtc.setAxis(Rotate.Y_AXIS);
        rtc.setDuration(Duration.seconds(10));
        rtc.setCycleCount(INDEFINITE);
        rtc.setByAngle(360);
        rtc.play();
    }
    

    @FXML
    public void changeBall(){
        if(osball){
            sball.setOpacity(0);
            cball.setOpacity(1);
            osball=false;
            
        }else{
            sball.setOpacity(1);
            cball.setOpacity(0);
            osball=true;
        }
        
    }
}
