package com.gmail.robmadeyou;


import com.age.Screen;
import com.age.graphics.Drawable;
import com.age.graphics.render.shapes.Box;

import java.util.ArrayList;

/**
 * Created by apex on 02/03/14.
 */
public class Base extends Box implements Part{
    private ArrayList<Part> partList = new ArrayList<Part>();

    /**
     * Notice no y value, this is because Base will always be on the ground
     * and so by default it will only need to be on the bottom.
     * Once generated, the Y value will decrease according to the height.
     * @param x x position
     * @param width width of the base
     * @param height height of the base
     */
    public Base(double x, double width, double height){
        super(x, Screen.getHeight(), width, height);
    }

    @Override
    public Drawable getDrawableObject() {
        return this;
    }

    @Override
    public ArrayList<Part> getChildren() {
        return null;
    }

    @Override
    public Part getParent() {
        return null;
    }

    @Override
    public void addChild(Part p) {

    }

    @Override
    public void update(double d) {

    }
}
