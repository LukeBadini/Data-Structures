/**
 * Simulates a game of Crazy Eights
 * 
 * @author Luke Badini
 * @version 4/23/2015
 */
import java.util.Scanner;

public class CrazyEights 
{
	private int playerNumber;
	private Hand[] playerHands;
	private Deck deck;
	private Card[] faceUpCard;
	private boolean playerHasWon;
	private String winningPlayer;
	private final String RULES = "Rules:\n\n"
			+ "Players are dealt 7 cards at the\n"
			+ "beginning of the game and 1 card is dealt face-up.\n"
			+ "Players then take turns matching cards from their\n"
			+ "hand to the face-up card by either their suit or\n"
			+ "value 8s can be played as any value or suit and when\n"
			+ "and 8 is played, the player declares the new suit of\n"
			+ "the card. If a player cannot play a card, they must\n"
			+ "draw. The winner is the first to discard their entire\n"
			+ "hand. In the event of no moves being able to be\n"
			+ "played, the game is considered a draw.\n";
	
	public CrazyEights()
	{
		System.out.println(RULES);
		
		askPlayerNumber();
		deck = new Deck();
		deck.shuffle();
		playerHands = new Hand[playerNumber];
		
		for (int i = 0; i < playerNumber; i++)
		{
			playerHands[i] = new Hand(deck);
		}
		
		faceUpCard = new Card[1];
		dealCard();
	}
	
	/**
	 * Asks for how many players there are.
	 */
	private void askPlayerNumber()
	{
		Scanner keyboard2 = new Scanner(System.in);
		
		System.out.print("How many players? ");
		playerNumber = keyboard2.nextInt();
		
		if (playerNumber < 2 || playerNumber > 10)
		{
			System.out.println("Invalid number of players.");
			askPlayerNumber();
		}
	}
	
	/**
	 * Deals a card from the deck to the face-up pile
	 */
	private void dealCard()
	{
		faceUpCard[0] = deck.deal();
	}
	
	/**
	 * Plays a game of Crazy Eights
	 */
	public void playGame()
	{
		boolean playingGame = true;
		playerHasWon = false;
		
		while (playingGame)
		{
			for (Hand hand: playerHands)
			{
				if (!playerHasWon)
				{
					System.out.println(hand.toString());
					printFaceUp();
				
					if (!playerNoMoves(hand))
					{
						playerHasMoves(hand);
					}
					else
					{
						if (!drawChecker())
						{
							playerHasNoMoves(hand);
						}
						else
						{
							playingGame = false;
						}
					}
				}
				else
				{
					playingGame = false;
				}
			}
		}
		if (playerHasWon)
		{
			System.out.print(winningPlayer + " has won!!!!");
		}
		else
		{
			System.out.print("The game is a draw.");
		}
	}
	
	/**
	 * Prints the face-up card
	 */
	private void printFaceUp()
	{
		System.out.print("Top card is ");
		System.out.println(faceUpCard[0].toString());
	}
	
	/**
	 * Makes the player's move
	 * @param hand; the player's hand
	 */
	private void playerMove(Hand hand)
	{
		Scanner keyboard3 = new Scanner(System.in);
		
		System.out.print(hand.getPlayerName() + "'s move? ");
		int playerMove = keyboard3.nextInt();
		System.out.println();
		
		Card cardInHand = hand.seekCard(playerMove);
		
		if (cardInHand.getValue() == 8)
		{
			crazyEight(cardInHand, playerMove, hand);
			
		}
		
		else if (cardInHand.getSuit().equals(faceUpCard[0].getSuit())
				|| cardInHand.getValue() == faceUpCard[0].getValue())
		{
			faceUpCard[0] = hand.removeCard(playerMove);
		}
		else
		{
			System.out.println("Invalid move.");
			playerMove(hand);
		}
	}
	
	/**
	 * Lets player choose a new suit for their crazy eight
	 * @param card; player's 8 card
	 * @param cardNumber; the card's position in the player's hand
	 * @param hand; player's hand
	 */
	private void crazyEight(Card card, int cardNumber, Hand hand)
	{
		Scanner keyboard4 = new Scanner(System.in);
		
		System.out.println("### CRAZY 8! ###");
		System.out.println("New suit? (H, D, C, S): ");
		String newSuit = keyboard4.nextLine();
		
		if (newSuit.equals("H") || newSuit.equals("h"))
		{
			card.setSuit("heart");
		}
		else if (newSuit.equals("D") || newSuit.equals("d"))
		{
			card.setSuit("diamond");
		}
		else if (newSuit.equals("C") || newSuit.equals("c"))
		{
			card.setSuit("club");
		}
		else if (newSuit.equals("S") || newSuit.equals("s"))
		{
			card.setSuit("spade");
		}
		else
		{
			System.out.println("Invalid suit");
			crazyEight(card, cardNumber, hand);
		}
		
		faceUpCard[0] = hand.removeCard(cardNumber);
	}
	
	/**
	 * Checks to see if a player has no valid moves. If they
	 * don't, draws a card into their hand.
	 * 
	 * @param playerHand; player's Hand
	 * @return true if no valid moves, false otherwise
	 */
	private boolean playerNoMoves(Hand playerHand)
	{
		for (int i = 0; i < playerHand.getHandLength(); i++)
		{
			if (playerHand.getPlayerHand()[i].getSuit().equals(
					faceUpCard[0].getSuit())||playerHand.getPlayerHand()
					[i].getValue() == faceUpCard[0].getValue() || 
					playerHand.getPlayerHand()[i].getValue() == 8)
			{
				return false;
			}
		}
		System.out.println(playerHand.getPlayerName() + " has no "
				+ "moves and drew a card");
		System.out.println();
		return true;
	}
	
	/**
	 * If the player has a move, prompts them to make a move
	 * 
	 * @param playerHand; player's hand
	 */
	private void playerHasMoves(Hand playerHand)
	{
		playerMove(playerHand);
		playerHasWon = hasWon(playerHand);
		
		if (playerHasWon)
		{
			winningPlayer = playerHand.getPlayerName();
		}
	
		if (player1CardLeft(playerHand))
		{
			System.out.println("!!!!" + playerHand.getPlayerName()
					+ " has 1 card left!!!!");
		}
	}
	
	/**
	 * If the player has no moves, draws cards until they
	 * have a move.
	 * 
	 * @param playerHand; player's hand
	 */
	private void playerHasNoMoves(Hand playerHand)
	{
		playerHand.drawCard();
		if (!playerNoMoves(playerHand))
		{
			System.out.println(playerHand.toString());
			printFaceUp();
			playerMove(playerHand);
		}
		else
		{
			playerHasNoMoves(playerHand);
		}
	}
	
	/**
	 * Checks to see if a player has 1 card left
	 * @return true is 1 card is left, false otherwise
	 */
	private boolean player1CardLeft(Hand playerHand)
	{
		return playerHand.getHandLength() == 1;
	}
	
	/**
	 * Checks to see if a player has won the game. If they won,
	 * prints that they won and stops the game.
	 * @param hand; player's hand
	 * @return true if player has won, false otherwise
	 */
	private boolean hasWon(Hand hand)
	{
		return (hand.getHandLength() == 0);	
	}
	
	/**
	 * Checks if there is a draw.
	 * @return true is there is a draw, false otherwise
	 */
	private boolean drawChecker()
	{
		if (deck.getDeck()[0] == null)
		{
			for (Hand hand: playerHands)
			{
				if (!playerNoMoves(hand))
				{
					return false;
				}
			}
			return true;
		}
		else
		{
			return false;
		}
	}
}
