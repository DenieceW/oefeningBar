package com.miniopdrachtenqien;


import java.util.Scanner;

public class UI {
    Scanner scanner = new Scanner(System.in);
    Drank bier = new Drank("bier",2.10,5);
    Drank wijn = new Drank("wijn",4.25,7);
    Drank fris = new Drank("fris",1.10,2);
    Voorraad voorraad = new Voorraad();
    Klant klant = new Klant();
    int aantalBierGedronken = 0;
    int aantalWijnGedronken = 0;


    void letsDrank(){
        printMenu();
        while (true) {
            System.out.println("Maak een keuze uit een bier, wijn of fris:-)");
            String invoer = scanner.nextLine().toLowerCase();
            if (invoer.equals("stop")) {
                System.out.println("Bedankt voor de gezelligheid en bijdrage aan onze omzet! Hopelijk tot snel :-)");
                break;
            }
            if(klant.dronkenschap >= 25 && klant.dronkenschap <= 35){
                System.out.println("Misschien tijd voor een frisje? Jouw wangetjes worden erg rood ;-)");
            }
            if(klant.dronkenschap >= 50){
                System.out.println("Je hebt " + aantalBierGedronken + " PARBO biertjes en " + aantalWijnGedronken + " wijn gedronken. Mogelijk" +
                        " heb je een probleem..." +
                        "Ik denk dat je teveel hebt gedronken en schenk niks meer in.\nTijd om naar huis te gaan en de roes uit te slapen!");
                break;
            }

            if(klant.geld <= 0){
                System.out.println("Je geld is op en ik run geen goede doelen instelling. Kom maar terug wanneer je meer te spenderen hebt!");
                break;
            }
            bestellingDoen(invoer);
            printVoorraad();
        }
    }

    void printMenu(){
        System.out.println("Welkom bij Bar Bieries! Hoe kunnen we jou noemen?");
        klant.naam =  scanner.nextLine();
        System.out.println("Hoeveel geld heb je op zak? We moeten denken aan onze omzet ;-)");
        klant.geld = Integer.parseInt(scanner.nextLine());
        System.out.println("**********************");
        System.out.println("Je kunt een keuze maken uit onderstaande drankjes!");
        System.out.println("Wijn: kost 4,25 euro, alcoholwaarde: 7");
        System.out.println("Parbo bier: kost 2,10 euro, alcoholwaarde: 5");
        System.out.println("Fris: kost 1,10 euro, alcoholwaarde: -1");
        System.out.println("Wil je naar huis? Type dan 'stop'. ");
        System.out.println("Pas op dat je niet teveel alcoholische drankjes drinkt want dan schenken we niks meer in en kun je naar huis!");
    }

    void printVoorraad(){
        System.out.println("Voorraad: ");
        System.out.println("Bier: " + voorraad.getAantalBier());
        System.out.println("Wijn: " + voorraad.getAantalWijn());
        System.out.println("Fris: " + voorraad.getAantalFris());
    }

    void bestellingDoen(String invoer){
          if (invoer.equals("parbo bier") || invoer.equals("bier")) {
            if (voorraad.getAantalBier() > 0 && klant.geld > bier.prijs) {
                System.out.println("Hoeveel Parbo biertjes?");
                aantalBierGedronken = Integer.parseInt(scanner.nextLine());
                voorraad.aantalBier-= aantalBierGedronken; //voorraad neemt af
                klant.geld -= (bier.prijs * aantalBierGedronken);
                klant.dronkenschap += (bier.dronkenschap * aantalBierGedronken);
            } else if (voorraad.getAantalBier() <= 0) {
                System.out.println("Sorry, het Parbo bier is op!");
            } else if (klant.geld < bier.prijs) {
                System.out.println("Je hebt niet genoeg geld:-(");
            }
            System.out.println(klant);
        }

         if (invoer.equals("wijn")) {
            if (voorraad.getAantalWijn() > 0 && klant.geld > wijn.prijs) {
                System.out.println("Hoeveel wijntjes?");
                aantalWijnGedronken = Integer.parseInt(scanner.nextLine());
                voorraad.aantalWijn -= aantalWijnGedronken; //voorraad neemt af
                klant.geld -= (wijn.prijs * aantalWijnGedronken);
                klant.dronkenschap += (wijn.dronkenschap * aantalWijnGedronken);
            } else if (voorraad.getAantalWijn() <= 0) {
                System.out.println("Sorry, helaas is de wijn op!");
            } else if (klant.geld < wijn.prijs) {
                System.out.println("Je hebt niet genoeg geld:-(");
            }
            System.out.println(klant);
        }

         if (invoer.equals("fris")) {
            if(voorraad.getAantalFris() > 0 && klant.geld > fris.prijs){
                System.out.println("Hoeveel fris?");
                int aantalFris = Integer.parseInt(scanner.nextLine());
                voorraad.aantalFris -= aantalFris; //voorraad neemt af
                klant.geld -= (fris.prijs * aantalFris);
                klant.dronkenschap -= (fris.dronkenschap * aantalFris);
            } else if (voorraad.getAantalFris() <= 0) {
                System.out.println("Sorry, helaas is de fris op!");
            } else if (klant.geld < fris.prijs) {
                System.out.println("Je hebt niet genoeg geld:-(");
            }
            System.out.println(klant);
        }

    }

}
