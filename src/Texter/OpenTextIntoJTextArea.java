package Texter;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

import java.util.*;

import java.io.*;

public class OpenTextIntoJTextArea
{
public void openTextFile(String path)
{
 try
 {
  System.out.println("done");
  FileReader readTextFile=new FileReader(path);

  //Create a scanner object from FileReader
  Scanner fileReaderScan=new Scanner(readTextFile);

  //Create a String that will store all text in the text file
  String storeAllString="";

  //Put all text from text file into created String
  while(fileReaderScan.hasNextLine())
  {
   String temp=fileReaderScan.nextLine()+"\n";
  
   storeAllString=storeAllString+temp;
  }

  //Set JTextArea text to created String
  JTextArea textArea=new JTextArea(storeAllString);
 
  //Set JTextArea to line wrap
  textArea.setLineWrap(true);
 
  //Set JTextArea text to word wrap
  textArea.setWrapStyleWord(true);
 
  //Create scrollbar for text area
  JScrollPane scrollBarForTextArea=new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
 
  //Create a window using JFrame with title ( Open text file into JTextArea )
  JFrame frame=new JFrame("Open text file into JTextArea");
 
  //Add scrollbar into JFrame
  frame.add(scrollBarForTextArea);
 
  //Set default close operation for JFrame
//  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
  //Set JFrame size
  frame.setSize(500,500);
 
  //Make JFrame locate at center on screen
  frame.setLocationRelativeTo(null);
 
  //Make JFrame visible
  frame.setVisible(true);
  frame.addWindowListener(new WindowAdapter(){
                @Override
                public void windowClosing(WindowEvent e) {
                    
                }
            });
        
        
        
 }
 catch(Exception exception)
 {
  //Print Error in file processing if it can't process your text file
  System.out.println("Error in file processing");
 }
}
}
