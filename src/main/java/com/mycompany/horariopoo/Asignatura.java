/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.horariopoo;


/**
 *
 * @author yago2
 */
public class Asignatura {
    
    private int ID;
    private String Nombre;
    
    
    public Asignatura(int numero, String nombre)
    {
        ID = numero;
        Nombre = nombre;
    }
    
    public int getID(){
        return ID;
    }
    
    public String getNombre(){
        return Nombre;
    }
    
    public String texto(){
        return "Asignatura Teorica {Codigo=%s ,Nombre=%s }".formatted(ID,Nombre);
    }
    
}



