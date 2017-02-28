package tetris;
 
import java.awt.Graphics;
 
import javax.swing.JFrame;



public class Main {
  public static void main(String[] a) {
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setBounds(30, 30, 300, 300);
//    frame.getContentPane().add(new Block());
    frame.getContentPane().add(new XYaxe());
    frame.setVisible(true);
  }
}