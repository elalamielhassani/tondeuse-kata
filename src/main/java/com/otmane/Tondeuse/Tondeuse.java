package com.otmane.Tondeuse;

public class Tondeuse {

    private Position position;
    private Direction direction;
    private String id;

    public void setPosition(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public boolean isPositionValid(Position coinSupieur) {
        return this.getPosition().isValid() &&
                coinSupieur.isValid() &&
                this.getPosition().getX() <= coinSupieur.getX() &&
                this.getPosition().getY() <= coinSupieur.getY();
    }

    public boolean isDirectionValid() {
        return direction != null;
    }

    public boolean isInitialConfValid(Position coinSupieur) {
        return isPositionValid(coinSupieur) && this.isDirectionValid();
    }


}
