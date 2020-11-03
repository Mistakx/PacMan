import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Wall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Wall extends Actor
{
    /**
     * Act - do whatever the Wall wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Wall(){
    
        GreenfootImage image = getImage();
        image.scale(15, 15);
        setImage(image);
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
}
