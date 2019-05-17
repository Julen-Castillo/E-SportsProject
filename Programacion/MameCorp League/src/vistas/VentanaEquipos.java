/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import main.MainEsports;

/**
 *
 * @author PETO
 */
public class VentanaEquipos extends javax.swing.JFrame {
    private String operacion;

    /**
     * Creates new form VentanaEquipos
     */
    public VentanaEquipos(String operacionActiva) {
        initComponents();
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        panelOpaco.setBackground(new Color(2,91,136,190));
        operacion = operacionActiva;
        mostrarOocultarfields();
    }
    public VentanaEquipos(){
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelOpaco = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        tfNombre = new javax.swing.JTextField();
        tfPresupuesto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfPuntos = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        bLimpiar = new javax.swing.JButton();
        bInsertar = new javax.swing.JButton();
        lFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        panelOpaco.setLayout(null);

        jLabel3.setText("NOMBRE");
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        panelOpaco.add(jLabel3);
        jLabel3.setBounds(20, 300, 100, 17);
        panelOpaco.add(tfNombre);
        tfNombre.setBounds(160, 300, 200, 20);
        panelOpaco.add(tfPresupuesto);
        tfPresupuesto.setBounds(160, 340, 200, 20);

        jLabel4.setText("PRESUPUESTO");
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        panelOpaco.add(jLabel4);
        jLabel4.setBounds(20, 340, 130, 17);

        jLabel5.setText("PUNTOS");
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        panelOpaco.add(jLabel5);
        jLabel5.setBounds(20, 380, 70, 17);
        panelOpaco.add(tfPuntos);
        tfPuntos.setBounds(160, 380, 200, 20);

        jLabel2.setText("EQUIPO");
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        panelOpaco.add(jLabel2);
        jLabel2.setBounds(70, 150, 340, 140);

        bLimpiar.setText("Limpiar");
        bLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLimpiarActionPerformed(evt);
            }
        });
        panelOpaco.add(bLimpiar);
        bLimpiar.setBounds(20, 440, 90, 23);

        bInsertar.setText("Insertar");
        bInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bInsertarActionPerformed(evt);
            }
        });
        panelOpaco.add(bInsertar);
        bInsertar.setBounds(261, 440, 100, 23);

        getContentPane().add(panelOpaco);
        panelOpaco.setBounds(0, -140, 400, 1310);

        lFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vistas/Imgs/ImgEquipo/EquipoFondo.png"))); // NOI18N
        lFondo.setText("jLabel6");
        getContentPane().add(lFondo);
        lFondo.setBounds(-380, -170, 2350, 1400);

        pack();
    }// </editor-fold>//GEN-END:initComponents
   public void mostrarOocultarfields(){
       
       if(operacion.equals("baja")){
           tfPresupuesto.setEnabled(false);
           tfPuntos.setEnabled(false);
       }
      
       
   }
    
    private void bLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLimpiarActionPerformed
    /**
     * Con el bLimpiar borramos todos los datos que se han tecleado en los 
     * labels de esta ventana, dejandolos asi en blanco.
     */   
    //BONTON LIMPIAR
        tfNombre.setText("");
        tfPresupuesto.setText("");
        tfPuntos.setText(""); 
    
    }//GEN-LAST:event_bLimpiarActionPerformed

    private void bInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bInsertarActionPerformed
        try {
           
            int insercion= MainEsports.insertarEquipos(tfNombre.getText(),Integer.parseInt(tfPresupuesto.getText()),Integer.parseInt(tfPuntos.getText()));
            
            if(insercion > 0){
                JOptionPane.showMessageDialog(this,"Linea insertada correctamente");
            }else{
                JOptionPane.showMessageDialog(this,"ERROR AL INSERTAR");
            }
            
        } catch (Exception ex) {
            System.out.println(ex.getClass() + ex.getMessage());
        }
        
    }//GEN-LAST:event_bInsertarActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaEquipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaEquipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaEquipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaEquipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaEquipos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bInsertar;
    private javax.swing.JButton bLimpiar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lFondo;
    private javax.swing.JPanel panelOpaco;
    private javax.swing.JTextField tfNombre;
    private javax.swing.JTextField tfPresupuesto;
    private javax.swing.JTextField tfPuntos;
    // End of variables declaration//GEN-END:variables
}
