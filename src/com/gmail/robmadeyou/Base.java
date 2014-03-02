package com.gmail.robmadeyou;


import com.age.Age;
import com.age.Screen;
import com.age.graphics.Drawable;
import com.age.graphics.render.shapes.Box;

import java.util.ArrayList;

/**
 * Created by apex on 02/03/14.
 */
public class Base extends Box implements Part, Parent, Child{


    private boolean hasGrown = false;
    private long timeToGrow = 20000;
    private long timeCreated;

    private Part parent;

    private ArrayList<Part> partList = new ArrayList<Part>();

    private double originalX, originalY, grownWidth, grownHeight;

    /**
     * Notice no y value, this is because Base will always be on the ground
     * and so by default it will only need to be on the bottom.
     * Once generated, the Y value will decrease according to the height.
     * @param x x position
     * @param width width of the base
     * @param height height of the base
     */
    public Base(Part parent, double x, double width, double height){
        super(x, parent.getDrawableObject().getDrawY(), 0, 0);
        this.parent = parent;
        this.originalX = x;
        this.originalY = getDrawY();
        this.grownWidth = width;
        this.grownHeight = height;
    }

    @Override
    public Drawable getDrawableObject() {
        return this;
    }

    @Override
    public ArrayList<Part> getChildren() {
        return partList;
    }

    @Override
    public void addChild(Part p) {
        this.partList.add(p);
    }
    @Override
    public Part getParent(){
        return parent;
    }

    @Override
    public Base toEngine(){
        timeCreated = System.currentTimeMillis();
        return (Base) Age.add(this);
    }

    @Override
    public void draw(){
        super.draw();
        update(Screen.delta);
    }

    public void update(double d) {
        if(!hasGrown){
            double left = System.currentTimeMillis() - timeCreated;
            if(left > timeToGrow) hasGrown = true;
            else{
                double multiplier = left / timeToGrow;
                setDrawWidth(multiplier * grownWidth);
                setDrawHeight(multiplier * grownHeight);
                setDrawX(originalX - getDrawWidth() /  2);
                System.out.println(multiplier);
                setDrawY(parent.getDrawableObject().getDrawY() - getDrawHeight());
            }
        }
    }
}
