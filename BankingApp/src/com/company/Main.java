package com.company;
import com.company.entities.*;

public class Main {

    public static void main(String[] args) {
        //cream  obiecte
        Conturi ionpope = new Conturi("Ion Popescu ", "A00001");
        Conturi iriione = new Conturi("Irina Ionescu", "B00002");
        Conturi davste = new Conturi("David Stefanescu ", "A00003");
        Conturi adidum = new Conturi("Adina Dumitrescu", "B00004");
        Conturi gabmal = new Conturi("Gabriel Malaimare ", "A00005");
        Conturi marper = new Conturi("Maria Pericica", "B00006");
        Conturi adrcot = new Conturi("Adrian Cotnarean ", "A00007");
        Conturi erdene = new Conturi("Erdina Ene", "B00008");

        //presupunem ca au avut ceva bani depozitati la deschiderea de cont
        ionpope.depoziteaza(1000);
        iriione.depoziteaza(20000);
        davste.depoziteaza(3000);
        adidum.depoziteaza(40000);
        gabmal.depoziteaza(5000);
        marper.depoziteaza(60000);
        adrcot.depoziteaza(7000);
        erdene.depoziteaza(80000);
        erdene.depoziteaza(9000);
        marper.depoziteaza(100000);

        //apoi putem alege diferite meniuri pentru Irina Ionescu de exemplu
        iriione.arataMeniu();

    }
}
