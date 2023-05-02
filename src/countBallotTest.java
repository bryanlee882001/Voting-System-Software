import static org.junit.Assert.*;
import org.junit.Test;
import java.util.*;

/**
 * The countBallotTest program contains the test cases with 
 * different conditions to check whether the voting system 
 * software meets all its acceptance criteria by counting 
 * the ballots based on election type using the information 
 * given into the voting system software through a .csv file. 
 *
 * @author Bryan Yen Sheng Lee
 * @author Cedric Tan Yee Shuen
 * @author Sherryl Ooi Shi Tyng
 * @version 2.0
 * @ since 2023-03-19
 */
public class countBallotTest {

    @Test
    // This test checks that countBallot() returns the correct TotalBallots list and ballotWithName map for CPL
    public void test1_countBallot(){        
        
        fileSystem.electionType = "CPL";                                                                // set election type to IR
        fileSystem.numOfCandidates = 4;                                                                 // set number of parties to 4
        fileSystem.numOfVotes = 7;                                                                      // set number of votes to 4
        fileSystem.candidates.addAll(Arrays.asList("Democratic","Republican","Reform","Green"));   // add parties
        fileSystem.ballot.add(Arrays.asList(0,1,0,0));                                             // add 7 arbitrary ballots
        fileSystem.ballot.add(Arrays.asList(1,0,0,0));
        fileSystem.ballot.add(Arrays.asList(0,0,1,0));
        fileSystem.ballot.add(Arrays.asList(0,0,0,1));
        fileSystem.ballot.add(Arrays.asList(0,1,0,0));
        fileSystem.ballot.add(Arrays.asList(1,0,0,0));
        fileSystem.ballot.add(Arrays.asList(0,1,0,0));

        // Create an object of the countBallot class to count totalBallots and ballotsWithName
        countBallot ballotCount = new countBallot();

        // expectedTotalBallots is created and used to compare results with ballotCount.totalBallots 
        List<List<Integer>> expectedTotalBallots = Arrays.asList(
            // (index 0: number of zeros in all ballots, index 1: number of ones in all ballots)
            Arrays.asList(5,2),
            Arrays.asList(4,3),
            Arrays.asList(6,1),
            Arrays.asList(6,1)
        );
        // Test that the totalBallots list has been calculated correctly using assertEquals
        assertEquals(expectedTotalBallots, ballotCount.totalBallots);

        // expectedBallotWithName is created and used to compare results with ballotCount.ballotWithName
        Map<String, List<Integer>> expectedBallotWithName = new HashMap<>();
        expectedBallotWithName.put("Democratic", Arrays.asList(5,2));
        expectedBallotWithName.put("Republican", Arrays.asList(4,3));
        expectedBallotWithName.put("Reform", Arrays.asList(6,1));
        expectedBallotWithName.put("Green", Arrays.asList(6,1));
        // Test that the ballotWithName list has been calculated correctly using assertEquals
        assertEquals(expectedBallotWithName, ballotCount.ballotWithName);
    }


    @Test
    // The second test checks that countBallot() returns the correct TotalBallots list and ballotWithName map for IR
    public void test2_countBallot(){        
        
        fileSystem.electionType = "IR";                                                  // set election type to IR
        fileSystem.numOfCandidates = 3;                                                  // set number of candidates to 3
        fileSystem.numOfVotes = 4;                                                       // set number of votes to 4
        fileSystem.candidates.add("Sherryl Ooi");                                      // add first candidate 
        fileSystem.candidates.add("Bryan Lee");                                        // add second candidate 
        fileSystem.candidates.add("Cedric Tan");                                       // add third candidate 
        fileSystem.ballot.add(Arrays.asList(1, 2, 3));                              // add 4 arbitrary ballots with rankings
        fileSystem.ballot.add(Arrays.asList(1, 3, 2));
        fileSystem.ballot.add(Arrays.asList(1, 2, 3));
        fileSystem.ballot.add(Arrays.asList(2, 3, 1));

        // Create an object of the countBallot class to count totalBallots and ballotsWithName
        countBallot ballotCount = new countBallot();

        // expectedTotalBallots is created and used to compare results with ballotCount.totalBallots 
        List<List<Integer>> expectedTotalBallots = Arrays.asList(
            // (index 0: number of zeros in all ballots, index 1: number of ones in all ballots)
            Arrays.asList(0, 3, 1, 0),
            Arrays.asList(0, 0, 2, 2),
            Arrays.asList(0, 1, 1, 2)
        );
        // Test that the totalBallots list has been calculated correctly using assertEquals
        assertEquals(expectedTotalBallots, ballotCount.totalBallots);

        // expectedBallotWithName is created and used to compare results with ballotCount.ballotWithName
        Map<String, List<Integer>> expectedBallotWithName = new HashMap<>();
        expectedBallotWithName.put("Sherryl Ooi", Arrays.asList(0, 3, 1, 0));
        expectedBallotWithName.put("Bryan Lee", Arrays.asList(0, 0, 2, 2));
        expectedBallotWithName.put("Cedric Tan", Arrays.asList(0, 1, 1, 2));
        // Test that the ballotWithName list has been calculated correctly using assertEquals
        assertEquals(expectedBallotWithName, ballotCount.ballotWithName);
    }


    @Test
    // This test checks that countBallot() returns an empty TotalBallots list and ballotWithName map when election type is neither CPL or IR
    public void test3_countBallot(){        
        
        fileSystem.electionType = "OPL";            // set election type to Open Party List 
        
        // expectedTotalBallots is created and used to compare results with ballotCount.totalBallots 
        List<List<Integer>> expectedTotalBallots = Arrays.asList();
        countBallot ballotCount = new countBallot();
        // Invalid election type means that ballots will not be counted therefore the array list is empty
        assertEquals(expectedTotalBallots,ballotCount.totalBallots); 

        // expectedBallotWithName is created and used to compare results with ballotCount.ballotWithName
        Map<String, List<Integer>> expectedBallotWithName = new HashMap<>();
        // Invalid election type means that ballots with name will not be counted therefore the map is empty 
        assertEquals(expectedBallotWithName, ballotCount.ballotWithName);
    }

}


