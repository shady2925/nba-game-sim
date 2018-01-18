import java.awt.*;
import java.awt.Component;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Frame extends JFrame
{

    public Frame()
    {
        super("NBA Simulator");
        setSize(500,350);
        setLocation(500,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Container c = getContentPane();
        
        try 
        {
            Panel p = new Panel();
            c.add(p);
            
        } catch (Exception exc) {
            System.out.println("error");
        }   
        
        setVisible(true);
   
    }
    
    public static void main(String[] args)
    {
        Frame f = new Frame();       
        
    }

}
