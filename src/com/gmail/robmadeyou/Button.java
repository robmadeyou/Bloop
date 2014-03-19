package com.gmail.robmadeyou;


import com.age.graphics.render.shapes.Box;
import com.age.logic.input.Mouse;


/**
 * Created by Aaapex on 18/03/14.
 */
public class Button extends Box{

    public Button(double x, double y, double width, double height){
        super(x,y,width,height);
    }

    @Override
    public void render(){
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

    public boolean isMouseOver(){
        if(isUseTranslate()){
            if(Mouse.getTranslatedX() >= getDrawX() && Mouse.getTranslatedX() <= getDrawX() + getDrawWidth()
                    && Mouse.getTranslatedY() >= getDrawY() && Mouse.getTranslatedY() <= getDrawY() + getDrawHeight()){
                return true;
            }
        }else{
            if(Mouse.getX() >= getDrawX() && Mouse.getX() <= getDrawX() + getDrawWidth()
                    && Mouse.getY() >= getDrawY() && Mouse.getY() <= getDrawY() + getDrawHeight()){
                return true;
            }
        }
        return false;
    }

    public boolean isPressed(){
        if(isMouseOver() && Mouse.isLeftMouseButtonDown()){
            return true;
        }
        return false;
    }
}
