/**
 * Testing suite for BetterBag
 * 
 * @author Luke Badini and Chris Fernandes
 *
 */
public class BagTests {
	public static final boolean VERBOSE = true;
	
	/* Runs a bunch of tests for the BetterBag class.
	 * @param args is ignored
	 */
	public static void main(String[] args)
	{
		System.out.println("Starting Tests");
		
		testClone();
		
		testisEmpty();
		testRemoveRandom();
		testContains();
		testEquals();
		System.out.println("Tests Complete");
	}
	
	private static void testClone()
	{
		testsSection("Testing clone()");
		
		BetterBag bag1 = new BetterBag(3);
		
		BetterBag bag2 = bag1.clone();
		assertEquals("cloning an empty sequence", "{} (capacity = 3)", bag2.toString());
		
		bag1 = new BetterBag(3);
		bag1.add(4);
		bag1.add(8);
		bag1.add(12);
		bag2 = bag1.clone();
		assertEquals("cloning {4, 8, 12}", "{4, 8, 12} (capacity = 3)", bag2.toString());
		assertEquals("cloning {4, 8, 12} should produce a different object.  Does (bag2 != bag1)", true, (bag2 != bag1));
		
		bag1 = new BetterBag(7);
		bag1.add(-1);
		bag1.add(-2);
		bag1.add(-3);
		bag2 = bag1.clone();
		bag1.add(-4);
		assertEquals("clone shouldn't change after adding to original", "{-1, -2, -3} (capacity = 7)", bag2.toString());
		assertEquals("original should change after cloning & adding to original", 
				"{-1, -2, -3, -4} (capacity = 7)", bag1.toString());
		
		bag1 = new BetterBag(5);
		bag1.add(1);
		bag1.add(2);
		bag1.add(3);
		bag1.add(4);
		bag2 = bag1.clone();
		bag2.add(5);
		assertEquals("original shouldn't change after adding to clone", "{1, 2, 3, 4} (capacity = 5)", bag1.toString());
		assertEquals("clone should change after cloning & adding to clone", 
				"{1, 2, 3, 4, 5} (capacity = 5)", bag2.toString());
	}
	
	private static void testisEmpty()
	{
		BetterBag bag3 = new BetterBag();
		assertEquals("Empty bag (should be true)", true, 
				bag3.isEmpty());
		
		bag3.add(1);
		bag3.add(2);
		assertEquals("Non-empty bag (should be false)", false, 
				bag3.isEmpty());
	}
	
	private static void testRemoveRandom()
	{
		BetterBag bag4 = new BetterBag(4);
		bag4.add(1);
		bag4.add(2);
		bag4.add(3);
		bag4.removeRandom();
		assertEquals("Remove a random number from a non-full bag",
				2, bag4.size());
		
		bag4.add(4);
		bag4.add(5);
		bag4.removeRandom();
		assertEquals("Remove a random number from a full bag",
				3, bag4.size());
		
		assertEquals("Is the capacity the same?", 4, 
				bag4.getCapacity());
	}
	
	private static void testContains()
	{
		BetterBag bag5 = new BetterBag();
		assertEquals("Checks a number in an empty bag", false, 
				bag5.contains(1));
		
		bag5.add(1);
		bag5.add(2);
		bag5.add(3);
		assertEquals("Checks a number in the bag", true, 
				bag5.contains(1));
		assertEquals("Check a number not in the bag", false, 
				bag5.contains(4));
		
		bag5.add(1);
		assertEquals("Checks a number that's in the bag multiples"
				+ " times", true, bag5.contains(1));
	}
	
	private static void testEquals()
	{
		BetterBag bag6 = new BetterBag();
		BetterBag bag7 = new BetterBag();
		assertEquals("Checks if 2 empty bags of the same capacity"
				+ " are equal", true, bag6.equals(bag7));
		BetterBag bag8 = new BetterBag(3);
		assertEquals("Checks if 2 empty bags with different "
				+ "capacities are equal", true, 
				bag6.equals(bag8));
		
		bag6.add(1);
		bag6.add(2);
		bag6.add(3);
		bag7.add(3);
		bag7.add(1);
		bag7.add(2);
		assertEquals("2 bags with same capacity and same items",
				true, bag6.equals(bag7));
		
		bag8.add(3);
		bag8.add(2);
		bag8.add(1);
		assertEquals("2 bags with different capacity and same "
				+ "items", true, bag6.equals(bag8));
		
		bag6.add(27);
		assertEquals("2 bags with same capacity and different "
				+ "number of items", false, bag6.equals(bag7));
		assertEquals("2 bags with different capacity and differnt"
				+ " items", false, bag6.equals(bag8));
		
		bag7.add(5);
		assertEquals("2 bags with same capacity and different "
				+ "items", false, bag6.equals(bag7));
		
		BetterBag bag9 = new BetterBag(3);
		BetterBag bag10 = new BetterBag(3);
		bag9.add(1);
		bag9.add(1);
		bag9.add(2);
		bag10.add(1);
		bag10.add(2);
		bag10.add(2);
		assertEquals("2 bags with different number of the same "
				+ "element", false, bag9.equals(bag10));		
	}
	
	/***********  TESTING TOOLS ****************/
	
	
	private static void assertEquals(String message, boolean expected, boolean actual)
	{
		printTestCaseInfo(message, "" + expected, "" + actual);
		if (expected == actual) {
			pass();
		} else {
			fail(message);
		}
	}

	
	private static void assertEquals(String message, int expected, int actual)
	{
		printTestCaseInfo(message, "" + expected, "" + actual);
		if (expected == actual) {
			pass();
		} else {
			fail(message);
		}
	}
	
	private static void assertEquals(String message, String expected, String actual)
	{
		printTestCaseInfo(message, expected, actual);
		
		if (expected == null) {
			if (actual == null) {
				pass();
			} else {
				fail(message);
			}
		} else if (expected.equals(actual)) {
			pass();
		} else {
			fail(message);
		}
		
	}
	
	private static void printTestCaseInfo(String message, String expected, String actual)
	{
		if (VERBOSE) {
			System.out.println(message + ":");
			System.out.println("expected: " + expected);
			System.out.println("actual:   " + actual);
		}
	}
	
	private static void pass()
	{
		if (VERBOSE) {
			System.out.println("PASS");
			System.out.println();
		}
	}
	
	private static void fail(String description)
	{
		if (!VERBOSE) {
			System.out.print(description + "  ");
		}
		System.out.println("*******########## FAIL");
		System.out.println();
	}
	
	private static void testsSection(String sectionTitle)
	{
		if (VERBOSE) {
			int dashCount = sectionTitle.length();
			System.out.println(sectionTitle);
			for (int i = 0; i < dashCount; i++) {
				System.out.print("-");
			}
			System.out.println();
			System.out.println();
		}
	}
}
