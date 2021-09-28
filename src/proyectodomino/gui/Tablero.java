package proyectodomino.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import proyectodomino.Backtracking;
import proyectodomino.BruteForce;
import proyectodomino.DominoFunctions;
import proyectodomino.FileManager;

public class Tablero extends javax.swing.JFrame {

    private ArrayList<JLabel> tiles;
    private int [][] matriz;
    private int n;
    private ArrayList<int []> soluciones;
    private int currentSolution;
    
    public Tablero() {
        tiles = new ArrayList<>();
        n = 0;
        currentSolution = 0;
        initComponents();
    }

    private void initMatriz(){
        if(matriz == null)
            return;
        
        JLabel tile;
        int x = 0;
        int y = 0;        
        
        //cambia el tamaño del panel y modifica el scrollpane
        panel_matriz.setBounds(0, 0, (n+3)*50, (n+2)*50);
        panel_matriz.setPreferredSize(new Dimension((n+3)*50, (n+2)*50));    
        
        for(int[] fila : matriz){
            for(int num : fila){
                
                tile = new javax.swing.JLabel();
                //if(num <= 6){
                  //  tile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectodomino/gui/domino"+num+".png")));
                //}
                //else{
                    tile.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                    tile.setText(String.valueOf(num));
                    tile.setOpaque(true);
                //}

                panel_matriz.add(tile);
                tile.setBounds(x, y, 50, 50);
                tiles.add(tile);

                x += 50;
            }
            y += 50;
            x = 0;
        }
    }
    
    private void nextSolution(){
        currentSolution++;
        if(currentSolution >= soluciones.size()){
            currentSolution = 0;
        }
    }
    
    private void setTileColor(int fila, int columna, Color color){
        int maxColumna = n+2;
        int casilla = (maxColumna*fila)+columna;
        //tiles.get(casilla).setBorder(javax.swing.BorderFactory.createLineBorder(color, 4));
        tiles.get(casilla).setBackground(color);
    }
    
    private Color getRandomColor(){
        Random random = new Random();
        return Color.getHSBColor(random.nextFloat(), (float)0.8, (float)0.8);
    }
    
    private void setTextSolution(String s){
        txt_respuesta.setText(null);
        txt_respuesta.append("("+currentSolution+")  "+s+"\n");
    }
    
    private String toStringSolution(int [] solution){
        return Arrays.toString(soluciones.get(currentSolution));
    }

    private void paintSolution(){
        int [][] matriz2 = DominoFunctions.copyMatriz(matriz);
        int [] solucion = soluciones.get(currentSolution);
        int fila = 0;
        int columna = 0;
        int pos = 0;
        
        //muestra la solucion
        setTextSolution(toStringSolution(solucion)); 
        
        for(int [] f : matriz2){
            for(int c : f){
                if(c != -1){
                    Color color = getRandomColor();
                    setTileColor(fila, columna, color);
                    matriz2[fila][columna] = -1;
                    switch (solucion[pos]) {
                        case 0:
                            setTileColor(fila, columna+1, color);
                            matriz2[fila][columna+1] = -1;
                            break;
                        case 1:
                            setTileColor(fila+1, columna, color);
                            matriz2[fila+1][columna] = -1;
                            break;
                    } pos++;
                } columna++;
            } fila++;
            columna = 0;
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        panel_menu = new javax.swing.JPanel();
        backtracking = new javax.swing.JButton();
        fuerzaBruta = new javax.swing.JButton();
        lbl_tipoAlgoritmo = new javax.swing.JLabel();
        generarMatriz = new javax.swing.JButton();
        ingresarN = new javax.swing.JSpinner();
        ingreseN = new javax.swing.JLabel();
        reset = new javax.swing.JButton();
        lbl_menu = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_respuesta = new javax.swing.JTextArea();
        scrollPane_matriz = new javax.swing.JScrollPane();
        panel_matriz = new javax.swing.JPanel();
        btn_next = new javax.swing.JButton();
        lbl_respuesta = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dominó");
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(255, 255, 255));
        setBounds(new java.awt.Rectangle(450, 125, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("domino.png")).getImage());
        setMinimumSize(new java.awt.Dimension(1080, 850));
        setResizable(false);

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setPreferredSize(new java.awt.Dimension(980, 710));
        background.setLayout(null);

        panel_menu.setBackground(new java.awt.Color(255, 255, 255));
        panel_menu.setLayout(null);

        backtracking.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectodomino/gui/button-06.png"))); // NOI18N
        backtracking.setBorderPainted(false);
        backtracking.setContentAreaFilled(false);
        backtracking.setFocusPainted(false);
        backtracking.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectodomino/gui/button-07.png"))); // NOI18N
        backtracking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backtrackingActionPerformed(evt);
            }
        });
        panel_menu.add(backtracking);
        backtracking.setBounds(110, 450, 110, 70);

        fuerzaBruta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectodomino/gui/button-08.png"))); // NOI18N
        fuerzaBruta.setBorderPainted(false);
        fuerzaBruta.setContentAreaFilled(false);
        fuerzaBruta.setFocusPainted(false);
        fuerzaBruta.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectodomino/gui/button-09.png"))); // NOI18N
        fuerzaBruta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fuerzaBrutaActionPerformed(evt);
            }
        });
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

        background.add(panel_menu);
        panel_menu.setBounds(0, 0, 330, 810);

        txt_respuesta.setColumns(20);
        txt_respuesta.setRows(5);
        jScrollPane1.setViewportView(txt_respuesta);

        background.add(jScrollPane1);
        jScrollPane1.setBounds(340, 100, 560, 50);

        panel_matriz.setBackground(new java.awt.Color(255, 255, 255));
        panel_matriz.setPreferredSize(new java.awt.Dimension(550, 500));

        javax.swing.GroupLayout panel_matrizLayout = new javax.swing.GroupLayout(panel_matriz);
        panel_matriz.setLayout(panel_matrizLayout);
        panel_matrizLayout.setHorizontalGroup(
            panel_matrizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
        );
        panel_matrizLayout.setVerticalGroup(
            panel_matrizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        scrollPane_matriz.setViewportView(panel_matriz);

        background.add(scrollPane_matriz);
        scrollPane_matriz.setBounds(340, 180, 560, 490);

        btn_next.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectodomino/gui/next-17.png"))); // NOI18N
        btn_next.setBorderPainted(false);
        btn_next.setContentAreaFilled(false);
        btn_next.setEnabled(false);
        btn_next.setFocusPainted(false);
        btn_next.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectodomino/gui/next-16.png"))); // NOI18N
        btn_next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nextActionPerformed(evt);
            }
        });
        background.add(btn_next);
        btn_next.setBounds(660, 30, 60, 60);

        lbl_respuesta.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lbl_respuesta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_respuesta.setText("Respuesta      ");
        background.add(lbl_respuesta);
        lbl_respuesta.setBounds(340, 40, 560, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        //elimina los tiles del panel
        panel_matriz.removeAll();
        panel_matriz.repaint();
        //elimina los tiles del todo
        tiles.clear();
        //habilita/deshabilita los botones
        reset.setEnabled(false);
        btn_next.setEnabled(false);
        generarMatriz.setEnabled(true);
        fuerzaBruta.setEnabled(false);
        backtracking.setEnabled(false);
        currentSolution = 0;
    }//GEN-LAST:event_resetActionPerformed

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
        fuerzaBruta.setEnabled(true);
        backtracking.setEnabled(true);
    }//GEN-LAST:event_generarMatrizActionPerformed

    private void fuerzaBrutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fuerzaBrutaActionPerformed
        //llama al algoritmo
        double datetime1 = System.nanoTime();
        soluciones = BruteForce.exec(matriz, n);
        double datetime2 = System.nanoTime();
        System.out.print("\n"+(datetime2-datetime1));
               
        //pinta la solucion
        paintSolution();
        //activa el boton para pasar respuestas
        btn_next.setEnabled(true);
    }//GEN-LAST:event_fuerzaBrutaActionPerformed

    private void backtrackingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backtrackingActionPerformed

        //llama al algoritmo
        soluciones = Backtracking.exec(matriz,n);
        //pinta la solucion
        paintSolution();
        //activa el boton para pasar respuestas
        btn_next.setEnabled(true);
    }//GEN-LAST:event_backtrackingActionPerformed

    private void btn_nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nextActionPerformed
        //avanza a la sig solucion
        nextSolution();
        //muestra la siguiente respuesta en la matriz
        paintSolution();
    }//GEN-LAST:event_btn_nextActionPerformed

    
    
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
    private javax.swing.JPanel background;
    private javax.swing.JButton backtracking;
    private javax.swing.JButton btn_next;
    private javax.swing.JButton fuerzaBruta;
    private javax.swing.JButton generarMatriz;
    private javax.swing.JSpinner ingresarN;
    private javax.swing.JLabel ingreseN;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_menu;
    private javax.swing.JLabel lbl_respuesta;
    private javax.swing.JLabel lbl_tipoAlgoritmo;
    private javax.swing.JPanel panel_matriz;
    private javax.swing.JPanel panel_menu;
    private javax.swing.JButton reset;
    private javax.swing.JScrollPane scrollPane_matriz;
    private javax.swing.JTextArea txt_respuesta;
    // End of variables declaration//GEN-END:variables
}
