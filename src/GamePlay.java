import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePlay extends JPanel implements ActionListener, KeyListener, MouseListener {
	
	int fW;
	int fH;
	
	private Timer timer;
	public Apple apple;
	public Snake snake;
	
	Boolean ateApple = false;
	int score = 0;
	
	GameState gS = GameState.START ;
	SnakeDirection sD = SnakeDirection.UP;
	
	public GamePlay( int frameWidth , int frameHeight ) {
		
		fW = frameWidth;
		fH = frameHeight;
		
		apple = new Apple(frameWidth, frameHeight);
		snake = new Snake(fW, fH);
		timer = new Timer( 100, this );
		timer.start();
		
		this.addKeyListener(this);
		this.addMouseListener(this);
		this.setFocusable(true);
		this.setFocusTraversalKeysEnabled(false);
		
	}
	
	public void paint ( Graphics g ) {
		
		switch ( gS ) {
		
		case START :
			
			showStart(g);
			
			break;
			
		case PLAY :
			
			showPlay(g);
			showScore(g);
			apple.setApple(g, ateApple);
			snake.setSnake(g, sD, ateApple);
			
			if( snake.head().x == apple.p.x && snake.head().y == apple.p.y ) {
				ateApple = true;
				score+=10;
			}else {
				ateApple = false;
			}
			
			if(snake.head().x > fW || snake.head().x < 0) {
				gS = GameState.GAMEOVER;
			}
			if(snake.head().y > fW || snake.head().y < 0) {
				gS = GameState.GAMEOVER;
			}
			
			
			break;
			
		case GAMEOVER :
			
			showGameOver(g);
			
			break;
			
		default :
			
			showError(g);
			
		}
	}
	private void paintBackground( Graphics g, Color bg ) {
		
		g.setColor(bg);
		
		g.fillRect(0, 0, fW, fH);
		
	}
	
	private void showStart( Graphics g ) {
		
		paintBackground(g, new Color( 216, 85, 85  ));
		
		try {
			BufferedImage logo = ImageIO.read(new File ( "./assets/logo.png"));
			
			int x = fW / 2 - logo.getWidth()/2;
			int y = fH / 4 - logo.getHeight()/3 ;
			
			g.drawImage( logo, x , y , logo.getWidth(), logo.getHeight(), this);
			
			BufferedImage playButton = ImageIO.read(new File ( "./assets/play_button.png"));
			
			int px = fW / 2 - playButton.getWidth()/2;
			int py = y+125;
			
			g.drawImage(playButton, px , py , playButton.getWidth() , playButton.getHeight() , this);
			
		} catch (IOException e) {

		}
		
	}
	
	private void showPlay( Graphics g ) {
		
		paintBackground(g, new Color(87, 110, 255  ));
		
	}

	private void showGameOver(  Graphics g) {
		
		paintBackground(g, new Color(246, 135, 255 ));
	
	}
	
	private void showError(  Graphics g) {
		
		paintBackground(g,Color.RED );
		
	}
	public void showScore( Graphics g ) {
	
		int fontS = 300;
		if( score >= 100 ) {
			fontS = 200;
		}
		FontMetrics fM = g.getFontMetrics();
		int tW = fM.stringWidth(Integer.toString(score));
		g.setColor( Color.WHITE);
		g.setFont(new Font( "TimesRoman", Font.PLAIN, fontS ));
		g.drawString( Integer.toString(score) , fW / 2 - tW / 2 , fH / 2  );
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource( ) == timer ) {
			repaint();
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {

		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		if( e.getKeyCode() == 10 || e.getKeyCode() == 32) {
			gS = GameState.PLAY;
		}
		switch (e.getKeyCode( )){
			
			case KeyEvent.VK_RIGHT:
			// Move right
			sD = SnakeDirection.RIGHT;
				break;
			
			case KeyEvent.VK_LEFT:
			//Move Left
			sD = SnakeDirection.LEFT;
				break;
				
			case KeyEvent.VK_DOWN:
			//Move Down
			sD = SnakeDirection.DOWN;
				break;
				
			case KeyEvent.VK_UP:
			//Move Up
			sD = SnakeDirection.UP;
				break;
				

		}
	
		
	
	}

	@Override
	public void keyReleased(KeyEvent e) {

		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if( gS == GameState.START ) {
			gS = GameState.PLAY;
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {

		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {

		
	}

	@Override
	public void mouseExited(MouseEvent e) {

		
	}
	

}
