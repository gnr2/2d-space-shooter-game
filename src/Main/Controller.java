/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import Entities.EntityA;
import Entities.EntityB;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author Ellis
 */
public class Controller {
    private LinkedList<EntityA> eA = new LinkedList<EntityA>();
    private LinkedList<EntityB> eB = new LinkedList<EntityB>();
    EntityA entA;
    EntityB entB;
    Textures tex;
    Random r = new Random();
    private Game game;
    
    public Controller(Textures tex, Game game){
        this.tex = tex;
        this.game = game;
    }
    
    public void tick(){
        //A
        for(int i = 0; i < eA.size(); i++){
            entA = eA.get(i);
            
            entA.tick();
        }
        //B
        for(int i = 0; i < eB.size(); i++){
            entB = eB.get(i);
            
            entB.tick();
        }
    }
    
    public void render(Graphics g){
        //A
        for(int i = 0; i < eA.size(); i++){
            entA = eA.get(i);
            
            entA.render(g);
        }
        //B
        for(int i = 0; i < eB.size(); i++){
            entB = eB.get(i);
            
            entB.render(g);
        }
    }
    
    public void addEntity(EntityA block){
        eA.add(block);
    }
    
    public void removeEntity(EntityA block){
        eA.remove(block);
    }
    
    public void addEntity(EntityB block){
        eB.add(block);
    }
    
    public void removeEntity(EntityB block){
        eB.remove(block);
    }
    
    public LinkedList<EntityA> getEntityA(){
        return eA;
    }
    
    public LinkedList<EntityB> getEntityB(){
        return eB;
    }

    
    public void createEnemy(int enemy_count){
        for(int i = 0; i < enemy_count; i++){
        addEntity(new Enemy(r.nextInt(640), -10, tex, this, game));
    }
    }
}

