import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Goomba here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */



public class Goomba extends Enemy
{
    static int HEALTH = 10;
    static int ATTACK_SPEED = 1;
    static int MOVEMENT_SPEED = 1;
    
    boolean goomba_attack() {
        int goomba_position_y = getY();
        
        for (int i = 0; i < 1; i++) {
        
            long temp_player_position_y = super.playersList[i].getY();
            
            // TODO: Maybe do a get on Enemy players list
            if ( ((temp_player_position_y + 20) > goomba_position_y) && (goomba_position_y > (temp_player_position_y - 20))){
                System.out.println("DEBUG HERE1");
                return true;
        
        }
        
        }
        
        System.out.println("DEBUG HERE2");
        return false;
        
        

    }
    
    public Goomba(Player[] playersList){
        
        super(HEALTH, MOVEMENT_SPEED, ATTACK_SPEED, playersList);
    
    }
    
    public void act() 
    {
        goomba_attack();
    }    
}
