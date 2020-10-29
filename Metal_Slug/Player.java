import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    
    private int gravity = 1;
    private int verticalSpeed = 0;
    
    public void act() 
    {
        
        verticalSpeed += gravity;
        setLocation(getX(), getY() + verticalSpeed);
        

        
    }    
}
