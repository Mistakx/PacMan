import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level1 extends World
{
    
    
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public Level1()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        long startingTime = System.currentTimeMillis();
        
        Player[] playerList = new Player[2];
        Player player1 = new Player(); 
        addObject(player1, 100, 50);
        playerList[0] = player1;
        
        
        
        Goomba goomba = new Goomba(playerList);
        addObject(goomba, 100, 100);
        
        
        
        Timer timer = new Timer(startingTime);
        //addObject(timer, 0, 0);
        
    }
    
    public void act(){


        
        
    }
    
}
