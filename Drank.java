package com.miniopdrachtenqien;

public class Drank {
    String naamDrank;
    int dronkenschap;
    double prijs;


    Drank(String naam, double prijs, int dronkenschap){
        this.naamDrank = naam;
        this.prijs = prijs;
        this.dronkenschap = dronkenschap;
    }
    Drank(){

    }

    double getPrijs(){
        return this.prijs;
    }
    String getNaamDrank(){
        return this.naamDrank;
    }

    @Override
    public String toString() {
        return "Deze " + this.naamDrank + " kost " + this.prijs + " euro's";
    }
}
