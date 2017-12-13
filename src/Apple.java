import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

public class Apple {
	
	int frameHeight = 0;
	int frameWidth = 0;
	Point p = new Point();
	
	
	public Apple( int fW, int fH) {
		
		frameWidth = fW;
		frameHeight = fH;
		
		p = getNewLocation(); 
			
	}
	private Point getNewLocation() {
		
		int x = new Random().nextInt(frameWidth);
		int y = new Random().nextInt(frameHeight);

		p.x = x;
		p.y = y;
		
		return p;

	}
	public void setApple(Graphics g , Boolean hitSnake ) {
		
		if ( hitSnake ) {
			p = getNewLocation();
		}
		g.setColor(Color.RED);
		g.fillRect(p.x, p.y, 10, 10);
		
	}

}
