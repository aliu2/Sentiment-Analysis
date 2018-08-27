//The increasingly diverse French director has created a film that one can 
//honestly describe as looking sounding and simply feeling like no other film in recent history
//2.924
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Sentiment
{
    public static double sentiment(String review, String reviewFilename)
    {
        try
        {
            String[] reviewArr = review.split(" ");
            double reviewSum = 0;
            int count = 0;
            
            for (String s: reviewArr)
            {
                Scanner reviewFileScanner = new Scanner(new File(reviewFilename));
                double wordScore = getWordScore(s, reviewFileScanner);
                if (wordScore > 0)
                {
                    reviewSum += wordScore;
                    count++;
                }
            }
            
            if (reviewSum == 0)
            {
                return -1;
            }
            return reviewSum/count;
        }
        
        catch(FileNotFoundException ex)
        {
            return -1;
        }
    }
    
    public static double getWordScore(String word, Scanner sc)
    {
        double sum = 0;
        int count = 0;
        while (sc.hasNext())
        {
            String[] reviewLine = sc.nextLine().split(" ");
            for (String s: reviewLine)
            {
                if (s.equalsIgnoreCase(word))
                {
                    sum += Integer.parseInt(reviewLine[0]);
                    count++;
                    break;
                }
            }
        }
        
        double avg = sum/count;
        if (avg < 1.8 || avg > 2.2 && sum != 0)
        {
            return avg;
        }
        return 0;
    }
}
