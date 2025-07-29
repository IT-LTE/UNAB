package cl.lte;

import java.util.ArrayList;

public class Contenedor {
    private ArrayList<Asesoria> lusuarios;
    private ArrayList<Capacitacion> lcapacitaciones;

    public void agregar_cliente(Cliente cliente){
        lusuarios.add(cliente);
    }
    public void agregar_profesional(Profesional profesional){
        lusuarios.add(profesional);
    }
    public void agregar_profesional(Administrativo administrativo){
        lusuarios.add(administrativo);
    }

    public void agregar_capacitacion(Capacitacion capacitacion){
        lcapacitaciones.add(capacitacion);
    }

    public void eliminarUsuario(int run) {
        lusuarios.removeIf(u -> (u instanceof Usuario) && ((Usuario) u).getRun() == run);
    }
    
    public void Listar_usuarios(String tipo){
        for(int i= 0; i<lusuarios.size(); i++){
            Asesoria usu = lusuarios.get(i);
            String clase = usu.getClass().getSimpleName();
            if(tipo.isBlank()|| tipo.equalsIgnoreCase(clase) ){
                String texto = usu.toString();
                System.out.println(texto);
            }
        }
    }
    public void listar_capacitacion(){
        for(int i= 0; i<lcapacitaciones.size(); i++){
            Capacitacion cp=lcapacitaciones.get(i);
            String texto = cp.toString();
            System.out.println(texto);
        }
    }
}
