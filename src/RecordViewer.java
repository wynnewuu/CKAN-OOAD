/** RecordViewer 
    An abstract class that enables us to polymorphically view records either in graphic or console mode
    all derived classes (viewers) must implement the abstract method displayViewer()

    @author Dr. Ziad Kobti
    (C)2018 All Rights Reserved to the author. 
    This code is strictly for education use. May not be reproduced without
    express written permission of the author.
*/

abstract class RecordViewer extends FileTemplate
{
	public RecordList records;		// the master RecordList loaded from a file
	public int currentRecord;		// you view a currentRecord by its index

	public abstract void displayViewer();

	// The idea behind the constructor is that when you instantiate a RecordViewer you
	// shall have the RecordList created and loaded from the file, all sorted and ready to be viewed. 
	public RecordViewer(FileTemplate fileTemplate)
	{
		super(fileTemplate);
		records = new RecordList(fileTemplate);
		records.loadRecords(fileTemplate);
		records.sort();
	}

}
