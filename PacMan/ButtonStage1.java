import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class ButtonStage1 extends Actor
{

    ButtonStage1(){
    
                getImage().scale(200, 200);
    }
    
    public void act() 
    {
       if (Greenfoot.mouseMoved(this)) getImage().setTransparency(100);
       if (Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this)) getImage().setTransparency(255);


        if (Greenfoot.mouseClicked(this))
        {  
            Greenfoot.setWorld(new Level1());
    }  
}
}
