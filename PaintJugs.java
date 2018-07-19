package ca.utoronto.utm.jugpuzzle;

import java.awt.*;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;

public class PaintJugs extends JPanel {
	
	// Instantiate global variables.
	private int _intJug0, _intJug1, _intJug2;
	
	/**
	 * 	Constructor.
	 * 	
	 * @param intJug0	Jug0's amount.
	 * @param intJug1	Jug1's amount.
	 * @param intJug2	Jug2's amount.
	 */
	public PaintJugs(int intJug0, int intJug1, int intJug2) {
		this._intJug0 = intJug0;
		this._intJug1 = intJug1;
		this._intJug2 = intJug2;
		repaint();
	}
	
	/**
	 * 
	 * @param intJug0	Jug0's amount.
	 * @param intJug1	Jug1's amount.
	 * @param intJug2	Jug2's amount.
	 */
	public void repaintJugs(int intJug0, int intJug1, int intJug2) {
		this._intJug0 = intJug0;
		this._intJug1 = intJug1;
		this._intJug2 = intJug2;
		repaint();
	}
	
	/**
	 * 	Paints the jugs and their amounts of the JugPuzzleGame.
	 */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        int intMaxHeight = 240;
        int intJugWidth = 150;
        int intOneAmount = 30;
        int intJugPatting = 5;
        int intAmountVerticalPatting = 15;
        int intAmountHorizontalPatting = 70;
        
        // Draws the 3 jugs and fills their amount respectively.
        g.setColor(Color.blue);
        g.fillRoundRect(0, intMaxHeight - _intJug0 * intOneAmount, intJugWidth,
        		_intJug0 * intOneAmount, 10, 10);
        
        g.drawRoundRect(0, 0, intJugWidth, intMaxHeight, 10, 10);
        
        g.fillRoundRect(intJugWidth + intJugPatting, 
        		intMaxHeight - _intJug1 * intOneAmount, intJugWidth, 
        		_intJug1 * intOneAmount, 10, 10);
        
        g.drawRoundRect(intJugWidth + intJugPatting,
        		intMaxHeight - intOneAmount * 5, intJugWidth, intOneAmount * 5,
        		10, 10);
        
        g.fillRoundRect(intJugWidth * 2 + intJugPatting * 2, 
        		intMaxHeight - _intJug2 * intOneAmount, 
        		intJugWidth, _intJug2 * intOneAmount, 10, 10);
        
        g.drawRoundRect((intJugWidth + intJugPatting) * 2, 
        		intMaxHeight - intOneAmount * 3, intJugWidth, intOneAmount * 3,
        		10, 10);
        
        // Draws the 3 jugs' amount below the appropriate jug.
        g.setColor(Color.black);
        g.drawString(String.valueOf(_intJug0), intAmountHorizontalPatting, 
        		intMaxHeight + intAmountVerticalPatting);
        
        g.drawString(String.valueOf(_intJug1), intAmountHorizontalPatting + 
        		intJugWidth + intJugPatting, 
        		intMaxHeight + intAmountVerticalPatting);
        
        g.drawString(String.valueOf(_intJug2), intAmountHorizontalPatting + 
        		((intJugWidth + intJugPatting) * 2), 
        		intMaxHeight + intAmountVerticalPatting);
        
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(500,500);
    }
	
    
}
