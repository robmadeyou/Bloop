package com.gmail.robmadeyou;

import com.age.Game;
import com.age.Screen;

/**
 * Created by apex on 02/03/14.
 */
public class Bloop {

    public static GameView game;

    public static void main(String... args){
        Game g = new Game("",600,500);
        g.start(new TitleView());
    }
}
