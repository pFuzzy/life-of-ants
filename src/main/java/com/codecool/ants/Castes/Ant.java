package com.codecool.ants.Castes;

import com.codecool.ants.geometry.Direction;
import com.codecool.ants.geometry.Position;

public abstract class Ant {
    private Position position;
    private Direction direction = Direction.NORTH;

    public abstract void move();

    public Direction getDirection() {
        return direction;
    }

    public Position getPosition(){
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
