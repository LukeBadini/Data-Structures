/**
 * Sequence ADT
 * @author Luke Badini
 * @version 5/10/2015
 *
 * INVARIANTS
 * 1. The number of elements in the sequence is stored in the instance
 *    variable manyItems
 *    
 * 2. If there is a current element, then it lies in data at node number
 *    currentIndex; if there is no current element, then currentIndex 
 *    equals -1
 *    
 * 3. For an empty sequence, we do not care what is stored in data. For
 *    a non-empty sequence, the elements are stored from the front to 
 *    the end from the 0th node to the (manyItems - 1)th node
 */
public class Sequence 
{
	private LinkedList data;
	private int size;
	private int capacity;
	private final int DEFAULT_CAPACITY = 10;
	private int currentIndex;
	
	/**
	 * Creates a new sequence with a capacity of 10
	 */
	public Sequence()
	{
		data = new LinkedList();
		size = 0;
		capacity = DEFAULT_CAPACITY;
		currentIndex = -1;
	}
	
	/**
	 * Creates a new sequence
	 * @param initialCapacity; the initial capacity of the sequence
	 */
	public Sequence(int initialCapacity)
	{
		data = new LinkedList();
		size = 0;
		capacity = initialCapacity;
		currentIndex = -1;
	}
	
	/**
	 * Adds a string to the sequence in the location before the current element.
	 * If the sequence has no current element, the string is added to the
	 * beginning of the sequence.
	 * 
	 * The added element becomes the current element.
	 * 
	 * If the sequences's capacity has been reached, the sequence will expand to
	 * twice its current capacity plus 1.
	 * 
	 * @param value
	 *            the string to add.
	 */
	public void addBefore(String value)
	{
		if (isFull())
		{
			capacity = (capacity * 2) + 1;
		}
		if (isCurrent())
		{
			data.add(value, (currentIndex - 1));
			size++;
		}
		else
		{
			currentIndex = 0;
			this.addBefore(value);
		}
	}
	
	/**
	 * Adds a string to the sequence in the location after the current element.
	 * If the sequence has no current element, the string is added to the end of
	 * the sequence.
	 * 
	 * The added element becomes the current element.
	 * 
	 * If the sequences's capacity has been reached, the sequence will expand to
	 * twice its current capacity plus 1.
	 * 
	 * @param value
	 *            the string to add.
	 */
	public void addAfter(String value)
	{
		if (isFull())
		{
			capacity = (capacity * 2) + 1;
		}
		if (isCurrent())
		{
			data.add(value, currentIndex);
			currentIndex++;
			if (currentIndex == (size - 1))
			{
				currentIndex--;
			}
			size++;
		}
		else
		{
			currentIndex = size;
			this.addAfter(value);
		}
	}
	
	/**
	 * Places the contents of another sequence at the end of this sequence.
	 * 
	 * If adding all elements of the other sequence would exceed the capacity of
	 * this sequence, the capacity is changed to make room for all of the
	 * elements to be added.
	 * 
	 * @param addend
	 *            the sequence whose contents should be added.
	 */
	public void addAll(Sequence addend)
	{
		LinkedList addendData = addend.getData();
		LinkedList cloneData = this.getData();
		LinkedList newData = new LinkedList();
		int addingIndex = 0;
		
		for (int i = 0; i < this.size(); i++)
		{
			newData.add(cloneData.get(i), i);
			addingIndex++;
		}
		for (int i = 0; i < addend.size(); i++)
		{
			newData.add(addendData.get(i), addingIndex);
			addingIndex++;
		}
		if (size + addend.size() > capacity)
		{
			capacity = addendData.size() + cloneData.size();
		}
		size = this.size() + addend.size();
		data = newData;
	}
	
	/**
	 * Move forward in the sequence so that the current element is now the next
	 * element in the sequence.
	 * 
	 * If the current element was already the end of the sequence, then
	 * advancing causes there to be no current element.
	 * 
	 * Precondition: should only be called when there is a current element.
	 */
	public void advance() 
	{
		currentIndex++;
		if (currentIndex >= size)
		{
			currentIndex = -1;
		}
	}
	
	/**
	 * Make a copy of this sequence. Subsequence changes to the copy do not
	 * affect the current sequence, and vice versa.
	 * 
	 * @return the copy of this sequence.
	 */
	public Sequence clone() 
	{
		Sequence cloneSequence = new Sequence(this.capacity);
		cloneSequence.addAll(this);
		cloneSequence.setParams(this.size, this.currentIndex);
		
		return cloneSequence;
	}
	
	/**
	 * Create a new sequence that contains all of the elements of one sequence
	 * followed by all of the elements of another sequence.
	 * 
	 * The new sequence does not have a current element. The new sequence has
	 * capacity equal to the sum of the capacities of the sequences being
	 * concatenated.
	 * 
	 * @param s1
	 *            the sequence whose elements should come first in the
	 *            concatenation
	 * @param s2
	 *            the sequence whose elements should come second
	 */
	public static Sequence concatenation(Sequence s1, Sequence s2) 
	{
		Sequence s1Clone = s1.clone();
		Sequence s2Clone = s2.clone();
		
		s1Clone.addAll(s2Clone);
		s1Clone.trimToSize();
		s1Clone.setParams(s1Clone.size(), -1);
		
		return s1Clone;
	}
	
	/**
	 * Change the current capacity of this sequence. The sequence's capacity
	 * will be changed to be at least a minimum capacity.
	 * 
	 * @param minCapacity
	 *            the minimum capacity that the sequence should now have.
	 */
	public void ensureCapacity(int minCapacity) 
	{
		if (minCapacity > capacity)
		{
			capacity = minCapacity;
		}
	}
	
	/**
	 * @return the capacity of the sequence.
	 */
	public int getCapacity() 
	{
		return capacity;
	}
	
	/**
	 * @return the element at the current location in the sequence, or null if
	 *         there is no current element.
	 */
	public String getCurrent() 
	{
		if (isCurrent())
		{
			return data.get(currentIndex);
		}
		else
		{
			return null;
		}
	}
	
	/**
	 * @return true if and only if the sequence has a current element.
	 */
	public boolean isCurrent() 
	{
		return (currentIndex >= 0);
	}
	
	/**
	 * Remove the current element from this sequence. The following element, if
	 * there was one, becomes the current element. If there was no following
	 * element (current was at the end of the sequence), the sequence now has no
	 * current element.
	 * 
	 * If there is no current element, does nothing.
	 */
	public void removeCurrent() 
	{
		if (isCurrent())
		{
			data.remove(currentIndex);
			size--;
			
			if (currentIndex == (capacity - 1))
			{
				currentIndex = -1;
			}
		}
	}
	
	/**
	 * @return the number of elements stored in the sequence.
	 */
	public int size() 
	{
		return size;
	}
	
	/**
	 * Sets the current element to the start of the sequence. If the sequence is
	 * empty, the sequence has no current element.
	 */
	public void start() 
	{
		if (size == 0)
		{
			currentIndex = -1;
		}
		else
		{
			currentIndex = 0;
		}
	}
	
	/**
	 * Reduce the current capacity to its actual size, so that it has capacity
	 * to store only the elements currently stored.
	 */
	public void trimToSize() 
	{
		capacity = size;
	}
	
	/**
	 * Produce a string representation of this sequence. The current location is
	 * indicated by a >. For example, a sequence with "A" followed by "B", where
	 * "B" is the current element, and the capacity is 5, would print as:
	 * 
	 * {A, >B} (capacity = 5)
	 * 
	 * An empty sequence with a capacity of 10 would print as:
	 * 
	 * {} (capacity = 10)
	 * 
	 * @return a string representation of this sequence.
	 */
	public String toString() 
	{
		String cloneNodeData = data.get(currentIndex);
		if (isCurrent())
		{
			String currentData = ">" + data.get(currentIndex);
			data.set(currentData, currentIndex);
		}
		
		if (size != 0)
		{
			String myString = data.toString() + " (capacity = " + 
		capacity + ")";
			data.set(cloneNodeData, currentIndex);
			return myString;
		}
		else
		{
			return "{} (capacity = " + capacity + ")";
		}
	}
	
	/**
	 * Checks whether another sequence is equal to this one. To be considered
	 * equal, the other sequence must have the same elements, in the same order,
	 * and with the same element marked current. The capacity can differ.
	 * 
	 * @param other
	 *            the other Sequence with which to compare
	 * @return true iff the other sequence is equal to this one.
	 */
	public boolean equals(Sequence other)
	{
		if (size == other.size() && currentIndex == other.getCurrentIndex())
		{
			for (int i = 0; i < this.size(); i++)
			{
				if (!data.get(i).equals(other.data.get(i)))
				{
					return false;
				}
			}
			return true;
		}
		return false;
	}
	
	/**
	 * @return true if sequence is full, false otherwise
	 */
	private boolean isFull()
	{
		return (size >= capacity);
	}
	
	/**
	 * Sets the size and current index of a sequence
	 */
	private void setParams(int newSize, int newIndex)
	{
		size = newSize;
		currentIndex = newIndex;
	}
	
	/**
	 * @return a clone of the LinkedList of data from a sequence
	 */
	private LinkedList getData()
	{
		LinkedList cloneData = new LinkedList();
		for (int i = 0; i < this.size(); i++)
		{
			cloneData.add(data.get(i), i);
		}
		return cloneData;
	}
	
	/**
	 * @return the current index of the sequence
	 */
	private int getCurrentIndex()
	{
		return currentIndex;
	}
}
