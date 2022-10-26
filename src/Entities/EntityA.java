/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Entities;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Ellis
 */
public interface EntityA {
    public void tick();
    public void render(Graphics g);
    public Rectangle getBounds();
    
    public double getX();
    public double getY();

}
