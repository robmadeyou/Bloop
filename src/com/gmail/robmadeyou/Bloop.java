package com.gmail.robmadeyou;

import com.age.Screen;
import com.age.logic.entity.Enemy;
import com.age.world.World;

/**
 * Created by apex on 02/03/14.
 */
public class Bloop {
    public static void main(String[] args){
        Screen.create(800,500, "Bloop!");

        Enemy e =(Enemy) new Enemy(20,20,20,20).toEngine();
        World.load(new World(32,50,50));
        while(!Screen.isCloseRequested()){
            Screen.update();



            Screen.refresh(60);
        }
    }
}
