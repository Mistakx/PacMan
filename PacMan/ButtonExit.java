import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class ButtonExit extends Actor
{

    public void act() 
    {
       if (Greenfoot.mouseMoved(this)) getImage().setTransparency(100);
       if (Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this)) getImage().setTransparency(255);



        if (Greenfoot.mouseClicked(this))
        {  
            System.exit(0);
    }  
}
}
