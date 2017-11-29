import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePlay extends JPanel implements ActionListener {
	
	int fW;
	int fH;
	
	private Timer timer;
	
	GameState gS = GameState.START ;
	
	public GamePlay( int frameWidth , int frameHeight ) {
		
		fW = frameWidth;
		fH = frameHeight;
		
		timer = new Timer( 100, this );
		timer.start();
		
	}
	
	public void paint ( Graphics g ) {
		
		switch ( gS ) {
		
		case START :
			
			showStart(g);
			
			break;
			
		case PLAY :
			
			showPlay(g);
			
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

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource( ) == timer ) {
			repaint();
		}
		
	
		
		
	}
	

}
