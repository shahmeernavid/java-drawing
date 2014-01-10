/*
 * the paint program
 * original code: http://forum.codecall.net/topic/58137-java-mini-paint-program/
 */
package myotest;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JComponent;

/**
 *
 * @author shahmeernavid
 */
public class Drawing extends JComponent{
    
    //image to draw on
    Image image;
    
    Graphics2D graphics2D;
    
    int currentX, currentY, oldX, oldY;
    float currentStroke = 0.0f;
    //these are gonna hold our mouse coordinates
    
    

    // constructor
    public Drawing() {
        setDoubleBuffered(false);
        
        // the mouse click listener - updates old x and y
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                oldX = e.getX();
                oldY = e.getY();
            }
        });
        
        // the mouse motion listener - updates old x and y and actually draws line!
        addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                currentX = e.getX();
                currentY = e.getY();
                if (graphics2D != null) {
                    graphics2D.drawLine(oldX, oldY, currentX, currentY);
                }
                repaint();
                oldX = currentX;
                oldY = currentY;
            }
        });
    }

    public void paintComponent(Graphics g) {
        // when using for the first time, image will be null so we need to give it a value
        if (image == null) {
            image = createImage(getSize().width, getSize().height);
            graphics2D = (Graphics2D) image.getGraphics();
            graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);  //smooths drawing
            
            clear();
        }
        g.drawImage(image, 0, 0, null);
    }

    
    //clears background
    public void clear() {
        graphics2D.setPaint(new Color(255, 255, 255));
        graphics2D.fillRect(0, 0, getSize().width, getSize().height);
        graphics2D.setPaint(Color.black); 
        repaint();
    }

    
    //color methods
    public void red() {
        graphics2D.setPaint(Color.red);
        repaint();
    }

    public void black() {
        graphics2D.setPaint(Color.black);
        repaint();
    }

    public void magenta() {
        graphics2D.setPaint(Color.magenta);
        repaint();
    }

    public void blue() {
        graphics2D.setPaint(Color.blue);
        repaint();
    }

    public void green() {
        graphics2D.setPaint(Color.green);
        repaint();
    }
    
    public void setStroke(float stroke){
        if(currentStroke >= 1)currentStroke = stroke; currentStroke = (currentStroke <= 0)?1: currentStroke;
        graphics2D.setStroke(new BasicStroke(currentStroke, BasicStroke.CAP_ROUND, 1));
    }
    
    public void increaseStroke(float s){
        if(currentStroke <= 20.0) currentStroke += s;
        graphics2D.setStroke(new BasicStroke(currentStroke, BasicStroke.CAP_ROUND, 1));
    }
    
}
