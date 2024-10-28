package com.otmane.Tondeuse.enums;

public enum Direction {
    N,S,W,E;

    public Direction tournerDroite() {
        return switch (this) {
            case N -> E;
            case E -> S;
            case S -> W;
            case W -> N;
        };
    }

    public Direction tournerGauche() {
        return switch (this) {
            case N -> W;
            case W -> S;
            case S -> E;
            case E -> N;
        };
    }

}
