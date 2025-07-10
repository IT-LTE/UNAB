/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cl.unab.android.ae3abp4.ae3abp4;

import java.util.ArrayList;

/**
 *
 * @author Alejandra Flaño fecha 26/06/2025 Clase alumno
 */
public class Alumno {

    public String nombre;
    public ArrayList<Double> notas;
    public double promedio;  

    //constructor
    public Alumno(String nombre) {
        this.nombre = nombre;
        this.notas = new ArrayList<>();
        this.promedio = 0.0;  
    }
}
