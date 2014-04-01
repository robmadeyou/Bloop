package com.gmail.robmadeyou;

import com.age.Screen;
import com.age.View;
import com.age.graphics.effects.Color;
import com.age.graphics.effects.TextureLoader;
import com.age.graphics.ui.Text;

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

    /**
     * Default constructor that takes no parameters. Loads high scores, and initializes the
     * HighScoresText array
     */
    public HighScoresView(){
        super("HighScores");
        loadHighScores();
        for(int i = 0; i < HighScoresText.length; i++){
            HighScoresText[i] = new Text("&?30", 200, 200 + 30 * i);
        }
    }

    /**
     * Initializing labels and making sure they are placed in order
     */
    @Override
    public void init() {
        backButton = (Button) new Button(10,Screen.getHeight() - 90, 125,70).toEngine();
        backButton.setTexture(TextureLoader.createTexture("res/border.png"));
        backButton.setColor(Color.RED);
        title = (Text) new Text("&?60HighScores", Screen.getWidth() / 2 - 250, 0).toEngine();
        backText = (Text) new Text("&?30Back", 20, Screen.getHeight() - 75).toEngine();

        //Load high scores from an external text file
        loadHighScores();

        /* ForEach loop compiled into a single line to save trees, it simply goes through the
         * HighScoresText array and adds each element to the engine, this way the objects
         * are able to be rendered
         * */
        for(Text t : HighScoresText){ t.toEngine();}
        //Sort the array in order of highest to lowest
        Arrays.sort(highScores);
        //After the scores have been sorted, they are added to the actual labels
        for(int i = 0; i < HighScoresText.length; i++){
            if(highScores[i] != null){
                HighScoresText[i].set("&?30" + highScores[i].getName() + " " + highScores[i].getScore());
            }
        }

    }

    /**
     * Update method, because nothing is really happening behind the scenes, this
     * method is rather small.
     *
     * The method is really only listening if the back button is pressed, and nothing else
     */
    @Override
    public void update() {
        if(backButton.isPressed()){
            getGame().changeView(Bloop.menuView);
        }
    }

    /**
     * Because the view doesn't get disposed (see in Bloop.java)
     * dispose method is empty.
     */
    @Override
    public void dispose() {

    }

    public void loadHighScores(){
        try{
            String tmp;
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
        }catch(Exception e){ e.printStackTrace(); System.out.println("File wasn't able to load");};
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
        }catch(IOException e){ e.printStackTrace(); System.out.println("Unable to save the high scores!");}
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
