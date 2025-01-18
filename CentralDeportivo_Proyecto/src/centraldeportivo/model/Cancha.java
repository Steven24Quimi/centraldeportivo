package centraldeportivo.model;


public class Cancha {
    private int id_cancha;
    private String nombreCancha;
    private String actividad;

    public Cancha(int id_cancha, String nombreCancha, String actividad) {
        this.id_cancha = id_cancha;
        this.nombreCancha = nombreCancha;
        this.actividad = actividad;
    }

    public Cancha() {
    }

    public int getId_cancha() {
        return id_cancha;
    }

    public void setId_cancha(int id_cancha) {
        this.id_cancha = id_cancha;
    }

    public String getNombreCancha() {
        return nombreCancha;
    }

    public void setNombreCancha(String nombreCancha) {
        this.nombreCancha = nombreCancha;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }
    
    

    
    
    
}
