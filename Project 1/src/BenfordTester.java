/** 
 * BenfordTester takes tokenized strings, parses their first
 * digit, increments a list for each digit parsed, and prints
 * a graph that depicts the frequency in which each digit appears. 
 * 
 * @author Luke Badini
 * @version 4/8/2015
 */

public class BenfordTester
{

    /*
     *  An array that stores how often each digit occurs in
     *  the leading position.
    */
    private int[] digits = new int[9];


    /**
     *  Counts the number of times the number n is the first digit
     *  in file filename for all n=1...9.  
     *  
     *  @param filename, the name of the file to be read as a string
     */
    public void count(String filename)
    {
    	/* fileBeingRead represents the currents text file
    	 *  being Tokenized. A boolean named checkingFile is used to
    	 *  keep the loop going until the file reaches the end.
    	 *  Once the final line is reached, checkingFile is
    	 *  set to false and the loop is exited.
    	 */
    	
    	Tokenizer fileBeingRead = new Tokenizer(filename);
    	boolean checkingFile = true;
    	
    	/* This loop creates a token variable which is a string
    	 *  composed of the numbers of the text line being read.
    	 *  The Integer method parseInt is called to take the first
    	 *  character of the token string and convert it into
    	 *  an integer which is assigned to firstDigit. A series of
    	 *  if-else if-else statements is run to increment the
    	 *  appropriate index of the array digits. 
    	 */
    	
    	while (checkingFile)
    	{
    		String token = fileBeingRead.nextToken();
    		int firstDigit;
    		
    		if (token != null)
    		{
    			firstDigit = Character.getNumericValue(token.charAt(0));
    		}
    		else
    		{
    			firstDigit = -1;
    		}
    		
    		if (firstDigit > 0)
    		{
    			digits[(firstDigit-1)]++;
    		}
    		else
    		{
    			if (firstDigit == 0)
    			{
    				checkingFile = true;
    			}
    			else
    			{
    				checkingFile = false;
    			}
    		}
    	
    		
    		
    	}
    }


    /** Uses the nine total counts (one for each digit 1-9) to form
     *  a histogram (a bar graph) of leading digit frequency.
     *
     *  One asterisk will be printed in the bar graph for every
     *  unitsPerAsterisk in the count.  For example, say you had
     *  counted that '2' was the leading digit 100 times.  If
     *  unitsPerAsterisk was 25, then you'd print 4 asterisks for the
     *  '2' bar (1 asterisk for each 25 in the count).  If
     *  unitsPerAsterisk was 1, then you'd print 100 asterisks for
     *  the '2' bar (1 asterisk for each 1 in the count).  Being able to
     *  adjust this for different statistics files will let you see
     *  coarser or finer levels of detail so you can make an easy-to-read
     *  bar graph.
     *  
     *  @param unitsPerAsterisk, an integer representing how many units are
     *  represented per asterisk on the graph
     */
    public void graph(int unitsPerAsterisk)
    {
    	/*  Uses nested for loops to print the correct number of
    	 *  asterisks for the graph. The outer loops iterates
    	 *  through the items in the digits array while the inner
    	 *  loop prints the number of of asterisks according to
    	 *  the value at each index of the array.
    	 */
    	
    	for (int i = 0; i < digits.length; i++)
    	{
    		System.out.print((i+1) + ": ");
    		
    		for (int j = 0; j < (digits[i]/unitsPerAsterisk); j++)
    		{
    			System.out.print("*");
    		}
    		
    		System.out.println();
    	}
    }

}
