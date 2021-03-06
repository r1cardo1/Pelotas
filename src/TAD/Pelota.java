/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TAD;

import java.io.Serializable;

/**
 *
 * @author este_
 */
public class Pelota implements Serializable{
    public String nombre;
    private Material material;
    private String relleno;
    private String forma;
    private String color;
    private int freb;
    private int presion;
    private int peso;
    private int medidas;

    public Pelota(String nombre,Material material, String forma,int presion, int peso, int medidas) {
        this.nombre=nombre;
        this.material = material;
        this.presion = presion;
        this.peso = peso;
        this.medidas = medidas;
    }

    public Material getMaterial() {
        return material;
    }

    public String getRelleno() {
        return relleno;
    }

    public String getForma() {
        return forma;
    }

    public String getColor() {
        return color;
    }

    public int getFreb() {
        return freb;
    }

    public int getPresion() {
        return presion;
    }

    public int getPeso() {
        return peso;
    }

    public int getMedidas() {
        return medidas;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public void setRelleno(String relleno) {
        this.relleno = relleno;
    }

    public void setForma(String forma) {
        this.forma = forma;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setFreb(int freb) {
        this.freb = freb;
    }

    public void setPresion(int presion) {
        this.presion = presion;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public void setMedidas(int medidas) {
        this.medidas = medidas;
    }
    
    
}
