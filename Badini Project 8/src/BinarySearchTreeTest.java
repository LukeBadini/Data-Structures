import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class BinarySearchTreeTest {

	private BinarySearchTree<String> tree;
	
	@Before
	public void setUp() throws Exception {
		tree = new BinarySearchTree<String> ();
	}

	@After
	public void tearDown() throws Exception {
		tree = null;
	}


	@Test
	public void testConstructor () {
		assertEquals ("A new tree should be empty", "", tree.toString());
	}
	
	@Test
	public void testAdd_toEmptyTree () {
		tree.add("K");
		assertEquals ("empty tree + K", "K", tree.toString());
	}
	
	@Test
	public void testAdd_depthZeroTreeLeftChild () {
		tree.add("K");
		tree.add("D");
		assertEquals ("K + D", "D\nK", tree.toString());
	}

	@Test
	public void testAddShowTree_depthZeroTreeLeftChild () {
		tree.add("K");
		tree.add("D");
		assertEquals ("K + D", "K\n D", tree.showTree());
	}

	// Add more tests.  
	
	
	@Test
	public void testRemove_oneItem() {
		tree.add("D");
		tree.remove("D");
		assertEquals ("D - D", "", tree.toString());
	}
	
	@Test
	public void testRemove_leaf() {
		tree.add("K");
		tree.add("D");
		tree.remove("D");
		assertEquals ("K + D - D", "K", tree.toString());
	}
	
	@Test
	public void testRemove_root() {
		tree.add("K");
		tree.add("W");
		tree.add("D");
		tree.remove("K");
		assertEquals ("K + W + D - K", "D\nW", tree.toString());
	}
	
	@Test
	public void testRemove_nodeWith2Children() {
		tree.add("K");
		tree.add("F");
		tree.add("G");
		tree.add("D");
		tree.remove("F");
		assertEquals ("K + F + G + D - F", "D\nG\nK", tree.toString());
	}
	
	@Test
	public void testRemove_noLeftChild() {
		tree.add("K");
		tree.add("D");
		tree.add("F");
		tree.remove("D");
		assertEquals ("K + D + F", "F\nK", tree.toString());
	}
	
	@Test
	public void testFind_found() {
		tree.add("K");
		tree.add("D");
		assertEquals ("Find K (found)", "K", tree.find("K"));
	}
	
	@Test
	public void testFind_notFound() {
		tree.add("K");
		tree.add("D");
		assertEquals ("Find X (not found)", null, tree.find("X"));
	}
	
}
