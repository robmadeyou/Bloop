package com.gmail.robmadeyou;


import com.age.graphics.render.shapes.Box;
import com.age.logic.input.Mouse;


/**
 * Created by Aaapex on 18/03/14.
 *
 * Simply serves the purpose of detecting if a user has clicked
 * on the button or not.
 *
 * Extends Button class
 */
public class Button extends Box{
    /**
     * Default constructor for the Button object
     * @param x location 0 -> absolute left
     * @param y location 0 -> absolute top
     * @param width dimension, size of the width
     * @param height dimension, size of the height
     */
    public Button(double x, double y, double width, double height){
        super(x,y,width,height);
    }

    /**
     * Renders the button
     */
    @Override
    public void render(){
        /**
         * Here I've overridden the super method to add
         * "on hover" effects. When the user moves their mouse
         * over the button, it increases in opacity (originally opacity was set to 0)
         */
        super.render();
        if(isMouseOver()){
            if(getOpacity() < 1){
                setOpacity(getOpacity() + 0.025f);
            }
        }else{
            if(getOpacity() > 0){
                setOpacity(getOpacity() - 0.025f);
            }
        }
    }

    /**
     * Check if mouse is over the button (Hovering over the button)
     * @return if mouse in bounds returns true else false
     */
    public boolean isMouseOver(){
        if(isUseTranslate()){
            //If mouse is within the bounds of the button and if the button uses translation, return true
            if(Mouse.getTranslatedX() >= getDrawX() && Mouse.getTranslatedX() <= getDrawX() + getDrawWidth()
                    && Mouse.getTranslatedY() >= getDrawY() && Mouse.getTranslatedY() <= getDrawY() + getDrawHeight()){
                return true;
            }
        }else{
            //If mouse is within the bounds of the button, return true
            if(Mouse.getX() >= getDrawX() && Mouse.getX() <= getDrawX() + getDrawWidth()
                    && Mouse.getY() >= getDrawY() && Mouse.getY() <= getDrawY() + getDrawHeight()){
                return true;
            }
        }
        return false;
    }

    /**
     * If mouse is inside the button (hovering) and the left mouse button is pressed returns true else false
     */
    public boolean isPressed(){
        if(isMouseOver() && Mouse.isLeftMouseButtonDown()){
            return true;
        }
        return false;
    }
}
