package vistas;

import java.applet.AudioClip;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import main.MainEsports;
import modelo.Jornada;

/**
 *
 * @author N3Essential
 */
public class VentanaCategoria extends javax.swing.JFrame {
        
    private String operacionActiva;
    private String opcionActiva;
    private ArrayList<Jornada> listaJornadas;
    private static AudioClip sonido;
    
    /**
     * Creates new form VentanaCategoria
     */
    public VentanaCategoria() {
        setUndecorated(true);
        initComponents();
        setAlwaysOnTop(rootPaneCheckingEnabled);
        setExtendedState(MAXIMIZED_BOTH);
        disableCRUD();
        setVisible(true); 
        panelTA.setVisible(false);
      String hola = MainEsports.getNombreUser();
      
        lUser.setText(hola);
        lTipo.setText("Administrador:");
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bJornadas = new javax.swing.JButton();
        bEquipos = new javax.swing.JButton();
        bJugadores = new javax.swing.JButton();
        bPartidos = new javax.swing.JButton();
        bPresidentes = new javax.swing.JButton();
        bLiga = new javax.swing.JButton();
        bAlta = new javax.swing.JButton();
        bModificar = new javax.swing.JButton();
        bBaja = new javax.swing.JButton();
        bConsultar = new javax.swing.JButton();
        lTipo = new javax.swing.JLabel();
        lUser = new javax.swing.JLabel();
        bLogOut = new javax.swing.JButton();
        bNoSimular = new javax.swing.JButton();
        bSimular = new javax.swing.JButton();
        lConfirmacionSimular = new javax.swing.JLabel();
        bGenerarCalendario = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        panelTA = new javax.swing.JScrollPane();
        taMostrarEquipos = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuCategoria = new javax.swing.JMenu();
        miLiga = new javax.swing.JMenuItem();
        miJornadas = new javax.swing.JMenuItem();
        miPartidos = new javax.swing.JMenuItem();
        miEquipos = new javax.swing.JMenuItem();
        miJugadores = new javax.swing.JMenuItem();
        miPresidentes = new javax.swing.JMenuItem();
        jMenuCuentas = new javax.swing.JMenu();
        miAdministradores = new javax.swing.JMenuItem();
        jMenuVolver = new javax.swing.JMenu();
        jMenuSalir = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        bJornadas.setBackground(new java.awt.Color(0, 102, 102));
        bJornadas.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        bJornadas.setForeground(new java.awt.Color(255, 255, 255));
        bJornadas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vistas/Imgs/imgVentanaCategoria/Jornada.png"))); // NOI18N
        bJornadas.setText("   JORNADAS");
        bJornadas.setBorder(null);
        bJornadas.setBorderPainted(false);
        bJornadas.setContentAreaFilled(false);
        bJornadas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bJornadas.setFocusPainted(false);
        getContentPane().add(bJornadas);
        bJornadas.setBounds(180, 160, 230, 50);

        bEquipos.setBackground(new java.awt.Color(0, 102, 102));
        bEquipos.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        bEquipos.setForeground(new java.awt.Color(255, 255, 255));
        bEquipos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vistas/Imgs/imgVentanaCategoria/Equipo.png"))); // NOI18N
        bEquipos.setText("    EQUIPOS");
        bEquipos.setBorder(null);
        bEquipos.setContentAreaFilled(false);
        bEquipos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bEquipos.setFocusPainted(false);
        bEquipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEquiposActionPerformed(evt);
            }
        });
        getContentPane().add(bEquipos);
        bEquipos.setBounds(160, 320, 260, 70);

        bJugadores.setBackground(new java.awt.Color(0, 102, 102));
        bJugadores.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        bJugadores.setForeground(new java.awt.Color(255, 255, 255));
        bJugadores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vistas/Imgs/imgVentanaCategoria/JugadorEsports.png"))); // NOI18N
        bJugadores.setText("   JUGADORES");
        bJugadores.setBorder(null);
        bJugadores.setContentAreaFilled(false);
        bJugadores.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bJugadores.setFocusPainted(false);
        bJugadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bJugadoresActionPerformed(evt);
            }
        });
        getContentPane().add(bJugadores);
        bJugadores.setBounds(170, 420, 260, 50);

        bPartidos.setBackground(new java.awt.Color(0, 102, 102));
        bPartidos.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        bPartidos.setForeground(new java.awt.Color(255, 255, 255));
        bPartidos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vistas/Imgs/imgVentanaCategoria/Partido.png"))); // NOI18N
        bPartidos.setText("    PARTIDOS");
        bPartidos.setBorder(null);
        bPartidos.setContentAreaFilled(false);
        bPartidos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bPartidos.setFocusPainted(false);
        getContentPane().add(bPartidos);
        bPartidos.setBounds(180, 240, 230, 60);

        bPresidentes.setBackground(new java.awt.Color(0, 102, 102));
        bPresidentes.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        bPresidentes.setForeground(new java.awt.Color(255, 255, 255));
        bPresidentes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vistas/Imgs/imgVentanaCategoria/Presidentes.png"))); // NOI18N
        bPresidentes.setText("  PRESIDENTES");
        bPresidentes.setBorder(null);
        bPresidentes.setContentAreaFilled(false);
        bPresidentes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bPresidentes.setFocusPainted(false);
        bPresidentes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPresidentesActionPerformed(evt);
            }
        });
        getContentPane().add(bPresidentes);
        bPresidentes.setBounds(160, 500, 290, 70);

        bLiga.setBackground(new java.awt.Color(255, 255, 255));
        bLiga.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        bLiga.setForeground(new java.awt.Color(255, 255, 255));
        bLiga.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vistas/Imgs/imgVentanaCategoria/Icono liga.png"))); // NOI18N
        bLiga.setText("        LIGA");
        bLiga.setBorder(null);
        bLiga.setContentAreaFilled(false);
        bLiga.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bLiga.setFocusPainted(false);
        bLiga.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                bLigaMouseMoved(evt);
            }
        });
        bLiga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLigaActionPerformed(evt);
            }
        });
        getContentPane().add(bLiga);
        bLiga.setBounds(180, 70, 190, 60);

        bAlta.setBackground(new java.awt.Color(255, 255, 255));
        bAlta.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        bAlta.setForeground(new java.awt.Color(255, 255, 255));
        bAlta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vistas/Imgs/imgVentanaCategoria/Alta.png"))); // NOI18N
        bAlta.setText("       ALTA");
        bAlta.setBorder(null);
        bAlta.setContentAreaFilled(false);
        bAlta.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bAlta.setFocusPainted(false);
        bAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAltaActionPerformed(evt);
            }
        });
        getContentPane().add(bAlta);
        bAlta.setBounds(160, 160, 250, 60);

        bModificar.setBackground(new java.awt.Color(255, 255, 255));
        bModificar.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        bModificar.setForeground(new java.awt.Color(255, 255, 255));
        bModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vistas/Imgs/imgVentanaCategoria/Modify.png"))); // NOI18N
        bModificar.setText("   MODIFICAR");
        bModificar.setBorder(null);
        bModificar.setContentAreaFilled(false);
        bModificar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bModificar.setFocusPainted(false);
        bModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bModificarActionPerformed(evt);
            }
        });
        getContentPane().add(bModificar);
        bModificar.setBounds(180, 260, 240, 60);

        bBaja.setBackground(new java.awt.Color(255, 255, 255));
        bBaja.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        bBaja.setForeground(new java.awt.Color(255, 255, 255));
        bBaja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vistas/Imgs/imgVentanaCategoria/Baja.png"))); // NOI18N
        bBaja.setText("         BAJA");
        bBaja.setBorder(null);
        bBaja.setContentAreaFilled(false);
        bBaja.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bBaja.setFocusPainted(false);
        bBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBajaActionPerformed(evt);
            }
        });
        getContentPane().add(bBaja);
        bBaja.setBounds(150, 350, 270, 60);

        bConsultar.setBackground(new java.awt.Color(255, 255, 255));
        bConsultar.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        bConsultar.setForeground(new java.awt.Color(255, 255, 255));
        bConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vistas/Imgs/imgVentanaCategoria/Consultar.png"))); // NOI18N
        bConsultar.setText("   CONSULTAR");
        bConsultar.setBorder(null);
        bConsultar.setContentAreaFilled(false);
        bConsultar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bConsultar.setFocusPainted(false);
        bConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bConsultarActionPerformed(evt);
            }
        });
        getContentPane().add(bConsultar);
        bConsultar.setBounds(170, 440, 270, 60);

        lTipo.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        lTipo.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(lTipo);
        lTipo.setBounds(1470, 40, 150, 30);

        lUser.setFont(new java.awt.Font("Roboto Light", 1, 18)); // NOI18N
        lUser.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(lUser);
        lUser.setBounds(1640, 40, 160, 30);

        bLogOut.setBackground(new java.awt.Color(255, 0, 0));
        bLogOut.setForeground(new java.awt.Color(255, 255, 255));
        bLogOut.setText("Log Out!");
        bLogOut.setBorder(null);
        bLogOut.setBorderPainted(false);
        bLogOut.setFocusPainted(false);
        bLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLogOutActionPerformed(evt);
            }
        });
        getContentPane().add(bLogOut);
        bLogOut.setBounds(1735, 130, 90, 30);

        bNoSimular.setBackground(new java.awt.Color(0, 153, 153));
        bNoSimular.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        bNoSimular.setForeground(new java.awt.Color(255, 255, 255));
        bNoSimular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vistas/Imgs/imgVentanaCategoria/play.png"))); // NOI18N
        bNoSimular.setText("  NO SIMULAR");
        bNoSimular.setBorder(null);
        bNoSimular.setBorderPainted(false);
        bNoSimular.setContentAreaFilled(false);
        bNoSimular.setFocusPainted(false);
        bNoSimular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNoSimularActionPerformed(evt);
            }
        });
        getContentPane().add(bNoSimular);
        bNoSimular.setBounds(380, 220, 200, 70);

        bSimular.setBackground(new java.awt.Color(0, 153, 153));
        bSimular.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        bSimular.setForeground(new java.awt.Color(255, 255, 255));
        bSimular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vistas/Imgs/imgVentanaCategoria/simular.png"))); // NOI18N
        bSimular.setText("SIMULAR");
        bSimular.setBorder(null);
        bSimular.setBorderPainted(false);
        bSimular.setContentAreaFilled(false);
        bSimular.setFocusPainted(false);
        bSimular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSimularActionPerformed(evt);
            }
        });
        getContentPane().add(bSimular);
        bSimular.setBounds(120, 210, 170, 90);

        lConfirmacionSimular.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        lConfirmacionSimular.setForeground(new java.awt.Color(255, 255, 255));
        lConfirmacionSimular.setText("PEPITO EL ALGORITMO");
        getContentPane().add(lConfirmacionSimular);
        lConfirmacionSimular.setBounds(230, 390, 290, 40);

        bGenerarCalendario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vistas/Imgs/imgVentanaCategoria/Jornada.png"))); // NOI18N
        bGenerarCalendario.setBorderPainted(false);
        bGenerarCalendario.setContentAreaFilled(false);
        bGenerarCalendario.setFocusPainted(false);
        bGenerarCalendario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGenerarCalendarioActionPerformed(evt);
            }
        });
        getContentPane().add(bGenerarCalendario);
        bGenerarCalendario.setBounds(1640, 870, 80, 70);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("GENERAR CALENDARIO");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(1540, 840, 270, 20);

        taMostrarEquipos.setColumns(20);
        taMostrarEquipos.setRows(5);
        panelTA.setViewportView(taMostrarEquipos);

        getContentPane().add(panelTA);
        panelTA.setBounds(650, 250, 690, 150);

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vistas/Imgs/imgVentanaCategoria/FondoCategoria.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(-260, -630, 3500, 2650);

        jMenuBar1.setForeground(new java.awt.Color(255, 255, 255));

        jMenuCategoria.setText("Categoria");

        miLiga.setText("Liga");
        miLiga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miLigaActionPerformed(evt);
            }
        });
        jMenuCategoria.add(miLiga);

        miJornadas.setText("Jornadas");
        miJornadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miJornadasActionPerformed(evt);
            }
        });
        jMenuCategoria.add(miJornadas);

        miPartidos.setText("Partidos");
        miPartidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miPartidosActionPerformed(evt);
            }
        });
        jMenuCategoria.add(miPartidos);

        miEquipos.setText("Equipos");
        miEquipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miEquiposActionPerformed(evt);
            }
        });
        jMenuCategoria.add(miEquipos);

        miJugadores.setText("Jugadores");
        miJugadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miJugadoresActionPerformed(evt);
            }
        });
        jMenuCategoria.add(miJugadores);

        miPresidentes.setText("Presidentes");
        miPresidentes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miPresidentesActionPerformed(evt);
            }
        });
        jMenuCategoria.add(miPresidentes);

        jMenuBar1.add(jMenuCategoria);

        jMenuCuentas.setText("Cuentas");

        miAdministradores.setText("Administradores");
        miAdministradores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAdministradoresActionPerformed(evt);
            }
        });
        jMenuCuentas.add(miAdministradores);

        jMenuBar1.add(jMenuCuentas);

        jMenuVolver.setText("Volver");
        jMenuVolver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuVolverMouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenuVolver);

        jMenuSalir.setText("Salir");
        jMenuSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuSalir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMenuSalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMenuSalir.setInheritsPopupMenu(true);
        jMenuSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuSalirMouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenuSalir);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bEquiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEquiposActionPerformed
       operacionActiva = "equipo";
        ocultarBotonesYMostrarCrud();
      // this.dispose();
     //  ControladorVista.mostrarVentanaEquipos();
    }//GEN-LAST:event_bEquiposActionPerformed

    private void bJugadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bJugadoresActionPerformed
        
        operacionActiva = "jugador";
        ocultarBotonesYMostrarCrud();
        //this.dispose();
       // ControladorVista.mostrarVentanaJugador();
    }//GEN-LAST:event_bJugadoresActionPerformed

    private void miLigaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miLigaActionPerformed
        bLiga.doClick();
    }//GEN-LAST:event_miLigaActionPerformed

    private void miJornadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miJornadasActionPerformed
        bJornadas.doClick();
    }//GEN-LAST:event_miJornadasActionPerformed

    private void bModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bModificarActionPerformed
            //this.dispose();
       if (operacionActiva.equals("liga")){
            ControladorVista.mostrarVentanaLiga("modificar");   
            this.dispose();
       }
       else {
           if (operacionActiva.equals("jugador")){
               try {
                   ControladorVista.mostrarVentanaJugador("modificar");
                   this.dispose();
               } catch (Exception ex) {
                   Logger.getLogger(VentanaCategoria.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
           else {
               if (operacionActiva.equals("presidente")){
                   try {
                       JOptionPane.showMessageDialog(this, "En mantenimiento hasta despues de los examenes");
                   } catch (Exception ex) {
                       Logger.getLogger(VentanaCategoria.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               else {
                 if  (operacionActiva.equals("equipo")){
                    try {
                    ControladorVista.mostrarVentanaEquipos("modificar");
                    this.dispose();
                    }catch (Exception ex) {
                         Logger.getLogger(VentanaCategoria.class.getName()).log(Level.SEVERE, null, ex);
                    }                 
               }
               }
           }
       }
    }//GEN-LAST:event_bModificarActionPerformed

    private void bPresidentesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPresidentesActionPerformed
        operacionActiva = "presidente";
        ocultarBotonesYMostrarCrud();
      //  this.dispose();
       // ControladorVista.mostrarVentanaPresidente();
    }//GEN-LAST:event_bPresidentesActionPerformed

    private void miEquiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miEquiposActionPerformed
        bEquipos.doClick();
    }//GEN-LAST:event_miEquiposActionPerformed

    private void bLigaMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bLigaMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_bLigaMouseMoved

    private void bLigaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLigaActionPerformed
       operacionActiva = "liga";
        ocultarBotonesYMostrarSimular();        
    }//GEN-LAST:event_bLigaActionPerformed

    private void bBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBajaActionPerformed
           //this.dispose();
        if (operacionActiva.equals("liga")){
             ControladorVista.mostrarVentanaLiga("baja");
             this.dispose();
        }
        else {
            if (operacionActiva.equals("jugador")){
                try {
                    ControladorVista.mostrarVentanaJugador("baja");
                    this.dispose();
                } catch (Exception ex) {
                    Logger.getLogger(VentanaCategoria.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        else {
            if (operacionActiva.equals("presidente")){
                try {
                    ControladorVista.mostrarVentanaPresidente("baja");
                    this.dispose();
                } catch (Exception ex) {
                    Logger.getLogger(VentanaCategoria.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        else {
          if  (operacionActiva.equals("equipo")){
              try {
                  ControladorVista.mostrarVentanaEquipos("baja");
                  this.dispose();
                  
              } catch (Exception ex) {
                  Logger.getLogger(VentanaCategoria.class.getName()).log(Level.SEVERE, null, ex);
              }

        }
               }
           }
       }
    
    }//GEN-LAST:event_bBajaActionPerformed

    private void bConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bConsultarActionPerformed
        try {
          
            String listaEquipos = MainEsports.llamarProcedureVisualizarEquipos();
             
             taMostrarEquipos.setText(listaEquipos);
             taMostrarEquipos.setEditable(false);
             panelTA.setVisible(true);
             
            
        } catch (Exception ex) {
            Logger.getLogger(VentanaCategoria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bConsultarActionPerformed

    private void bAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAltaActionPerformed
            
        this.dispose();
       if (operacionActiva.equals("liga")){
            ControladorVista.mostrarVentanaLiga("alta");   
       }
       else {
           if (operacionActiva.equals("jugador")){
               try {
                   ControladorVista.mostrarVentanaJugador("alta");
               } catch (Exception ex) {
                   Logger.getLogger(VentanaCategoria.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
           else {
               if (operacionActiva.equals("presidente")){
                   try {
                       ControladorVista.mostrarVentanaPresidente("alta");
                   } catch (Exception ex) {
                       Logger.getLogger(VentanaCategoria.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               else {
                 if  (operacionActiva.equals("equipo")){
                     try {
                         ControladorVista.mostrarVentanaEquipos("alta");
                     } catch (Exception ex) {
                         Logger.getLogger(VentanaCategoria.class.getName()).log(Level.SEVERE, null, ex);
                     }
               }
                 else {
                     if (operacionActiva.equals("jornada")){
                     // ControladorVista.blablabla
                 }
                     else {
                         
                         if (operacionActiva.equals("partido")){
                             // ControladorVista.blablabla
                         }
                     }
                     
                 }
                     
               }
           }
   
       }
       
        
    }//GEN-LAST:event_bAltaActionPerformed

    private void jMenuVolverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuVolverMouseClicked
        disableCRUD();
        showCategorias();
        panelTA.setVisible(false);
    }//GEN-LAST:event_jMenuVolverMouseClicked

    private void miPartidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miPartidosActionPerformed
        bPartidos.doClick();
    }//GEN-LAST:event_miPartidosActionPerformed

    private void miJugadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miJugadoresActionPerformed
        bJugadores.doClick();
    }//GEN-LAST:event_miJugadoresActionPerformed

    private void miPresidentesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miPresidentesActionPerformed
        bPresidentes.doClick();
    }//GEN-LAST:event_miPresidentesActionPerformed

    private void miAdministradoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAdministradoresActionPerformed
        ocultarBotonesYMostrarCrud();
        opcionActiva = "alta";
        this.dispose();
        ControladorVista.mostrarVentanaAdministradores(opcionActiva);
    }//GEN-LAST:event_miAdministradoresActionPerformed

    private void jMenuSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuSalirMouseClicked
        System.exit(0);
    }//GEN-LAST:event_jMenuSalirMouseClicked

    private void bLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLogOutActionPerformed
        /**
         * El botón de LogOut devuelve al usuario a la ventana de LogIn
         */
        this.dispose();
        try {
            ControladorVista.mostrarLogin();
        } catch (Exception ex) {
            Logger.getLogger(VentanaCategoria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bLogOutActionPerformed

    private void bSimularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSimularActionPerformed
        try {
            MainEsports.crearRoundRobinEmparejamientos(true);
        } catch (Exception ex) {
            Logger.getLogger(VentanaCategoria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bSimularActionPerformed

    private void bNoSimularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNoSimularActionPerformed
        try {
            MainEsports.crearRoundRobinEmparejamientos(false);
        } catch (Exception ex) {
            Logger.getLogger(VentanaCategoria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bNoSimularActionPerformed

    private void bGenerarCalendarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGenerarCalendarioActionPerformed

        try {
            sonido = java.applet.Applet.newAudioClip(getClass().getResource("/music/letsgo.wav"));
            sonido.play();
            
            listaJornadas = MainEsports.consultarJornadas();
            
            JOptionPane.showMessageDialog(this, "Calendario creado correctamente");
       
            MainEsports.generarCalendario();
        } catch (Exception ex) {
            Logger.getLogger(VentanaCategoria.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_bGenerarCalendarioActionPerformed
    
    public final void disableCRUD(){
        lConfirmacionSimular.setVisible(false);
        bSimular.setVisible(false);
        bNoSimular.setVisible(false);
        bAlta.setVisible(false);
        bModificar.setVisible(false);
        bBaja.setVisible(false);
        bConsultar.setVisible(false);
    }
    
    public void ocultarBotonesYMostrarCrud(){
        bAlta.setVisible(true);
        bModificar.setVisible(true);
        bBaja.setVisible(true);
        bConsultar.setVisible(true);
        
        bLiga.setVisible(false);
        bJornadas.setVisible(false);
        bPartidos.setVisible(false);
        bEquipos.setVisible(false);
        bJugadores.setVisible(false);
        bPresidentes.setVisible(false);
    }
    
    public void ocultarBotonesYMostrarSimular(){
        bSimular.setVisible(true);
        bNoSimular.setVisible(true);
        
        bLiga.setVisible(false);
        bJornadas.setVisible(false);
        bPartidos.setVisible(false);
        bEquipos.setVisible(false);
        bJugadores.setVisible(false);
        bPresidentes.setVisible(false);
    }
    
    public void showCategorias(){
        bLiga.setVisible(true);
        bJornadas.setVisible(true);
        bPartidos.setVisible(true);
        bEquipos.setVisible(true);
        bJugadores.setVisible(true);
        bPresidentes.setVisible(true);
    }
    
    public void simulacionCorrecta(){
        lConfirmacionSimular.setText("Successful simulation!");
        lConfirmacionSimular.setVisible(true);
    }
    public void simulacionError(){
        lConfirmacionSimular.setText("Error en la simulacion");
        lConfirmacionSimular.setVisible(true);
    }
    public void emparejamientosCorrectos(){
        lConfirmacionSimular.setText("Emparejamientos realizados");
        lConfirmacionSimular.setVisible(true);
    }
    
    
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
            java.util.logging.Logger.getLogger(VentanaCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaCategoria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAlta;
    private javax.swing.JButton bBaja;
    private javax.swing.JButton bConsultar;
    private javax.swing.JButton bEquipos;
    private javax.swing.JButton bGenerarCalendario;
    private javax.swing.JButton bJornadas;
    private javax.swing.JButton bJugadores;
    private javax.swing.JButton bLiga;
    private javax.swing.JButton bLogOut;
    private javax.swing.JButton bModificar;
    private javax.swing.JButton bNoSimular;
    private javax.swing.JButton bPartidos;
    private javax.swing.JButton bPresidentes;
    private javax.swing.JButton bSimular;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuCategoria;
    private javax.swing.JMenu jMenuCuentas;
    private javax.swing.JMenu jMenuSalir;
    private javax.swing.JMenu jMenuVolver;
    private javax.swing.JLabel lConfirmacionSimular;
    private javax.swing.JLabel lTipo;
    private javax.swing.JLabel lUser;
    private javax.swing.JMenuItem miAdministradores;
    private javax.swing.JMenuItem miEquipos;
    private javax.swing.JMenuItem miJornadas;
    private javax.swing.JMenuItem miJugadores;
    private javax.swing.JMenuItem miLiga;
    private javax.swing.JMenuItem miPartidos;
    private javax.swing.JMenuItem miPresidentes;
    private javax.swing.JScrollPane panelTA;
    private javax.swing.JTextArea taMostrarEquipos;
    // End of variables declaration//GEN-END:variables
}
