/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TAD;

/**
 *
 * @author este_
 */
public class Material {
    String nombre;
    String file;

    public Material(String nombre, String file) {
        this.nombre = nombre;
        this.file = file;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFile() {
        return file;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFile(String file) {
        this.file = file;
    }
    
    
}
