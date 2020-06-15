package com.miniopdrachtenqien;


import java.util.Scanner;

public class UI {
    Scanner scanner = new Scanner(System.in);




    void printMenu(){
        System.out.println("Welkom bij BarBieries!");
        System.out.println("**********************");
        System.out.println("Je kunt een keuze maken uit onderstaande drankjes!");
        System.out.println("Wijn: kost 4,25 euro");
        System.out.println("Bier: kost 2,10 euro");
        System.out.println("Fris: kost 1,10 euro");
        System.out.println("Pas op dat je niet teveel alcoholische drankjes drinkt!");
    }
}
