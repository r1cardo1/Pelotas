/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TAD;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author este_
 */
public class TVEmpresa {
    SimpleStringProperty nombre;
    SimpleStringProperty rif;
    SimpleStringProperty direccion;
    SimpleStringProperty logo;

    public TVEmpresa(String nombre, String rif, String direccion, String logo) {
        this.nombre = new SimpleStringProperty(nombre);
        this.rif = new SimpleStringProperty(rif);
        this.direccion = new SimpleStringProperty(direccion);
        this.logo = new SimpleStringProperty(logo);
    }

    public String getNombre() {
        return nombre.get();
    }

    public String getRif() {
        return rif.get();
    }

    public String getDireccion() {
        return direccion.get();
    }

    public String getLogo() {
        return logo.get();
    }

    public void setNombre(String nombre) {
        this.nombre = new SimpleStringProperty(nombre);
    }

    public void setRif(String rif) {
        this.rif = new SimpleStringProperty(rif);
    }

    public void setDireccion(String direccion) {
        this.direccion = new SimpleStringProperty(direccion);
    }

    public void setLogo(String logo) {
        this.logo = new SimpleStringProperty(logo);
    }
    
    
}
