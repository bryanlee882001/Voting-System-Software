import org.junit.Test;
import static org.junit.Assert.*;

public class rankingsTest {
    
    rankings rank = new rankings();

    @Test
    // This test case checks if checkRanking() sorts each candidate based on votes
    public void test1_checkRankingsTest(){
        
        fileSystem.electionType = "CPL";
        fileSystem.numOfCandidates = 3;
        fileSystem.numOfSeats = 1;
        int initialRank = 0;

        int[][] newBallots = new int[][] {{1, 2, 3}, {2, 3, 1}, {3, 1, 2}}; 
        
        int[] expectedRank = new int[] {2,1,0};
        int[] actualRank = rank.checkRanking(newBallots, initialRank);
        
        // check if actual results matches expected results
        assertArrayEquals(expectedRank, actualRank);

    }

    @Test
    // This test case checks if checkMajority() determines the winner of the election
    public void test2_checkMajority(){
        
        int[][] totalBallots = { {10, 20, 30}, {15, 25, 20},{5, 15, 10}};
        fileSystem.electionType = "IR";
        fileSystem.numOfCandidates = 3;
        fileSystem.numOfVotes = 30;
        countBallot.totalBallots = totalBallots;

        rank.checkMajority(totalBallots);

        int[] expectedRank = new int[] {0,1,2};
        assertArrayEquals(expectedRank, rank.ranking);

    }

}
