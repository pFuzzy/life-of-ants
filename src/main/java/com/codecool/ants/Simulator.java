package com.codecool.ants;

import java.io.IOException;
import java.util.Scanner;


public class Simulator {

    public static void main(String[] args) throws IOException {
        Colony colony = new Colony(9);
        colony.generateAnts(2,2,2);
        colony.getAntStartingPosition();
        colony.displayColony();
        boolean isRunning = true;
        Scanner input = new Scanner(System.in);
        while(isRunning){
            switch (input.nextLine()){
                case "q":
                    isRunning = false;
                    break;
                case "":
                    colony.update();
                    colony.displayColony();
                    break;
                default:
                    break;
            }
        }
    }
}
