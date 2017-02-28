package tetris;
 
import java.awt.Graphics; 
 
import javax.swing.JFrame;
import java.awt.Point;

class Tetromino{
    int [][] shape = {{1,1},{1,1}};
    int [] topLeft = {0,4};
}
public class Main {
  public static void main(String[] a) {
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setBounds(30, 30, 300, 300);
//    frame.getContentPane().add(new Block());
    frame.getContentPane().add(new XYaxe());
    frame.setVisible(true);

    int [][] landed ={{0,0,0,0,0,0,0,0,0,0}, 
    			{0,0,0,0,0,0,0,0,0,0},
    			{0,0,0,0,0,0,0,0,0,0},
    			{0,0,0,0,0,0,0,0,0,0},
    			{0,0,0,0,0,0,0,0,0,0},
    			{0,0,0,0,0,0,0,0,0,0},
    			{0,0,0,0,0,0,0,0,0,0},
    			{0,0,0,0,0,0,0,0,0,0},
    			{0,0,0,0,0,0,0,0,0,0},
    			{0,0,0,0,0,0,0,0,0,0},
    			{0,0,0,0,0,0,0,0,0,0},
    			{0,0,0,0,0,0,0,0,0,0},
    			{0,0,0,0,0,0,0,0,0,0},
    			{0,0,0,0,1,1,1,0,0,0},
    			{0,0,0,1,1,1,1,0,0,0},
    			{0,0,1,1,0,0,0,0,0,0}};
    int row;
    int col=0;
    String str="";
    		int row1;
    Tetromino tetromino = new Tetromino();
    int level=0;
    for ( row = 0; row < landed.length; row++) {
        for ( col = 0; col < landed[row].length; col++) {
    	if(row==tetromino.topLeft[0] && col==tetromino.topLeft[1] ){ 
    		   	for (row1= tetromino.topLeft[0]; row1 < tetromino.shape[0].length; row1++) {
    		   		System.out.println(row1+"row1");
    				landed[row][col++]=1;    			
    			}  
    		}
    	if(row==tetromino.topLeft[0]+1 && col==tetromino.topLeft[1] && row < tetromino.shape[0].length){ 
		   	for (row1= tetromino.topLeft[0]; row1 < tetromino.shape[0].length; row1++) {
		   		System.out.println(row1+"row1");
				landed[row][col++]=1;    			
			}  
		}
    	if(row==tetromino.topLeft[0]+2 && col==tetromino.topLeft[1] && row < tetromino.shape[0].length){ 
		   	for (row1= tetromino.topLeft[0]; row1 < tetromino.shape[0].length; row1++) {
		   		System.out.println(row1+"row1");
				landed[row][col++]=1;    			
			}  
		}
    	if(row==tetromino.topLeft[0]+3 && col==tetromino.topLeft[1] && row < tetromino.shape[0].length){ 
		   	for (row1= tetromino.topLeft[0]; row1 < tetromino.shape[0].length; row1++) {
		   		System.out.println(row1+"row1");
				landed[row][col++]=1;    			
			}  
		}
    	} 
 
    }
        
    
  
  for ( row = 0; row < landed.length; row++) {
      for ( col = 0; col < landed[row].length; col++) {
      	 str+=landed[row][col]+"," ;
          if (landed[row][col] != 0) {
              //draw block at position corresponding to row and col
              //remember, row gives y-position, col gives x-position
          }
       }
      System.out.println(str);
      str="";
  }  
  }

  }
  
      
