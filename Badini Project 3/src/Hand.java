/**
 * Stores information on a player and their hand
 * 
 * @author Luke Badini
 * @version 4/22/2015
 *
 */
import java.util.Scanner;

public class Hand 
{
	private String playerName;
	private Card[] playerHand;
	private Deck deck;
	private int handLength;
	private String handAsString;
	
	/**
	 * Constructs a player's hand
	 * 
	 * @param aDeck; the shuffled deck being used for the game
	 */
	public Hand(Deck aDeck)
	{
		deck = aDeck;
		askPlayerName();
		playerHand = new Card[deck.getCardNumber()];
		startingDeal();
	}
	
	/**
	 * Asks for a player's name
	 */
	private void askPlayerName()
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter your name: ");
		playerName = keyboard.nextLine();
	}
	
	/**
	 * Deals the player 7 cards to start their hand
	 */
	private void startingDeal()
	{
		for (int i = 0; i < 7; i++)
		{
			playerHand[i] = deck.deal();
		}
		handLength = 7;
	}
	
	/**
	 * Draws a card from the deck and puts
	 * it into the player's hand
	 */
	public void drawCard()
	{
		playerHand[handLength] = deck.deal();
		handLength++;		
	}
	
	/**
	 * Removes a card from the player's hand
	 * @return the Card object removed
	 */
	public Card removeCard(int cardNumber)
	{
		handLength--;
		Card cardRemoved = playerHand[cardNumber];
		playerHand[cardNumber] = playerHand[handLength];
		
		return cardRemoved;
	}
	
	/**
	 * Finds a card from the player's hand
	 * @return the Card object found
	 */
	public Card seekCard(int cardNumber)
	{
		return playerHand[cardNumber];
	}
	
	/**
	 * Returns the player's hand as a string
	 */
	public String toString()
	{
		handAsString = (playerName + "'s hand\n"
				+ "----------\n");
				
		for (int i = 0; i < handLength; i++)
		{
			handAsString += (i + ") ");
			handAsString += (playerHand[i].toString() + "\n");
		}
		
		return handAsString;
	}
	
	/**
	 * Returns the player's name
	 */
	public String getPlayerName()
	{
		return playerName;
	}
	
	/**
	 * Returns the player's hand
	 */
	public Card[] getPlayerHand()
	{
		return playerHand;
	}
	
	/**
	 * Returns the player's hand length
	 */
	public int getHandLength()
	{
		return handLength;
	}
}
