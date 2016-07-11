/**
 * Simulates a game of solitaire on a deck.
 * 
 * @author Luke Badini
 * @version 4/15/15
 */
public class SolitaireSimulator 
{
	private Deck aDeck;
	private Card[] faceUp;
	private int cardsFaceUp;
	
	/**
	 * Constructs a SolitaireSimulator
	 */
	public SolitaireSimulator()
	{
		aDeck = new Deck();
		faceUp = new Card[52];
		cardsFaceUp = 0;
		
		aDeck.fillDeck();
		aDeck.shuffle();
	}
	
	/**
	 * Plays a game of solitaire. Returns true if the
	 * game is won and false otherwise.
	 */
	public boolean playGame()
	{
		for (int i = 0; i < 4; i++)
		{
			faceUp[i] = aDeck.deal();
		}
		
		boolean playingGame = true;
		
		while (playingGame)
		{
			boolean fourDiscarded = false;
			cardsFaceUp = numberFaceUp();
			
			if (cardsFaceUp >= 4)
			{
				fourDiscarded = discardCondition1();
			
				if (!fourDiscarded)
				{
					discardCondition2();
				}
			}
			
			if (aDeck.deal() == null)
			{
				playingGame = false;
			}
			else
			{
				faceUp[cardsFaceUp] = aDeck.deal();
			}
		}
		
		if (faceUp[0] == null)
		{
			return true;
		}
		else
		{
			return false;
		}
		
		
	}
	
	private int numberFaceUp()
	{		
		for (int i = 0; i < faceUp.length; i++)
		{
			if (faceUp[i] == null)
			{
				return i;
			}
		}
		return 0;
	}
	
	/**
	 * Checks to see if the last 4 cards in the hand are
	 * all of the same suit. If they are, removes them from
	 * the hand.
	 */
	private boolean discardCondition1()
	{
		int lastCard = cardsFaceUp - 1;
		int secondLastCard = cardsFaceUp - 2;
		int thirdLastCard = cardsFaceUp - 3;
		int fourthLastCard = cardsFaceUp - 4;
		
		if (faceUp[lastCard].getSuit().equals(
				faceUp[secondLastCard].getSuit()) &&
				faceUp[lastCard].getSuit().equals(
						faceUp[thirdLastCard].getSuit()) && 
				faceUp[lastCard].getSuit().equals(
						faceUp[fourthLastCard].getSuit()))
		{
			faceUp[lastCard] = null;
			faceUp[secondLastCard] = null;
			faceUp[thirdLastCard] = null;
			faceUp[fourthLastCard] = null;
			
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Checks to see if the rightmost and 4th-to-rightmost card
	 * are of the same suit. If they are, removes the two cards between
	 * them from the hand.
	 */
	private void discardCondition2()
	{
		int lastCard = cardsFaceUp - 1;
		int secondLastCard = cardsFaceUp - 2;
		int thirdLastCard = cardsFaceUp - 3;
		int fourthLastCard = cardsFaceUp - 4;
		
		if (faceUp[lastCard].getSuit().equals(
				faceUp[fourthLastCard].getSuit()))
		{
			faceUp[secondLastCard] = null;
			faceUp[thirdLastCard] = null;
			faceUp[secondLastCard] = faceUp[fourthLastCard];
		}
	}
}
