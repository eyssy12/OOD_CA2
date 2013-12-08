import java.util.Comparator;


public class TaskComparator implements Comparator<Task>
{
	public enum SortType
	{
		STATUS, LEADER_ID, DESCRIPTION;
		
		public String toString()
		{
			if (this.ordinal() == 0)
				return "Status";
			else if (this.ordinal() == 1)
				return "Leader ID";
			else
				return "Description";
		}
	}
	
	public enum SortOrder
	{
		ASCENDING(1), DESCENDING(-1);

		private int sortOrder;

		private SortOrder(int sortOrder)
		{
			this.sortOrder = sortOrder;
		}
		
		public int getValue()
		{
			return this.sortOrder;
		}
		
		public String toString()
		{
			if (this.ordinal() == 0)
				return "Ascending order";
			else
				return "Descending order";
		}
	}
	
	private SortType actualSortType;
	private SortOrder actualSortOrder = SortOrder.ASCENDING;
	
	public TaskComparator(SortType actualSortType)
	{
		this.actualSortType = actualSortType;
	}
	
	public void setSortType(SortType actualSortType)
	{
		this.actualSortType = actualSortType;
	}

	public void setSortOrder(SortOrder actualSortOrder)
	{
		this.actualSortOrder = actualSortOrder;
	}
	
	@Override
	public int compare(Task t1, Task t2)
	{
		int order = this.actualSortOrder.getValue();
		
		if (this.actualSortType == SortType.STATUS)
		{
			return order * t1.getTaskStatus().getValue().compareTo(t2.getTaskStatus().getValue());
		}
		else if (this.actualSortType == SortType.LEADER_ID)
		{
			// Person ids contain a indentifier, hence we cut of that part and convert to an Integer
			String v1 = t1.getLeaderID().substring(3);
			String v2 = t2.getLeaderID().substring(3);
			int num1 = Integer.parseInt(v1);
			int num2 = Integer.parseInt(v2);
			
			int diff = num1 - num2;
			
			if (diff > 0)
				return order * 1;
			else if (diff < 0)
				return order * -1;
			else
				return 0;
		}
		else
		{
			return order * t1.getDescription().compareTo(t2.getDescription());
		}
	}
}
