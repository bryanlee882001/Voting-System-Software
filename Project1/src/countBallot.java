import javax.swing.*;

/**
 * The countBallot program implements functions that are 
 * related to counting the ballots based on election type 
 * using the information given into the voting system 
 * software through a .csv file. 
 *
 * @author Bryan Yen Sheng Lee
 * @author Cedric Tan Yee Shuen
 * @author Sherryl Ooi Shi Tyng
 * @version 1.0
 * @ since 2023-03-19
 */
public class countBallot {

    // A 2-D array that stores the count of total ballots for each candidate
    static int [][] totalBallots;

    /**
     * A constructor of the countBallot class that takes in no parameter
     * and will calculate the total number of ballots for each candidate.
     */
    public countBallot () {

        // Create fileSystem object
        fileSystem files = new fileSystem();

        // If the election type is Closed Party Listing (CPL)
        if(fileSystem.electionType.equals("CPL")) {
            totalBallots = new int[fileSystem.numOfCandidates][2];

            // Loops through number of votes and candidates to allocate ballots based on parties
            for (int i = 0; i < fileSystem.numOfVotes; i++) {
                for (int j = 0; j < fileSystem.numOfCandidates; j++) {
                    if(fileSystem.ballot[i][j] == 1) {
                        totalBallots[j][1] ++;
                    }
                    else {
                        totalBallots[j][0] ++;
                    }
                }
            }
        }

        // If the election type is Instant Runoff(IR)
        else if(fileSystem.electionType.equals("IR")){
            totalBallots = new int[fileSystem.numOfCandidates][fileSystem.numOfCandidates + 1];

            // Loops through number of votes and candidates to allocate the ballots based on the ranking of each candidate
            for (int i = 0; i < fileSystem.numOfVotes; i++) {
                for (int j = 0; j < fileSystem.numOfCandidates; j++) {
                    for (int k = 0; k <= fileSystem.numOfCandidates; k++) {
                        if(fileSystem.ballot[i][j] == k) {
                            totalBallots[j][k] ++;
                        }
                    }
                }
            }
        }

        // If the election type is neither IR nor CPL 
        else {
            JOptionPane.showMessageDialog(null,"The election type is not recognized.","ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);
        }
    }
}
