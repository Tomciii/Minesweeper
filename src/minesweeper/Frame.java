package minesweeper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Frame extends JFrame implements MouseListener, KeyListener {

    private static int width = 400;
    private static int height = 400;

    private Screen screen;
    private World world;
    private Font font;



    public Frame(){
        super("MineSweeper");

        world = new World();
        screen = new Screen();
        add(screen);
        addMouseListener(this);
        addKeyListener(this);


        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(width+16,height);
        setLocationRelativeTo(null);
        setVisible(true);

        font = new Font("SansSerif", 0,12);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getButton()==1)world.clickedLeft(e.getX() - 3, e.getY() - 30);
        if(e.getButton()==3)world.clickedRight(e.getX() - 3, e.getY() - 30);
        screen.repaint();


    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode()== KeyEvent.VK_R){
            world.reset();
            screen.repaint();
        }
    }


    public class Screen extends JPanel{

        @Override
        public void paintComponent(Graphics g){
            g.setFont(font);
           world.draw(g);
        }
    }

    public static int getScreenWidth(){
        return width;
    }

    public static int getScreenHeight(){
        return height;
    }
}
