package com.otmane.Tondeuse.entities;

import com.otmane.Tondeuse.enums.Commande;
import com.otmane.Tondeuse.enums.Direction;

import java.util.ArrayDeque;
import java.util.Queue;

public class Tondeuse {

    private Position position;
    private Position coinSuperieur;
    private Direction direction;
    private int id;
    private Queue<Commande> commandes = new ArrayDeque<>();

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

    public void setId(int id) {
        this.id = id;
    }

    public Queue<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(Queue<Commande> commandes) {
        this.commandes = commandes;
    }

    public void setCoinSuperieur(Position coinSuperieur) {
        this.coinSuperieur = coinSuperieur;
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

    public boolean isInitialConfValid() {
        return isPositionValid(this.coinSuperieur) && this.isDirectionValid();
    }

    public void start(){
            commandes.forEach(this::apply);

    }

    public void apply(Commande commande) {
        switch (commande){
            case D -> setDirection(this.direction.tournerDroite());
            case G -> setDirection(this.direction.tournerGauche());
            case A -> mouve();
        }
    }

    private void mouve() {
        switch (this.direction){
            case N -> this.position.bougerEnHaut(coinSuperieur.getY());
            case E -> this.position.bougerADroite(coinSuperieur.getX());
            case S -> this.position.bougerEnBas();
            case W -> this.position.bougerAGauche();
        }
    }
}
