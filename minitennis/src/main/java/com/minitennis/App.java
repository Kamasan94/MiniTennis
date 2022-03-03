package com.minitennis;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


//Sopprime i warning del compilatore per un certo elemento
@SuppressWarnings("serial")
public class App extends JPanel
{
    
    Ball ball = new Ball(this);
    Racquet racquet = new Racquet();

    public App() 
    {
        addKeyListener(new KeyListener()
        {
            @Override
            public void keyTyped(KeyEvent e)
            {} 

            @Override
            
            
            
        });
    }    
    private void move()
    {
        ball.move();
    }  

    @Override
    public void paint(Graphics g)
    {
        //Pulisce lo schermo ad ogni chiamata di repaint
        super.paint(g);

        Graphics2D g2d = (Graphics2D) g;

        //Antialiasing, per rendere i bordi dell'immagine piu lisci
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);

        ball.paint(g2d);
    }
    public static void main( String[] args ) throws InterruptedException
    {
        JFrame frame= new JFrame("Mini Tennis");
        App app = new App();
        frame.add(app);
        frame.setSize(300,300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        while(true)
        {
            app.move();
            app.repaint();

            /*
            Dice al processore di fermare il thread principale per 10ms
            Questo per permettere al thread AWT-EventQueue di eseguire il
            repaint del canvas
            */
            Thread.sleep(10);
        }        
    }
}
