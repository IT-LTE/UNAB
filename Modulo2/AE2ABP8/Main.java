import java.util.scanner;

public class AE2ABP8 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== Conversor de Temperatura a Celsius ===");
        System.out.println("Unidades válidas: CELSIUS, FAHRENHEIT, KELVIN");
        System.out.println("-------------------------------------------");

        System.out.print("Ingresa la temperatura: ");
        double valor = Double.parseDouble(sc.nextLine());

        System.out.print("Ingresa la unidad de origen: ");
        String unidad = sc.nextLine();

        double resultado = Conversor.convertirTemperatura(valor, unidad);

        if (!unidad.equalsIgnoreCase("CELSIUS") &&
                !unidad.equalsIgnoreCase("FAHRENHEIT") &&
                !unidad.equalsIgnoreCase("KELVIN")) {
            System.out.println("La unidad Ingresada no existe");
            return;
        }

        System.out.printf("Temperatura convertida a Celsius: %.2f °C%n", resultado);

    }
}
