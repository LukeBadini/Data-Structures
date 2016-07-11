/**
 * Defines the GenericLinkedList class and methods
 * @author Luke Badini
 * @version 5/13/2015
 * @param <T> the object type
 */
public class GenericLinkedList <T extends Comparable<T>>
{
	private GenericListNode<T> head;
	
	/**
	 * Default constructor for a GenericLinkedList
	 */
	public GenericLinkedList()
	{
		head = null;
	}
	
	/**
	 * Gets the size of the GenericLinkedList
	 * @return the size as an integer
	 */
	public int size()
	{
		int size = 0;
		GenericListNode<T> runner = head;
		
		if (runner == null)
		{
			return size;
		}
		else
		{
			while (runner != null)
			{
				runner = runner.next;
				size++;
			}
			return size;
		}
	}
	
	/**
	 * Adds a node to the GenericLinkedList at a specified index
	 * @param value; the value of the node
	 * @param index; the index the node is being added at
	 */
	public void add(T value, int index)
	{
		GenericListNode<T> aNode = new GenericListNode<T>(value);
		GenericListNode<T> runner = head;
		
		if (runner == null)
		{
			head = aNode;
		}
		else if (index < 0)
		{
			aNode.next = runner;
			head = aNode;
		}
		else
		{
			runner = findNodeBefore(index);
			aNode.next = runner.next;
			runner.next = aNode;
		}
		
	}
	
	/**
	 * Inserts a new node in the correct spot such that all 
	 * elements before toAdd are “smaller or equal” according to the 
	 * compareTo method defined for typeT and all elements after 
	 * toAdd are “greater or equal” according to the compareTo 
	 * method defined for type T.
	 * 
	 * @param value the value of the data being added
	 */
	public void insertSorted (T value)
	{
		GenericListNode<T> runner = head;
		int compare = -1;
		int indexCounter = 0;
		while (compare < 0 && runner != null)
		{
			compare = runner.data.compareTo(value);
			runner = runner.next;
			indexCounter++;
		}
		this.add(value, indexCounter);
		
	}
	
	/**
	 * Removes the node at the current index from the GenericLinkedList
	 * @param index; the index of the node being removed
	 * @return the data in the removed node
	 */
	public T remove(int index)
	{
		GenericListNode<T> runner = findNodeBefore(index);
		GenericListNode<T> removedNode = findNodeAt(index);
		
		if (runner == null)
		{
			return null;
		}
		if (index != 0)
		{
			if(removedNode.next == null)
			{
				runner.next = null;
				return removedNode.data;
			}
			else
			{
				runner.next = removedNode.next;
				return removedNode.data;
			}
		}
		else
		{
			if (removedNode.next != null)
			{
				head = removedNode.next;
				return removedNode.data;
			}
			else
			{
				head = null;
				return removedNode.data;
			}
		}
	}
	
	/**
	 * Finds the first node whose data match value and returns the data
	 * 
	 * @param value the value to be found
	 * @return the value of the data if it is found and null if it is
	 *         not found
	 */
	public T find(T value)
	{
		GenericListNode<T> runner = head;
		while (runner.data.compareTo(value) != 0 && runner.next != null)
		{
			runner = runner.next;
		}
		if (runner.data.compareTo(value) == 0)
		{
			return runner.data;
		}
		else
		{
			return null;
		}
	}
	
	/**
	 * Finds the first node whose data match value and removes it
	 * 
	 * @param value; the value to be found and removed
	 * @return true if the item was found and removed, false otherwise
	 */
	public boolean findRemove(T value)
	{
		GenericListNode<T> runner = head;
		int indexCounter = 0;
		
		while (runner.data.compareTo(value) != 0 && runner.next != null)
		{
			runner = runner.next;
			indexCounter++;
		}
		if (runner.data.compareTo(value) == 0)
		{
			this.remove(indexCounter);
			return true;
		}
		return false;
	}
	
	/**
	 * @return the GenericLinkedList as a string
	 */
	public String toString()
	{
		String listAsString = "{";
		GenericListNode<T> runner = head;
		int counter = 0;
		
		while (counter < this.size())
		{
			listAsString += runner.data;
			if (counter < this.size() - 1)
			{
				listAsString += "\n";
			}
			runner = runner.next;
			counter++;
		}
		listAsString += "}";
		return listAsString;
	}
	
	/**
	 * Gets the node at the specified index
	 * @param index; the specified index
	 * @return the node at index
	 */
	private GenericListNode<T> findNodeAt(int index)
	{
		GenericListNode<T> runner = head;
		int counter = 0;
		while (counter < index && runner.next != null)
		{
			runner = runner.next;
			counter++;
		}
		return runner;
	}
	
	/**
	 * Gets the node 1 before  the specified index
	 * @param index; specified index
	 * @return the node 1 before index
	 */
	private GenericListNode<T> findNodeBefore(int index)
	{
		GenericListNode<T> runner = head;
		int counter = 0;
		while (counter < (index - 1) && runner.next != null)
		{
			runner = runner.next;
			counter++;
		}
		return runner;
	}
}
