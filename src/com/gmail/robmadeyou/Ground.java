package com.gmail.robmadeyou;

import com.age.Screen;
import com.age.graphics.Drawable;
import com.age.graphics.render.shapes.Box;

import java.util.ArrayList;

/**
 * Created by apex on 02/03/14.
 */
public class Ground extends Box implements Part, Parent{

    /**
     * Ground acts as a base component for the game. It's the Father/Mother of all
     * other objects in the game.
     * @param size amount of pixels from bottom of the screen.
     */
    public Ground(double size){
        super(0, Screen.getHeight() - size,Screen.getWidth(), size);
    }

    @Override
    public ArrayList<Part> getChildren() {
        return null;
    }

    @Override
    public Drawable getDrawableObject() {
        return this;
    }

    @Override
    public void addChild(Part p) {

    }
}
