/** ConsoleViewer is a RecordViewer... so it can displayRecord()
    This is a text mode interactive implementation of the viewer.

    @author Dr. Ziad Kobti
    (C)2018 All Rights Reserved to the author. 
    This code is strictly for education use. May not be reproduced without
    express written permission of the author.
*/

import java.util.Scanner;
import java.util.InputMismatchException;

class ConsoleViewer extends RecordViewer
{
	// public RecordList records;   <-- that's already in the base class!

	public ConsoleViewer(FileTemplate fileTemplate)
	{
		super(fileTemplate);				// <-- base class constructor to create the list, load and sort it.
	}

	public void displayViewer()
	{
		boolean done = false;
		currentRecord=0;
		char selection;

		displayRecord();

		do
		{	
			displayMenu();
			selection = getSelection("fnpleaxv");
			switch(selection)
			{
				case 'f':
					currentRecord = 0;
					displayRecord();
					break;
				case 'n':
					currentRecord = (currentRecord==records.size()-1)?currentRecord:currentRecord+1;
					displayRecord();
					break;
			 	case 'p':
					currentRecord = (currentRecord==0)?currentRecord:currentRecord-1;
					displayRecord();
					break;
				case 'l':
					currentRecord = records.size()-1;
					displayRecord();
					break;
				case 'e':
					System.out.println("TODO");
					break;
				case 'a':
					displayRecords();
					break;
				case 'x':
					done = true;
					break;
				case 'v':
					visualizeRecords();
					break;
				default:
					// should not happen if you did the input right!
			}	
		}while(!done);
	}

	public void displayMenu()
	{
		System.out.print("[F]irst | [N]ext | [P]revious | [L]ast | [E]dit | [A]ll | [V]isualize | E[x]it >>");
	}

	public void displayRecord()
	{
		System.out.println(records.get(currentRecord));
	}
	
	public char getSelection(String optionString)
	{

		Scanner sc = new Scanner(System.in);
		char c='x';
		String pattern = "["+optionString.toLowerCase() + optionString.toUpperCase()+"]";
		boolean done = false;
		
		do
		{
			try
			{
				c = sc.next(pattern).trim().charAt(0);	
				c =  Character.toLowerCase(c);
				done = true;
			}
			catch(InputMismatchException imme)
			{
				done = false;
			}
		}while(!done);

		System.out.println("user selection = ["+c+"]");
		return c;

	}

	public void displayRecords()
	{
		System.out.println(records);	// recall that RecordList has a toString! 
								// not the best way to do this especially if you have a huge file.
	}

	public void visualizeRecords(){
		RecordVisualizer rv = new RecordVisualizer(this.records);
		System.out.println();
		rv.displayVisualization();
	}

}
