package com.company;
import java.lang.StringBuffer.*;
import java.lang.String;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;


public class Main {

    public static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        //DEKLARACIJA VARIJABLI I OBJEKATA
        boolean runVariable = true; //runVariable koristim za provjeru u meniu izbora zadatka da li se program završava ili nastavlja
        int choiceVariable; //choiceVariable koristim za izbor zadatka ili izlaz iz menia, tj. programa
        int[] arr = {3,5,7,8,10};
        int n = 25;
        String str;

        //MENU
        do{
            try { // u slucaju unosa stringa
                System.out.println("Choose one of three tests:\n1--Rock, Paper, Scissors\n2--Palindrome\n3--Arrays\n4--Exit");
                choiceVariable = scan.nextInt();

                //IZBOR ZADATKA
                switch (choiceVariable) {
                    case 1:
                        //ROCK PAPER SCISSORS
                        RockPaperScissors.play();
                        break;
                    case 2:
                        //PALINDROME CHECK
                        System.out.println("Unesite recenicu za provjeru palindroma:\n");
                        scan.nextLine(); //s obzirom da sam prije toga koristio nextInt() u bufferu ostaje \n te ga praznim s ovom linijom koda
                        str = scan.nextLine();
                        Palindrome pal = new Palindrome(str);
                        pal.palindromeOnThreeWays();
                        break;
                    case 3:
                        //ARRAY TEST
                        System.out.println("Array: " + Arrays.toString(arr) + "  Number: " + n + "\nMinimum number of combinations: ");
                        ArraySum.allSubsets(arr, n, ""); //poziv metode koja ce naci minimalni broj kombinacija i zapisati u staticnu variajblu
                        System.out.println(ArraySum.getMinNumberOfCombinations()); //dohvacanje staticne varijable iz klase
                        break;
                    case 4:
                        //EXIT
                        runVariable = false;
                        break;
                    default:
                        //KRIVI BROJ
                        System.out.println("Wrong Number entered, please try again!");
                }
            }
            catch(Exception e){
                System.out.println("Wrong input. Try again!");
                scan.nextLine();
            }
        }while(runVariable);

        scan.close();

    }
}

