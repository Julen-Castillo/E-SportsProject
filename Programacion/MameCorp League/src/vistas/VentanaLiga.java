/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import java.awt.Color;
import javax.swing.JFrame;
import main.MainEsports;

/**
 *
 * @author PETO
 */
public class VentanaLiga extends javax.swing.JFrame {

    /**
     * Creates new form VentanaInsertarLiga
     */
    public VentanaLiga() {
        initComponents();
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        panelOpaco.setBackground(new Color(255,255,255,190));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        datePicker1 = new com.github.lgooddatepicker.components.DatePicker();
        datePicker2 = new com.github.lgooddatepicker.components.DatePicker();
        jCheckBox1 = new javax.swing.JCheckBox();
        bInsertar = new javax.swing.JButton();
        bLimpiar = new javax.swing.JButton();
        bVolver = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        panelOpaco = new javax.swing.JPanel();
        lFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1);
        jTextField1.setBounds(270, 560, 190, 20);
        getContentPane().add(jTextField3);
        jTextField3.setBounds(270, 610, 190, 20);

        jLabel5.setText("LIGA EN CURSO");
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(110, 780, 130, 17);

        jLabel6.setText("NOMBRE DE LIGA");
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(110, 610, 150, 17);

        jLabel7.setText("ID LIGA");
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(jLabel7);
        jLabel7.setBounds(110, 560, 110, 17);

        jLabel8.setText("FECHA DE INICIO");
        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(jLabel8);
        jLabel8.setBounds(110, 670, 140, 17);

        jLabel9.setText("FECHA DE FIN");
        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(jLabel9);
        jLabel9.setBounds(110, 730, 170, 17);
        getContentPane().add(datePicker1);
        datePicker1.setBounds(270, 670, 190, 20);
        getContentPane().add(datePicker2);
        datePicker2.setBounds(270, 730, 190, 20);
        getContentPane().add(jCheckBox1);
        jCheckBox1.setBounds(270, 780, 30, 21);

        bInsertar.setText("INSERTAR");
        getContentPane().add(bInsertar);
        bInsertar.setBounds(360, 870, 100, 23);

        bLimpiar.setText("LIMPIAR");
        getContentPane().add(bLimpiar);
        bLimpiar.setBounds(110, 870, 73, 23);

        bVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVentanaCategoria/volver.png"))); // NOI18N
        bVolver.setOpaque(false);
        bVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bVolverActionPerformed(evt);
            }
        });
        getContentPane().add(bVolver);
        bVolver.setBounds(1620, 740, 270, 250);

        jLabel1.setText("LIGA");
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(190, 120, 170, 120);
        getContentPane().add(panelOpaco);
        panelOpaco.setBounds(0, -230, 530, 1430);

        lFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgVentanaCategoria/LigaFondo.jpg"))); // NOI18N
        getContentPane().add(lFondo);
        lFondo.setBounds(-320, -250, 2560, 1440);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void bVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bVolverActionPerformed
        // TODO add your handling code here:
        this.dispose();
        MainEsports.lanzarVentanaCategoria();
    }//GEN-LAST:event_bVolverActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaLiga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaLiga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaLiga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaLiga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaLiga().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bInsertar;
    private javax.swing.JButton bLimpiar;
    private javax.swing.JButton bVolver;
    private com.github.lgooddatepicker.components.DatePicker datePicker1;
    private com.github.lgooddatepicker.components.DatePicker datePicker2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JLabel lFondo;
    private javax.swing.JPanel panelOpaco;
    // End of variables declaration//GEN-END:variables
}
