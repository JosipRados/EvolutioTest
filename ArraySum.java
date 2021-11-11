package com.company;

public class ArraySum {
    static int minNumberOfCombinations = -1;

    //**********************REKURZIVNA METODA ZA PRONALAZENJE SVIH KOMBINACIJA******************************************
    static void allSubsets(int[] arr, int n, String str) {

        if(n == 0) {
            //u slucaju da je trenutni broj kombinacije manji od zadnje zapisanoga, stari se prepisuje s novime
            //u slucaju da se nikada ne nade kombinacija broj ostaje -1 kao sto je zadano u zadatku
            if((minNumberOfCombinations > countNumbers(str)) || (minNumberOfCombinations == -1)){
                minNumberOfCombinations = countNumbers(str);
            }
            return;
        }
        for(int i = 0; i<arr.length;i++) {
            if(n >= arr[i]) {
                allSubsets(arr, n-arr[i], str + arr[i] + " ");
            }
        }
    }
    //************************GETER METODA ZA VARIJABLU MINIMALNOG BROJA KOMBINACIJA************************************
    static int getMinNumberOfCombinations(){
        return minNumberOfCombinations;
    }

    //************************POMOCNA METODA ZA PROVJERU KOLICINE BROJEVA U KOMBINACIJI*********************************
    static int countNumbers(String str){
        String[] num = str.split(" ");
        return num.length;
    }
}
