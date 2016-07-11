/**
 * Creates card objects with suit and value variables.
 * 
 * @author Luke Badini
 * @version 4/14/2014
 *
 */
public class Card 
{
	private String suit;
	private int value;
	
	/**
	 * Constructor that sets values of the suit and value 
	 * variables of the card object.
	 * 
	 * @param newSuit; a string representing the suit of the card
	 * @param newValue; an integer representing the value of the card
	 * 					(1 is Ace, 11 is Jack, 12 is Queen, 13 is King)
	 */
	public Card(String newSuit, int newValue)
	{
		suit = newSuit;
		value = newValue;
	}
	
	/**
	 * Returns the suit value for a card object.
	 */
	public String getSuit()
	{
		return suit;
	}
	
	/**
	 * Sets the suit value for a card object.
	 */
	public void setSuit(String newSuit)
	{
		suit = newSuit;
	}
	
	/**
	 * Returns the value value for a card object.
	 */
	public int getValue()
	{
		return value;
	}
	
	/**
	 * Prints the value and suit of a card object.
	 */
	public String toString()
	{
		if (value == 1)
		{
			return ("Ace of " + suit);
		}
		else if (value == 11)
		{
			return ("Jack of " + suit);
		}
		else if (value == 12)
		{
			return ("Queen of " + suit);
		}
		else if (value == 13)
		{
			return ("King of " + suit);
		}
		else
		{
			return (value + " of " + suit);
		}
	}
}
