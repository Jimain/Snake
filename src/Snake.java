import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Snake {
	
	int frameWidth = 0;
	int frameHeight = 0;
	Point p = new Point(0,0);
	SnakeDirection sT;
	
	public Snake(int fW, int fH) {
		
		frameWidth = fW;
		frameHeight = fH;
		int x = (int) (Math.floor( (frameWidth / 2 - 5 ) / 10) * 10 );
		int y = (int) (Math.floor( (frameHeight / 2 - 5 ) / 10 ) * 10);
		p = new Point( x , y );
		
		
	}
	public void setSnake( Graphics g, SnakeDirection sD ) {
		
		sT = sD;
		newMove();
		g.setColor(Color.GREEN);
		g.fillRect( p.x , p.y , 10, 10);
		
	}
	public void newMove () {
		
		switch(sT) {
		
		case UP:
			p.y -= 10;
			break;
		
		case DOWN:
			p.y += 10;
			break;
			
		case RIGHT:
			p.x += 10;
			break;
			
		case LEFT:
			p.x -= 10;
			break;
		}
		
	}

}
