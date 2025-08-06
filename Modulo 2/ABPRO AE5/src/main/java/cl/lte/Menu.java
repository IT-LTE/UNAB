package cl.lte;

import java.util.Scanner;

public class Menu {
    private SistemaAcademico sistema;
    private Scanner sc;

    public Menu(SistemaAcademico sistema, Scanner sc) {
        this.sistema = sistema;
        this.sc = sc;
    }

    public void mostrar() {
        int opcion;
        do {
            System.out.println("\n--- MENU PRINCIPAL ---");
            System.out.println("1. Registrar estudiante");
            System.out.println("2. Registrar docente");
            System.out.println("3. Registrar curso");
            System.out.println("4. Inscribir estudiante en curso");
            System.out.println("5. Asignar nota");
            System.out.println("6. Ver promedio de estudiante");
            System.out.println("7. Ver estudiantes por curso");
            System.out.println("8. Ver cursos con promedio alto");
            System.out.println("9. Ver docentes con mayor carga");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    registrarEstudiante();
                    break;
                case 2:
                    registrarDocente();
                    break;
                case 3:
                    registrarCurso();
                    break;
                case 4:
                    inscribirEstudiante();
                    break;
                case 5:
                    asignarNota();
                    break;
                case 6:
                    verPromedio();
                    break;
                case 7:
                    verEstudiantesCurso();
                    break;
                case 8:
                    verCursosPromedioAlto();
                    break;
                case 9:
                    verDocentesCarga();
                    break;
                case 0:
                    System.out.println("Gracias por usar nuestro sistema");
                    break;
                default:
                    System.out.println("Opcion invalida");
            }

        } while (opcion != 0);
    }

    private void registrarEstudiante() {
        System.out.print("Rut: ");
        String rut = sc.nextLine();
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Carrera: ");
        String carrera = sc.nextLine();
        System.out.print("Anio de ingreso: ");
        int anio = sc.nextInt();
        sc.nextLine();
        sistema.agregarEstudiante(new Estudiante(rut, nombre, carrera, anio));
    }

    private void registrarDocente() {
        System.out.print("Rut: ");
        String rut = sc.nextLine();
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Area: ");
        String area = sc.nextLine();
        sistema.agregarDocente(new Docente(rut, nombre, area));
    }

    private void registrarCurso() {
        System.out.print("Codigo: ");
        String codigo = sc.nextLine();
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Creditos: ");
        int creditos = sc.nextInt();
        sc.nextLine();
        System.out.print("Rut docente: ");
        String rutDocente = sc.nextLine();
        Docente docente = null;
        for (Docente d : sistema.getDocentes()) {
            if (d.getRut().equalsIgnoreCase(rutDocente)) {
                docente = d;
                break;
            }
        }
        if (docente != null) {
            sistema.agregarCurso(new Curso(codigo, nombre, creditos, docente));
        } else {
            System.out.println("Docente no encontrado");
        }
    }

    private void inscribirEstudiante() {
        System.out.print("Rut estudiante: ");
        String rut = sc.nextLine();
        System.out.print("Codigo curso: ");
        String codigo = sc.nextLine();
        sistema.inscribirEstudiante(rut, codigo);
    }

    private void asignarNota() {
        System.out.print("Rut estudiante: ");
        String rut = sc.nextLine();
        System.out.print("Codigo curso: ");
        String codigo = sc.nextLine();
        System.out.print("Nota (1.0 a 7.0): ");
        double nota = sc.nextDouble();
        sc.nextLine();
        sistema.asignarNota(rut, codigo, nota);
    }

    private void verPromedio() {
        System.out.print("Rut estudiante: ");
        String rut = sc.nextLine();
        double promedio = sistema.promedioEstudiante(rut);
        System.out.println("Promedio: " + promedio);
    }

    private void verEstudiantesCurso() {
        System.out.print("Codigo curso: ");
        String codigo = sc.nextLine();
        for (Estudiante e : sistema.listarEstudiantesPorCurso(codigo)) {
            System.out.println(e.getNombre() + " (" + e.getRut() + ")");
        }
    }

    private void verCursosPromedioAlto() {
        for (Curso c : sistema.cursosConPromedioAlto()) {
            System.out.println(c.getNombre() + " (" + c.getCodigo() + ")");
        }
    }

    private void verDocentesCarga() {
        for (Docente d : sistema.docentesConMayorCarga()) {
            System.out.println(d.getNombre() + " - " + d.getArea());
        }
    }
}
