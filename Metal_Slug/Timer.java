import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Timer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Timer extends Actor
{
    
    long startingTime = 0;
    
    public Timer(long startingTime){
    
        this.startingTime = startingTime;

    
    }
    
    
    public void act() 
    {
        long currentTime = (System.currentTimeMillis() - startingTime) / 1000;
        World currentWorld = getWorld();
        currentWorld.showText(String.valueOf(currentTime), currentWorld.getWidth() / 2, currentWorld.getWidth()/10);
    }    
}
