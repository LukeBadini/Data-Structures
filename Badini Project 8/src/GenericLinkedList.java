/**
 * Defines the GenericLinkedList class and methods
 * @author Luke Badini
 * @version 5/30/2015
 * @param <T> the object type
 */
public class GenericLinkedList <T extends Comparable<T>>
{
	private GenericListNode<T> head;
	private int size;
	
	/**
	 * Default constructor for a GenericLinkedList
	 */
	public GenericLinkedList()
	{
		head = null;
		size = 0;
	}
	
	/**
	 * @return the size of the GenericLinkedList
	 */
	public int size()
	{
		return size;
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
		size++;
		
	}
	
	/**
	 * Adds a new element to the end of the list
	 * @param toAdd; the data of the node to be added
	 */
	public void addAtTail(T toAdd)
	{
		this.add(toAdd, size - 1);
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
		if (head == null)
		{
			return null;
		}
		
		GenericListNode<T> runner = head;
		while (runner != null && runner.data.compareTo(value) != 0)
		{
			runner = runner.next;
		}
		if (runner == null)
		{
			return null;
		}
		else
		{
			return runner.data;
		}
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
				listAsString += ", ";
			}
			runner = runner.next;
			counter++;
		}
		listAsString += "}";
		return listAsString;
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
