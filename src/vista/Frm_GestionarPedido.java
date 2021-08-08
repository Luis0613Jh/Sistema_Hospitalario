
package vista;

import controlador.DAO.ExamenDAO;
import controlador.DAO.PedidoDAO;
import controlador.DAO.PersonaDAO;
import controlador.utilidades.UtilidadesControlador;
import javax.swing.JOptionPane;
import modelo.Examen;
import modelo.tabla.modeloCitas;
import modelo.tabla.ExamenTabla;
import vista.utilidades.UtilidadesVista;

public class Frm_GestionarPedido extends javax.swing.JFrame {

<<<<<<< HEAD
    private PedidoDAO pedidoDAO = new PedidoDAO();
    private ExamenDAO examenDAO = new ExamenDAO();
    private modeloCitas modelocitas = new modeloCitas();
    private PersonaDAO personaDAO = new PersonaDAO();
    private ExamenTabla examenesTabla = new ExamenTabla();

    /**
     * Creates new form Frm_GestionarPedido
     */
    public Frm_GestionarPedido(long id) {
=======
    /**
     * Creates new form Frm_GestionarPedido
     */
    public Frm_GestionarPedido() {
>>>>>>> parent of 5c9e17f (Avance agendar consulta)
        initComponents();
        cargarCampos();
        cargarTabla();
        pedidoDAO.setIdConsulta(id);
    }

    public void cargarCampos() {
        // Datos Pedido
        lblNroPedido.setText(pedidoDAO.getPedido().getNro_pedido());
        lblFecha.setText(pedidoDAO.getPedido().getFecha_pedido());
        
        // Datos Médico Solicitante
        personaDAO.setPersona(personaDAO.buscarPersonaPorId(pedidoDAO.getPedido().getConsulta().getId_medico()));
        lblMedicoSolicitante.setText(personaDAO.getPersona().toString());
        personaDAO.setPersona(null);
        
        // Datos Paciente
        personaDAO.setPersona(personaDAO.buscarPersonaPorId(pedidoDAO.getPedido().getConsulta().getId_paciente()));
        lblPaciente.setText(personaDAO.getPersona().toString());
        lblSexo.setText(personaDAO.getPersona().getGenero());
        lblFechaNacimiento.setText(personaDAO.getPersona().getFecha_nacimiento());
        lblEdad.setText(String.valueOf(UtilidadesControlador.determinarEdad(personaDAO.getPersona().getFecha_nacimiento())));
        lblDireccion.setText(personaDAO.getPersona().getDireccion());
        
        personaDAO.setPersona(null);
        
        cargarTabla();
        UtilidadesVista.cargarCbxPersonas(cbxExamenes, examenDAO.TodosExam());
    }

    public void habilitarCampos() {
        cbxExamenes.setEnabled(true);
        btnAñadir.setEnabled(true);
    }

    public void deshabilitarCampos() {
        cbxExamenes.setEnabled(false);
    }

    public void guardar() {        
        pedidoDAO.setConsulta(pedidoDAO.encontrarConsulta(pedidoDAO.getIdConsulta()));
        pedidoDAO.getPedido().setConsulta(pedidoDAO.getConsulta());
        pedidoDAO.getPedido().setEstado_pedido("PENDIENTE");
        pedidoDAO.getPedido().setNro_pedido(String.valueOf(Math.random()*1000));        
        pedidoDAO.getPedido().setListaExamen(pedidoDAO.getPedido().getListaExamen());
        pedidoDAO.getPedido().setFecha_pedido(pedidoDAO.getConsulta().getFecha_cita());
        if (pedidoDAO.agregar(pedidoDAO.getPedido())) {
            JOptionPane.showMessageDialog(null,"Se ha guardado el pedido");
        }else{
            JOptionPane.showMessageDialog(null,"Se ha producido un error en guardar.");
        }
    }

    public void nuevo() {
        habilitarCampos();
    }

    public void eliminarExamen() {
        if (tblExamenes.getSelectedRow() != - 1) {
            pedidoDAO.getPedido().getListaExamen().remove(tblExamenes.getSelectedRow());
            cargarTabla();
            JOptionPane.showMessageDialog(this, "Exámen eliminado del pedido exitosamente");
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, primero seleccione un pedido de la tabla");
        }
    }

    public void cargarTabla() {
        examenesTabla.setListaExamenes(pedidoDAO.getPedido().getListaExamen());
        tblExamenes.setModel(examenesTabla);
        tblExamenes.updateUI();
    }

    public void añadirExamen() {
        pedidoDAO.getPedido().getListaExamen().add((Examen) cbxExamenes.getSelectedItem());
        cargarTabla();
    }
    
    public void cancelar() {
        deshabilitarCampos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblMedicoSolicitante = new javax.swing.JLabel();
        lblNroPedido = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        lblPaciente = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblSexo = new javax.swing.JLabel();
        lblFechaNacimiento = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblEdad = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cbxExamenes = new javax.swing.JComboBox<>();
        btnCancelar = new javax.swing.JButton();
        btnAñadir = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblExamenes = new javax.swing.JTable();
        btnEliminar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(null);

        jLabel1.setText("Nro de Pedido:");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(20, 20, 90, 16);

        jLabel2.setText("Médico solicitante:");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(20, 60, 110, 16);

        lblMedicoSolicitante.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(lblMedicoSolicitante);
        lblMedicoSolicitante.setBounds(150, 60, 430, 20);

        lblNroPedido.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(lblNroPedido);
        lblNroPedido.setBounds(150, 20, 130, 20);

        jLabel3.setText("Fecha:");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(350, 20, 50, 16);

        lblFecha.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(lblFecha);
        lblFecha.setBounds(410, 20, 170, 20);

        lblPaciente.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(lblPaciente);
        lblPaciente.setBounds(150, 100, 430, 20);

        jLabel4.setText("Paciente:");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(20, 100, 110, 16);

        lblDireccion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(lblDireccion);
        lblDireccion.setBounds(150, 140, 430, 20);

        jLabel5.setText("Dirección:");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(20, 140, 110, 16);

        jLabel6.setText("Sexo:");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(20, 180, 40, 16);

        lblSexo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(lblSexo);
        lblSexo.setBounds(80, 180, 60, 20);

        lblFechaNacimiento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(lblFechaNacimiento);
        lblFechaNacimiento.setBounds(300, 180, 130, 20);

        jLabel7.setText("Fecha de Nacimiento:");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(160, 180, 130, 16);

        lblEdad.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(lblEdad);
        lblEdad.setBounds(510, 180, 70, 20);

        jLabel8.setText("Edad:");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(450, 180, 40, 16);

        jLabel9.setText("Exámen:");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(20, 230, 70, 16);

        cbxExamenes.setEnabled(false);
        jPanel2.add(cbxExamenes);
        cbxExamenes.setBounds(150, 230, 230, 22);

        btnCancelar.setText("Cancelar");
        btnCancelar.setEnabled(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel2.add(btnCancelar);
        btnCancelar.setBounds(600, 230, 80, 22);

        btnAñadir.setText("Añadir");
        btnAñadir.setEnabled(false);
        btnAñadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAñadirActionPerformed(evt);
            }
        });
        jPanel2.add(btnAñadir);
        btnAñadir.setBounds(600, 170, 72, 22);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(10, 10, 690, 270);

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setLayout(null);

        tblExamenes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblExamenes);

        jPanel3.add(jScrollPane1);
        jScrollPane1.setBounds(12, 12, 570, 170);

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel3.add(btnEliminar);
        btnEliminar.setBounds(600, 110, 80, 22);

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jPanel3.add(btnNuevo);
        btnNuevo.setBounds(600, 10, 80, 22);

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel3.add(btnGuardar);
        btnGuardar.setBounds(600, 200, 80, 22);

        jButton1.setText("Cerrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1);
        jButton1.setBounds(10, 200, 72, 22);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(10, 290, 690, 240);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 720, 570);

        setSize(new java.awt.Dimension(739, 581));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        eliminarExamen();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        nuevo();
        
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        guardar();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        cancelar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAñadirActionPerformed
        añadirExamen();
    }//GEN-LAST:event_btnAñadirActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Frm_GestionarPedido.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_GestionarPedido.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_GestionarPedido.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_GestionarPedido.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new Frm_GestionarPedido().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAñadir;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox<String> cbxExamenes;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblEdad;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblFechaNacimiento;
    private javax.swing.JLabel lblMedicoSolicitante;
    private javax.swing.JLabel lblNroPedido;
    private javax.swing.JLabel lblPaciente;
    private javax.swing.JLabel lblSexo;
    private javax.swing.JTable tblExamenes;
    // End of variables declaration//GEN-END:variables
}
