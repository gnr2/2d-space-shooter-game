/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import Entities.EntityA;
import Entities.EntityB;
import java.util.LinkedList;

/**
 *
 * @author Ellis
 */
public class Physics {
    
    public static boolean Collision(EntityA entA, LinkedList<EntityB> entB){
        for (int i = 0; i < entB.size(); i++){
            if(entA.getBounds().intersects(entB.get(i).getBounds())){
                return true;
            }
        } return false;
    }
    
    public static boolean Collision(EntityB entB, LinkedList<EntityA> entA){
        for (int i = 0; i < entA.size(); i++){
            if(entB.getBounds().intersects(entA.get(i).getBounds())){
                return true;
            }
        } return false;
    }
    
}
