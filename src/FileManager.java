

/** FileManager
    A file manager controls the loading (really displaying) of the parameters
   and decides whther to instantiate a GraphicViewer or a ConsoleViewer 

*/

class FileManager
{
	public RecordViewer rv;
/*
	public FileManager(String mode)	// graphic or console
	{
		System.out.println("FileManager initiated....");

		System.out.println("FILE_NAME = " + FILE_NAME);
		System.out.println("NUMBER_OF_FIELDS " + NUMBER_OF_FIELDS);
		for (int i=0; i < NUMBER_OF_FIELDS; i++)
			System.out.println("FIELD: " + i + " " + FIELD_TYPES[i] + " " + FIELD_LABELS[i]);
		System.out.println("PRIMARY_KEY_FIELD_INDEX = " + FIELD_LABELS[PRIMARY_KEY_FIELD_INDEX]);

		if (mode.compareToIgnoreCase("graphics")==0)
		{
			System.out.println("Entering graphics mode...\n\n");
			rv = new GraphicViewer();
			rv.displayViewer();
		}
		else
		{
			// console by default
			System.out.println("Entering console mode...\n\n");
			rv = new ConsoleViewer();
			rv.displayViewer();
		}	
	}

 */
	public FileManager(FileTemplate fileTemplate){
		System.out.println("FileManager initiated....");

		System.out.println("FILE_NAME = " + fileTemplate.getFilename());
		System.out.println("NUMBER_OF_FIELDS " + fileTemplate.getFieldNumber());
		for (int i=0; i < fileTemplate.getFieldNumber(); i++)
			System.out.println("FIELD: " + i + " " + fileTemplate.getFieldTypes().get(i) + " " + fileTemplate.getFieldLabels().get(i));
		System.out.println("PRIMARY_KEY_FIELD_INDEX = " + fileTemplate.getFieldLabels().get(fileTemplate.getPrimary_field()));


		// console by default
		System.out.println("Entering console mode...\n\n");
		rv = new ConsoleViewer(fileTemplate);
		rv.displayViewer();

	}


}
