/**
 * Linked List is a collection of data nodes.  All methods here relate to
 * how one can manipulate those nodes.
 * 
 * @author Luke Badini
 * @version 5/7/2015
 */
public class LinkedList
{
    private int length;          // number of nodes
    private ListNode firstNode;  // pointer to first node

    public LinkedList()
    {
        length=0;
        firstNode=null;
    }

    /** insert new Event at linked list's head
     * 
     * @param newData the Event to be inserted
     */
    public void insertAtHead(Event newData)
    {
    	ListNode newnode = new ListNode(newData);
        if (getLength() == 0)
        {
            firstNode=newnode;
        }
        else
        {
            newnode.next=firstNode;
            firstNode=newnode;
        }
        length++;
    }
    
    /** Turn entire chain into a string
     *  
     *  @return return linked list as printable string
     */
    public String toString() 
    {
    	String toReturn="(";
    	ListNode n;
    	n=firstNode;
    	while (n!=null)
    	{
    		toReturn = toReturn + n;  //call node's toString automatically
    		n=n.next;
    		if (n!=null)
    		{
    			toReturn = toReturn + ",\n";
    		}
    	}
    	toReturn = toReturn + ")";
    	return toReturn;
    }
    
    /** getter for number of nodes in the linked list
     * 
     * @return length of LL
     */
    public int getLength() {return length;}
    
    /**
     * If the list is not empty, deletes firstNode and returns
     * the Event contained in firstNode. Otherwise returns null
     * 
     * @return the Event contained in firstNode (if there is a 
     * first node). Otherwise null
     */
    public Event removeHead()
    {
    	if (length != 0)
    	{
    		Event headEvent = firstNode.data;
    		firstNode = firstNode.next;
    		length--;
    		return headEvent;
    	}
    	else
    	{
    		return null;
    	}
    	
    }
    
    /**
     * Inserts a node containing Event at the
     * end of the linked list
     * 
     * @param event; the data of the node being
     *               added
     */
    public void insertAtTail(Event event)
    {
    	if (length != 0)
    	{
    		ListNode aNode = new ListNode(event);
    		ListNode runner = firstNode;
    		int counter = 0;
    	
    		while (counter < length && runner.next != null)
    		{
    			runner = runner.next;
    			counter++;
    		}
    		runner.next = aNode;
    		length++;
    	}
    	else
    	{
    		firstNode = new ListNode(event);
    		length++;
    	}
    }
    
    /**
     * Given an event name, finds the first event with that name 
     * in the linked list and returns its start time as an int.
     * If the event is not found, returns -1
     * 
     * @param eventName; name of the event
     * @return the start time of the event
     */
    public int search(String eventName)
    {
    	if (length != 0)
    	{
    		ListNode runner = firstNode;
    		int counter = 0;
    	
    		while (counter < length && runner != null)
    		{
    			if (runner.data.getName() == eventName)
    			{
    				return runner.data.getStart();
    			
    			}
    			runner = runner.next;
    			counter++;
    		}
    		return -1;
    	}
    	else
    	{
    		return -1;
    	}
    }
}