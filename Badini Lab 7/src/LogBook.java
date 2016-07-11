/**
 * A LogBook for storing LogEntry objects
 * 
 * @author Luke Badini
 * @version 5/14/2015
 *
 */
public class LogBook 
{
	private int month;
	private int year;
	private LogEntry[] entries;
	private final int ENTRIES_LENGTH = 32;
	
	/**
	 * A non-default constructor that takes a month and a year as
	 * parameters. Sets entries to an array long enough to hold every
	 * event possible in a given month.
	 * 
	 * @param aMonth; a given month
	 * @param aYear; a given year
	 */
	public LogBook(int aMonth, int aYear)
	{
		if (aMonth > 0 && aMonth < 13)
		{
			month = aMonth;
			year = aYear;
			entries = new LogEntry[ENTRIES_LENGTH];
		}
		else
		{
			System.out.println("Invalid month. LogBook not made.");
		}
	}
	
	/**
	 * Inserts a LogEntry into the entries array if there is not already
	 * an event there and returns true. If an invalid month, day, or year
	 * is given, returns false.
	 * 
	 * @param entry; the LogEntry to be added
	 * @return; true if the entry was added, false otherwise
	 */
	public boolean insertEntry(LogEntry entry)
	{
		if (entry.getDay() < 1 || entry.getDay() > 31)
		{
			return false;
		}
		else if (entry.getMonth() != month || entry.getYear() != year
				|| entries[entry.getDay()] != null)
		{
			return false;
		}
		else
		{
			entries[entry.getDay()] = entry;
			return true;
		}
	}
	
	/**
	 * Takes a day as a parameter and returns the event at
	 * that day or null if no event is on that day
	 * 
	 * @param day; given day of the event
	 * @return the event on that day or null if no event exists on
	 *         that day
	 */
	public LogEntry getEntry(int day)
	{
		if (day > 0 && day < 32)
		{
			return entries[day];
		}
		else
		{
			return null;
		}
	}
	
	/**
	 * @return the LogBook as a string
	 */
	public String toString()
	{
		String myString = month + " " + year + "\n";
		for (int i = 0; i < entries.length; i++)
		{
			if (entries[i] != null)
			{
				myString += entries[i].toString() + "\n";
			}
		}
		return myString;
	}
}
