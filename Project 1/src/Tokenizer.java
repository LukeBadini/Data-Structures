import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;

/** 
 * Tokenizer takes a text file and parses it into individual tokens,
 * returning each as a string.  The expected format of the text file is
 * to have comments at the top of the file, in (* ... *) format, 
 * which are ignored by the Tokenizer.  The tokens then follow, one per line.  
 * Whitespace is ignored. 
 * 
 * @author Aaron G. Cass, based on earlier version by Chris Fernandes
 * @version 1/4/2012
 */
public class Tokenizer {

	private Scanner sc;
	private static Pattern commentPattern = Pattern.compile("\\s*\\(\\*.*\\*\\)\\s*");
	
	/** 
	 * Constructor specifying the file to tokenize.  
	 * Anything between (* and *) at the top of the file will
	 * be ignored, and line terminators are delimiters.
	 * 
	 * @param filename absolute or relative path to the file to be tokenized.
	 * Examples: "input.txt" or "C:/input.txt"
	 */
	public Tokenizer(String filename)
	{
		try {
    		sc = new Scanner(new File(filename));
    		
    		sc.useDelimiter("\\s*[\\n\\r]\\s*");	 
    		consumeComments();
    	} catch (FileNotFoundException e) {
	    	System.out.println(filename + " not found");
	    }
	}
	
	/**
	 * Skips over the block of comments at the top of the file.  Must be called before we've
	 * tried to get the first token. 
	 */
    private void consumeComments()
    {
    	while (sc.hasNext(commentPattern)) {
    		sc.skip(commentPattern);
    	}
    	if (sc.hasNext("")) {
    		sc.next();
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
