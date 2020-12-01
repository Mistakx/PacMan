import greenfoot.*;
import java.util.ArrayList;
import java.util.List;

public class Enemy extends Actor {

  private int movementDirection; // 0 - Up, 1 - Right, 2 - Down, 3 - Left

  // Spawn
  private int spawnX;
  private int spawnY;

  private boolean wasInitialized = false;

  public Enemy(int movementDirection) {
    this.movementDirection = movementDirection;

    GreenfootImage image = getImage();
    image.scale(15, 15);
    setImage(image);
  }

  // Movement
  protected void setMovementDirection(int newMovementDirection) {
    movementDirection = newMovementDirection;
  }

  private void TurnBack() {
    if (movementDirection == 0) {
      movementDirection = 2;
    } else if (movementDirection == 1) {
      movementDirection = 3;
    } else if (movementDirection == 2) {
      movementDirection = 0;
    } else if (movementDirection == 3) {
      movementDirection = 1;
    }
  }

  private void moveWhenInCorner() {
    // Moving up when arriving at a corner, can't go up, can't go back down.
    if (movementDirection == 0) {
      // Checks left
      if (
        (getWorld().getObjectsAt(getX() - 1, getY(), Wall.class)).isEmpty() ==
        false
      ) {
        movementDirection = 1;
      }
      // Checks right
      else if (
        (getWorld().getObjectsAt(getX() + 1, getY(), Wall.class)).isEmpty() ==
        false
      ) {
        movementDirection = 3;
      }
    }
    // Moving right when arriving at a corner, can't go right, can't go back left
    else if (movementDirection == 1) {
      // Checks up
      if (
        (getWorld().getObjectsAt(getX(), getY() - 1, Wall.class)).isEmpty() ==
        false
      ) {
        movementDirection = 2;
      }
      // Checks down
      else if (
        (getWorld().getObjectsAt(getX(), getY() + 1, Wall.class)).isEmpty() ==
        false
      ) {
        movementDirection = 0;
      }
    }
    // Moving down when arriving at a corner, can't go down, can't go back up
    else if (movementDirection == 2) {
      // Checks left
      if (
        (getWorld().getObjectsAt(getX() - 1, getY(), Wall.class)).isEmpty() ==
        false
      ) {
        movementDirection = 1;
      }
      // Checks right
      else if (
        (getWorld().getObjectsAt(getX() + 1, getY(), Wall.class)).isEmpty() ==
        false
      ) {
        movementDirection = 3;
      }
    }
    // Moving left when arriving at a corner, can't go left, can't go back right
    else if (movementDirection == 3) {
      // Checks up
      if (
        (getWorld().getObjectsAt(getX(), getY() - 1, Wall.class)).isEmpty() ==
        false
      ) {
        movementDirection = 2;
      }
      // Checks down
      else if (
        (getWorld().getObjectsAt(getX(), getY() + 1, Wall.class)).isEmpty() ==
        false
      ) {
        movementDirection = 0;
      }
    }
  }

  private void moveWhenInIntersection() {
    // Wall only above. Can go right, down and left
    if (
      !getWorld().getObjectsAt(getX(), getY() - 1, Wall.class).isEmpty() && // Wall above
      getWorld().getObjectsAt(getX() + 1, getY(), Wall.class).isEmpty() && // No wall right
      getWorld().getObjectsAt(getX(), getY() + 1, Wall.class).isEmpty() && // No wall below
      getWorld().getObjectsAt(getX() - 1, getY(), Wall.class).isEmpty() // No wall left
    ) {
      // System.out.println("Wall only above");

      int randomNumber = Greenfoot.getRandomNumber(3);

      if (randomNumber == 0) {
        movementDirection = 1;
      } else if (randomNumber == 1) {
        movementDirection = 2;
      } else if (randomNumber == 2) {
        movementDirection = 3;
      }
    }
    // Wall only left. Can go up, right and down
    else if (
      getWorld().getObjectsAt(getX(), getY() - 1, Wall.class).isEmpty() && // No wall above
      getWorld().getObjectsAt(getX() + 1, getY(), Wall.class).isEmpty() && // No wall right
      getWorld().getObjectsAt(getX(), getY() + 1, Wall.class).isEmpty() && // No wall below
      !getWorld().getObjectsAt(getX() - 1, getY(), Wall.class).isEmpty() // Wall left
    ) {
      //System.out.println("Wall only left");

      int randomNumber = Greenfoot.getRandomNumber(3);

      if (randomNumber == 0) {
        movementDirection = 0;
      } else if (randomNumber == 1) {
        movementDirection = 1;
      } else if (randomNumber == 2) {
        movementDirection = 2;
      }
    }
    // No walls in any direction
    else if (
      getWorld().getObjectsAt(getX(), getY() - 1, Wall.class).isEmpty() && // No wall above
      getWorld().getObjectsAt(getX() + 1, getY(), Wall.class).isEmpty() && // No wall right
      getWorld().getObjectsAt(getX(), getY() + 1, Wall.class).isEmpty() && // No wall below
      getWorld().getObjectsAt(getX() - 1, getY(), Wall.class).isEmpty() // No wall left
    ) {
      //System.out.println("No walls in any direction");
      movementDirection = Greenfoot.getRandomNumber(4);
    }
    // Wall only below. Can go up, right and left
    else if (
      getWorld().getObjectsAt(getX(), getY() - 1, Wall.class).isEmpty() && // No wall above
      getWorld().getObjectsAt(getX() + 1, getY(), Wall.class).isEmpty() && // No wall right
      !getWorld().getObjectsAt(getX(), getY() + 1, Wall.class).isEmpty() && // Wall below
      getWorld().getObjectsAt(getX() - 1, getY(), Wall.class).isEmpty() // No wall left
    ) {
      //System.out.println("Wall only below");

      int randomNumber = Greenfoot.getRandomNumber(3);

      if (randomNumber == 0) {
        movementDirection = 0;
      } else if (randomNumber == 1) {
        movementDirection = 1;
      } else if (randomNumber == 2) {
        movementDirection = 3;
      }
    }
    // Wall only right. Can go up, right and down
    else if (
      getWorld().getObjectsAt(getX(), getY() - 1, Wall.class).isEmpty() && // No wall above
      !getWorld().getObjectsAt(getX() + 1, getY(), Wall.class).isEmpty() && // Wall right
      getWorld().getObjectsAt(getX(), getY() + 1, Wall.class).isEmpty() && // No wall below
      getWorld().getObjectsAt(getX() - 1, getY(), Wall.class).isEmpty() // No wall left
    ) {
      //System.out.println("Wall only to the right");

      int randomNumber = Greenfoot.getRandomNumber(3);

      if (randomNumber == 0) {
        movementDirection = 0;
      } else if (randomNumber == 1) {
        movementDirection = 2;
      } else if (randomNumber == 2) {
        movementDirection = 3;
      }
    }
  }

  private void move() {
    // Moving up
    if (movementDirection == 0) {
      setLocation(getX(), getY() - 1);
    }
    // Moving to the right
    else if (movementDirection == 1) {
      setLocation(getX() + 1, getY());
      // Moving down
    } else if (movementDirection == 2) {
      setLocation(getX(), getY() + 1);
      // Moving to the left
    } else if (movementDirection == 3) {
      setLocation(getX() - 1, getY());
    }

    // Reaches corner
    if (
      (getWorld().getObjectsAt(getX(), getY(), Corner.class)).isEmpty() == false
    ) {
      moveWhenInCorner();
    }
    // Reaches intersection
    else if (
      (getWorld().getObjectsAt(getX(), getY(), Intersection.class)).isEmpty() ==
      false
    ) {
      moveWhenInIntersection();
    }
    // Reaches turn back
    else if (
      (getWorld().getObjectsAt(getX(), getY(), TurnBack.class)).isEmpty() ==
      false
    ) {
      TurnBack();
    }
  }

  // Hit detection

  private void gameOver() {
    getWorldOfType(Level.class).setGameOver(true);
    getWorld()
      .showText(
        "Game Over! Score: " +
        String.valueOf(getWorldOfType(Level.class).getScore()) + ".",
        getWorld().getWidth() / 2,
        getWorld().getHeight() / 2
      );
      
            if (getWorld() instanceof Level1) {
               Level1 level1 = (Level1) getWorld(); 
               
               // Restart level button
      ButtonRestartLevel buttonRestartLevel = new ButtonRestartLevel(level1.getBackgroundMusic());
            getWorldOfType(Level.class).addObject(buttonRestartLevel, 10, 22);
            
            // Back to menu button
            ButtonBackToMenu buttonBackToMenu = new ButtonBackToMenu(level1.getBackgroundMusic());
            getWorldOfType(Level.class).addObject(buttonBackToMenu, 26, 22);

      } else if (getWorld() instanceof Level2) {
        Level2 level2 = (Level2) getWorld();
                       // Restart level button
      ButtonRestartLevel buttonRestartLevel = new ButtonRestartLevel(level2.getBackgroundMusic());
            getWorldOfType(Level.class).addObject(buttonRestartLevel, 10, 22);
            // Back to menu button
            ButtonBackToMenu buttonBackToMenu = new ButtonBackToMenu(level2.getBackgroundMusic());
            getWorldOfType(Level.class).addObject(buttonBackToMenu, 26, 22);

      }
      
      
      


  }

  private void stopTime(int milliseconds) {
    long startingTime = System.currentTimeMillis();

    while ((System.currentTimeMillis() - startingTime) < milliseconds) {}
  }

  private List<Player> hitPlayers(List<Player> playersAlreadyHit) {
    List<Player> playersHit = getWorld()
      .getObjectsAt(getX(), getY(), Player.class);

    // Hit one or more players
    if (playersHit.isEmpty() == false) {
      GreenfootSound roar = new GreenfootSound("roar.mp3");
      roar.play();

      // Players hit
      for (int i = 0; i < playersHit.size(); i++) {
        Player tempPlayerHit = playersHit.get(i);

        boolean playerAlreadyHit = false;

        // Players already hit
        for (int y = 0; y < playersAlreadyHit.size(); y++) {
          Player tempPlayerAlreadyHit = playersAlreadyHit.get(y);

          if (tempPlayerHit == tempPlayerAlreadyHit) {
            playerAlreadyHit = true;
          }
        }

        // If the player was already hit in a single act, don't hit it again
        if (!playerAlreadyHit) {
          // The player isn't powered up
          if (!tempPlayerHit.isPoweredUp()) {
            stopTime(1000);
            getWorldOfType(Level.class)
              .setPlayerHealth(
                getWorldOfType(Level.class).getPlayerHealth() - 1
              );

            tempPlayerHit.setLocation(
              tempPlayerHit.getSpawnX(),
              tempPlayerHit.getSpawnY()
            );

            tempPlayerHit.setIsMoving(false);

            if (getWorldOfType(Level.class).getPlayerHealth() < 1) {
              gameOver();
            }
          }
          // The player is powered up
          else if (tempPlayerHit.isPoweredUp()) {
            stopTime(500);

            getWorldOfType(Level.class)
              .setScore(getWorldOfType(Level.class).getScore() + 200);

            // Moves the enemy back to the box
            setLocation(spawnX, spawnY);
          }
        }
      }
    }

    return playersHit;
  }

  public void act() {
    // Individual enemy initialization
    if (!wasInitialized) {
      // Sets the respawning position. The respawning position is set equal to the position that the enemy actor is initialized (the position in the first act).
      spawnX = getX();
      spawnY = getY();

      wasInitialized = true;
    }

    // After the countdown ends, if the game isn't over
    if (
      getWorldOfType(Level.class).wasCountdownAlreadyShown() &&
      (!getWorldOfType(Level.class).getGameOver())
    ) {

      List<Player> playersHit = new ArrayList<Player>();
      playersHit = hitPlayers(playersHit);

      if (getWorld() instanceof Level1) {
        Level1 level1 = (Level1) getWorld();
        level1.leaveTheBox(this);
      } else if (getWorld() instanceof Level2) {
        Level2 level2 = (Level2) getWorld();
        level2.leaveTheBox(this);
      }
      
      hitPlayers(playersHit);
      move();
      hitPlayers(playersHit);

    }
  }
}
