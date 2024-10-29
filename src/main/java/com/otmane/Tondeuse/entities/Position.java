package com.otmane.Tondeuse.entities;

public class Position {
    private int x;
    private int y;

    public void setX(int x) {

        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public boolean isValid() {
        return x >= 0 && y >= 0;
    }

    public void bougerEnHaut(int yMax) {
        if (this.y < yMax) {
            y++;
        }
    }

    public void bougerADroite(int xMax) {
        if (this.x < xMax) {
            x++;
        }
    }

    public void bougerEnBas() {
        if (this.y > 0) {
            y--;
        }
    }

    public void bougerAGauche() {
        if (this.x > 0) {
            x--;
        }
    }
}
