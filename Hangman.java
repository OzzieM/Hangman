import java.util.Scanner;
import java.util.ArrayList;

public class Hangman {
    private static ArrayList<String> track = new ArrayList<String>();
   private static ArrayList<String> word = new ArrayList<String>();

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
        String a ="";
        while(!a.toUpperCase().matches("[A-Z]")){
            System.out.print("Enter your guess: ");
            a = guess.nextLine();
            if(a.toUpperCase().matches("[A-Z]")){
                return a;
            }
            else{
                System.out.println("Incorrect Input");
            }
        }
        return  a;
    }

    public String Hint(){
        for(int i=0; i<word.size();i++){
            if(!track.contains(word.get(i)) && !word.get(i).equals("#")){
                return word.get(i);
            }
        }
        return null;
    }

    public void Word(String[] phrase){
        for(int i = 0; i< phrase.length;i++){
            if(phrase[i].equals(" ")){
                word.add("#");
            }
            else{
                word.add(phrase[i]);
            }
        }
    }


    public static void main(String[] args) {

        //ArrayList<String> track = new ArrayList<String>();

        System.out.println("-------------Welcome to Hangman---------------");
        int guesses = 4;

        Hangman hang = new Hangman();
            String a = hang.Scanner().toUpperCase(); //scan input and change to UpperCase
            hang.Word(a.split("")); // split string and add each letter to arraylist

        //System.out.println(word);

        while(guesses != 0){
            //winning condition
            if(track.containsAll(word)){
                break;
            }
            System.out.println();
            System.out.print("So far, the word is: ");
                // prints blanks/letters
            for(int i =0;i<word.size();i++){
                if(word.get(i).equals("#")){
                    System.out.print(" #");
                }
                else if(!track.contains(word.get(i))){
                    System.out.print(" _");
                }
                else if(track.contains(word.get(i))){
                    System.out.print(" "+word.get(i));
                }
            }


            System.out.println();

            Scanner oneORtwo = new Scanner(System.in);
            System.out.println("You have " + guesses +" incorrect guesses left.");
            boolean tf=true;
            while (tf){
                System.out.print("Enter either 1 for guessing or 2 for hint: ");
                String ot = oneORtwo.nextLine();
                if(ot.equals("1")){
                    String letter = hang.Guessing().toUpperCase();
                    for(int i = 0; i<word.size(); i++){
                        if(track.contains(letter)){
                            System.out.println("Not Valid Input. You already guessed " + letter);
                            tf = false;
                            break;
                        }
                        else if(word.contains(letter)){
                            System.out.println("That's right! "+ letter +" is in the word.");
                            tf = false;
                            break; //was printing above line multiple times so broke to show only one occurrence
                        }
                        else if(!word.contains(letter)){
                            System.out.println("Sorry, "+ letter +" isn't in the word");
                            guesses--;
                            tf = false;
                            break;
                        }
                    }//add guesses into an ArrayList to track
                    hang.Guesses(letter);

                }//hint if int == 2
                else if(ot.equals("2")){
                    hang.Guesses(hang.Hint());
                    guesses--;
                    break;
                }
                else{
                    System.out.println("Incorrect Input.");
                }
            }

        }
        System.out.println();

        if(track.containsAll(word)){ //kind of redundant but double checks before outputting game winning condition
            System.out.print("CONGRATULATIONS THE WORD WAS: ");
            for(String i :word){
                System.out.print(i);
            }
        }
        if(guesses == 0){
            System.out.print("You Failed. The word was: ");
            for(String i :word){
                System.out.print(i);
            }
        }


    }
}
