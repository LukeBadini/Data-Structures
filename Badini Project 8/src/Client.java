/**
 * Scans through a text file and prints the index and dictionary
 * associated with it
 * 
 * @author Luke Badini
 * @version 6/4/2015
 *
 */
public class Client 
{
	//This won't work because I couldn't get my compareTo for
	//IndexEntry working properly
	public static void main(String[] args) 
	{
		String fileName = "src/input.txt";
		FileReader file = new FileReader(fileName);
		Index anIndex = new Index();
		Integer pageNumber = 1;
		boolean tokenizing = true;
		
		while (tokenizing)
		{
			String word = file.nextToken();
			if (word == null)
			{
				tokenizing = false;
			}
			else if (word.equals("#"))
			{
				pageNumber++;
			}
			else if (word.length() >= 3 && !anIndex.inDictionary(word))
			{
				if (anIndex.inIndexTree(word))
				{
					if (!anIndex.hasPageNumber(word, pageNumber))
					{
						if (!anIndex.pageListIsFull(word))
						{
							anIndex.addPageNumber(word, pageNumber);
						}
						else
						{
							IndexEntry anEntry = new IndexEntry(word);
							System.out.println(anIndex.getIndexTree().
									find(anEntry).toString());
							anIndex.removeFromIndexTree(word);
							anIndex.addToDictionary(word);
						}
					}
				}
				else
				{
					anIndex.addToIndexTree(word, pageNumber);
				}
			}
		}
		System.out.println("Dictionary:\n" + anIndex.getDictionary().
				toString() + "\n");
		System.out.println("Index:\n" + anIndex.getIndexTree().
				toString() + "\n");
	}
}
