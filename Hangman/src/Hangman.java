import java.util.Scanner;
import java.util.ArrayList;

public class Hangman {
    private static ArrayList<String> track = new ArrayList<String>();
   private static ArrayList<String> lul = new ArrayList<String>();

    public String Scanner(){
        Scanner userInput = new Scanner(System.in);
        String phrase;
        System.out.print("Enter a word: ");
        phrase = userInput.nextLine();
        return phrase;
    }

    public ArrayList<String> Guesses(String guess){
        track.add(guess);
        return track;
    }

    public String Guessing(){
        Scanner guess = new Scanner(System.in);
        System.out.print("Enter your guess: ");
        return guess.nextLine();
        //return letterGuess;
    }

    public int Hint(int hint){
        return hint;
    }

    public void Word(String[] word){





        for(String i : lul){
            System.out.print(" "+i);
        }
        //return null;
        }


    public static void main(String[] args) {

        //ArrayList<String> track = new ArrayList<String>();

        System.out.println("-------------Welcome to Hangman---------------");
        int guesses = 4;

        Hangman hang = new Hangman();
            String a = hang.Scanner();
            //a = a.replace(" ","#");
            String[] b = a.split("");

        for(int i = 0; i<b.length;i++){
            if(b[i].equals(" ")){
                lul.add(i,"#");
            }
            else {
                lul.add(i,"_");
            }
        }

        while(guesses != 0){
            System.out.print("So far, the word is: ");

            for (int i = 0; i<track.size(); i++){
                if(b[i].contains(track.get(i))){
                    lul.set(i,b[i]);
                }
            }

            for(String i : lul){
                System.out.print(" "+i);
            }

            //hang.Word(b);

//            for(int i = 0;i<b.length;i++){
//                    if(!b[i].equals("#")){
//                        System.out.print(" _");
//                    }
//                    else{
//                        System.out.print(" #");
//                    }
//
//
//
//            }
            System.out.println();

            Scanner oneORtwo = new Scanner(System.in);
            System.out.println("You have " + guesses +" left.");
            boolean tf=true;
            while (tf){
                System.out.print("Enter either 1 for guessing or 2 for hint: ");
                int ot = oneORtwo.nextInt();
                if(ot == 1){
                    String letter = hang.Guessing();
                    for(int i = 0; i<b.length; i++){
                        if(b[i].equals(letter) ){
                            System.out.println("That's right! "+ letter +" is in the word.");
                            tf = false;
                        }
                    }//add guesses into an ArrayList to track
                    hang.Guesses(letter);

                }//hint if int == 2
                else if(ot == 2){

                }
                else{
                    System.out.println("Incorrect Input.");
                }
            }

        }





    }
}
