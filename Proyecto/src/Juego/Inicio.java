package Juego;



import javax.swing.JLabel;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jerson
 */
public class Inicio extends javax.swing.JFrame {

    /**
     * Creates new form Inicio
     */
    Manager m;
    public Inicio(Manager m) {
        this.m=m;
        initComponents();
        setLocationRelativeTo(null);
        setSize(1020,640);

        
        
    }



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Leelawadee", 0, 48)); // NOI18N
        jLabel1.setForeground(java.awt.Color.blue);
        jLabel1.setText("Cerebritos");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 80, 250, 70));

        jButton2.setBackground(new java.awt.Color(4, 121, 205));
        jButton2.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(227, 255, 39));
        jButton2.setText("Tetris");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 220, 200, 120));

        jButton3.setBackground(new java.awt.Color(4, 121, 205));
        jButton3.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(227, 255, 39));
        jButton3.setText("adivina el numero");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 400, 200, 120));

        jButton4.setBackground(new java.awt.Color(4, 121, 205));
        jButton4.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(227, 255, 39));
        jButton4.setText("mini tenis");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 400, 200, 120));

        jLabel2.setText("Juego 1");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 180, -1, -1));

        jLabel3.setText("Juego 2");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 370, -1, -1));

        jLabel4.setText("Juego 3");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 360, -1, -1));

        jLabel6.setText("bienvenido ");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 110, -1, -1));

        jLabel7.setText("jLabel7");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 110, -1, -1));

        jLabel5.setText("Creado por Julio Herrera, Jerson Ortega, Sebastian Sanhueza");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 570, 460, 20));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Juego/fondo.jpg"))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -40, 1150, 730));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

      m.tetris.setVisible(true);
      m.tetris.t.start();
    
      
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        m.intruadivina.setVisible(true);
    
        m.adivinanumero.setVisible(false);
      
      
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
m.tenist.setVisible(true);
m.tenist.mo.pollo=true;
m.tenist.mo.frame.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

   
    
    public JLabel getjLabel7() {
        return jLabel7;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    // End of variables declaration//GEN-END:variables
}
