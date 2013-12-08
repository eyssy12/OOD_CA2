import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TaskDate implements Comparable, Serializable
{
	private Calendar TaskDate;
	
	static final byte BEFORE = 1;
	static final byte AFTER = -1;
	static final byte SAME = 0;
	
	public TaskDate()
	{
		this.TaskDate = Calendar.getInstance();
		this.TaskDate.set(31, 1, 2013);
	}
	
	public TaskDate(int day, int month, int year)
	{
		this.TaskDate = Calendar.getInstance();
		this.TaskDate.set(year, month, day);
	}

	public Calendar getDate() 
	{
		return TaskDate;
	}

	public void setDate(Calendar taskDate)
	{
		this.TaskDate = taskDate;
	}
	
	@Override
	public String toString()
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");
		String dateFormatted = dateFormat.format(this.TaskDate.getTime());
		
		return dateFormatted;
	}

	@Override
	public int compareTo(Object obj)
	{
		if (obj == null)
			return 0;
		if (this.getClass() != obj.getClass())
			return 0;
		
		TaskDate date = (TaskDate)obj;
		
		return doCompare(date);
	}	
	
	private int doCompare(TaskDate thatDate)
	{
		if (this.TaskDate.before(thatDate.getDate()))
			return this.BEFORE;
		else if (this.TaskDate.after(thatDate.getDate()))
			return this.AFTER;
		else
			return this.SAME;
	}
}
