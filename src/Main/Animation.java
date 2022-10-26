package Main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author Ellis
 */
public class Animation {
    
    private int speed;
    private int frames;
    private int index = 0;
    private int count = 0;
    
    private BufferedImage img1;
    private BufferedImage img2;
    private BufferedImage img3;
    
//    private BufferedImage img4;
//    private BufferedImage img5;
//    private BufferedImage img6;
//    private BufferedImage img7;
//    private BufferedImage img8;
//    private BufferedImage img9;
    
    private BufferedImage currentImg;
    
    public Animation(int speed, BufferedImage img1,BufferedImage img2, BufferedImage img3){
        this.speed = speed;
        this.img1 = img1;
        this.img2 = img2;
        this.img3 = img3;
        
        frames = 3;
    }
    
    public Animation(int speed, BufferedImage img1,BufferedImage img2){
        this.speed = speed;
        this.img1 = img1;
        this.img2 = img2;
        
        frames = 2;
    }
    
    public void runAnimation(){
        index++;
        if(index>speed){
            index = 0;
            nextFrame();
        }
    }
    
    public void nextFrame(){
        
        switch(frames){
            
            case 2:
                
                if(count == 0)
                    currentImg = img1;
                if(count == 1)
                    currentImg = img2;
                
                count++;
                
                if(count > frames)
                    count = 0;
                break;
                
            case 3:
                if(count == 0)
                    currentImg = img1;
                if(count == 1)
                    currentImg = img2;
                if(count == 2)
                    currentImg = img3;
                
                count++;
                
                if(count > frames)
                    count = 0;
                break;
        }
        
    }
    
    public void drawAnimation(Graphics g, double x, double y,int offset){
        g.drawImage(currentImg, (int)x, (int)y, null);
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    
    
    
}
