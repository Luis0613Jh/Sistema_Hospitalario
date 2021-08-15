/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.principales;

import javax.swing.JPanel;
import vista.Frm_Categoria;
import vista.Frm_Examenes;
import vista.Frm_Laboratorio;
import vista.Frm_Pedidos;
import vista.Frm_SolicitudPedido;
import vista.inicio_sesion;

/**
 *
 * @author Jean Agreda
 */
public class Frm_Principal_Laboratorio extends javax.swing.JFrame {

    /**
     * Creates new form Frm_Principal_Laboratorio
     */
       
    Frm_Laboratorio fl = new Frm_Laboratorio();
    Frm_Categoria fc = new Frm_Categoria();
    Frm_SolicitudPedido fsp = new Frm_SolicitudPedido();
    Frm_Examenes fe = new Frm_Examenes();
    Frm_Pedidos fp = new Frm_Pedidos();

    public Frm_Principal_Laboratorio() {
        initComponents();
        setLocationRelativeTo(this);
        setResizable(false);

    }

    public void EsconderPanel() {

        Frm_Categoria.PanelCategoria.setVisible(false);
        Frm_Examenes.PanelExamen.setVisible(false);
        Frm_Laboratorio.PanelLab.setVisible(false);
        Frm_Pedidos.PanelPedido.setVisible(false);
        Frm_SolicitudPedido.PanelSolP.setVisible(false);
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
        PanelPLaboratorio = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btn_laboratorio = new javax.swing.JButton();
        btn_categoria = new javax.swing.JButton();
        btn_SolPedido = new javax.swing.JButton();
        btn_Examen = new javax.swing.JButton();
        btn_Pedido = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        PanelPLaboratorio.setBackground(new java.awt.Color(153, 204, 255));
        PanelPLaboratorio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        PanelPLaboratorio.setLayout(new java.awt.BorderLayout());

        jLabel1.setText("Usuario");

        jButton1.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jButton1.setText("Cerrar Sesión");
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(153, 204, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 192, Short.MAX_VALUE)
        );

        btn_laboratorio.setText("Laboratorio");
        btn_laboratorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_laboratorioActionPerformed(evt);
            }
        });

        btn_categoria.setText("Categoria");
        btn_categoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_categoriaActionPerformed(evt);
            }
        });

        btn_SolPedido.setText("Solicitud Pedido");
        btn_SolPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SolPedidoActionPerformed(evt);
            }
        });

        btn_Examen.setText("Examen");
        btn_Examen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ExamenActionPerformed(evt);
            }
        });

        btn_Pedido.setText("Pedido");
        btn_Pedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_PedidoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_laboratorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_categoria, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                    .addComponent(btn_Examen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_SolPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_Pedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelPLaboratorio, javax.swing.GroupLayout.DEFAULT_SIZE, 663, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addGap(10, 10, 10)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_laboratorio, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(btn_categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(btn_Examen, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_SolPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_Pedido, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(PanelPLaboratorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_laboratorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_laboratorioActionPerformed

        try {
            EsconderPanel();

           new  Frm_Laboratorio().PanelLab.setVisible(true);
            PanelPLaboratorio.add(Frm_Laboratorio.PanelLab);
            PanelPLaboratorio.updateUI();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btn_laboratorioActionPerformed

    private void btn_categoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_categoriaActionPerformed
        try {
            EsconderPanel();

            new Frm_Categoria().PanelCategoria.setVisible(true);
            PanelPLaboratorio.add(Frm_Categoria.PanelCategoria);
            PanelPLaboratorio.updateUI();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btn_categoriaActionPerformed

    private void btn_SolPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SolPedidoActionPerformed
        try {
            EsconderPanel();

           new  Frm_SolicitudPedido().PanelSolP.setVisible(true);
            PanelPLaboratorio.add(Frm_SolicitudPedido.PanelSolP);
            PanelPLaboratorio.updateUI();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btn_SolPedidoActionPerformed

    private void btn_ExamenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ExamenActionPerformed
        try {
            EsconderPanel();
           new  Frm_Examenes().PanelExamen.setVisible(true);
            //Frm_Examenes.PanelExamen.setVisible(true);
            PanelPLaboratorio.add(Frm_Examenes.PanelExamen);
            PanelPLaboratorio.updateUI();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btn_ExamenActionPerformed

    private void btn_PedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_PedidoActionPerformed
        try {
            EsconderPanel();

           new  Frm_Pedidos().PanelPedido.setVisible(true);
            PanelPLaboratorio.add(Frm_Pedidos.PanelPedido);
            PanelPLaboratorio.updateUI();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btn_PedidoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       inicio_sesion is = new inicio_sesion();
       this.dispose();
       is.setVisible(true);
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
            java.util.logging.Logger.getLogger(Frm_Principal_Laboratorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_Principal_Laboratorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_Principal_Laboratorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_Principal_Laboratorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_Principal_Laboratorio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JPanel PanelPLaboratorio;
    private javax.swing.JButton btn_Examen;
    private javax.swing.JButton btn_Pedido;
    private javax.swing.JButton btn_SolPedido;
    private javax.swing.JButton btn_categoria;
    private javax.swing.JButton btn_laboratorio;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
