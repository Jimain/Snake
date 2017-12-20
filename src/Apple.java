import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Random;

public class Apple {
	
	int frameHeight = 0;
	int frameWidth = 0;
	int width = 10;
	int height = 10;
	Point p = new Point();
	
	
	public Apple( int fW, int fH) {
		
		frameWidth = fW;
		frameHeight = fH;
		
		p = getNewLocation(); 
			
	}
	private Point getNewLocation() {
		
		int x = new Random().nextInt(frameWidth - width);
		int y = new Random().nextInt(frameHeight - height - 22);
		
		x = (int) (Math.floor( x / width ) * width);
		y = (int) (Math.floor(y / height ) * height);

		p.x = x ;
		p.y = y;
		
		return p;

	}
	public void setApple(Graphics g , Boolean ateApple ) {
		
		if ( ateApple ) {
			p = getNewLocation();
		}
		g.setColor(Color.RED);
		g.fillRect(p.x, p.y, width, height);
		
	}

}
