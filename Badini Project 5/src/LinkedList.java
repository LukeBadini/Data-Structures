/**
 * Defines the LinkedList class and methods
 * @author Luke Badini
 * @version 5/6/2015
 *
 */
public class LinkedList 
{
	private LinkNode head;
	
	public LinkedList()
	{
		head = null;
	}
	
	/**
	 * Gets the size of the LinkedList
	 * @return the size as an integer
	 */
	public int size()
	{
		int size = 0;
		LinkNode runner = head;
		
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
	 * Gets the data stored at the LinkNode at a specified index
	 * @param index; the index of the node being used
	 * @return the data in the node at index
	 */
	public String get(int index)
	{
		LinkNode runner = head;
		
		if (runner == null)
		{
			return null;
		}
		else
		{
			runner = findNodeAt(index);
			return runner.data;
		}
	}
	
	/**
	 * Sets the data stored at the LinkNode at a specified index
	 * @param value; the new value of the data
	 * @param index; the index of the node being used
	 */
	public void set(String value, int index)
	{
		LinkNode runner = head;
		
		if (runner == null)
		{
			head = new LinkNode(value);
		}
		else
		{
			runner = findNodeAt(index);
			runner.data = value;
		}
	}
	
	/**
	 * Adds a node to the LinkedList at a specified index
	 * @param value; the value of the node
	 * @param index; the index the node is being added at
	 */
	public void add(String value, int index)
	{
		LinkNode aNode = new LinkNode(value);
		LinkNode runner = head;
		
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
	 * Removes the node at the current index from the LinkedList
	 * @param index; the index of the node being removed
	 * @return the data in the removed node as a string
	 */
	public String remove(int index)
	{
		LinkNode runner = findNodeBefore(index);
		LinkNode removedNode = findNodeAt(index);
		
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
	 * @return the LinkedList as a string
	 */
	public String toString()
	{
		String listAsString = "{";
		LinkNode runner = head;
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
	 * Gets the node at the specified index
	 * @param index; the specified index
	 * @return the node at index
	 */
	private LinkNode findNodeAt(int index)
	{
		LinkNode runner = head;
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
	private LinkNode findNodeBefore(int index)
	{
		LinkNode runner = head;
		int counter = 0;
		while (counter < (index - 1) && runner.next != null)
		{
			runner = runner.next;
			counter++;
		}
		return runner;
	}
}
