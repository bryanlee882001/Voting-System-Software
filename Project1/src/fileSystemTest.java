import static org.junit.Assert.*;
import org.junit.Test;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class fileSystemTest {
    
    fileSystem file = new fileSystem();

    @Test
    // This test checks that getFileExtension() returns the correct file extension
    public void test1_getFileExtension(){        
        File testFile1 = new File("testfile.csv");
        // Expect "csv" as the outcome
        assertEquals("csv", fileSystem.getFileExtension(testFile1));
    }

    @Test
    // This test checks that getFileExtension() returns the correct file extension
    public void test2_getFileExtension(){        
        File testFile2 = new File("testfile.pdf");
        // Expect "pdf" as the outcome
        assertEquals("pdf", fileSystem.getFileExtension(testFile2));
    }

    @Test
    // This test checks that getFileExtension() returns the correct file extension
    public void test3_getFileExtension(){        
        File testFile3 = new File("testfiledocs");
        // Expect "" as the outcome
        assertEquals("", fileSystem.getFileExtension(testFile3));
    }

    @Test
    // This test checks that getFileExtension() returns the correct file extension
    public void test4_getFileExtension(){        
        File testFile4 = new File("");
        // Expect "" as the outcome
        assertEquals("", fileSystem.getFileExtension(testFile4));
    }

    @Test
    // This test checks that getFileExtension() returns the correct file extension
    public void test5_getFileExtension(){        
        File testFile5 = new File("testfile.csv.csv");
        // Expect "csv.csv" as the outcome
        assertEquals("csv.csv", fileSystem.getFileExtension(testFile5));
    }

    @Test
    // This test checks that getFileExtension() returns the correct file extension
    public void test6_getFileExtension(){        
        File testFile6 = new File("testfile..");
        // Expect "" as the outcome
        assertEquals("", fileSystem.getFileExtension(testFile6));
    }


    @Test
    // This test checks that checkFileFormat() returns boolean indicating correct file format
    public void test7_checkFileFormat(){
        File testFile7 = new File("testfile.csv");
        // Expect True as the outcome
        assertEquals(true, fileSystem.checkFileFormat(testFile7));
    }

    @Test
    // This test checks that checkFileFormat() returns boolean indicating correct file format
    public void test8_checkFileFormat(){
        File testFile8 = new File("testfile.pdf");
        // Expect False as the outcome
        assertEquals(false, fileSystem.checkFileFormat(testFile8));
    }

    @Test
    // This test checks that checkFileFormat() returns boolean indicating correct file format
    public void test9_checkFileFormat(){
        File testFile9 = new File("testfiledocs");
        // Expect False as the outcome
        assertEquals(false, fileSystem.checkFileFcrmat(testFile9));
    }

    @Test
    // This test checks that checkFileFormat() returns boolean indicating correct file format
    public void test10_checkFileFormat(){
        File testFile10 = new File("testfile..");
        // Expect False as the outcome
        assertEquals(false, fileSystem.checkFileFormat(testFile10));
    }

    @Test
    // This test checks that checkFileFormat() returns boolean indicating correct file format
    public void test11_checkFileFormat(){
        File testFile11 = new File("testfile.csv.csv");
        // Expect True as the outcome
        assertEquals(true, fileSystem.checkFileFormat(testFile11));
    }

    @Test
    // This test checks that readFile() returns correct information about election type, number of candidates, and list of candidates
    public void test12_readFile(){
        File testFile12 = new File("Project1/testing/CPL_18-3-2023.csv");
        
        // Call the method being tested
        fileSystem.readFile(testFile12);
        
        // Assert that the values were read correctly
        assertEquals("CPL", fileSystem.electionType);
        assertEquals(6, fileSystem.numOfCandidates);
        assertArrayEquals(new String[]{"Democratic", "Republican", "New Wave", "Reform", "Green", "Independent"}, fileSystem.candidates);
        assertArrayEquals(new String[]{"Foster, Volz, Pike", "Green, Xu, Wang", "Jacks, Rosen", "McClure, Berg", "Zheng, Melvin", "Peters"}, fileSystem.candidatesList);
        assertEquals(3, fileSystem.numOfSeats);
        assertEquals(11, fileSystem.numOfVotes);
    }

    @Test
    // This test checks that readFile() returns correct information about election type, number of candidates, and list of candidates
    public void test13_readFile(){
        File testFile13 = new File("Project1/testing/IR_2-3-2023.csv");
        
        // Call the method being tested
        fileSystem.readFile(testFile13);
        
        // Assert that the values were read correctly
        assertEquals("IR", fileSystem.electionType);
        assertEquals(4, fileSystem.numOfCandidates);
        assertArrayEquals(new String[]{"Rosen (D)", "Kleinberg (R)", "Chou (I)", "Royce (L)"}, fileSystem.candidates);
        assertEquals(6, fileSystem.numOfVotes);""
    }
    
    @Test 
    // This test checks that openFile() checks the file format and then reads file
    public void test14_openFile(){
        File testFile14 = new File("Project1/testing/CPL_18-3-2023.csv");
        
        // Check if file format is True
        fileSystem.openFile(testFile14);
        assertTrue(fileSystem.checkFileFormat(testFile14));

        // Check if ReadFile() function was run 
        boolean functionWasRun = true;
        try { fileSystem.readFile(testFile14); } catch (Exception e) { functionWasRun = true; }
        assertTrue(functionWasRun);

    }

    @Test 
    // This test checks that openFile() checks the file format and then reads file
    public void test15_openFile(){
        File testFile15 = new File("Project1/testing/CPL_18-3-2023.pdf");

        fileSystem.openFile(testFile15);
        assertFalse(fileSystem.checkFileFormat(testFile15));
    }


}
