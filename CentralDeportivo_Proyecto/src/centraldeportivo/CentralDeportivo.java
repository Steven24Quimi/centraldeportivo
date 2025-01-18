package centraldeportivo;
import centraldeportivo.controller.UsuarioController;
import centraldeportivo.model.Cancha;
import centraldeportivo.model.ConsultasRegistro;
import centraldeportivo.model.Usuarios;
import centraldeportivo.view.FrmRegistro;

public class CentralDeportivo {

    public static void main(String[] args) {
        Cancha cancha = new Cancha();
        Usuarios usu = new Usuarios();
        ConsultasRegistro modRegistro = new ConsultasRegistro();
        FrmRegistro guiDeportivo = new FrmRegistro();
        
        UsuarioController usuController = new UsuarioController(cancha, usu, modRegistro, guiDeportivo);
        usuController.iniciar();
        guiDeportivo.setVisible(true);
        
        
        
    }
    
}
