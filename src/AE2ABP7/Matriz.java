/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cl.unab.android.ae2abp7.ae2abp7;

import java.util.Random;

/**
 *
 * @author Usuario
 */
public class Matriz {

    //permite cargar en forma aleatoria los datos de una matriz de 5x3 (filasxcolumnas)
    public void asignarValores() {
        Random rnd = new Random();

        // 5 filas, 3 columnas
        int[][] matriz = new int[5][3];
        int [][] matrizTraspuesta = new int [3][5];

        // Llenar la matriz con números aleatorios del 1 al 100
        System.out.println("Los valores de la matriz son: ");
        for (int i = 0; i < 5; i++) { // filas (días)
            for (int j = 0; j < 3; j++) { // columnas (turnos)
                matriz[i][j] = rnd.nextInt(100) + 1;
            }

            System.out.println("Fila " + i + " | " + matriz[i][0] + " - " + matriz[i][1] + " - " + matriz[i][2]);
        }

        //ahora llenaremos la matrizTraspuesta
        System.out.println("Los valores de la matriz traspuesta son: ");
        for (int i = 0; i < 3; i++) { // columnas (turnos)
            for (int j = 0; j < 5; j++) { // filas (días)
                matrizTraspuesta[i][j] = matriz[j][i];
            }

            System.out.println("Fila " + i + " | " + matrizTraspuesta[i][0] + " - " + matrizTraspuesta[i][1] + " - " + matrizTraspuesta[i][2] + " - " + matrizTraspuesta[i][3] + " - " + matrizTraspuesta[i][4]);
        }
    }
}
