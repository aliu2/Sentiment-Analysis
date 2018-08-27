public class SentimentAnalysis
{
	public static void main(String[] args)
	{
		System.out.println("This review gets a score of " + Sentiment.sentiment("great movie with a gripping plot but falls short sometimes", "senti.txt"));
	}
}
