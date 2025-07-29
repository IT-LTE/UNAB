package cl.lte;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;


public class Usuario implements Asesoria {
    private String nombre;
    private String fechaNacimiento;
    private int run;

    public Usuario(String nombre, String fechaNacimiento, int run) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.run = run;
    }

    public int getRun() {
        return run;
    }

    @Override
    public void analizarUsuario() {
        System.out.println("Analizando usuario: ");
        System.out.println("Nombre: " + nombre);
        System.out.println("RUN: " + run);
    }

    // Lógica para calcular y mostrar la edad del usuario
    public String mostrarEdad(){
        // Asumiendo que fechaNacimiento está en formato "dd/MM/yyyy"
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        // Aquí se debería calcular la edad basándose en la fecha de nacimiento
        LocalDate fechaNac = LocalDate.parse(fechaNacimiento, dateFormatter);
        int edad = Period.between(fechaNac, LocalDate.now()).getYears();
        // Retornar la edad como un String
        return "El usuario tiene " + edad + " años.";
    }

}