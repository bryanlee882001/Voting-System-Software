import static org.junit.Assert.*;
import org.junit.Test;
import java.io.*;
import java.util.*;

/**
 * The fileSystemTest program contains the test cases with 
 * different conditions to check whether the voting system software 
 * meets all its acceptance criteria by performing file handling in 
 * a correct manner.
 *
 * @author Bryan Yen Sheng Lee
 * @author Cedric Tan Yee Shuen
 * @author Sherryl Ooi Shi Tyng
 * @version 2.0
 * @ since 2023-03-19
 */
public class fileSystemTest {
    

    @Test
    // This test checks that getFileExtension() returns the correct file extension
    public void test1_getFileExtension(){        
        File testFile1 = new File("testfile.csv");
        // Expects "csv" as the outcome
        assertEquals("csv", fileSystem.getFileExtension(testFile1));
    }


    @Test
    // This test checks that getFileExtension() returns the correct file extension
    public void test2_getFileExtension(){        
        File testFile2 = new File("testfile.pdf");
        // Expects "pdf" as the outcome
        assertEquals("pdf", fileSystem.getFileExtension(testFile2));
    }

    
    @Test
    // This test checks that getFileExtension() returns the correct file extension
    public void test3_getFileExtension(){        
        File testFile3 = new File("testfiledocs");
        // Expects "" as the outcome
        assertEquals("", fileSystem.getFileExtension(testFile3));
    }


    @Test
    // This test checks that getFileExtension() returns the correct file extension
    public void test4_getFileExtension(){        
        File testFile4 = new File("");
        // Expects "" as the outcome
        assertEquals("", fileSystem.getFileExtension(testFile4));
    }


    @Test
    // This test checks that getFileExtension() returns the correct file extension
    public void test5_getFileExtension(){        
        File testFile5 = new File("testfile.csv.csv");
        // Expects "csv.csv" as the outcome
        assertEquals("csv", fileSystem.getFileExtension(testFile5));
    }


    @Test
    // This test checks that getFileExtension() returns the correct file extension
    public void test6_getFileExtension(){        
        File testFile6 = new File("testfile..");
        // Expects "" as the outcome
        assertEquals("", fileSystem.getFileExtension(testFile6));
    }


    @Test
    // This test checks that checkFileFormat() returns boolean indicating whether file format is correct
    public void test7_checkFileFormat(){
        File testFile7 = new File("testfile.csv");
        // Expects True as the outcome
        assertEquals(true, fileSystem.checkFileFormat(testFile7));
    }


    @Test
    // This test checks that checkFileFormat() returns boolean indicating whether file format is correct
    public void test8_checkFileFormat(){
        File testFile8 = new File("testfile.pdf");
        // Expects False as the outcome
        assertEquals(false, fileSystem.checkFileFormat(testFile8));
    }


    @Test
    // This test checks that checkFileFormat() returns boolean indicating whether file format is correct
    public void test9_checkFileFormat(){
        File testFile9 = new File("testfile..");
        // Expects False as the outcome
        assertEquals(false, fileSystem.checkFileFormat(testFile9));
    }


    @Test
    // This test checks that checkFileFormat() returns boolean indicating whether file format is correct
    public void test10_checkFileFormat(){
        File testFile10 = new File("testfile.csv.csv");
        // Expects True as the outcome
        assertEquals(true, fileSystem.checkFileFormat(testFile10));
    }


    @Test
    // This test checks that readFile() reads and returns correct information based on election file
    public void test11_readFile() throws IOException{

        // Create temporary csv fie containing election information 
        File testFile11 = File.createTempFile("testFile11", ".csv");
        FileWriter writer = new FileWriter(testFile11);
        writer.write("CPL\n3\nDemocratic, Republican, New Wave\nFoster, Volz, Pike\nGreen, Xu, Wang\nJacks, Rosen\n3\n8");
        writer.close();
        
        // Call the method being tested
        fileSystem.readFile(testFile11);

        // Stores candidates from all parties
        List<List<String>> expectedCandidatesList = Arrays.asList(
            // List of candidates from each party
            Arrays.asList("Foster, Volz, Pike"),
            Arrays.asList("Green, Xu, Wang"),
            Arrays.asList("Jacks, Rosen")
        );

        // Test that election information were read correctly from testFile12        
        assertEquals("CPL", fileSystem.electionType);
        assertEquals(3, fileSystem.numOfCandidates);
        assertEquals(Arrays.asList("Democratic", "Republican", "New Wave"), fileSystem.candidates);
        assertEquals(expectedCandidatesList, fileSystem.candidatesList);
        assertEquals(3, fileSystem.numOfSeats);
        assertEquals(8, fileSystem.numOfVotes);
    }


    @Test
    // This test checks that readFile() reads and returns correct information based on election file
    public void test12_readFile() throws IOException{

        // Create temporary csv fie containing election information 
        File testFile12 = File.createTempFile("testFile12", ".csv");
        FileWriter writer = new FileWriter(testFile12);
        writer.write("IR\n4\nRosen (D), Kleinberg (R), Chou (I), Royce (L)\n8");
        writer.close();
        
        // Call the method being tested
        fileSystem.readFile(testFile12);
        
        // Test that election information were read correctly from testFile12        
        assertEquals("IR", fileSystem.electionType);
        assertEquals(4, fileSystem.numOfCandidates);
        assertEquals(Arrays.asList("Rosen (D)", "Kleinberg (R)", "Chou (I)", "Royce (L)"), fileSystem.candidates);
        assertEquals(8, fileSystem.numOfVotes);
    }
    

    @Test 
    // This test checks that openFile() checks the file format and then reads file
    public void test13_openFile(){
        File testFile13 = new File("Project2/testing/CPL_18-3-2023.csv");
        
        // Check if file format is True
        fileSystem.openFile(testFile13);
        assertTrue(fileSystem.checkFileFormat(testFile13));

        // Initialize boolean
        boolean functionWasRun = true;
        // Check if readFile() is called using try and catch 
        try { fileSystem.readFile(testFile13); } catch (Exception e) { functionWasRun = true; }
        assertTrue(functionWasRun);

    }


    @Test 
    // This test checks that openFile() checks the file format and then reads file
    public void test14_openFile(){
        File testFile14 = new File("Project1/testing/CPL_18-3-2023.pdf");

        fileSystem.openFile(testFile14);
        assertFalse(fileSystem.checkFileFormat(testFile14));

        // Check if ReadFile() function was run 
        boolean functionWasRun = false;
        try { fileSystem.readFile(testFile14); } catch (Exception e) { functionWasRun = false; }
        assertFalse(functionWasRun);
    }

}




