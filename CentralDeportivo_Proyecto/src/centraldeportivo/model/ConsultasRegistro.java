package centraldeportivo.model;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;

public class ConsultasRegistro extends Conexion{
    
    
    
    public boolean registrar (Usuarios usu, Cancha cancha){
        PreparedStatement pst = null;
        Connection con = conectar();
        String query = "INSERT INTO usuario(nombre, apellido, cedula) VALUES" + "(?,?,?)";
        String query2 = "SET @id_cancha = (SELECT id_cancha FROM cancha WHERE nombre_cancha = ?)";
        String query3 = "INSERT INTO fk_disponibilidad (id_usuario, id_cancha, disponibilidad) \n" +
"VALUES (LAST_INSERT_ID(), @id_cancha, ?)";
        
        try{
            pst = con.prepareStatement(query);
            pst.setString(1, usu.getNombre());
            pst.setString(2, usu.getApellido());
            pst.setString(3, usu.getCedula());
            
            pst.execute();
            
            pst = con.prepareStatement(query2);
            pst.setString(1, cancha.getNombreCancha());
            pst.execute();
            
            pst = con.prepareStatement(query3);
            pst.setString(1, cancha.getActividad());
            pst.execute();
            
            System.out.println("Insertado con exito");
            return true;
        }catch(SQLException e){
            System.out.println("Error al insertar: " + e);
            return false;
        }finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexion: " + e);
            }
        }
    }
    
    public boolean modificar (Usuarios usu, Cancha cancha){
        PreparedStatement pst = null;
        Connection con = conectar();
        String query = "UPDATE usuario SET nombre = ?, apellido = ? WHERE cedula = ?";
        String query2 = "SET @id_cancha = (SELECT id_cancha FROM cancha WHERE nombre_cancha = ?)";
        String query3 = "SET @id_usuario = (SELECT id_usuario FROM usuario WHERE cedula = ?)";
        String query4 = "INSERT INTO fk_disponibilidad (id_usuario, id_cancha, disponibilidad) VALUES (@id_usuario, @id_cancha, ?)";
        
        String query5 = "DELETE FROM fk_disponibilidad\n" +
"WHERE id = (\n" +
"    SELECT id FROM (\n" +
"        SELECT id\n" +
"        FROM fk_disponibilidad\n" +
"        ORDER BY id DESC\n" +
"        LIMIT 1 OFFSET 1\n" +
"    ) AS temp_table\n" +
");";
        
        try{
            pst = con.prepareStatement(query);
            pst.setString(1, usu.getNombre());
            pst.setString(2, usu.getApellido());
            pst.setString(3, usu.getCedula());
            
            pst.execute();
            
            pst = con.prepareStatement(query2);
            pst.setString(1, cancha.getNombreCancha());
            pst.execute();
            
            pst = con.prepareStatement(query3);
            pst.setString(1, usu.getCedula());
            pst.execute();
            
            
            pst = con.prepareStatement(query4);
            pst.setString(1, cancha.getActividad());
            pst.execute();
            
            pst = con.prepareStatement(query5);
            pst.execute();
            
            System.out.println("Insertado con exito");
            return true;
        }catch(SQLException e){
            System.out.println("Error al insertar: " + e);
            return false;
        }finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexion: " + e);
            }
        }
    }
    
        public boolean delete (Usuarios usu){
        PreparedStatement pst = null;
        Connection con = conectar();
        String query = "SET @id_usuario = (SELECT id_usuario FROM usuario WHERE cedula = ?)";
        String query2 = "DELETE FROM fk_disponibilidad  WHERE id_usuario = @id_usuario";
        String query3 = "DELETE FROM usuario WHERE id_usuario = @id_usuario;";
        
        
        try{
            
            pst = con.prepareStatement(query);
            pst.setString(1, usu.getCedula());
            pst.execute();
            
            pst = con.prepareStatement(query2);
            pst.execute();
            
            pst = con.prepareStatement(query3);
            pst.execute();
            
            
            
            
            System.out.println("Insertado con exito");
            return true;
        }catch(SQLException e){
            System.out.println("Error al insertar: " + e);
            return false;
        }finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexion: " + e);
            }
        }
    }
    
    
    


    
    
//    public boolean registrar (Usuarios usu){
//        PreparedStatement pst = null;
//        Connection con = conectar();
//        String query = "INSERT INTO Registro(nombre, apellido, cedula) VALUES" + "(?,?,?)";
//        
//        try{
//            pst = con.prepareStatement(query);
//            pst.setString(1, usu.getNombre());
//            pst.setString(2, usu.getApellido());
//            pst.setString(3, usu.getCedula());
//            
//            pst.execute();
//            
//            System.out.println("Insertado con exito");
//            return true;
//        }catch(SQLException e){
//            System.out.println("Error al insertar: " + e);
//            return false;
//        }finally{
//            try {
//                con.close();
//            } catch (SQLException e) {
//                System.out.println("Error al cerrar la conexion: " + e);
//            }
//        }
//    }
    
    
    
    
    
    
//    public boolean modificar (Usuarios usu){
//        PreparedStatement pst = null;
//        Connection con = conectar();
//        String query = "UPDATE registro SET nombre=?, apellido=? WHERE cedula=?";
//        
//        try{
//            pst = con.prepareStatement(query);
//            pst.setString(1, usu.getNombre());
//            pst.setString(2, usu.getApellido());
//            pst.setString(3, usu.getCedula());
//            
//            pst.execute();
//            return true;
//        }catch(SQLException e){
//            System.out.println("Error al insertar: " + e);
//            return false;
//        }finally{
//            try {
//                con.close();
//            } catch (SQLException e) {
//                System.out.println("Error al cerrar la conexion: " + e);
//            }
//        }
//    }
    
//    public boolean delete (Usuarios usu){
//        PreparedStatement pst = null;
//        Connection con = conectar();
//        String query = "DELETE FROM usuario WHERE cedula=?";
//        
//        try{
//            pst = con.prepareStatement(query);
//            pst.setString(1, usu.getCedula());
//            
//            pst.execute();
//            
//            System.out.println("Insertado con exito");
//            return true;
//        }catch(SQLException e){
//            System.out.println("Error al insertar: " + e);
//            return false;
//        }finally{
//            try {
//                con.close();
//            } catch (SQLException e) {
//                System.out.println("Error al cerrar la conexion: " + e);
//            }
//        }
//    }
    
    public boolean buscar (Usuarios usu, Cancha cancha){
        PreparedStatement pst = null;
        ResultSet rs =null;
        Connection con = conectar();
        //String query = "SELECT * FROM usuario WHERE cedula=?;";
        String query = "SELECT u.nombre, u.apellido, u.cedula, d.disponibilidad, c.nombre_cancha FROM usuario u \n" +
"inner join fk_disponibilidad d ON u.id_usuario = d.id_usuario \n" +
"inner join cancha c on c.id_cancha = d.id_cancha where u.cedula = ?;";
        
        try{
            pst = con.prepareStatement(query);
            pst.setString(1, usu.getCedula());
            rs = pst.executeQuery();
            
            if(rs.next()){
                usu.setNombre(rs.getString("nombre"));
                usu.setApellido(rs.getString("apellido"));
                usu.setCedula(rs.getString("cedula"));
                cancha.setActividad(rs.getString("disponibilidad"));
                cancha.setNombreCancha(rs.getString("nombre_cancha"));
                
                return true;
            }
            
            
            return false;
        }catch(SQLException e){
            System.out.println("Error al insertar: " + e);
            return false;
        }finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexion: " + e);
            }
        }
    }
    
}
