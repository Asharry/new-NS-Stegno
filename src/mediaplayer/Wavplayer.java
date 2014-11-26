package mediaplayer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author hcl
 */
public class Wavplayer {
    
    
    
    
    public void wavplay(final String file) {
        JFrame frame = new JFrame();
        JButton stopbutton=new JButton("Stop");
        frame.setSize(300,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        stopbutton.setSize(30, 30);
        frame.add(stopbutton);
        frame.setVisible(true);
    frame.addWindowListener(new WindowAdapter(){
                @Override
                public void windowClosing(WindowEvent e) {
                    
                }
            });
        
        
        

        try {
            AudioInputStream audio = AudioSystem.getAudioInputStream(new File(file));
            Clip clip = AudioSystem.getClip();
            clip.open(audio);
            clip.start();
            
        }
         catch(UnsupportedAudioFileException uae) {
            System.out.println(uae);
        }
        catch(IOException ioe) {
            System.out.println(ioe);
        }
        catch(LineUnavailableException lua) {
            System.out.println(lua);
        }
        
        stopbutton.addActionListener(new ActionListener(){
        

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    AudioInputStream audio = AudioSystem.getAudioInputStream(new File(file));
                    Clip clip = AudioSystem.getClip();
                    clip.close();              
                 
                } catch (UnsupportedAudioFileException ex) {
                    Logger.getLogger(Wavplayer.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Wavplayer.class.getName()).log(Level.SEVERE, null, ex);
                } catch (LineUnavailableException ex) {
                    Logger.getLogger(Wavplayer.class.getName()).log(Level.SEVERE, null, ex);
                }
            
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
      }
    );
        
        
        
        
        
        
        
        
        
        
       
}
    
    
    
    
    
    
    
    
    
    
    
}
