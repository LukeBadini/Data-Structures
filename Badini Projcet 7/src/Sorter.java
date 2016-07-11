
public interface Sorter 
{
	/**
	 * Sorts an array of ints.
	 * 
	 * @param toSort the array to sort, which is not altered by this method.
	 * @return a new array contining all of the elements from toSort, but in sorted order.
	 */
	public int [] sort (int [] toSort);
	
	/**
	 * @return the number of operations the most recent call to sort took.
	 */
	public long getOperationCount();
}
