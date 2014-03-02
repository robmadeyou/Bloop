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

        while(!Screen.isCloseRequested()){
            Screen.update();

            Screen.refresh(60);
        }
    }
}
