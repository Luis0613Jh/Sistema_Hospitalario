package vista;

import controlador.DAO.LaboratorioDAO;
import controlador.DAO.PersonaDAO;
import javax.swing.JOptionPane;
import modelo.Persona;
import modelo.tabla.LaboratoriosTabla;
import vista.utilidades.UtilidadesVista;

public class Frm_Laboratorio extends javax.swing.JFrame {

    private LaboratorioDAO laboratorioDAO = new LaboratorioDAO();
    private LaboratoriosTabla laboratoriosTabla = new LaboratoriosTabla();
    private PersonaDAO personaDAO = new PersonaDAO();

    /**
     * Creates new form Frm_Laboratorio
     */
    public Frm_Laboratorio() {
        initComponents();
        cargarTabla();
        cargarCbxPersonas();
    }

    public void cargarCbxPersonas() {
        UtilidadesVista.cargarCbxPersonas(cbxEncargado, personaDAO.filtro(Long.valueOf(1), "Disponible"));
    }

    public void limpiarCampos() {
        txtNombre.setText("");
        txtDescripcion.setText("");
    }

    public void cargarCampos() {
        txtNombre.setText(laboratorioDAO.getLaboratorio().getNombre_lab());
        txtDescripcion.setText(laboratorioDAO.getLaboratorio().getDescripcion_lab());
    }

    public void habilitarCampos() {
        txtNombre.setEnabled(true);
        txtDescripcion.setEnabled(true);
        btnGuardar.setEnabled(true);
        btnCancelar.setEnabled(true);
        cbxEncargado.setEnabled(true);
    }

    public void deshabilitarCampos() {
        txtNombre.setEnabled(false);
        txtDescripcion.setEnabled(false);
        btnGuardar.setEnabled(false);
        btnCancelar.setEnabled(false);
        cbxEncargado.setEnabled(false);
    }

    public void guardar() {
        switch (btnGuardar.getText().toUpperCase()) {
            case "GUARDAR":
                if (!txtNombre.getText().equals("") && !txtDescripcion.getText().equals("")) {
                    laboratorioDAO.getLaboratorio().setNombre_lab(txtNombre.getText());
                    laboratorioDAO.getLaboratorio().setDescripcion_lab(txtDescripcion.getText());
                    personaDAO.setPersona((Persona)cbxEncargado.getSelectedItem());
                    laboratorioDAO.getLaboratorio().setId_encargado(personaDAO.getPersona().getId_persona());
                    personaDAO.setPersona(null);
                    laboratorioDAO.getLaboratorio().setEstado("activo");
                    if (laboratorioDAO.agregar(laboratorioDAO.getLaboratorio())) {

                        JOptionPane.showMessageDialog(this, "Laboratorio ingresado exitosamente");
                        laboratorioDAO.setLaboratorio(null);
                        limpiarCampos();
                        deshabilitarCampos();
                        cargarTabla();

                    } else {
                        JOptionPane.showMessageDialog(this, "Ha ocurrido un error, el laboratorio no se pudo ingresar");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Por favor, primero llene todos los campos");
                }
                break;
            case "ACTUALIZAR":
                if (!txtNombre.getText().equals("") && !txtDescripcion.getText().equals("")) {
                    laboratorioDAO.setLaboratorio(laboratorioDAO.listar().get(tblLaboratorios.getSelectedRow()));
                    laboratorioDAO.getLaboratorio().setNombre_lab(txtNombre.getText());
                    laboratorioDAO.getLaboratorio().setDescripcion_lab(txtDescripcion.getText());
                    personaDAO.setPersona((Persona)cbxEncargado.getSelectedItem());
                    laboratorioDAO.getLaboratorio().setId_encargado(personaDAO.getPersona().getId_persona());
                    personaDAO.setPersona(null);

                    if (laboratorioDAO.editar(laboratorioDAO.getLaboratorio())) {

                        JOptionPane.showMessageDialog(this, "Laboratorio actualizado exitosamente");
                        laboratorioDAO.setLaboratorio(null);
                        limpiarCampos();
                        deshabilitarCampos();
                        cargarTabla();
                        btnGuardar.setText("Guardar");
                    } else {
                        JOptionPane.showMessageDialog(this, "Ha ocurrido un error, el laboratorio no se pudo actualizar");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Por favor, primero llene todos los campos");
                }
                break;
        }
    }

    public void nuevo() {

        habilitarCampos();
    }

    public void editar() {

        if (tblLaboratorios.getSelectedRow() != - 1) {

            habilitarCampos();
            cargarCampos();
            btnGuardar.setText("Actualizar");

        } else {
            JOptionPane.showMessageDialog(this, "Por favor, primero seleccione un laboratorio de la tabla");
        }
    }

    public void darDeBaja() {

        if (tblLaboratorios.getSelectedRow() != - 1) {
            laboratorioDAO.setLaboratorio(laboratorioDAO.listar().get(tblLaboratorios.getSelectedRow()));
            laboratorioDAO.getLaboratorio().setEstado("inactivo");

            if (laboratorioDAO.editar(laboratorioDAO.getLaboratorio())) {

                JOptionPane.showMessageDialog(this, "Laboratorio eliminado exitosamente");
                laboratorioDAO.setLaboratorio(null);
                cargarTabla();

            } else {
                JOptionPane.showMessageDialog(this, "Ha ocurrido un error, el laboratorio no se pudo eliminar");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, primero seleccione un laboratorio de la tabla");
        }
    }

    public void cargarTabla() {
        laboratoriosTabla.setListaLaboratorios(laboratorioDAO.laboratoriosPorEstado("ACTIVO"));
        tblLaboratorios.setModel(laboratoriosTabla);
        tblLaboratorios.updateUI();
    }

    public void cancelar() {
        btnGuardar.setText("Guardar");
        limpiarCampos();
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
        txtNombre = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        cbxEncargado = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLaboratorios = new javax.swing.JTable();
        btnEliminar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(null);

        jLabel1.setText("Nombre:");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(20, 30, 80, 16);

        jLabel2.setText("Descripción:");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(20, 70, 80, 16);

        txtNombre.setEnabled(false);
        jPanel2.add(txtNombre);
        txtNombre.setBounds(120, 20, 270, 30);

        txtDescripcion.setEnabled(false);
        jPanel2.add(txtDescripcion);
        txtDescripcion.setBounds(120, 62, 270, 30);

        btnCancelar.setText("Cancelar");
        btnCancelar.setEnabled(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel2.add(btnCancelar);
        btnCancelar.setBounds(410, 110, 80, 22);

        btnGuardar.setText("Guardar");
        btnGuardar.setEnabled(false);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel2.add(btnGuardar);
        btnGuardar.setBounds(410, 20, 80, 22);

        jLabel3.setText("Encargado:");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(20, 110, 70, 16);

        cbxEncargado.setEnabled(false);
        cbxEncargado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxEncargadoActionPerformed(evt);
            }
        });
        jPanel2.add(cbxEncargado);
        cbxEncargado.setBounds(120, 110, 270, 22);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(10, 10, 510, 150);

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setLayout(null);

        tblLaboratorios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblLaboratorios);

        jPanel3.add(jScrollPane1);
        jScrollPane1.setBounds(12, 12, 390, 210);

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel3.add(btnEliminar);
        btnEliminar.setBounds(410, 200, 80, 22);

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanel3.add(btnEditar);
        btnEditar.setBounds(410, 100, 80, 22);

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jPanel3.add(btnNuevo);
        btnNuevo.setBounds(410, 10, 80, 22);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(10, 170, 510, 240);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(546, 445));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        darDeBaja();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        guardar();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        editar();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        nuevo();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        cancelar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void cbxEncargadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxEncargadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxEncargadoActionPerformed

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
            java.util.logging.Logger.getLogger(Frm_Laboratorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_Laboratorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_Laboratorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_Laboratorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_Laboratorio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox<String> cbxEncargado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblLaboratorios;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
