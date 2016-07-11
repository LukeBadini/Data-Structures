/**
 * An interface representing entries in an address book.
 *
 * @author Kristina Striegnitz
 * @version Feb 2015
 */
public interface Contact extends Comparable<Contact> 
{
	public String getName ();
	public String getAddress ();
	public String getEmail ();
	public String getPhone ();
	
	public String toString ();
	
}
