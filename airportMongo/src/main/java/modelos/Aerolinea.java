/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import org.bson.types.ObjectId;

/**
 *
 * @author ID145
 */
public class Aerolinea {
    private ObjectId id;
    private String nombre;
    private String pais;
    private String moneda;
    private boolean economica;
    
    public Aerolinea(){
        
    }
    
     public Aerolinea(String nombre, String pais, String moneda, boolean economica) {
        this.nombre = nombre;
        this.pais = pais;
        this.moneda = moneda;
        this.economica = economica;
    }

    public Aerolinea(ObjectId id, String nombre, String pais, String moneda, boolean economica) {
        this.id = id;
        this.nombre = nombre;
        this.pais = pais;
        this.moneda = moneda;
        this.economica = economica;
    }
    
}
