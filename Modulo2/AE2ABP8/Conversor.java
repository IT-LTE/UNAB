public class Conversor {

    public static double convertirTemperatura(double temperatura, String unidadOrigen) {
        UnidadTemperatura unidad;

        switch (unidadOrigen.toUpperCase()) {
            case "FAHRENHEIT":
                unidad = new Fahrenheit();
                break;
            case "KELVIN":
                unidad = new Kelvin();
                break;
            case "CELSIUS":
                unidad = new Celsius();
                break;
            default:
                System.out.println("La unidad que ingreso no es válida.");
        }

        return unidad.convertirACelsius(temperatura);
    }

}
