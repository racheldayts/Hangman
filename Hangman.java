import java.util.Scanner;
public class Hangman
{
    public static String askForLetter()
    {
        Scanner reader= new Scanner(System.in);
        System.out.println("Choose a letter!");
        return reader.nextLine();
    }
    
    public static String selectWord()
    {
        String[] words= {"SNICKERDOODLE","LOLLIPOP","SNEAKERS","FLOWERS","SLEEP"};
        int random=(int)(Math.random()*5);
        return words[random];
    }
    
    public static void main(String[] args)
    {
        String newWord=selectWord();
        HangmanGame game= new HangmanGame(newWord);
        game.printStatus();
        String letter="";
        while(!game.gameWon()&& !game.gameOver())
        {
             letter= askForLetter();
             game.updateBoard(letter);
        }
        if(game.gameWon())
        {
            System.out.println("Congratulations! You won!");
        }
        if(game.gameOver())
        {
            System.out.println("You lose:( But You should play again!");
        }
    }
}

