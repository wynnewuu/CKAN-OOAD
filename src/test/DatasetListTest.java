import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DatasetListTest {

    DatasetList tester = new DatasetList();
    @BeforeAll
    void initAll(){
        tester.loadDatasets(); //if all the test cases pass then the loadDataset function works
    }


    @Test
    void get() {
        ArrayList<String> formats = new ArrayList<String>();
        ArrayList<String> urls = new ArrayList<String>();
        ArrayList<String> fileNames = new ArrayList<String>();
        formats.add("CSV");
        formats.add("CSV");
        urls.add("http://www.statweb.provincia.tn.it/indicatoristrutturalisubpro/exp.aspx?idind=430&info=d&fmt=csv");
        urls.add("http://www.statweb.provincia.tn.it/indicatoristrutturalisubpro/exp.aspx?ntab=Sub_RAI_Abbonati&info=d&fmt=csv");
        fileNames.add("Abbonamenti alla RAI");
        fileNames.add("Numero di abbonati alla RAI");

        Dataset temp = new Dataset("abbonamenti-alla-rai", formats, urls, fileNames, 2);
        //if all the fields are the same
        //the objects are the same
        //therefore the get function works
        assertEquals(temp.fileCount, tester.get(0).fileCount);
        assertEquals(temp.fileNames, tester.get(0).fileNames);
        assertEquals(temp.formats, tester.get(0).formats);
        assertEquals(temp.urls, tester.get(0).urls);
        assertEquals(temp.datasetName, tester.get(0).datasetName);
    }

    @Test
    void size() {
        assertEquals(10, tester.size());
    }

    @Test
    void testToString() { //if passes toString test, means the datasetlist was filled correctly
        String toString = "\n";
        try
        {
            String line = null;
            BufferedReader br = new BufferedReader(new FileReader("src/test/resources/datasetlist.txt"));
            while ((line = br.readLine()) != null)
                toString+=line+"\n";
            br.close();
        }
        catch(IOException ioe) { System.err.println(ioe); }

        assertEquals(toString, tester.toString());
    }


}