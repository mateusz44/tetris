package tetris;
 
import java.awt.Graphics; 
 
import javax.swing.JFrame;
import java.awt.Point;

class Tetromino{
    protected int [][][] shape = {
    		{{5,9},{6,7}},//o
    		{{0,0,1,0},{0,0,1,0},{0,0,1,0},{0,0,1,0}},// I
    		{{0,0,1,0},{0,0,1,0},{0,0,1,0},{0,1,1,0}},// L
    		{{1,1,1},{0,1,0},{0,0,0}}, //T
    		{{0,1,1},{0,1,0},{1,1,0}}, //s
    		{{1,1,0},{0,1,0},{0,1,1}}} //z
    		;
    int [] topLeft = {0,4};
    int [] former_topLeft = {0,4};
    int row=0;
    int col=0;
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
   public boolean condition(  int t, int row, int col)
    {
    	return ( row == topLeft[0]+t  && col== topLeft[1] );
    }
   public boolean condition2(  int t, int row, int col)
   {
   	return ( row == topLeft[0]+t-shape[1].length && col== topLeft[1] );
   }
    public void paint(){ 
    String str="";
	int row1;
	int t=0; 
 
    for ( row = 0; row < landed.length; row++) {
        for ( col = 0; col < landed[row].length; col++) {
    	while(t<4 &&  condition( t, row,col )){ 
	    		   	for (row1= topLeft[0]+t; row1 < shape[1].length + topLeft[0]+t-1; row1++) {
    		   			System.out.println( ( shape[1].length)); 
    		   			System.out.println(  shape[1][0].length); 
	    		   		if(row<shape[1].length && row1<shape[1][row].length)
	    		   		if(shape[1][col][row1]!=0)
	    		   			 landed[col][row1]=1;     
	    		   		 else
	    		   			landed[col][row1]=0;       
	    		}
	    		t++;
	    	}
    	t=0;
    	} 
        
    }
/*    
    for ( row = 0; row < landed.length; row++) {
        for ( col = 0; col < landed[row].length; col++) {
    	while(t<4 &&  condition2( t, row,col )){ 
	    		   	for (row1= topLeft[0]+t ; row1 < shape[1].length + topLeft[0]+t; row1++) {  
	    				landed[row][col++]=0;     
	    		}
	    		t++;
	    	}
    	t=0;
    	} 
       
    }
   */      
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
 
    void turn(int t, String direction)
    {   
    	int [][][] d1 = {
        		{{1,2},{3,4}},//o
        		{{0,0,1,0},{0,0,1,0},{0,0,1,0},{0,0,1,0}},// I
        		{{0,0,1,0},{0,0,1,0},{0,0,1,0},{0,1,1,0}},// L
        		{{1,1,1},{0,1,0},{0,0,0}}, //T
        		{{0,1,1},{0,1,0},{1,1,0}}, //s
        		{{1,1,0},{0,1,0},{0,1,1}}};
    	int i;int j;
	    	String str1="";
	    	if(direction=="L"){
		        for ( i = 0; i < shape[t].length; i++) {
		            for (j = 0; j < shape[t][i].length; j++) { 
		            	//System.out.println(shape[t].length+":"+shape[t][i].length);
		            	d1[t][j][i]=shape[t][i][j];
		            }
		        }
 

    }else
    {
        for ( i = shape[t].length; i > 0; i--) {
            for (j = shape[t][i].length; j > 0; j--) { 
            	System.out.println(shape[t].length+":"+shape[t][i].length);
            	d1[t][j][i]=shape[t][i][j];
            }
        }
    }
	    	 System.out.println(str1);
		    	shape[t] = d1[t];
		    	/*
	str1="";
	    for ( i = 0; i < d1[t].length; i++) {
	        for ( j = 0; j < d1[t][i].length; j++) {
	           str1+= shape[t][i][j]+",";
	        }
	    } 
	    System.out.println(str1);
	    */
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
    game.paint();
    game.turn(0,  "L");
    game.turn(2,"L");
    game.turn(5, "L");
	// Make the falling piece drop every second
	new Thread() {
		@Override public void run() {
			while (true) {
				try {
					Thread.sleep(1000);
					game.dropDown();
				} catch ( InterruptedException e ) {}
			}
		}
	}.start();
  } 
  }
  
      
