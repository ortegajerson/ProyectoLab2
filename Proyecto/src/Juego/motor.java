package Juego;


import java.awt.Color;
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
    boolean pollo=false;
    public motor(Manager m) throws InterruptedException {
     this.m=m;
    
                frame = new JFrame("Mini Tennis");
		game game = new game();
		frame.add(game);
		frame.setSize(300, 400);
                frame.setBackground(Color.red);
		frame.setVisible(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		while (pollo) {
			game.moveBall();
			game.repaint();
			Thread.sleep(7);
		}}
    
    
}
