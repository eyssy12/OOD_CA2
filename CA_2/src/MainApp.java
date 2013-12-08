import java.util.ArrayList;



public class MainApp
{
	public static void main(String[] args)
	{
		MainApp theApp = new MainApp();
		theApp.start();
	}
	
	private void start()
	{
		Menu menu = new Menu("Task Management Application");
		
		TaskStore store1 = new TaskStore("My store");
		PersonStore personStore = new PersonStore("huh");
		
		/*
		Person p1 = new Person("Person 1" , "jaksjkskjakjk", "4094039043");
		Person p2 = new Person("Person 2", "bbbbbbbbbbbbb", "09504323");
		
		personStore.addPerson(p1);
		personStore.addPerson(p2);
		
		Task t1 = new Task("ZZZ Build a new IPhone 6", p1);
		Task t2 = new Task("CDA Create GUI for the new MacBook Chrome", p2);
		Task t3 = new Task("CAD Task 4", p2);
		Task t4 = new Task("AA Task 4", p1);
		store1.addTask(t2);
		store1.addTask(t1);
		store1.addTask(t3);
		store1.addTask(t4);
		*/
		
		menu.addChoice("Manage people");
		menu.addChoice("Manage tasks");
		menu.addChoice("Eat shet");
		menu.addChoice("222");
		
		int choice = 0;
		do
		{
			menu.printChoices();
			choice = MyScanner.getInt("Enter choice: ", menu.getFirstChoice(), menu.getLastChoice());

			
			if (choice == menu.getLastChoice())
			{
				menu.printMessageWithBorders("Finishing....");
			}
		}while(choice != menu.getLastChoice());	
	}
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private void test()
	{
		/*
		TaskDate date = new TaskDate(31,10,2013);
		TaskDate date2 = new TaskDate(30,8,2013);
		TaskDate date3 = new TaskDate(5,3,2013);
		TaskDate date4 = new TaskDate(12,6,2013);
		TaskDate date5 = new TaskDate(6,11,2013);
		TaskDate date6 = new TaskDate(21,3,2013);
		TaskDate date7 = new TaskDate(4,9,2013);
		
		ArrayList<TaskDate> dates = new ArrayList<TaskDate>();
		dates.add(date2);
		dates.add(date3);
		dates.add(date4);
		dates.add(date5);
		dates.add(date6);
		dates.add(date7);
		*/
		
		/*
		ArrayList<TaskDate> list = new ArrayList<TaskDate>();
		for (int i = 0; i < dates.size(); i++)
		{
			if (date.compareTo(dates.get(i)) == TaskDate.BEFORE)
				System.out.println(dates.get(i));	
		}
		*/
		
		/*
		 * Returns a list with all tasks due within a date range
		 
		TaskDate searchDate = new TaskDate(3, 9, 2013);
		ArrayList<Task> dueList = store1.getTasksByDateRange(searchDate);
		
		System.out.println("Tasks due on " + searchDate);
		System.out.println("--------------------------");
		for (Task t : dueList)
		{
			System.out.println(t);
		}
		*/ 
		
		/*
		// copy ones store contents into another
		TaskStore copy = new TaskStore("My Store");
		copy.addTaskList(store1.getTaskList());
		
		
		store1.print();
		System.out.println();
		copy.print();
		*/
		// compare two stores for equality
		//System.out.println(store1.compareStores(store1.getTaskList(), copy.getTaskList()));
		
		// Get tasks by status
		//ArrayList<Task> list = store1.getTasksByTaskStatus(Task.Status.ONGOING);
		//System.out.println(list.size());
		
		/*
		store1.setSortOrder(TaskComparator.SortOrder.ASCENDING);
		store1.setSortType(TaskComparator.SortType.LEADER_ID);
		store1.print();
		System.out.println();
		System.out.println();
		
		ArrayList<Task> sortedListStatus = store1.getTasksSortedByStatus();
		
		for (Task t: sortedListStatus)
		{
			System.out.println(t);
			System.out.println();
		}
		*/
		
		
		/*
		personStore.print();
		if (personStore.removePerson(p1, p1.getID()))
		{
			System.out.println("Removed");
		}
		else
		{
			System.out.println("Not found");
		}
		System.out.println("------------------------");
		
		personStore.print();
		
		*/
		//p1.personIDGenerator.printUsedIDValues();
		
		/*
		// create tasks, unique - works
		Task t1 = new Task("Build a new IPhone 6", p1, Task.Status.ONGOING, Task.NOTIFY_YES);
		Task t2 = new Task("Create GUI for the new MacBook Chrome", p1, Task.Status.PAUSED, Task.NOTIFY_YES);
		
		store1.addTask(t1, t1.getTaskID());
		store1.addTask(t2, t2.getTaskID());
		*/
		
		/*
		 * Edit, remove, print - all works
		 * 
		store1.printAllTaskDetails();
		System.out.println("-----------------------------------------");
		
		store1.edit(t1.getTaskID(), TaskStore.EditType.TASK_STATUS, Task.Status.PAUSED);
		store1.remove("EMP490349039430");
		
		store1.printAllTaskDetails(); 
		
		*/
		
		/*
		 * Print all tasks that a leader is ruling - works
		 * 
		store1.printTasksByLeader(p1);
		store1.printAllTaskDetails();
		store1.edit(t1.getTaskID(), TaskStore.EditType.DESCRIPTION, "Finish the project on the bastards");
		*/
		
		/*
		 * Serialization Test - works
		SerializationUtility.save("c:/test/", "store.txt", store1);
		
		TaskStore test = (TaskStore)SerializationUtility.load("c:/test/", "store.txt");
		test.printAllTaskDetails();
		*/
		
		/* default tests
		 * 
			Task t1 = new Task();
			Task t2 = new Task();
			Task t3 = new Task();
			Task t4 = new Task();
			Task t5 = new Task();
			Task t6 = new Task();
			Task t7 = new Task();
			Task t8 = new Task();
			
			store1.addTask(t1, t1.getTaskID());
			store1.addTask(t2, t2.getTaskID());
			store1.addTask(t3, t3.getTaskID());
			store1.addTask(t4, t4.getTaskID());
			store1.addTask(t5, t5.getTaskID());
			store1.addTask(t6, t6.getTaskID());
			store1.addTask(t7, t7.getTaskID());
			store1.addTask(t8, t8.getTaskID());
		 */
		
		//t1.taskIDGenerator.printUsedIDValues();
		
		// use a hash map to store the taskStore objects which hold a set of lists of the tasks
		//HashMap<String, TaskStore> map = new HashMap<String, TaskStore>();

		
		//store1.printAllTaskDetails();
		
		
		//TaskDate d1 = new TaskDate(23,5,2013);
		//TaskDate d2 = new TaskDate(28,6,2013);
		//System.out.println(d1.compareTo(d2));
		
		
		
		/*
		 * get the all tasks by task status - works
		 * 
		ArrayList<Task> list = store1.getTasksByTaskStatus(Task.Status.ONGOING);
		for (Task t : list)
		{
			System.out.println(t);
			System.out.println();
		}
		*/
	}
}
