package ca.utoronto.utm.jugpuzzle;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

public class GUIView extends JLabel implements Observer {
	
		@Override
		public void update(Observable o, Object arg) {
			JugPuzzle jugPuzzleGame = (JugPuzzle)o;
			
			this.setText("Something has changed.");
		}

}
