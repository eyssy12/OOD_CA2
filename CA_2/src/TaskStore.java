import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;


public class TaskStore extends ArrayList<Task> implements Serializable
{
	enum EditType
	{
		DESCRIPTION,
		LEADER,
		CREATE_DATE,
		DUE_DATE,
		FINISH_DATE,
		TASK_STATUS,
		NOTIFY_OVERDUE;
		
		public String toString()
		{
			if (this.ordinal() == 0)
				return "Description edit";
			else if (this.ordinal() == 1)
				return "Leader edit";
			else if (this.ordinal() == 2)
				return "Date created on edit";
			else if (this.ordinal() == 3)
				return "Date due on edit";
			else if (this.ordinal() == 4)
				return "Date completed on edit";
			else if (this.ordinal() == 5)
				return "Task status edit";
			else
				return "Notify overdue edit";
		}
	}
	
	private static TaskComparator comp = new TaskComparator(TaskComparator.SortType.STATUS);
	private String name;
	
	public TaskStore(String name)
	{
		this.name = name;
	}
	
	public boolean addTask(Task task)
	{
		if (!this.contains(task))
		{
			this.add(task);
			return true;
		}
		
		return false;
	}
	
	public boolean edit(Task task, EditType editType, Object newChange)
	{
		if (this.contains(task))
		{
			if (editType == EditType.DESCRIPTION)
				task.setDescription((String)newChange);
			else if (editType == EditType.LEADER)
				task.setLeader((Person)newChange);
			else if (editType == EditType.CREATE_DATE)
				task.setAddDate((TaskDate)newChange);
			else if (editType == EditType.DUE_DATE)
				task.setDueDate((TaskDate)newChange);
			else if (editType == EditType.FINISH_DATE)
				task.setFinishDate((TaskDate)newChange);
			else if (editType == EditType.TASK_STATUS)
				task.setTaskStatus((Task.Status) newChange);
			else
				task.setNotifyOverdue((Boolean)newChange);
			
			return true;
		}
		
		return false;
	}
	
	public void print()
	{
		for (Task t : this)
		{
			System.out.println(t);
			System.out.println();
		}
	}
	
	public void setSortOrder(TaskComparator.SortOrder newSortOrder)
	{
		this.comp.setSortOrder(newSortOrder);
	}
	
	public void setSortType(TaskComparator.SortType newSortType)
	{
		this.comp.setSortType(newSortType);
	}
	
	public ArrayList<Task> getTasksSortedByStatus()
	{
		ArrayList<Task> list = new ArrayList<Task>();
		list = this;

		Collections.sort(list, this.comp);
	
		return list;
	}
	
	public ArrayList<Task> getTasksByDateRange(TaskDate targetDate)
	{
		ArrayList<Task> list = new ArrayList<Task>();
		
		for (int i = 0; i < this.size(); i++)
		{	
			if (this.get(i).getDueDate().compareTo(targetDate) == TaskDate.BEFORE)
			{
				list.add(this.get(i));
			}	
		}
		
		return list;
	}
	
	public void printTasksLite()
	{
		System.out.println("Store: " + this.name + "\nTasks: " + this.size());
		System.out.println("--------------------");
		System.out.println();
		for (int i = 0; i < this.size(); i++)
		{
			System.out.println("-( " + (i+1) + " )-");
			this.get(i).printTaskDetailsLite();
			System.out.println();
		}
		System.out.println();

	}
	
	public void printTasksByLeader(Person searchLeader)
	{
		boolean found = false;
		
		System.out.println("Tasks under: " + searchLeader.getName() + "\nID: " + searchLeader.getID());
		System.out.println("---------------------------");
		
		for (int i = 0; i < this.size(); i++)
		{
			if (searchLeader.getID().equalsIgnoreCase(this.get(i).getLeaderID()))
			{
				System.out.println(this.get(i));
				System.out.println();
				
				found = true;
			}
		}
		
		if (!found)
		{
			System.out.println("None found");
		}
	}
	
	public ArrayList<Task> getTasksByTaskStatus(Task.Status searchStatus)
	{
		ArrayList<Task> list = new ArrayList<Task>();
		
		for (Task t : this)
		{
			if (searchStatus == t.getTaskStatus())
			{
				list.add(t);
			}
		}
		
		return list;
	}
	
	public boolean removeTask(Task task)
	{
		if (this.contains(task))
		{
			this.remove(task);
			return true;
		}
		
		return false;
	}
	
	public ArrayList<Task> getTaskList()
	{
		return new ArrayList<Task>(this);
	}
	
	public void addTaskList(ArrayList<Task> list)
	{
		for(int i = 0; i < list.size(); i++)
		{
			this.add(list.get(i));
		}
	}
	
	public boolean compareStores(ArrayList<Task> list1, ArrayList<Task> list2)
	{
		if (list1.containsAll(list2) && list2.containsAll(list1))
		{
			return true;
		}
		
		return false;
	}
}
