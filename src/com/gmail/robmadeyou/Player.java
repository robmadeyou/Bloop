package com.gmail.robmadeyou;

import com.age.graphics.effects.Animation;
import com.age.graphics.effects.TextureLoader;
import com.age.logic.entity.Entity;
import com.age.logic.input.Keyboard;

/**
 * Created by apex on 13/03/14.
 */
public class Player extends Entity{


    Animation skeleton = new Animation(TextureLoader.createTexture("res/animations/skeleton/1.png"),2);
    public Player(double x, double y){
        super(x, y, 30, 60);
        skeleton.add(TextureLoader.createTexture("res/animations/skeleton/2.png"))
                              .add(TextureLoader.createTexture("res/animations/skeleton/3.png"))
                              .add(TextureLoader.createTexture("res/animations/skeleton/4.png"));
        setTexture(skeleton.getCurrentTexture());
    }

    @Override
    public void update(double delta){
        super.update(delta);
        if(Keyboard.isKeyDown(Keyboard.Key.D)){
            moveRight();
        }else if(Keyboard.isKeyDown(Keyboard.Key.A)){
            moveLeft();
        }
        if(Keyboard.isKeyDown(Keyboard.Key.Space)){
            jump(-5);
        }
    }

    @Override
    public boolean moveLeft(){
        setTexture(skeleton.getCurrentTexture());
        setInvertsX(true);
        return super.moveLeft();
    }

    @Override
    public boolean moveRight(){
        setTexture(skeleton.getCurrentTexture());
        setInvertsX(false);
        return super.moveRight();
    }
}