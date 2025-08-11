package cl.lte;

import java.util.Scanner;

public class MenuSimulador {

    private SimuladorDistribucion simulador;
    private Scanner sc;

    public MenuSimulador() {
        simulador = new SimuladorDistribucion();
        sc = new Scanner(System.in);
        cargarDatosIniciales();
    }

    private void cargarDatosIniciales() {
        // Vehiculos iniciales
        simulador.agregarVehiculo(new CamionRefrigerado("CAM001", 5000, "Bodega Central", 60));
        simulador.agregarVehiculo(new DronRepartidor("DRN001", 5, "Base Aerea", 40));
        simulador.agregarVehiculo(new MotoElectrica("MOT001", 50, "Sucursal Norte", 70));
        simulador.agregarVehiculo(new BicicletaCarga("BIC001", 30, "Sucursal Sur", 20));

        // Rutas iniciales
        simulador.agregarRuta(new RutaEntrega("Bodega Central", "Sucursal Norte", 12.5, "Baja"));
        simulador.agregarRuta(new RutaEntrega("Sucursal Norte", "Sucursal Sur", 25.0, "Media"));
        simulador.agregarRuta(new RutaEntrega("Sucursal Sur", "Bodega Central", 18.7, "Alta"));
    }

    public void iniciar() {
        int opcion;

        do {
            mostrarMenu();
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    simulador.mostrarFlota();
                    break;
                case 2:
                    simulador.mostrarRutas();
                    break;
                case 3:
                    asignarRuta();
                    break;
                case 4:
                    System.out.println("Gracias por haber usado la aplicacion");
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        } while (opcion != 4);
    }

    private void mostrarMenu() {
        System.out.println("\n=== Menu Simulador de Distribucion ===");
        System.out.println("1. Ver flota de vehiculos");
        System.out.println("2. Ver rutas disponibles");
        System.out.println("3. Asignar ruta y simular entrega");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opcion: ");
    }

    private void asignarRuta() {
        System.out.println("\nSeleccione el vehiculo:");
        simulador.mostrarFlota();
        System.out.print("Ingrese numero de vehiculo: ");
        int vehiculo = sc.nextInt();

        System.out.println("\nSeleccione la ruta:");
        simulador.mostrarRutas();
        System.out.print("Ingrese numero de ruta: ");
        int ruta = sc.nextInt();

        simulador.asignarYSimularEntrega(vehiculo, ruta);
    }
}
