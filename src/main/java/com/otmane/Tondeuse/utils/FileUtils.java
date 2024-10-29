package com.otmane.Tondeuse.utils;

import com.otmane.Tondeuse.entities.Position;
import com.otmane.Tondeuse.enums.Commande;
import com.otmane.Tondeuse.enums.Direction;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.stream.Collectors;

public class FileUtils {


    public static ArrayDeque<Commande> getCommandes(String lines) {
        return Arrays.stream(lines.split("")).map(Commande::valueOf).collect(Collectors.toCollection(ArrayDeque::new));
    }

    public static Position getPosition(String line1) {
        String[] input1 = line1.split(" ");
        Position position = new Position();
        int x = Integer.parseInt(input1[0]);
        int y = Integer.parseInt(input1[1]);
        position.setX(x);
        position.setY(y);
        return position;
    }

    public static Direction getDirection(String line1) {
        String directionString = line1.split(" ")[2];
        return Direction.valueOf(directionString);
    }

}
