package com.gmail.robmadeyou;

import com.age.graphics.Drawable;

import java.util.ArrayList;

/**
 * Created by apex on 02/03/14.
 */
public interface Part {
    ArrayList<Part> getChildren();
    Drawable getDrawableObject();
    Part getParent();
    void addChild(Part p);
    void update(double d);
}
