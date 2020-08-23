package com.codecool.ants;

import com.codecool.ants.Castes.*;
import com.codecool.ants.geometry.Position;

import java.util.ArrayList;
import java.util.Random;


public class Colony {
    public static int WIDTH;
    private final Ant[][] colony;
    private ArrayList<Drone> drones;
    private ArrayList<Worker> workers;
    private ArrayList<Soldier> soldiers;


    public Colony(int width) {
        WIDTH = width;
        colony = new Ant[width][width];
        colony[(int) Math.floor(WIDTH / 2)][(int) Math.floor(WIDTH / 2)] = new Queen();
    }

    public void generateAnts(int drones, int workers, int soldiers) {
        if((drones + workers + soldiers) > WIDTH*WIDTH-1){
            throw new IllegalArgumentException("Number of ants cannot exceed size of hive");
        }
        this.drones = new ArrayList<>();
        this.soldiers = new ArrayList<>();
        this.workers = new ArrayList<>();
        for (int i = 0; i < drones; i++) {
            this.drones.add(new Drone());
        }
        for (int i = 0; i < workers; i++) {
            this.workers.add(new Worker());
        }
        for (int i = 0; i < soldiers; i++) {
            this.soldiers.add(new Soldier());
        }
    }

    public void getAntStartingPosition(){
        for (Drone drone: drones) {
            int[] position = getRandomPosition();
            drone.setPosition(new Position(position[0], position[1]));
            colony[drone.getPosition().getX()][drone.getPosition().getY()] = drone;
        }
        for (Worker worker: workers) {
            int[] position = getRandomPosition();
            worker.setPosition(new Position(position[0], position[1]));
            colony[worker.getPosition().getX()][worker.getPosition().getY()] = worker;
        }
        for (Soldier soldier: soldiers) {
            int[] position = getRandomPosition();
            soldier.setPosition(new Position(position[0], position[1]));
            colony[soldier.getPosition().getX()][soldier.getPosition().getY()] = soldier;
        }

    }

    public void displayColony() {
        for (Ant[] row : colony) {
            for (Ant ant : row) {
                if (ant == null) {
                    System.out.print(" . ");
                } else if (ant.getClass() == Queen.class) {
                    System.out.print(" Q ");
                } else if (ant.getClass() == Drone.class) {
                    System.out.print(" D ");
                } else if (ant.getClass() == Soldier.class) {
                    System.out.print(" S ");
                } else if (ant.getClass() == Worker.class) {
                    System.out.print(" W ");
                }
            }
            System.out.println("\n");
        }
    }

    public void update() {
        for (Drone drone:drones) {
            drone.move();
        }
        for (Worker worker:workers) {
            moveAnt(worker);
        }
        for (Soldier soldier:soldiers) {
            moveAnt(soldier);
        }


    }

    public int[] getRandomPosition(){
        Random random = new Random();
        int x = random.nextInt(WIDTH);
        int y = random.nextInt(WIDTH);
        while(colony[x][y] != null){
            x = random.nextInt(WIDTH);
            y = random.nextInt(WIDTH);
        }
        return new int[]{x,y};
    }

    public void moveAnt(Ant ant){
        int positionX;
        int positionY;
        positionX = ant.getPosition().getX();
        positionY = ant.getPosition().getY();
        colony[positionX][positionY] = null;
        ant.move();
        positionX = ant.getPosition().getX();
        positionY = ant.getPosition().getY();
        if(colony[positionX][positionY] == null){
            colony[positionX][positionY] = ant;
        }
    }
}
