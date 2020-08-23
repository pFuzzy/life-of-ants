package com.codecool.ants;

import com.codecool.ants.Castes.*;
import com.codecool.ants.geometry.Position;

import java.util.ArrayList;
import java.util.Random;


public class Colony {
    private final int width;
    private final Ant[][] colony;
    private ArrayList<Drone> drones;
    private ArrayList<Worker> workers;
    private ArrayList<Soldier> soldiers;


    public Colony(int width) {
        this.width = width;
        colony = new Ant[width][width];
        colony[(int) Math.floor(width / 2)][(int) Math.floor(width / 2)] = new Queen();
    }

    public void generateAnts(int drones, int workers, int soldiers) {
        if((drones + workers + soldiers) > width*width-1){
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

    public void placeAnts(){
        for (Drone drone: drones) {
            int[] position = getRandomPosition();
            drone.setPosition(new Position(position[0], position[1]));
            colony[position[0]][position[1]] = drone;
        }
        for (Worker worker: workers) {
            int[] position = getRandomPosition();
            worker.setPosition(new Position(position[0], position[1]));
            colony[position[0]][position[1]] = worker;
        }
        for (Soldier soldier: soldiers) {
            int[] position = getRandomPosition();
            soldier.setPosition(new Position(position[0], position[1]));
            colony[position[0]][position[1]] = soldier;
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

    }

    public int[] getRandomPosition(){
        Random random = new Random();
        int x = random.nextInt(width);
        int y = random.nextInt(width);
        while(colony[x][y] != null){
            x = random.nextInt(width);
            y = random.nextInt(width);
        }
        return new int[]{x,y};
    }
}
