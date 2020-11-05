
import greenfoot.*;
import java.util.List;

public class Player extends Actor {

    private int playerNumber;
    private boolean isMoving;
    private int movementDirection; // 0 - Up, 1 - Right, 2 - Down, 3 - Left
    private int spawnX = -1;
    private int spawnY = -1;

    public Player(int playerNumber) {
        this.playerNumber = playerNumber;

        // Image scale
        GreenfootImage image = getImage();
        image.scale(15, 15);
        setImage(image);
    }

    public void move(int playerNumber) {
        if (playerNumber == 1) {
            if (Greenfoot.isKeyDown("W")) {
                isMoving = true;
                movementDirection = 0;
            } else if (Greenfoot.isKeyDown("D")) {
                isMoving = true;
                movementDirection = 1;
            } else if (Greenfoot.isKeyDown("S")) {
                isMoving = true;
                movementDirection = 2;
            } else if (Greenfoot.isKeyDown("A")) {
                isMoving = true;
                movementDirection = 3;
            }
        } else if (playerNumber == 2) {
            if (Greenfoot.isKeyDown("up")) {
                isMoving = true;
                movementDirection = 0;
            } else if (Greenfoot.isKeyDown("right")) {
                isMoving = true;
                movementDirection = 1;
            } else if (Greenfoot.isKeyDown("down")) {
                isMoving = true;
                movementDirection = 2;
            } else if (Greenfoot.isKeyDown("left")) {
                isMoving = true;
                movementDirection = 3;
            }
        }

        if (isMoving) {
            // Moving up
            if (movementDirection == 0) {
                // Checks if there is a wall above before moving up
                if ((getWorld().getObjectsAt(getX(), getY() - 1, Wall.class)).isEmpty() == false) {
                    isMoving = false;
                } else {
                    setLocation(getX(), getY() - 1);
                }
            }
            // Moving to the right
            else if (movementDirection == 1) {
                // Checks if there is a wall to the right before moving to the right
                if ((getWorld().getObjectsAt(getX() + 1, getY(), Wall.class)).isEmpty() == false) {
                    isMoving = false;
                } else {
                    setLocation(getX() + 1, getY());
                }
            // Moving down    
            } else if (movementDirection == 2) {
                // Checks if there is a wall below before moving down
                if ((getWorld().getObjectsAt(getX(), getY() + 1, Wall.class)).isEmpty() == false) {
                    isMoving = false;
                } else {
                    setLocation(getX(), getY() + 1);
                }
            // Moving to the left    
            } else if (movementDirection == 3) {
                // Checks if there is a wall to the left before moving to the left
                if (getWorld().getObjectsAt(getX() - 1, getY(), Wall.class).isEmpty() == false) {
                    isMoving = false;
                } else {
                    setLocation(getX() - 1, getY());
                }
            }
        }
    }

    public void eatSmallDot() {
        
        List<SmallDot> smallDotToEat = getWorld().getObjectsAt(getX(), getY(), SmallDot.class);
        
        if (smallDotToEat.isEmpty() == false) {
            Level1.score += 10;
            getWorld().removeObject(smallDotToEat.get(0));
        
        }
    }

    public void eatBigDot() {
        
        List<BigDot> bigDotToEat = getWorld().getObjectsAt(getX(), getY(), BigDot.class);
        
        if (bigDotToEat.isEmpty() == false) {
            Level1.score += 50;
            getWorld().removeObject(bigDotToEat.get(0));
        
        }
    }
    
    
    public void hitEnemy() {
        
        List<Enemy> enemyHit = getWorld().getObjectsAt(getX(), getY(), Enemy.class);
        
        if (enemyHit.isEmpty() == false) {
            
            Level1.playersHealth -= 1;
            
            setLocation(spawnX, spawnY);
            
            if (Level1.playersHealth < 1){
            
                getWorld().showText("GAME OVER!", getWorld().getWidth() / 2, getWorld().getHeight() / 2 );
                
            }
            
        }
    }

    
    
    public void teleportWalls() {
        
        // Left teleport
        if ( (getX() == 3) && (getY() == 17) ) {
            setLocation(36-5, getY());
        }
        
        // Right teleport
        else if ( (getX() == 36-4) && (getY() == 17) ) {
            setLocation(4, getY());
        }

    }

    public void act() {
        // Sets starting positions
        if (spawnX == -1){spawnX = getX();}
        if (spawnY == -1){spawnY = getY();}

        move(playerNumber);
        eatSmallDot();
        eatBigDot();
        teleportWalls();
        hitEnemy();
    }
}
