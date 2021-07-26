import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DatasetTest {
    ArrayList<String> formats = new ArrayList<String>();
    ArrayList<String> urls = new ArrayList<String>();
    ArrayList<String> fileNames = new ArrayList<String>();
    FileTemplate ft;
    Dataset test;

    @BeforeAll
    void initAll(){
        formats.add("CSV");
        formats.add("CSV");
        urls.add("http://www.statweb.provincia.tn.it/indicatoristrutturalisubpro/exp.aspx?idind=430&info=d&fmt=csv");
        urls.add("http://www.statweb.provincia.tn.it/indicatoristrutturalisubpro/exp.aspx?ntab=Sub_RAI_Abbonati&info=d&fmt=csv");
        fileNames.add("Abbonamenti alla RAI");
        fileNames.add("Numero di abbonati alla RAI");
        test = new Dataset("abbonamenti-alla-rai", formats, urls, fileNames, 2);
        ft = new FileTemplate(new ArrayList<String>(Arrays.asList("anno", "codEnte","valore")), "Abbonamenti_alla_RAI.txt", 3);
    }
    @Test

    void getFormat() { //returns correct formats
        assertEquals(formats.get(0), test.getFormat(0));
        assertEquals(formats.get(1), test.getFormat(1));
    }

    @Test
    void getUrl() { //returns correct urls
        assertEquals(urls.get(0), test.getUrl(0));
        assertEquals(urls.get(1), test.getUrl(1));
    }

    @Test
    void getTemplate() { //if all the attributes of the expected template are equal to getTemplate(), then method returns expected template
        try {
            assertEquals(true, ft.fieldLabels.equals(test.getTemplate(0).fieldLabels));
            assertEquals(ft.fieldNumber,  (test.getTemplate(0).fieldNumber));
            assertEquals(ft.filename, test.getTemplate(0).filename);
            assertEquals(true, ft.fieldTypes.equals(test.getTemplate(0).fieldTypes));
            assertEquals(ft.primary_field, test.getTemplate(0).primary_field);
            assertEquals(ft.delimiter, test.getTemplate(0).delimiter);
        }catch (IOException e){
            System.out.println(e);
        }

    }

    @Test
    void testToString() { //returns correct toString
        String toString = "\n";
        try
        {
            String line = null;
            BufferedReader br = new BufferedReader(new FileReader("src/test/resources/dataset.txt"));
            while ((line = br.readLine()) != null)
                toString+=line+"\n";
            br.close();
        }
        catch(IOException ioe) { System.err.println(ioe); }

        assertEquals(toString, test.toString());
    }
}