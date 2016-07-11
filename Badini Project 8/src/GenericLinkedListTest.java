import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class GenericLinkedListTest {

	private GenericLinkedList<String> ll;
	
	@Before
	public void setUp() throws Exception {
		ll = new GenericLinkedList<String> ();
	}

	@After
	public void tearDown() throws Exception {
		ll = null;
	}

	// There should be at most one assert statement per testing method.
	@Test
	public void testConstructor () {
		assertEquals ("New list is empty", "{}", ll.toString());
	}
	
	@Test
	public void testAddAtTail_toEmptyList () {
		ll.addAtTail("A");
		assertEquals ("{} + A", "{A}", ll.toString());
	}
	
	@Test
	public void testAddAtTail_nonEmptyList () {
		ll.addAtTail("A");
		ll.addAtTail("B");
		assertEquals ("{A} + B", "{A, B}", ll.toString());
	}

	// Add more tests.     
	
	@Test
	public void testFind_emptyList() {
		assertEquals("Find A in {}", null, ll.find("A"));
	}
	
	@Test
	public void testFind_nonEmptyFound() {
		ll.addAtTail("A");
		assertEquals("Find A in {A}", "A", ll.find("A"));
	}
	
	@Test
	public void testFind_nonEmptyNotFound() {
		ll.addAtTail("A");
		assertEquals("Find B in {A}", null, ll.find("B"));
	}
}
