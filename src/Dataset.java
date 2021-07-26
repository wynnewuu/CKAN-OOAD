/** Dataset is a class that abstracts a collection of files, known as dataset.
 A Dataset is a has a names for its files, formats, urls, and a name itself
 Each one of these files needs a template if it wants to be managed
 @author Jose Guillen Santos

 */
import java.util.ArrayList;
import java.net.*;
import java.io.*;
import java.util.StringTokenizer;

public class Dataset implements DatasetTemplate {

    public String datasetName;
    public ArrayList<String> formats;
    public ArrayList<String> urls;
    public ArrayList<String> fileNames;
    public int fileCount;

    Dataset(String name, ArrayList<String> formats, ArrayList<String> urls, ArrayList<String> fileNames, int fileCount){
        this.datasetName = name;
        this.formats = formats;
        this.urls = urls;
        this.fileNames = fileNames;
        this.fileCount = fileCount;
    }

    /** useful couple of gets.... */
    public String getFormat(int key) {
        return formats.get(key);
    }
    public String getUrl(int key) {
        return urls.get(key);
    }

    /**
     * Helpful to create template for each file of a dataset, in order to manage it
     * Assuming CSV file and that first line has label titles
     * @param key
     * @return FileTemplate
     * @throws IOException
     */


    public FileTemplate getTemplate(int key) throws IOException {
        int fieldNumber=0;
        ArrayList<String> fieldLabels = new ArrayList<>();
        String filename = fileNames.get(key).replace(" ","_")+".txt"; // filename to write to is record name with txt concat

        URL url = new URL(getUrl(key));
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename)); //writes dataset file to a local file with the name of filename
        BufferedReader read = new BufferedReader(new InputStreamReader(url.openStream())); //reads from url
        String line;

        int lineNumber = 0;
        while ((line = read.readLine()) != null) {
            if (lineNumber==0){
                StringTokenizer st = new StringTokenizer(line, ";"); //CSV comma delimited assumed
                fieldNumber = st.countTokens();
                for (int i = 0; i < fieldNumber ; i++) {
                    fieldLabels.add(st.nextToken());
                }
            }
            writer.write(line.replace(";",",")+"\n");
            lineNumber++;
        }
        read.close();
        writer.close();
        return new FileTemplate(fieldLabels, filename, fieldNumber);
    }

    /**
     * Helpful toString in order to display dataset and its resources
     * @return String
     */
    @Override
    public String toString() {
        String dataset ="";
        dataset += String.format("\n");
        dataset += String.format("DATASET: %s\n", this.datasetName);
        dataset+= String.format("  RESOURCES:\n");
        for (int i = 0; i < fileCount; i++) {
            dataset += String.format("    %s\n", this.fileNames.get(i));
            dataset += String.format("    FORMAT: %s\n", this.formats.get(i));
            dataset+=String.format("       URL: %s\n", this.urls.get(i));
        }
        return dataset;
    }


}
