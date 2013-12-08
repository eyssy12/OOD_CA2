
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class IDGenerator
{
	private HashSet<String> generatedIDSet;
	private IDType actualIDType;
	
	enum IDType
	{
		PERSON("EMP"), TASK("TSK");
		
		private String identifier;
		private IDType(String identifier)
		{
			this.identifier = identifier;
		}
		
		public String getValue()
		{
			return this.identifier;
		}
		
		public void setValue(String identifier)
		{
			this.identifier = identifier;
		}
		
		public String toString()
		{
			if (this.ordinal() == 0)
				return "Employee ID";
			else 
				return "Task ID";
		}
	}
	
	public IDGenerator(IDType actualIDType)
	{
		this.generatedIDSet = new HashSet<String>();
		this.actualIDType = actualIDType;
	}
	
	public boolean addUniqueValue(String number)
	{
		if (!this.generatedIDSet.contains(number))
		{
			this.generatedIDSet.add(number);
			return true;
		}
		
		return false;
	}
	
	public void printUsedIDValues()
	{
		Iterator<String> iterator = this.generatedIDSet.iterator(); 

		while (iterator.hasNext())
		{
			String str = iterator.next();
			
			System.out.println(str);
		}
		
		System.out.println();
	}

	private int getRandomNumber(int lo, int hi)
	{
		return (int)Math.round((hi - lo) * Math.random() + lo);
	}
	
	public String getUnique(int lo, int hi)
	{
		int limit = (hi-lo)+1;
		if (this.generatedIDSet.size() == limit)
			return "No numbers left!";
		
		int uniqueNum = 0;
		String uniqueIDStr = "";
		boolean isUnique = false;
		
		while (!isUnique)
		{
			uniqueNum = getRandomNumber(lo, hi);
			
			// get the appropriate identifier for the type of id 
			// then build a string using the identifier and the unique number
			uniqueIDStr = this.actualIDType.getValue() + uniqueNum;
			
			if (!addUniqueValue(uniqueIDStr))
			{
				isUnique = false;
			}
			else
			{
				isUnique = true;
			}
		}
		
		return uniqueIDStr;
	}
}
