package Juego;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class game extends JPanel{
       ball ball=new ball(this);
       Racquet racquet = new Racquet(this);
       int speed = 1;

	void moveBall() {
		ball.move();
                racquet.move();
	}
        
        private int getScore() {
		return speed - 1;
	}
        
        public game() {
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				racquet.keyReleased(e);
			}

			@Override
			public void keyPressed(KeyEvent e) {
				racquet.keyPressed(e);
			}
		});
		setFocusable(true);
                Sound.BACK.loop();
	}
        
        public void gameOver() {
                Sound.BACK.stop();
		Sound.GAMEOVER.play();
		JOptionPane.showMessageDialog(this, "your score is: " + getScore(),
				"Game Over", JOptionPane.YES_NO_OPTION);
		System.exit(ABORT);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		ball.paint(g2d);
                racquet.paint(g2d);
                
                g2d.setColor(Color.GRAY);
		g2d.setFont(new Font("Verdana", Font.BOLD, 30));
		g2d.drawString(String.valueOf(getScore()), 10, 30);
	}

}
