import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

/**
 * The displayResultsTest program contains the test cases with 
 * different conditions to check whether the voting system 
 * software meets all its acceptance criteria by displaying 
 * the final results of the election based on the election 
 * type as well as generate an audit file for a completed 
 * election. 
 *
 * @author Bryan Yen Sheng Lee
 * @author Cedric Tan Yee Shuen
 * @author Sherryl Ooi Shi Tyng
 * @version 2.0
 * @ since 2023-03-19
 */
public class displayResultsTest {
    
    @Test
    // This test case checks if generateAuditFile() is called to export an audit file when the election type is CPL
    public void test1_generateAuditFile(){

        fileSystem.electionType = "CPL";                                                                // set election type to IR
        fileSystem.numOfCandidates = 4;                                                                 // set number of parties to 4
        fileSystem.numOfSeats = 5;                                                                      // set number of seats to 5
        fileSystem.numOfVotes = 5;                                                                      // set number of votes to 5
        fileSystem.candidates.addAll(Arrays.asList("Democratic","Republican","Reform","Green"));   // add parties
        fileSystem.ballot.add(Arrays.asList(0,1,0,0));                                             // add 5 arbitrary ballots
        fileSystem.ballot.add(Arrays.asList(1,0,0,0));
        fileSystem.ballot.add(Arrays.asList(1,0,0,0));
        fileSystem.ballot.add(Arrays.asList(0,1,0,0));
        fileSystem.ballot.add(Arrays.asList(0,1,0,0));
        
        // Creates a new object of the displayResults class 
        displayResults dR = new displayResults();

            // +--------------------+
            // | Results:           |
            // +--------------------+
            // | "Democratic",(3,2) |
            // | "Republican",(2,3) |
            // | "Reform",(5,0)     |
            // | "Green", (5,0)     |
            // +--------------------+

        // Initialize boolean
        boolean CheckIfAuditFileIsGenerated = true;
        // Checks if the generateAuditFile() method is called using try and catch 
        try {  
            dR.generateAuditFile();
            dR.showResults();
        } 
        catch (Exception e) { CheckIfAuditFileIsGenerated  = false; }
        assertFalse(CheckIfAuditFileIsGenerated);
    }


    @Test
    // This test case checks if generateAuditFile() is called to export an audit file when the election type is IR
    public void test2_generateAuditFile(){

        fileSystem.electionType = "IR";                                                  // set election type to IR
        fileSystem.numOfCandidates = 3;                                                  // set number of candidates to 3
        fileSystem.numOfVotes = 5;                                                       // set number of votes to 5
        fileSystem.candidates.add("Cedric Tan");                                       // add first candidate 
        fileSystem.candidates.add("Bryan Lee");                                        // add second candidate 
        fileSystem.candidates.add("Sherryl Ooi");                                      // add third candidate 
        fileSystem.ballot.add(Arrays.asList(2, 1, 3));                              // add 5 arbitrary ballots with rankings
        fileSystem.ballot.add(Arrays.asList(3, 2, 1));
        fileSystem.ballot.add(Arrays.asList(3, 2, 1));                              
        fileSystem.ballot.add(Arrays.asList(3, 2, 1));
        fileSystem.ballot.add(Arrays.asList(2, 3, 1));

        // Creates a new object of the displayResults class 
        displayResults dR = new displayResults();

            // +------------------------------+
            // | Results:                     |
            // +------------------------------+
            // | "Cedric",(0,0,2,3)           |
            // | "Bryan",(0,1,3,1)            | 
            // | "Sherryl",(0,4,0,1)          |
            // +------------------------------+

        // Initialize boolean
        boolean CheckIfAuditFileIsGenerated = true;
        // Checks if the generateAuditFile() method is called using try and catch 
        try {  
            dR.generateAuditFile(); 
            dR.showResults();
        } 
        catch (Exception e) { CheckIfAuditFileIsGenerated  = false; }
        assertTrue(CheckIfAuditFileIsGenerated);
    }


    @Test
    // This test case checks if showResults() is called to display the election results when the election type is IR
    public void test3_showResults(){
        
        fileSystem.electionType = "CPL";                                                                // set election type to IR
        fileSystem.numOfCandidates = 4;                                                                 // set number of parties to 4
        fileSystem.numOfSeats = 6;                                                                      // set number of seats to 4
        fileSystem.numOfVotes = 5;                                                                      // set number of votes to 5
        fileSystem.candidates.addAll(Arrays.asList("Democratic","Republican","Reform","Green"));   // add parties
        fileSystem.ballot.add(Arrays.asList(0,1,0,0));                                             // add 5 arbitrary ballots
        fileSystem.ballot.add(Arrays.asList(1,0,0,0));
        fileSystem.ballot.add(Arrays.asList(1,0,0,0));
        fileSystem.ballot.add(Arrays.asList(0,1,0,0));
        fileSystem.ballot.add(Arrays.asList(0,1,0,0));

        // Creates a new object of the displayResults class 
        displayResults dR = new displayResults();

            // +--------------------+
            // | Results:           |
            // +--------------------+
            // | "Democratic",(3,2) |
            // | "Republican",(2,3) |
            // | "Reform",(5,0)     |
            // | "Green", (5,0)     |
            // +--------------------+

        // Initialize boolean
        boolean CheckIfResultsAreDisplayed = true;
        // Checks if the showResults() method is called using try and catch 
        try {  dR.showResults(); 
               dR.generateAuditFile();} catch (Exception e) { CheckIfResultsAreDisplayed  = false; }
        assertFalse(CheckIfResultsAreDisplayed);
    }


    @Test
    // This test case checks if showResults() is called to display the election results when the election type is IR
    public void test4_showResults(){
        
        fileSystem.electionType = "IR";                                                  // set election type to IR
        fileSystem.numOfCandidates = 3;                                                  // set number of candidates to 3
        fileSystem.numOfVotes = 5;                                                       // set number of votes to 5
        fileSystem.candidates.add("Cedric Tan");                                       // add first candidate 
        fileSystem.candidates.add("Bryan Lee");                                        // add second candidate 
        fileSystem.candidates.add("Sherryl Ooi");                                      // add third candidate 
        fileSystem.ballot.add(Arrays.asList(2, 1, 3));                              // add 5 arbitrary ballots with rankings
        fileSystem.ballot.add(Arrays.asList(3, 2, 1));
        fileSystem.ballot.add(Arrays.asList(3, 2, 1));                              
        fileSystem.ballot.add(Arrays.asList(3, 2, 1));
        fileSystem.ballot.add(Arrays.asList(2, 3, 1));

        // Creates a new object of the displayResults class 
        displayResults dR = new displayResults();

            // +------------------------------+
            // | Results:                     |
            // +------------------------------+
            // | "Cedric",(0,0,2,3)           |
            // | "Bryan",(0,1,3,1)            | 
            // | "Sherryl",(0,4,0,1)          |
            // +------------------------------+

        // Initialize boolean
        boolean CheckIfResultsAreDisplayed= true;
        // Checks if the showResults() method is called using try and catch 
        try {  dR.showResults(); } catch (Exception e) { CheckIfResultsAreDisplayed  = false; }
        assertTrue(CheckIfResultsAreDisplayed);
    }

}

