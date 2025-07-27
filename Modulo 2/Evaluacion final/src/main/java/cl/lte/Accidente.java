/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cl.unab.android.p1.prevensionriesgos;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author canas
 */
public class Accidente {
    private int identificadorAccidente;
    private int rutCliente;
    private Date dia;
    private String hora; // formato HH:MM
    private String lugar;
    private String origen;
    private String consecuencias;

    public Accidente() {}

    public Accidente(int identificadorAccidente, int rutCliente, Date dia, String hora, String lugar, String origen, String consecuencias) {
        this.identificadorAccidente = identificadorAccidente;
        this.rutCliente = rutCliente;
        setDia(dia);
        setHora(hora);
        setLugar(lugar);
        setOrigen(origen);
        setConsecuencias(consecuencias);
    }

    public void setDia(Date dia) {
        this.dia = dia;
    }

    public void setHora(String hora) {
        if (!hora.matches("^([01]?\\d|2[0-3]):[0-5]\\d$"))
            throw new IllegalArgumentException("Hora en formato HH:MM valido (00:00 a 23:59)");
        this.hora = hora;
    }

    public void setLugar(String lugar) {
        if (lugar == null || lugar.length() < 10 || lugar.length() > 50)
            throw new IllegalArgumentException("Lugar debe tener entre 10 y 50 caracteres.");
        this.lugar = lugar;
    }

    public void setOrigen(String origen) {
        if (origen != null && origen.length() > 100)
            throw new IllegalArgumentException("Origen maximo 100 caracteres.");
        this.origen = origen;
    }

    public void setConsecuencias(String consecuencias) {
        if (consecuencias != null && consecuencias.length() > 100)
            throw new IllegalArgumentException("Consecuencias maximo 100 caracteres.");
        this.consecuencias = consecuencias;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return "ID: " + identificadorAccidente + ", RUT Cliente: " + rutCliente + ", Dia: " + sdf.format(dia) +
               ", Hora: " + hora + ", Lugar: " + lugar + ", Origen: " + origen + ", Consecuencias: " + consecuencias;
    }
}    

