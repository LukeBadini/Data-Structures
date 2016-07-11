public class Tests
{
    public static void main(String [] args)
    {
        Testing.setVerbose(true);
		
        Testing.startTests();
		
        listTests();
        stackTests();
        balancerTests();
		
        Testing.finishTests();
    }
	
    public static void listTests()
    {
        Testing.testSection("Empty Linked List Tests");

        LinkedList<String> l = new LinkedList<String>();
		
        Testing.assertEquals("New list is empty", true, l.isEmpty());
        Testing.assertEquals("New list has 0 elements", 0, l.size());
		
        Testing.testSection("Linked List Tests -- Head Element");
		
        l.insertAtHead("Foo");
		
        Testing.assertEquals("Adding to head produces non-empty list", false, l.isEmpty());
        Testing.assertEquals("Adding to head produces list with 1 element", 1, l.size());
        Testing.assertEquals("Element added to head is now at head", "Foo", l.elementAtHead());
        Testing.assertEquals("Element added to head is shown in list", "{Foo} (size = 1)", l.toString());
		
        l.insertAtHead("Bar");

        Testing.assertEquals("Adding to head of non-empty list produces non-empty list", false, l.isEmpty());
        Testing.assertEquals("Adding to head adds to the number of elements", 2, l.size());
        Testing.assertEquals("Element added to head is now at head", "Bar", l.elementAtHead());
        Testing.assertEquals("Element added to head is shown in list", "{Bar, Foo} (size = 2)", l.toString());

        l.insertAtHead("Cat");
        Testing.assertEquals("Element added to head is shown in list", "{Cat, Bar, Foo} (size = 3)", l.toString());
		
        Testing.testSection("Linked List Tests -- Tail Element");
		
        Testing.assertEquals("First element added at head is now at tail", "Foo", l.elementAtTail());
		
        l.removeTail();
        Testing.assertEquals("Removing tail results in non-empty list", false, l.isEmpty());
        Testing.assertEquals("Removing tail removes 1 element", 2, l.size());
        Testing.assertEquals("Removing tail makes previous element the tail", "Bar", l.elementAtTail());
        Testing.assertEquals("Removing tail removes it from the list", "{Cat, Bar} (size = 2)", l.toString());		

        l.removeTail();
        Testing.assertEquals("Removing tail again results in non-empty list", false, l.isEmpty());
        Testing.assertEquals("Removing tail removes 1 more element", 1, l.size());
        Testing.assertEquals("Removing tail makes previous element the tail", "Cat", l.elementAtTail());
        Testing.assertEquals("Removing tail removes it from the list", "{Cat} (size = 1)", l.toString());		

        l.removeTail();
        Testing.assertEquals("Removing tail yet again results in empty list", true, l.isEmpty());
        Testing.assertEquals("Removing tail yet again removes last element", 0, l.size());
        Testing.assertEquals("Removing tail makes tail null", null, l.elementAtTail());
        Testing.assertEquals("Removing tail removes last element from the list", "{} (size = 0)", l.toString());		
    }
	
    public static void stackTests()
    {
        Testing.testSection("Stack tests -- Empty Stack");
		
        Stack<String> emptyStack = new Stack<String>();
        Testing.assertEquals("New stack is empty", true, emptyStack.isEmpty());
        Testing.assertEquals("New stack has no elements", 0, emptyStack.size());
        Testing.assertEquals("New stack has no top element", null, emptyStack.top());
		
        Testing.testSection("Stack tests -- non-empty stack");
		
        Stack<String> s = new Stack<String>();
        s.push("George");
        Testing.assertEquals("Pushing changes empty", false, s.isEmpty());
        Testing.assertEquals("Pushing changes size", 1, s.size());
        Testing.assertEquals("Pushing changes top", "George", s.top());
		
        Testing.assertEquals("Popping the only element returns it", "George", s.pop());
        Testing.assertEquals("Popping from 1 element statck removes the last element", 0, s.size());
        Testing.assertEquals("Popping from 1 element statck makes it empty", true, s.isEmpty());
    }
	
    public static void balancerTests()
    {
        Testing.testSection("Enclosure Balancer Tests");
		
        EnclosureBalancer balancer = new EnclosureBalancer();
        
        String string1 = "(hello)";
        String string2 = "{hello)";
        String string3 = "(<{[hello]}>)";
        String string4 = "(<{[hello)>}]";
        String string5 = "hello";
        String string6 = "(hello";
        String string7 = "hello>";
        
        Testing.assertEquals("Balanced enclosures", true, 
        		balancer.isBalanced(string1));
        Testing.assertEquals("Unbalancer enclosures", false, 
        		balancer.isBalanced(string2));
        Testing.assertEquals("Multiple enclosures in correct order", 
        		true, balancer.isBalanced(string3));
        Testing.assertEquals("Multiple enclosures in wrong order",
        		false, balancer.isBalanced(string4));
        Testing.assertEquals("No enclosures", true,
        		balancer.isBalanced(string5));
        Testing.assertEquals("Opening but no closing", false,
        		balancer.isBalanced(string6));
        Testing.assertEquals("Closing but no opening", false,
        		balancer.isBalanced(string7));
    }
}
