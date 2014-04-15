package com.gmail.robmadeyou;

/**
 * Created by apex on 26/03/14.
 * A simple high scores class that holds
 * the player data in an object. Implements Comparable
 * for convenience sake
 */
public class HighScoresEntry implements Comparable{
    private String name;
    private int score;
    public HighScoresEntry(String name, int score){
        this.name = name;
        this.score = score;
    }

    /**
     * @return players name
     */
    public String getName(){
        return name;
    }

    /**
     * @return score gained by player
     */
    public int getScore(){
        return score;
    }

    /**
     * Compares two score entries and returns the difference between them
     * This is used by the Arrays.sort method to successfully sory an array
     * @param obj Object, meaning other High scores entry
     * @return obj.getScore - this.score;
     */
    public int compareTo(Object obj){
        return ((HighScoresEntry) obj).getScore() - score;
    }

    //Note no setter methods due to the fact that these objects will only serve as a single purpose objects
    //meaning they will be created, but not edited
}