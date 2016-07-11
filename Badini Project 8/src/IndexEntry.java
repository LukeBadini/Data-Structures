/**
 * A data type used to store information of an indexEntry.
 * Contains a String specifying a word and a GenericLinkedList
 * of Integer objects specifying what pages the word appears on
 * 
 * @author Luke Badini
 * @version 6/1/2015
 *
 */
public class IndexEntry implements Comparable<IndexEntry>
{
	private String word;
	private GenericLinkedList<Integer> pages;
	private final int MAX_ENTRIES = 5;
	
	/**
	 * Non-default constructor for an IndexEntry
	 * @param aString; the word being stored in the IndexEntry
	 */
	public IndexEntry(String aString)
	{
		word = aString;
		pages = new GenericLinkedList<Integer>();
	}
	
	/**
	 * @return true if the IndexEntry is full, false otherwise
	 */
	public boolean isFull()
	{
		return (pages.size() > MAX_ENTRIES);
	}
	
	/**
	 * Adds a page number to the pages linked list
	 * @param pageNumber; the page number to add
	 */
	public void addPageNumber(Integer pageNumber)
	{
		pages.addAtTail(pageNumber);
	}
	
	/**
	 * @return; the word stored in this IndexEntry
	 */
	public String getWord()
	{
		return word;
	}
	
	/**
	 * @return; the pages linked list stored in this IndexEntry
	 */
	public GenericLinkedList<Integer> getPages()
	{
		return pages;
	}
	
	/**
	 * @return the IndexEntry as a String
	 */
	public String toString()
	{
		return word + " pages: " + pages.toString();
	}
	
	/**
	 * Compares the word of this IndexEntry to the word of
	 * another IndexEntry
	 */
	//Couldn't get this to work properly. Not quite sure why
	@Override public int compareTo(IndexEntry anEntry)
	{
		return word.compareTo(anEntry.getWord());
	}
}
