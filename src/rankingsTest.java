import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

/**
 * The rankingsTest program contains the test cases with 
 * different conditions to check whether the voting 
 * system software meets all its acceptance criteria 
 * by determining the ranking of the candidates/parties 
 * of the election as well as check whether there is a 
 * majority to determine the winner of the election. 
 *
 * @author Bryan Yen Sheng Lee
 * @author Cedric Tan Yee Shuen
 * @author Sherryl Ooi Shi Tyng
 * @version 2.0
 * @ since 2023-03-19
 */
public class rankingsTest {


    @Test 
    // This test case checks if checkRanking() sorts each candidate based on votes for CPL election 
    public void test1_checkRankingsTest(){

        fileSystem.electionType = "CPL";                                                                // set election type to IR
        fileSystem.numOfCandidates = 4;                                                                 // set number of parties to 4
        fileSystem.numOfVotes = 7;                                                                      // set number of votes to 4
        fileSystem.candidates.addAll(Arrays.asList("Democratic","Republican","Reform","Green"));   // add parties
        fileSystem.ballot.add(Arrays.asList(0,1,0,0));                                             // add 7 arbitrary ballots
        fileSystem.ballot.add(Arrays.asList(1,0,0,0));
        fileSystem.ballot.add(Arrays.asList(0,0,1,0));
        fileSystem.ballot.add(Arrays.asList(0,1,0,0));
        fileSystem.ballot.add(Arrays.asList(0,1,0,0));
        fileSystem.ballot.add(Arrays.asList(1,0,0,0));
        fileSystem.ballot.add(Arrays.asList(0,1,0,0));
        
        // expectedRanking is created and used to compare results with actualRanking to determine if ranking is correct
        Map<String, List<Integer>> expectedRanking = new LinkedHashMap<>();
        expectedRanking.put("Republican", Arrays.asList(3,4));
        expectedRanking.put("Democratic", Arrays.asList(5,2));
        expectedRanking.put("Reform", Arrays.asList(6,1));
        expectedRanking.put("Green", Arrays.asList(7,0));

        // Create an object of rankings class and check ranking for all candidates
        rankings rank = new rankings();
        Map<String, List<Integer>> actualRanking = rank.checkRanking(countBallot.ballotWithName); 

        // Test that the ranking for each candidate has been determined correctly
        assertEquals(expectedRanking, actualRanking);
    }


    @Test
    // This test case checks if checkRanking() sorts each candidate based on votes for IR election 
    public void test2_checkRankingsTest(){

        fileSystem.electionType = "IR";                                                  // set election type to IR
        fileSystem.numOfCandidates = 3;                                                  // set number of candidates to 3
        fileSystem.numOfVotes = 4;                                                       // set number of votes to 4
        fileSystem.candidates.add("Cedric Tan");                                       // add first candidate 
        fileSystem.candidates.add("Bryan Lee");                                        // add second candidate 
        fileSystem.candidates.add("Sherryl Ooi");                                      // add third candidate 
        fileSystem.ballot.add(Arrays.asList(3, 2, 1));                              // add 4 arbitrary ballots with rankings
        fileSystem.ballot.add(Arrays.asList(2, 3, 1));
        fileSystem.ballot.add(Arrays.asList(3, 2, 1));
        fileSystem.ballot.add(Arrays.asList(1, 3, 2));
        
        // expectedRanking is created and used to compare results with actualRanking to determine if ranking is correct
        Map<String, List<Integer>> expectedRanking = new LinkedHashMap<>();
        expectedRanking.put("Sherryl Ooi", Arrays.asList(0, 3, 1, 0));
        expectedRanking.put("Bryan Lee", Arrays.asList(0, 0, 2, 2));
        expectedRanking.put("Cedric Tan", Arrays.asList(0, 1, 1, 2));
        
        // Create an object of rankings class and check ranking for all candidates
        rankings rank = new rankings();
        Map<String, List<Integer>> actualRanking = rank.checkRanking(countBallot.ballotWithName); 

        // Test that the ranking for each candidate has been determined correctly
        assertEquals(expectedRanking, actualRanking);
    }


    @Test
    // This test case checks if checkRanking() sorts each candidate based on votes for CPL election 
    public void test3_checkRanking(){

        fileSystem.electionType = "CPL";                                                                // set election type to IR
        fileSystem.numOfCandidates = 4;                                                                 // set number of parties to 4
        fileSystem.numOfVotes = 7;                                                                      // set number of votes to 4
        fileSystem.candidates.addAll(Arrays.asList("Democratic","Republican","Reform","Green"));   // add parties
        fileSystem.ballot.add(Arrays.asList(0,1,0,0));                                             // add 7 arbitrary ballots
        fileSystem.ballot.add(Arrays.asList(1,0,0,0));
        fileSystem.ballot.add(Arrays.asList(0,0,1,0));
        fileSystem.ballot.add(Arrays.asList(0,1,0,0));
        fileSystem.ballot.add(Arrays.asList(0,1,0,0));
        fileSystem.ballot.add(Arrays.asList(1,0,0,0));
        fileSystem.ballot.add(Arrays.asList(0,1,0,0));
        
        // expectedResultsAfterCheckingMajority is created and used to compare with actual results after checking for Majority
        Map<String, List<Integer>> expectedRanking = new LinkedHashMap<>();
        expectedRanking.put("Republican", Arrays.asList(3,4));
        expectedRanking.put("Democratic", Arrays.asList(5,2));
        expectedRanking.put("Reform", Arrays.asList(6,1));
        expectedRanking.put("Green", Arrays.asList(7,0));

        // Create an object of rankings class and check ranking for all candidates
        rankings rank = new rankings();
        Map<String, List<Integer>> actualRanking = rank.checkRanking(countBallot.ballotWithName); 

        // Test that the ranking for each candidate has been determined correctly after checking for Majority
        assertEquals(expectedRanking, actualRanking);
    }

    @Test
    // This test case checks if checkMajority() finds a majority among the candidates for IR election
    public void test4_checkMajority(){

        fileSystem.electionType = "IR";                                                  // set election type to IR
        fileSystem.numOfCandidates = 3;                                                  // set number of candidates to 3
        fileSystem.numOfVotes = 9;                                                       // set number of votes to 9
        fileSystem.candidates.add("Cedric Tan");                                       // add first candidate 
        fileSystem.candidates.add("Bryan Lee");                                        // add second candidate 
        fileSystem.candidates.add("Sherryl Ooi");                                      // add third candidate 
        fileSystem.ballot.add(Arrays.asList(3, 2, 1));                              // add 9 arbitrary ballots with rankings
        fileSystem.ballot.add(Arrays.asList(2, 1, 3));
        fileSystem.ballot.add(Arrays.asList(3, 2, 1));
        fileSystem.ballot.add(Arrays.asList(1, 3, 2));
        fileSystem.ballot.add(Arrays.asList(1, 3, 2));                             
        fileSystem.ballot.add(Arrays.asList(3, 2, 1));
        fileSystem.ballot.add(Arrays.asList(2, 1, 3));
        fileSystem.ballot.add(Arrays.asList(2, 1, 3));
        fileSystem.ballot.add(Arrays.asList(1, 3, 2));
        
        // expectedResultsAfterCheckingMajority is created and used to compare with actual results after checking for Majority
        Map<String, List<Integer>> expectedResultsAfterCheckingMajority = new LinkedHashMap<>();
        expectedResultsAfterCheckingMajority.put("Sherryl Ooi", Arrays.asList(0, 0, 3, 3));
        expectedResultsAfterCheckingMajority.put("Bryan Lee", Arrays.asList(0, 6, 3, 3));
        expectedResultsAfterCheckingMajority.put("Cedric Tan", Arrays.asList(0, 0, 3, 3));

        // Create an object of rankings class and check for majority
        rankings rank = new rankings();
        rank.checkMajority(countBallot.ballotWithName);

        // Test that the ranking for each candidate has been determined correctly after checking for Majority
        assertEquals(expectedResultsAfterCheckingMajority, countBallot.ballotWithName);
    }

    @Test
    // This test case checks if checkMajority() finds a majority among the candidates for IR election
    public void test5_checkMajority(){

        fileSystem.electionType = "IR";                                                  // set election type to IR
        fileSystem.numOfCandidates = 3;                                                  // set number of candidates to 3
        fileSystem.numOfVotes = 4;                                                       // set number of votes to 4
        fileSystem.candidates.add("Cedric Tan");                                       // add first candidate 
        fileSystem.candidates.add("Bryan Lee");                                        // add second candidate 
        fileSystem.candidates.add("Sherryl Ooi");                                      // add third candidate 
        fileSystem.ballot.add(Arrays.asList(3, 2, 1));                              // add 4 arbitrary ballots with rankings
        fileSystem.ballot.add(Arrays.asList(2, 3, 1));
        fileSystem.ballot.add(Arrays.asList(3, 2, 1));
        fileSystem.ballot.add(Arrays.asList(1, 3, 2));
        
        // expectedResultsAfterCheckingMajority is created and used to compare with actual results after checking for Majority
        Map<String, List<Integer>> expectedResultsAfterCheckingMajority = new LinkedHashMap<>();
        expectedResultsAfterCheckingMajority.put("Sherryl Ooi", Arrays.asList(0, 3, 1, 0));
        expectedResultsAfterCheckingMajority.put("Bryan Lee", Arrays.asList(0, 0, 2, 2));
        expectedResultsAfterCheckingMajority.put("Cedric Tan", Arrays.asList(0, 1, 1, 2));

        // Create an object of rankings class and check for majority
        rankings rank = new rankings();
        rank.checkMajority(countBallot.ballotWithName);
    
        // Test that the ranking for each candidate has been determined correctly after checking for Majority
        assertEquals(expectedResultsAfterCheckingMajority, countBallot.ballotWithName);
    }
}
