package cl.lte;

import java.util.ArrayList;
import java.util.List;

// Clase que gestiona la simulacion de la distribucion
public class SimuladorDistribucion {

    private List<VehiculoLogistico> flota;
    private List<RutaEntrega> rutas;

    public SimuladorDistribucion() {
        flota = new ArrayList<>();
        rutas = new ArrayList<>();
    }

    // Agregar vehiculos a la flota
    public void agregarVehiculo(VehiculoLogistico vehiculo) {
        flota.add(vehiculo);
    }

    // Agregar rutas disponibles
    public void agregarRuta(RutaEntrega ruta) {
        rutas.add(ruta);
    }

    // Mostrar todos los vehiculos
    public void mostrarFlota() {
        System.out.println("=== Flota de vehiculos ===");
        for (int i = 0; i < flota.size(); i++) {
            VehiculoLogistico v = flota.get(i);
            System.out.println((i + 1) + ". " + v.getClass().getSimpleName() +
                    " | ID: " + v.getIdVehiculo() +
                    " | Ubicacion: " + v.getUbicacionActual() +
                    " | Capacidad: " + v.getCapacidadCargaKg() + " kg");
        }
    }

    // Mostrar todas las rutas
    public void mostrarRutas() {
        System.out.println("=== Rutas disponibles ===");
        for (int i = 0; i < rutas.size(); i++) {
            System.out.println((i + 1) + ". " + rutas.get(i));
        }
    }

    // Asignar una ruta a un vehiculo y simular entrega
    public void asignarYSimularEntrega(int indiceVehiculo, int indiceRuta) {
        if (indiceVehiculo < 1 || indiceVehiculo > flota.size() ||
                indiceRuta < 1 || indiceRuta > rutas.size()) {
            System.out.println("Indices no validos");
            return;
        }

        VehiculoLogistico vehiculo = flota.get(indiceVehiculo - 1);
        RutaEntrega ruta = rutas.get(indiceRuta - 1);

        // Simulacion
        vehiculo.verificarEstado();
        vehiculo.desplazar(ruta.getDestino());

        if (vehiculo instanceof Energizable) {
            ((Energizable) vehiculo).recargar();
        }
        if (vehiculo instanceof CombustibleFosil) {
            ((CombustibleFosil) vehiculo).repostar();
        }

        if (vehiculo instanceof Operativo) {
            ((Operativo) vehiculo).calcularDesgaste();
            ((Operativo) vehiculo).registrarEntrega();
        }

        System.out.println("Entrega completada: " + vehiculo.getIdVehiculo());
    }
}
