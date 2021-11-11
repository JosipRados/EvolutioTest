package com.company;
import java.util.Random;

public class RockPaperScissors {
    private static int playerWins = 0, computerWins = 0, playerId, computerId;
    static String[] RPS = {
            "ROCK",
            "PAPER",
            "SCISSORS"
    };

    public RockPaperScissors() {
    }

    //********************METODA ZA POKRETANJE RockPaperScissors IGRE***************************************************
    static void play(){
        Random rand = new Random();
        System.out.println("This is game of \"Rock Paper Scissors\", first one to WIN 3 games.");
        do{
            computerId = rand.nextInt(3); //random generiranje broja od 0,1,2
            System.out.println("Please eneter your choice:\n1--Rock\n2--Paper\n3--Scissors\n");

            do{
                try { // u slucaju unosa stringa
                    playerId = Main.scan.nextInt();
                    Main.scan.nextLine();
                }
                catch(Exception e){
                    System.out.println("Wrong input, try again!");
                    Main.scan.nextLine();
                }
            }while(playerId < 1 || playerId > 3); // provjera unosa broja od strane igraca

            checkWinner(playerId-1,computerId); //salje se playerId-1 jer korisnik upisuje 1,2,3 a indeksi polja su 0,1,2

            //služi samo da zaustavi kod prije sljedeceg unosa
            System.out.println("Press ENTER to continue ...");
            Main.scan.nextLine();

        }while((playerWins < 3) && (computerWins < 3));

        if(playerWins == 3){
            System.out.println("YOU WON! " + playerWins + " AGAINST " + computerWins + "      CONGRATULATION!!!");
            resetWinsVariables(); //sluzi za postavljanje statickih varijabli koje prate broj pobjeda na 0
        }
        else{
            System.out.println("COMPUTER WON! " + computerWins + " AGAINST " + playerWins + "      TOO BAD :( ... TRY AGAIN");
            resetWinsVariables();
        }

        System.out.println("Press ENTER to continue ...");
        Main.scan.nextLine();
    }

    //********************************POMOCNA METODA ZA PROVJERU POBJEDNIKA*********************************************
    static void checkWinner(int playerId, int computerId){

        //U slucaju da je izjednaceno samo printa poruku
        if(playerId == computerId){
            System.out.println("It's a DRAW");
        }
        //U tri slucaja igrac pobjeđuje te su oni provjereni u else if uvjetu, brojevi su jednaki indeksima u RPS arrayu
        //gdje je 0 - ROCK ; 1 - PAPER ; 2 - SCISSORS
        else if(((playerId == 0) && (computerId == 2)) || ((playerId == 1) && (computerId == 0)) || ((playerId == 2) && (computerId == 1)) ){
            playerWins++;
            System.out.println("You draw " + RPS[playerId] + " and computer draw " + RPS[computerId] + "\nYOU WIN!\n");
            System.out.println("YOU: " + playerWins + "\nCOMPUTER: " + computerWins);
        }
        //U svim ostalim uvijetima je pobjedilo racunalo
        else{
            computerWins++;
            System.out.println("You draw " + RPS[playerId] + " and computer draw " + RPS[computerId] + "\nCOMPUTER WIN!\n");
            System.out.println("YOU: " + playerWins + "\nCOMPUTER: " + computerWins);
        }
    }

    //************POMOCNA METODA ZA RESETIRANJE STATICKIH VARIJABLI KOJE PRATE BROJ POBJEDA*****************************
    static void resetWinsVariables(){
        playerWins = 0;
        computerWins = 0;
    }
}
