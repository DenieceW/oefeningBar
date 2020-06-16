package com.miniopdrachtenqien;

public class Klant {
    int dronkenschap;
    int geld;
    String naam;

    Klant(int money,String naam){
        this.dronkenschap = 0;
        this.geld = money;
        this.naam = naam;
    }

    Klant(){

    }

    int getGeld(){
        return this.geld;
    }

    int getDronkenschap(){
        return this.dronkenschap;
    }

    public String toString(){
        return this.naam + " heeft momenteel " + this.geld + " euros op zak. het alcoholniveau is op " + this.dronkenschap;
    }

}
