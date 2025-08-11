package cl.lte;

// Camion refrigerado: funciona con combustible fosil
public class CamionRefrigerado extends VehiculoLogistico implements CombustibleFosil, Operativo {

    public CamionRefrigerado(String idVehiculo, double capacidadCargaKg, String ubicacionActual, double velocidadPromedioKmH) {
        super(idVehiculo, capacidadCargaKg, ubicacionActual, velocidadPromedioKmH);
    }

    @Override
    public void desplazar(String destino) {
        System.out.println("Camion refrigerado " + idVehiculo + " se desplaza desde " + ubicacionActual + " a " + destino);
        ubicacionActual = destino;
    }

    @Override
    public void verificarEstado() {
        System.out.println("Verificando sistema de refrigeracion y estado mecanico del camion " + idVehiculo);
    }

    @Override
    public void repostar() {
        System.out.println("Repostando combustible del camion refrigerado " + idVehiculo);
    }

    @Override
    public void calcularDesgaste() {
        System.out.println("Calculando desgaste de motor y sistema de refrigeracion del camion " + idVehiculo);
    }

    @Override
    public void registrarEntrega() {
        System.out.println("Entrega registrada por el camion refrigerado " + idVehiculo);
    }
}
