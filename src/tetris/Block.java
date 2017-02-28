package tetris;

import java.awt.Graphics;

import javax.swing.JComponent;
 
class Block extends JComponent {
	int x=50;
	int y=50;
	int width=10;
	int height=10; 
	int color = 12; 
	  public void paint(Graphics g, int x, int y) {
	    g.drawRect (x, y, width, height);  
	  } 
	}