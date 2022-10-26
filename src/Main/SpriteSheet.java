/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;
import java.awt.image.BufferedImage;

/**
 *
 * @author Ellis
 */
public class SpriteSheet {
    
    private BufferedImage image;
    
    public SpriteSheet(BufferedImage image){
        this.image = image;
    }
    
    public BufferedImage grabImage(int col, int row, int width, int height){
        
        BufferedImage img = image.getSubimage((col * 32) - 32, (row * 32) - 32, width, height );
        return img;
    }
}

