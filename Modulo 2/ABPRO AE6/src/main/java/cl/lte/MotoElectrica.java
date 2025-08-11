package cl.lte;

// Moto electrica: funciona con bateria
public class MotoElectrica extends VehiculoLogistico implements Energizable, Operativo {

    public MotoElectrica(String idVehiculo, double capacidadCargaKg, String ubicacionActual, double velocidadPromedioKmH) {
        super(idVehiculo, capacidadCargaKg, ubicacionActual, velocidadPromedioKmH);
    }

    @Override
    public void desplazar(String destino) {
        System.out.println("Moto electrica " + idVehiculo + " se desplaza desde " + ubicacionActual + " a " + destino);
        ubicacionActual = destino;
    }

    @Override
    public void verificarEstado() {
        System.out.println("Verificando sistema electrico y frenos de la moto " + idVehiculo);
    }

    @Override
    public void recargar() {
        System.out.println("Recargando bateria de la moto " + idVehiculo);
    }

    @Override
    public void calcularDesgaste() {
        System.out.println("Calculando desgaste de la bateria y llantas de la moto " + idVehiculo);
    }

    @Override
    public void registrarEntrega() {
        System.out.println("Entrega registrada por la moto electrica " + idVehiculo);
    }
}
