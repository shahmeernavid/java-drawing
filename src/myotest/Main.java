/*
 *  Main application
 */
package myotest;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import java.awt.Toolkit;

/**
 *
 * @author shahmeernavid
 */
public class Main extends JFrame{
    
    // constructor - not really needed
    public Main(){}
    
    public static void main(String[] args) {
        Drawing drawPad = new Drawing(); //instantiate drawing surface
        MyFrame frame = new MyFrame(drawPad); // create a new frame - see MyFrame
        frame.setSize(Toolkit.getDefaultToolkit().getScreenSize()); //get screen size
        frame.setBackground(Color.white);  // set bg to white
        frame.setUndecorated(true);  // get rid of close buttons

        //actually add drawing surface to frame
        frame.getContentPane().add(drawPad, BorderLayout.CENTER);

        // Show the frame
        frame.setVisible(true);

    }
    
}
