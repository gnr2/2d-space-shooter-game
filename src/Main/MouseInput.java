/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Ellis
 */
public class MouseInput extends MouseAdapter{
    
    Game game;
    
    public MouseInput(Game game){
        this.game = game;
    }
    
    public void mouseMoved(MouseEvent e){
        game.mouseMoved(e);
    }
    
    public void mouseClicked(MouseEvent e){
        game.mouseClicked(e);
    }
    
    public void mouseDragged(MouseEvent e){
        game.mouseDragged(e);
    }
    
}
