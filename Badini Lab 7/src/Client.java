/** Tester for the LogBook, Event, and Reminder classes
 * 
 * @author Luke Badini, Aaron Cass, and Chris Fernandes
 * @version 5/14/15
 */
public class Client {
    public static final boolean VERBOSE = true;
    
    public static void main(String[] args)
    {
    	System.out.println("Starting Tests");

    	testReminder();
    	testLogBook();
    	testAlteringEvents();
	
    	System.out.println("Tests Complete");
    }
    
    private static void testReminder()
    {
    	testsSection("Reminder tests");
    	
    	Reminder aReminder = new Reminder("Go to the grocery store",
    			"01/23/2014");
    	assertEquals("toString test", "Go to the grocery store "
    			+ "01/23/2014", aReminder.toString());
    	assertEquals("getMonth test", 1, aReminder.getMonth());
    	assertEquals("getDay test", 23, aReminder.getDay());
    	assertEquals("getYear test", 2014, aReminder.getYear());
    }
    
    private static void testLogBook()
    {
    	testsSection("Log Book tests");
    	
    	LogBook aLogBook = new LogBook(1, 2015);
    	assertEquals("toString on empty LogBook", "1 2015\n", 
    			aLogBook.toString());
    	
    	Reminder aReminder = new Reminder("Go to the grocery store",
    			"01/23/2015");
    	assertEquals("insertEntry on empty LogBook", true, 
    			aLogBook.insertEntry(aReminder));
    	
    	Event anEvent = new Event("An event", 2015, 01, 23, 800,
    			900);
    	assertEquals("insertEntry on a day that already has an "
    			+ "event", false, aLogBook.insertEntry(anEvent));
    	
    	Reminder aReminder2 = new Reminder("Make a reminder", 
    			"01/12/1995");
    	assertEquals("insertEntry on a different year", false,
    			aLogBook.insertEntry(aReminder2));
    	
    	Event anEvent2 = new Event("A second event", 2015, 01, 33, 
    			800, 900);
    	assertEquals("insertEntry on an invalid day", false,
    			aLogBook.insertEntry(anEvent2));
    	assertEquals("getEntry on an event in the LogBook", true,
    			aReminder == aLogBook.getEntry(23));
    	
    	Reminder aReminder3 = new Reminder("another reminder", 
    			"01/12/2016");
    	assertEquals("getEntry on an event not in the LogBook",
    			false, aReminder3 == aLogBook.getEntry(12));
    	
    	assertEquals("toString on a non-empty LogBook", "1 2015\n"
    			+ "Go to the grocery store 01/23/2015\n",
    			aLogBook.toString());
    }
    
    // Altering events
    public static void alteringEvents(LogBook aLogBook)
    {
    	for(int i = 10; i < 16; i++)
    	{
    		if (aLogBook.getEntry(i) != null && 
    				aLogBook.getEntry(i) instanceof Event)
    		{
    			Event anEvent = (Event) aLogBook.getEntry(i);
    			anEvent.setStart(1600);
    			anEvent.setEnd(1730);
    		}
    	}
    }
    public static void testAlteringEvents()
    {
    	testsSection("Altering Events tests");
    	
    	LogBook aLogBook = new LogBook(01, 2015);
    	Event anEvent = new Event("An event", 2015, 01, 10, 800,
    			900);
    	aLogBook.insertEntry(anEvent);
    	System.out.print("Before:\n" + aLogBook.toString());
    	alteringEvents(aLogBook);
    	System.out.print("After:\n" + aLogBook.toString());
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
