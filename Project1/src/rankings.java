import javax.swing.*;
import java.lang.Math;

/**
 * The rankings program implements functions that are 
 * related to determine the ranking of the candidates/parties 
 * of the election as well as check whether there is a majority 
 * to determine the winner of the election. 
 *
 * @author Bryan Yen Sheng Lee
 * @author Cedric Tan Yee Shuen
 * @author Sherryl Ooi Shi Tyng
 * @version 1.0
 * @ since 2023-03-19
 */
public class rankings {
    
    // An array to store rankings of each candidate
    static int [] ranking;
    
    /**
     * A constructor of the rankings class that takes in no parameter
     * and counts the ballot. The rankings are then determined. 
     */
    public rankings () {
        countBallot ballotCount = new countBallot();

        // Count new ballots
        int [][] newBallots = new int [fileSystem.numOfCandidates][2];
        for(int i = 0; i < fileSystem.numOfCandidates; i++) {
            newBallots[i][1] = ballotCount.totalBallots[i][1];
        }

        // Determine candidates' rankings based on new ballots
        checkMajority(newBallots);
    }

    /**
     * A function that reads the newBallots array and determines the ranking
     * for each candidate based on number of votes
     * @param newBallots — a 2D array indicating the number of votes for each candidate
     * @param initialRank - an integer indicating the initial rank of the candidate
     * @return integer array indicating candidates' rankings 
     */
    public int [] checkRanking (int [][] newBallots, int initialRank) {

        // Check if election type is CPL
        if(fileSystem.electionType.equals("CPL")) {
            ranking = new int [fileSystem.numOfCandidates];
            int totalNumber = fileSystem.numOfCandidates; 

            // Sets the rankings of all candidates to zero
            for(int i = 0; i < totalNumber; i++) {
                ranking[i] = 0;
            }

            // Sorts the candidates based on number of votes
            for(int j = 0; j < totalNumber; j++) {
                int temp = 0;
                int max = newBallots[0][initialRank];
                for(int i = 1; i < totalNumber; i++) {
                    if (max != Math.max(max, newBallots[i][initialRank])) {
                        max = Math.max(max, newBallots[i][initialRank]);
                        temp = i;
                    }
                }
                if (max == 0) {
                    ranking[j] = -1;
                }
                else {
                    ranking[j] = temp;
                }
                newBallots[temp][initialRank] = 0;
            }

            return ranking;
        }

        // Check if election type is IR
        else if (fileSystem.electionType.equals("IR")) {
            ranking = new int [fileSystem.numOfCandidates];
            int totalNumber = fileSystem.numOfCandidates; 
            for(int i = 0; i < totalNumber; i++) {
                ranking[i] = 0;
            }

            for(int j = 0; j < totalNumber; j++) {
                int temp = 0;
                int max = newBallots[0][initialRank];
                for(int i = 1; i < totalNumber; i++) {
                    if (max != Math.max(max, newBallots[i][initialRank])) {
                        max = Math.max(max, newBallots[i][initialRank]);
                        temp = i;
                    }
                }
                if (max == 0) {
                    ranking[j] = -1;
                }
                else {
                    ranking[j] = temp;
                }
                newBallots[temp][initialRank] = 0;
            }

            return ranking;
        }

        // Displays error message if an error is detected
        else {
            JOptionPane.showMessageDialog(null,"The election type is not recognized.","ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);
        }
        return ranking;
    }

    /**
     * A function that reads the totalBallots array and check if there is a majority
     * among the candidates. 
     * @param totalBallots — a 2D array indicating the number of votes per candidate
     */
    public void checkMajority (int [][] totalBallots) {

        // Checks if election type is CPL
        if(fileSystem.electionType.equals("CPL")) {
            checkRanking(totalBallots, 1);
        }

        // Checks if election type is IR
        else if (fileSystem.electionType.equals("IR")) {
            ranking = new int [fileSystem.numOfCandidates];
            int updatedNumOfCandidates = fileSystem.numOfCandidates;
            int majority = (int) fileSystem.numOfVotes * 50 / 100;
            int [] ranks = new int [updatedNumOfCandidates];
            int temp = 1;
            int temp2;

            int [][] newBallots = new int [fileSystem.numOfCandidates][fileSystem.numOfCandidates];
            for(int i = 0; i < fileSystem.numOfCandidates; i++) {
                newBallots[i][1] = countBallot.totalBallots[i][1];
            }

            // While there is no majority 
            while(newBallots[ranks[0]][1] < majority) {
                ranks = checkRanking(newBallots, 1);

                // Redistribute votes 
                for(int i = 0; i < updatedNumOfCandidates; i++) {
                    if(newBallots[ranks[updatedNumOfCandidates]][temp] == 0) {
                        newBallots[i][1] += totalBallots[ranks[updatedNumOfCandidates]][temp+1];
                        if(temp+1 > 2) {
                            newBallots[i][1] += totalBallots[ranks[updatedNumOfCandidates]][temp+2];
                            newBallots[ranks[updatedNumOfCandidates]][temp+1] = 0;
                        }
                    }
                }

                newBallots[ranks[updatedNumOfCandidates]][temp] = 0;
                ranks[updatedNumOfCandidates] = -1;
                temp ++;
            }

            ranks = checkRanking(newBallots, 1);
            if(newBallots[ranks[0]][1] > majority) {
                for(int i = 0; i < fileSystem.numOfCandidates; i++) {
                    ranking[i] = ranks[i];
                }
            }
        }

        // Displays error message if an error is detected
        else {
            JOptionPane.showMessageDialog(null,"The election type is not recognized.","ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);
        }
    }
}
