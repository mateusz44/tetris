package tetris;
 
import java.awt.Graphics; 
 
import javax.swing.JFrame;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class Tetromino{
	protected int that=1;
    protected int [][][] shape = {
    		{{5,9},{6,7}},//o
    		{{0,1,0,0},{0,1,0,0},{0,1,0,0},{0,1,0,0}},// I
    		{{0,0,5},{0,0,6},{0,7,8} },// L
    		{{0,1,1},{0,1,0},{0,1,0} },// L
    		{{1,1,1},{0,1,0},{0,0,0}}, //T
    		{{0,1,1},{0,1,0},{1,1,0}}, //s
    		{{1,1,0},{0,1,0},{0,1,1}}} //z
    		;
    
       int [] topLeft = {0,4};
    int [] former_topLeft = {0,4};
    int row=0;
    int col=0;
	int row2=0; 
     int [][] landed  ={{0,0,0,0,0,0,0,0,0,0}, 
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
    			{0,0,1,1,0,0,0,0,0,0}};;

   public boolean condition2(  int t, int that,int row, int col)
   {
   	return ( row == topLeft[0]+t-shape[that].length && col== topLeft[1] );
   }
   public boolean condition(  int t, int that, int row, int col)
    {
    	return ( row == topLeft[0]+t  && col== topLeft[1] );
    }
    public void paint(){ 
 
    	   String str="";
    		int row1=0;
    		int t=0;
    		int coll=0;
    	    for ( row = 0; row < landed.length; row++) {  
    	        for ( col = 0; col < landed[row].length; col++) {
    	        	if( row ==topLeft[0]){
     	    		int col2=0; 
    	           	for(row2=0; row2<shape[that].length; row2++, row++){ 
    		    		   	for (col2=0,coll=topLeft[1];col2<shape[that][row2].length;col2++)
 
    		    		   		 if(shape[that][row2][col2]!=0) 
    		    		   			 landed[row][coll++]=shape[that][row2][col2];   
    		    		   		 else
    		    		   			landed[row][coll++]=0; 
    		    		} 
    		    	}
    	        }
    	    }
    for ( row = 0; row < topLeft[0]; row++) 
        for ( col = 0; col < landed[row].length; col++) 
	    		   			landed[row][col]=2;       
	        
     callBlocks();

    }
    public void callBlocks()
    {   
    	String str="";
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
 
    void rotate(String direction)
    {   
    	int [][][] d1=shape.clone(); 
    	int i;int j;
	    	String str1="";
	    	if(direction=="L"){
		        for ( i = 0; i < shape[that].length; i++) {
		            for (j = 0; j < shape[that][i].length; j++) {  
		            	d1[that][j][i]=shape[that][i][j];
		            }
		        }
 

    }else
    {
        for ( i = shape[that].length-1; i >= 0; i--) {
            for (j = shape[that][i].length-1; j >= 0; j--) { 
            	System.out.println(shape[that].length+":"+shape[that][i].length);
            	d1[that][j][i]=shape[that][i][j];
            }
        }
    }
	    	 System.out.println(str1);
		    	shape[that] = d1[that];  
    }
    public void dropDown()
    {
    	this.former_topLeft[0]=this.topLeft[0];
    	this.topLeft[0]++;
    	this.paint();
     	System.out.println("\n");;
    }
    public void move(int ii){
    	this.topLeft[1]+=ii;
    }

}
 
public class Main {
  public static void main(String[] a) {
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setBounds(30, 30, 300, 300);
//    frame.getContentPane().add(new Block());
    frame.getContentPane().add(new XYaxe());
    frame.setVisible(true);
    Tetromino game = new Tetromino(); 
	frame.addKeyListener(new KeyListener() {
		public void keyTyped(KeyEvent e) {
		}
		
		public void keyPressed(KeyEvent e) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_UP:
				game.rotate("L");
				game.paint();
				break;
			case KeyEvent.VK_DOWN:
				game.rotate("d");
				game.paint();
				break;
			case KeyEvent.VK_LEFT:
				game.move(-1);
				break;
			case KeyEvent.VK_RIGHT:
				game.move(+1);
				break;
			case KeyEvent.VK_SPACE:
				game.dropDown();
//				game.score += 1;
				break;
			} 
		}
		
		public void keyReleased(KeyEvent e) {
		}
	});
	 
	new Thread() {
		@Override public void run() {
			while (true) {
				try {
					Thread.sleep(2000);
					game.dropDown();
				} catch ( InterruptedException e ) {}
			}
		}
	}.start();
  } 
  }
  
      
