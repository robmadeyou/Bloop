package com.gmail.robmadeyou;

import com.age.Game;
import com.age.Screen;
import com.age.View;

/**
 *
 * @author Robert Ellis
 */
public class Bloop {
    /**
     * Menu view pre-created to avoid memory errors when switching views.
     */
    public static View menuView = new MenuView();
    /**
     * Title view pre-created for convenience
     */
    public static View titleView = new TitleView();
    /**
     * High scores
     */
    public static View highScoresView = new HighScoresView();

    public static int currentScore = 0;
    public static int currentLevel = 1;

    public static void main(String... args){
        Game g = new Game("", 800,500);
        g.start(titleView);
    }
}
