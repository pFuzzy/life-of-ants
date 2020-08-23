package com.codecool.ants.Castes;

import com.codecool.ants.Colony;
import com.codecool.ants.geometry.Direction;
import com.codecool.ants.geometry.Position;

import java.util.Random;

public class Worker extends Ant {


    @Override
    public void move() {
        this.setDirection(getRandomDirection());
        switch (this.getDirection()) {
            case NORTH:
                if(this.getPosition().getX() > 0){
                    this.setPosition(new Position(this.getPosition().getX() - 1, this.getPosition().getY()));
                }
                break;
            case EAST:
                if(this.getPosition().getY() < Colony.WIDTH - 1){
                    this.setPosition(new Position(this.getPosition().getX(), this.getPosition().getY() + 1));
                }
                break;
            case SOUTH:
                if(this.getPosition().getX() < Colony.WIDTH - 1){
                    this.setPosition(new Position(this.getPosition().getX() + 1, this.getPosition().getY()));
                }
                break;
            case WEST:
                if(this.getPosition().getY() > 0){
                    this.setPosition(new Position(this.getPosition().getX(), this.getPosition().getY() - 1));
                }
                break;
        }
    }

    public Direction getRandomDirection() {
        Direction direction;
        Random random = new Random();
        int x = random.nextInt(4);
        switch (x) {
            case 0:
                direction = Direction.NORTH;
                break;
            case 1:
                direction = Direction.EAST;
                break;
            case 2:
                direction = Direction.SOUTH;
                break;
            case 3:
                direction = Direction.WEST;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + x);
        }
        return direction;
    }


}
