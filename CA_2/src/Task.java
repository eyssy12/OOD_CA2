import java.io.Serializable;
import java.util.ArrayList;

public class Task implements Serializable
{
	enum Status
	{
		ONGOING("Ongoing"), COMPLETED("Completed"), CANCELLED("Cancelled"), PAUSED("Paused");
		
		private String value;
		private Status(String value)
		{
			this.value = value;
		}
		
		public String getValue()
		{
			return this.value;
		}
	}
	
	static final boolean NOTIFY_YES = true;
	static final boolean NOTIFY_NO = false;
	private static IDGenerator taskIDGenerator = new IDGenerator(IDGenerator.IDType.TASK);
	
	private String description, taskID, leaderID;
	private Person leader;
	private ArrayList<Person> teamMembers;
	private TaskDate createDate, dueDate, finishDate;
	private Status taskStatus;
	private boolean notifyOverdue;
	
	// test constructor
	public Task()
	{
		this.description = "-";
		this.leader = new Person("Name", "Email", "Telephone");
		this.taskID = Task.taskIDGenerator.getUnique(1, 99999);
		this.leaderID = this.leader.getID();
		this.teamMembers = new ArrayList<Person>();
		this.createDate = new TaskDate();
		this.dueDate = new TaskDate();
		this.finishDate = new TaskDate();
		this.taskStatus = Status.ONGOING;
		this.notifyOverdue = NOTIFY_YES;
	}
	public Task(String description, Person leader)
	{
		this.description = description;
		this.leader = leader;
		this.taskID = Task.taskIDGenerator.getUnique(1,  99999);
		this.leaderID = this.leader.getID();
		this.teamMembers = new ArrayList<Person>();
		this.createDate = new TaskDate(30,0,2013);
		this.dueDate = new TaskDate(3, 9, 2013);
		this.finishDate = new TaskDate(30,11,2015);
		this.taskStatus = Status.ONGOING;
		this.notifyOverdue = NOTIFY_YES;
	}
	
	public Task(String description, Person leader, ArrayList<Person> teamMembers,
			TaskDate createDate, TaskDate dueDate, TaskDate finishDate)
	{
		this.description = description;
		this.leader = leader;
		this.taskID = Task.taskIDGenerator.getUnique(1,  99999);
		this.leaderID = this.leader.getID();
		this.teamMembers = teamMembers;
		this.createDate = createDate;
		this.dueDate = dueDate;
		this.finishDate = finishDate;
		this.taskStatus = Status.ONGOING;
		this.notifyOverdue = NOTIFY_YES;
	}
	
	// getters and setters
	public String getDescription()
	{
		return description;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}
	public String getTaskID()
	{
		return taskID;
	}
	public String getLeaderID()
	{
		return leaderID;
	}
	public Person getLeader()
	{
		return leader;
	}
	public void setLeader(Person leader)
	{
		this.leader = leader;
	}
	public ArrayList<Person> getTeamMembers()
	{
		return teamMembers;
	}
	public void setTeamMembers(ArrayList<Person> teamMembers)
	{
		this.teamMembers = teamMembers;
	}
	public TaskDate getCreateDate()
	{
		return createDate;
	}
	public void setAddDate(TaskDate createDate)
	{
		this.createDate = createDate;
	}
	public TaskDate getDueDate()
	{
		return dueDate;
	}
	public void setDueDate(TaskDate dueDate)
	{
		this.dueDate = dueDate;
	}
	public TaskDate getFinishDate()
	{
		return finishDate;
	}
	public void setFinishDate(TaskDate finishDate)
	{
		this.finishDate = finishDate;
	}
	public Status getTaskStatus()
	{
		return taskStatus;
	}
	public void setTaskStatus(Status taskStatus)
	{
		this.taskStatus = taskStatus;
	}
	public boolean isNotifyOverdue()
	{
		return notifyOverdue;
	}
	public void setNotifyOverdue(boolean notifyOverdue)
	{
		this.notifyOverdue = notifyOverdue;
	}

	// helpers
	private String getNotifyOverdueStr()
	{
		if (this.notifyOverdue == NOTIFY_YES)
			return "Yes";
		else
			return "No";
	}
	private String getTeamMembersStr()
	{
		String members = "";
		
		for (int i = 0; i < teamMembers.size(); i++)
		{
			if (i == (teamMembers.size() - 1))
			{
				members += teamMembers.get(i).getName();
			}
			else
			{
				members += teamMembers.get(i).getName() + ", ";
			}
		}
		
		return members;
	}
	
	// methods
	public boolean addTeamMember(Person p)
	{
		if (!this.teamMembers.contains(p))
		{
			this.teamMembers.add(p);
			return true;
		}
		
		return false;
	}
	
	public void printTaskDetails()
	{
		System.out.println(this.toString());
	}
	
	public void printTaskDetailsLite()
	{
		System.out.println("Task ID: " + this.taskID);
		System.out.println("Description: " + this.description);
		System.out.println("Leader: " + this.leader.getName());
		System.out.println("Status: " + this.taskStatus);
		System.out.println();
	}
	
	@Override
	public String toString()
	{
		return "Description: " + this.description
				+ "\nTask ID: " + this.taskID
				+ "\nTask Leader: " + this.leader.getName()
				+ "\nTask Leader ID: " + this.leader.getID()
				+ "\nTask Team: " + getTeamMembersStr()
				+ "\nAdded On: " + this.createDate
				+ "\nDue On: " + this.dueDate
				+ "\nCompleted On: " + this.finishDate
				+ "\nStatus: " + this.taskStatus.getValue()
				+ "\nNotify Overdue: " + getNotifyOverdueStr()
				+ "\n";
	}
	
}
