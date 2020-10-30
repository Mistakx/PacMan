    import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
    import java.util.List;
    /**
     * Write a description of class Player here.
     * 
     * @author (your name) 
     * @version (a version number or a date)
     */
    public class Player extends Actor
    {
        
        private int playerNumber;
        private boolean isMoving;
        private int movementDirection; // 0 - Up, 1 - Right, 2 - Down, 3 - Left
        private int health = 2;
        
        public Player(int playerNumber){
        this.playerNumber = playerNumber;
        }
        
        public void move(int playerNumber){
            
            if (playerNumber == 1){
                
                if (Greenfoot.isKeyDown("W")) {
                    isMoving = true;
                    movementDirection = 0;
                
                }
                else if (Greenfoot.isKeyDown("D")) {
                    isMoving = true;
                    movementDirection = 1;
                
                }
                else if (Greenfoot.isKeyDown("S")) {
                    isMoving = true;
                    movementDirection = 2;
                
                }
                else if (Greenfoot.isKeyDown("A")) {
                    isMoving = true;
                    movementDirection = 3;
                
                }
            }
            
            else if (playerNumber == 2){
            
                if (Greenfoot.isKeyDown("up")) {
                    isMoving = true;
                    movementDirection = 0;
                
                }
                else if (Greenfoot.isKeyDown("right")) {
                    isMoving = true;
                    movementDirection = 1;
                
                }
                else if (Greenfoot.isKeyDown("down")) {
                    isMoving = true;
                    movementDirection = 2;
                
                }
                else if (Greenfoot.isKeyDown("left")) {
                    isMoving = true;
                    movementDirection = 3;
                
                }
                
            }
            
            
            
            if (isMoving) {
                
                if (movementDirection == 0){setLocation(getX(), getY() - 2);}
                else if (movementDirection == 1){setLocation(getX() + 2, getY());}
                else if (movementDirection == 2){setLocation(getX(), getY() + 2);}
                else if (movementDirection == 3){setLocation(getX() - 2, getY());}
            
                
            }
                    
                    
        }
        
        public void eatCoin(){
            
            List<Coin> intersectingCoins = getIntersectingObjects(Coin.class);
            if (intersectingCoins.size() > 0) {
            
                for (Coin coin:intersectingCoins){getWorld().removeObject(coin);}
                Level1.score += 10;
            
            }
            
           
        
        }
        
        public void hitEnemy(){
        
            List<Enemy> intersectingEnemies = getIntersectingObjects(Enemy.class); 
                        
            if (intersectingEnemies.size() > 0) {
            
                health -= 1;
                
                if (health == 0){getWorld().showText("GAME OVER!", getX()/2, getY()/2);}
            
            }
        }
        
        public void act() 
    {

        
        move(playerNumber);
        eatCoin();
        


        
    }    
}
