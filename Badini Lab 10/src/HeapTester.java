/**
 * Driver for the heap lab
 * 
 * @author Luke Badini, Chris Fernandes, and Aaron Cass
 * @version 3/13/13
 */
import java.util.Arrays;
public class HeapTester
{
	public static final boolean VERBOSE = true;
    
    public static void main(String[] args)
    {
    	System.out.println("***Starting Heap Tests***");
    	shallowHeap();
    	emptyHeap();
    	alreadyAHeap();
    	minHeap();
    	
    	System.out.println("***Starting Sort Tests***");
    	// since I couldn't get deleteRoot working, none of these
    	// will work
    	sortUnique();
    	sortSorted();
    	sortDuplicates();
    	sortEmpty();
    	sortReverse();
    	
    	
    	System.out.println("Tests Complete");
    }
    
	/**
	 * Heap tests
	 */
    private static void shallowHeap()
    {
    	testsSection("heap test: subtree root swaps just once");
	
    	int[] anArray = {11, 12, 5, 1, 23, 33, 9, 21, 14, 10, 4};	
        printArray("before building heap:",anArray);
	
        Heap sample = new Heap(anArray);
		
    	assertEquals("shallowHeap: after building heap",
    			"33\n23 11\n21 12 5 9\n1 14 10 4", sample.toString());
    }
    
    private static void emptyHeap()
    {
    	testsSection("heap test: empty heap");
    	
    	int[] anArray = {};
    	
    	Heap sample = new Heap(anArray);
    	
    	assertEquals("emptyHeap: after building heap", "0", sample.toString());
    }
    
    private static void alreadyAHeap()
    {
    	testsSection("heap test: tree is already a heap");
    	
    	int[] anArray = {33, 23, 11, 21, 12, 5, 9, 1, 14, 10, 4};
    	printArray("before building heap:",anArray);
    	
    	Heap sample = new Heap(anArray);
    	
    	assertEquals("alreadyAHeap: after building heap",
    			"33\n23 11\n21 12 5 9\n1 14 10 4", sample.toString());
    }
    
    private static void minHeap()
    {
    	testsSection("minHeap: tree is a minHeap");
    	
    	int[] anArray = {1, 2, 3, 4, 5, 6, 7, 8};
    	printArray("before building heap:",anArray);
    	
    	Heap sample = new Heap(anArray);
    	
    	assertEquals("minHeap: after buidling heap",
    			"8\n5 7\n4 1 6 3\n2", sample.toString());
    }
    
    /**
     * Sort tests
     */
    private static void sortUnique()
    {
    	testsSection("sort test: random, no duplicates");
	
    	int[] unsorted = {11, 12, 5, 1, 23, 33, 9, 21, 14, 10};
    	printArray("before sorting",unsorted);
        int[] sorted = Sorter.priorityQueueSort(unsorted);
        int[] answer = {1, 5, 9, 10, 11, 12, 14, 21, 23, 33};

        assertEquals("sortUnique: after sorting", answer, sorted);
    }
    
    private static void sortSorted()
    {
    	testsSection("sort test: sorted PQ");
    	
    	int[] initial = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    	printArray("before sorting", initial);
    	int[] sorted = Sorter.priorityQueueSort(initial);
    	int[] answer = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    	
    	assertEquals("sortSorted: after sorting", answer, sorted);
    }
    
    private static void sortDuplicates()
    {
    	testsSection("sort test: duplicates");
    	
    	int[] initial = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    	printArray("before sorting", initial);
    	int[] sorted = Sorter.priorityQueueSort(initial);
    	int[] answer = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    	
    	assertEquals("sortDuplicate: after sorting", answer, sorted);
    }
    
    private static void sortEmpty()
    {
    	testsSection("sort test: empty PQ");
    	
    	int[] initial = {};
    	printArray("before sorting", initial);
    	int[] sorted = Sorter.priorityQueueSort(initial);
    	int[] answer = {};
    	
    	assertEquals("sortEmpty: after sorting", answer, sorted);
    }
    
    private static void sortReverse()
    {
    	testsSection("sort test: reverse-sorted PQ");
    	
    	int[] initial = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    	printArray("before sorting", initial);
    	int[] sorted = Sorter.priorityQueueSort(initial);
    	int[] answer = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    	
    	assertEquals("sortReverse: after sorting", answer, sorted);
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
     * same type (either boolean, int, Object, or String) to compare:
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
		    Object expected, Object actual)
    {
    	printTestCaseInfo(message, "" + expected, "" + actual);
    	
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
    
    private static void assertEquals(String message, 
    		int[] expected, int[] actual)
    {
    	printTestCaseInfo(message, Arrays.toString(expected), Arrays.toString(actual));
    	if (Arrays.equals(expected,actual)) {
    		pass();
    	} else {
    		fail(message);
    	}
    }
    
    private static void printTestCaseInfo(String message, 
					  String expected, String actual)
    {
    	if (VERBOSE) {
    		System.out.println(message + ":");
    		System.out.println("expected:\n" + expected);
    		System.out.println("\nactual:\n" + actual);
		}
    }
    
    /** 
     *  prints an array
     *  @param message string to print before printing array
     *  @param array the array of ints to be printed
     */
    private static void printArray(String message, int[] array) 
    {
    	if (VERBOSE) {
    		System.out.println(message);
    		int len = array.length;
    		for (int i = 0; i < len - 1; i++) {
    			System.out.print(array[i] + " ");
    		}
    		System.out.println(array[len-1] + "\n");
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