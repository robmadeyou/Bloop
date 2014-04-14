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
 *
 * GameView holds the whole game and deals with all of the Physics.
 */
public class GameView extends View{

    //Score "Label" that will show the user the score
    Text score;
    //Player entity that the user will be able to control
    Player p;
    //How far is the wall currently. This will increase every wall tick
    int wallIndex = 0;
    //How many iterations must the wall wait to increase in index
    int wallDelay = 10 - Bloop.currentLevel;
    //Current wall iteration, after it passes or is equal to wallDelay it is reset
    int wallDelayCurrent = 0;

    //The Player label when seeing the map
    Text playerText;
    //Same as playerText, except for the wall
    Text wallText;
    //The "path" that both playerText and wallText will follow
    Line line;
    //The delay for the wall to start when the view is first created
    Timer wallStart;

    /**
     * Default constructor for the GameView object
     */
    public GameView(){
        super("Game");
    }

    /**
     * Init method, initializes all of the objects. This is done in the init method
     * because otherwise the engine would break.
     */
    @Override
    public void init(){
        /*

            Resets the score, as the player might want to play the game more than once, if this wasn't done
            the score would be saved from the last time and the player would just be able to "cheat"

            *Notice* how this isn't done with the current level. This is because the level is "Re loaded"
            to re-generate the terrain, and set the location of labels back to original, if the level would be
            reset here, the player would never be able to get a higher score than 200 (because there was no level multiplier)

         */
        Bloop.currentScore = 0;
        //Initialize the score label and add it to the engine for rendering
        score = (Text) new Text("", 20, 20).toEngine();
        /*
            Create a timer to countdown 3000 milliseconds (3 seconds) from the View creation.
            when timer is 0 the wall will start to move
         */
        wallStart = new Timer(3000);
        //Set the path the player label and wall label will follow, it is created dynamically according to the screen size
        line = new Line(Screen.getWidth() / 2 - 200, 70, Screen.getWidth() / 2 + 200, 70).toEngine();

        //Player text to show the location of player in relation to how far in the map they are
        playerText = (Text) new Text("You", Screen.getWidth() / 2 - 200, 75).toEngine();
        //Wall label to show the location of the wall in relation to how far in the map it is
        wallText = (Text) new Text("Wall", Screen.getWidth() / 2 - 200, 75).toEngine();

        //Creating the Player entity and adding it to the Engine for functionality like physics, and rendering
        p =(Player) new Player(100,20).toEngine();
        //Set the gravity size, this will determine how fast the entity falls down
        p.setGravity(p.getGravity() - (float)(Bloop.currentLevel) / 90);
        //Set the jump height, this will determine how high the player will ultimately be able to jump
        p.setJumpHeight(p.getJumpHeight() - Bloop.currentLevel / 5);
        /*
            Make sure that the player object uses translate, this means that the player can move across
            the map without any problems. It also means that the camera is able to follow the player
         */
        p.setUseTranslate(true);
        //Load a new world
        World.load(new World(32,200,50));

        /*
            Setting the target of the camera to be the player object. This means that the camera will follow
            the player when they are running across the map
        */
        Age.cameraMain.setTarget(p);

        //Creating a new tileType dirt, this only serves a visual bonus to the level
        TileType dirt = new TileType(TextureLoader.createTexture("res/dirt.png"), true, "DIRT");
        //Creating a new tileType topGrass, similar to dirt, except it has a grass top
        TileType topGrass = new TileType(TextureLoader.createTexture("res/grassTop.png"), true, "GRASS_TOP");

        //Check if the active world is empty and load it if it is
        if(World.activeWorld == null){
            World.activeWorld.load();
        }

        /*

            This nested for loop block loops twice through the map to create really random terrain.

            The terrain is randomly generated, but it is made in such a way that the player is still able to jump over
            the walls. This is done by checking if the "tower" generated is larger than the height that the player is
            able  to jump. If it is, then a tower exactly 2x as small is generated to the left of it.


         */
        for(int k = 0; k < 2; k++){
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
        if(SerialRead.jump){
            p.jump(-4);
        }
        if(SerialRead.run){
            p.moveRight();
        }
        score.set("&?50SCORE "+ Bloop.currentScore);
        score.setDrawX(Screen.getWidth() / 2 - ((score.getChildren().size() * 50) / 2));
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
