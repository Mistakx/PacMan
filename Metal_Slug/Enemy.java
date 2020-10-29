import greenfoot.*;
import java.util.List;

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{

    public int health;
    public int attackSpeed;
    public int movementSpeed;
    public Player[] playersList;
    
    public Enemy(int health, int attackSpeed, int movementSpeed, Player[] playersList){
    
        this.health = health;
        this.attackSpeed = attackSpeed;
        this.movementSpeed = movementSpeed;
        this.playersList = playersList;
        
    }
    
    
    public void act() 
    {
        // Add your action code here.
    }    
}
