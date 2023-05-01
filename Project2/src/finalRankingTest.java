import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

/**
 * The finalRankingTest program contains the test cases with 
 * different conditions to check whether the voting system software 
 * meets all its acceptance criteria by determining the final ranking 
 * of the candidates/parties of the election and perform check for tie 
 * and flip a coin toss if necessary to determine the winner through 
 * an unbiased method. 
 *
 * @author Bryan Yen Sheng Lee
 * @author Cedric Tan Yee Shuen
 * @author Sherryl Ooi Shi Tyng
 * @version 2.0
 * @ since 2023-03-19
 */
public class finalRankingTest {
    
    @Test
    // This test case checks if checkfortie() performs pool coin toss when election type is CPL
    public void test1_checkForTie(){
        
        fileSystem.electionType = "CPL";                                                                // set election type to IR
        fileSystem.numOfCandidates = 4;                                                                 // set number of parties to 4
        fileSystem.numOfSeats = 5;                                                                      // set number of seats to 5
        fileSystem.numOfVotes = 9;                                                                      // set number of votes to 4
        fileSystem.candidates.addAll(Arrays.asList("Democratic","Republican","Reform","Green"));   // add parties
        fileSystem.ballot.add(Arrays.asList(0,1,0,0));                                             // add 9 arbitrary ballots
        fileSystem.ballot.add(Arrays.asList(1,0,0,0));
        fileSystem.ballot.add(Arrays.asList(1,0,0,0));
        fileSystem.ballot.add(Arrays.asList(0,1,0,0));
        fileSystem.ballot.add(Arrays.asList(0,1,0,0));
        fileSystem.ballot.add(Arrays.asList(1,0,0,0));
        fileSystem.ballot.add(Arrays.asList(0,0,1,0));
        fileSystem.ballot.add(Arrays.asList(0,0,1,0));
        fileSystem.ballot.add(Arrays.asList(0,0,1,0));

        // create an object of the rankings class and count ballots for each candidate
        rankings rank = new rankings();
        rank.checkRanking(countBallot.ballotWithName); 

            // +--------------------+
            // | Results:           |
            // +--------------------+
            // | "Democratic",(6,3) |
            // | "Republican",(6,3) |
            // | "Reform",(6,3)     |
            // | "Green", (9,0)     |
            // +--------------------+

        // create an object of the finalrankings class to check for tie 
        finalRanking fr = new finalRanking();
        
        // Check if checkForTie() function was executed
        boolean CheckForTieWasRun = true;
        try { fr.checkForTie(); } catch (Exception e) { CheckForTieWasRun  = false; }
        assertTrue(CheckForTieWasRun );

        // Check if poolCoinToss() was run when more than two parties have equal votes
        boolean poolCoinTossWasRun = true;
        try { fr.poolCoinToss(3); } catch (Exception e) {  poolCoinTossWasRun = false; }
        // poolCoinToss was run because a tie exist between more than two parties 
        assertTrue(poolCoinTossWasRun);

        // Check if fairCoinToss() was not run given that poolCoinToss() was run 
        boolean fairCoinTossWasRun = false;
        try { fr.fairCoinToss(); } catch (Exception e) { fairCoinTossWasRun = true; }
        // fairCoinToss was not run because a tie exist between more than two parties 
        assertFalse(fairCoinTossWasRun);

    }


    @Test
    // This test case checks if checkfortie() performs fair coin toss when election type is IR
    public void test2_checkForTie(){
        
        fileSystem.electionType = "IR";                                                  // set election type to IR
        fileSystem.numOfCandidates = 3;                                                  // set number of candidates to 3
        fileSystem.numOfVotes = 8;                                                       // set number of votes to 4
        fileSystem.candidates.add("Cedric Tan");                                       // add first candidate 
        fileSystem.candidates.add("Bryan Lee");                                        // add second candidate 
        fileSystem.candidates.add("Sherryl Ooi");                                      // add third candidate 
        fileSystem.ballot.add(Arrays.asList(2, 1, 3));                              // add 4 arbitrary ballots with rankings
        fileSystem.ballot.add(Arrays.asList(3, 2, 1));
        fileSystem.ballot.add(Arrays.asList(3, 2, 1));                              
        fileSystem.ballot.add(Arrays.asList(3, 2, 1));
        fileSystem.ballot.add(Arrays.asList(2, 3, 1));
        fileSystem.ballot.add(Arrays.asList(3, 1, 2));                              
        fileSystem.ballot.add(Arrays.asList(3, 1, 2));
        fileSystem.ballot.add(Arrays.asList(3, 1, 2));

        // create an object of the rankings class and count ballots for each candidate
        rankings rank = new rankings();
        rank.checkRanking(countBallot.ballotWithName); 
        
            // +------------------------------+
            // | Results:                     |
            // +------------------------------+
            // | "Cedric",(0,0,2,6)           |
            // | "Bryan",(0,4,3,1)            | 
            // | "Sherryl",(0,4,3,1)          |
            // +------------------------------+

        // create an object of the finalrankings class to check for tie 
        finalRanking fr = new finalRanking();

        // Check if checkForTie() function was executed
        boolean CheckForTieWasRun = true;
        try { fr.checkForTie(); } catch (Exception e) { CheckForTieWasRun  = false; }
        assertTrue(CheckForTieWasRun);

        // Check if poolCoinToss() was not run given that there is only a tie between two parties
        boolean poolCoinTossWasRun = false;
        try { fr.poolCoinToss(3); } catch (Exception e) {  poolCoinTossWasRun = true; }
        // poolCoinToss was run because a tie exist between two parties 
        assertFalse(poolCoinTossWasRun);

        // Check if fairCoinToss() was run given that there is only a tie between two parties
        boolean fairCoinTossWasRun = true;
        try { fr.fairCoinToss(); } catch (Exception e) { fairCoinTossWasRun = false; }
        // fairCoinToss was run because a tie exist between two parties 
        assertTrue(fairCoinTossWasRun);
    }
    

    @Test
    // This test case checks if checkfortie() does not perform any toss given that there is no tie when election type is CPL
    public void test3_checkForTie(){
        
        fileSystem.electionType = "CPL";                                                                // set election type to IR
        fileSystem.numOfCandidates = 4;                                                                 // set number of parties to 4
        fileSystem.numOfSeats = 5;                                                                      // set number of seats to 5
        fileSystem.numOfVotes = 9;                                                                      // set number of votes to 4
        fileSystem.candidates.addAll(Arrays.asList("Democratic","Republican","Reform","Green"));   // add parties
        fileSystem.ballot.add(Arrays.asList(1,0,0,0));                                             // add 9 arbitrary ballots
        fileSystem.ballot.add(Arrays.asList(1,0,0,0));
        fileSystem.ballot.add(Arrays.asList(1,0,0,0));
        fileSystem.ballot.add(Arrays.asList(0,1,0,0));
        fileSystem.ballot.add(Arrays.asList(0,1,0,0));
        fileSystem.ballot.add(Arrays.asList(1,0,0,0));
        fileSystem.ballot.add(Arrays.asList(0,0,1,0));
        fileSystem.ballot.add(Arrays.asList(0,0,1,0));
        fileSystem.ballot.add(Arrays.asList(0,0,1,0));

        // create an object of the rankings class and count ballots for each candidate
        rankings rank = new rankings();
        rank.checkRanking(countBallot.ballotWithName); 

            // +--------------------+
            // | Results:           |
            // +--------------------+
            // | "Democratic",(5,4) |
            // | "Republican",(7,2) |
            // | "Reform",(6,3)     |
            // | "Green", (9,0)     |
            // +--------------------+

        // create an object of the finalrankings class to check for tie 
        finalRanking fr = new finalRanking();
        
        // Test that checkForTie() function was executed
        boolean CheckForTieWasRun = true;
        try { fr.checkForTie(); } catch (Exception e) { CheckForTieWasRun  = false; }
        assertTrue(CheckForTieWasRun );

        // Test that poolCoinToss() was not run given there is no tie
        boolean poolCoinTossWasRun = false;
        try { fr.poolCoinToss(3); } catch (Exception e) {  poolCoinTossWasRun = true; }
        assertFalse(poolCoinTossWasRun);

        // Test that fairCoinToss() was not run given there is no tie
        boolean fairCoinTossWasRun = false;
        try { fr.fairCoinToss(); } catch (Exception e) { fairCoinTossWasRun = true; }
        assertFalse(fairCoinTossWasRun);
    }


    @Test
    // This test case checks if checkfortie() does not perform any toss if election type is CPL
    public void test4_fairCoinToss(){
        
        fileSystem.electionType = "IR";                                                  // set election type to IR
        fileSystem.numOfCandidates = 3;                                                  // set number of candidates to 3
        fileSystem.numOfVotes = 8;                                                       // set number of votes to 4
        fileSystem.candidates.add("Cedric Tan");                                       // add first candidate 
        fileSystem.candidates.add("Bryan Lee");                                        // add second candidate 
        fileSystem.candidates.add("Sherryl Ooi");                                      // add third candidate 
        fileSystem.ballot.add(Arrays.asList(2, 1, 3));                              // add 4 arbitrary ballots with rankings
        fileSystem.ballot.add(Arrays.asList(3, 2, 1));
        fileSystem.ballot.add(Arrays.asList(3, 2, 1));                              
        fileSystem.ballot.add(Arrays.asList(3, 2, 1));
        fileSystem.ballot.add(Arrays.asList(2, 3, 1));
        fileSystem.ballot.add(Arrays.asList(3, 1, 2));                              
        fileSystem.ballot.add(Arrays.asList(3, 1, 2));
        fileSystem.ballot.add(Arrays.asList(3, 1, 2));

        // create an object of the rankings class and count ballots for each candidate
        rankings rank = new rankings();
        rank.checkRanking(countBallot.ballotWithName); 
        
            // +------------------------------+
            // | Results:                     |
            // +------------------------------+
            // | "Cedric",(0,0,2,6)           |
            // | "Bryan",(0,4,3,1)            | 
            // | "Sherryl",(0,4,3,1)          |
            // +------------------------------+

        // create an object of the finalrankings class to check for tie 
        finalRanking fr = new finalRanking();
        
        // Test that fairCoinToss returns a value between 0 and 1 indicating the winning party
        int result = fr.fairCoinToss();
        assertTrue(result >= 0 && result <= 1);

    }

    @Test
    // This test case checks if checkfortie() does not perform any toss if election type is CPL
    public void test5_poolCoinToss(){
        
        fileSystem.electionType = "CPL";                                                                // set election type to IR
        fileSystem.numOfCandidates = 4;                                                                 // set number of parties to 4
        fileSystem.numOfSeats = 5;                                                                      // set number of seats to 5
        fileSystem.numOfVotes = 9;                                                                      // set number of votes to 4
        fileSystem.candidates.addAll(Arrays.asList("Democratic","Republican","Reform","Green"));   // add parties
        fileSystem.ballot.add(Arrays.asList(0,1,0,0));                                             // add 9 arbitrary ballots
        fileSystem.ballot.add(Arrays.asList(1,0,0,0));
        fileSystem.ballot.add(Arrays.asList(1,0,0,0));
        fileSystem.ballot.add(Arrays.asList(0,1,0,0));
        fileSystem.ballot.add(Arrays.asList(0,1,0,0));
        fileSystem.ballot.add(Arrays.asList(1,0,0,0));
        fileSystem.ballot.add(Arrays.asList(0,0,1,0));
        fileSystem.ballot.add(Arrays.asList(0,0,1,0));
        fileSystem.ballot.add(Arrays.asList(0,0,1,0));

        // create an object of the rankings class and count ballots for each candidate
        rankings rank = new rankings();
        rank.checkRanking(countBallot.ballotWithName); 

            // +--------------------+
            // | Results:           |
            // +--------------------+
            // | "Democratic",(6,3) |
            // | "Republican",(6,3) |
            // | "Reform",(6,3)     |
            // | "Green", (9,0)     |
            // +--------------------+

        // create an object of the finalrankings class to check for tie 
        finalRanking fr = new finalRanking();

        // Test that fairCoinToss returns a value between 0 and 1 indicating the winning party
        int result = fr.poolCoinToss(3);
        assertTrue(result >= 0 && result <= 2);
    }


    
}
