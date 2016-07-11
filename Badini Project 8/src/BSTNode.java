/**
 * A generic node class used for binary search trees
 * 
 * @author Luke Badini
 * @version 5/29/2015
 * @param <T> the object type
 */
public class BSTNode<T>
{
	public T data;
	public BSTNode<T> leftChild;
	public BSTNode<T> rightChild;
	
	/**
	 * Non-default constructor of a BSTNode
	 * Filled with element and pointing to null
	 */
	public BSTNode(T element)
	{
		data = element;
		leftChild = null;
		rightChild = null;
	}
	
	/**
	 * Non-default constructor of a BSTNode
	 * Filled with element and leftChild pointing to aNode
	 * and rightChild pointing to anotherNode
	 */
	public BSTNode(T element, BSTNode<T> aNode, 
			BSTNode<T> anotherNode)
	{
		data = element;
		leftChild = aNode;
		rightChild = anotherNode;
	}
	
	/**
	 * @return the BSTNode's data as a Sting
	 */
	public String toString()
	{
		return data.toString();
	}
}
