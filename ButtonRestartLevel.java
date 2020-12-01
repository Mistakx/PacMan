import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class ButtonRestartLevel extends Actor
{
    
    GreenfootSound backgroundMusic;
    
    

    
    public ButtonRestartLevel(GreenfootSound backgroundMusic){
    
    this.backgroundMusic = backgroundMusic;
    getImage().scale(225, 75);
    
    }
    

    public void act() 
    {
       if (Greenfoot.mouseMoved(this)) getImage().setTransparency(100);
       if (Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this)) getImage().setTransparency(255);



        if (Greenfoot.mouseClicked(this))
        {  

              backgroundMusic.stop();
              
                    if (getWorld() instanceof Level1) {
Greenfoot.setWorld(new Level1());
      } else if (getWorld() instanceof Level2) {
Greenfoot.setWorld(new Level2());
      }
              
            
      }
    }  
}

