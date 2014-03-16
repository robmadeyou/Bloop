package com.gmail.robmadeyou;

import com.age.Age;
import com.age.Game;
import com.age.Screen;
import com.age.View;
import com.age.event.EventEmitterOnDotCreate;
import com.age.graphics.Drawable;
import com.age.graphics.effects.Emitter;
import com.age.graphics.ui.Image;
import com.age.helper.Random;

/**
 * Created by apex on 14/03/14.
 */
public class TitleView extends View{

    Image title;
    Timer t;
    public TitleView(){
        super("TitleView");
    }

    @Override
    public void init() {
        title =(Image) new Image(Screen.getWidth() / 2 - 100, Screen.getHeight() / 2 - 50, 200,100).toEngine();
        t = new Timer(3000);
        title.setIsVisible(false);
    }

    @Override
    public void dispose() {
    }

    @Override
    public void update() {
        if(t.isDone()){
            title.setIsVisible(true);
        }
    }
}
