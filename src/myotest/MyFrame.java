/*
 * Main purpose to allow implementation of controls
 */
package myotest;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

/**
 *
 * @author shahmeernavid
 */
public class MyFrame extends JFrame implements KeyListener{
    
    // a reference to the drawing surface
    Drawing drawing;
    
    
    //constructor requires a drawing surface
    public MyFrame(Drawing p){
        drawing = p;
        
        addKeyListener(this);  //add an event listener to the frame
    }

    
    
    @Override
    public void keyTyped(KeyEvent e) {
        
        //changes colors
        if(e.getKeyChar() == 'q')
            drawing.black();
        else if (e.getKeyChar() == 'w')
            drawing.blue();
        else if (e.getKeyChar() == 'e')
            drawing.red();
        else if (e.getKeyChar() == 'r')
            drawing.green();
        else if (e.getKeyChar() == 't')
            drawing.magenta();
        
        
        //other functions - self explanitory
        else if (e.getKeyChar() == 'z')
            drawing.increaseStroke(-0.5f);
        else if (e.getKeyChar() == 'x')
            drawing.increaseStroke(0.5f);
        
        else if (e.getKeyChar() == 'h')
            grabScreenShot();
        else if (e.getKeyChar() == 'c')
            drawing.clear();
        
        
    }

    @Override
    public void keyPressed(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}
    
    
    
    private void grabScreenShot(){
        //create buffered image of correct size
        BufferedImage image = (BufferedImage)createImage(getContentPane().getSize().width,getContentPane().getSize().height);
        
        //screenshot time!
        getContentPane().paint(image.getGraphics());
        
        //saving
        try{
            ImageIO.write(image, "png", new File("./screenshot.png"));
            System.out.println("Image was created");
        }
        catch (IOException e){
            System.out.println("Had trouble writing the image.");
           
        }
    }
    
}
