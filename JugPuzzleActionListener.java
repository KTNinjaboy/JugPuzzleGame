package ca.utoronto.utm.jugpuzzle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JugPuzzleActionListener implements ActionListener {
	
	// Instantiating variables.
	private JFrame myFrame;
	private JugPuzzle myGame;
	private PaintJugs myJugPainter;
	private JButton myEight, myFive, myThree;
	private JLabel myMoves, myYouWonMessage, myEndGameMessage;
	private static int from;
	private static int clicks = 0;
	
	/**
	 * 	Constructor.
	 * @param frame				the JFrame for the JugPuzzleGame.
	 * @param game				the JugPuzzleGame.
	 * @param jugPainter		the paint method for the jugs.
	 * @param numOfMoves		the number of moves made in JugPuzzleGame.
	 * @param youWonMessage		the message when you win the game.
	 * @param endGameMessage	another message when you win the game.
	 * @param eight				the jug button for jug with capacity 8.
	 * @param five				the jug button for jug with capacity 5.
	 * @param three				the jug button for jug with capacity 3.
	 */
	public JugPuzzleActionListener(JFrame frame, JugPuzzle game, 
			PaintJugs jugPainter, JLabel numOfMoves, JLabel youWonMessage,
			JLabel endGameMessage, JButton eight, JButton five, 
			JButton three) {
		
		this.myFrame = frame;
		this.myGame = game;
		this.myJugPainter = jugPainter;
		this.myMoves = numOfMoves;
		this.myYouWonMessage = youWonMessage;
		this.myEndGameMessage = endGameMessage;
		this.myEight = eight;
		this.myFive = five;
		this.myThree = three;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// Checks which button was pressed.
		if (e.getActionCommand() == "New Game") {
			this.myFrame.dispose();
			JugPuzzleGUIController.createAndShowGUI();
		}
		
		if (e.getActionCommand() == "Quit") {
			this.myFrame.dispose();
		}
		
		// Runs only when New Game or Quit is not pressed and is the first
		// jug button that was chosen.
		if (clicks == 0) {
			// Checks which jug was pressed and stores it in the corresponding
			// integer for later use as it is the first jug that is chosen.
			if (e.getActionCommand() == "Jug with capacity 8") {
				from = 0;
				clicks++;
			}
			
			if (e.getActionCommand() == "Jug with capacity 5") {
				from = 1;
				clicks++;
			}
			
			if (e.getActionCommand() == "Jug with capacity 3") {
				from = 2;
				clicks++;
			}
		}
		
		// Runs only when New Game or Quit is not pressed and is not the first
		// jug that is pressed.
		else {
			if (e.getActionCommand() == "Jug with capacity 8") {
				myGame.move(from, 0);
				myJugPainter.repaintJugs(myGame.getJugs()[0].getAmount(), 
						myGame.getJugs()[1].getAmount(), 
						myGame.getJugs()[2].getAmount());
				myGame.notifyObservers();
			}
			
			if (e.getActionCommand() == "Jug with capacity 5") {
				myGame.move(from, 1);
				myJugPainter.repaintJugs(myGame.getJugs()[0].getAmount(), 
						myGame.getJugs()[1].getAmount(), 
						myGame.getJugs()[2].getAmount());
				myGame.notifyObservers();
			}
			
			if (e.getActionCommand() == "Jug with capacity 3") {
				myGame.move(from, 2);
				myJugPainter.repaintJugs(myGame.getJugs()[0].getAmount(), 
						myGame.getJugs()[1].getAmount(), 
						myGame.getJugs()[2].getAmount());
				myGame.notifyObservers();
			}
			
			if (myGame.getIsPuzzleSolved()) {
				this.myYouWonMessage.setText("You Won!!");
				this.myYouWonMessage.setForeground(Color.red);
				this.myEndGameMessage.setText("Start a new game or quit.");
				this.myEight.removeActionListener(this);
				this.myFive.removeActionListener(this);
				this.myThree.removeActionListener(this);
				
			}
			
			this.myMoves.setText(String.valueOf(myGame.getMoves()));
			clicks = 0;
		}

	}

}
