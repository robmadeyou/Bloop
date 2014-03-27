package com.gmail.robmadeyou;

import com.age.Age;
import com.age.Screen;
import com.age.View;
import com.age.graphics.effects.Color;
import com.age.graphics.effects.TextureLoader;
import com.age.graphics.ui.Text;
import com.age.logic.input.Keyboard;
import sun.misc.Sort;

import java.io.*;
import java.util.Arrays;

/**
 * Created by apex on 19/03/14.
 */
public class HighScoresView extends View {

    Text title;

    Text backText;

    Text[] HighScoresText = new Text[3];
    Button backButton;

    HighScoresEntry[] highScores = new HighScoresEntry[3];

    public HighScoresView(){
        super("HighScores");
        loadHighScores();
        for(int i = 0; i < HighScoresText.length; i++){
            HighScoresText[i] =(Text) new Text("&?30", 200, 200 + 30 * i);
        }
    }

    @Override
    public void init() {
        backButton = (Button) new Button(10,Screen.getHeight() - 90, 125,70).toEngine();
        backButton.setTexture(TextureLoader.createTexture("res/border.png"));
        backButton.setColor(Color.RED);
        title = (Text) new Text("&?60HighScores", Screen.getWidth() / 2 - 250, 0).toEngine();
        backText = (Text) new Text("&?30Back", 20, Screen.getHeight() - 75).toEngine();
        loadHighScores();

        for(int i = 0; i < HighScoresText.length; i++){
            HighScoresText[i].toEngine();

        }

        Arrays.sort(highScores);

        for(int i = 0; i < HighScoresText.length; i++){
            if(highScores[i] != null){
                HighScoresText[i].set("&?30" + highScores[i].getName() + " " + highScores[i].getScore());
            }
        }

    }

    @Override
    public void update() {
        if(backButton.isPressed()){
            getGame().changeView(Bloop.menuView);
        }
    }

    @Override
    public void dispose() {

    }

    public void loadHighScores(){
        try{
            String tmp = "";
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("save"));
            tmp = (String) ois.readObject();
            ois.close();
            if(!tmp.equalsIgnoreCase("")){
                for(String s : tmp.split("#")){
                    for(int i = 0; i < highScores.length; i++){
                        if(highScores[i] == null){
                            highScores[i] = new HighScoresEntry(s.split("&")[0], Integer.parseInt(s.split("&")[1]));
                            break;
                        }
                    }
                }
            }
        }catch(Exception e){};
    }

    public void saveHighScores(){
        String toSave = "";
        if(highScores != null){
            for(HighScoresEntry h : highScores){
                toSave+= h.getName() + "&" + h.getScore() + "#";
            }
        }
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("save"));
            oos.writeObject(toSave);
            oos.close();
        }catch(IOException e){}
    }

    public boolean addScore(HighScoresEntry entry){
        Arrays.sort(highScores);
        if(highScores[highScores.length-1].getScore() < entry.getScore()){
            highScores[highScores.length-1] = entry;
            Arrays.sort(highScores);
            for(int i = 0; i < HighScoresText.length; i++){
                if(highScores[i] != null){
                    HighScoresText[i].set("&?30" + highScores[i].getName() + " " + highScores[i].getScore());
                }
            }
            saveHighScores();
            return true;
        }
        return false;
    }
}
