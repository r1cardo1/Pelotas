/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TAD;

import java.io.Serializable;
import javafx.scene.image.Image;

/**
 *
 * @author este_
 */
public class Empresa implements Serializable{
    private String nombre;
    private String rif;
    private String direccion;
    private int logo;

    public Empresa(String nombre, String rif, String direccion, int logo) {
        this.nombre = nombre;
        this.rif = rif;
        this.direccion = direccion;
        this.logo = logo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRif() {
        return rif;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getLogo() {
        return logo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRif(String rif) {
        this.rif = rif;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }
    
    
}
