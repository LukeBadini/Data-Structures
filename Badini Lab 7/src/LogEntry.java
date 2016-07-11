/**
 * LogEntry interface
 * 
 * @author Luke Badini
 * @version 5/14/2015
 */
public interface LogEntry 
{
	// returns the log entry as a string
	public String toString();
	
	// returns the month of the log entry as an integer
	public int getMonth();
	
	// returns the day of the log entry as an integer
	public int getDay();
	
	// returns the year of the log entry as an integer
	public int getYear();
}
