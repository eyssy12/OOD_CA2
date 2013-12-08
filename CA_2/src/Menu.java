import java.util.ArrayList;


public class Menu
{
	private String heading;
	private ArrayList<String> choiceList = new ArrayList<String>();
	
	public Menu(String heading)
	{
		this.heading = heading;
	}
	
	public int getFirstChoice()
	{
		return (this.choiceList.size() - this.choiceList.size()) + 1;
	}
	
	public int getLastChoice()
	{
		return this.choiceList.size() + 1;
	}
	
	public int getChoiceCount()
	{
		return choiceList.size();
	}

	
	public void addChoice(String choice)
	{
		this.choiceList.add(choice);
	}
	
	public void printMessageWithBorders(String message)
	{
		byte size = (byte)message.length();
		
		System.out.println();
		for (int i = 0; i < size; i++)
		{
			System.out.print("-");
		}
		System.out.println();
		System.out.print(message);
		System.out.println();
		for (int i = 0; i < size; i++)
		{
			System.out.print("-");
		}
		System.out.println();
		System.out.println();
	}
	
	public void printChoices()
	{
		this.printMessageWithBorders(this.heading);
		for (int i = 0; i < this.choiceList.size(); i++)
		{
			System.out.println((i+1) +") " + this.choiceList.get(i));
		}
		
		System.out.println();
		System.out.println(this.getLastChoice() + ") Finish");
		System.out.println();
	}
}
