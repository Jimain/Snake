import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFrame frame = new JFrame();
		
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		
		int dH = (int) dimension.getHeight();
		int dW = (int) dimension.getWidth();
		
		int frameHeight = dH / 2;
		int frameWidth = dW / 3;
		
		int xp = ( dW / 2 ) -  ( frameWidth / 2 );
		int yp = ( dH / 2 ) - ( frameHeight / 2 );
		
		frame.setResizable(false);
		frame.setBounds( xp , yp , frameWidth  , frameHeight );
		frame.setBackground(Color.gray);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GamePlay gP = new GamePlay( frameWidth, frameHeight );
		frame.add( gP );
		frame.setVisible(true);
		
		
	
		
		
		
	}

}
