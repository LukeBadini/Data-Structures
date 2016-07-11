import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;

/** 
 * FileReader takes a text file and parses it into individual tokens,
 * which are either words (separated by spaces or other punctuation)
 * or the # symbol, indicating a page break.
 *
 * Hyphenated words are treated as multiple words (e.g. "ham-handed"
 * is returned as two tokens "ham" and "handed")
 * 
 * @author Aaron G. Cass, based on earlier version by Chris Fernandes
 * @version 2/26/2012
 */
public class FileReader {

    private Scanner sc;
	
    /** 
     * Constructor specifying the file to tokenize.  
     * 
     * @param filename absolute or relative path to the file to be tokenized.
     * Examples: "input.txt" or "C:/input.txt"
     */
    public FileReader(String filename)
    {
	try {
	    sc = new Scanner(new File(filename));
	    
	    sc.useDelimiter("[\\.,\\-;:]*\\s+|\\-");	 
	} catch (FileNotFoundException e) {
	    System.out.println(filename + " not found");
	}
    }
    
    /**
     * @return the next token, if there is one, and null otherwise.
     */
    public String nextToken()
    {
    	if (sc.hasNext()) {
    		return sc.next();
    	} else {
    		return null;
    	}
    }
}
