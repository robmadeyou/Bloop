package com.gmail.robmadeyou;

import com.age.Screen;
import com.age.View;
import com.age.graphics.effects.Color;
import com.age.graphics.effects.TextureLoader;
import com.age.graphics.ui.Text;

/**
 * Created by apex on 19/03/14.
 */
public class HighScoresView extends View {

    Text title;

    Text backText;
    Button backButton;

    public HighScoresView(){
        super("HighScores");
    }

    @Override
    public void init() {
        backButton = (Button) new Button(10,Screen.getHeight() - 90, 125,70).toEngine();
        backButton.setTexture(TextureLoader.createTexture("res/border.png"));
        backButton.setColor(Color.RED);
        title = (Text) new Text("&?60HighScores", Screen.getWidth() / 2 - 250, 0).toEngine();
        backText = (Text) new Text("&?30Back", 20, Screen.getHeight() - 75).toEngine();
    }

    @Override
    public void update() {
        if(backButton.isPressed()){
            getGame().changeView(Bloop.menuView);
        }
    }

    @Override
    public void dispose() {

    }
}
