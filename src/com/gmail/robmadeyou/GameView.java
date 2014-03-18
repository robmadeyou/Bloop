package com.gmail.robmadeyou;

import com.age.Age;
import com.age.Game;
import com.age.View;
import com.age.logic.input.Keyboard;
import com.age.world.World;
import com.age.graphics.ui.Text;


/**
 * Created by apex on 14/03/14.
 */
public class GameView extends View{

    Text score;
    Player p;
    public GameView(){
        super("Game");
    }

    @Override
    public void init(){
        score = (Text) new Text("", 200,0).toEngine();
        World.load(new World(32,2000,30));
        p =(Player) new Player(20,20).toEngine();
        p.setUseTranslate(true);
        Age.cameraMain.setTarget(p);

        World.activeWorld.load();
    }

    @Override
    public void update(){
        if(Keyboard.isKeyDown(Keyboard.Key.R)){
            World.activeWorld.save("save.txt");
        }
        score.set("&?50SCORE "+ Math.round(p.getDrawX() / World.activeWorld.getDimensions()));
    }

    @Override
    public void dispose(){

    }
}
