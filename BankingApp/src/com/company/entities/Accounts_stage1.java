package com.company.entities;

import java.util.Scanner;

//o clasa mai de sine statatoare pentru main, cu metode in ea, urmeaza de impartit in entities si service

public class Accounts_stage1 {
    private int sold;
    private int tranzactiePreced;
    private String numeClient;
    private String idClient;

    public Accounts_stage1(String cname, String cid) {
        numeClient = cname;
        idClient = cid;
    }

    //e publica pentru ca o folosesc in main la alimentare initiala
    public void depoziteaza(int suma) {
        if (suma != 0) {
            sold = sold + suma;
            tranzactiePreced = suma;
        }
    }

    void retrage(int suma) {
        if (suma != 0) {
            sold = sold - suma;
            tranzactiePreced = -suma;
        }
    }

    void gettranzactiePreced() {
        if (tranzactiePreced > 0) {
            System.out.println("Tranzactia precedenta, s-a depozitat: " + tranzactiePreced);
        } else if (tranzactiePreced < 0) {
            System.out.println("Tranzactia precedenta, s-a retras: " + Math.abs(tranzactiePreced));
        } else {
            System.out.println("Nu s-a efectuat tranzactie anterior");
        }
    }

    void calculeazaDobanda(int ani) {
        double rataDobanda = 0.055;
        double nouSold = (sold * rataDobanda * ani) + sold;
        System.out.println("Dobanda curenta este: " + (100 * rataDobanda) + "%");
        System.out.println("Dupa " + ani + " ani, soldul va fi: " + nouSold);
    }

    public void arataMeniu() {
        char optiune;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bun venit, " + numeClient + "!");
        System.out.println("ID-ul dvs este: " + idClient);
        System.out.println();
        System.out.println("Ce ati dori sa faceti?");
        System.out.println();
        System.out.println("1. Verificati sold");
        System.out.println("2. Efectuati o depunere");
        System.out.println("3. Efectuati o retragere");
        System.out.println("4. Vedeti tranzactie anterioara");
        System.out.println("5. Calculati dobanda");
        System.out.println("6. Iesire");

        do {
            System.out.println();
            System.out.println("Alege o optiune: ");
            char optiune1 = scanner.next().charAt(0);
            optiune = Character.toUpperCase(optiune1);
            System.out.println();

            switch(optiune) {
                //Case '1' se verifica soldul
                case '1':
                    System.out.println("====================================");
                    System.out.println("Soldul = " + sold);
                    System.out.println("====================================");
                    System.out.println();
                    break;
                //'2', se depoziteaza bani
                case '2':
                    System.out.println("Alegeti suma de depus: ");
                    int suma = scanner.nextInt();
                    depoziteaza(suma);
                    System.out.println();
                    break;
                //'3', se retrag bani de catre client
                case '3':
                    System.out.println("Alegeti suma de retras: ");
                    int suma2 = scanner.nextInt();
                    retrage(suma2);
                    System.out.println();
                    break;
                //'4', clientul poate vedea cea mai recenta tranzactie
                case '4':
                    System.out.println("====================================");
                    gettranzactiePreced();
                    System.out.println("====================================");
                    System.out.println();
                    break;
                // '5', se calculeaza dobanda
                case '5':
                    System.out.println("Dupa cati ani se va calcula dobanda: ");
                    int ani = scanner.nextInt();
                    calculeazaDobanda(ani);
                    break;
                // '6', utilizatorul iese din aplicatie
                case '6':
                    System.out.println("====================================");
                    break;
                //Caz in care nicio optiune nu a fost valida
                default:
                    System.out.println("Eroare. Optiune invalida..Alegeti intre 1, 2, 3, 4, 5.");
                    break;
            }
        } while(optiune != '6');
        System.out.println("Va multumim pentru alegerea facuta!");
    }

}
