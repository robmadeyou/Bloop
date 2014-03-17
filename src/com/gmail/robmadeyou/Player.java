package com.gmail.robmadeyou;

import com.age.graphics.effects.Animation;
import com.age.graphics.effects.TextureLoader;
import com.age.logic.entity.Entity;
import com.age.logic.input.Keyboard;

/**
 * Created by apex on 13/03/14.
 */
public class Player extends Entity{


    Animation anim = new Animation(TextureLoader.createTexture("res/running.png",0,0,64,128));
    public Player(double x, double y){
        this(x, y, 64, 128);
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 9; j++){
                if(j != 8 && i != 7 && i != 6){
                    anim.add(TextureLoader.createTexture("res/running.png",57 * j, 128 * i,56,128));
                }
            }
        }
        setTexture(anim.get(0));

    }
    public Player(double x, double y, double width, double height){
        super(x,y,width,height);
    }

    @Override
    public void update(double delta){

        if(Keyboard.isKeyDown(Keyboard.Key.A)){
            moveLeft();
            setInvertsX(true);
            setTexture(anim.getCurrentTexture());
        }else if(Keyboard.isKeyDown(Keyboard.Key.D)){
            moveRight();
            setInvertsX(false);
            setTexture(anim.getCurrentTexture());
        }else{
            setTexture(anim.get(22));
        }
        if(Keyboard.isKeyDown(Keyboard.Key.Space)){
            jump(-4);
        }
        super.update(delta);
    }
}