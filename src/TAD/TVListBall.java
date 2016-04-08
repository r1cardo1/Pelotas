/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TAD;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author Ricardo
 */
public class TVListBall {
    SimpleStringProperty name;
    SimpleStringProperty rif;
    ImageView preview;

    public TVListBall(String name, String rif, String preview) {
        this.name = new SimpleStringProperty(name);
        this.rif = new SimpleStringProperty(rif);
        this.preview = new ImageView(new Image("/images/data/"+name+".jpg"));
    }

    public String getName() {
        return name.get();
    }

    public String getRif() {
        return rif.get();
    }

    public ImageView getPreview() {
        return preview;
    }

    public void setName(SimpleStringProperty name) {
        this.name = name;
    }

    public void setRif(SimpleStringProperty rif) {
        this.rif = rif;
    }

    public void setPreview(ImageView preview) {
        this.preview = preview;
    }
    
}
