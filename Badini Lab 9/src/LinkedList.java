public class LinkedList<Element>
{
    private ListNode<Element> firstNode;
    private int size;
	
    /**
     * Constructs an empty list.
     */
    public LinkedList()
    {
        firstNode = null;
        size = 0;
    }
	
    /**
     * @return the number of elements in the list.
     */
    public int size()
    {
        return size;
    }
	
    /**
     * @return true if and only if there are no elements in the list.
     */
    public boolean isEmpty()
    {
        return (size() == 0);
    }
	
    /**
     * Adds to the front of the list.
     * @param toInsert the element to insert.
     */
    public void insertAtHead(Element toInsert)
    {
        ListNode<Element> newNode = new ListNode<Element>(toInsert);
        newNode.next = firstNode;
        firstNode = newNode;
        size++;
    }
	
    /**
     * Removes from the front of the list.
     * @return the removed element, or null if there was no element.
     */
    public Element removeHead()
    {
        if (isEmpty()) {
            return null;
        } else {
            Element toReturn = firstNode.data;
            firstNode = firstNode.next;
            size--;
            return toReturn;
        }
    }
	
    /**
     * Returns (without removing) the element at the front of the list. 
     * @return the front element, or null if there is no front element.
     */
    public Element elementAtHead()
    {
        if (isEmpty()) {
            return null;
        } else {
            return firstNode.data;
        }
    }
	
    /**
     * Adds to the end of the list.
     * @param toInsert the element to add.
     */
    public void insertAtTail(Element toInsert)
    {
        if (isEmpty()) {
            insertAtHead(toInsert);
        } else {
            ListNode<Element> newNode = new ListNode<Element>(toInsert);
            ListNode<Element> runner = firstNode;
            while(runner.next != null) {
                runner = runner.next;
            }
            runner.next = newNode;
            size++;
        }
    }
	
    /**
     * Removes from the tail of the list
     * @return the removed element, or null if there was no element to remove.
     */
    public Element removeTail()
    {
        if (isEmpty()) {
            return null;
        } else if (size() == 1) {
            return removeHead();
        } else {
            ListNode<Element> runner = firstNode;
            ListNode<Element> prev = null;
            while(runner.next != null) {
                prev = runner;
                runner = runner.next;
            }
            Element toReturn = runner.data;
			
            prev.next = null;
            size--;
            return toReturn;
        }
    }
	
    /**
     * Returns (without removing) the element at the tail of the list.
     * @return the element at the tail, or null if there are no elements in the list.
     */
    public Element elementAtTail()
    {
        if (isEmpty()) {
            return null;
        } else {
            ListNode<Element> runner = firstNode;
            while (runner.next != null) {
                runner = runner.next;
            }
            return runner.data;
        }
    }
	
    /**
     * @return a string representation of the list.
     */
    public String toString()
    {
        String toReturn = "{";
        ListNode<Element> runner = firstNode;
        while (runner != null) {
            toReturn += runner;
            if (runner.next != null) {
                toReturn += ", ";
            }
            runner = runner.next;
        }
        toReturn += "}";
        toReturn += " (size = " + size() + ")";
        return toReturn;
    }
}
