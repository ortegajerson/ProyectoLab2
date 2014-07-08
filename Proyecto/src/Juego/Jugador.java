package Juego;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sebastian
 */
public class Jugador {
    
    String nombre;
    String puntaje;
    String record;

    public Jugador(String nombre, String puntaje, String record) {
        this.nombre=nombre;
        this.puntaje=puntaje;
        this.record=record;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPuntaje() {
        return puntaje;
    }

    public String getRecord() {
        return record;
        
    }

 
    
    
}
