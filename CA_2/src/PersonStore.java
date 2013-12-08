import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PersonStore extends ArrayList<Person> implements Serializable
{
	enum EditType
	{
		NAME, EMAIL, TELEPHONE;
		
		public String toString()
		{
			if (this.ordinal() == 0)
				return "Name Edit";
			else if (this.ordinal() == 1)
				return "Email Edit";
			else
				return "Telephone Edit";
		}
	}
	
	private String name;
	
	public PersonStore(String name)
	{
		this.name = name;
	}
	
	public boolean addPerson(Person person)
	{
		if (!this.contains(person))
		{
			this.add(person);
			return true;
		}
		
		return false;
	}
	
	public void print()
	{
		for (Person p : this)
		{
			System.out.println(p);
		}
	}
	
	public void print(Person person)
	{
		if (this.contains(person))
			System.out.println(person);
	}
	
	public Person getPersonByID(String id)
	{
		Person p = null;
		boolean found = false;
		int index = 0;
		
		while (index < this.size() && !found)
		{
			if (id.equalsIgnoreCase(this.get(index).getID()))
			{
				p = this.get(index);
			}
		}
		
		return p;
	}
	
	public boolean edit(Person person, EditType editType, Object newChange)
	{
		if (this.contains(person))
		{
			if (editType == EditType.NAME)
			{
				person.setName((String)newChange);
			}
			else if (editType == EditType.EMAIL)
			{
				person.setEmail((String)newChange);
			}
			else
			{
				person.setTelephone((String)newChange);
			}
			
			return true;
		}
		
		return false;
	}
	
	public boolean removePerson(Person person)
	{
		if (this.contains(person))
		{
			this.remove(person);
			return true;
		}
			
		return false;
	}
	
}
