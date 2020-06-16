package com.miniopdrachtenqien;


import java.util.Scanner;

public class UI {
    Scanner scanner = new Scanner(System.in);
    Drank bier = new Drank("bier",2.10,5);
    Drank wijn = new Drank("wijn",4.25,7);
    Drank fris = new Drank("fris",1.10,-1);
    Voorraad voorraad = new Voorraad();
    Klant klant = new Klant();
    boolean alcoholON = true;

    void letsDrank(){
        printMenu();
        while (alcoholON){
            System.out.println("Maak een keuze uit een bier, wijn of fris:-)");
            String invoer = scanner.nextLine().toLowerCase();
              if (invoer.equals("stop")){
                alcoholON = false;
            }else bestellingDoen(invoer);
            System.out.println(klant);
        }
    }

    void printMenu(){
        System.out.println("Welkom bij Bar Bieries! Hoe kunnen we jou noemen?");
        klant.naam =  scanner.nextLine();
        System.out.println("Hoeveel geld heb je op zak? We moeten denken aan onze omzet ;-)");
        klant.geld = Integer.parseInt(scanner.nextLine());
        System.out.println("**********************");
        System.out.println("Je kunt een keuze maken uit onderstaande drankjes!");
        System.out.println("Wijn: kost 4,25 euro");
        System.out.println("Bier: kost 2,10 euro");
        System.out.println("Fris: kost 1,10 euro");
        System.out.println("Pas op dat je niet teveel alcoholische drankjes drinkt!");
    }

    void bestellingDoen(String invoer){
        if(invoer.equals("bier")){
            if(voorraad.getAantalBier()<= 0){
                System.out.println("Sorry, het bier is op!");
            }else if(klant.geld < bier.prijs){
                System.out.println("Je hebt niet genoeg geld:-(");
            }else
            System.out.println("Hoeveel biertjes?");
            int aantalBiertjes = Integer.parseInt(scanner.nextLine());
            voorraad.aantalBier-= aantalBiertjes; //voorraad neemt af
            klant.geld-=bier.prijs;
            klant.dronkenschap+=bier.dronkenschap;
            System.out.println(voorraad.getAantalBier());

        }
        if(invoer.equals("wijn")){
            if(voorraad.getAantalWijn() <= 0){
                System.out.println("Sorry, helaas is de wijn op!");
            } else if(klant.geld < wijn.prijs){
                    System.out.println("Je hebt niet genoeg geld:-(");
            }else
            System.out.println("Hoeveel wijntjes?");
            int aantalWijntjes = Integer.parseInt(scanner.nextLine());
            voorraad.aantalWijn-= aantalWijntjes; //voorraad neemt af
            klant.geld-=wijn.prijs;
            klant.dronkenschap+=wijn.dronkenschap;
            System.out.println(voorraad.getAantalWijn());

        }
        if(invoer.equals("fris")){
            if(voorraad.getAantalFris() <= 0){
                System.out.println("Sorry, helaas is de fris op!");
            } else if(klant.geld < fris.prijs){
                System.out.println("Je hebt niet genoeg geld:-(");
            }else
            System.out.println("Hoeveel fris?");
            int aantalFris = Integer.parseInt(scanner.nextLine());
            voorraad.aantalFris-= aantalFris; //voorraad neemt af
            klant.geld-=fris.prijs;
            klant.dronkenschap-=fris.dronkenschap;
            System.out.println(voorraad.getAantalFris());
        }
    }
}
