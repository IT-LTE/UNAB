package cl.lte;

public class Administrativo extends Usuario {

    private String area;
    private String experienciaPrevia;

    Administrativo(String nombre, String fechaNacimiento, int run, String area, String experienciaPrevia) {
        super(nombre, fechaNacimiento, run);
        this.area = area;
        this.experienciaPrevia = experienciaPrevia;
    }

    @Override
    public void analizarUsuario() {
        super.analizarUsuario();
        System.out.println("Área: " + area);
        System.out.println("Experiencia previa: " + experienciaPrevia);
    }

    public void setArea(String area) {
        if(area.length() >= 5 && area.length() <= 10) {
            this.area = area;
        }else {
            System.out.println("Area debe tener entre 5 y 10 caracteres.");
        }
    }

    public void setExperienciaPrevia(String experienciaPrevia) {
        if(experienciaPrevia.length() <= 100){
            this.experienciaPrevia = experienciaPrevia;
        } else {
            System.out.println("Experiencia debe tener un maximo de 100 caracteres.");
        }
    }

}

