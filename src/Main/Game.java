
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Main;

import Entities.EntityA;
import Entities.EntityB;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.*;
import java.io.IOException;
import java.util.LinkedList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Ellis
 */
public class Game extends Canvas implements Runnable{
    
    private static final long serialVersionUID = 1L;
    public static final int WIDTH = 320;
    public static final int HEIGHT = WIDTH / 12*9;
    public static final int SCALE = 2;
    public final String TITLE = "2D Space Shooter";
    
    private boolean running = false;
    private Thread thread;
    
    private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
    private BufferedImage spriteSheet = null;
    private BufferedImage background = null;
    
    private Textures tex;
    private Player p;
    private Controller c;
    
    private int enemy_count = 5;
    private int enemy_killed = 0;
    
    public LinkedList<EntityA> eA;
    public LinkedList<EntityB> eB;
    
    public void init(){
        
        BufferedImageLoader loader = new BufferedImageLoader();
        
        
        try{
            
            background = loader.loadImage("bg.png");
            spriteSheet = loader.loadImage("sprite_sheet.png");
           
        }catch(IOException e){
            e.printStackTrace();
        }
        
        tex = new Textures(this);
        
        p = new Player(200,200, tex);
        c = new Controller(tex, this);
        
        eA = c.getEntityA();
        eB = c.getEntityB();
        
        addMouseMotionListener(new MouseInput(this));
        addMouseListener(new MouseInput(this));
        
        c.createEnemy(enemy_count);
        
        
    }
    
    
    private synchronized void start(){
        if(running)
            return;
        
        running = true;
        thread = new Thread(this);
        thread.start();
    }
    
    private synchronized void stop(){
        if(!running)
            return;
        
        running = false;
        try{
            thread.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.exit(1);
    }
    
    @Override
    public void run(){
        init();
        long lastTime = System.nanoTime();
        final double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        int updates = 0;
        int frames = 0;
        long timer = System.currentTimeMillis();
        
        while(running){     //game loop
            
            long now = System.nanoTime();
            delta +=(now - lastTime) / ns;
            lastTime = now;
            if(delta >= 1){
                tick();
                updates++;
                delta--;
            }
            render();
            frames++;
            
            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                System.out.println(updates + " Ticks, Fps " + frames);
                updates = 0;
                frames = 0;
            }
        }
        stop();
    }
    
    private void tick(){
        p.tick();
        c.tick();
        
        if(enemy_killed >= enemy_count){
            enemy_count +=2;
            enemy_killed = 0;
            c.createEnemy(enemy_count);
        }
    }
    
    private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        
        if(bs == null){
            createBufferStrategy(3);
            return;
        }
        
        Graphics g = bs.getDrawGraphics();
        
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        
        g.drawImage(background, 0, 0, null);
        
        p.render(g);
        c.render(g);
        
        g.dispose();
        bs.show();
        
    }
    
    public void mouseMoved(MouseEvent e){
        
        p.setX(e.getX());
        p.setY(e.getY());
    }
    
    public void mouseClicked(MouseEvent e){
        
        c.addEntity(new Bullet(e.getX(), e.getY(), tex, this));
        
    }
    
    public void mouseDragged(MouseEvent e){
        p.setX(e.getX());
        p.setY(e.getY());
    }
    
    
    public static void main(String[] args) {
        Game game = new Game();
        
        game.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        game.setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        game.setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
        
        BufferedImage cursorImage = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
        Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImage, new Point(0,0), "Blank Cursor");
        
        JFrame frame = new JFrame(game.TITLE);
        JMenuBar mb = new JMenuBar();
        JMenu menu1 = new JMenu("Options");
        
        JMenuItem play = new JMenuItem("Play");
        play.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ev) {
        
          }
        });
        
        menu1.add(play);
        JMenuItem pause = new JMenuItem("Pause");
        menu1.add(pause);
        pause.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ev) {
        
          }
        });
        
        JMenuItem restart = new JMenuItem("Restart Game");
        menu1.add(restart);
        restart.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ev) {
        
          }
        });
        
        JMenuItem back = new JMenuItem("Back");
        menu1.add(back);
        mb.add(menu1);
        back.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ev) {
        try {
        Menu.main(new String[0]);
        } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
        }
        
        frame.setVisible(false);
        
          }
        });
        
        
        JMenu about = new JMenu("About");
        mb.add(about);
        about.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ev) {
            
          }
        });
        
        frame.setJMenuBar(mb);
        frame.add(game);
        
  
        
        frame.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
              frame.setCursor(blankCursor);
            }
        });
        
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        game.start();
    }
    
    public BufferedImage getSpriteSheet(){
        return spriteSheet;
    }

    public int getEnemy_count() {
        return enemy_count;
    }

    public void setEnemy_count(int enemy_count) {
        this.enemy_count = enemy_count;
    }

    public int getEnemy_killed() {
        return enemy_killed;
    }

    public void setEnemy_killed(int enemy_killed) {
        this.enemy_killed = enemy_killed;
    }
    
    
}
