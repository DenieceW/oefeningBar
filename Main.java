package com.miniopdrachtenqien;

public class Main {

    public static void main(String[] args) {
        Drank bier = new Drank("bier", 2.10, 5);
        Drank wijn = new Drank("wijn", 4.25, 7);
        Drank cola = new Drank("cola", 1.10, 0);

        Voorraad voorraad = new Voorraad();
        for (int i = 0; i < 12; i++) {
            voorraad.voegDrankjestoe(bier);
            voorraad.voegDrankjestoe(wijn);
            voorraad.voegDrankjestoe(cola);
        }

    }
}
