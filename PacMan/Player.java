import greenfoot.*;
import java.util.List;

public class Player extends Actor {

  private boolean wasInitialized = false;

  // Movement
  private boolean isMoving;
  private int movementDirection; // 0 - Up, 1 - Right, 2 - Down, 3 - Left
  private int bearMovementAnimationIndex;
  char[] player1MovementKeys;
  String[] player2MovementKeys;

  // Spawn
  private int spawnX;
  private int spawnY;

  // Power up
  private boolean isPoweredUp = false;
  private long poweredUpStartingTime;
  private long poweredUpBlinkingStartingTime;

  // Constructors
  public Player(char[] player1MovementKeys) {
    this.player1MovementKeys = player1MovementKeys;
  }

  public Player(String[] player2MovementKeys) {
    this.player2MovementKeys = player2MovementKeys;
  }

  // Spawn coordinates
  protected int getSpawnX() {
    return spawnX;
  }

  protected int getSpawnY() {
    return spawnY;
  }

  // Power up
  protected boolean isPoweredUp() {
    return isPoweredUp;
  }

  protected void setIsPoweredUp(boolean newIsPoweredUp) {
    isPoweredUp = newIsPoweredUp;
  }

  protected long getPowerUpStartingTime() {
    return poweredUpStartingTime;
  }

  protected void setPoweredUpStartingTime(long newPoweredUpStartingTime) {
    poweredUpStartingTime = newPoweredUpStartingTime;
  }

  protected void setPoweredUpBlinkingStartingTime(
    long newPoweredUpBlinkingStartingTime
  ) {
    poweredUpBlinkingStartingTime = newPoweredUpBlinkingStartingTime;
  }

  private void blink() {
    // Makes the player blink

    long currentTime = System.currentTimeMillis();

    // 200 ms transparent
    if (currentTime - poweredUpBlinkingStartingTime < 400) {
      getImage().setTransparency(50);
    }
    // 200 ms opaque
    else if (
      (currentTime - poweredUpBlinkingStartingTime) > 400 &&
      (currentTime - poweredUpBlinkingStartingTime) < 800
    ) {
      getImage().setTransparency(255);
    }
    // Resets the cycle
    else {
      poweredUpBlinkingStartingTime = System.currentTimeMillis();
    }
  }

  private void powerUp() {
    // Makes the player blink if the player is powered up, and stops the power up after 15 seconds

    // Powered up
    if (isPoweredUp) {
      blink();
    }

    // Stop the power up after 15 seconds
    if (
      (isPoweredUp) &&
      (System.currentTimeMillis() - poweredUpStartingTime) > 15000
    ) {
      // TODO: Add sound after power up ends
      getImage().setTransparency(255);
      isPoweredUp = false;
    }
  }

  // Movement
  protected void setIsMoving(boolean newIsMoving) {
    isMoving = newIsMoving;
  }

  private void bearMovementAnimation(
    // Animates the bears while they're movings
    
    GreenfootImage[] BearUpAnimation,
    GreenfootImage[] BearRightAnimation,
    GreenfootImage[] BearDownAnimation,
    GreenfootImage[] BearLeftAnimation
  ) {
    // Isn't moving
    if (!isMoving) {}
    // Moving up
    else if (movementDirection == 0) {
      bearMovementAnimationIndex += 1;

      if (bearMovementAnimationIndex >= BearUpAnimation.length) {
        bearMovementAnimationIndex = 0;
      }

      BearUpAnimation[bearMovementAnimationIndex].scale(12, 17);
      setImage(BearUpAnimation[bearMovementAnimationIndex]);
    }
    // Moving right
    else if (movementDirection == 1) {
      bearMovementAnimationIndex += 1;

      if (bearMovementAnimationIndex >= BearRightAnimation.length) {
        bearMovementAnimationIndex = 0;
      }

      BearRightAnimation[bearMovementAnimationIndex].scale(17, 12);
      setImage(BearRightAnimation[bearMovementAnimationIndex]);
    }
    // Moving down
    else if (movementDirection == 2) {
      bearMovementAnimationIndex += 1;

      if (bearMovementAnimationIndex >= BearDownAnimation.length) {
        bearMovementAnimationIndex = 0;
      }

      BearDownAnimation[bearMovementAnimationIndex].scale(12, 17);
      setImage(BearDownAnimation[bearMovementAnimationIndex]);
    }
    // Moving left
    else if (movementDirection == 3) {
      bearMovementAnimationIndex += 1;

      if (bearMovementAnimationIndex >= BearLeftAnimation.length) {
        bearMovementAnimationIndex = 0;
      }

      BearLeftAnimation[bearMovementAnimationIndex].scale(17, 12);
      setImage(BearLeftAnimation[bearMovementAnimationIndex]);
    }
  }

  private void move(char[] keyboardKeys) {
    // Player 1 movement

    if (Greenfoot.isKeyDown(String.valueOf(keyboardKeys[0]))) {
      isMoving = true;
      movementDirection = 0;
    } else if (Greenfoot.isKeyDown(String.valueOf(keyboardKeys[1]))) {
      isMoving = true;
      movementDirection = 1;
    } else if (Greenfoot.isKeyDown(String.valueOf(keyboardKeys[2]))) {
      isMoving = true;
      movementDirection = 2;
    } else if (Greenfoot.isKeyDown(String.valueOf(keyboardKeys[3]))) {
      isMoving = true;
      movementDirection = 3;
    }

    if (isMoving) {
      // Moving up
      if (movementDirection == 0) {
        // Checks if there is a wall above before moving up
        if (
          (getWorld().getObjectsAt(getX(), getY() - 1, Wall.class)).isEmpty() ==
          false
        ) {
          isMoving = false;
        } else {
          setLocation(getX(), getY() - 1);
        }
      }
      // Moving to the right
      else if (movementDirection == 1) {
        // Checks if there is a wall to the right before moving to the right
        if (
          (getWorld().getObjectsAt(getX() + 1, getY(), Wall.class)).isEmpty() ==
          false
        ) {
          isMoving = false;
        } else {
          setLocation(getX() + 1, getY());
        }
        // Moving down
      } else if (movementDirection == 2) {
        // Checks if there is a wall below before moving down
        if (
          (getWorld().getObjectsAt(getX(), getY() + 1, Wall.class)).isEmpty() ==
          false
        ) {
          isMoving = false;
        } else {
          setLocation(getX(), getY() + 1);
        }
        // Moving to the left
      } else if (movementDirection == 3) {
        // Checks if there is a wall to the left before moving to the left
        if (
          getWorld().getObjectsAt(getX() - 1, getY(), Wall.class).isEmpty() ==
          false
        ) {
          isMoving = false;
        } else {
          setLocation(getX() - 1, getY());
        }
      }
    }
  }

  private void move(String[] keyboardKeys) {
    // Player 2 movement

    if (Greenfoot.isKeyDown(keyboardKeys[0])) {
      isMoving = true;
      movementDirection = 0;
    } else if (Greenfoot.isKeyDown(keyboardKeys[1])) {
      isMoving = true;
      movementDirection = 1;
    } else if (Greenfoot.isKeyDown(keyboardKeys[2])) {
      isMoving = true;
      movementDirection = 2;
    } else if (Greenfoot.isKeyDown(keyboardKeys[3])) {
      isMoving = true;
      movementDirection = 3;
    }

    if (isMoving) {
      // Moving up
      if (movementDirection == 0) {
        // Checks if there is a wall above before moving up
        if (
          (getWorld().getObjectsAt(getX(), getY() - 1, Wall.class)).isEmpty() ==
          false
        ) {
          isMoving = false;
        } else {
          setLocation(getX(), getY() - 1);
        }
      }
      // Moving to the right
      else if (movementDirection == 1) {
        // Checks if there is a wall to the right before moving to the right
        if (
          (getWorld().getObjectsAt(getX() + 1, getY(), Wall.class)).isEmpty() ==
          false
        ) {
          isMoving = false;
        } else {
          setLocation(getX() + 1, getY());
        }
        // Moving down
      } else if (movementDirection == 2) {
        // Checks if there is a wall below before moving down
        if (
          (getWorld().getObjectsAt(getX(), getY() + 1, Wall.class)).isEmpty() ==
          false
        ) {
          isMoving = false;
        } else {
          setLocation(getX(), getY() + 1);
        }
        // Moving to the left
      } else if (movementDirection == 3) {
        // Checks if there is a wall to the left before moving to the left
        if (
          getWorld().getObjectsAt(getX() - 1, getY(), Wall.class).isEmpty() ==
          false
        ) {
          isMoving = false;
        } else {
          setLocation(getX() - 1, getY());
        }
      }
    }
  }

  public void act() {
    // Individual player initialization
    if (!wasInitialized) {
      // Sets the respawning position. The respawning position is set equal to the position that the player actor is initialized (the position in the first act).
      spawnX = getX();
      spawnY = getY();

      // Player image
      if (player1MovementKeys != null) {
        setImage("be_1.png");
        getImage().scale(17, 12);
      } else {
        setImage("ad_1.png");
        getImage().scale(17, 12);
      }

      wasInitialized = true;
    }

    if (
      (getWorldOfType(Level.class).wasCountdownAlreadyShown()) &&
      (!getWorldOfType(Level.class).getGameOver())
    ) {
      // Player 1 movement
      if (player1MovementKeys != null) {
        move(player1MovementKeys);

        // Player 1 bear up animations
        GreenfootImage[] player1BearUpAnimation = new GreenfootImage[4];
        player1BearUpAnimation[0] = new GreenfootImage("bc_1.png");
        player1BearUpAnimation[1] = new GreenfootImage("bc_2.png");
        player1BearUpAnimation[2] = new GreenfootImage("bc_1.png");
        player1BearUpAnimation[3] = new GreenfootImage("bc_3.png");

        // Player 1 bear right animations
        GreenfootImage[] player1BearRightAnimation = new GreenfootImage[4];
        player1BearRightAnimation[0] = new GreenfootImage("bd_1.png");
        player1BearRightAnimation[1] = new GreenfootImage("bd_2.png");
        player1BearRightAnimation[2] = new GreenfootImage("bd_1.png");
        player1BearRightAnimation[3] = new GreenfootImage("bd_3.png");

        // Player 1 bear down animations
        GreenfootImage[] player1BearDownAnimation = new GreenfootImage[4];
        player1BearDownAnimation[0] = new GreenfootImage("bb_1.png");
        player1BearDownAnimation[1] = new GreenfootImage("bb_2.png");
        player1BearDownAnimation[2] = new GreenfootImage("bb_1.png");
        player1BearDownAnimation[3] = new GreenfootImage("bb_3.png");

        // Player 1 bear left animations
        GreenfootImage[] player1BearLeftAnimation = new GreenfootImage[4];
        player1BearLeftAnimation[0] = new GreenfootImage("be_1.png");
        player1BearLeftAnimation[1] = new GreenfootImage("be_2.png");
        player1BearLeftAnimation[2] = new GreenfootImage("be_1.png");
        player1BearLeftAnimation[3] = new GreenfootImage("be_3.png");

        bearMovementAnimation(
          player1BearUpAnimation,
          player1BearRightAnimation,
          player1BearDownAnimation,
          player1BearLeftAnimation
        );
      }
      // Player 2 movement
      else {
        move(player2MovementKeys);

        // Player 2 bear up animations
        GreenfootImage[] player1BearUpAnimation = new GreenfootImage[4];
        player1BearUpAnimation[0] = new GreenfootImage("ac_1.png");
        player1BearUpAnimation[1] = new GreenfootImage("ac_2.png");
        player1BearUpAnimation[2] = new GreenfootImage("ac_1.png");
        player1BearUpAnimation[3] = new GreenfootImage("ac_3.png");

        // Player 2 bear right animations
        GreenfootImage[] player1BearRightAnimation = new GreenfootImage[4];
        player1BearRightAnimation[0] = new GreenfootImage("ad_1.png");
        player1BearRightAnimation[1] = new GreenfootImage("ad_2.png");
        player1BearRightAnimation[2] = new GreenfootImage("ad_1.png");
        player1BearRightAnimation[3] = new GreenfootImage("ad_3.png");

        // Player 2 bear down animations
        GreenfootImage[] player1BearDownAnimation = new GreenfootImage[4];
        player1BearDownAnimation[0] = new GreenfootImage("ab_1.png");
        player1BearDownAnimation[1] = new GreenfootImage("ab_2.png");
        player1BearDownAnimation[2] = new GreenfootImage("ab_1.png");
        player1BearDownAnimation[3] = new GreenfootImage("ab_3.png");

        // Player 2 bear left animations
        GreenfootImage[] player1BearLeftAnimation = new GreenfootImage[4];
        player1BearLeftAnimation[0] = new GreenfootImage("ae_1.png");
        player1BearLeftAnimation[1] = new GreenfootImage("ae_2.png");
        player1BearLeftAnimation[2] = new GreenfootImage("ae_1.png");
        player1BearLeftAnimation[3] = new GreenfootImage("ae_3.png");

        bearMovementAnimation(
          player1BearUpAnimation,
          player1BearRightAnimation,
          player1BearDownAnimation,
          player1BearLeftAnimation
        );
      }
    }

    powerUp();
  }
}
