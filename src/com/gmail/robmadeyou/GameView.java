package com.gmail.robmadeyou;

import com.age.Age;
import com.age.Game;
import com.age.View;
import com.age.logic.input.Keyboard;
import com.age.world.World;


/**
 * Created by apex on 14/03/14.
 */
public class GameView extends View{
    public GameView(){
        super("Game");
    }

    @Override
    public void init(){
        World.load(new World());
        Player p =(Player) new Player(20,20).toEngine();
        p.setUseTranslate(true);
        Age.cameraMain.setTarget(p);
    }

    @Override
    public void update(){
        if(Keyboard.isKeyDown(Keyboard.Key.R)){
            getGame().changeView(new TitleView());
        }
    }

    @Override
    public void dispose(){

    }
}
