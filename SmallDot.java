import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

public class SmallDot extends Actor {

  public SmallDot() {
    GreenfootImage image = getImage();
    image.scale(14, 14);
    setImage(image);
  }

  private void hitPlayer() {
    List<Player> playerHit = getWorld()
      .getObjectsAt(getX(), getY(), Player.class);

    if (playerHit.isEmpty() == false) {
      Level level = getWorldOfType(Level.class);

      level.setScore(level.getScore() + 10);
      level.setNumberOfCoinsAte(level.getNumberOfCoinsAte() + 1);
      
      GreenfootSound eat = new GreenfootSound("eat.mp3");
      eat.play();
      eat.setVolume(30);

      getWorld().removeObject(this);
    }
  }

  public void act() {
    hitPlayer();
  }
}
