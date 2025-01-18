package centraldeportivo.view;

import centraldeportivo.controller.UsuarioController;
import centraldeportivo.model.Cancha;
import centraldeportivo.model.Conexion;
import centraldeportivo.model.ConsultasRegistro;
import centraldeportivo.model.Usuarios;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;


public class GUI_cancha extends javax.swing.JFrame {
    Conexion con1 = new Conexion();
    Connection conet = con1.conectar();
    DefaultTableModel modelo;
    Statement st;
    ResultSet rs;
    int idc;
    
    
    public GUI_cancha() {
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setTitle("GUI CANCHA");
        consultar();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCancha = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblCancha.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "CANCHA"
            }
        ));
        jScrollPane1.setViewportView(tblCancha);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
        );

        jMenu1.setText("Reistro");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Cancha");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Horarios");
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu3MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu3);

        jMenu4.setText("Usuarios");
        jMenu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu4MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        Cancha cancha = new Cancha();
        Usuarios usu = new Usuarios();
        ConsultasRegistro modRegistro = new ConsultasRegistro();
        FrmRegistro guiDeportivo = new FrmRegistro();
        
        UsuarioController usuController = new UsuarioController(cancha, usu, modRegistro, guiDeportivo);
        usuController.iniciar();
        guiDeportivo.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenu1MouseClicked

    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked
        GUI_horario gui_horario = new GUI_horario();
        gui_horario.setVisible(true);
        gui_horario.setLocationRelativeTo(null);
        this.setVisible(false);
    }//GEN-LAST:event_jMenu3MouseClicked

    private void jMenu4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu4MouseClicked
        GUI_usuario gui_usuario = new GUI_usuario();
        gui_usuario.setVisible(true);
        gui_usuario.setLocationRelativeTo(null);
        this.setVisible(false);
    }//GEN-LAST:event_jMenu4MouseClicked

    public void consultar(){
        String sql = "SELECT * FROM cancha";
        
        try {
            conet = con1.conectar();
            st = conet.createStatement();
            rs = st.executeQuery(sql);
            Object[] usuarios = new Object[2];
            modelo = (DefaultTableModel) tblCancha.getModel();
            
            while(rs.next()){
                usuarios[0] = rs.getString("id_cancha");
                usuarios[1] = rs.getString("nombre_cancha");
                
                modelo.addRow(usuarios);               
            }
            
            tblCancha.setModel(modelo);
            
        } catch (Exception e) {
            System.out.println("Falla al agregar los datos en la tabla: " + e);
        }
    }
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCancha;
    // End of variables declaration//GEN-END:variables
}
