/**
 * An class defining an address book that holds Contact objects
 * 
 * @author Luke Badini
 * @version 5/16/2015
 */
import java.util.Scanner;

public class AddressBook 
{
	private GenericLinkedList<Contact> addressBook;
	
	public AddressBook()
	{
		addressBook = new GenericLinkedList<Contact>();
	}
	
	/**
	 * Adds a Contact to the address book via user input.
	 */
	// I couldn't figure out how to make it detect hitting the
	// enter key so I wasn't able to make it require a name or
	// make other fields empty. If I was able to do that,
	// I would add in a while loop that would keep asking
	// for a name until getName() != ""
	public void add()
	{		
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Person or Business? ");
		String contactType = keyboard.next();
		
		if (contactType.equalsIgnoreCase("person"))
		{
			Person person = new Person();

			System.out.print("Last name: ");
			person.setLastName(keyboard.next());

			System.out.print("First name: ");
			person.setFirstName(keyboard.next());
			
			System.out.print("Address: ");
			person.setAddress(keyboard.next());
			
			System.out.print("Email: ");
			person.setEmail(keyboard.next());
			
			System.out.print("Phone: ");
			person.setPhone(keyboard.next());
			
			System.out.println("Birthday: ");
			person.setBirthday(keyboard.next());
			
			addressBook.insertSorted((Contact) person);
			
		}
		else if(contactType.equalsIgnoreCase("business"))
		{
			Business business = new Business();

			System.out.print("Name: ");
			business.setName(keyboard.next());

			System.out.print("Address: ");
			business.setAddress(keyboard.next());
			
			System.out.print("Email: ");
			business.setEmail(keyboard.next());
			
			System.out.print("Phone: ");
			business.setPhone(keyboard.next());
			
			System.out.print("Hours: ");
			business.setHours(keyboard.next());
			
			addressBook.insertSorted((Contact) business);
		}
		else
		{
			System.out.println("Invalid contact");
		}
	}
	/**
	 * Prints the information of the person or business given their name.
	 * Assumes names are given in "last,first" format.
	 * 
	 * @param contactName; name of the contact being found
	 */
	public void find(String contactName)
	{
		Person person = new Person();
		String[] personName = contactName.split("[,]");
		if (personName.length > 1)
		{
			person.setFirstName(personName[1]);
		}
		person.setLastName(personName[0]);
		
		Business business = new Business();
		business.setName(contactName);
		
		Contact personFind = addressBook.find(person);
		Contact businessFind = addressBook.find(business);
		if (personFind != null)
		{
			System.out.println(personFind.toString());
		}
		else if (businessFind != null)
		{
			System.out.println(businessFind.toString());
		}
		else
		{
			System.out.println("Contact '" + contactName + "' not found.");
		}
	}
	
	/**
	 * Finds the contact with the given name, removes it, and
	 * prints a message informing the user of what was deleted.
	 * 
	 * @param contactName; the name of the contact to be removed
	 */
	public void remove(String contactName)
	{
		Person person = new Person();
		String[] personName = contactName.split("[,]");
		if (personName.length > 1)
		{
			person.setFirstName(personName[1]);
		}
		person.setLastName(personName[0]);
		
		Business business = new Business();
		business.setName(contactName);
		
		if (addressBook.findRemove(person) || addressBook.findRemove(
				business))
		{
			System.out.println(contactName + " found and removed.");
		}
		else
		{
			System.out.println(contactName + " not found.");
		}
		
	}
}
