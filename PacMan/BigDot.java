import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

public class BigDot extends Actor {

  private long blinkingStartingTime = System.currentTimeMillis();

  public BigDot() {
    GreenfootImage image = getImage();
    image.scale(15, 15);
    setImage(image);
  }

  private void blink() {
    // Blinking

    long currentTime = System.currentTimeMillis();

    // 200 ms Opaque
    if (currentTime - blinkingStartingTime < 250) {
      getImage().setTransparency(255);
    }
    // 200 ms Transparent
    else if (
      (currentTime - blinkingStartingTime) > 250 &&
      (currentTime - blinkingStartingTime) < 500
    ) {
      getImage().setTransparency(0);
    }
    // Resets the cycle
    else {
      blinkingStartingTime = System.currentTimeMillis();
    }
  }

  private void hitPlayer() {
    List<Player> playerHit = getWorld()
      .getObjectsAt(getX(), getY(), Player.class);

    if (playerHit.isEmpty() == false) {
      Level level = getWorldOfType(Level.class);
      level.setScore(level.getScore() + 50);
      level.setNumberOfCoinsAte(level.getNumberOfCoinsAte() + 1);

      GreenfootSound roar = new GreenfootSound("roar.mp3");
      roar.play();

      // Power up the player that hit the big dot. If two players hit it at the same time, only powers up the first in the list.
      playerHit.get(0).setIsPoweredUp(true);
      playerHit
        .get(0)
        .setPoweredUpBlinkingStartingTime(System.currentTimeMillis());
      playerHit.get(0).setPoweredUpStartingTime(System.currentTimeMillis());

      getWorld().removeObject(this);
    }
  }

  public void act() {
    blink();
    hitPlayer();
  }
}
