package tetris;

import java.awt.*;
import javax.swing.*;

import java.awt.FlowLayout; 
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class MyFrame extends JFrame
{
  JPanel panel;
  JLabel label;  
  // constructor 
  MyFrame( String title )
  {
    super( title );                      // invoke the JFrame constructor
    setSize( 500, 500 );
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE ); 
    setLayout( new FlowLayout() );       // set the layout manager
    label = new JLabel("Hello Swing!");  // construct a JLabel
     add(label);

 
  }

}