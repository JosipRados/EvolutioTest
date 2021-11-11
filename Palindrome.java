package com.company;
import java.lang.StringBuffer.*;
import java.lang.String;

public class Palindrome {
    private String str;

    public Palindrome() {
    }

    public Palindrome(String str) {
        this.str = str;
    }

    void palindromeOnThreeWays(){
        //PRVI NACIN testiranja palindroma je preko vec postojecih metoda i objekata unutar Jave
        if(palFirstWay()){
            System.out.println("FIRST WAY RESULT: String is a palindrome.");
        }
        else{
            System.out.println("FIRST WAY RESULT: String is not a palindrome.");
        }

        //DRUGI NACIN je preko petlje i uspoređivanja prednjih  s stražnjim clanovima
        if(palSecondWay()){
            System.out.println("SECOND WAY RESULT: String is a palindrome.");
        }
        else{
            System.out.println("SECOND WAY RESULT: String is not a palindrome.");
        }

        //TRECI NACIN je preko rekurzije
        if(palThirdWay()){
            System.out.println("THIRD WAY RESULT: String is a palindrome.\n");
        }
        else{
            System.out.println("THIRD WAY RESULT: String is not a palindrome.\n");
        }
    }

    //*****************************PRVI NACIN PROVJERE PALINDROMA*******************************************************
    //Koristeci strBuffer klasu s metodama reverse() i equals() uspoređujem pocetni i obrnuti string te vracam bool
    boolean palFirstWay(){
        String strOnlyAlpha = onlyAlpha(this.str);
        StringBuffer strBuffer = new StringBuffer(strOnlyAlpha);
        return strBuffer.reverse().toString().equals(strOnlyAlpha);
    }

    //*****************************DRUGI NACIN PROVJERE PALINDROMA******************************************************
    //Uspoređivanje prvog i zadnjeg znaka, tj drugog i prezadnjeg itd. , u slucaju da je neparan broj slova
    //na srednjem slovu vraca true, a u slucaju da je paran broj slova kada i postane veci od brojaca unazad
    // vraca true, te u slucaju da prije toga dode do razlicitog znaka u provjeri vraca false
    boolean palSecondWay(){
        String strOnlyAlpha = onlyAlpha(this.str);
        for(int i = 0; i < strOnlyAlpha.length(); i++){
            if( (i >= strOnlyAlpha.length()-1-i) ){
                return true;
            }
            if( strOnlyAlpha.charAt(i) != strOnlyAlpha.charAt(strOnlyAlpha.length()-1-i)){
                return false;
            }
        }
        return true;//Iako se nece nikada izvrsiti zahtjevalo mi je pristutnost returna van for petlje
    }
    //*****************************TRECI NACIN PROVJERE PALINDROMA******************************************************
    //Metoda koja uz pomoc pomocne metode onlyAlpha mice znakove i razmake koji nisu slova te vraca rezultat
    //rekurzivne provjere stringa
    boolean palThirdWay(){
        String strOnlyAlpha = onlyAlpha(this.str);
        return polRecursion(strOnlyAlpha,0, strOnlyAlpha.length() - 1);
    }

    //*****************************POMOCNA METODA ZA REKURZIVNU PROVJERU************************************************
    //metoda u slucaju da se ne nalazimo na sredini stringa provjerava jednakost prvog i zadnjeg elementa
    //u slucaju da su jednaki ponovno pozivamo metodu te joj saljemo index drugog i prezadnjeg elementa
    //u slucaju da naleti da neka dva znaka nisu jednaka vraca false kroz rekurzuju i string nije palindrom
    boolean polRecursion(String str, int start, int end){
        if(start >= end){
            return true;
        }
        if(str.charAt(start) == str.charAt(end)) {
            return polRecursion(str, start + 1, end - 1);
        }
        return false;
    }

    //****************POMOCNA METODA ZA MICANJE SVIH ZNAKOVA KOJI NISU SLOVA(UKLJUCUJUC RAZMAKE)************************
    //Radio sam provjeru za svaki znak s isLetter() metodom te u slucaju da je slovo punio u novi string
    //koji sam kasnije vratio kao mala slova
    String onlyAlpha(String str){
        String strOnlyAlpha = "";

        for(int i = 0; i < str.length(); i++){
            if(Character.isLetter(str.charAt(i))){
                strOnlyAlpha += str.charAt(i);
            }
        }
        return strOnlyAlpha.toLowerCase();
    }
}
