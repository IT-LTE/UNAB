package cl.lte;

// Bicicleta de carga: no requiere combustible ni bateria
public class BicicletaCarga extends VehiculoLogistico implements Operativo {

    public BicicletaCarga(String idVehiculo, double capacidadCargaKg, String ubicacionActual, double velocidadPromedioKmH) {
        super(idVehiculo, capacidadCargaKg, ubicacionActual, velocidadPromedioKmH);
    }

    @Override
    public void desplazar(String destino) {
        System.out.println("Bicicleta de carga " + idVehiculo + " pedaleando desde " + ubicacionActual + " hasta " + destino);
        ubicacionActual = destino;
    }

    @Override
    public void verificarEstado() {
        System.out.println("Verificando llantas y frenos de la bicicleta " + idVehiculo);
    }

    @Override
    public void calcularDesgaste() {
        System.out.println("Calculando desgaste de llantas y cadenas de la bicicleta " + idVehiculo);
    }

    @Override
    public void registrarEntrega() {
        System.out.println("Entrega registrada por la bicicleta de carga " + idVehiculo);
    }
}
