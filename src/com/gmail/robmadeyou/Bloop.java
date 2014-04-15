package com.gmail.robmadeyou;

import com.age.Game;
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
    /**
     * Options view to change a few options to make the play style somewhat unique
     */
    public static View optionsView = new OptionsView();
    /**
     * Current score is held in here to make sure all classes can get
     * the score
     */
    public static int currentScore = 0;

    /**
     * Current level, reason for starting at 1 is because on the first
     * level the score wouldn't go up, as the score is calculated
     * by the level * current x coordinate
     */
    public static int currentLevel = 1;

    /**
     * Main method that invokes the runtime of the game
     * @param args any arguments you would like to pass. Nothing wil lbe done with them
     */
    public static void main(String... args){
        //Using Abereth.jar to invoke a new gae instance
        Game g = new Game("", 800,500);
        //Starting the game, with the view titleView
        g.start(titleView);
    }
}
