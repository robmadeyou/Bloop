package com.gmail.robmadeyou;

import com.age.Screen;

/**
 * Created by apex on 02/03/14.
 */
public class Bloop {
    public static void main(String... args){
        Screen.create(800,500, "Bloop!");

        Ground g =(Ground) new Ground(2).toEngine();

        Base b = (Base) new Base(g, 60, 60, 200).toEngine();
        boolean a = false;
        while(!Screen.isCloseRequested()){
            Screen.update();
            if(!a && b.canGrowMore()){
                new Base(b, 60,20, 400).toEngine();
            }
            Screen.refresh(60);
        }
    }
}
