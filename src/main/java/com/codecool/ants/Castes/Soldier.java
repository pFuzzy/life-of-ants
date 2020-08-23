package com.codecool.ants.Castes;

import com.codecool.ants.Colony;
import com.codecool.ants.geometry.Direction;
import com.codecool.ants.geometry.Position;

public class Soldier extends Ant{

    @Override
    public void move() {
        switch (this.getDirection()) {
            case NORTH:
                if(this.getPosition().getX() > 0){
                    this.setPosition(new Position(this.getPosition().getX() - 1, this.getPosition().getY()));
                }
                this.setDirection(Direction.WEST);
                break;
            case EAST:
                if(this.getPosition().getY() < Colony.WIDTH - 1){
                    this.setPosition(new Position(this.getPosition().getX(), this.getPosition().getY() + 1));
                }
                this.setDirection(Direction.NORTH);
                break;
            case SOUTH:
                if(this.getPosition().getX() < Colony.WIDTH - 1){
                    this.setPosition(new Position(this.getPosition().getX() + 1, this.getPosition().getY()));
                }
                this.setDirection(Direction.EAST);
                break;
            case WEST:
                if(this.getPosition().getY() > 0){
                    this.setPosition(new Position(this.getPosition().getX(), this.getPosition().getY() - 1));
                }
                this.setDirection(Direction.SOUTH);
                break;
        }
    }
}
