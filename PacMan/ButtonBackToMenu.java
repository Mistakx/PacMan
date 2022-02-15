import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class ButtonBackToMenu extends Actor
{
    GreenfootSound backgroundMusic;
 
    
    public ButtonBackToMenu(GreenfootSound backgroundMusic){
    
        getImage().scale(225, 75);
    this.backgroundMusic = backgroundMusic;
    
    }
    
    public ButtonBackToMenu(){    
       getImage().scale(225, 75);

    }
    
    

    public void act() 
    {

        
       if (Greenfoot.mouseMoved(this)) getImage().setTransparency(100);
       if (Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this)) getImage().setTransparency(255);



        if (Greenfoot.mouseClicked(this))
        {  
              
            if ( backgroundMusic != null){
              backgroundMusic.stop();
            }
              Greenfoot.setWorld(new MainMenu());
              
            
      }
    }  
}

