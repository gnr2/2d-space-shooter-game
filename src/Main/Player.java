/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;
import Entities.EntityA;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import Main.Animation;

/**
 *
 * @author Ellis
 */
public class Player extends GameObject implements EntityA{

    private Textures tex;
    
    Animation anim;
    
    public Player(double x, double y, Textures tex){
        super(x, y);
        this.tex = tex;
        
        anim = new Animation(2, tex.player[0], tex.player[1], tex.player[2]);
    }
    public Rectangle getBounds(){
        return new Rectangle((int)x, (int) y, 32, 32);
    }
    
    public void tick(){
        anim.runAnimation();
    }
    
    public void render(Graphics g){
        anim.drawAnimation(g, x, y, 0);
    }
    
    public double getX(){
        return x;
    }
    
    public double getY(){
        return y;
    }
    
    public void setX(double x){
        this.x = x;
    }
    
    public void setY(double y){
        this.y = y;
    }
}
