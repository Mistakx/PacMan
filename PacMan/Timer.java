import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Timer extends Actor
{
    private long startingTime;
    
    public Timer(long startingTime) {
    this.startingTime = startingTime;
}
    
    public void act() 
    {
        long currentTime = (System.currentTimeMillis() - startingTime) / 1000;
        GreenfootImage timer = new GreenfootImage(String.valueOf(currentTime), 240, Color.BLACK, new Color(0, 0, 0, 0));
        timer.scale(10, 10);
        setImage(timer);
    }    
}
