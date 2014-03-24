package com.gmail.robmadeyou;

import com.age.Game;
import com.age.Screen;
import com.age.View;

/**
 * Created by apex on 02/03/14.
 */
public class Bloop {

    public static View menuView = new MenuView();
    public static View titleView = new TitleView();
    public static View highScoresView = new HighScoresView();

    public static void main(String... args){
        Game g = new Game("",800,500);
        g.start(new TitleView());
    }
}
