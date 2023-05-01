import org.junit.Test;
import static org.junit.Assert.*;
import java.io.File;
import javax.swing.*;


public class displayResultsTest {
    
    displayResults results = new displayResults();

    @Test
    // This test case checks if generateAuditFile() exports an audit file
    public void test1_generateAuditFile(){

        fileSystem.electionType = "CPL";
        fileSystem.numOfCandidates = 3;
        fileSystem.allCandidates = "A, B";
        fileSystem.candidates = new String[] {"A", "B", "C"};
        fileSystem.numOfSeats = 2;
        fileSystem.numOfVotes = 5;
        rankings.ranking = new int[] {0,1,2};

        results.generateAuditFile();

        File auditFile = new File("auditFile.csv");

        // checks if auditFile exists and is working properly
        assertTrue(auditFile.exists());
        assertTrue(auditFile.isFile());
        assertTrue(auditFile.canRead());

        }


    @Test 
    // This test case checks if showResults() displays the information correctly
    public void test2_showResults(){

        fileSystem.electionType = "IR";
        fileSystem.numOfCandidates = 2;
        fileSystem.allCandidates = "A, B";
        fileSystem.candidates = new String[]{"A", "B"};
        fileSystem.numOfSeats = 1;
        fileSystem.numOfVotes = 10;
        rankings.ranking = new int[]{0,1};

        // Call showResults method
        results.showResults();

        // Check if the Final Results window is displayed
        JFrame[] new_frame = (JFrame[]) JFrame.getFrames();
        
        JFrame[] new_jFrames = new JFrame[new_frame.length];

        for (int i = 0; i < new_frame.length; i++) {
            new_jFrames[i] = (JFrame) new_frame[i];
        }

        JFrame finalResults = null;

        for (JFrame frame : new_frame) {
            if (frame.getTitle().equals("Final Results")) {
                finalResults= frame;
                break;
            }
        }

        assertNotNull(finalResults);

        // Check if the actual area of message contains the expected results
        JTextArea actualAreaOfMessage = (JTextArea) finalResults.getContentPane().getComponent(0);

        String expectedMessage = "Election type: IR\n" + "Number of Candidates: 2\n" +
                "Candidates joined election: A, B\n" +
                "Total number of voters: 10\n" +
                "1's rank is candidate A\n" +
                "2's rank is candidate B\n" +
                "The final winner of the election is candidate A\n";

        assertEquals(expectedMessage, actualAreaOfMessage.getText());
    }

    
}


