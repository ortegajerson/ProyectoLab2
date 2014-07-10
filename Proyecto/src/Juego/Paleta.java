

package Juego;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Paleta {
    private static final int Y = 330;
	private static final int WITH = 60;
	private static final int HEIGHT = 10;   
        int x = 0;
	int xa = 0;
	private MiniTenis minitenis;

	public Paleta(MiniTenis minitenis){
            this.minitenis=minitenis;
        }

	public void move() {
		if (x + xa > 0 && x + xa < minitenis.getWidth()-60)
			x = x + xa;
	}

	public void paint(Graphics2D g) {
                g.setColor(Color.GREEN);
		g.fillRect(x, 330, 60, 10);
	}

	public void keyReleased(KeyEvent e) {
		xa = 0;
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			xa = -minitenis.velocidad;
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			xa = minitenis.velocidad;
	}
        
        public Rectangle getBounds() {
		return new Rectangle(x, Y, WITH, HEIGHT);
	}

	public int getTopY() {
		return Y - HEIGHT;
	}
    
}
