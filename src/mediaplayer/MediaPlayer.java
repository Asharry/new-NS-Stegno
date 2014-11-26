/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mediaplayer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javazoom.jl.decoder.JavaLayerException;

import javazoom.jl.player.Player;


public class MediaPlayer {
    private String filename;
    private Player player; 
    private String path;

    // constructor that takes the name of an MP3 file
   

    public void close() { if (player != null) player.close(); }

    // play the MP3 file to the sound card
    public void play(String path) {
        try {
            FileInputStream fis     = new FileInputStream(path);
            BufferedInputStream bis = new BufferedInputStream(fis);
            player = new Player(bis);
        }
        catch (FileNotFoundException | JavaLayerException e) {
            System.out.println("Problem playing file " + filename);
            System.out.println(e);
        }

        // run in new thread to play in background
        new Thread() {
            @Override
            public void run() {
                try { player.play(); }
                catch (Exception e) { System.out.println(e); }
            }
        }.start();




    }


    // test client
    public void finalrun(String path) throws InterruptedException {
      
       
        
        
        
         JFrame frame = new JFrame();
        JButton stopbutton=new JButton("Stop");
        frame.setSize(300,300);
     //   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        stopbutton.setSize(30, 30);
        frame.add(stopbutton);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
            frame.addWindowListener(new WindowAdapter(){
                @Override
                public void windowClosing(WindowEvent e) {
                    
                }
            });
        
        
        
        
        
        
        
        final MediaPlayer mp3 = new MediaPlayer();
        mp3.play(path);
        
        
        
        stopbutton.addActionListener(new ActionListener(){
        

            @Override
            public void actionPerformed(ActionEvent e) {
            mp3.close();
            
            }});
        
        
        
        
        
        
        
        File file = new File(path);
        long filesize = file.length();
        long timeout = filesize*8/(1000*200);
        mp3.wait(timeout);
        // do whatever computation you like, while music plays
        
        // when the computation is done, stop playing it
        mp3.close();

        // play from the beginning
    
     

    }

}

