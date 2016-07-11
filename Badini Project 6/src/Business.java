/**
 * Business class containing name, address, email,
 * phone number, and business hours
 * 
 * @author Luke Badini
 * @version 5/15/2015
 */
public class Business implements Contact
{
	private String name;
	private String address;
	private String email;
	private String phone;
	private String hours;
	
	/**
	 * Business constructor
	 */
	public Business()
	{
		name = "";
		address = "";
		email = "";
		phone = "";
		hours = "";
	}
	
	/**
	 * @return the name of the business
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Sets the name of the business
	 * @param newName; new name for the business
	 */
	public void setName(String newName)
	{
		name = newName;
	}
	
	/**
	 * @return the address of the business
	 */
	public String getAddress()
	{
		return address;
	}
	
	/**
	 * Sets the address of the business
	 * @param newAddress; new address of the business
	 */
	public void setAddress(String newAddress)
	{
		address = newAddress;
	}
	
	/**
	 * @return the email of the business
	 */
	public String getEmail()
	{
		return email;
	}
	
	/**
	 * Sets the email of the business
	 * @param newEmail; new email of the business
	 */
	public void setEmail(String newEmail)
	{
		email = newEmail;
	}
	
	/**
	 * @return the phone number of the business
	 */
	public String getPhone()
	{
		return phone;
	}
	
	/**
	 * Sets the phone number of the business
	 * @param newPhone; new phone number of the business
	 */
	public void setPhone(String newPhone)
	{
		phone = newPhone;
	}
	
	/**
	 * @return the business hour of the business
	 */
	public String getHours()
	{
		return hours;
	}
	
	/**
	 * Sets the business hours of the business
	 * @param newHours; the new hours of the business
	 */
	public void setHours(String newHours)
	{
		hours = newHours;
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
	 * @return the Business as a string
	 */
	public String toString()
	{
		return name + " " + address + " " + email + " " + phone + " " +
					hours;
	}
}
