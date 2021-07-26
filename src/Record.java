/** Record is a class that abstracts a single record in a file.
    A Record is a list (hashmap) of ordered Fields.
    Hence an inner class "Field" is defined as an abstraction where one Record
    may contain any number of Fields, and a Field contains a field label, type and value.
    @author Dr. Ziad Kobti
    (C)2018 All Rights Reserved to the author. 
    This code is strictly for education use. May not be reproduced without
    express written permission of the author.
*/

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Iterator;

public class Record extends FileTemplate
{	

	public HashMap<Integer, Field> recordMap;


	/** A valuable public utility method that allows me to create a record from a line!
         The actual line is a comma delimited list of field values that we read from a file
         This method simply parses a given line and generates a record with all the fields
         according to the RecordTemplate definitions. 
     */
	public Record(String line, FileTemplate ft)	// create a record from a line
	{
		super(ft);
		int i;
		recordMap = new HashMap<>(); 
		StringTokenizer st = new StringTokenizer(line, this.delimiter);

		for (i=0; i < this.fieldNumber; i++)
		{
			recordMap.put(i, new Field(this.getFieldTypes().get(i), this.getFieldLabels().get(i), st.nextToken()));
		}		
	}	

	/** A Record has a list of fields - use this set method to change the value of
         any field by its index.

	*/
	public boolean setFieldValue(int fieldIndex, String newValue)
	{
		if (fieldIndex < 0 || fieldIndex > this.getFieldNumber()) return false;

		Field newField = new Field(recordMap.get(fieldIndex).type, recordMap.get(fieldIndex).label, newValue);

		// This is the advantage of a hashmap over a list... no need to "search" for an element to
		// to change its value, simply use the "hash key" which is just the index of the field. 
		// O(C) efficiency!
		recordMap.replace(fieldIndex, newField);

		return true;
	}

	/** toString for a given Record - demonstrate the use of Iterator over a list */
	public String toString()
	{
		String line="";
		Iterator<Integer> keySetIterator = recordMap.keySet().iterator(); 
		Integer key;
		while(keySetIterator.hasNext())
		{ 
			key = keySetIterator.next(); 
			if (key == 0) line+=recordMap.get(key);
			else line+=this.getDelimiter()+recordMap.get(key);
		}
		return line;
	}

	/** useful bunch of gets.... */
	public String getType(int fieldIndex)	// fieldIndex same as column number in file
	{
		return recordMap.get(fieldIndex).type;
	}
	public String getLabel(int fieldIndex)
	{
		return recordMap.get(fieldIndex).label;
	}
	public String getValue(int fieldIndex)
	{
		return recordMap.get(fieldIndex).value;
	}


	// inner class Field; a Record has many Fields...A Field has type, label and value
	// e.g. Field: String first_name Jim
	class Field
	{
		public String type;
		public String label;
		public String value;

		public Field(String type, String label, String value)
		{
			this.type = type;
			this.label = label;
			this.value = value;
		}

		public String toString()
		{
			return type + " " + label + " " + value;
		}
	}

}


