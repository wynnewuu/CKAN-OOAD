import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class FileTemplateTest {
    FileTemplate ft;
    @BeforeAll
    void initAll(){ //initializae FileTemplate
        ft = new FileTemplate(new ArrayList<String>(Arrays.asList("a","b", "c")), "filename", 5);
    }
    /* A few tests to make sure the gets work properly */
    @Test
    void getFieldNumber() { assertEquals(5, ft.getFieldNumber());}

    @Test
    void getFieldLabels() { assertEquals(true, ft.getFieldLabels().equals(new ArrayList<String>(Arrays.asList("a", "b", "c"))));}

    @Test
    void getDelimiter() { assertEquals(",", ft.getDelimiter());}

    @Test
    void getFilename() {  assertEquals("filename", ft.getFilename());}

    @Test
    void getPrimary_field() { assertEquals(0, ft.getPrimary_field());}

    @Test
    void getFieldTypes() { assertEquals(true, ft.getFieldTypes().equals(new ArrayList<String>(
            Arrays.asList("String","String","String","String","String"))));}
}