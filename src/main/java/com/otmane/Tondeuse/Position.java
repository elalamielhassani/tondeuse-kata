package com.otmane.Tondeuse;

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
        return x>=0 && y>=0;
    }

    public void bougerEnHaut() {
        y++;
    }

    public void bougerADroite() {
        x++;
    }

    public void bougerEnBas() {
        y--;
    }

    public void bougerAGauche() {
        x--;
    }
}
