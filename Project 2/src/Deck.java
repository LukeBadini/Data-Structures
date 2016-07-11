/**
 * Generates a deck comprised of an array of Card objects.
 * 
 * @author Luke Badini
 * @version 4/15/2015
 *
 */

import java.util.Random;

public class Deck 
{
	private Card[] deck;
	private int dealIndex;
	private int generatorIndex;
	private int cardNumbers;
	
	/**
	 * Deck constructor
	 */
	public Deck()
	{
		deck = new Card[52];
		generatorIndex = 0;
		dealIndex = -1;
		cardNumbers = 13;
	}
	
	/**
	 * Fills the deck with card objects
	 */
	public void fillDeck()
	{
		String[] suitArray = {"heart", "diamond", "spade", "club"};
		Card aCard;
		
		for (String suit: suitArray)
		{
			for (int value = 1; value <= cardNumbers; value++)
			{
				aCard = new Card(suit, value);
				deck[generatorIndex] = aCard;
				generatorIndex++;
			}
		}
	}
	/**
	 * Returns the next dealt card in the deck.
	 * If the deck is empty, returns null.
	 */
	public Card deal()
	{			
		if (dealIndex < 51)
		{
			dealIndex++;
			return deck[dealIndex];
		}
		else
		{
			return null;
		}
	}
	
	/**
	 * Shuffles the deck array from back to front.
	 */
	public void shuffle()
	{
		int shuffleIndex = 51;
		boolean shuffling = true;
		Random randomNumberGenerator = new Random();
		int randomNumber;
		Card swapper;
		
		while (shuffling)
		{
			if (shuffleIndex == 0)
			{
				shuffling = false;
			}
			else
			{
				randomNumber = randomNumberGenerator.nextInt(shuffleIndex);
				
				swapper = deck[shuffleIndex];
				deck[shuffleIndex] = deck[randomNumber];
				deck[randomNumber] = swapper;
				shuffleIndex--;
			}
		}
	}
	
	/**
	 * Prints every card in the deck as a string.
	 */
	public void deckToString()
	{
		for (Card card: deck)
		{
			card.cardToString();
		}
	}
}
