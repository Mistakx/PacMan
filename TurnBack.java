import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TurnBack here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TurnBack extends Actor
{
    /**
     * Act - do whatever the TurnBack wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public TurnBack(){
        GreenfootImage image = getImage();
        image.scale(15, 15);
        setImage(image);
        image.setTransparency(0); 
        
        
    }
    
    
    public void act() 
    {
        //
    }    
}
