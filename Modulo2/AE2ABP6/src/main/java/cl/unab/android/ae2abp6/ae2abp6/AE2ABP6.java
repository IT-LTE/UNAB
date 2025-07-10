/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package cl.unab.android.ae2abp6.ae2abp6;

/**
 *
 * @author Alejandra Flaño
 * Fecha 7/7/2025
 * 
 * Declarar una matriz de tamaño 4x4. 
 * Los valores pueden: 
 * • Ingresarse manualmente por el usuario, o 
 * • Asignarse directamente en el código para facilitar la prueba. 
 * 2. Recorrer la matriz para: 
 * • Calcular la suma de los valores en la diagonal principal (cuando fila = columna). 
 * • Calcular la suma de la zona superior (cuando columna > fila). 
 * • Calcular la suma de la zona inferior (cuando fila > columna).
 * 3. Al finalizar, mostrar: 
 * • El valor total de cada una de las tres zonas. 
 * • Un mensaje indicando si la suma de la zona superior e inferior 
 *   es menor que la diagonal principal, o si no se cumple la condición.
 * 
 */
public class AE2ABP6 {

    public static void main(String[] args) {
        
        // Los valores pueden: 
 //* • Ingresarse manualmente por el usuario
        int[][] matriz = {
            {4, 3, 2, 1},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };

        // Inicializar variables para las sumas
        int sumaDiagonal = 0;
        int sumaSuperior = 0;
        int sumaInferior = 0;

        // Recorrer la matriz y calcular las sumas
        for (int i = 0; i < 4; i++) {               ////fila
            for (int j = 0; j < 4; j++) {           ////columna
                if (i == j) {                       //Diagonal
                    sumaDiagonal += matriz[i][j];
                } else if (j > i) {                 // zona superior
                    sumaSuperior += matriz[i][j];
                } else if (i > j) {                 //zona inferior
                    sumaInferior += matriz[i][j];
                }
            }
        }

        // Despliege de los resultados los resultados
        System.out.println("Suma diagonal principal: " + sumaDiagonal);
        System.out.println("Suma zona superior: " + sumaSuperior);
        System.out.println("Suma zona inferior: " + sumaInferior);

        // Evaluar la condición final
        if ((sumaSuperior + sumaInferior) < sumaDiagonal) {
            System.out.println("La suma de las zonas superior e inferior es menor que la diagonal .");
        } else {
            System.out.println(" La suma de las zonas superior e inferior es mayor que la diagonal principal.");
        }
    }
}
