import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

public class Level extends World {

  private int score = 0;
  private int playerHealth = 3;
  private boolean countdownAlreadyShown = false; // Starts the movement after the coundown is shown
  private long startingTime; // The time at which the level was initialized
  private boolean gameOver = false; // Stops the movement after the game is over
  private int numberOfCoinsAte = 0; // Used to insert new coins after eating them all
  private int numberOfCoinsInLevel; // The total amount of coins in each level

  private Player[] players = new Player[2];
  private Enemy[] enemies = new Enemy[6];

  public Level(long startingTime) {
    super(36, 36, 17);
    this.startingTime = startingTime;
  }

  // Actors
  protected Player[] getPlayers() {
    return players;
  }

  protected void addPlayer(Player newPlayer, int i) {
    players[i] = newPlayer;
  }

  protected Enemy[] getEnemies() {
    return enemies;
  }

  protected void addEnemy(Enemy newEnemy, int i) {
    enemies[i] = newEnemy;
  }

  // Number of Coins
  protected int getNumberOfCoinsAte() {
    return numberOfCoinsAte;
  }

  protected void setNumberOfCoinsAte(int newNumberOfCoinsAte) {
    numberOfCoinsAte = newNumberOfCoinsAte;
  }

  protected int getNumberOfCoinsInLevel() {
    return numberOfCoinsInLevel;
  }

  protected void setNumberOfCoinsInLevel(int newNumberOfCoinsInLevel) {
    numberOfCoinsInLevel = newNumberOfCoinsInLevel;
  }

  // Score
  protected int getScore() {
    return score;
  }

  protected void setScore(int newScore) {
    score = newScore;
  }

  protected void showScore(Level level) {
    showText("Score: " + String.valueOf(score), 2 * getWidth() / 3, 1);
  }

  // Player Health
  protected int getPlayerHealth() {
    return playerHealth;
  }

  protected void setPlayerHealth(int newPlayerHealth) {
    playerHealth = newPlayerHealth;
  }

  protected void showHealthBar(Level level) {
    // Player Health
    level.showText("Health: " + String.valueOf(playerHealth), getWidth() / 3, 1);


  }

  // Countdown
  protected boolean wasCountdownAlreadyShown() {
    return countdownAlreadyShown;
  }

  protected void setCountdownAlreadyShown(boolean newCountdownAlreadyShown) {
    countdownAlreadyShown = newCountdownAlreadyShown;
  }

  protected void countdown(Level level) {
    // Starts a 3 second countdown

    if (!countdownAlreadyShown) {
      long currentTime = System.currentTimeMillis();

      if (
        (currentTime - startingTime) > 1000 &&
        (currentTime - startingTime) < 2000
      ) {
        level.showText("Get ready: 3", 18, 17);
      } else if (
        (currentTime - startingTime) > 2000 &&
        (currentTime - startingTime) < 3000
      ) {
        level.showText("Get ready: 2", 18, 17);
      } else if (
        (currentTime - startingTime) > 3000 &&
        (currentTime - startingTime) < 4000
      ) {
        level.showText("Get ready: 1", 18, 17);
      } else if ((currentTime - startingTime) > 4000) {
        countdownAlreadyShown = true;
        level.showText("", 18, 17);
      }
    }
  }

  // Game Over
  protected boolean getGameOver() {
    return gameOver;
  }

  protected void setGameOver(boolean newGameOver) {
    gameOver = newGameOver;
  }

  // Return to menu
  protected void returnToMenu(GreenfootSound backgroundMusic) {
    if (Greenfoot.isKeyDown("escape")) {
      backgroundMusic.stop();
      Greenfoot.setWorld(new MainMenu());
    }
  }


}
