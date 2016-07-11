
/**
 * The main method you use to run your experiments is here.
 * You should study this code to see what's going on and
 * modify it in MANY WAYS to thoroughly test each sort routine.
 * See the assignment for suggestions of ways to modify this code.
 * 
 * @author Chris Fernandes
 * @version 2/27/13
 */
public class Client
{
	public static void main(String[] args) 
	{
		int[] A, B = null;
		int n;
		long startTime;
		
		//create a random array of n integers
		n = 640000;
		A = new int[n];
		for (int i = 0; i < n; i++)
			A[i] = (int) (-1000*Math.random());
		//uncomment the following two lines if you wish to see the
		//elements of the array A.
		//System.out.println("initial array:");
		//printArray(A);
		System.out.println("For a random array of length " + n + ":\n");
		
		//time method1
		startTime = System.currentTimeMillis();
		B = LabSort.method1(A);
		System.out.print("\nmethod1 time:");
		System.out.print(System.currentTimeMillis() - startTime);
		System.out.print(", \tmethod1 count: " + LabSort.getMethod1Count());
		//to make sure it is sorted
		if( ! isSorted(B) )
			System.out.println("  The array is not sorted.");

	}
	
	//-----------------------------
	/** prints the elements of array A to System.out.
	 *  It prints 10 values per line
	 * 
	 *  @param A array to print
	 */
	private static void printArray(int[] A)
	{
		System.out.println();
		for( int i = 0; i < A.length; i++ ) {
			System.out.print(A[i] + ",  ");
			if( (i+1) % 10 == 0 )
				System.out.println();
		}
	}
	
	//-----------------------------
	/** tests array A to see whether it is sorted.  
	 *  Returns true if A is sorted from smallest to largest.
	 *  If A is not sorted, it prints out the two unsorted
	 *  elements that it found and then returns false.
	 *  
	 *  @param A the array to test
	 *  @return true if sorted, false if not
	 */
	private static boolean isSorted(int[] A)
	{
		if(A == null) return true;
		for( int i = 0; i < A.length-1; i++ )
			if( A[i] > A[i+1] ) {
				System.out.print("A[" + i + "] = " + A[i] +
								" and A[" + (i+1) + "] = " + A[i+1]);
				return false;
			}
		return true;
	}
}
