/**
 * Defines nodes that are used in the LinkedList class
 * 
 * @author Luke Badini
 * @version 5/5/2015
 *
 */
public class LinkNode 
{
	public String data;
	public LinkNode next;
	
	/**
	 * Non-default constructor of a LinkNode
	 * Filled with aString and pointing to null
	 */
	public LinkNode(String aString)
	{
		data = aString;
		next = null;
	}
	
	/**
	 * Non-default constructor of a LinkNode
	 * Filled with aString and pointing to aNode
	 */
	public LinkNode(String aString, LinkNode aNode)
	{
		data = aString;
		next = aNode;
	}
}
