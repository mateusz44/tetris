package tetris;

import java.awt.Graphics;

public class XYaxe extends Block{
	int axeX=10;
	int axeY=20;
	int ii;
	  public void paint(Graphics g) {
		  for(int i=0; i<axeX; i++)
			  for(ii=0; ii<axeY; ii++) {
				  g.drawRect(this.x+i*10, this.y+ii*10, width, height);
				System.out.println(this.x);  
			  }
		    g.drawLine (this.x , this.y+ii*10 , 220, this.y+ii*10);
		    g.drawLine (this.x , this.y+ii*10 , this.x, 30);
		  }

}
