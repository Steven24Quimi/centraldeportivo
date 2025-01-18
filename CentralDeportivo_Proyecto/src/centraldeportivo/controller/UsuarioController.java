package centraldeportivo.controller;

import centraldeportivo.model.Cancha;
import centraldeportivo.model.Conexion;
import centraldeportivo.model.ConsultasRegistro;
import centraldeportivo.model.Usuarios;
import centraldeportivo.view.FrmRegistro;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


public class UsuarioController implements ActionListener{
    Conexion connector = new Conexion();
    Cancha cancha = new Cancha();
    
    Usuarios usu = new Usuarios();
    ConsultasRegistro consultasRegistro = new ConsultasRegistro();
    FrmRegistro vw_registro = new FrmRegistro();
    
    public UsuarioController(Cancha cancha, Usuarios usu, ConsultasRegistro consultasregistro, FrmRegistro vw_registro){
        this.cancha = cancha;
        this.usu = usu;
        this.consultasRegistro = consultasregistro;
        this.vw_registro = vw_registro;
        this.vw_registro.btn_guardar.addActionListener(this);
        this.vw_registro.btn_buscar.addActionListener(this);
        this.vw_registro.btn_update.addActionListener(this);
        this.vw_registro.btnDelete.addActionListener(this);
        this.vw_registro.btn_limpiar.addActionListener(this);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e){
        
        
        if(e.getSource() == vw_registro.btn_guardar){
            usu.setNombre(vw_registro.txt_nombre.getText());
            usu.setApellido(vw_registro.txt_apellido.getText());
            usu.setCedula(vw_registro.txt_cedula.getText());
            cancha.setActividad(vw_registro.txt_actividad.getText());
            cancha.setNombreCancha((String) vw_registro.cbx_cancha.getSelectedItem());
            
            if(consultasRegistro.registrar(usu, cancha)){
                JOptionPane.showMessageDialog(null, "REGISTRO GUARDADO");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "fallo al guardar");
                limpiar();
            }
        }
        
        
        
        
        if(e.getSource() == vw_registro.btn_update){
            usu.setNombre(vw_registro.txt_nombre.getText());
            usu.setApellido(vw_registro.txt_apellido.getText());
            usu.setCedula(vw_registro.txt_cedula.getText());
            cancha.setActividad(vw_registro.txt_actividad.getText());
            cancha.setNombreCancha((String) vw_registro.cbx_cancha.getSelectedItem());
            
            if(consultasRegistro.modificar(usu, cancha)){
                JOptionPane.showMessageDialog(null, "REGISTRO MODIFICADO");
                vw_registro.txt_cedula.setEnabled(true);
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "fallo al MODIFICAR");
                limpiar();
            }
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        if(e.getSource() == vw_registro.btnDelete){
            usu.setCedula(vw_registro.txt_cedula.getText());
            
            if(consultasRegistro.delete(usu)){
                JOptionPane.showMessageDialog(null, "REGISTRO ELIMINADO");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "fallo al ELIMINAR");
                limpiar();
            }
        }
        
        if(e.getSource() == vw_registro.btn_buscar){
            usu.setCedula(vw_registro.txt_cedula.getText());
            
            if(consultasRegistro.buscar(usu, cancha)){
                
                vw_registro.txt_nombre.setText(usu.getNombre());
                vw_registro.txt_apellido.setText(usu.getApellido());
                vw_registro.txt_cedula.setText(usu.getCedula());
                vw_registro.txt_actividad.setText(cancha.getActividad());
                vw_registro.cbx_cancha.setSelectedItem(cancha.getNombreCancha());
                
                
                JOptionPane.showMessageDialog(null, "REGISTRO ENCONTRADO");
                vw_registro.txt_cedula.setEnabled(false);
            }else{
                JOptionPane.showMessageDialog(null, "fallo al ENCONTRAR");
                limpiar();
            }
        }
        
        
        
        
        if(e.getSource() == vw_registro.btn_limpiar){
            vw_registro.txt_cedula.setEnabled(true);
            limpiar();
        }
    }
    
    public void limpiar(){
        vw_registro.txt_nombre.setText(null);
        vw_registro.txt_apellido.setText(null);
        vw_registro.txt_cedula.setText(null);
        vw_registro.txt_actividad.setText(null);
    }
    
    public void iniciar(){
        vw_registro.setLocationRelativeTo(null);
        vw_registro.setTitle("GUI REGISTRO");
    }
    
    
}
