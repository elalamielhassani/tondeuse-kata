package com.otmane.Tondeuse;

import com.otmane.Tondeuse.enums.Commande;
import com.otmane.Tondeuse.enums.Direction;

import java.util.ArrayDeque;
import java.util.Queue;

public class Tondeuse {

    private Position position;
    private Direction direction;
    private String id;
    private Queue<String> commandes = new ArrayDeque<>();

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

    public Queue<String> getCommandes() {
        return commandes;
    }

    public void setCommandes(Queue<String> commandes) {
        this.commandes = commandes;
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


    public void apply(Commande commande) {
        switch (commande){
            case D -> setDirection(this.direction.tournerDroite());
            case G -> setDirection(this.direction.tournerGauche());
            case A ->{
                switch (this.direction){
                    case N -> this.position.bougerEnHaut();
                    case E -> this.position.bougerADroite();
                    case S -> this.position.bougerEnBas();
                    case W -> this.position.bougerAGauche();
                }
            }
        }
    }
}
