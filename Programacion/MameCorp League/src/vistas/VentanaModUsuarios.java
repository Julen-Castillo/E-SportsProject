package vistas;

import java.awt.Color;

/**
 *
 * @author N3Essential
 */
public class VentanaModUsuarios extends javax.swing.JFrame {

    /**
     * Creates new form VentanaAdministradores
     */
    public VentanaModUsuarios() {
        setUndecorated(true);
        initComponents();
        setAlwaysOnTop(rootPaneCheckingEnabled);
        setExtendedState(MAXIMIZED_BOTH);
        panelOpaco.setBackground(new Color(255,255,255,190));
        setVisible(true);
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
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        bAceptar = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuVolver = new javax.swing.JMenu();
        jMenuSalir = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("NOMBRE");

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel4.setText("USUARIO");

        bAceptar.setText("VOLVER");
        bAceptar.setBackground(new java.awt.Color(83, 175, 226));
        bAceptar.setBorder(null);
        bAceptar.setContentAreaFilled(false);
        bAceptar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bAceptar.setFocusPainted(false);
        bAceptar.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        bAceptar.setForeground(new java.awt.Color(255, 255, 255));
        bAceptar.setOpaque(true);
        bAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAceptarActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.setBorder(null);

        javax.swing.GroupLayout panelOpacoLayout = new javax.swing.GroupLayout(panelOpaco);
        panelOpaco.setLayout(panelOpacoLayout);
        panelOpacoLayout.setHorizontalGroup(
            panelOpacoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelOpacoLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(panelOpacoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelOpacoLayout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81))
                    .addGroup(panelOpacoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelOpacoLayout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addGap(157, 157, 157))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelOpacoLayout.createSequentialGroup()
                            .addComponent(bAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(42, 42, 42)))))
        );
        panelOpacoLayout.setVerticalGroup(
            panelOpacoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOpacoLayout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(181, 181, 181)
                .addGroup(panelOpacoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 586, Short.MAX_VALUE)
                .addComponent(bAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69))
        );

        getContentPane().add(panelOpaco, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 1110));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vistas/Imgs/ImgVentanaAdministradores/admin.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 2030, 1080));

        jMenuVolver.setText("Volver");
        jMenuBar1.add(jMenuVolver);

        jMenuSalir.setText("Salir");
        jMenuSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuSalirMouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenuSalir);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuSalirMouseClicked
        System.exit(0);
    }//GEN-LAST:event_jMenuSalirMouseClicked

    private void bAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAceptarActionPerformed

    }//GEN-LAST:event_bAceptarActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaModUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaModUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaModUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaModUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaModUsuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAceptar;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuSalir;
    private javax.swing.JMenu jMenuVolver;
    private javax.swing.JPanel panelOpaco;
    // End of variables declaration//GEN-END:variables
}
