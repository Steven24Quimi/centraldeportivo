package centraldeportivo.model;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    Connection con;
    
    public Connection conectar(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3307/gestion_cancha","root","1234");
            System.out.println("Conectado con exito");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return con;
    }
}
