package com.gmail.robmadeyou;

import com.age.Age;
import com.age.Game;
import com.age.Screen;
import com.age.View;
import com.age.graphics.effects.TextureLoader;
import com.age.graphics.render.shapes.Line;
import com.age.logic.input.Keyboard;
import com.age.world.Tile;
import com.age.world.TileType;
import com.age.world.World;
import com.age.graphics.ui.Text;

import javax.swing.*;


/**
 * Created by apex on 14/03/14.
 */
public class GameView extends View{

    Text score;
    Player p;
    Timer countdownTimer;
    Text countdownText;
    int wallIndex = 0;
    int wallDelay = 10 - Bloop.currentLevel;
    int wallDelayCurrent = 0;

    Text playerText;
    Text wallText;
    Line line;
    Timer wallStart;
    public GameView(){
        super("Game");
    }

    @Override
    public void init(){

        Bloop.currentScore = 0;

        wallStart = new Timer(3000);
        line = new Line(Screen.getWidth() / 2 - 200, 70, Screen.getWidth() / 2 + 200, 70).toEngine();

        playerText = (Text) new Text("You", Screen.getWidth() / 2 - 200, 75).toEngine();
        wallText = (Text) new Text("Wall", Screen.getWidth() / 2 - 200, 75).toEngine();

        score = (Text) new Text("", 200,0).toEngine();
        countdownText = (Text) new Text("", 250,100).toEngine();
        p =(Player) new Player(100,20).toEngine();
        p.setGravity(p.getGravity() - (float)(Bloop.currentLevel) / 90);
        p.setJumpHeight(p.getJumpHeight() - Bloop.currentLevel / 5);
        World.load(new World(32,200,50));
        p.setUseTranslate(true);
        countdownTimer = new Timer(24000);
        Age.cameraMain.setTarget(p);
        TileType dirt = new TileType(TextureLoader.createTexture("res/dirt.png"), true, "DIRT");
        TileType topGrass = new TileType(TextureLoader.createTexture("res/grassTop.png"), true, "GRASS_TOP");
        if(World.activeWorld == null){
            World.activeWorld.load();
        }
        for(int k = 0; k < 1; k++){
            for(int i = 0; i < World.activeWorld.get().length; i++){
                for(int j = 0; j < World.activeWorld.get()[i].length; j++){
                    try{
                        if(World.activeWorld.get()[i][j].isSolid()){
                            if(Math.random() >= 0.7){
                                int duration = (int)(Math.random() * 10 + Bloop.currentLevel);
                                for(int l = 0; l < duration; l++){
                                    World.activeWorld.get()[i][j-1*l].setType(TileType.BRICK);
                                    if(duration >= 5){
                                        if(l <= duration / 2){
                                            World.activeWorld.get()[i-1][j-1*l].setType(TileType.BRICK);
                                        }
                                    }
                                }
                            }
                        }
                    }catch(ArrayIndexOutOfBoundsException e){}
                }
            }
        }
        for(int i = 0; i < World.activeWorld.get().length; i++){
            for(int j = 0; j < World.activeWorld.get()[i].length; j++){
                try{
                    if(World.activeWorld.get()[i][j].getType() == TileType.BRICK){
                        if(World.activeWorld.get()[i][j - 1].getType() != TileType.AIR){
                            World.activeWorld.get()[i][j].setType(dirt);
                        }else if(World.activeWorld.get()[i][j - 1].getType() == TileType.AIR){
                            World.activeWorld.get()[i][j].setType(topGrass);
                        }
                    }
                }catch(ArrayIndexOutOfBoundsException e){}
            }
        }
    }

    @Override
    public void update(){

        score.set("&?50SCORE "+ Bloop.currentScore);
        score.setDrawX(Screen.getWidth() / 2 - ((score.getChildren().size() * 50) / 2));
        countdownText.set("Time left " + countdownTimer.timeLeft() / 1000);
        if(wallStart.isDone()){
            wallDelayCurrent++;
        }

        if(wallDelay < wallDelayCurrent){
            if(wallIndex < 2000){
                if(World.activeWorld.get().length - 1 > wallIndex){
                    wallIndex++;
                    for(int i = 0; i < World.activeWorld.get()[wallIndex].length; i++){
                        World.activeWorld.get()[wallIndex][i].setType(TileType.BRICK);
                    }
                }else{
                    onDeath();
                }
            }
            wallDelayCurrent = 0;
        }

        if(countdownTimer.isDone() || Math.round(p.getDrawX() / World.activeWorld.getDimensions()+1) <= wallIndex){
            onDeath();
        }

        playerText.setDrawX((Screen.getWidth()  / 2 - 200) + (((Screen.getWidth() / 2 + 200) - (Screen.getWidth() / 2 - 200)) * ((p.getDrawX() / World.activeWorld.getDimensions()) / World.activeWorld.get().length)));
        wallText.setDrawX((Screen.getWidth() / 2 - 200) + (((Screen.getWidth() / 2 + 200) - (Screen.getWidth() / 2 - 200)) * ((double)(wallIndex) / World.activeWorld.get().length)));
        Bloop.currentScore = (int) Math.round(p.getDrawX() / World.activeWorld.getDimensions()) * Bloop.currentLevel;
        if(p.getDrawX() / World.activeWorld.getDimensions() > 200){
            onWin();
        }
    }

    public void onDeath(){
        HighScoresView view =(HighScoresView) Bloop.highScoresView;
        if(view.addScore(new HighScoresEntry(JOptionPane.showInputDialog("What is your name?"), Bloop.currentScore))){
            JOptionPane.showMessageDialog(null, "Congratulations, you're in the high scores!");
        }
        Bloop.currentLevel = 1;
        getGame().changeView(Bloop.menuView);
    }

    public void onWin(){
        Bloop.currentLevel++;
        getGame().changeView(new GameView());
    }

    @Override
    public void dispose(){

    }
}
