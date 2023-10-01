public class HangmanGame{
    private HangmanImage image;
    private String word;
    private String triedLetters;
    private String guessed;
    public HangmanGame(String toBeGuessed)
    {
      image=new HangmanImage();  
      word=toBeGuessed;
      triedLetters="";
      guessed="";
      for(int i=0; i<toBeGuessed.length(); i++)
      {
          guessed+="-";
      }
    }
    
    public String getWord()
    {
        return word;
    }
    
    public String getTriedLetters()
    {
        return triedLetters;
    }
    
    public String getGuessed()
    {
        return guessed;
    }
    
    public boolean gameOver()
    {
        if(image.getCount()>=5)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public boolean gameWon()
    {
        if(guessed.equals(word))
        {
            return true;
        }
        return false;
    }
    
    public int tryLetter(String letter)
    {
        triedLetters+=letter;
        int psn = word.indexOf(letter);
        int count=0;
        if(psn>-1)
        {
            while(psn>-1)
            {
                String firstPart = guessed.substring(0, psn);
            String lastPart = guessed.substring(psn + letter.length());
            guessed=firstPart+letter+lastPart;  
                    psn = word.indexOf(letter, psn + 1);
            count++;
            }
 
        }
        for(int i=0; i<triedLetters.length()-1; i++)
        {
            if(triedLetters.substring(i,i+1).equals(letter))
            {
                return 0;
            }
        } 
        if(count==0)
        {
           if(psn==-1)
        {
            return -1;
        }
        }
        return 1;
    }
    
    public void printStatus()
    {
        image.printImage();
        System.out.println("Tried Letters: "+ triedLetters);
        System.out.println("Word: " +guessed);
    }
    
    public void updateBoard(String letter)
    {
        int tryResult=tryLetter(letter);
        if(tryResult==-1)
        {
           System.out.println("not present");
           image.increaseCount();
        }
        else if(tryResult==0)
        {
            System.out.println("already tried");
        }
        else
        {
            System.out.println("success!");
        }
        printStatus();
    }
}

