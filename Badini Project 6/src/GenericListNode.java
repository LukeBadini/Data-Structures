/**
 * A generic node class used for linked lists
 * 
 * @author Luke Badini
 * @version 5/13/2015
 * @param <T> the object type
 */
public class GenericListNode<T>
{
	public T data;
	public GenericListNode<T> next;
	
	/**
	 * Non-default constructor of a GenericListNode
	 * Filled with element and pointing to null
	 */
	public GenericListNode(T element)
	{
		data = element;
		next = null;
	}
	
	/**
	 * Non-default constructor of a GenericListNode
	 * Filled with aString and pointing to aNode
	 */
	public GenericListNode(T element, GenericListNode<T> aNode)
	{
		data = element;
		next = aNode;
	}
}
