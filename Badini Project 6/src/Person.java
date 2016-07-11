/**
 * Person class containing first and last name, address, email,
 * phone number, and birthday
 * 
 * @author Luke Badini
 * @version 5/14/2015
 */
public class Person implements Contact
{
	private String firstName;
	private String lastName;
	private String address;
	private String email;
	private String phone;
	private String birthday;
	
	/**
	 * Person constructor
	 */
	public Person()
	{
		firstName = "";
		lastName = "";
		address = "";
		email = "";
		phone = "";
		birthday = "";
	}
	
	/**
	 * @return the first name of the person
	 */
	public String getFirstName()
	{
		return firstName;
	}
	
	/**
	 * Sets the first name of the person
	 * @param name; new first name
	 */
	public void setFirstName(String name)
	{
		firstName = name;
	}
	
	/**
	 * @return the last name of the person
	 */
	public String getLastName()
	{
		return lastName;
	}
	
	/**
	 * Sets the last name of the person
	 * @param name; new last name
	 */
	public void setLastName(String name)
	{
		lastName = name;
	}
	
	/**
	 * @return the address of the person
	 */
	public String getAddress()
	{
		return address;
	}
	
	/**
	 * Sets a new address for the person
	 * @param newAddress; the new address of the person
	 */
	public void setAddress(String newAddress)
	{
		address = newAddress;
	}
	
	/**
	 * @return the email of the person
	 */
	public String getEmail()
	{
		return email;
	}
	
	/**
	 * Sets a new email for the person
	 * @param newEmail; the new email of the perosn
	 */
	public void setEmail(String newEmail)
	{
		email = newEmail;
	}
	
	/**
	 * @return the phone number of the person
	 */
	public String getPhone()
	{
		return phone;
	}
	
	/**
	 * Sets a new phone number for the person
	 * @param number; new phone number of the person
	 */
	public void setPhone(String number)
	{
		phone = number;
	}
	
	/**
	 * @return the birthday of the person
	 */
	public String getBirthday()
	{
		return birthday;
	}
	
	/**
	 * Sets a new birthday for the person
	 * @param newBirthday; the new birthday of the person
	 */
	public void setBirthday(String newBirthday)
	{
		birthday = newBirthday;
	}
	
	/**
	 * Returns last name, first name of the person
	 * as a String
	 */
	public String getName()
	{
		return lastName + "," + firstName;
	}
	
	/**
	 * Compares the name of this person to the name of
	 * another contact using the Comparable compareTo method
	 */
	@Override public int compareTo(Contact contact)
	{
		return this.getName().compareTo(contact.getName());
	}
	
	/**
	 * @return the Person as a string
	 */
	public String toString()
	{
		return firstName + " " + lastName + " " + address + " " + 
				email + " " + phone + " " + birthday;
	}
}
