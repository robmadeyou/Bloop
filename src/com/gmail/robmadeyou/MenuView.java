package com.gmail.robmadeyou;

import com.age.Screen;
import com.age.View;
import com.age.graphics.effects.Color;
import com.age.graphics.effects.TextureLoader;
import com.age.graphics.ui.Text;
import com.age.graphics.ui.Image;

/**
 * Created by Aaapex on 18/03/14.
 */
public class MenuView extends View {


    Text playText;
    Button playButton;

    Text highText;
    Button highButton;

    Text optionsText;
    Button optionsButton;

    Image title;
    public MenuView(){
        super("MenuView");
    }

    @Override
    public void init() {
        playButton = (Button) new Button(50,50,136,75).toEngine();
        playButton.setOpacity(0f);
        playButton.setColor(Color.RED);
        playButton.setTexture(TextureLoader.createTexture("res/border.png"));
        playText = (Text) new Text("&?30Play", 70,70).toEngine();

        highButton = (Button) new Button(180,120,350,75).toEngine();
        highButton.setOpacity(0f);
        highButton.setColor(Color.BLUE);
        highButton.setTexture(TextureLoader.createTexture("res/border.png"));
        highText = (Text) new Text("&?30High Scores", 200,140).toEngine();

        optionsButton = (Button) new Button(480,380,230,75).toEngine();
        optionsButton.setOpacity(0f);
        optionsButton.setColor(Color.GREEN);
        optionsButton.setTexture(TextureLoader.createTexture("res/border.png"));
        optionsText = (Text) new Text("&?30Options", 500, 400).toEngine();

        title =(Image) new Image(Screen.getWidth() / 2 - 100, Screen.getHeight() / 2 - 50, 200,100).toEngine();
        title.setTexture(TextureLoader.createTexture("res/Title.png"));
    }

    @Override
    public void update() {
        if(playButton.isPressed()){
            getGame().changeView(new GameView());
        }else if(highButton.isPressed()){
            //TODO add highscores
        }else if(optionsButton.isPressed()){
            //TODO add options
        }

    }

    @Override
    public void dispose() {

    }
}
