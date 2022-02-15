import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StageChooser extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public StageChooser()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        setBackground("background.png");
        
        // Stage 1 Button
                        showText("Stage 1", 200, 100);

        ButtonStage1 stage1Button = new ButtonStage1();
        addObject(stage1Button, 195, 220);
        

        
        
        // Stage 2 button
                        showText("Stage 2", 400, 100);
        ButtonStage2 stage2Button = new ButtonStage2();
        addObject(stage2Button, 405, 220);
    }
}
