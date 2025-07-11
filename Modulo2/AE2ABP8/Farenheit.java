public class Fahrenheit implements UnidadTemperatura {
    @Override
    public double convertirACelsius(double temperatura) {
        return (temperatura - 32) * 5 / 9;
    }
}