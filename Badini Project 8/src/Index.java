/**
 * An index holding a dictionary of Strings and an indexTree of
 * IndexEntries
 * 
 * @author Luke Badini
 * @version 6/4/2015
 */

//Most of these methods won't work properly because I couldn't
//get the compareTo in IndexEntry working properly. As such,
//any method that calls the BST method find() will not work.
public class Index 
{
	private BinarySearchTree<String> dictionary;
	private BinarySearchTree<IndexEntry> indexTree;
	
	/**
	 * Default constructor for the Index class
	 */
	public Index()
	{
		dictionary = new BinarySearchTree<String>();
		indexTree = new BinarySearchTree<IndexEntry>();
	}
	
	/**
	 * Adds a word to the dictionary
	 * @param aString; the word to be added
	 */
	public void addToDictionary(String aString)
	{
		dictionary.add(aString);
	}
	
	/**
	 * Checks to see if a specified String is in the dictionary
	 * @param aString; the specified String
	 * @return true if the String is in the dictionary, false otherwise
	 */
	public boolean inDictionary(String aString)
	{
		return (dictionary.find(aString) != null);
	}
	
	/**
	 * Checks to see if a specified String is in the indexTree
	 * @param aString; the specified String
	 * @return true if the String is in the indexTree, false otherwise
	 */
	public boolean inIndexTree(String aString)
	{
		IndexEntry anEntry = new IndexEntry(aString);
		return (indexTree.find(anEntry) != null);
	}
	
	/**
	 * Adds a word that isn't already in the indexTree and isn't in the
	 * dictionary into the indexTree. Does nothing if the word is
	 * already in the indexTree or is in the dictionary
	 * @param aString; the word to add
	 */
	public void addToIndexTree(String aString, Integer pageNumber)
	{
		IndexEntry anEntry = new IndexEntry(aString);
		if (indexTree.find(anEntry) == null && 
				dictionary.find(aString) != null)
		{
			indexTree.add(anEntry);
			addPageNumber(aString, pageNumber);
		}
	}
	
	/**
	 * Removes an entry from the indexTree
	 * @param aString; the String of the entry to be removed
	 */
	public void removeFromIndexTree(String aString)
	{
		IndexEntry anEntry = new IndexEntry(aString);
		if (indexTree.find(anEntry) != null)
		{
			indexTree.remove(anEntry);
		}
	}
	
	/**
	 * Adds the page number to the IndexEntry of a String that is
	 * already in the indexTree (if the word has not already appeared
	 * on this page). If the IndexEntry isn't in the index, does nothing.
	 * 
	 * @param aString; value of the word in the indexTree
	 * @param pageNumber; the number to be added
	 */
	public void addPageNumber(String aString, Integer pageNumber)
	{
		IndexEntry anEntry = new IndexEntry(aString);
		if (indexTree.find(anEntry) != null)
		{
			IndexEntry anotherEntry = indexTree.find(anEntry);
			if (anotherEntry.getPages().find(pageNumber) == null)
			{
				anotherEntry.getPages().addAtTail(pageNumber);
			}
		}
	}
	
	/**
	 * Checks to see if the page list of this indexTree already
	 * contains a specified page number
	 * @param aString; the word in the indexTree
	 * @param pageNumber; the number to look for
	 * @return true if the number is in the indexTree, false otherwise
	 */
	public boolean hasPageNumber(String aString, Integer pageNumber)
	{
		IndexEntry anEntry = new IndexEntry(aString);
		if (indexTree.find(anEntry) != null)
		{
			IndexEntry anotherEntry = indexTree.find(anEntry);
			if (anotherEntry.getPages().find(pageNumber) != null)
			{
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Checks if the page list is full
	 * @param aString; the word to check the page list of
	 * @return true if the page list is full, false otherwise
	 */
	public boolean pageListIsFull(String aString)
	{
		IndexEntry anEntry = new IndexEntry(aString);
		if (indexTree.find(anEntry) != null)
		{
			IndexEntry anotherEntry = indexTree.find(anEntry);
			if (anotherEntry.getPages().size() >= 5)
			{
				return true;
			}
		}
		return false;
		
	}
	
	/**
	 * @return the indexTree of this indexEntry
	 */
	public BinarySearchTree<IndexEntry> getIndexTree()
	{
		return indexTree;
	}
	
	/**
	 * @return the dictionary of this IndexEntry
	 */
	public BinarySearchTree<String> getDictionary()
	{
		return dictionary;
	}
}