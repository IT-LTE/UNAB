package cl.lte;

import java.util.ArrayList;

public class Contenedor {
    private ArrayList<Asesoria> usuarios;
    private ArrayList<Capacitacion> capacitaciones;

    public Contenedor() {
        usuarios = new ArrayList<>();
        capacitaciones = new ArrayList<>();
    }

    public void agregar_cliente(Cliente cliente) {
        usuarios.add(cliente);
    }

    public void agregar_profesional(Profesional profesional) {
        usuarios.add(profesional);
    }

    public void agregar_administrativo(Administrativo administrativo) {
        usuarios.add(administrativo);
    }

    public void agregar_capacitacion(Capacitacion capacitacion) {
        capacitaciones.add(capacitacion);
    }

    public boolean eliminarUsuario(int run) {
        // Elimina cualquier objeto en la lista que sea un Usuario y que tenga el mismo Run
        return usuarios.removeIf(usuario -> {
            if (usuario instanceof Usuario) {
                return ((Usuario) usuario).getRun() == run;
            }
            return false;
        });
    }

    public void listarUsuarios(){
        for(Asesoria usuario : usuarios) {
            usuario.analizarUsuario();
        }
    }

    public void listar_usuarios_por_tipo(String tipo) {
        for (int i = 0; i < usuarios.size(); i++) {
            Asesoria usuario = usuarios.get(i);
            String clase = usuario.getClass().getSimpleName();
            if (tipo.isBlank() || tipo.equalsIgnoreCase(clase)) {
                usuario.analizarUsuario();
            }
        }
    }

    public void listar_capacitacion() {
        for (int i = 0; i < capacitaciones.size(); i++) {
            Capacitacion cap = capacitaciones.get(i);
            String texto = cap.toString();
            System.out.println(texto);
        }
    }

    public boolean existeUsuario(int run) {
        for (Asesoria usuario : usuarios) {
            if (usuario instanceof Usuario && ((Usuario) usuario).getRun() == run) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Asesoria> getUsuarios() {
        return usuarios;
    }

    public ArrayList<Capacitacion> getCapacitaciones() {
        return capacitaciones;
    }
}
