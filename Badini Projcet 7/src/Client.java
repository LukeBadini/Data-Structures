/**
 * The main method you use to run your experiments is here. You should study
 * this code to see what's going on and modify it in MANY WAYS to thoroughly
 * test each sort routine. See the assignment for suggestions of ways to modify
 * this code.
 * 
 * @author Aaron Cass and Kristina Striegnitz based on a version by Chris Fernandes
 * @version 5/21/2013
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;

public class Client
{
    public static void main(String[] args) throws IOException {
	sandbox();
    }

    public static void sandbox() throws IOException
    {
    	PrintWriter writer = new PrintWriter(new FileWriter("output.csv"));
    	// Random array sorting
    	writer.println("Random Arrays");
    	writer.println("Method 1, , ,Method 2, ,Method3, ,Method4"
    			+ ", ,Method5, ,Method6");
    	writer.println("Length,Time,Operations,Time,Operations,"
    			+ "Time,Operations,Time,Operations,"
    			+ "Time,Operations,Time,Operations");
    	for (int i = 313; i < 650000; i = i*2)
    	{
    		int[] A, B = null;
    		int n;

    		// create a random array of n integers
    		n = i;
    		A = new int[n];
    		for (int j = 0; j < n; j++) 
    		{
    			A[j] = (int) (-1000 * Math.random());
    		}
    		// uncomment the following two lines if you wish to see the
    		// elements of the array A.
    		//	 System.out.println("initial array:");
    		//	 printArray(A);
    		System.out.println("For a random array of length " + n + ":\n");
    	
    		Sorter[] sortMethods = initializeSortMethods();

    		writer.print(n + "," + timeSorting(sortMethods, 1, A));
    		writer.print(n + "," + timeSorting(sortMethods, 2, A));
    		writer.print(n + "," + timeSorting(sortMethods, 3, A));
    		writer.print(n + "," + timeSorting(sortMethods, 4, A));
    		writer.print(n + "," + timeSorting(sortMethods, 5, A));
    		writer.print(n + "," + timeSorting(sortMethods, 6, A));
    		writer.println();
    	}
    	
    	// Identical number array sorting
    	writer.println("Identical Numbers");
    	writer.println("Method 1, , ,Method 2, ,Method3, ,Method4"
    			+ ", ,Method5, ,Method6");
    	writer.println("Length,Time,Operations,Time,Operations,"
    			+ "Time,Operations,Time,Operations,"
    			+ "Time,Operations,Time,Operations");
    	for (int i = 313; i < 650000; i = i*2)
    	{
    		int[] A, B = null;
    		int n;

    		// create an of n of identical integers
    		n = i;
    		A = new int[n];
    		for (int j = 0; j < n; j++) 
    		{
    			A[j] = 5;
    		}
    		// uncomment the following two lines if you wish to see the
    		// elements of the array A.
    		//	 System.out.println("initial array:");
    		//	 printArray(A);
    		System.out.println("For an array of identical numbers of length"
    				+ " " + n + ":\n");
    	
    		Sorter[] sortMethods = initializeSortMethods();

    		writer.print(n + "," + timeSorting(sortMethods, 1, A));
    		writer.print(n + "," + timeSorting(sortMethods, 2, A));
    		writer.print(n + "," + timeSorting(sortMethods, 3, A));
    		writer.print(n + "," + timeSorting(sortMethods, 4, A));
    		writer.print(n + "," + timeSorting(sortMethods, 5, A));
    		writer.print(n + "," + timeSorting(sortMethods, 6, A));
    		writer.println();
    	}
    	
    	// Sorted array sorting
    	writer.println("Sorted Array");
    	writer.println("Method 1, , ,Method 2, ,Method3, ,Method4"
    			+ ", ,Method5, ,Method6");
    	writer.println("Length,Time,Operations,Time,Operations,"
    			+ "Time,Operations,Time,Operations,"
    			+ "Time,Operations,Time,Operations");
    	for (int i = 313; i < 650000; i = i*2)
    	{
    		int[] A, B = null;
    		int n;

    		// create a sorted array of n integers
    		n = i;
    		A = new int[n];
    		for (int j = 0; j < n; j++) 
    		{
    			A[j] = j;
    		}
    		// uncomment the following two lines if you wish to see the
    		// elements of the array A.
    		//	 System.out.println("initial array:");
    		//	 printArray(A);
    		System.out.println("For a sorted array of length"
    				+ " " + n + ":\n");
    	
    		Sorter[] sortMethods = initializeSortMethods();

    		writer.print(n + "," + timeSorting(sortMethods, 1, A));
    		writer.print(n + "," + timeSorting(sortMethods, 2, A));
    		writer.print(n + "," + timeSorting(sortMethods, 3, A));
    		writer.print(n + "," + timeSorting(sortMethods, 4, A));
    		writer.print(n + "," + timeSorting(sortMethods, 5, A));
    		writer.print(n + "," + timeSorting(sortMethods, 6, A));
    		writer.println();
    	}
    	
    	// Reverse sorted array sorting
    	writer.println("Reverse Sorted Array");
    	writer.println("Method 1, , ,Method 2, ,Method3, ,Method4"
    			+ ", ,Method5, ,Method6");
    	writer.println("Length,Time,Operations,Time,Operations,"
    			+ "Time,Operations,Time,Operations,"
    			+ "Time,Operations,Time,Operations");
    	for (int i = 313; i < 650000; i = i*2)
    	{
    		int[] A, B = null;
    		int n;

    		// create a reverse sorted array of n integers
    		n = i;
    		A = new int[n];
    		for (int j = 0; j < n; j++) 
    		{
    			A[j] = n - j;
    		}
    		// uncomment the following two lines if you wish to see the
    		// elements of the array A.
    		//	 System.out.println("initial array:");
    		//	 printArray(A);
    		System.out.println("For a reverse sorted array of length"
    				+ " " + n + ":\n");
    	
    		Sorter[] sortMethods = initializeSortMethods();

    		writer.print(n + "," + timeSorting(sortMethods, 1, A));
    		writer.print(n + "," + timeSorting(sortMethods, 2, A));
    		writer.print(n + "," + timeSorting(sortMethods, 3, A));
    		writer.print(n + "," + timeSorting(sortMethods, 4, A));
    		writer.print(n + "," + timeSorting(sortMethods, 5, A));
    		writer.print(n + "," + timeSorting(sortMethods, 6, A));
    		writer.println();
    	}
    	writer.close();
    }

    private static Sorter[] initializeSortMethods() {
	Sorter[] sorts = new Sorter[7];

	sorts[1] = new Method1();
	sorts[2] = new Method2();
	sorts[3] = new Method3();
	sorts[4] = new Method4();
	sorts[5] = new Method5();
	sorts[6] = new Method6();

	return sorts;
    }

    /**
     * Times a sort method. Prints the time the sort method took as well as the
     * number of operations it took. Also prints a message if the resulting
     * array is not actually sorted.
     * 
     * @param sorters
     *            an array of sorters containing a Sorter to use.
     * @param sortMethodNum
     *            the index of the Sorter to use (from the sorters array)
     * @param toSort
     *            an array of ints to sort.
     */
    // changed this method to return a String
    private static String timeSorting(Sorter[] sorters, int sortMethodNum,
				    int[] toSort) {
	long startTime = System.currentTimeMillis();
	int[] B;

	B = sorters[sortMethodNum].sort(toSort);
	System.out.print("Method" + sortMethodNum + " time: ");
	System.out.print(System.currentTimeMillis() - startTime);
	System.out.println(", \tmethod" + sortMethodNum + " count: "
			   + sorters[sortMethodNum].getOperationCount());
	
	// to make sure it is sorted
	if (!isSorted(B)) {
	    System.out.println("  The array is not sorted.");
	    return null;
	}
	return (System.currentTimeMillis() - startTime) + "," + sorters[sortMethodNum].getOperationCount();
    }

    /**
     * printArray: prints the elements of array A to System.out. It prints 10
     * values per line
     * 
     * @param A
     *            the array to print
     */
    private static void printArray(int[] A) {
	System.out.println();
	for (int i = 0; i < A.length; i++) {
	    System.out.print(A[i] + ",  ");
	    if ((i + 1) % 10 == 0) {
		System.out.println();
	    }
	}
    }

    /**
     * tests if an array is sorted. If the array is not sorted, prints out the
     * two unsorted elements that it found.
     * 
     * @param A
     *            the array to test
     * @return true iff A is sorted from smallest to largest.
     */
    private static boolean isSorted(int[] A) {
	if (A == null)
	    return true;
	for (int i = 0; i < A.length - 1; i++)
	    if (A[i] > A[i + 1]) {
		System.out.print("A[" + i + "] = " + A[i] + " and A[" + (i + 1)
				 + "] = " + A[i + 1]);
		return false;
	    }
	return true;
    }
}
