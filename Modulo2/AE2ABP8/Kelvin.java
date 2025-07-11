public class Kelvin implements UnidadTemperatura {
    @Override
    public double convertirACelsius(double temperatura) {
        return temperatura - 273.15;
    }
}
