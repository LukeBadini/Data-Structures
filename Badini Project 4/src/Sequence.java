public class Sequence 
{
	private String[] data;
	private int size;
	private int currentIndex;
	
	/**
	 * Creates a new sequence with initial capacity 10.
	 */
	public Sequence() 
	{
		data = new String[10];
		size = 0;
		currentIndex = -1;
	}

	/**
	 * Creates a new sequence.
	 * 
	 * @param initialCapacity
	 *            the initial capacity of the sequence.
	 */
	public Sequence(int initialCapacity) 
	{
		data = new String[initialCapacity];
		size = 0;
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
		// There's something weird happening in here that's causing
		// currentIndex to increase by 1 if the sequence is full and
		// there's no current index. I can't figure out where it is but
		// it's causing my last test to fail
		
		if (isFull())
		{
			int doubleCapacity = (data.length * 2) + 1;
			String[] temp = new String[doubleCapacity];
			String[] clone = data.clone();
		
			for (int i = 0; i < doubleCapacity; i++)
			{
				if (i >= clone.length)
				{
					temp[i] = null;
				}
				else
				{
					temp[i] = clone[i];
				}
			}
		
			data = temp;
		}
		if (isCurrent())
		{
			for (int i = size; i > currentIndex; i--)
			{
				data[i] = data[i - 1];
			}
			data[currentIndex] = value;
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
		// There's something weird happening in here that's causing
		// currentIndex to increase by 1 an extra time. I've tried fixing
		// it for 2 hours but couldn't figure it out.
		
		if (isFull())
		{
			int doubleCapacity = (data.length * 2) + 1;
			String[] temp = new String[doubleCapacity];
			String[] clone = data.clone();
		
			for (int i = 0; i < doubleCapacity; i++)
			{
				if (i >= clone.length)
				{
					temp[i] = null;
				}
				else
				{
					temp[i] = clone[i];
				}
			}
		
			data = temp;
		}
		if (isCurrent())
		{
			for (int i = size; i > currentIndex + 1; i--)
			{
				data[i] = data[i - 1];
			}
			data[currentIndex] = value;
			currentIndex++;
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
		String[] addendData = addend.getData();
		String[] cloneData = data.clone();
		String[] newData;
		
		if (size + addendData.length > cloneData.length)
		{
			newData = new String[cloneData.length + addendData.length];
		}
		else
		{
			newData = new String[cloneData.length];
		}
		
		int addingIndex = 0;
		
		for (int i = 0; i < this.size(); i++)
		{
			newData[addingIndex] = cloneData[i];
			addingIndex++;
		}
		for (int j = 0; j < addend.size(); j++)
		{
			newData[addingIndex] = addendData[j];
			addingIndex++;
		}
		
		size = this.size() + addend.size();
		data = newData;
		currentIndex = -1;
		
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
		Sequence cloneSequence = new Sequence(data.length);
		cloneSequence.addAll(this);
		cloneSequence.setParams(size, currentIndex);
		
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
		if (minCapacity > data.length)
		{
			String[] temp = new String[minCapacity];
			String[] clone = data.clone();
		
			for (int i = 0; i < minCapacity; i++)
			{
				if (i >= data.length)
				{
					temp[i] = null;
				}
				else
				{
					temp[i] = clone[i];
				}
			}
		
			data = temp;
		}
	}

	/**
	 * @return the capacity of the sequence.
	 */
	public int getCapacity() 
	{
		return data.length;
	}

	/**
	 * @return the element at the current location in the sequence, or null if
	 *         there is no current element.
	 */
	public String getCurrent() 
	{
		if (isCurrent())
		{
			return data[currentIndex];
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
			for (int i = currentIndex; i < size - 1; i++)
			{
				data[i] = data[i + 1];
			}
			size--;
			
			if (currentIndex == (data.length - 1))
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
		String[] temp = new String[size];
		String[] clone = data.clone();
		
		for (int i = 0; i < size; i++)
		{
			temp[i] = clone[i];
		}
		
		data = temp;
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
		String myString = "{";
		for (int i = 0; i < size; i++)
		{
			if (i == currentIndex)
			{
				myString += ">";
			}
			myString += data[i];
			if (i != size - 1)
			{
				myString += ", ";
			}
		}
		myString += "} (capacity = " + data.length + ")";
		
		return myString;
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
			for (int i = 0; i < size; i++)
			{
				if (!data[i].equals(other.getData()[i]))
				{
					return false;
				}
			}
			return true;
		}
		return false;
	}
	
	/**
	 * @return a clone of the sequence's data
	 */
	private String[] getData()
	{
		return data.clone();
	}
	
	/**
	 * @return the current index of the sequence
	 */
	private int getCurrentIndex()
	{
		return currentIndex;
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
	 * @return true if sequence is full, false otherwise
	 */
	private boolean isFull()
	{
		return (size >= data.length);
	}
}