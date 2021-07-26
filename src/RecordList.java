/** RecordList maintains a list of Record(s)
	Records can be loaded from a file

    @author Dr. Ziad Kobti
    (C)2018 All Rights Reserved to the author. 
    This code is strictly for education use. May not be reproduced without
    express written permission of the author.
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

class RecordList extends FileTemplate
{

	// Could use hashmap as well here, however I opted to demonstrate how ArrayList can be used
	public ArrayList<Record> recordList;

	/** default constructor */
	public RecordList(FileTemplate fileTemplate)
	{
		super(fileTemplate);
		recordList = new ArrayList<>();

	}

	/** get a Record given its index from the list of records */
	public Record get(int n)
	{
		return recordList.get(n);
	}

	/** Load records from a file, defined filename in RecordTemplate */
	public int loadRecords(FileTemplate ft)
	{
		try
		{
			String line = null;
			BufferedReader br = new BufferedReader(new FileReader(this.filename));
			
			while ((line = br.readLine()) != null) 
			{	
				if (line.trim().length()==0) continue;	// skip empty line
			
				// So convenient to use the overloaded construcor of Record that takes a Line!
				recordList.add(new Record(line, ft));
  			}
			br.close();
		}
		catch(IOException ioe)
		{
			System.err.println(ioe);
		}
		
		return recordList.size();
	}

	/** New way without using the old Iterator method - only in Java 8 and above! */
	public void sort() // sort according to primary key defined in RecordTemplate
	{
   	// todo: make this support different data types such as dates, int etc.
		recordList.sort((Record r1, Record r2)->r1.getValue(this.primary_field).compareTo(r2.getValue(this.primary_field)));
        recordList.forEach((r)->System.out.println(r));
	}
	
	public int size()
	{
		return recordList.size();
	}	

	public String toString()
	{
		String s="";

        Iterator<Record> RecordIterator = recordList.iterator();
		Record record;
		while(RecordIterator.hasNext())
		{ 
			record = RecordIterator.next();
			s+=record.toString()+"\n";
		}

		return s;	// this string will contain all the lines (ie. all the records)
	}
	
}

