


import java.awt.BorderLayout;
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
public class Tetris extends javax.swing.JFrame {

    /**
     * Creates new form Tetris
     */
  Manager m;
    public Tetris(Manager m) {
        this.m=m;
        initComponents();
        add(Puntuacion,BorderLayout.SOUTH);
        tablero tab=new tablero(this);
        add(tab);
        tab.start();
        setSize(200, 400);
        setTitle("Tetris");
    }

   
    
    public JLabel obtenerPuntuacion(){
        return Puntuacion;
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Puntuacion = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Puntuacion.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Puntuacion)
                .addGap(0, 390, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 284, Short.MAX_VALUE)
                .addComponent(Puntuacion))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Puntuacion;
    // End of variables declaration//GEN-END:variables
}
