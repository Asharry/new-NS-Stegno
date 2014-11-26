package imagedemo;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
 
/**
 * This class demonstrates how to load an Image from an external file
 */
public class ImageDemo extends Component {
           
    BufferedImage img;
 
    public void paint(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }
 public ImageDemo(){}
    public ImageDemo(String path) {
       try { 
           
           img = ImageIO.read(new File(path));
       } catch (IOException e) {
       }
 
    }
 
    @Override
    public Dimension getPreferredSize() {
        if (img == null) {
             return new Dimension(100,100);
        } else {
           return new Dimension(img.getWidth(null), img.getHeight(null));
       }
    }
 
    public void launch(String path) {
 
        JFrame f = new JFrame(" IMAGE FILE");
             
        f.addWindowListener(new WindowAdapter(){
                @Override
                public void windowClosing(WindowEvent e) {
                   
                }
            });
 
        f.add(new ImageDemo(path));
        f.pack();
        f.setVisible(true);
    }
}