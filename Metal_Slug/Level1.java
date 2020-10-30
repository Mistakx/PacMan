import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level1 extends World
{
    
    public static int score = 0;
    private long startingTime = System.currentTimeMillis();
    
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public Level1()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 400, 1);
        

        
        Player[] players = new Player[2];
        
        Player player1 = new Player(1); 
        addObject(player1, 100, 50);
        players[0] = player1;
        
        Player player2 = new Player(2); 
        addObject(player2, 100, 100);
        players[1] = player2;
        
        Coin coin1 = new Coin();
        addObject(coin1, 200, 200);
        Coin coin2 = new Coin();
        addObject(coin2, 300, 200);
        Coin coin3 = new Coin();
        addObject(coin3, 300, 300);
        Coin coin4 = new Coin();
        addObject(coin4, 400, 350);
        Coin coin5 = new Coin();
        addObject(coin5, 200, 250);
        

        

        
        
        

        //addObject(timer, 0, 0);
        
    }
    
    public void setScore(int newScore){this.score = newScore;}
    
    public void act() {

        // Timer
        long currentTime = (System.currentTimeMillis() - startingTime) / 1000;
        showText("Time: " + String.valueOf(currentTime), getWidth() / 2, getWidth()/15);
        
        // Score
        showText("Score: " + String.valueOf(score), getWidth() / 2, getWidth()/10);
        
        
        
    }
    
}
