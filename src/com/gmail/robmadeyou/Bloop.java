package com.gmail.robmadeyou;

import com.age.Screen;
import com.age.world.World;

/**
 * Created by apex on 02/03/14.
 */
public class Bloop {
    public static void main(String... args){
        Screen.create(800,500, "Bloop!");

        World.load(new World());
        Player p =(Player) new Player(0,0).toEngine();

        while(!Screen.isCloseRequested()){
            Screen.update();

            Screen.refresh(60);
        }
    }
}
