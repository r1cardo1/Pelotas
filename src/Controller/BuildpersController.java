/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import TAD.Empresa;
import TAD.Material;
import TAD.Pelota;
import TAD.TVEmpresa;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;
import javax.imageio.ImageIO;

/**
 * FXML Controller class
 *
 * @author Ricardo
 */
public class BuildpersController implements Initializable {

    @FXML
    GridPane panPred;
    @FXML
    Label msg;
    @FXML
    TextField name;
    @FXML
    Label pres;
    @FXML
    Label material;
    @FXML
    Label tamano;
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
    int presion=0;
    static TVEmpresa temp;
    String direc;
    
    
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
        loadPredesign();
        mat.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
            public void changed(ObservableValue<? extends Toggle> ov,
                Toggle toggle, Toggle new_toggle) {
                    if (new_toggle!=null){
                        RadioButton bt = (RadioButton)new_toggle;
                        texturize(path.get(file.indexOf(bt.getText()))+bt.getText());
                        direc=path.get(file.indexOf(bt.getText()))+bt.getText();
                    }
            }
        });
        cball.setRotationAxis(Rotate.X_AXIS);
        cball.rotateProperty().add(30);
        cball.setRotationAxis(Rotate.Y_AXIS);
        initSBall();
        initCBall();
        pres.setText(Integer.toString(presion)+" Lbs.");
        
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
        File dir = new File("src\\images\\textures\\madera");
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
                    pic = new ImageView(new Image("/images/textures/madera/"+f[i].getName()));
                    pic.setFitHeight(110);
                    pic.setFitWidth(110);
                    file.add(f[i].getName());
                    path.add("/images/textures/madera/");
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
        File dir = new File("src\\images\\textures\\goma");
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
                    pic = new ImageView(new Image("/images/textures/goma/"+f[i].getName()));
                    pic.setFitHeight(110);
                    pic.setFitWidth(110);
                    file.add(f[i].getName());
                    path.add("/images/textures/goma/");
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
        File dir = new File("src\\images\\textures\\plastico");
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
                    pic = new ImageView(new Image("/images/textures/plastico/"+f[i].getName()));
                    pic.setFitHeight(110);
                    pic.setFitWidth(110);
                    file.add(f[i].getName());
                    path.add("/images/textures/plastico/");
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
        File dir = new File("src\\images\\textures\\cuero");
        
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
                    pic = new ImageView(new Image("/images/textures/cuero/"+f[i].getName()));
                    pic.setFitHeight(110);
                    pic.setFitWidth(110);
                    file.add(f[i].getName());
                    path.add("/images/textures/cuero/");
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
        File dir = new File("src\\images\\textures\\otro");
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
                    pic = new ImageView(new Image("/images/textures/otro/"+f[i].getName()));
                    pic.setFitHeight(110);
                    pic.setFitWidth(110);
                    file.add(f[i].getName());
                    path.add("/images/textures/otro/");
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
    
    public void loadPredesign(){
        File dir = new File("src\\images\\textures\\predesign");
            if(dir.isDirectory()){
                ImageView pic;
                RadioButton bt;
                panPred.setHgap(5);
                panPred.setVgap(5);
                panPred.setPadding(new Insets(10));
                File f[] = dir.listFiles();
                int imageCol=0;
                int imageRow=2;
                for(int i=0;i<f.length;i++){
                    System.out.println(f[i].getName());
                    pic = new ImageView(new Image("/images/textures/predesign/"+f[i].getName()));
                    pic.setFitHeight(110);
                    pic.setFitWidth(110);
                    file.add(f[i].getName());
                    path.add("/images/textures/predesign/");
                    bt= new RadioButton(f[i].getName());
                    bt.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
                    bt.setGraphic(pic);
                    bt.setToggleGroup(mat);
                    panPred.add(bt, imageCol, imageRow);
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
    String[] mat = path.split("/");
    material.setText(mat[mat.length-2]);
    }
    
    @FXML
    public void sizeUpAction(ActionEvent evt){
        if(osball){
            sball.setRadius(sball.getRadius()+2);
            tamano.setText(Double.toString(sball.getRadius())+" Cm");
        }
        else{
            cball.setWidth(cball.getWidth()+2);
            cball.setHeight(cball.getHeight()+2);
            cball.setDepth(cball.getDepth()+2);
            tamano.setText(Double.toString(cball.getWidth())+" Cm");
        }
        
    }
    
    @FXML
    public void sizeDownAction(ActionEvent evt){
        if(osball){
            sball.setRadius(sball.getRadius()-2);
            tamano.setText(Double.toString(sball.getRadius())+" Cm");
        }
        else{
            cball.setWidth(cball.getWidth()-2);
            cball.setHeight(cball.getHeight()-2);
            cball.setDepth(cball.getDepth()-2);
            tamano.setText(Double.toString(cball.getWidth())+" Cm");
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
            tamano.setText(Double.toString(cball.getWidth())+" Cm");
        }else{
            sball.setOpacity(1);
            cball.setOpacity(0);
            osball=true;
            tamano.setText(Double.toString(sball.getRadius())+" Cm");
        }
        
    }
    
    @FXML
    public void presUp(ActionEvent evt){
        presion+=5;
        pres.setText(Integer.toString(presion)+" Lbs.");
    }
    
    @FXML
    public void presDown(ActionEvent evt){
        presion-=5;
        pres.setText(Integer.toString(presion)+" Lbs.");
    }
    
    public void saveAction(ActionEvent evt) throws IOException, ClassNotFoundException{          
        if(!name.getText().isEmpty()){
        Empresa cp;
        Boolean opc = true;
        ArrayList<Empresa> list = new ArrayList<Empresa>();
        if(!new File("C:\\AppPelotas").isDirectory())
            new File("C:\\AppPelotas").mkdirs();
        File f = new File("C:\\AppPelotas\\dbCompany");
        
        if(new File("C:\\AppPelotas\\dbCompany").isFile()){
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            list = (ArrayList<Empresa>)ois.readObject();
            ois.close();
        }        
        
        for(int i=0;i<list.size();i++){
            if(list.get(i).getRif().equals(temp.getRif())){
                System.out.println("YES IT FIT");
                if(!list.get(i).listaPelotas.isEmpty())
                for(int j=0;j<list.get(i).listaPelotas.size();j++){
                    if(list.get(i).listaPelotas.get(j).nombre.equals(name.getText())){
                        msg.setText("Error, la pelota ya existe");
                        msg.setOpacity(1);
                        opc=false;
                    }
                    }
                    if(opc){
                        String[] nombre = direc.split("/");
                        String forma;
                        if(osball)
                            forma="Esfera";
                        else
                            forma="Cubica";
                        if(osball)
                            list.get(i).listaPelotas.add(new Pelota(name.getText(),new Material(nombre[nombre.length-2],direc),forma,presion,presion,(int) sball.getRadius()));
                        else
                            list.get(i).listaPelotas.add(new Pelota(name.getText(),new Material(nombre[nombre.length-2],direc),forma,presion,presion,(int) cball.getWidth()));
                
                        FileOutputStream fos = new FileOutputStream(f);
                        ObjectOutputStream oos = new ObjectOutputStream(fos);
                        oos.writeObject(list);
                        oos.close();
                
                        WritableImage im = sball.snapshot(null,null);        
                        BufferedImage image =SwingFXUtils.fromFXImage(im,null);        
                        BufferedImage imageRGB = new BufferedImage(image.getWidth(),image.getHeight(),BufferedImage.OPAQUE);
                        Graphics2D graphics = imageRGB.createGraphics();
                        graphics.drawImage(image,0,0,null);
                        ImageIO.write(imageRGB,"jpg",new File("src/images/data/"+name.getText()+".jpg"));
                        graphics.dispose();                        
                        msg.setText("Guardado con Exito.");
                        msg.setOpacity(1);
                    }
            }
        }
        }
        
    }
    
    
}
