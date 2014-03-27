package com.gmail.robmadeyou;

/**
 * Created by apex on 26/03/14.
 */
public class HighScoresEntry implements Comparable{
    private String name;
    private int score;
    public HighScoresEntry(String name, int score){
        this.name = name;
        this.score = score;
    }

    public String getName(){
        return name;
    }

    public int getScore(){
        return score;
    }

    public int compareTo(Object obj){
        return ((HighScoresEntry) obj).getScore() - score;
    }
}