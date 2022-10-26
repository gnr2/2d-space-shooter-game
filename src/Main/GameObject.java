/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import java.awt.Rectangle;

/**
 *
 * @author Ellis
 */
public class GameObject {
    
    public double x, y;
    
    public GameObject(double x, double y){
        this.x = x;
        this.y = y;
    }
    
    public Rectangle getBounds(int width, int height){
        return new Rectangle((int)x, (int) y, width, height);
    }
    
}
