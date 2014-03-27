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

    public static int currentScore = 0;
    public static int currentLevel = 1;

    public static void main(String... args){
        Game g = new Game("",1920,1080);
        g.start(new TitleView());
    }
}
