package cl.lte;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Usuario implements Asesoria {
    private String nombre;
    private String fechaNacimiento;
    private int run;

    public Usuario(String nombre, String fechaNacimiento, int run) {
        setNombre(nombre);
        setFechaNacimiento(fechaNacimiento);
        setRun(run);
    }

    
    @Override
    public void analizarUsuario() {
        System.out.println("\nAnalizando usuario: ");
        System.out.println("Nombre: " + nombre);
        System.out.println("RUN: " + run);
    }

    // Lógica para calcular y mostrar la edad del usuario
    public String mostrarEdad() {
        // Asumiendo que fechaNacimiento está en formato "dd/MM/yyyy"
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        // Aquí se debería calcular la edad basándose en la fecha de nacimiento
        LocalDate fechaNac = LocalDate.parse(fechaNacimiento, dateFormatter);
        int edad = Period.between(fechaNac, LocalDate.now()).getYears();
        // Retornar la edad como un String
        return "El usuario tiene " + edad + " años.";
    }

    public int getRun() {
        return run;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre != null && nombre.length() >= 10 && nombre.length() <= 50) {
            this.nombre = nombre;
        } else {
            System.out.println("Nombre debe tener entre 10 y 50 caracteres.");
        }
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        // Validar formato de fecha (dd/MM/yyyy)
        if (fechaNacimiento != null
                && fechaNacimiento.matches("^([0][1-9]|[12][0-9]|3[01])/([0][1-9]|1[0-2])/\\d{4}$")) {
            this.fechaNacimiento = fechaNacimiento;
        } else {
            System.out.println("Fecha de nacimiento debe estar en formato dd/MM/yyyy.");
        }
    }

    public void setRun(int run) {
        if (run < 99999999 && run > 0) {
            this.run = run;
        } else {
            System.out.println("RUN debe ser un número válido menor a 99999999.");
        }
    }

}