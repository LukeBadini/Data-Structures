/** Tester for the Event and LinkedList classes
 * 
 * @author Luke Badini, Aaron Cass, and Chris Fernandes
 * @version 2/14/13
 */
public class Tester {
    public static final boolean VERBOSE = true;
    
    public static void main(String[] args)
    {
    	System.out.println("Starting Tests");
	
    	testConstructor();
    	testCompareTo();
    	testRemoveHead();
    	testInsertAtTail();
    	testSearch();
	
    	System.out.println("Tests Complete");
    }
    
    private static void testConstructor()
    {
    	testsSection("Event Constructor test");
	
    	Event e1 = new Event("book club", 2012, 2, 24, 1000, 1200);
    	assertEquals("Non-default constructor", "book club  2/24/2012  1000-1200", e1.toString());
    }
    
    private static void testCompareTo()
    {
    	testsSection("Event compareTo tests");
	
    	Event later = new Event("book club", 2012, 2, 24, 1000,
    			1200);
    	Event earlier = new Event("chess club", 2011, 2, 24, 900,
    			1000);
    	assertEquals("different years", 1, later.compareTo(
    			earlier));
    	
    	// Add more tests here.
    	// Be sure every line in compareTo gets a chance to execute.
    	Event later2 = new Event("book club", 2012, 2, 24, 1000,
    			1200);
    	Event earlier2 = new Event("chess club", 2012, 2, 24, 900,
    			1200);
    	assertEquals("same year", 1, later2.compareTo(earlier2));
    	
    	Event event1 = new Event("book club", 2012, 2, 24, 1000, 
    			1200);
    	Event event2 = new Event("chess club", 2012, 2, 24, 1000, 
    			1200);
    	assertEquals("same exact time", 0, event1.compareTo(
    			event2));
    	
    	event2 = new Event("chess club", 2012, 2, 24, 1000, 1100);
    	assertEquals("same start different end", 0, 
    			event1.compareTo(event2));
    	
    	event2 = new Event("chess club", 2011, 2, 24, 1000, 1200);
    	assertEquals("same time different year", 1, 
    			event1.compareTo(event2));
    	
    	event2 = new Event("chess club", 2011, 2, 23, 1000, 1200);
    	assertEquals("different day different year", 1, 
    			event1.compareTo(event2));
    	
    	event2 = new Event("chess club", 2011, 2, 23, 800, 1000);
    	assertEquals("different day different time different year",
    			1, event1.compareTo(event2));
    	
    	event2 = new Event("chess club", 2012, 2, 23, 1000, 1200);
    	assertEquals("same time different day", -1, 
    			event2.compareTo(event1));    	
    }
    
    
    private static void testRemoveHead()
    {
    	testsSection("LinkedList removeHead tests");
    	
    	LinkedList list1 = new LinkedList();
    	list1.removeHead();
    	assertEquals("removed from empty list", "()", 
    			list1.toString());
    	
    	LinkedList list2 = new LinkedList();
    	Event event1 = new Event("chess club", 2011, 2, 23, 800, 
    			1000);
    	list2.insertAtHead(event1);
    	assertEquals("removed from list with 1 item", 
    			event1.toString(), 
    			list2.removeHead().toString());
    	
    	Event event2 = new Event("book club", 2012, 2, 24, 1000, 
    			1200);
    	list2.insertAtHead(event1);
    	list2.insertAtHead(event2);
    	assertEquals("revmoed from list with >1 item", 
    			event2.toString(), 
    			list2.removeHead().toString());
    }
    
    private static void testInsertAtTail()
    {
    	testsSection("LinkedList insertAtTail tests");
    	
    	LinkedList list3 = new LinkedList();
    	Event event3 = new Event("book club", 2012, 2, 24, 1000, 
    			1200);
    	list3.insertAtTail(event3);
    	assertEquals("insert on empty list", "(book club  2/24/"
    			+ "2012  1000-1200)", list3.toString());
    	
    	LinkedList list4 = new LinkedList();
    	Event event4 = new Event("chess club", 2011, 2, 23, 800, 
    			1000);
    	list4.insertAtHead(event3);
    	list4.insertAtTail(event4);
    	assertEquals("insert on non-empty list", "(book club  "
    			+ "2/24/2012  "
    			+ "1000-1200,\nchess club  2/23/2011  800-1000)", 
    			list4.toString());    	
    }
    
    private static void testSearch()
    {
    	testsSection("LinkedList search tests");
    	
    	LinkedList list4 = new LinkedList();
    	Event event1 = new Event("book club", 2012, 2, 24, 1000, 
    			1200);
    	Event event2 = new Event("chess club", 2011, 2, 23, 800, 
    			1000);
    	assertEquals("search in empty list", -1, list4.search(
    			event1.getName()));
    	
    	LinkedList list5 = new LinkedList();
    	list5.insertAtHead(event1);
    	assertEquals("search in 1-item list (found)", 1000, 
    			list5.search(event1.getName()));
    	assertEquals("search in 1-item list (not found)", -1, 
    			list5.search(event2.getName()));
    	
    	for (int i = 0; i < 4; i++)
    	{
    		list5.insertAtHead(event2);
    	}
    	assertEquals("search in list with >1 of the same event "
    			+ "name",
    			800, list5.search(event2.getName()));
    	
    }
    
    
    /***********  TESTING TOOLS ****************/
    
    /**
     * Each of the assertEquals methods tests whether the actual
     * result equals the expected result.  If it does, then the test
     * passes, otherwise it fails.  If VERBOSE is true, then complete
     * information is printed, whether the tests passes or fails.  If
     * VERBOSE is false, only failures are printed.
     *
     * The only difference between these methods is the types of the
     * parameters.  All take a String message and two values of the
     * same type (either boolean, int, or String) to compare:
     *
     * @param message a message or description of the test
     * @param expected the correct, or expected, value
     * @param actual the actual value
     */
    private static void assertEquals(String message, 
				    boolean expected, boolean actual)
    {
    	printTestCaseInfo(message, "" + expected, "" + actual);
    	if (expected == actual) {
    		pass();
    	} else {
    		fail(message);
    	}
    }

    private static void assertEquals(String message, 
				    int expected, int actual)
    {
    	printTestCaseInfo(message, "" + expected, "" + actual);
    	if (expected == actual) {
    		pass();
    	} else {
    		fail(message);
    	}
    }
    
    private static void assertEquals(String message, 
				    String expected, String actual)
    {
    	printTestCaseInfo(message, expected, actual);
	
    	if (expected == null) {
    		if (actual == null) {
    			pass();
	    	} else {
	    		fail(message);
	    	}
    	} 
    	else if (expected.equals(actual)) {
    		pass();
    	} 
		else {
			fail(message);
		}
    }
    
    private static void printTestCaseInfo(String message, 
					  String expected, String actual)
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
    	System.out.println("FAIL");
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
