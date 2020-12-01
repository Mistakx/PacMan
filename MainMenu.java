import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MainMenu extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MainMenu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
                setBackground("background.png");
        
        // Play Button
        ButtonPlay playButton = new ButtonPlay();
        addObject(playButton, 300, 100);
        
                //Instructions Button
        ButtonInstructions instructionsButton = new ButtonInstructions();
        addObject(instructionsButton, 300, 200);
        
        // Exit button
        ButtonExit exitButton = new ButtonExit();
        addObject(exitButton, 300, 300);
    }
}
