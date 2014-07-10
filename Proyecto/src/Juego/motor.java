package Juego;


import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Litoman
 */
public class motor {

    Manager m;
    Inicio inicio;
    JFrame frame;
    boolean p;
    game game;
    public motor(Manager m){
     this.m=m;
    
                frame = new JFrame("Mini Tennis");
		game = new game();
		frame.add(game);
		frame.setSize(300, 400);
                frame.setBackground(Color.red);
		frame.setVisible(false);
                
    }
    
    public void start(){
        
    Thread t=new Thread(new Runnable() {

        @Override
        public void run() {
            while (true) {                
                game.moveBall();
                game.repaint();
                try {
                    Thread.sleep(7);
                } catch (Exception e) {
                }
            }
            
        }
    });t.start();
    }
}


