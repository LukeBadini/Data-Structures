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
	 * Returns the value value for a card object.
	 */
	public int getValue()
	{
		return value;
	}
	
	/**
	 * Prints the value and suit of a card object.
	 */
	public void cardToString()
	{
		if (value == 1)
		{
			System.out.println("Ace of " + suit);
		}
		else if (value == 11)
		{
			System.out.println("Jack of " + suit);
		}
		else if (value == 12)
		{
			System.out.println("Queen of " + suit);
		}
		else if (value == 13)
		{
			System.out.println("King of " + suit);
		}
		else
		{
			System.out.println(value + " of " + suit);
		}
	}
}
