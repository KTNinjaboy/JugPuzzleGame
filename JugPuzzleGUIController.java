package ca.utoronto.utm.jugpuzzle;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;


public class JugPuzzleGUIController extends Observable {

	public static void main(String[] args) {
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
	
	public static void createAndShowGUI() {
		// Create and hook up the Model, View and the controller
		
		// View
		GUIView guiView = new GUIView();
		
		// Model
		JugPuzzle jugPuzzleGame = new JugPuzzle();
		
		// Hook the model to the View
		jugPuzzleGame.addObserver(guiView);
		
		// Create the GUI Controller to control Model
		JFrame frame = new JFrame("Jug Puzzle Game"); // Frame with title
		frame.setLayout(new BorderLayout());
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Create the buttons
		JButton eight = new JButton("Jug with capacity 8");
		JButton five = new JButton("Jug with capacity 5");
		JButton three = new JButton("Jug with capacity 3");
		JButton newGame = new JButton("New Game");
		JButton quit = new JButton("Quit");
		
		// Create the labels
		JLabel moves = new JLabel("Moves: ");
		JLabel numOfMoves = new JLabel(String.valueOf(jugPuzzleGame.getMoves()));
		JLabel youWonMessage = new JLabel("");
		JLabel endGameMessage = new JLabel("");

		// Create reference to the paint method
		PaintJugs jugPainter = new PaintJugs(8, 0, 0);
		
		// Tell the buttons who they should call when they are pressed.
		// That is, hook up the controller to the Model.
		JugPuzzleActionListener jpal = new JugPuzzleActionListener(frame, 
				jugPuzzleGame, jugPainter, numOfMoves, youWonMessage, 
				endGameMessage, eight, five, three);
		
		eight.addActionListener(jpal);
		five.addActionListener(jpal);
		three.addActionListener(jpal);
		newGame.addActionListener(jpal);
		quit.addActionListener(jpal);
		
		Container c = frame.getContentPane();
		
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		buttonsPanel.add(eight);
		buttonsPanel.add(five);
		buttonsPanel.add(three);

		JPanel jugsPanel = new JPanel();
		jugsPanel.add(jugPainter);
		
		JPanel movesPanel = new JPanel();
		movesPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		movesPanel.add(moves);
		movesPanel.add(numOfMoves);
		movesPanel.add(youWonMessage);
		movesPanel.add(endGameMessage);
		movesPanel.add(newGame);
		movesPanel.add(quit);
		
		c.add(buttonsPanel, BorderLayout.NORTH);
		c.add(jugsPanel, BorderLayout.CENTER);
		c.add(movesPanel, BorderLayout.SOUTH);
		
		frame.setSize(600, 400);
		frame.setVisible(true);
		
		// Let the model tell the views to update
		guiView.update(jugPuzzleGame, jpal);
		jugPuzzleGame.notifyObservers(jpal);
		
		
	}
	
	
}
