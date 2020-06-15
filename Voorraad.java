package com.miniopdrachtenqien;

import java.util.ArrayList;

public class Voorraad {
    ArrayList<Drank> voorraad;
    int totaalVoorraad;
    int aantalFris;
    int aantalWijn;
    int aantalBier;

    Voorraad(){
        this.voorraad = new ArrayList<Drank>();
    }
    void voegDrankjestoe(Drank drank){
        voorraad.add(drank);
        this.totaalVoorraad++;

        if(drank.naamDrank.equals("fris")){
            aantalFris++;
        }
        if(drank.naamDrank.equals("wijn")){
            aantalWijn++;
        }
        if(drank.naamDrank.equals("bier")){
            aantalBier++;
        }
    }

    void afnameDrankjes(String naamDrank){
        for (Drank drank:voorraad){
            if (drank.naamDrank.equals(naamDrank)){
                voorraad.remove(drank);
            }
        }
    }

    void showDrankjes(){
        for(Drank drank : voorraad){
            System.out.println(drank);
        }
    }

    int getAantalFris(){
        return aantalFris;

    }
    int getAantalWijn(){
        return aantalWijn;

    }
    int getAantalBier (){
        return aantalBier;
    }

    void printTotaleVoorraad(){
        System.out.println("Totaal aantal flessen drank: " + this.totaalVoorraad);
    }

    int getTotaalVoorraad(){
        return this.totaalVoorraad;
    }

}
