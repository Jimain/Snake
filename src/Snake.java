import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;

public class Snake {

	int frameWidth = 0;
	int frameHeight = 0;
	SnakeDirection sT;
	ArrayList<Point> body = new ArrayList<Point>();

	public Snake(int fW, int fH) {

		frameWidth = fW;
		frameHeight = fH;
		int x = (int) (Math.floor((frameWidth / 2 - 5) / 10) * 10);
		int y = (int) (Math.floor((frameHeight / 2 - 5) / 10) * 10);
		body.add(new Point(x, y));

	}

	public void setSnake(Graphics g, SnakeDirection sD, Boolean ateApple) {

		sT = sD;
		newMove(ateApple);
		g.setColor(Color.GREEN);
		for (int i = 0; i < body.size(); i++) {
			g.fillRect(body.get(i).x, body.get(i).y, 10, 10);
		}
	}

	public void newMove(Boolean ateApple) {

		Point head = head();
		Point newHead = new Point(head.x, head.y);

		switch (sT) {

		case UP:
			newHead.y -= 10;
			break;

		case DOWN:
			newHead.y += 10;
			break;

		case RIGHT:
			newHead.x += 10;
			break;

		case LEFT:
			newHead.x -= 10;
			break;
		}

		body.add(0, newHead);
		if (!ateApple) {
			body.remove(body.size() - 1);
		}

	}

	public Point head() {

		Point head = body.get(0);

		return head;

	}
	public Boolean iAmDead(){
		Boolean dead = false;
		Point head = head();
		
		for( int i = 1; i < body.size() ; i++) {
			if( head.x == body.get(i).x ) {
				dead = true;
			}
		}
		return dead;
	}

}
