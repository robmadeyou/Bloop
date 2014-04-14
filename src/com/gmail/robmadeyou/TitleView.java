package com.gmail.robmadeyou;

import com.age.Age;
import com.age.Screen;
import com.age.View;
import com.age.event.Event;
import com.age.graphics.effects.Color;
import com.age.graphics.effects.Emitter;
import com.age.graphics.effects.TextureLoader;
import com.age.graphics.ui.Image;
import com.age.helper.Random;

/**
 * Created by apex on 14/03/14.
 */
public class TitleView extends View{

    Image title;
    Timer t;
    Emitter e;
    public TitleView(){
        super("TitleView");
    }

    @Override
    public void init() {
        title =(Image) new Image(Screen.getWidth() / 2 - 100, Screen.getHeight() / 2 - 50, 200,100).toEngine();
        title.setTexture(TextureLoader.createTexture("res/Title.png"));
        t = new Timer(3000);
        title.setOpacity(0f);
        e =(Emitter) new Emitter(40,40,10,10,2f).toEngine();
    }

    @Override
    public void dispose() {

    }

    @Override
    public void update() {
        if(title.getOpacity() >= 1 && t.isDone()){
            t.reset();
            getGame().changeView(new MenuView());
        }else if(title.getOpacity() < 1 && t.isDone()){
            title.setOpacity(title.getOpacity() + 0.05f);
        }
    }
}