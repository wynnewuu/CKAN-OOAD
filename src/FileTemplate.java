/**
 * Gives the basic structure of a Record
 * This is the super class of any class that needs to access these fields
 */

import java.util.ArrayList;

public class FileTemplate {

        int fieldNumber;
        ArrayList<String> fieldLabels;
        ArrayList<String> fieldTypes;
        String filename;
        String delimiter ;
        int primary_field;

        public FileTemplate(ArrayList<String> fieldLabels,  String filename, int fieldNumber){ //invoked when making a template
            this.fieldNumber = fieldNumber;
            this.fieldLabels = fieldLabels;
            this.filename = filename;
            this.delimiter = ","; //we are assuming that we are only dealing with CSV files as of this version
            this.primary_field = 0;
            this.fieldTypes = new ArrayList<String>();
            for (int i = 0; i < this.fieldNumber; i++) { //all types will be of type String when read from files
                this.fieldTypes.add("String");
            }
        }
        public FileTemplate(FileTemplate ft){ //invoked when creating the manager system when template used
            this.fieldNumber = ft.fieldNumber;
            this.fieldLabels = ft.fieldLabels;
            this.filename = ft.filename;
            this.delimiter = ft.delimiter; //we are assuming that we are only dealing with CSV files as of this version
            this.primary_field = ft.primary_field;
            this.fieldTypes = ft.fieldTypes;
        }

        /**
         * Some useful gets
         */
        public int getFieldNumber() { return fieldNumber; }
        public ArrayList<String> getFieldLabels() { return fieldLabels; }
        public String getDelimiter() { return delimiter; }
        public String getFilename() { return filename; }
        public int getPrimary_field() { return primary_field; }
        public ArrayList<String> getFieldTypes() { return fieldTypes; }


}
