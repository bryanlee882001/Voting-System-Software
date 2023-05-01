import static org.junit.Assert.*;
import org.junit.Test;

public class countBallotTest {
    
    countBallot ballot = new countBallot();
    fileSystem file = new fileSystem();


    @Test
    // This test checks that countBallot() returns the correct total ballots for CPL
    public void test1_countBallot(){        
        
        fileSystem.electionType = "CPL";
        fileSystem.numOfCandidates = 3;
        fileSystem.numOfVotes = 5;
        fileSystem.ballot = new int[][]{{1,2,3}, {1,2,3}, {2,1,3}, {2,3,1}, {3,2,1}};
        int[][] expectedBallots = new int[][]{{2,3},{2,2},{1,3}};
        assertArrayEquals(expectedBallots, countBallot.totalBallots);

    }


    @Test
    // This test checks that countBallot() returns the correct total ballots for IR 
    public void test2_countBallot(){        
        
        fileSystem.electionType = "IR";
        fileSystem.numOfCandidates = 3;
        fileSystem.numOfVotes = 5;
        fileSystem.ballot = new int[][]{{1,2,3}, {1,2,3}, {2,1,3}, {2,3,1}, {3,2,1}};        
        int[][] expectedBallots = new int[][]{{2,0,0,0},{2,2,1,0},{1,3,4,1}};
        assertArrayEquals(expectedBallots, countBallot.totalBallots);
        
    }
    

    @Test
    // This test checks that countBallot() returns invalid message when election type is invalid
    public void test3_countBallot(){        
        
        fileSystem.electionType = "Invalid";
        fileSystem.numOfCandidates = 3;
        fileSystem.numOfVotes = 5;
        fileSystem.ballot = null;         
        int[][] expectedBallots = null; 
        assertArrayEquals("This election type is not recognized", expectedBallots, countBallot.totalBallots);
        
    }

}
