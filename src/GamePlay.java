import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePlay extends JPanel implements ActionListener {
	
	private Timer timer;
	
	GameState gS = GameState.START ;
	
	public GamePlay( int frameWidth , int frameHeight ) {
		
		timer = new Timer( 100, this );
		timer.start();
		
	}
	
	public void paint ( Graphics g ) {
		
		switch ( gS ) {
		
		case START :
			
			showStart();
			
			break;
			
		case PLAY :
			
			showPlay();
			
			break;
			
		case GAMEOVER :
			
			showGameOver();
			
			break;
			
		default :
			
			showError();
			
		}
	}
	
	private void showStart( ) {
		
	}
	
	private void showPlay( ) {
		
	}

	private void showGameOver( ) {
	
	}
	
	private void showError( ) {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource( ) == timer ) {
			repaint();
		}
		
	
		
		
	}
	

}
