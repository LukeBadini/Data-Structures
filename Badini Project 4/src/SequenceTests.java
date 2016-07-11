public class SequenceTests {

	public static void main(String[] args) 
	{
		
		Testing.setVerbose(true);
		System.out.println("Starting Tests");

		testCreate();
		testAddBefore();
		testAddAfter();
		testAddAll();
		testAdvance();
		testClone();
		testConcatenation();
		testEnsureCapacity();
		testGetCapacity();
		testGetCurrent();
		testIsCurrent();
		testRemoveCurrent();
		testSize();
		testStart();
		testTrimToSize();
		testEquals();

		System.out.println("Tests Complete");
	}

	private static void testCreate() 
	{
		Testing.testSection("Creation tests");

		Sequence s1 = new Sequence();
		Testing.assertEquals("Default constructor", "{} (capacity = 10)", 
				s1.toString());
		Testing.assertEquals("Default constructor, initial size", 0, 
				s1.size());

		Sequence s2 = new Sequence(20);
		Testing.assertEquals("Non-default constructor", "{} (capacity = 20)",
				s2.toString());
		Testing.assertEquals("Non-default constructor, initial size", 0,
				s2.size());
	}
	
	private static void testAddBefore()
	{
		Testing.testSection("Add before tests");
		
		Sequence s3 = new Sequence();
		s3.addBefore("test");
		Testing.assertEquals("Add to empty", "{>test} (capacity = 10)", 
				s3.toString());
		
		Sequence s4 = new Sequence();
		s4.addBefore("test");
		s4.addBefore("test2");
		Testing.assertEquals("Add to partially full", "{>test2, test} "
				+ "(capacity = 10)", s4.toString());
		
		Sequence s5 = new Sequence();
		for (int i = 0; i < s5.getCapacity(); i++)
		{
			s5.addBefore("xD");
		}
		s5.addBefore("test");
		Testing.assertEquals("Add to full", "{>test, xD, xD, xD, xD, xD, xD, "
				+ "xD, xD, xD, xD} (capacity = 21)", s5.toString());
		
		Sequence s6 = new Sequence();
		for (int i = 0; i < s6.getCapacity(); i++)
		{
			s6.addBefore("xD");
		}
		s6.advance();
		s6.addBefore("test");
		Testing.assertEquals("Add to full with no current index", 
				"{>test, xD, xD, xD, xD, xD, xD, "
				+ "xD, xD, xD, xD} (capacity = 21)", s6.toString());
	}
	
	private static void testAddAfter()
	{
		Testing.testSection("Add after tests");
		
		Sequence s7 = new Sequence();
		s7.addAfter("test");
		Testing.assertEquals("Add to empty", "{>test} (capacity = 10)", 
				s7.toString());
		
		Sequence s8 = new Sequence();
		s8.addAfter("test");
		s8.addAfter("test2");
		Testing.assertEquals("Add to partially full", "{test, >test2} "
				+ "(capacity = 10)", s8.toString());
		
		s8.addBefore("test3");
		s8.addAfter("test4");
		Testing.assertEquals("Add to the middle of a sequence", 
				"{test, test3, >test4, test2} (capacity = 10)", 
				s8.toString());
		
		Sequence s9 = new Sequence();
		for (int i = 0; i < s9.getCapacity(); i++)
		{
			s9.addAfter("xD");
		}
		s9.addAfter("test");
		Testing.assertEquals("Add to full", "{xD, xD, xD, xD, xD, xD, "
				+ "xD, xD, xD, xD, >test} (capacity = 21)", s9.toString());
		
		Sequence s10 = new Sequence();
		for (int i = 0; i < s10.getCapacity(); i++)
		{
			s10.addAfter("xD");
		}
		s10.advance();
		s10.addAfter("test");
		Testing.assertEquals("Add to full with no current index", 
				"{xD, xD, xD, xD, xD, xD, "
				+ "xD, xD, xD, xD, >test} (capacity = 21)", s10.toString());
	}
	
	private static void testAddAll()
	{
		Testing.testSection("Add All tests");
		
		Sequence s11 = new Sequence(1);
		Sequence s12 = new Sequence();
		s11.addBefore("xD");
		s12.addAfter("test");
		s12.addAll(s11);
		Testing.assertEquals("Add a full sequence to a not-full sequence", 
				"{>test, xD} (capacity = 10)", s12.toString());
		
		Sequence s13 = new Sequence(1);
		Sequence s14 = new Sequence();
		s13.addBefore("test");
		for (int i = 0; i < s14.getCapacity(); i++)
		{
			s14.addAfter("xD");
		}
		s13.addAll(s14);
		Testing.assertEquals("Add a full sequence to a full sequence", 
				"{>test, xD, xD, xD, xD, xD, xD, xD, xD, xD, xD} "
				+ "(capacity = 11)", s13.toString());
	}
	
	private static void testAdvance()
	{
		Testing.testSection("Advance tests");
		
		Sequence s15 = new Sequence();
		s15.addBefore("2");
		s15.addBefore("1");
		s15.advance();
		Testing.assertEquals("Advance to the next item", 
				"{1, >2} (capacity = 10)", s15.toString());
		
		Sequence s16 = new Sequence(2);
		s16.addAfter("1");
		s16.addAfter("2");
		s16.advance();
		Testing.assertEquals("Advance past the size of the sequence",
				"{1, 2} (capacity = 2)", s16.toString());
	}
	
	private static void testClone()
	{
		Testing.testSection("Clone tests");
		
		Sequence s17 = new Sequence();
		s17.addBefore("3");
		s17.addBefore("2");
		s17.addBefore("1");
		Sequence s18 = s17.clone();
		Testing.assertEquals("Clone a sequence", "{>1, 2, 3} (capacity = 10)",
				s18.toString());
		
		s18.addBefore("test");
		System.out.println("Sequence s17 is: " + s17.toString());
		Testing.assertEquals("Modify a cloned sequence", "{>test, 1, 2, 3}"
				+ " (capacity = 10)", s18.toString());
		
		s17.addBefore("harpoon");
		System.out.println("Sequence s18 is: " + s18.toString());
		Testing.assertEquals("Modify the original sequence", ""
				+ "{>harpoon, 1, 2, 3} (capacity = 10)", s17.toString());
	}
	
	private static void testConcatenation()
	{
		Testing.testSection("Concatenation tests");
		
		Sequence s19 = new Sequence(2);
		Sequence s20 = new Sequence(2);
		s19.addBefore("2");
		s19.addBefore("1");
		s20.addBefore("4");
		s20.addBefore("3");
		Sequence s21 = Sequence.concatenation(s19, s20);
		Testing.assertEquals("Concatenate 2 full sequences", "{1, 2, 3, 4}"
				+ " (capacity = 4)", s21.toString());
		
		Sequence s22 = new Sequence(1);
		Sequence s23 = new Sequence();
		s22.addBefore("1");
		s23.addBefore("2");
		Sequence s24 = Sequence.concatenation(s22, s23);
		Testing.assertEquals("Concatenate a full sequence and a not-full"
				+ " sequence", "{1, 2} (capacity = 2)", s24.toString());
		
		Sequence s25 = new Sequence();
		Sequence s26 = new Sequence();
		s25.addBefore("10");
		s26.addBefore("20");
		Sequence s27 = Sequence.concatenation(s25, s26);
		Testing.assertEquals("Concatenate a 2 not-full sequences"
				+ " sequence", "{10, 20} (capacity = 2)", s27.toString());
	}
	
	private static void testEnsureCapacity()
	{
		Testing.testSection("Ensure capacity tests");
		
		Sequence s28 = new Sequence(1);
		s28.addBefore(":D");
		s28.ensureCapacity(10);
		Testing.assertEquals("Increase capacity to 10", "{>:D} "
				+ "(capacity = 10)", s28.toString());
		
		Sequence s29 = new Sequence(3);
		for (int i = 0; i < s29.getCapacity(); i++)
		{
			s29.addBefore(":D");
		}
		s29.ensureCapacity(1);
		Testing.assertEquals("Lower capacity", "{>:D, :D, :D} "
				+ "(capacity = 3)", s29.toString());
		
	}
	
	private static void testGetCapacity()
	{
		Testing.testSection("Get capacity tests");
		
		Sequence s30 = new Sequence();
		Testing.assertEquals("Default constructor", 10, s30.getCapacity());
		
		Sequence s31 = new Sequence(5);
		Testing.assertEquals("Non-default constructor", 5, s31.getCapacity());
	}
	
	private static void testGetCurrent()
	{
		Testing.testSection("Get current tests");
		
		Sequence s32 = new Sequence();
		s32.addBefore("D");
		s32.addBefore("x");
		Testing.assertEquals("Get current with an index", "x", 
				s32.getCurrent());
		
		Sequence s33 = new Sequence();
		Testing.assertEquals("Get current without an index", null, s33.getCurrent());
	}
	
	private static void testIsCurrent()
	{
		Testing.testSection("Is current tests");
		
		Sequence s34 = new Sequence();
		Testing.assertEquals("No current index", false, s34.isCurrent());
		
		s34.addBefore("ebin");
		Testing.assertEquals("Has a current index", true, s34.isCurrent());
		
		s34.advance();
		Testing.assertEquals("Advance to no current index", false, 
				s34.isCurrent());
	}
	
	private static void testRemoveCurrent()
	{
		Testing.testSection("Remove current tests");
		
		Sequence s35 = new Sequence();
		s35.addBefore("gun");
		s35.addBefore("harpoon");
		s35.removeCurrent();
		Testing.assertEquals("Remove an element from a not-full sequence"
				, "{>gun} (capacity = 10)", s35.toString());
		
		Sequence s36 = new Sequence(1);
		s36.addBefore("harpoon gun");
		s36.removeCurrent();
		Testing.assertEquals("Remove and element from the end of a full "
				+ "sequence", "{} (capacity = 1)", s36.toString());
	}
	
	private static void testSize()
	{
		Testing.testSection("Size tests");
		
		Sequence s37 = new Sequence();
		Testing.assertEquals("Size of an empty sequence", 0, s37.size());
		
		s37.addBefore("esfrsaf");
		Testing.assertEquals("Size of a not-empty sequence", 1, s37.size());
		
		s37.trimToSize();
		Testing.assertEquals("Size of a full sequence", 1, s37.size());
	}
	
	private static void testStart()
	{
		Testing.testSection("Start tests");
		
		Sequence s38 = new Sequence();
		for (int i = 0; i < s38.getCapacity(); i++)
		{
			s38.addBefore("1");
		}
		s38.advance();
		System.out.println("The current sequence is: " + s38.toString());
		s38.start();
		Testing.assertEquals("A non-empty sequence", "{>1, 1, 1, 1, 1, "
				+ "1, 1, 1, 1, 1} (capacity = 10)", s38.toString());
		
		Sequence s39 = new Sequence();
		s39.start();
		Testing.assertEquals("An empty sequence", "{} (capacity = 10)",
				s39.toString());
	}
	
	private static void testTrimToSize()
	{
		Testing.testSection("Trim to size tests");
		
		Sequence s40 = new Sequence();
		s40.trimToSize();
		Testing.assertEquals("An empty sequence", "{} (capacity = 0)", 
				s40.toString());
		
		Sequence s41 = new Sequence();
		s41.addBefore("harpoon gun");
		s41.trimToSize();
		Testing.assertEquals("A non-empty sequence", "{>harpoon gun} "
				+ "(capacity = 1)", s41.toString());
		
		s41.trimToSize();
		Testing.assertEquals("A full sequence", "{>harpoon gun} "
				+ "(capacity = 1)", s41.toString());
	}
	
	private static void testEquals()
	{
		Testing.testSection("Equals tests");
		
		Sequence s42 = new Sequence();
		Sequence s43 = new Sequence();
		s42.addBefore("This testing is so tedious");
		s43.addBefore("This testing is so tedious");
		Testing.assertEquals("2 not-full sequences", true, s42.equals(s43));
		
		Sequence s44 = new Sequence();
		Sequence s45 = new Sequence();
		Testing.assertEquals("2 empty sequences", true, s44.equals(s45));
		
		s43.addBefore("I've been writing this test code for 3 hours "
				+ "straight and I'm ready to shoot myself with a "
				+ "harpoon gun");
		Testing.assertEquals("2 not-full, not-equal sequences", false,
				s42.equals(s43));
		
		Sequence s46 = new Sequence();
		Sequence s47 = new Sequence(20);
		s46.addBefore("xD");
		s47.addBefore("xD");
		Testing.assertEquals("2 not-full sequences with different "
				+ "capacities", true, s46.equals(s47));
	}
}
