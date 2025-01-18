package centraldeportivo.model;

public class Usuarios {
    private int id_usurio;
    private String nombre;
    private String apellido;
    private String cedula;

    public Usuarios(int id_usurio, String nombre, String apellido, String cedula) {
        this.id_usurio = id_usurio;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
    }

    public Usuarios() {
    }

    public int getId_usurio() {
        return id_usurio;
    }

    public void setId_usurio(int id_usurio) {
        this.id_usurio = id_usurio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
}
