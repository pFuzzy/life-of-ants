package com.codecool.ants.Castes;

public class Queen extends Ant{
    private boolean mood = true;

    @Override
    public void move() {
    }

    public boolean getMood(){
        return this.mood;
    }

    public void changeMood(){
        this.mood = !this.mood;
    }
}
