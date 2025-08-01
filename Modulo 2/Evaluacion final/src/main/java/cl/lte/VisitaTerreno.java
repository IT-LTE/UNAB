package cl.lte;


public class VisitaTerreno {
    public int identificador_visita; //obligatorio, número interno manejado por la compañía.
    public int rut_cliente; //obligatorio
    public String dia; //formato DD/MM/AAAA
    public String hora; //debe ser una hora válida del día, en formato HH:MM (horadesde 0 a 23, minutos entre 0 y 59)
    public String lugar;// obligatorio, mínimo 10 caracteres, máximo 50
    public String comentarios; //máximo 100 caracteres
    public VisitaTerreno(){}

    public VisitaTerreno(int identificador_visita, int rut_cliente, String dia, String hora, String lugar, String comentarios){
        this.identificador_visita=identificador_visita;
        this.rut_cliente=rut_cliente;
        this.dia=dia;
        this.hora=hora;
        this.lugar=lugar;
        this.comentarios=comentarios;
    }

    public void setHora(String hora) {
        String h = hora;
        while (!h.matches("^([01]?\\d|2[0-3]):[0-5]\\d$")) {
            System.out.print("Ingrese la hora (HH:MM): ");
            //h = Main.entrada.nextLine();
        }
        this.hora = h; // se guarda solo si es válida
    }

    public void setDia(String dia) {
        String d = dia;
        while (!d.matches("^([0][1-9]|[12][0-9]|3[01])/([0][1-9]|1[0-2])/\\d{4}$")) {
            System.out.print("Ingrese el día (dd/mm/yyyy): ");
            //d = Main.entrada.nextLine();
        }
        this.dia = d;
    }

    public void setLugar(String lugar) {
        String d = lugar;
        while (d.trim().length() < 10 || d.trim().length() > 50) {
            System.out.print("Ingrese una dirección válida (10 a 50 caracteres): ");
            //d = Main.entrada.nextLine();
        }
        this.lugar = d.trim();
    }

    public void setComentario(String comentarios) {
        String d = comentarios;
        while (d.trim().length() > 100) {
            System.out.print("Comentario alcanza hasta 100 caracteres");
            //d = Main.entrada.nextLine();
        }
        this.comentarios = d.trim();
    }

    // public void agregar_visita(Visitas visita){
    //     lvisitas.add(visita);
    // }
    // public void listar_visita(int rut_cliente){
    //     for (int i = 0; i < lvisitas.size(); i++) {
    //         if((rut_cliente!=0 && rut_cliente == lvisitas.get(i).rut_cliente) || rut_cliente==0){
    //             var lv=lvisitas.get(i);
    //             System.out.println("id: " + lv.identificador_visita + " Cliente: "+lv.rut_cliente + " Fecha: " + lv.dia+" " + lv.hora+" Dirección: " + lv.lugar+" Comentario: " + lv.comentarios);
    //         }
    //     }
    // }
}
