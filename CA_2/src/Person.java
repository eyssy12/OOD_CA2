import java.io.Serializable;


public class Person implements Serializable
{
	private static IDGenerator personIDGenerator = new IDGenerator(IDGenerator.IDType.PERSON);
	
	private String name, id, email, telephone;
	
	public Person()
	{
		this.name = "-";
		this.id = Person.personIDGenerator.getUnique(1, 99999);
		this.email = "default@default.com";
		this.telephone = "000-00000";
	}
	
	public Person(String name, String email, String telephone) 
	{
		this.name = name;
		this.id = Person.personIDGenerator.getUnique(1, 99999);
		this.email = email;
		this.telephone = telephone;
	}

	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getID()
	{
		return id;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public String getTelephone()
	{
		return telephone;
	}
	public void setTelephone(String telephone)
	{
		this.telephone = telephone;
	}
	
	@Override
	public String toString()
	{
		return "Name: " + this.name
				+ "\nID: " + this.id
				+ "\nE-mail: " + this.email
				+ "\nTelephone: " + this.telephone
				+ "\n";
	}
}
