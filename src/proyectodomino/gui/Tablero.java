package proyectodomino.gui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import proyectodomino.BruteForce;
import proyectodomino.FileManager;

public class Tablero extends javax.swing.JFrame {

    private ArrayList<JLabel> tiles = new ArrayList<>();
    private int [][] matriz = null;
    private int n = 0;
    private int [] solucion = null;
    
    public Tablero() {
        initComponents();
        
    }

    private void initMatriz(){
        if(matriz == null)
            return;
        
        JLabel tile;
        int x = 0;
        int y = 0;        
        
        if(panel_matriz.getSize().height < n*50 || panel_matriz.getSize().width < n*50){
            panel_matriz.setBounds(330, 30, (n+3)*50, (n+2)*50);
        }
        
        for(int[] fila : matriz){
            for(int num : fila){
                
                tile = new javax.swing.JLabel();
                if(num <= 6){
                    tile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectodomino/gui/domino"+num+".png")));
                }
                else{
                    tile.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                    tile.setText(String.valueOf(num));
                }

                panel_matriz.add(tile);
                tile.setBounds(x, y, 50, 50);
                tiles.add(tile);

                x += 50;
            }
            y += 50;
            x = 0;
        }
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_menu = new javax.swing.JPanel();
        backtracking = new javax.swing.JButton();
        fuerzaBruta = new javax.swing.JButton();
        lbl_tipoAlgoritmo = new javax.swing.JLabel();
        generarMatriz = new javax.swing.JButton();
        ingresarN = new javax.swing.JSpinner();
        ingreseN = new javax.swing.JLabel();
        reset = new javax.swing.JButton();
        lbl_menu = new javax.swing.JLabel();
        panel_matriz = new javax.swing.JPanel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dominó");
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(255, 255, 255));
        setBounds(new java.awt.Rectangle(450, 125, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("domino.png")).getImage());
        setMaximumSize(new java.awt.Dimension(10800, 8000));
        setMinimumSize(new java.awt.Dimension(1080, 850));
        setPreferredSize(new java.awt.Dimension(1080, 850));
        getContentPane().setLayout(null);

        panel_menu.setBackground(new java.awt.Color(255, 255, 255));
        panel_menu.setLayout(null);

        backtracking.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectodomino/gui/button-08.png"))); // NOI18N
        backtracking.setBorderPainted(false);
        backtracking.setContentAreaFilled(false);
        backtracking.setFocusPainted(false);
        backtracking.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectodomino/gui/button-09.png"))); // NOI18N
        backtracking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backtrackingActionPerformed(evt);
            }
        });
        panel_menu.add(backtracking);
        backtracking.setBounds(110, 450, 110, 70);

        fuerzaBruta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectodomino/gui/button-06.png"))); // NOI18N
        fuerzaBruta.setBorderPainted(false);
        fuerzaBruta.setContentAreaFilled(false);
        fuerzaBruta.setFocusPainted(false);
        fuerzaBruta.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectodomino/gui/button-07.png"))); // NOI18N
        panel_menu.add(fuerzaBruta);
        fuerzaBruta.setBounds(110, 380, 110, 60);

        lbl_tipoAlgoritmo.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lbl_tipoAlgoritmo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_tipoAlgoritmo.setText("Tipo de algoritmo:");
        panel_menu.add(lbl_tipoAlgoritmo);
        lbl_tipoAlgoritmo.setBounds(50, 330, 230, 40);

        generarMatriz.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectodomino/gui/done_button-02.png"))); // NOI18N
        generarMatriz.setBorder(null);
        generarMatriz.setBorderPainted(false);
        generarMatriz.setContentAreaFilled(false);
        generarMatriz.setFocusPainted(false);
        generarMatriz.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectodomino/gui/done_button-03.png"))); // NOI18N
        generarMatriz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generarMatrizActionPerformed(evt);
            }
        });
        panel_menu.add(generarMatriz);
        generarMatriz.setBounds(130, 240, 70, 60);

        ingresarN.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        panel_menu.add(ingresarN);
        ingresarN.setBounds(110, 180, 110, 40);

        ingreseN.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        ingreseN.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ingreseN.setText("Tamaño del set:");
        panel_menu.add(ingreseN);
        ingreseN.setBounds(50, 140, 230, 30);

        reset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectodomino/gui/reset_button-02.png"))); // NOI18N
        reset.setBorderPainted(false);
        reset.setContentAreaFilled(false);
        reset.setEnabled(false);
        reset.setFocusPainted(false);
        reset.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectodomino/gui/reset_button-03.png"))); // NOI18N
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });
        panel_menu.add(reset);
        reset.setBounds(130, 560, 70, 60);

        lbl_menu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectodomino/gui/frame-01.png"))); // NOI18N
        panel_menu.add(lbl_menu);
        lbl_menu.setBounds(20, 0, 290, 700);

        getContentPane().add(panel_menu);
        panel_menu.setBounds(0, 0, 330, 700);

        panel_matriz.setOpaque(false);
        panel_matriz.setLayout(null);
        getContentPane().add(panel_matriz);
        panel_matriz.setBounds(330, 30, 800, 670);

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setOpaque(true);
        getContentPane().add(background);
        background.setBounds(0, 0, 1920, 1080);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void generarMatrizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generarMatrizActionPerformed
        //lee el n de la matriz
        n = (Integer)ingresarN.getValue();
        try {
            //genera la matriz
            matriz = FileManager.getMatriz(n);
            initMatriz();
        } catch (IOException ex) {
            Logger.getLogger(Tablero.class.getName()).log(Level.SEVERE, null, ex);
        }
        //bloquea el botón hasta que se resetee el programa
        generarMatriz.setEnabled(false);
        reset.setEnabled(true);
    }//GEN-LAST:event_generarMatrizActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        //elimina los tiles del panel 
        panel_matriz.removeAll();
        panel_matriz.repaint();
        //elimina los tiles del todo
        tiles.clear();
        //habilita el botón generarMatriz
        reset.setEnabled(false);
        generarMatriz.setEnabled(true);
    }//GEN-LAST:event_resetActionPerformed

    private void backtrackingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backtrackingActionPerformed
        BruteForce.exec(matriz, solucion, n);
        
    }//GEN-LAST:event_backtrackingActionPerformed

    
    
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
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new Tablero().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JButton backtracking;
    private javax.swing.JButton fuerzaBruta;
    private javax.swing.JButton generarMatriz;
    private javax.swing.JSpinner ingresarN;
    private javax.swing.JLabel ingreseN;
    private javax.swing.JLabel lbl_menu;
    private javax.swing.JLabel lbl_tipoAlgoritmo;
    private javax.swing.JPanel panel_matriz;
    private javax.swing.JPanel panel_menu;
    private javax.swing.JButton reset;
    // End of variables declaration//GEN-END:variables
}
