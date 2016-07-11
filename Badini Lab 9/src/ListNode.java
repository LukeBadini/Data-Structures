public class ListNode<Element>
{
    public Element data;
    public ListNode<Element> next;
	
    public ListNode(Element newData)
    {
        data = newData;
        next = null;
    }
	
    public String toString()
    {
        return data.toString();
    }
}
