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
public class MiniTenis extends JPanel{
     Pelota pelota=new Pelota(this);
       Paleta paleta = new Paleta(this);
       int velocidad = 1;

	private void moveBall() {
		pelota.move();
                paleta.move();
	}
        
        private int obtenerPuntaje() {
		return velocidad - 1;
	}
        
        public MiniTenis() {
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				paleta.keyReleased(e);
			}

			@Override
			public void keyPressed(KeyEvent e) {
				paleta.keyPressed(e);
			}
		});
		setFocusable(true);
                Sonido.BACK.loop();
	}
        
        public void gameOver() {
                Sonido.BACK.stop();
		Sonido.GAMEOVER.play();
		JOptionPane.showMessageDialog(this, "Tu puntaje es : " + obtenerPuntaje(),
				"Juego terminado", JOptionPane.YES_NO_OPTION);
		System.exit(ABORT);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		pelota.paint(g2d);
                paleta.paint(g2d);
                
                g2d.setColor(Color.GRAY);
		g2d.setFont(new Font("Verdana", Font.BOLD, 30));
		g2d.drawString(String.valueOf(obtenerPuntaje()), 10, 30);
	}

	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("Mini Tenis");
		MiniTenis minitenis = new MiniTenis();
		frame.add(minitenis);
		frame.setSize(300, 400);
                frame.setBackground(Color.red);
		frame.setVisible(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		while (true) {
			minitenis.moveBall();
			minitenis.repaint();
			Thread.sleep(7);
		}
	}
}
