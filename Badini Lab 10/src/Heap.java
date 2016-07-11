/**
 * The Heap ADT.  This is a max heap. 
 * 
 * @author Luke Badini 
 * @version 6/5/2015
 */
import java.util.Arrays;

public class Heap
{
	private int[] itemArray;    //binary tree of ints in array form (element 0 not used) 
	private int nodes;          //number of nodes in the tree

	/**
	 * Builds a heap from an array of ints.
	 *
	 * @param items 
	 *            an array of ints(starting at index 0), which will be 
	 *            interpreted as a binary tree.
	 */
	public Heap(int[] items)
	{
		itemArray = new int[items.length + 1];
		nodes = items.length;

		for (int i = 0; i < nodes; i++) {
			itemArray[i + 1] = items[i];
		}

		buildAHeap();
	}

	/**
	 * @return number of nodes in the heap.
	 */
	public int size()
	{
		return nodes;
	}

	/** string representation of a heap that looks (a little) like a tree
	 * @return string with one int on 1st line, two ints on 2nd line, four ints on 3rd line, etc.
	 */
	public String toString()
	{
		String result = "";
		int lastNodeOnLevel = 1;

		for (int i = 1; i < nodes; i++)
		{
			result += itemArray[i];
			if (i == lastNodeOnLevel) {
				result += "\n";
				lastNodeOnLevel = lastNodeOnLevel * 2 + 1;
			} else {
				result += " ";
			}
		}
		result += itemArray[nodes];

		return result;
	}

	/**
	 * Constructs a heap from the given binary tree (given as an array).  
	 * Heapifies each internal node in reverse level-by-level order.
	 */
	public void buildAHeap()
	{
		for (int i = nodes/2; i >= 1; i--) 
		{
			heapify(i);
		}
	}
	
	/**
	 * Turns a subtree into a heap, assuming that only the root of that subtree
	 * violates the heap property.
	 *
	 * @param startingNode 
	 * 			the index of the node to start with.  This node 
	 * 			is the root of a subtree which must be turned into a heap.
	 */
	public void heapify(int startingNode)
	{
		int largerChild = findLargerChild(startingNode);
		if (largerChild != startingNode)
		{
			swap(startingNode, largerChild);
			
			if (hasChildren(largerChild))			
			{
				heapify(largerChild);
			}
		}
	}
	
	/**
	 * @return the index position of the left child of aNode
	 */
	private int getLeft(int aNode)
	{
		return aNode*2;
	}
	
	/**
	 * @return the index position of the right child of aNode
	 */
	private int getRight(int aNode)
	{
		return (aNode*2) + 1;
	}
	
	/**
	 * @param aNode; a given node
	 * @return true if the node has a right child, false otherwise
	 */
	private boolean hasRightChild(int aNode)
	{
		return getRight(aNode) <= nodes;
	}
	
	/**
	 * @param aNode; a given node
	 * @return true if the node has children, false otherwise
	 */
	private boolean hasChildren(int aNode)
	{
		return getLeft(aNode) <= nodes;
	}
	
	/**
	 * Finds the larger child of a non-leaf node
	 * @param aNode; a non-leaf node
	 * @return the index at which the larger child is located. If
	 *         both children are smaller than aNode, returns aNode
	 */
	private int findLargerChild(int aNode)
	{
		if (itemArray[aNode] < itemArray[getLeft(aNode)] ||
				itemArray[aNode] < itemArray[getRight(aNode)])
		{
			if (!hasRightChild(aNode))
			{
				return aNode*2;
			}
			else if (itemArray[getLeft(aNode)] < 
					itemArray[getRight(aNode)])
			{
				return (aNode*2) + 1;
			}
			else if (itemArray[getLeft(aNode)] >= 
					itemArray[getRight(aNode)])
			{
				return aNode*2;
			}
		}
			return aNode;
	}
		
	/**
	 * Swaps the positions of 2 nodes
	 * @param aNode; first node to swamp
	 * @param anotherNode; second node to swap
	 */
	private void swap(int aNode, int anotherNode)
	{
		int temp = itemArray[aNode];
		itemArray[aNode] = itemArray[anotherNode];
		itemArray[anotherNode] = temp;
	}
	
	/**
	 * Removes the root from the heap, returning it.  The resulting array is 
	 * then turned back into a heap. 
	 *
	 * @return the root value.
	 */
	// I couldn't get this to work no matter what I tried
	// I keep getting an ArrayIndexOutOfBoundsException
	// and I can't figure out how to fix it
	public int deleteRoot()
	{
		int toReturn = itemArray[1];
		itemArray[1] = itemArray[nodes];
		nodes--;
		itemArray = Arrays.copyOf(itemArray, nodes);
		heapify(1);
		return toReturn;
	}
}
