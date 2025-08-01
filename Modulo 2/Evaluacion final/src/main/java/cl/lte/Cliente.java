package cl.lte;

public class Cliente extends Usuario {
    private int rut;
    private String nombres;
    private String apellidos;
    private String telefono;
    private String afp;
    private int sistemaSalud; // 1 = Fonasa, 2 = Isapre
    private String direccion;
    private String comuna;
    private int edad;

    public Cliente(String nombre, String fechaNacimiento, int run, int rut, String nombres, String apellidos,
                   String telefono, String afp, int sistemaSalud, String direccion, String comuna, int edad) {
        super(nombre, fechaNacimiento, run);
        this.rut = rut;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.afp = afp;
        this.sistemaSalud = sistemaSalud;
        this.direccion = direccion;
        this.comuna = comuna;
        this.edad = edad;
    }

    public String obtenerNombre() {
        return nombres + " " + apellidos;
    }

    public String obtenerSistemaSalud() {
        return sistemaSalud == 1 ? "Fonasa" : (sistemaSalud == 2 ? "Isapre" : "Desconocido");
    }

    @Override
    public void analizarUsuario() {
        super.analizarUsuario();
        System.out.println("Dirección: " + direccion);
        System.out.println("Comuna: " + comuna);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "rut=" + rut +
                ", nombres='" + nombres + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", telefono='" + telefono + '\'' +
                ", afp='" + afp + '\'' +
                ", sistemaSalud=" + sistemaSalud +
                ", direccion='" + direccion + '\'' +
                ", comuna='" + comuna + '\'' +
                ", edad=" + edad +
                "} " + super.toString();
    }

    // Getters y Setters
    public int getRut() {
        return rut; }
    public void setRut(int rut) {
        this.rut = rut; }

    public String getNombres() {
        return nombres; }
    public void setNombres(String nombres) {
        this.nombres = nombres; }

    public String getApellidos() {
        return apellidos; }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos; }

    public String getTelefono() {
        return telefono; }
    public void setTelefono(String telefono) {
        this.telefono = telefono; }

    public String getAfp() {
        return afp; }
    public void setAfp(String afp) {
        this.afp = afp; }

    public int getSistemaSalud() {
        return sistemaSalud; }
    public void setSistemaSalud(int sistemaSalud) {
        this.sistemaSalud = sistemaSalud; }

    public String getDireccion() {
        return direccion; }
    public void setDireccion(String direccion) {
        this.direccion = direccion; }

    public String getComuna() {
        return comuna; }
    public void setComuna(String comuna) {
        this.comuna = comuna; }

    public int getEdad() {
        return edad; }
    public void setEdad(int edad) {
        this.edad = edad; }
}
