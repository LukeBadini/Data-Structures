/**
 * Simulates 10,000 solitaire games and prints the %
 * winrate after every 1,000 games.
 * 
 * @author Luke Badini
 * @version 4/15/2015
 *
 */
public class Client 
{
	public static void main(String[] args)
	{
		double gamesPlayed = 1;
		double simulatedGamesWon = 0;
		double winPercent = 0;
		SolitaireSimulator aSimulator = new SolitaireSimulator();

		while (gamesPlayed <= 10000)
		{
			aSimulator = new SolitaireSimulator();			
			boolean wonGame = aSimulator.playGame();
			
			if (wonGame)
			{
				simulatedGamesWon++;
			}
			
			winPercent = (simulatedGamesWon / gamesPlayed) * 100;
			
			if (gamesPlayed%1000 == 0)
			{
				System.out.println((int)simulatedGamesWon + "/" +
			(int)gamesPlayed + " games won = " + winPercent + "%");
			}
			
			gamesPlayed++;
		}
	}	
}
