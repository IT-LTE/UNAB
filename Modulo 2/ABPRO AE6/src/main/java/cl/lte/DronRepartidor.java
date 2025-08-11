package cl.lte;

// Dron repartidor: funciona con bateria
public class DronRepartidor extends VehiculoLogistico implements Energizable, Operativo {

    public DronRepartidor(String idVehiculo, double capacidadCargaKg, String ubicacionActual, double velocidadPromedioKmH) {
        super(idVehiculo, capacidadCargaKg, ubicacionActual, velocidadPromedioKmH);
    }

    @Override
    public void desplazar(String destino) {
        System.out.println("Dron " + idVehiculo + " volando desde " + ubicacionActual + " hasta " + destino);
        ubicacionActual = destino;
    }

    @Override
    public void verificarEstado() {
        System.out.println("Verificando motores y sistema GPS del dron " + idVehiculo);
    }

    @Override
    public void recargar() {
        System.out.println("Recargando bateria del dron " + idVehiculo);
    }

    @Override
    public void calcularDesgaste() {
        System.out.println("Calculando desgaste de baterias y rotores del dron " + idVehiculo);
    }

    @Override
    public void registrarEntrega() {
        System.out.println("Entrega registrada por el dron " + idVehiculo);
    }
}