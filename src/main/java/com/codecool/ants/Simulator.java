package com.codecool.ants;

import java.util.Scanner;

public class Simulator {

    public static void main(String[] args) {
        Colony colony = new Colony(9);
        colony.generateAnts(2,2,2);
        colony.placeAnts();
        colony.displayColony();
        boolean isRunning = true;
        Scanner input = new Scanner(System.in);
        while(isRunning){
            if(input.nextLine().equals("q")){
                isRunning = false;
            }else if (input.nextLine().equals("")){
                colony.update();
                colony.displayColony();
            }
        }
    }

}
