package tetris;
 
import java.awt.Graphics; 
 
import javax.swing.JFrame;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Tetromino{
	ArrayList<Integer> piece = new ArrayList<Integer>();
	int that=0;
	int rotation_that=0; 
	int [][][]shape;
	int rotation ;
	int [] margin = {0,0}; 

    int [][][] shapeo  = {{
	    					{0,5,9},
	    					{0,6,7},
	    					{0,0,0}}};//o  //0

    int [][][] shapes={		{
        		 //two rotations
			    	     {0,1,1},
			    	     {1,1,0},
			    	     {0,0,0}}, //s  //13
			    		{
			        	 {0,1,0},
			        	 {0,1,1},
			        	 {0,0,1}}};
    //14
    int [][][] shapez = {		{
    					  {1,1,0},
			    	      {0,1,1},
			    	      {0,0,0}}, //z  //15
						{
						  {0,0,1},
						  {0,1,1},
						  {0,1,0}}};     //16
    int [][][] shapel  =	{	//4 rotation
				    		{
				    		 {0,3,5},
				    		 {0,0,6},
				    		 {0,0,8} },// J  //1-4
				    		{
				        		{5,6,8},
				        		{9,0,0},
				        		{0,0,0} }, //2
				    		{
				            	{0,6,0},
				            	{0,7,0},
				            	{0,7,9} },   //3
				        	{
				            	{0,0,9},
				            	{3,7,3},
				            	{0,0,0} }};
int [][][] shapej =	{        	
			        	//4
					{
						{0,1,2},
					 	{0,3,0},
					 	{0,4,0} },// L    //5-8
					 {
						{2,0,0},
						{1,3,4},
						{0,0,0} },  //6
			  		 {
						{0,0,4},
			   		 	{0,0,3},
			   		 	{0,2,1} },//7
			  		 {
						{0,0,0},
			   		 	{4,3,1},
			   		 	{0,0,2} }}; //8
int [][][] shapet={
		    		{
		    		 {1,1,1},
		    		 {0,7,0},
		    		 {0,0,0}}, //T  //9
		    		{
		    		 {0,1,0},
		    		 {0,1,7},
		    		 {0,1,0}},  //10
		    		{
		    		 {0,0,0},
		        	 {0,7,0},
		        	 {1,1,1}},  //11
		    		{
		        	 {0,0,1},
		        	 {0,7,1},
		        	 {0,0,1}}};
     //12
    int [][][] shapei= {
    			{{0,0,0,0},{0,0,0,0},{1,2,3,4},{0,0,0,0}},// I       17
    			{{0,1,0,0},{0,1,0,0},{0,1,0,0},{0,1,0,0}}};  //18
    
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
    
   Tetromino(int t)
   {
	   choosePiece(t);
   }
   public void choosePiece(int t){
	   	if(t==0)
		   	 shape=shapeo;
		   	if(t==1)
		   		shape=shapei;
		   	if(t==2)
		   		shape=shapes;
		   	if(t==3)
		   		shape=shapez;
		   	if(t==4)
		   		shape=shapej;
		   	if(t==5)
		   		shape=shapel;
		   	if(t==6)
		   		shape=shapet;
		   	 rotation_that=t;
   }
	public void nextPiece() {
		if (piece.isEmpty()) {
			Collections.addAll(piece, 0, 1, 2, 3, 4, 5, 6);
			Collections.shuffle(piece);
		}
		choosePiece(piece.get(0));
		piece.remove(0);
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
    	           	for(row2=0; row2<shape[rotation].length; row2++, row++){ 
    		    		   	for (col2=margin[0],coll=topLeft[1] ;col2<shape[rotation][row2].length;col2++)
    		    		   		if(coll<10){
    		    		   			if(landed[row][coll]==0){
		    		    		   		 if(shape[rotation][row2][col2]!=0){ 
		   		    		   				 landed[row][coll++]=1;
		    		    		   		 }
		    		    		   		 else
		    		    		   			landed[row][coll++]=0;
    		    		   			} 
    		    		   		}
    		    		} 
    		    	}
    	        }
    	    }
    for ( row = 0; row < topLeft[0]; row++) 
        for ( col = 0; col < landed[row].length; col++) 
	    		   			landed[row][col]=9;       
         
     callBlocks();

    }
    public void callBlocks()
    {   
    	String str="";
    	for ( row = 0; row < landed.length; row++) {
        for ( col = 0; col < landed[row].length; col++) {
         	 str+=landed[row][col]+"," ;
             if (landed[row][col] != 0) { 
             }
          }
         System.out.println(str);
         str="";
       } 
    	
    }
 
    public void rotate(String direction)
    {     
    	if( direction=="L" && rotation_that>0)
    		rotation++;
    	else
    		rotation--;  
    	if( ( rotation_that>=1 && rotation_that<=3) && rotation>1)
    		rotation=0; 
    	else if(rotation<0)rotation=1;

    	if( ( rotation_that>=4 && rotation_that<=6) && rotation>3)
    		rotation=0; 
    	else if(rotation_that<0)rotation=3;
    	//move(0);
    } 
    public void dropDown()
    {
    	this.former_topLeft[0]=this.topLeft[0];
    	this.topLeft[0]++;
    	this.paint();
     	System.out.println("\n");;
    }
    public void move(int ii){
    	margin[0]=0;
    	margin[1]=0;
    	if(ii>0)
    		topLeft[1]++;
    	else if(ii<0)
    		topLeft[1]--;
    	if(topLeft[1]<0)
    		topLeft[1]=0; 
   	 if( ( rotation_that>1 || rotation_that>0 ) && topLeft[1]+shape[rotation].length>9)
   		topLeft[1]=7;
   	 if(rotation_that==1 && topLeft[1]>9)topLeft[1]=9;
    	 if(rotation_that==1 && rotation==0 && topLeft[1]+shape[rotation].length>9)
    		topLeft[1]=6;
  
     	for(int i=0; i<shape[rotation][0].length; i++) 
     	{ 
			if(rotation_that==1 && shape[rotation][i][0]==0 && rotation==0)
				margin[0]=0;
			else
				margin[0]=1;
			if( ( rotation_that>1 ||rotation_that==0 ) && shape[rotation][i][0]==0)
				margin[0]=1;
			else
				margin[0]=0;
				break;
     	}   
   	 
	        
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
    Tetromino game = new Tetromino(5);
	frame.addKeyListener(new KeyListener() {
		public void keyTyped(KeyEvent e) {
		}
		
		public void keyPressed(KeyEvent e) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_UP:
				//game.rotate("L");
				game.paint();
				break;
			case KeyEvent.VK_DOWN:
				//game.rotate("d");
				game.paint();
				break;
			case KeyEvent.VK_LEFT:
				game.move(-1);
				break;
			case KeyEvent.VK_RIGHT:
				//game.move(+1);
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
					Thread.sleep(1000);
					game.dropDown();
				} catch ( InterruptedException e ) {}
			}
		}
	}.start();
  } 
  }
  
      
