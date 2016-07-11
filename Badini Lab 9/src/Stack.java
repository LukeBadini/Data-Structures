/**
 * A Stack ADT that stores elements using a LinkedList
 * 
 * @author Luke Badini
 * @version 5/28/2015
 * @param <T> the data type of the Stack
 */
public class Stack<T> 
{
	private LinkedList<T> data;
	
	/**
	 * Default constructor
	 */
	public Stack()
	{
		data = new LinkedList<T>();
	}
	
	/**
	 * @return the size of the stack
	 */
	public int size()
	{
		return data.size();
	}
	
	/**
	 * @return true if the Stack is empty, false otherwise
	 */
	public boolean isEmpty()
	{
		return data.isEmpty();
	}
	
	/**
	 * Adds an item to the top of the stack
	 * @param item; the item to be added
	 */
	public void push(T item)
	{
		data.insertAtHead(item);
	}
	
	/**
	 * Removes an item from the top of the stack
	 * @param item; the item to be removed
	 */
	public T pop()
	{
		return data.removeHead();
	}
	
	/**
	 * @return the item at the top of the stack
	 */
	public T top()
	{
		return data.elementAtHead();
	}
}
