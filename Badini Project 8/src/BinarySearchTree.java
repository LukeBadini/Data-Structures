/**
 * BinarySearchTree ADT that stores items using a GenericLinkedList
 * 
 * @author Luke Badini
 * @version 5/31/2015
 * @param <T> the object type
 */
public class BinarySearchTree<T extends Comparable<T>>
{
	private BSTNode<T> root;
	
	/**
	 * Default constructor for a BinarySearchTree
	 */
	public BinarySearchTree()
	{
		root = null;
	}
	
	/**
	 * Finds a specified value in the tree and returns it. If the
	 * item is not in the tree, returns null
	 * @param toFind; the item to be found
	 * @return the value of the item, null if the item isn't found
	 */
	public T find(T toFind)
	{
		BSTNode<T> cursor = root;
		return findHelper(toFind, cursor);
	}
	
	/**
	 * Helper method for the find method
	 */
	private T findHelper(T toFind, BSTNode<T> root)
	{
		if (root == null)
		{
			return null;
		}
		else if (toFind.compareTo(root.data) == 0)
		{
			return root.data;
		}
		else if (toFind.compareTo(root.data) < 0)
		{
			return findHelper(toFind, root.leftChild);
		}
		else
		{
			return findHelper(toFind, root.rightChild);
		}
	}
		
	/**
	 * Returns the tree as a String in pre-order
	 */
	public String showTree()
	{
		BSTNode<T> cursor = root;
		return preOrderToString(cursor, 0);
	}
	
	/**
	 * Helper method for showTree
	 * @param root; the root of the tree
	 * @param depth; the current depth
	 * @return the tree as a String in pre-order
	 */
	private String preOrderToString(BSTNode<T> root, int depth)
	{
		String preOrder = "";
		preOrder += printSpaces(depth);
		if (root != null)
		{
			preOrder += root.toString();
		}
		if (root.leftChild != null)
		{
			preOrder += "\n" + preOrderToString(root.leftChild, depth + 1);
		}
		if (root.rightChild != null)
		{
			preOrder += "\n" + preOrderToString(root.rightChild, depth + 1);
		}
		return preOrder;
		
	}
	
	/**
	 * Given an integer, returns a string containing that
	 * many spaces
	 */
	private String printSpaces(int spaces)
	{
		String toReturn = "";
		for (int i = 0; i < spaces; i++)
		{
			toReturn += " ";
		}
		return toReturn;
	}
	
	/**
	 * Adds the specified value into the tree
	 * @param toAdd; the value of the node to be added
	 */
	public void add(T toAdd)
	{
		BSTNode<T> cursor = root;
		BSTNode<T> nodeToAdd = new BSTNode<T>(toAdd);
		addHelper(nodeToAdd, cursor);
		
	}
	
	/**
	 * Helper method for the add method
	 */
	private void addHelper(BSTNode<T> nodeToAdd, BSTNode<T> root)
	{
		if (root == null)
		{
			this.root = nodeToAdd;
		}
		else if (nodeToAdd.data.compareTo(root.data) <= 0)
		{
			if (root.leftChild == null)
			{
				root.leftChild = nodeToAdd;
			}
			else
			{
				addHelper(nodeToAdd, root.leftChild);
			}
		}
		else
		{
			if (root.rightChild == null)
			{
				root.rightChild = nodeToAdd;
			}
			else
			{
				addHelper(nodeToAdd, root.rightChild);
			}
		}
	}
	
	/**
	 * @return the BST as a String
	 */
	public String toString()
	{
		BSTNode<T> cursor = root;
		String toReturn = toStringHelper(cursor, 0);
		if (toReturn.length() == 0)
		{
			return toReturn;
		}
		return toReturn.substring(0,toReturn.length() - 1);
	}
	
	
	/**
	 * Helper method for toString
	 * @param root; the root of the tree
	 * @return the tree as a String
	 */
	private String toStringHelper(BSTNode<T> root, int depth)
	{
		String inOrder = "";
		if (root == null)
		{
			return inOrder;
		}
		if (root.leftChild != null)
		{
			inOrder += toStringHelper(root.leftChild, depth + 1);
		}
	
		inOrder += root.toString() + "\n";
		
		if (root.rightChild != null)
		{
			inOrder += toStringHelper(root.rightChild, depth + 1);
		}
		return inOrder;
		
	}
	/**
	 * Given a value, removes a node containing that value 
	 * from the BST and returns the value stored in it
	 * @param toRemove; the value to be removed
	 * @return the removed value, null if the value isn't in the BST
	 */
	public T remove(T toRemove)
	{
		BSTNode<T> removedNode = new BSTNode<T>(toRemove);
		BSTNode<T> finder = findNode(removedNode);
		if (finder == null)
		{
			return null;
		}
		else if (root == finder && root.leftChild == null &&
				root.rightChild == null)
		{
			root = null;
			return toRemove;
		}
		else
		{
			BSTNode<T> cursor = root;
			return removeHelper(toRemove, cursor).data;
		}
	}
	
	/**
	 * Helper method for the remove method
	 */
	private BSTNode<T> removeHelper(T toRemove, BSTNode<T> root)
	{
		if (toRemove.compareTo(root.data) < 0)
		{
			root.leftChild = removeHelper(toRemove, root.leftChild);
		}
		else if (toRemove.compareTo(root.data) > 0)
		{
			root.rightChild = removeHelper(toRemove, root.rightChild);
		}
		else if (root.leftChild != null && 
				root.rightChild != null)
		{
			BSTNode<T> tempNode = findLargestInLeft(root.leftChild);
			root.data = tempNode.data;
			root.leftChild = removeHelper(root.data, root.leftChild);
		}
		else
		{
			if (root.leftChild == null)
			{
				root = root.rightChild;
			}
			else if (root.rightChild == null)
			{
				root = root.leftChild;
			}
				
		}
		return root;
	}

	/**
	 * Finds and returns the node with the largest value in a given
	 * node's left subtree.
	 * @param root; the node whose largest value is being found
	 * @return the node with the largest value in the root's 
	 * 		   left subtree. Null if the given node is null
	 */
	private BSTNode<T> findLargestInLeft(BSTNode<T> root)
	{
		if (root.rightChild == null)
		{
			return root;
		}
		else if (root.leftChild.rightChild != null)
		{
			return findLargestInLeft(root.leftChild.rightChild);
		}
		else
		{
			return root.leftChild;
		}
	}
		
	/**
	 * Finds a specified node in the tree and returns it. If the
	 * node is not in the tree, returns null
	 * @param toFind; the node to be found
	 * @return the specified node in the tree, null if the node
	 * 		   isn't found
	 */
	private BSTNode<T> findNode(BSTNode<T> toFind)
	{
		BSTNode<T> cursor = root;
		return findNodeHelper(toFind, cursor);
	}
	
	/**
	 * Helper method for the findNode method
	 */
	private BSTNode<T> findNodeHelper(BSTNode<T> toFind, 
			BSTNode<T> root)
	{
		if (root == null)
		{
			return null;
		}
		else if (toFind.data.compareTo(root.data) == 0)
		{
			return root;
		}
		else if (toFind.data.compareTo(root.data) < 0)
		{
			return findNodeHelper(toFind, root.leftChild);
		}
		else
		{
			return findNodeHelper(toFind, root.rightChild);
		}
	}
}
