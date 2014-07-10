

package Juego;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Pelota {
     private static final int DIAMETER = 30;
        int x = 0;
	int y = 0;
	int xa = 1;
	int ya = 1;
	private MiniTenis minitenis;
        
        public Pelota(MiniTenis minitenis) {
		this.minitenis= minitenis;
	}
	void move() {
                boolean changeDirection = true;
		if (x + xa < 0)
			xa = minitenis.velocidad;
		else if (x + xa > minitenis.getWidth() - DIAMETER)
			xa = -minitenis.velocidad;
		else if (y + ya < 0)
			ya = minitenis.velocidad;
		else if (y + ya > minitenis.getHeight() - DIAMETER)
			minitenis.gameOver();
		else if (collision()){
			ya = -minitenis.velocidad;
			y = minitenis.paleta.getTopY() - DIAMETER;
			minitenis.velocidad++;
                        System.out.println(minitenis.velocidad);
		} else 
			changeDirection = false;
		
		if (changeDirection) 
			Sonido.BALL.play();

		x = x + xa;
		y = y + ya;
	}
        
        private boolean collision() {
		return minitenis.paleta.getBounds().intersects(getBounds());
	}
	public void paint(Graphics2D g) {
                g.setColor(Color.BLUE);
		g.fillOval(x, y, 20, 20);
	}
        
        public Rectangle getBounds() {
		return new Rectangle(x, y, DIAMETER, DIAMETER);
	}
}
